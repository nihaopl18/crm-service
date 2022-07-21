package cn.com.yusys.yusp.rai.engine.data.util;


import cn.com.yusys.yusp.rai.engine.data.constants.ExceptionCodeConstant;
import cn.com.yusys.yusp.rai.engine.data.domain.*;
import cn.com.yusys.yusp.rai.engine.data.enums.*;
import cn.com.yusys.yusp.rai.engine.data.exceptions.RuleExprErrorException;
import cn.com.yusys.yusp.rai.engine.data.exceptions.SourceDataErrorException;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * 解析数据库表达式
 * @author fangqiang
 * @email fangqiang@yusys.com.cn
 * @date 2021-03-23 17:25:48
 */
public class ParseUtil {

    public static final String VAR_PREFIX = "@";
    public static final String PAY_TRIAL_VAR_PREFIX = "#@#";
    public static final String PAY_TRIAL_PARAM_CHECK = "*";
    public static final String PAY_TRIAL_PARAM_SPLIT = "\\*";
    public static final String  POS_PREFIX = "#POS_PREFIX_";

    private static final String PATTERN = "_(\\w)";
    
    public static Pattern VAR_PATTERN = Pattern.compile("@[A-Z|a-z|0-9|_]+");
    
    public static Pattern POS_FUN_PATTERN = Pattern.compile("POS\\[[^\\[\\]]");

    public static Pattern SCORE_GEN_TYPE_PATTERN = Pattern.compile("7029000[123]");
    
    /**
     * 格式化活动表达式中信息
     * @author zhangchi
     * @date 2021年12月10日 17:35:52
     * @param activityPo 
     * @return cn.com.yusys.yusp.rai.engine.data.domain.ActivityPo 
     */
    public static void fmtActivityExpr(ActivityPo activityPo, List<FieldPo> fieldPoList, List<QuoteParamPo> quoteParamPoList) {
        Map<String, FieldPo> fieldMap = fieldPoList.stream().collect(Collectors.toMap(FieldPo::getFieldName, item -> item, (v1, v2)->v1));
        Map<String, QuoteParamPo> quoteParamMap = quoteParamPoList.stream().collect(Collectors.toMap(QuoteParamPo::getParamCode, item -> item, (v1, v2)->v1));
        activityPo.getRulePos().forEach(rulePo -> fmtRuleExpr(rulePo, fieldMap, quoteParamMap));
    }
    
    /**
     * 格式化规则表达式
     * @author zhangchi
     * @date 2021年12月10日 17:37:53
     * @param rule 
     * @return void 
     */
    private static void fmtRuleExpr(RulePo rule, Map<String, FieldPo> fieldMap, Map<String, QuoteParamPo> quoteParamMap) {
        //提取引用参数和规则变量
        fmtVariables(rule, fieldMap, quoteParamMap);

        //解析连续动作表达式
        fmtContinueActionRule(rule);

        //解析动作
        if (rule.getActionPoList() != null && rule.getActionPoList().size() > 0) {
            rule.getActionPoList().forEach(action -> fmtAction(action, fieldMap, quoteParamMap));
        }
        if (rule.getContinueActionPoList() != null && rule.getContinueActionPoList().size() > 0) {
            rule.getContinueActionPoList().forEach(action -> fmtAction(action, fieldMap, quoteParamMap));
        }
    }

    /**
     * 解析规则中变量
     * @author zhangchi
     * @date 2021年12月12日 01:30:44
     * @param rule
     * @param fieldMap
     * @param quoteParamMap
     * @return void
     */
    private static void fmtVariables(RulePo rule, Map<String, FieldPo> fieldMap, Map<String, QuoteParamPo> quoteParamMap){
        Matcher matcher = VAR_PATTERN.matcher(rule.getConditionExpress());
        while (matcher.find()) {
            String varName = matcher.group().substring(1);
            QuoteParamPo quoteParam = quoteParamMap.get(varName);
            if (null != quoteParam) {
                rule.getQuoteParamList().add(quoteParam);
            } else {
                FieldPo field = fieldMap.get(varName);
                if (null != field) {
                    rule.getFieldList().add(field);
                } else {
                    throw new RuleExprErrorException("表达式" + rule.getConditionExpress() + "中存在不能识别的变量" + varName);
                }
            }
        }
    }

    /**
     * 解析连续动作配置
     * @author zhangchi
     * @date 2021年12月12日 01:29:21
     * @param rulePo
     * @return void
     */
    public static void fmtContinueActionRule(RulePo rulePo){
        if ((rulePo.getContinueActExpress() == null || "".equals(rulePo.getContinueActExpress())) || "1=1".equals(rulePo.getContinueActExpress())) {
            return;
        }
        ContinueExpressPo continueExpressPo = new ContinueExpressPo();
        String[] ruleInfo = rulePo.getContinueActExpress().split("\\|");
        if (ruleInfo.length != 3) {
            throw new SourceDataErrorException(ExceptionCodeConstant.CONT_RULE_EXP_ERROR, "连续动作表达式配置错误" + rulePo.getContinueActExpress());
        }

        String[] countTypeInfo = ruleInfo[0].split("=");

        if (countTypeInfo.length == 1) {
            continueExpressPo.setCountType(CountTypeEnum.getByCode(countTypeInfo[0]));
        } else {
            continueExpressPo.setCountType(CountTypeEnum.getByCode(countTypeInfo[1]));
            continueExpressPo.setFieldName(countTypeInfo[0]);
        }

        String[] cycleTypeInfo = ruleInfo[1].split("=");
        CountCycleTypeEnum countCycleType = CountCycleTypeEnum.getByCode(cycleTypeInfo[0]);
        continueExpressPo.setCountCycleType(countCycleType);
        switch (countCycleType) {
            case COUNT_CYCLE_DAY:
                continueExpressPo.setDays(Long.valueOf(cycleTypeInfo[1]));
                break;
            case COUNT_CYCLE_STATIC:
                String[] dayInfo = cycleTypeInfo[1].split("#@#");
                continueExpressPo.setBeginDate(dayInfo[0]);
                continueExpressPo.setEndDate(dayInfo[1]);
                break;
            default:
                break;
        }

        String[] compareInfo = ruleInfo[2].split("=");
        continueExpressPo.setContActionStore(ContActionStoreTypeEnum.getByCode(compareInfo[0]));
        continueExpressPo.setCompareValue(compareInfo[1]);
        rulePo.setContinueExpressPo(continueExpressPo);
    }

    /**
     * 格式化动作
     * @author zhangchi
     * @date 2021年12月13日 10:31:27
     * @param
     * @return void
     */
    private static void fmtAction(ActionPo action, Map<String, FieldPo> fieldMap, Map<String, QuoteParamPo> quoteParamMap) {
        CalcTypeEnum calcTypeEnum = CalcTypeEnum.getByCode(action.getCalcWay());
        action.setCalcTypeEnum(calcTypeEnum);
        if (CalcTypeEnum.STATIC_VALUE.equals(calcTypeEnum)) {
            return;
        }
        parseActionVariables(action, fieldMap, quoteParamMap);
        if (CalcTypeEnum.SECTION.equals(calcTypeEnum)) {
            Matcher matcher = SCORE_GEN_TYPE_PATTERN.matcher(action.getCalcExprDesc());
           if (matcher.find()) {
               action.setScoreGenType(ScoreGenTypeEnum.getByCode(matcher.group()));
           }
           if (action.getScoreGenType() != null) {
                String calcExpr = action.getCalcExpr().replaceAll("IF\\[", "").replaceAll("\\]", "");
               String[] sections;
               List<String[]> sectionList;
               switch (action.getScoreGenType()) {
                    case STATIC_VAL:
                    case SCALE:
                        sections = calcExpr.split(";");
                        sectionList = Arrays.stream(sections).filter(item -> !item.equals("0")).map(item -> item.split(":")).collect(Collectors.toList());
                        action.setSections(sectionList);
                        break;
                    case EVERY:
                        calcExpr = calcExpr.substring(0,calcExpr.indexOf("*")+1);
                        sections = calcExpr.split(";");
                        sectionList = Arrays.stream(sections).filter(item -> !item.equals("0"))
                                .map(item -> {
                                    String[] section = new String[3];
                                    String[] exprVals = item.split(":");
                                    section[0] = exprVals[0];
                                    section[1] = exprVals[1];
                                    section[2] = exprVals[0].substring(exprVals[0].indexOf("=")+1);
                                    return section;
                                })
                                .collect(Collectors.toList());
                        action.setSections(sectionList);
                        break;
                   default:
                       break;
                }
           }
        }
    }

    /**
     * 解析函数中的变量
     * @author zhangchi
     * @date 2021年12月12日 01:30:01
     * @param action
     * @param fieldMap
     * @param quoteParamMap
     * @return void
     */
    public static void parseActionVariables(ActionPo action, Map<String, FieldPo> fieldMap, Map<String, QuoteParamPo> quoteParamMap){
        Matcher matcher = VAR_PATTERN.matcher(action.getCalcExpr());
        while (matcher.find()) {
            String varName = matcher.group().substring(1);
            QuoteParamPo quoteParam = quoteParamMap.get(varName);
            if (null != quoteParam) {
                action.getQuoteParamList().add(quoteParam);
            } else {
                FieldPo field = fieldMap.get(varName);
                if (null != field) {
                    action.getFieldList().add(field);
                } else {
                    throw new RuleExprErrorException("表达式" + action.getCalcExpr() + "中存在不能识别的变量" + varName);
                }
            }
        }
    }

    /**
     * 补全引用参数的redis key
     * @author zhangchi
     * @date 2021年12月08日 18:11:39
     * @param key
     * @param transData
     * @return java.lang.String
     */
    public static String completeQuoteParamRedisKey(String key, Map<String, Object> transData){
        Matcher matcher = VAR_PATTERN.matcher(key);
        while (matcher.find()) {
            String varName = matcher.group();
            String code = nameToCode(varName.substring(1));
            key = key.replaceAll(varName, transData.get(code) != null ? transData.get(code).toString() : "");
        }
        return key;
    }

    /**
     * 变量名转小驼峰
     * @author zhangchi
     * @date 2021年12月09日 09:53:37
     * @param name
     * @return java.lang.String
     */
    public static String nameToCode (String name) {
        Pattern pattern = Pattern.compile(PATTERN);
        name = name.toLowerCase();
        Matcher matcher = pattern.matcher(name);
        StringBuffer sb = new StringBuffer();
        while(matcher.find()){
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    /**
     * 将普通的字符串转换为SQL字符串，字符串开始结束都加单引号，字符串中的单引号换成2个单引号
     *
     * @param originString 原始的字符串
     * @return SQL字符串
     */
    public static synchronized String getQuotedString(String originString) {
        String result = null;
        if (originString != null) {
            StringBuilder builder = new StringBuilder();
            builder.append('\'');
            int length = originString.length();
            for (int i = 0; i < length; i++) {
                char c = originString.charAt(i);
                if (c == '\'') {
                    builder.append("''");
                } else {
                    builder.append(c);
                }
            }
            builder.append('\'');
            result = builder.toString();
        }
        return result;
    }

    /**
     * 截断异常消息，避免效果超长
     * @author zhangchi
     * @date 2021年12月09日 19:00:38
     * @param message
     * @return java.lang.String
     */
    public static String subErrorMsg(String  message) {
        return message != null && message.length() > 500 ?  message.substring(0, 500) : message;
    }
}

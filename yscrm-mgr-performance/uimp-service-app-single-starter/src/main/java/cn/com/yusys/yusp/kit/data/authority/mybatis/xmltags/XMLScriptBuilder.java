package cn.com.yusys.yusp.kit.data.authority.mybatis.xmltags;

import org.apache.ibatis.builder.BaseBuilder;
import org.apache.ibatis.builder.BuilderException;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.parsing.XNode;
import org.apache.ibatis.scripting.defaults.RawSqlSource;
import org.apache.ibatis.scripting.xmltags.ChooseSqlNode;
import org.apache.ibatis.scripting.xmltags.DynamicSqlSource;
import org.apache.ibatis.scripting.xmltags.ForEachSqlNode;
import org.apache.ibatis.scripting.xmltags.IfSqlNode;
import org.apache.ibatis.scripting.xmltags.MixedSqlNode;
import org.apache.ibatis.scripting.xmltags.SetSqlNode;
import org.apache.ibatis.scripting.xmltags.SqlNode;
import org.apache.ibatis.scripting.xmltags.StaticTextSqlNode;
import org.apache.ibatis.scripting.xmltags.TextSqlNode;
import org.apache.ibatis.scripting.xmltags.TrimSqlNode;
import org.apache.ibatis.scripting.xmltags.VarDeclSqlNode;
import org.apache.ibatis.scripting.xmltags.WhereSqlNode;
import org.apache.ibatis.session.Configuration;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * {@code Mybatis}启动时，XML文件中SQL语句处理，该类主要扩展了自定义的占位符在启动时转换成{@code Mybatis}本身$的处理,
 * 因为{@code Mybatis}对应处理类{@link org.apache.ibatis.scripting.xmltags.XMLScriptBuilder}的结构，导致需要全部复制
 * 该类中所有对象信息后才可做对应的处理
 * @author tangxb
 * @since 2.4.1
 * @see org.apache.ibatis.scripting.xmltags.XMLScriptBuilder
 */
public class XMLScriptBuilder extends BaseBuilder {

    private final static Pattern CUSTOMIZED_PLACEHOLDER_PATTERN = Pattern.compile(":\\{");

    private final XNode context;
    private boolean isDynamic;
    private final Class<?> parameterType;
    private final Map<String, NodeHandler> nodeHandlerMap = new HashMap<String, NodeHandler>();


    public XMLScriptBuilder(Configuration configuration, XNode context) {
        this(configuration, context, null);
    }

    public XMLScriptBuilder(Configuration configuration, XNode context, Class<?> parameterType) {
        super(configuration);
        this.context = context;
        this.parameterType = parameterType;
        initNodeHandlerMap();
    }

    private void initNodeHandlerMap() {
        nodeHandlerMap.put("trim", new TrimHandler());
        nodeHandlerMap.put("where", new WhereHandler());
        nodeHandlerMap.put("set", new SetHandler());
        nodeHandlerMap.put("foreach", new ForEachHandler());
        nodeHandlerMap.put("if", new IfHandler());
        nodeHandlerMap.put("choose", new ChooseHandler());
        nodeHandlerMap.put("when", new IfHandler());
        nodeHandlerMap.put("otherwise", new OtherwiseHandler());
        nodeHandlerMap.put("bind", new BindHandler());
    }

    public SqlSource parseScriptNode() {
        MixedSqlNode rootSqlNode = parseDynamicTags(context);
        SqlSource sqlSource = null;
        if (isDynamic) {
            sqlSource = new DynamicSqlSource(configuration, rootSqlNode);
        } else {
            sqlSource = new RawSqlSource(configuration, rootSqlNode, parameterType);
        }
        return sqlSource;
    }

    protected MixedSqlNode parseDynamicTags(XNode node) {
        List<SqlNode> contents = new ArrayList<SqlNode>();
        NodeList children = node.getNode().getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            XNode child = node.newXNode(children.item(i));
                if (child.getNode().getNodeType() == Node.CDATA_SECTION_NODE || child.getNode().getNodeType() == Node.TEXT_NODE) {
                    // 自定义暂未付替换处理
                    String data = replaceCustomizedPlaceholder(child.getStringBody(""));
                    TextSqlNode textSqlNode = new TextSqlNode(data);
                    if (textSqlNode.isDynamic()) {
                        contents.add(textSqlNode);
                        isDynamic = true;
                    } else {
                        contents.add(new StaticTextSqlNode(data));
                    }
                } else if (child.getNode().getNodeType() == Node.ELEMENT_NODE) { // issue #628
                    String nodeName = child.getNode().getNodeName();
                    NodeHandler handler = nodeHandlerMap.get(nodeName);
                    if (handler == null) {
                        throw new BuilderException("Unknown element <" + nodeName + "> in SQL statement.");
                    }
                    handler.handleNode(child, contents);
                    isDynamic = true;
                }
        }
        return new MixedSqlNode(contents);
    }

    private interface NodeHandler {
        void handleNode(XNode nodeToHandle, List<SqlNode> targetContents);
    }

    private class BindHandler implements NodeHandler {
        public BindHandler() { }

        @Override
        public void handleNode(XNode nodeToHandle, List<SqlNode> targetContents) {
            final String name = nodeToHandle.getStringAttribute("name");
            final String expression = nodeToHandle.getStringAttribute("value");
            final VarDeclSqlNode node = new VarDeclSqlNode(name, expression);
            targetContents.add(node);
        }
    }

    private class TrimHandler implements NodeHandler {
        public TrimHandler() { }

        @Override
        public void handleNode(XNode nodeToHandle, List<SqlNode> targetContents) {
            MixedSqlNode mixedSqlNode = parseDynamicTags(nodeToHandle);
            String prefix = nodeToHandle.getStringAttribute("prefix");
            String prefixOverrides = nodeToHandle.getStringAttribute("prefixOverrides");
            String suffix = nodeToHandle.getStringAttribute("suffix");
            String suffixOverrides = nodeToHandle.getStringAttribute("suffixOverrides");
            TrimSqlNode trim = new TrimSqlNode(configuration, mixedSqlNode, prefix, prefixOverrides, suffix, suffixOverrides);
            targetContents.add(trim);
        }
    }

    private class WhereHandler implements NodeHandler {
        public WhereHandler() { }

        @Override
        public void handleNode(XNode nodeToHandle, List<SqlNode> targetContents) {
            MixedSqlNode mixedSqlNode = parseDynamicTags(nodeToHandle);
            WhereSqlNode where = new WhereSqlNode(configuration, mixedSqlNode);
            targetContents.add(where);
        }
    }

    private class SetHandler implements NodeHandler {
        public SetHandler() { }

        @Override
        public void handleNode(XNode nodeToHandle, List<SqlNode> targetContents) {
            MixedSqlNode mixedSqlNode = parseDynamicTags(nodeToHandle);
            SetSqlNode set = new SetSqlNode(configuration, mixedSqlNode);
            targetContents.add(set);
        }
    }

    private class ForEachHandler implements NodeHandler {
        public ForEachHandler() { }

        @Override
        public void handleNode(XNode nodeToHandle, List<SqlNode> targetContents) {
            MixedSqlNode mixedSqlNode = parseDynamicTags(nodeToHandle);
            String collection = nodeToHandle.getStringAttribute("collection");
            String item = nodeToHandle.getStringAttribute("item");
            String index = nodeToHandle.getStringAttribute("index");
            String open = nodeToHandle.getStringAttribute("open");
            String close = nodeToHandle.getStringAttribute("close");
            String separator = nodeToHandle.getStringAttribute("separator");
            ForEachSqlNode forEachSqlNode = new ForEachSqlNode(configuration, mixedSqlNode, collection, index, item, open, close, separator);
            targetContents.add(forEachSqlNode);
        }
    }

    private class IfHandler implements NodeHandler {
        public IfHandler() { }

        @Override
        public void handleNode(XNode nodeToHandle, List<SqlNode> targetContents) {
            MixedSqlNode mixedSqlNode = parseDynamicTags(nodeToHandle);
            String test = nodeToHandle.getStringAttribute("test");
            IfSqlNode ifSqlNode = new IfSqlNode(mixedSqlNode, test);
            targetContents.add(ifSqlNode);
        }
    }

    private class OtherwiseHandler implements NodeHandler {
        public OtherwiseHandler() { }

        @Override
        public void handleNode(XNode nodeToHandle, List<SqlNode> targetContents) {
            MixedSqlNode mixedSqlNode = parseDynamicTags(nodeToHandle);
            targetContents.add(mixedSqlNode);
        }
    }

    private class ChooseHandler implements NodeHandler {
        public ChooseHandler() { }

        @Override
        public void handleNode(XNode nodeToHandle, List<SqlNode> targetContents) {
            List<SqlNode> whenSqlNodes = new ArrayList<SqlNode>();
            List<SqlNode> otherwiseSqlNodes = new ArrayList<SqlNode>();
            handleWhenOtherwiseNodes(nodeToHandle, whenSqlNodes, otherwiseSqlNodes);
            SqlNode defaultSqlNode = getDefaultSqlNode(otherwiseSqlNodes);
            ChooseSqlNode chooseSqlNode = new ChooseSqlNode(whenSqlNodes, defaultSqlNode);
            targetContents.add(chooseSqlNode);
        }

        private void handleWhenOtherwiseNodes(XNode chooseSqlNode, List<SqlNode> ifSqlNodes, List<SqlNode> defaultSqlNodes) {
            List<XNode> children = chooseSqlNode.getChildren();
            for (XNode child : children) {
                String nodeName = child.getNode().getNodeName();
                NodeHandler handler = nodeHandlerMap.get(nodeName);
                if (handler instanceof IfHandler) {
                    handler.handleNode(child, ifSqlNodes);
                } else if (handler instanceof OtherwiseHandler) {
                    handler.handleNode(child, defaultSqlNodes);
                }
            }
        }

        private SqlNode getDefaultSqlNode(List<SqlNode> defaultSqlNodes) {
            SqlNode defaultSqlNode = null;
            if (defaultSqlNodes.size() == 1) {
                defaultSqlNode = defaultSqlNodes.get(0);
            } else if (defaultSqlNodes.size() > 1) {
                throw new BuilderException("Too many default (otherwise) elements in choose statement.");
            }
            return defaultSqlNode;
          }
    }

    /**
     * 将自定义占位符替换成{@code Mybatis}本身的占位符
     * @param sql
     * @return
     */
    private static String replaceCustomizedPlaceholder(String sql) {
        Matcher matcher = CUSTOMIZED_PLACEHOLDER_PATTERN.matcher(sql);
        if (matcher.find()) {
            sql = matcher.replaceAll("\\$\\{");
        }
        return sql;
    }
}

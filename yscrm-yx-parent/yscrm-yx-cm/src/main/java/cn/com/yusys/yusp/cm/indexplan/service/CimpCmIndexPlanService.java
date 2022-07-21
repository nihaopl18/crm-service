package cn.com.yusys.yusp.cm.indexplan.service;

import cn.com.yusys.yusp.admin.domain.AdminSmOrg;
import cn.com.yusys.yusp.admin.domain.AdminSmUser;
import cn.com.yusys.yusp.admin.service.SystemUtilService;
import cn.com.yusys.yusp.cm.indexplan.domain.*;
import cn.com.yusys.yusp.cm.indexplan.repository.mapper.CimpCmIndexPlanMapper;
import cn.com.yusys.yusp.cm.market.domain.CimpCmAsseminfo;
import cn.com.yusys.yusp.cm.market.vo.OrgIndexRemainVo;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.security.SecurityUtils;
import cn.com.yusys.yusp.commons.service.CommonService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 营销成效策划指标
 *
 * @author zhanghan3 20181120
 */
@Service
public class CimpCmIndexPlanService extends CommonService {

    @Autowired
    private CimpCmIndexPlanMapper indexPlanMapper;
    @Autowired
    private SystemUtilService service;

    @Override
    protected CommonMapper<?> getMapper() {
        // TODO 自动生成的方法存根
        return this.indexPlanMapper;
    }

    private Set<String> orgCodeSet = new HashSet<>();

    // 查询动态生成表头数据
    public List<Map<String, Object>> getTitle(String nodeId) {
        String prdId = "";
        List<Map<String, Object>> list = new ArrayList<>();
        String proId = indexPlanMapper.proQuery(nodeId);//查询表单输出值
        if (proId != null && !proId.equals("")) {
            proId = proId.replaceAll(",", "','");
            proId = "'" + proId + "'";
            list = indexPlanMapper.getProductList(proId);//查询产品信息
            List<Map<String, Object>> list2 = new ArrayList<>();
            list2 = indexPlanMapper.getIndexList(proId);//从产品营销成效指标归属表--查询指标列表
            for (int i = 0; i < list.size(); i++) {
                String productId = (String) list.get(i).get("productId");
                List<Map<String, Object>> list3 = new ArrayList<>();
                for (int s = 0; s < list2.size(); s++) {
                    String productId2 = (String) list2.get(s).get("productId");
                    if (productId.equals(productId2)) {
                        list3.add(list2.get(s));
                        list.get(i).put("index", list3);
                    }
                }
            }
        }
        return list;
    }

//	// 查询动态生成表头数据
//	public List<Map<String, Object>> targetQuery(List<Map<String, Object>> ids, String nodeId) {
//		String sql = "";
//		String a = "";
//		String b = "";
//		String c = "";
//		String d = "";
//		int s = 1;
//		for (int i = 0; i < ids.size(); i++) {
//			Map map = ids.get(i);
//			String productId = (String) map.get("productId");
//			String productId2 = "";
//			Pattern pattern = Pattern.compile("^[_][A-Za-z]");
//			Pattern pattern2 = Pattern.compile("[A-Za-z]");
//			char[] pro = productId.toCharArray();
//			for (int j = 0; j < pro.length-1; j++) {
//				String p1 = String.valueOf(pro[j])+String.valueOf(pro[j+1]);
//
//				Matcher isNum = pattern.matcher(p1 +"");
//				if (isNum.matches()) {
//					if(j==0) {
//						productId2 = "_" + p1;
//					} else {
//						productId2 = productId2+"_" + String.valueOf(pro[j+1]);
//					}
//				} else {
//					if(j==0) {
//						productId2 = p1;
//					} else {
//						productId2 = productId2+String.valueOf(pro[j+1]);
//					}
//				}
//			}
//			Matcher pIsNum = pattern2.matcher(productId2.charAt(0) + "");
//			if (pIsNum.matches()) {
//				productId2 = "_" + productId2;
//			}
//			productId2 = productId2.toLowerCase();
//			String targetId = (String) map.get("targetId");
//			String targetId2 = "";
//			char[] tar = targetId.toCharArray();
//			for (int j = 0; j < tar.length-1; j++) {
//				String p1 = String.valueOf(tar[j])+String.valueOf(tar[j+1]);
//				Matcher isNum = pattern.matcher(p1 +"");
//				if (isNum.matches()) {
//					if(j==0) {
//						targetId2 = "_" + p1;
//					} else {
//						targetId2 = targetId2 + "_" + String.valueOf(tar[j+1]);
//					}
//				} else {
//					if(j==0) {
//						targetId2 = p1;
//					} else {
//						targetId2 = targetId2 + String.valueOf(tar[j+1]);
//					}
//				}
//			}
//			Matcher isNum2 = pattern2.matcher(targetId2.charAt(0) + "");
//			if (isNum2.matches()) {
//				targetId2 = "_" + targetId2;
//			}
//			targetId2 = targetId2.toLowerCase();
//			String initialV = "STA_" + productId2 + "_" + targetId2;
//			String targetV = "TAR_" + productId2 + "_" + targetId2;
//			if (i == 0) {
//				sql = "select t1.obj_type,t1.obj_id, t1.initial_value as " + initialV + ",t1.target_value as "
//						+ targetV;
//				b = " from CIMP_CM_ASSEMBLY_ANALYSIS t1 ";
//				d = " where t1.PRODUCT_ID ='" + productId + "' and t1.INDEX_ID ='" + targetId + "' and t1.NOD_ID='"
//						+ nodeId + "'";
//				s++;
//			} else {
//				a = a + ",t" + s + "." + initialV + ", t" + s + "." + targetV;
//				c = c + " left join (select obj_type,obj_id,initial_value as " + initialV + ",target_value as "
//						+ targetV + " " + "from CIMP_CM_ASSEMBLY_ANALYSIS where PRODUCT_ID='" + productId
//						+ "' and INDEX_ID = '" + targetId + "' and NOD_ID='" + nodeId + "') t" + s
//						+ " on t1.obj_type = t" + s + ".obj_type and t1.obj_id = " + "t" + s + ".obj_id";
//				s++;
//			}
//		}
//		sql = sql + a + b + c + d;
//		QueryModel model = new QueryModel();
//		PageHelper.startPage(model.getPage(), model.getSize());
//		return indexPlanMapper.targetQuery(sql);
//	}

    public IndexPlanReturnDto targetQuery(String nodeId) {
        //查询出该节点下所有数据
        List<CimpCmAssemblyAnalysis> cimpCmAssemblyAnalysis = indexPlanMapper.targetQuery(nodeId);
        return assembleIndex(cimpCmAssemblyAnalysis);
    }

    // //保存分发数据
    // public int saveAssembly(List<Map<String, Object>> ids) {
    // String sql="";
    // for(int i = 0;i<ids.size();i++) {
    //
    // }
    // indexPlanMapper.saveAssembly(sql);
    // return 0 ;
    // }
    // 保存分发数据
    public int add(CimpCmAssemblyAnalysis ccaa) {
        if (this.insertSelective(getMapper(), ccaa) != 1) {
            return 0;
        }
        return 1;

    }

    public void deleteAssembly(String nodId) {
        indexPlanMapper.deleteAssembly(nodId);
    }

    // 查询流程中指标
    public List<Map<String, Object>> getAssembly(String nodeId, QueryModel model) {
        PageHelper.startPage(model.getPage(), model.getSize());
        return indexPlanMapper.getAssembly(nodeId);
    }

    // 查询流程中渠道
    public List<Map<String, Object>> custQuery(String flowId, QueryModel model) {
        // TODO Auto-generated method stub
        // List<Map<String, Object>> list = indexPlanMapper.getAssembly(nodeId);
        PageHelper.startPage(model.getPage(), model.getSize());
        return indexPlanMapper.getAssembly(flowId);
    }

    // 查询流程中产品
    public List<Map<String, Object>> proQuery(String flowId) {
        String productId = indexPlanMapper.proQuery(flowId);
        if (productId != null && !productId.equals("")) {
            productId = productId.replaceAll(",", "','");
            productId = "'" + productId + "'";
            // List<Map<String, Object>> list = indexPlanMapper.getProduct(productId);
            QueryModel model = new QueryModel();
            PageHelper.startPage(model.getPage(), model.getSize());
            return indexPlanMapper.getProduct(productId);
        } else {
            return null;
        }
    }

    // 查询流程中渠道
    public List<Map<String, Object>> chaQuery(String flowId, QueryModel model) {
        PageHelper.startPage(model.getPage(), model.getSize());
        return indexPlanMapper.chaQuery(flowId);
    }

    public List<Map<String, Object>> proIndexList(String nodeId) {
        // TODO Auto-generated method stub
        String proId = indexPlanMapper.proQuery(nodeId);
        proId = proId.replaceAll(",", "','");
        proId = "'" + proId + "'";
        return indexPlanMapper.getProductList(proId);
    }

    public List<Map<String, Object>> orgQuery() {
        // TODO Auto-generated method stub
        return indexPlanMapper.orgQuery();
    }

    public List<Map<String, Object>> customerquery(QueryModel model) {
        PageHelper.startPage(model.getPage(), model.getSize());
        return indexPlanMapper.customerquery(model);
    }

    public List<Map<String, Object>> customerByLoginCode(String customerLogCode) {
        // TODO Auto-generated method stub
        return indexPlanMapper.customerByLoginCode(customerLogCode);
    }

    public List<OrgIndexRemainVo> indexRemainQuery(ObjectInfo objectInfo) {
        //返回营销成效指标的NodeId
        String nodeId = indexPlanMapper.selectNodeId(objectInfo.getTempId());
        //查询该nodeId下有几个objId
        Set<String> objIdSet = indexPlanMapper.selectObjIdBynodeId(nodeId);
        List<String> objIdListTemp = new ArrayList<>(objIdSet);

        //机构、客户经理、渠道的objId
        ObjectInfoListDto objectInfoListDto = objIdListQuery(objectInfo);
        List<String> objIdList = objectInfoListDto.getObjIdList();
        String createOrg = indexPlanMapper.selectCreateOrg(objectInfo.getTempId());
        //当前登陆的机构是创建活动的机构 则可查询出机构
        if (objectInfo.getOrgId().equals(createOrg)) {
            List<CimpCmAsseminfo> cimpCmAsseminfoList = indexPlanMapper.selectChannel(objectInfo);
            if (cimpCmAsseminfoList.size() > 0) {
                for (CimpCmAsseminfo cimpCmAsseminfo : cimpCmAsseminfoList) {
                    ObjectInfoDto objectInfoTemp = new ObjectInfoDto();
                    objectInfoTemp.setObjType("03");
                    objectInfoTemp.setObjName(cimpCmAsseminfo.getAssemblyName());
                    objectInfoTemp.setObjId(cimpCmAsseminfo.getAssemblyId());
                    objectInfoListDto.getObjectInfoDtoList().add(objectInfoTemp);
                    objIdList.add(cimpCmAsseminfo.getAssemblyId());
                }
            }
        }
        //去除机构等级高于此机构的objId
        for (String s : objIdListTemp) {
            if (!objIdList.contains(s)) {
                objIdSet.remove(s);
            }
        }
        //查询当前机构剩余指标
        List<CimpCmAssemblyAnalysis> orgAnalysisList = indexPlanMapper.selectOrgIndex(nodeId, objectInfo.getOrgId());
        IndexPlanReturnDto orgIndexPlanReturnDto = new IndexPlanReturnDto();
        if (orgAnalysisList.size() > 0) {
            orgIndexPlanReturnDto = assembleIndex(orgAnalysisList);
        }
        //移除当前机构orgId
        objIdSet.remove(objectInfo.getOrgId());
        //未给下面的机构或者客户经理分配任务
        if (objIdSet.size() <= 0) {
            if (orgAnalysisList.size() > 0) {
                List<OrgIndexRemainVo> OrgIndexRemainVoList = new ArrayList<>();
                for (CimpCmAssemblyAnalysis orgAnalysis : orgAnalysisList) {
                    OrgIndexRemainVo orgIndexRemainVo = new OrgIndexRemainVo();
                    BigDecimal indexRemain = new BigDecimal(0);
                    //先计算出机构的指标剩余值
                    if (orgAnalysis.getTargetValue() == null) {//未给该机构分配指标目标值

                    } else if (orgAnalysis.getInitialValue() == null) {
                        indexRemain = orgAnalysis.getTargetValue().subtract(new BigDecimal(0));
                    } else if (orgAnalysis.getTargetValue() != null && orgAnalysis.getInitialValue() != null) {
                        indexRemain = orgAnalysis.getTargetValue().subtract(orgAnalysis.getInitialValue());
                    }

                    orgIndexRemainVo.setIndexRemain(indexRemain);
                    orgIndexRemainVo.setSort(orgAnalysis.getSort());
                    orgIndexRemainVo.setIndexId(orgAnalysis.getIndexId());
                    orgIndexRemainVo.setIndexName(orgAnalysis.getIndexName());
                    orgIndexRemainVo.setNodeId(nodeId);
                    OrgIndexRemainVoList.add(orgIndexRemainVo);
                }
                return OrgIndexRemainVoList;
            } else {
                return null;
            }
        }
        //给下属机构和客户经理分配了指标,查询出所有object指标
        List<CimpCmAssemblyAnalysis> cimpCmAssemblyAnalysisList = indexPlanMapper.selectTotalIndex(objIdSet, nodeId);
        IndexPlanReturnDto indexPlanReturnDto = assembleIndex(cimpCmAssemblyAnalysisList);
        List<OrgIndexRemainVo> OrgIndexRemainVoList = new ArrayList<>();
        List<indexDataDto> indexDataDto = indexPlanReturnDto.getIndexDataDto();
        if (orgAnalysisList.size() > 0) {
            for (CimpCmAssemblyAnalysis orgAnalysis : orgAnalysisList) {
                OrgIndexRemainVo orgIndexRemainVo = new OrgIndexRemainVo();
                BigDecimal indexRemain = new BigDecimal(0);
                //先计算出机构的指标剩余值
                if (orgAnalysis.getTargetValue() == null) {
                    //continue;
                } else if (orgAnalysis.getInitialValue() == null) {
                    indexRemain = orgAnalysis.getTargetValue().subtract(new BigDecimal(0));
                } else if (orgAnalysis.getTargetValue() != null && orgAnalysis.getInitialValue() != null) {
                    indexRemain = orgAnalysis.getTargetValue().subtract(orgAnalysis.getInitialValue());
                }
                //减去子机构分配的指标
                for (CimpCmAssemblyAnalysis objAnalysis : cimpCmAssemblyAnalysisList) {
                    if (orgAnalysis.getSort().equals(objAnalysis.getSort())) {
                        if (objAnalysis.getTargetValue() == null) {
                            //continue;
                        } else if (objAnalysis.getInitialValue() == null) {
                            indexRemain = indexRemain.subtract(objAnalysis.getTargetValue().subtract(new BigDecimal(0)));
                        } else if (objAnalysis.getTargetValue() != null && objAnalysis.getInitialValue() != null) {
                            indexRemain = indexRemain.subtract(objAnalysis.getTargetValue().subtract(objAnalysis.getInitialValue()));
                        }
                    }
                }
                orgIndexRemainVo.setIndexRemain(indexRemain);
                orgIndexRemainVo.setSort(orgAnalysis.getSort());
                orgIndexRemainVo.setIndexId(orgAnalysis.getIndexId());
                orgIndexRemainVo.setIndexName(orgAnalysis.getIndexName());
                orgIndexRemainVo.setNodeId(nodeId);
                OrgIndexRemainVoList.add(orgIndexRemainVo);
            }
        } else {//没有给该机构分配指标则设置为0
            for (indexDataDto dataDto : indexDataDto) {
                OrgIndexRemainVo orgIndexRemainVo = new OrgIndexRemainVo();
                BigDecimal indexRemain = new BigDecimal(0);
                orgIndexRemainVo.setIndexRemain(indexRemain);
                orgIndexRemainVo.setSort(dataDto.getSort());
                orgIndexRemainVo.setIndexId(dataDto.getIndexId());
                orgIndexRemainVo.setIndexName(dataDto.getIndexName());
                orgIndexRemainVo.setNodeId(nodeId);
                OrgIndexRemainVoList.add(orgIndexRemainVo);
            }
        }
        return OrgIndexRemainVoList;
    }

    public IndexPlanReturnDto indexDistributionQuery(ObjectInfo objectInfo) {
        //返回营销成效指标的nodeId
        String nodeId = indexPlanMapper.selectNodeId(objectInfo.getTempId());
        //查询出已经分配的指标并组装好，查询出几个指标
        IndexPlanReturnDto indexPlanReturnDto = assembleIndex(indexPlanMapper.targetQuery(nodeId));
//		int sortSize = indexPlanReturnDto.getIndexDataDto().size();
        List<indexDataDto> indexDataDtoList = indexPlanReturnDto.getIndexDataDto();
        if (objectInfo.getObjType().equals("01")) {//客户经理
            //查询当前机构的客户经理
            List<AdminSmUser> adminSmUsers = indexPlanMapper.selectCustomerMgrIdOfOrg(objectInfo);
            int size = adminSmUsers.size();
            //获取客户经理的ORG_ID
            List<String> customerMgrList = new ArrayList<>();
            if (adminSmUsers.size() > 0) {
                for (AdminSmUser adminSmUser : adminSmUsers) {
                    customerMgrList.add(adminSmUser.getLoginCode());
                }
                return objindexPlanReturn(nodeId, customerMgrList, objectInfo, indexPlanReturnDto);
            }
            return null;
        } else if (objectInfo.getObjType().equals("02")) {//机构
            //查询出当前机构的所有子机构
            List<Map<String, Object>> orgList = service.getOrgByParam(objectInfo.getOrgId(), "", false);
            List<String> orgCodeList = new ArrayList<>();
            for (Map<String, Object> stringObjectMap : orgList) {
                orgCodeList.add((String) stringObjectMap.get("orgCode"));
            }
            //移除当前机构,不能给当前机构分配指标
            orgCodeList.remove(objectInfo.getOrgId());
            if (StringUtils.isEmpty(objectInfo.getObjName())) {//全量查询
                return objindexPlanReturn(nodeId, orgCodeList, objectInfo, indexPlanReturnDto);
            } else {//对象名称模糊查询
                //根据objName模糊查询出orgID
                List<AdminSmOrg> adminSmOrgList = indexPlanMapper.fuzzSelectOrgId(objectInfo.getObjName(), orgCodeList);
                if (adminSmOrgList.size() > 0) {
                    List<String> orgIdList = new ArrayList<>();
                    for (AdminSmOrg adminSmOrg : adminSmOrgList) {
                        orgIdList.add(adminSmOrg.getOrgCode());
                    }
                    return objindexPlanReturn(nodeId, orgIdList, objectInfo, indexPlanReturnDto);
                } else {
                    return null;
                }
            }
        } else if (objectInfo.getObjType().equals("03")) {//渠道
            List<String> channelIdList = new ArrayList<>();
            String createOrg = indexPlanMapper.selectCreateOrg(objectInfo.getTempId());
            //当前登陆机构等于活动创建机构
            if (objectInfo.getOrgId().equals(createOrg)) {
                //查询出所有渠道
                List<CimpCmAsseminfo> cimpCmAsseminfoList = indexPlanMapper.selectChannel(objectInfo);
                if (cimpCmAsseminfoList.size() > 0) {
                    for (CimpCmAsseminfo cimpCmAsseminfo : cimpCmAsseminfoList) {
                        channelIdList.add(cimpCmAsseminfo.getAssemblyId());
                    }
                }
                return objindexPlanReturn(nodeId, channelIdList, objectInfo, indexPlanReturnDto);
            }
            return null;
        }
        return null;
    }

    public IndexPlanReturnDto objindexPlanReturn(String nodeId, List<String> objIdList, ObjectInfo objectInfo, IndexPlanReturnDto indexPlanReturnDto) {
        List<indexDataDto> indexDataDtoChannel = indexPlanReturnDto.getIndexDataDto();
        List<ObjDataListDto> objDataListDtoChannel = indexPlanReturnDto.getObjDataListDto();
        List<CimpCmAssemblyAnalysis> cimpCmAssemblyAnalysisList = indexPlanMapper.indexDistributionQuery(nodeId, objIdList);
        if (cimpCmAssemblyAnalysisList.size() > 0) {
            IndexPlanReturnDto tempIndexPlanReturnDto = assembleIndex(cimpCmAssemblyAnalysisList);
            List<indexDataDto> tempIndexDataDto = tempIndexPlanReturnDto.getIndexDataDto();
            List<ObjDataListDto> tempObjDataListDto = tempIndexPlanReturnDto.getObjDataListDto();
            //移除已经分配了指标的渠道
            for (ObjDataListDto objDataListDto : tempObjDataListDto) {
                objIdList.remove(objDataListDto.getObjId());
            }
        }
        for (String objId : objIdList) {
            for (indexDataDto indexDataDto : indexDataDtoChannel) {
                CimpCmAssemblyAnalysis cimpCmAssemblyAnalysis = new CimpCmAssemblyAnalysis();
                cimpCmAssemblyAnalysis.setAssemblyId(getUUID());
                cimpCmAssemblyAnalysis.setIndexId(indexDataDto.getIndexId());
                cimpCmAssemblyAnalysis.setIndexName(indexDataDto.getIndexName());
                cimpCmAssemblyAnalysis.setSort(indexDataDto.getSort());
                cimpCmAssemblyAnalysis.setObjType(objectInfo.getObjType());
                cimpCmAssemblyAnalysis.setObjId(objId);
                cimpCmAssemblyAnalysisList.add(cimpCmAssemblyAnalysis);
            }
        }
        List<CimpCmAssemblyAnalysis> cimpCmAssemblyAnalysisListReturn = new ArrayList<>();
        int assembleIndexSize = 0;
        if (objectInfo.getPage() * objectInfo.getSize() * indexDataDtoChannel.size() < cimpCmAssemblyAnalysisList.size()) {
            assembleIndexSize = objectInfo.getPage() * objectInfo.getSize() * indexDataDtoChannel.size();
        } else {
            assembleIndexSize = cimpCmAssemblyAnalysisList.size();
        }
        //进行分页返回数据
        for (int i = (objectInfo.getPage() - 1) * objectInfo.getSize() * indexDataDtoChannel.size(); i < assembleIndexSize; i++) {
            cimpCmAssemblyAnalysisListReturn.add(cimpCmAssemblyAnalysisList.get(i));
        }
        IndexPlanReturnDto indexPlanReturnDtoData = assembleIndex(cimpCmAssemblyAnalysisListReturn);
        indexPlanReturnDtoData.setTotalSize(cimpCmAssemblyAnalysisList.size() / indexDataDtoChannel.size());
        return indexPlanReturnDtoData;

    }

    public ObjectInfoListDto objIdListQuery(ObjectInfo objectInfo) {
        //查询当前机构及其子机构orgId集合
        ObjectInfoListDto objectInfoListDto = new ObjectInfoListDto();
        //查询机构树,得到子机构的orgCode
        List<Map<String, Object>> orgList = service.getOrgByParam(objectInfo.getOrgId(), "", false);
        //将对象封装成ObjectInfo
        List<ObjectInfoDto> objectInfoList = new ArrayList<>();
        //查询当前机构及其子机构的客户经理
        List<String> orgCodeList = new ArrayList<>();
        if (orgList.size() > 0) {
            for (Map<String, Object> stringObjectMap : orgList) {
                ObjectInfoDto objectInfoTemp = new ObjectInfoDto();
                objectInfoTemp.setObjType("02");
                objectInfoTemp.setObjName((String) stringObjectMap.get("orgName"));
                objectInfoTemp.setOrgId((String) stringObjectMap.get("orgCode"));
                objectInfoTemp.setObjId((String) stringObjectMap.get("orgCode"));
                objectInfoList.add(objectInfoTemp);
                orgCodeList.add((String) stringObjectMap.get("orgCode"));
            }
        }
        List<String> objIdList = new ArrayList<>(orgCodeList);
        //根据OrgCode查找下属客户经理
        List<AdminSmUser> adminSmUsers = indexPlanMapper.selectCustomerId(orgCodeList);
        //获取客户经理的ORG_ID
        if (adminSmUsers.size() > 0) {
            for (AdminSmUser adminSmUser : adminSmUsers) {
                ObjectInfoDto objectInfoTemp = new ObjectInfoDto();
                objectInfoTemp.setObjType("01");
                objectInfoTemp.setObjName(adminSmUser.getUserName());
                objectInfoTemp.setObjId(adminSmUser.getLoginCode());
                objectInfoTemp.setOrgId(adminSmUser.getOrgId());
                objectInfoList.add(objectInfoTemp);
                objIdList.add(adminSmUser.getLoginCode());
            }
        }
        //查询渠道ASSEMBLY_ID
//		List<CimpCmAsseminfo> cimpCmAsseminfoList = indexPlanMapper.selectChannel();
//		if(cimpCmAsseminfoList.size()>0){
//			for (CimpCmAsseminfo cimpCmAsseminfo : cimpCmAsseminfoList) {
//				ObjectInfoDto objectInfoTemp = new ObjectInfoDto();
//				objectInfoTemp.setObjType("03");
//				objectInfoTemp.setObjName(cimpCmAsseminfo.getAssemblyName());
//				objectInfoTemp.setObjId(cimpCmAsseminfo.getAssemblyId());
//				objectInfoList.add(objectInfoTemp);
//				objIdList.add(cimpCmAsseminfo.getAssemblyId());
//			}
//		}
        //子机构及客户经理、渠道的id
        //objIdList.remove(objectInfo.getOrgId());
        objectInfoListDto.setObjectInfoDtoList(objectInfoList);
        objectInfoListDto.setObjIdList(objIdList);
        return objectInfoListDto;
    }

    //组装数据
    public IndexPlanReturnDto assembleIndex(List<CimpCmAssemblyAnalysis> cimpCmAssemblyAnalysis) {
        IndexPlanReturnDto indexPlanReturnDto = new IndexPlanReturnDto();
        List<String> indexDataList = new ArrayList<>();
        List<String> objIdList = new ArrayList<>();
        List<indexDataDto> indexDataDtoList = new ArrayList<>();
        for (CimpCmAssemblyAnalysis entity : cimpCmAssemblyAnalysis) {
            if (!indexDataList.contains(entity.getIndexName())) {
                indexDataDto indexDataDto = new indexDataDto();
                indexDataList.add(entity.getIndexName());
                indexDataDto.setIndexId(entity.getIndexId());
                indexDataDto.setIndexName(entity.getIndexName());
                indexDataDto.setSort(entity.getSort());
                indexDataDtoList.add(indexDataDto);
            }
            if (!objIdList.contains(entity.getObjId())) {
                objIdList.add(entity.getObjId());
            }
        }
        //用于存放所有的行数据
        List<ObjDataListDto> objDataListDtoList = new ArrayList<>();
        if (objIdList.size() > 0) {
            for (int i = 0; i < objIdList.size(); i++) {
                //用于存放每一行的初期值、目标值、指标顺序
                List<DataListDto> dataListDtoList = new ArrayList<>();
                //用于存放每一行数据
                ObjDataListDto objDataListDto = new ObjDataListDto();
                String objId = "";
                String objType = "";
                for (CimpCmAssemblyAnalysis entity : cimpCmAssemblyAnalysis) {
                    if (objIdList.get(i) != null) {
                        if (objIdList.get(i).equals(entity.getObjId())) {
                            objId = entity.getObjId();
                            objType = entity.getObjType();
                            DataListDto dataListDto = new DataListDto();
                            dataListDto.setSort(entity.getSort());
                            if (entity.getInitialValue() != null) {
                                dataListDto.setInitialValue(entity.getInitialValue().toString());
                            } else {
                                dataListDto.setInitialValue("");
                            }
                            if (entity.getTargetValue() != null) {
                                dataListDto.setTargetValue(entity.getTargetValue().toString());
                            } else {
                                dataListDto.setTargetValue("");
                            }
                            dataListDtoList.add(dataListDto);
                        }
                    }
                }
                objDataListDto.setObjId(objId);
                ;
                objDataListDto.setObjType(objType);
                objDataListDto.setDataListDto(dataListDtoList);
                objDataListDtoList.add(objDataListDto);
            }
        }
        indexPlanReturnDto.setIndexDataDto(indexDataDtoList);
        indexPlanReturnDto.setObjDataListDto(objDataListDtoList);
        return indexPlanReturnDto;
    }

    public String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public int saveindex(IndexPlanSaveForm indexPlanSaveForm) throws ParseException {
        List<ObjectDataForm> objectDataFormList = indexPlanSaveForm.getObjectDataFormList();
        List<IndexDataFormList> indexDataFormList = indexPlanSaveForm.getIndexDataFormList();
        //获取节点nodeId
        String nodeId = indexPlanSaveForm.getNodeId();
        //查出该节点所有数据
        List<CimpCmAssemblyAnalysis> cimpCmAssemblyAnalysisList = indexPlanMapper.targetQuery(nodeId);
        IndexPlanReturnDto indexPlanReturnDto = assembleIndex(cimpCmAssemblyAnalysisList);
        List<ObjDataListDto> objDataListDto = indexPlanReturnDto.getObjDataListDto();
        List<ObjectDataForm> objectDataFormUpdateList=new ArrayList<>();
        for (ObjectDataForm objectDataForm : objectDataFormList) {
            for (ObjDataListDto dataListDto : objDataListDto) {
                if (Objects.equals(objectDataForm.getObjId(), dataListDto.getObjId()) && objectDataForm.getObjType().equals(dataListDto.getObjType())){
                    objectDataFormUpdateList.add(objectDataForm);
                }
            }
        }
        //删除原有数据
        List<String> objIdList = new ArrayList<>();
        for (ObjectDataForm objectDataForm : objectDataFormList) {
            objIdList.add(objectDataForm.getObjId());
        }
        indexPlanMapper.deleteOriginalIndex(objIdList, nodeId);

        objectDataFormList.removeAll(objectDataFormUpdateList);
        //更新的数据
        for (ObjectDataForm objectDataForm : objectDataFormUpdateList) {
            for (int j = 0; j < indexDataFormList.size(); j++) {
                // 获取当前用户code
                String loginCode = SecurityUtils.getCurrentUserLogin();
                // 获取当前日期
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                // 获取ID
                String uuid = UUID.randomUUID().toString().toLowerCase().replace("-", "");
                // 获取 对象类型
                String objType = objectDataForm.getObjType();
                // 获取对象ID
                String objId = objectDataForm.getObjId();
                //获取指标id
                String targetId = indexDataFormList.get(j).getTargetId();
                //获取指标name
                String targetName = indexDataFormList.get(j).getTargetName();
                //获取期初值、目标值
                List<DataListForm> dataListForm = objectDataForm.getDataList();
                String sort = dataListForm.get(j).getSort();

                CimpCmAssemblyAnalysis cimpCmAssemblyAnalysis = new CimpCmAssemblyAnalysis();
                if (dataListForm.get(j).getTargetValue() != null && !dataListForm.get(j).getTargetValue().isEmpty()) {
                    String targetValue = dataListForm.get(j).getTargetValue();
                    cimpCmAssemblyAnalysis.setTargetValue(new BigDecimal(targetValue));
                }
                String s = dataListForm.get(j).getStartValue();
                if (dataListForm.get(j).getStartValue() != null && !dataListForm.get(j).getStartValue().isEmpty()) {
                    String initialValue = dataListForm.get(j).getStartValue();
                    cimpCmAssemblyAnalysis.setInitialValue(new BigDecimal(initialValue));
                }
                cimpCmAssemblyAnalysis.setAssemblyId(uuid);
                cimpCmAssemblyAnalysis.setIndexId(targetId);
                cimpCmAssemblyAnalysis.setObjType(objType);
                cimpCmAssemblyAnalysis.setObjId(objId);
                cimpCmAssemblyAnalysis.setCratUsr(loginCode);
                cimpCmAssemblyAnalysis.setCratDt(df.parse(df.format(new Date())));
                cimpCmAssemblyAnalysis.setLastChgUsr(loginCode);
                cimpCmAssemblyAnalysis.setLastChgDt(df.parse(df.format(new Date())));
                cimpCmAssemblyAnalysis.setNodId(nodeId);
                cimpCmAssemblyAnalysis.setSort(sort);
                cimpCmAssemblyAnalysis.setIndexName(targetName);
                cimpCmAssemblyAnalysis.setMarkFlag("1");
                int addSuccess = add(cimpCmAssemblyAnalysis);
                if (addSuccess != 1) {
                    return addSuccess;
                }
            }
        }
        //新插入数据
        for (ObjectDataForm objectDataForm : objectDataFormList) {
            for (int j = 0; j < indexDataFormList.size(); j++) {
                // 获取当前用户code
                String loginCode = SecurityUtils.getCurrentUserLogin();
                // 获取当前日期
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                // 获取ID
                String uuid = UUID.randomUUID().toString().toLowerCase().replace("-", "");
                // 获取 对象类型
                String objType = objectDataForm.getObjType();
                // 获取对象ID
                String objId = objectDataForm.getObjId();
                //获取指标id
                String targetId = indexDataFormList.get(j).getTargetId();
                //获取指标name
                String targetName = indexDataFormList.get(j).getTargetName();
                //获取期初值、目标值
                List<DataListForm> dataListForm = objectDataForm.getDataList();
                String sort = dataListForm.get(j).getSort();

                CimpCmAssemblyAnalysis cimpCmAssemblyAnalysis = new CimpCmAssemblyAnalysis();
                if (dataListForm.get(j).getTargetValue() != null && !dataListForm.get(j).getTargetValue().isEmpty()) {
                    String targetValue = dataListForm.get(j).getTargetValue();
                    cimpCmAssemblyAnalysis.setTargetValue(new BigDecimal(targetValue));
                }
                String s = dataListForm.get(j).getStartValue();
                if (dataListForm.get(j).getStartValue() != null && !dataListForm.get(j).getStartValue().isEmpty()) {
                    String initialValue = dataListForm.get(j).getStartValue();
                    cimpCmAssemblyAnalysis.setInitialValue(new BigDecimal(initialValue));
                }
                cimpCmAssemblyAnalysis.setAssemblyId(uuid);
                cimpCmAssemblyAnalysis.setIndexId(targetId);
                cimpCmAssemblyAnalysis.setObjType(objType);
                cimpCmAssemblyAnalysis.setObjId(objId);
                cimpCmAssemblyAnalysis.setCratUsr(loginCode);
                cimpCmAssemblyAnalysis.setCratDt(df.parse(df.format(new Date())));
                cimpCmAssemblyAnalysis.setLastChgUsr(loginCode);
                cimpCmAssemblyAnalysis.setLastChgDt(df.parse(df.format(new Date())));
                cimpCmAssemblyAnalysis.setNodId(nodeId);
                cimpCmAssemblyAnalysis.setSort(sort);
                cimpCmAssemblyAnalysis.setIndexName(targetName);
                int addSuccess = add(cimpCmAssemblyAnalysis);
                if (addSuccess != 1) {
                    return addSuccess;
                }
            }
        }
        return 0;
    }
    public int editIndex(IndexPlanSaveForm indexPlanSaveForm) throws ParseException{
        String activityId = indexPlanSaveForm.getActivityId();
        String activityName=indexPlanSaveForm.getActivityName();
        String orgId=indexPlanSaveForm.getOrgId();
        //查询出已有的数据
        List<YscimcIndexStatePo> yscimcIndexStatePoList=indexPlanMapper.selectIndexState(activityId);
        List<ObjectDataForm> objectDataFormList = indexPlanSaveForm.getObjectDataFormList();

        List<ObjectDataForm> removeList =new ArrayList<>();
        //去除已经分配的机构数据
        if (objectDataFormList.get(0).getObjType().equals("02")){
            List<YscimcIndexStatePo> yscimcIndexStatePoArray=new ArrayList<>();
            for (ObjectDataForm objectDataForm : objectDataFormList) {
                for (YscimcIndexStatePo yscimcIndexStatePo : yscimcIndexStatePoList) {
                    if(yscimcIndexStatePo.getOrgId().equals(objectDataForm.getObjId())){
//                        yscimcIndexStatePo.setIndexState("0");
//                        yscimcIndexStatePoUpdateList.add(yscimcIndexStatePo);
                        removeList.add(objectDataForm);
                    }
                }
            }
            objectDataFormList.removeAll(removeList);
            //添加新的机构数据
            if(objectDataFormList.size()>0){
                for (ObjectDataForm objectDataForm : objectDataFormList) {
                    YscimcIndexStatePo yscimcIndexStatePo =new YscimcIndexStatePo();
                    yscimcIndexStatePo.setIndexState("0");
                    yscimcIndexStatePo.setActivityId(activityId);
                    yscimcIndexStatePo.setActivityName(activityName);
                    yscimcIndexStatePo.setOrgId(objectDataForm.getObjId());
                    yscimcIndexStatePo.setId(getUuid());
                    yscimcIndexStatePoArray.add(yscimcIndexStatePo);

                }
                indexPlanMapper.insertIndexStateList(yscimcIndexStatePoArray);
            }
        }
        //查询指标是否为0
        ObjectInfo objectInfo =new ObjectInfo();
        objectInfo.setOrgId(orgId);
        objectInfo.setTempId(activityId);
        List<OrgIndexRemainVo> orgIndexRemainVos = indexRemainQuery(objectInfo);
        int flag=0;
        for (OrgIndexRemainVo orgIndexRemainVo : orgIndexRemainVos) {
            //orgIndexRemainVo是否为0
            if (orgIndexRemainVo.getIndexRemain().compareTo(new BigDecimal(0)) > 0){
                flag=1;
            }
        }
        //改变当前机构指标的状态
        for (YscimcIndexStatePo yscimcIndexStatePo : yscimcIndexStatePoList) {
         if(yscimcIndexStatePo.getOrgId().equals(orgId)){
            if (flag==1){
                yscimcIndexStatePo.setIndexState("1");
                indexPlanMapper.updateIndexState(yscimcIndexStatePo);
            }else if (flag==0){
                yscimcIndexStatePo.setIndexState("2");
                indexPlanMapper.updateIndexState(yscimcIndexStatePo);
            }

        }
    }
        return 0;
    }
    /**
     * 通过活动编号以机构维度查询指标信息
     *
     * @param model
     * @return
     */
    public List<Map<String, Object>> taskDataForOrgUrl(QueryModel model) {
        PageHelper.startPage(model.getPage(), model.getSize());
        List<Map<String, Object>> list = indexPlanMapper.taskDataForOrgUrl(model);
        PageHelper.clearPage();
        return list;
    }

    /**
     * 通过活动编号以客户经理维度查询指标信息
     *
     * @param model
     * @return
     */
    public List<Map<String, Object>> taskDataForMgrUrl(QueryModel model) {
        PageHelper.startPage(model.getPage(), model.getSize());
        List<Map<String, Object>> list = indexPlanMapper.taskDataForMgrUrl(model);
        PageHelper.clearPage();
        return list;
    }


	public List<Map<String, Object>> customerQueryByOrgId(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		return indexPlanMapper.customerQueryByOrgId(model);
	}
    public String dataCheck(IndexPlanSaveForm indexPlanSaveForm) throws ParseException {
        List<ObjectDataForm> objectDataFormList = indexPlanSaveForm.getObjectDataFormList();
        List<IndexDataFormList> indexDataFormList = indexPlanSaveForm.getIndexDataFormList();
        String orgId=indexPlanSaveForm.getOrgId();
        List<ObjectDataForm> managerDataFormList=new ArrayList<>();
        List<ObjectDataForm> orgDataFormList=new ArrayList<>();
        List<ObjectDataForm> channelDataFormList=new ArrayList<>();
        List<String> orgIdList=new ArrayList<>();
        for (ObjectDataForm objectDataForm : objectDataFormList) {
            //分类
            int flag=0;
            if (objectDataForm.getObjType().equals("01")){
                managerDataFormList.add(objectDataForm);
            }else if(objectDataForm.getObjType().equals("02")){
                orgDataFormList.add(objectDataForm);
                orgIdList.add(objectDataForm.getObjId());
            }else {
                channelDataFormList.add(objectDataForm);
            }
            for (DataListForm dataListForm : objectDataForm.getDataList()) {
               if (indexCheck(dataListForm).equals("1") ){
                   flag=1;
                   try{
                       BigDecimal targetValue=new BigDecimal(dataListForm.getTargetValue());
                       BigDecimal startValue=new BigDecimal(dataListForm.getStartValue());
                       if (startValue.compareTo(targetValue)>0){
                           return "存在指标的目标值小于期初值";
                       }
                   }catch (Exception e){
                       return "含有非数字字符串";
                   }

               }else if(indexCheck(dataListForm).equals("2")){
                   //目标值有数据
                   try{
                       BigDecimal targetValue=new BigDecimal(dataListForm.getTargetValue());
                   }catch (Exception e){
                       return "含有非数字字符串";
                   }
                   flag=1;
               }else if(indexCheck(dataListForm).equals("3")){

               } else if(indexCheck(dataListForm).equals("4")){

               }
            }
            if (flag==0){
                return "存在对象的所有指标的目标值都为空";
            }
        }

        for (ObjectDataForm orgDataForm : orgDataFormList) {
            //查找出该机构的所有子机构
            String objId = orgDataForm.getObjId();
            String orgName=indexPlanMapper.selectOrgName(objId);
            //查询出当前机构及子机构id
            List<String> orgCodeList=new ArrayList<>();
            List<Map<String, Object>> orgMapList = service.getOrgByParam(objId, "", false);
            for (Map<String, Object> stringObjectMap : orgMapList) {
                orgCodeList.add((String) stringObjectMap.get("orgCode"));
            }
            //求两个orgIdList交集
            List<String> orgIntersection = orgCodeList.stream().filter(item -> orgIdList.contains(item)).collect(Collectors.toList());
            //orgIntersection.size();
            List<DataListForm> dataList = null;
            //当前分配中的机构有子机构
            if (orgIntersection.size()>1){
                for (ObjectDataForm objectDataForm : orgDataFormList) {
                    if (objectDataForm.getObjId().equals(objId)){
                         dataList = objectDataForm.getDataList();
                    }
                }
                //移除自己这个
                orgIntersection.remove(objId);
                for (String s : orgIntersection) {
                    //int flag=0;
                    if(dataList!=null && dataList.size()>0){
                        for (DataListForm dataListForm : dataList) {
                            BigDecimal indexRemain = new BigDecimal(0);
                            //判断返回的值不为null和空字符串""
                            if (indexCheck(dataListForm).equals("1")){
                                try {
                                    BigDecimal targetValue=new BigDecimal(dataListForm.getTargetValue());
                                    BigDecimal startValue=new BigDecimal(dataListForm.getStartValue());
                                    indexRemain =targetValue.subtract(startValue) ;
                                    if (indexRemain.compareTo(new BigDecimal(0)) < 0){
                                        return "目标值小于期初值";
                                    }
                                }catch (Exception e){
                                    return "含有非数字字符串";
                                }
                            }else if (indexCheck(dataListForm).equals("2")){
                                try{
                                    indexRemain=new BigDecimal(dataListForm.getTargetValue());
                                    if (indexRemain.compareTo(new BigDecimal(0)) < 0){
                                        return "目标值小于期初值";
                                    }
                                }catch (Exception e){
                                    return "含有非数字字符串";
                                }
                            }
                            //当前机构是指标分配机构
                            if(objId.equals(orgId)){
                                if (managerDataFormList.size()>0){
                                    for (ObjectDataForm managerDataForm : managerDataFormList) {
                                        List<DataListForm> childDataList = managerDataForm.getDataList();
                                        for (DataListForm listForm : childDataList) {
                                            if (listForm.getSort().equals(dataListForm.getSort())){
                                                if(indexCheck(listForm).equals("1")){
                                                    BigDecimal targetValue=new BigDecimal(listForm.getTargetValue());
                                                    BigDecimal startValue=new BigDecimal(listForm.getStartValue());
                                                    indexRemain =indexRemain.subtract(targetValue.subtract(startValue));
                                                    //indexRemain=indexRemain-(Integer.parseInt(listForm.getTargetValue()) - Integer.parseInt(listForm.getTargetValue()));
                                                    if (indexRemain.compareTo(new BigDecimal(0))<0){
                                                        return "子级机构、客户经理、渠道指标之和大于父级机构 ["+orgName+"] 指标";
                                                    }
                                                }else if (indexCheck(listForm).equals("2")) {
                                                    indexRemain=indexRemain.subtract(new BigDecimal(listForm.getTargetValue()));
                                                    //indexRemain = indexRemain - Integer.parseInt(listForm.getTargetValue());
                                                    if (indexRemain.compareTo(new BigDecimal(0))<0){
                                                        return "子级机构、客户经理、渠道指标之和大于父级机构 ["+orgName+"] 指标";
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }else if (channelDataFormList.size()>0){
                                    for (ObjectDataForm channelDataForm : channelDataFormList){
                                        List<DataListForm> childDataList = channelDataForm.getDataList();
                                        for (DataListForm listForm : childDataList) {
                                            if (listForm.getSort().equals(dataListForm.getSort())){
                                                if(indexCheck(listForm).equals("1")){
                                                    BigDecimal targetValue=new BigDecimal(listForm.getTargetValue());
                                                    BigDecimal startValue=new BigDecimal(listForm.getStartValue());
                                                    indexRemain =indexRemain.subtract(targetValue.subtract(startValue)) ;
                                                    //indexRemain=indexRemain-(Integer.parseInt(listForm.getTargetValue()) - Integer.parseInt(listForm.getTargetValue()));
                                                    if (indexRemain.compareTo(new BigDecimal(0))<0){
                                                        return "子级机构、客户经理、渠道指标之和大于父级机构 ["+orgName+"] 指标";
                                                    }
                                                }else if (indexCheck(listForm).equals("2")) {
                                                    indexRemain=indexRemain.subtract(new BigDecimal(listForm.getTargetValue()));
                                                    //indexRemain = indexRemain - Integer.parseInt(listForm.getTargetValue());
                                                    if (indexRemain.compareTo(new BigDecimal(0))<0){
                                                        return "子级机构、客户经理、渠道指标之和大于父级机构 ["+orgName+"] 指标";
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            for (ObjectDataForm objectDataForm : orgDataFormList) {
                                if (objectDataForm.getObjId().equals(s)){
                                    List<DataListForm> childDataList = objectDataForm.getDataList();
                                    for (DataListForm listForm : childDataList) {
                                        if (listForm.getSort().equals(dataListForm.getSort())){
                                            if(indexCheck(listForm).equals("1")){
                                                BigDecimal targetValue=new BigDecimal(listForm.getTargetValue());
                                                BigDecimal startValue=new BigDecimal(listForm.getStartValue());
                                                indexRemain=indexRemain.subtract(targetValue.subtract(startValue));
                                                //indexRemain=indexRemain-(Integer.parseInt(listForm.getTargetValue()) - Integer.parseInt(listForm.getTargetValue()));
                                                if (indexRemain.compareTo(new BigDecimal(0))<0){
                                                    return "子级机构、客户经理、渠道指标之和大于父级机构 ["+orgName+"] 指标";
                                                }
                                            }else if (indexCheck(listForm).equals("2")) {
                                                indexRemain=indexRemain.subtract(new BigDecimal(listForm.getTargetValue()));
                                                //indexRemain = indexRemain - Integer.parseInt(listForm.getTargetValue());
                                                if (indexRemain.compareTo(new BigDecimal(0))<0){
                                                    return "子级机构、客户经理、渠道指标之和大于父级机构 ["+orgName+"] 指标";
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                }
            }
        }
        return "0";
    }
    public String indexCheck( DataListForm dataListForm){
        if ((dataListForm.getStartValue()!=null && !dataListForm.getStartValue().equals(""))
                && (dataListForm.getTargetValue()!=null && !dataListForm.getTargetValue().equals(""))){
            //期初值、目标值都不为空
            return "1";
        }else if ((dataListForm.getStartValue()==null || dataListForm.getStartValue().equals(""))
                &&(dataListForm.getTargetValue()!=null && !dataListForm.getTargetValue().equals(""))){
            //期初值为空、目标值不为空
            return "2";
        }else if ((dataListForm.getStartValue()!=null && !dataListForm.getStartValue().equals(""))
                && (dataListForm.getTargetValue()==null || dataListForm.getTargetValue().equals(""))){
            //期初值不为空、目标值为空
            return "3";
        }else if ((dataListForm.getStartValue() ==null || dataListForm.getStartValue().equals(""))
                && (dataListForm.getTargetValue()==null || dataListForm.getTargetValue().equals(""))){
            //期初值、目标值都为空
            return "4";
        }
        return "0";
    }
	public int saveAssembly(IndexPlanSaveForm indexPlanSaveForm) throws ParseException {
		List<ObjectDataForm> objectDataFormList = indexPlanSaveForm.getObjectDataFormList();
		List<IndexDataFormList> indexDataFormList = indexPlanSaveForm.getIndexDataFormList();
		String orgId=indexPlanSaveForm.getOrgId();
		//获取节点nodeId
		String nodeId = indexPlanSaveForm.getNodeId();
		this.deleteAssembly(nodeId);
//		saveWaitDistribution(indexPlanSaveForm);
		for(int i=0;i<objectDataFormList.size();i++){
			for(int j=0;j<indexDataFormList.size();j++){
				// 获取当前用户code
				String loginCode = SecurityUtils.getCurrentUserLogin();
				// 获取当前日期
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				// 获取ID
				String uuid = UUID.randomUUID().toString().toLowerCase().replace("-", "");
				// 获取 对象类型
				String objType = objectDataFormList.get(i).getObjType();
				// 获取对象ID
				String objId = objectDataFormList.get(i).getObjId();
				//获取指标id
				String targetId = indexDataFormList.get(j).getTargetId();
				//获取指标name
				String targetName = indexDataFormList.get(j).getTargetName();

				//获取期初值、目标值
				List<DataListForm> dataListForm = objectDataFormList.get(i).getDataList();
				String sort = dataListForm.get(j).getSort();

				CimpCmAssemblyAnalysis cimpCmAssemblyAnalysis = new CimpCmAssemblyAnalysis();
				if(dataListForm.get(j).getTargetValue()!=null&&!dataListForm.get(j).getTargetValue().isEmpty()){
					String targetValue=dataListForm.get(j).getTargetValue();
					cimpCmAssemblyAnalysis.setTargetValue(new BigDecimal(targetValue));
				}
				String s=dataListForm.get(j).getStartValue();
				if (dataListForm.get(j).getStartValue()!=null &&! dataListForm.get(j).getStartValue().isEmpty()){
					String initialValue=dataListForm.get(j).getStartValue();
					cimpCmAssemblyAnalysis.setInitialValue(new BigDecimal(initialValue));
				}
				cimpCmAssemblyAnalysis.setAssemblyId(uuid);
				cimpCmAssemblyAnalysis.setIndexId(targetId);
				cimpCmAssemblyAnalysis.setObjType(objType);
				cimpCmAssemblyAnalysis.setObjId(objId);
				cimpCmAssemblyAnalysis.setCratUsr(loginCode);
				cimpCmAssemblyAnalysis.setCratDt(df.parse(df.format(new Date())));
				cimpCmAssemblyAnalysis.setLastChgUsr(loginCode);
				cimpCmAssemblyAnalysis.setLastChgDt(df.parse(df.format(new Date())));
				cimpCmAssemblyAnalysis.setNodId(nodeId);
				cimpCmAssemblyAnalysis.setSort(sort);
				cimpCmAssemblyAnalysis.setIndexName(targetName);
				cimpCmAssemblyAnalysis.setMarkFlag("1");
				int addSuccess = this.add(cimpCmAssemblyAnalysis);
				if (addSuccess!=1){
					return addSuccess;
				}
			}
		}
		return 0;
	}
	public int saveWaitDistribution(IndexPlanSaveForm indexPlanSaveForm){
		List<ObjectDataForm> objectDataFormList = indexPlanSaveForm.getObjectDataFormList();
		List<IndexDataFormList> indexDataFormList = indexPlanSaveForm.getIndexDataFormList();
		String orgId=indexPlanSaveForm.getOrgId();
		//获取节点nodeId
		String nodeId = indexPlanSaveForm.getNodeId();
		//根据nodeId查询出tempId(活动ID)
		String activityId=indexPlanMapper.getActivityId(nodeId);
		//查询出活动的名称
		String activityName=indexPlanMapper.getActivityName(activityId);
		//查询出活动的创建机构
		String createOrg = indexPlanMapper.selectCreateOrg(activityId);
        //先删除数据
        indexPlanMapper.deleteIndexState(activityId);
        //将对象数据分为客户经理，机构，渠道
        List<ObjectDataForm> managerDataList=new ArrayList<>();
        List<ObjectDataForm> orgDataList=new ArrayList<>();
        List<ObjectDataForm> channelDataList=new ArrayList<>();
		//先把数据中的机构设置为未分配状态
		Set<String> orgIdList=new HashSet<>();
		Set<String> managerIdList=new HashSet<>();
		Set<String> channelIdList=new HashSet<>();
		List<YscimcIndexStatePo> yscimcIndexStatePoList=new ArrayList<>();
		for (ObjectDataForm objectDataForm : objectDataFormList){
			if(objectDataForm.getObjType().equals("01")){
                managerDataList.add(objectDataForm);
				managerIdList.add(objectDataForm.getObjId());
			}else if(objectDataForm.getObjType().equals("02")){
				orgIdList.add(objectDataForm.getObjId());
                orgDataList.add(objectDataForm);
				YscimcIndexStatePo yscimcIndexStatePo=new YscimcIndexStatePo();
				yscimcIndexStatePo.setId(UUID.randomUUID().toString().toLowerCase().replace("-", ""));
				yscimcIndexStatePo.setActivityId(activityId);
				yscimcIndexStatePo.setActivityName(activityName);
				yscimcIndexStatePo.setOrgId(objectDataForm.getObjId());
				yscimcIndexStatePo.setIndexState("0");
				yscimcIndexStatePoList.add(yscimcIndexStatePo);
			}else if(objectDataForm.getObjType().equals("03")){
			    channelDataList.add(objectDataForm);
                channelIdList.add(objectDataForm.getObjId());
            }
		}
		//查询客户经理的机构是否有待分配指标
		if(managerDataList.size()>0){
            //Integer i = indexPlanMapper.selectOrgIndexState(orgId);
            //判断客户经理的机构是否有指标待分配
            int flag=0;
            ObjectDataForm orgDataForm=new ObjectDataForm();
            for (ObjectDataForm objectDataForm : orgDataList) {
                //给客户经理所属机构分配了指标
                if(objectDataForm.getObjId().equals(orgId)){
                    flag=1;
                    orgDataForm=objectDataForm;
                }
            }
            List<DataListForm> orgDataFormDataList = orgDataForm.getDataList();
            if (orgDataFormDataList!=null){
                for (DataListForm dataListForm : orgDataFormDataList) {
                    int orgIndexRemain=0;
                    if(dataListForm.getStartValue()==null || dataListForm.getStartValue().equals("")){
                        orgIndexRemain= Integer.parseInt(dataListForm.getTargetValue());
                    }else {
                        orgIndexRemain=Integer.parseInt(dataListForm.getTargetValue())-Integer.parseInt(dataListForm.getStartValue());
                    }

                    for (ObjectDataForm managerDataForm : managerDataList) {
                        List<DataListForm> dataList = managerDataForm.getDataList();
                        for (DataListForm listForm : dataList) {
                            if (listForm.getSort().equals(dataListForm.getSort())){
                                if ((listForm.getStartValue()==null ||listForm.getStartValue().equals("")) && (listForm.getTargetValue()!=null &&!listForm.getStartValue().equals(""))){
                                    orgIndexRemain=orgIndexRemain-Integer.parseInt(listForm.getTargetValue());
                                }else if ((listForm.getStartValue() != null && !listForm.getStartValue().equals("")) && (listForm.getTargetValue() != null && !listForm.getStartValue().equals(""))){
                                    orgIndexRemain=Integer.parseInt(listForm.getTargetValue())-Integer.parseInt(listForm.getStartValue());
                                }
                            }
                        }
                    }
                    if (orgIndexRemain == 0){
                        for (YscimcIndexStatePo yscimcIndexStatePo : yscimcIndexStatePoList) {
                            if(yscimcIndexStatePo.getOrgId().equals(orgId)){
                                yscimcIndexStatePo.setIndexState("2");
                            }
                        }
                    }else if (orgIndexRemain > 0){
                        for (YscimcIndexStatePo yscimcIndexStatePo : yscimcIndexStatePoList) {
                            if(yscimcIndexStatePo.getOrgId().equals(orgId)){
                                yscimcIndexStatePo.setIndexState("1");
                            }
                        }
                    }
                }
            }
            //没有待分配的指标
			if(flag == 0){
				YscimcIndexStatePo yscimcIndexStatePo=new YscimcIndexStatePo();
                yscimcIndexStatePo.setIndexState("2");
                yscimcIndexStatePo.setOrgId(orgId);
                yscimcIndexStatePo.setActivityId(activityId);
                yscimcIndexStatePo.setActivityName(activityName);
                yscimcIndexStatePo.setId(getUuid());
                //添加进数组中
                yscimcIndexStatePoList.add(yscimcIndexStatePo);
				//indexPlanMapper.insertIndexState(yscimcIndexStatePo);
			}else {
                //orgIdList.
            }
		}
        indexPlanMapper.insertIndexStateList(yscimcIndexStatePoList);
        return 0;
	}
	public String getUuid(){
        return UUID.randomUUID().toString().toLowerCase().replace("-", "");
    }
}

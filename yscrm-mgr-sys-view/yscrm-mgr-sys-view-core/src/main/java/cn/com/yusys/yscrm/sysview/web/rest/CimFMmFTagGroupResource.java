package cn.com.yusys.yscrm.sysview.web.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import cn.com.yusys.yscrm.sysview.domain.CimFMmFTagGroup;
import cn.com.yusys.yscrm.sysview.domain.TagTree;
import cn.com.yusys.yscrm.sysview.service.CimFMmFTagGroupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;

/**
 * @author dell @项目名称： yusp-app-cim
 * @类名称: CimFMmFTagGroupResource
 * @类描述:
 * @功能描述: 标签分组
 * @创建人: Yangjingbo
 * @创建时间: 2018年09月28日
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 */

@RestController
@RequestMapping("/api/cimfmmftagGrop")
public class CimFMmFTagGroupResource extends CommonResource<CimFMmFTagGroup, String> {
	@Autowired
	private CimFMmFTagGroupService cimFmmTagGroupService;

	public CimFMmFTagGroupResource(CimFMmFTagGroupService service) {
		super();
		this.cimFmmTagGroupService = service;
		// TODO Auto-generated constructor stub
	}

	private final Logger log = LoggerFactory.getLogger(CimFMmFTagGroupResource.class);

	@Override
	protected CommonService getCommonService() {
		// TODO Auto-generated method stub
		return this.cimFmmTagGroupService;
	}

	/**
	 * 查询获取分组树
	 *
	 * @return
	 */

	@GetMapping("/getGroupTree")
	public ResultDto<List<CimFMmFTagGroup>> getGroupTree(String[] roles) {
		String role = roles[0];
		List<CimFMmFTagGroup> list = new ArrayList<>();
		if (role.contains("R006") || role.contains("R003") || role.contains("R002")) {
			list = this.cimFmmTagGroupService.getGroupTree();
		} else {
			list = this.cimFmmTagGroupService.getSystemTree();
		}
		if (list.size() > 0) {
			int count = 0;
			for (CimFMmFTagGroup obj : list) {
				if ("1".equals(obj.getGroupNo()) || "1023".equals(obj.getGroupNo())) {
					String num = (obj.getCount() == null || "".equals(obj.getCount())) ? String.valueOf(0) : obj.getCount();
					obj.setGroupName(obj.getGroupName() + "(" + num + ")");
				} else if (!"0".equals(obj.getGroupNo()) && obj.getTagCount() != null) {
//					obj.setGroupName(obj.getGroupName() + "(" + obj.getTagCount() + ")");
					count = count + Integer.valueOf(obj.getTagCount());
				}
			}
			for (CimFMmFTagGroup obj : list) {
				if ("0".equals(obj.getGroupNo())) {
					obj.setGroupName(obj.getGroupName() + "(" + count + ")");
				}
			}
		}
		ResultDto<List<CimFMmFTagGroup>> resultDto = new ResultDto<List<CimFMmFTagGroup>>(list);
		resultDto.setTotal(list.size());
		resultDto.setData(list);
		return resultDto;
	}

	/**
	 * 获取自定义标签分组树
	 *
	 * @return
	 */
	@GetMapping("/getCustomTree")
	public ResultDto<List<CimFMmFTagGroup>> getCustomTree() {
		List<CimFMmFTagGroup> list = this.cimFmmTagGroupService.getCustomTree("1023");
		return new ResultDto<List<CimFMmFTagGroup>>(list);
	}

	/**
	 * 获取自定义标签分组及标签树
	 *
	 * @return
	 */
	@GetMapping("/getTagsTree")
	public ResultDto<List<TagTree>> getTagsTree(String custId) {
		List<TagTree> list = this.cimFmmTagGroupService.getTagsTree("1023",custId);
		return new ResultDto<List<TagTree>>(list);
	}
	
	/**
	 * 获取系统标签分组树
	 *
	 * @return
	 */
	@GetMapping("/getSysTree")
	public ResultDto<List<CimFMmFTagGroup>> getSysTree() {
		List<CimFMmFTagGroup> list = this.cimFmmTagGroupService.getCustomTree("1");
		return new ResultDto<List<CimFMmFTagGroup>>(list);
	}
	
	/**
	 * 获取全部标签分组树
	 *
	 * @return
	 */
	@GetMapping("/getAllTree")
	public ResultDto<List<CimFMmFTagGroup>> getAllTree() {
		List<CimFMmFTagGroup> list = this.cimFmmTagGroupService.getCustomTree("1");
		list.addAll(this.cimFmmTagGroupService.getCustomTree("1023"));
		return new ResultDto<List<CimFMmFTagGroup>>(list);
	}
	
	/*
	 * 新增标签分组
	 */
	@PostMapping("/saveTagGroup")
	public ResultDto<CimFMmFTagGroup> saveTagGroup(@RequestBody CimFMmFTagGroup record) {
		QueryModel model = new QueryModel();
		model.setCondition("{\"groupName\":\"" + record.getGroupName() + "\"}");
		List<CimFMmFTagGroup> list = this.cimFmmTagGroupService.getByParentNo(model);
		ResultDto<CimFMmFTagGroup> resultDto = new ResultDto<CimFMmFTagGroup>();
		if (list.size() > 0) {
			resultDto.setCode(-1);
			resultDto.setMessage("标签分组名称已存在");
			return resultDto;
		}
		resultDto = new ResultDto<CimFMmFTagGroup>(this.cimFmmTagGroupService.saveTagGroup(record));
		resultDto.setCode(0);
		resultDto.setMessage("新增成功");
		return resultDto;
	}

	@PostMapping("/deleteTagGroup")
	public ResultDto<Integer> deleteTagGroup(@RequestBody QueryModel model) {
		return new ResultDto<Integer>(this.cimFmmTagGroupService.deleteTagGroup(model));
	}

	/**
	 * 标签分组维护
	 *
	 * @param record
	 * @return
	 */

	@PostMapping("/modifyTagGroup")
	public ResultDto<Integer> modifyTagGroup(@RequestBody CimFMmFTagGroup record) {
		QueryModel model = new QueryModel();
		model.setCondition("{\"parentNo\":\"1023\"}");
		ResultDto<Integer> resultDto = new ResultDto<Integer>();
		String groupName = this.cimFmmTagGroupService.getGroupName(record.getGroupNo());
		List<CimFMmFTagGroup> list = this.cimFmmTagGroupService.getByParentNo(model);
		for (CimFMmFTagGroup cimFMmFTagGroup: list) {
			if (record.getGroupName().equals(cimFMmFTagGroup.getGroupName()) && !groupName.equals(cimFMmFTagGroup.getGroupName())){
				resultDto.setCode(-1);
				resultDto.setMessage("标签分组名称已存在");
				return resultDto;
			}
		}
		return new ResultDto<Integer>(this.cimFmmTagGroupService.updateTagGroup(record));
	}

	/**
	 * 校验标签名称是否重复
	 *
	 * @param model
	 * @return
	 */
	@GetMapping("/getByParentNo")
	public ResultDto<List<CimFMmFTagGroup>> getByParentNo(QueryModel model) {
		List<CimFMmFTagGroup> list = this.cimFmmTagGroupService.getByParentNo(model);
		return new ResultDto<List<CimFMmFTagGroup>>(list);
	}

	/**
	 * 校验当前节点的上级节点是否为他的子节点,得到子节点
	 *
	 * @param model
	 * @return
	 */

	@GetMapping("/getChild")
	public ResultDto<List<CimFMmFTagGroup>> getChild(QueryModel model) {
		List<CimFMmFTagGroup> list = this.cimFmmTagGroupService.getChild(model);
		return new ResultDto<List<CimFMmFTagGroup>>(list);
	}
}
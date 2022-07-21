package cn.com.yusys.yscimc.marketmethod.web.rest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import com.google.common.io.ByteStreams;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yscimc.marketmethod.domain.CmicAppMarketActyInfo;
import cn.com.yusys.yscimc.marketmethod.service.CmicAppBulletinBoardService;
import cn.com.yusys.yscimc.marketmethod.service.CmicAppClickInfoService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * 
 * @项目名称：yscimc-app-mobile
 * @类名称：CmicAppBulletinBoardResource
 * @类描述：公告板资源类
 * @功能描述:营销方式公告板
 * @创建人：chenlin2@yusys.com.cn @创建时间：2019-06-11 @修改备注：
 * @修改日期 修改人员 修改原因 -------- -------- ----------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2019宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/cmicappbulletinboard")
public class CmicAppBulletinBoardResource extends CommonResource<Object, String> {

	private static final Logger log = getLogger(CmicAppBulletinBoardResource.class);

	@Value("${application.localDiskPath}")
	private String localDiskPath;

	@Autowired
	private CmicAppBulletinBoardService bulletinBoardService;
	@Autowired
	private CmicAppClickInfoService cmicAppClickInfoService;


	@Override
	protected CommonService getCommonService() {
		return bulletinBoardService;
	}

	/**
	 * @方法名称:clickinfo
	 * @方法描述:客户点击链接
	 * @param activityId    活动id
	 * @param recommenderId 推荐人id
	 * @param custId        客户id
	 * @param data          推荐页面json数据
	 * @return
	 */
	@RequestMapping("/clickinfo/{activityId}/{recommenderId}/{custId}/{data}")
	public ResultDto<Integer> clickinfo(@PathVariable String activityId, @PathVariable String recommenderId,
		@PathVariable String custId, @PathVariable String data) {
		return new ResultDto<>(cmicAppClickInfoService.clickinfo(activityId, recommenderId, custId, data));
	}
	
	/**
	 * 
	 * @方法名称:bulletinBoardQuery
	 * @方法描述:营销方式公告板
	 * @参数与返回说明:condition: {"channel":"渠道ID（组件ID）","hurdles":"栏位标识"}
	 * @算法描述:
	 */
	@GetMapping("/bbquery")
	public ResultDto<Map<String, List<Map<String,String>>>> bulletinBoardQuery(QueryModel queryModel) {
		return new ResultDto<>(bulletinBoardService.bulletinBoardQuery(queryModel));
	}
	/**
	 * 
	* @方法名称:getAssembleActy
	* @方法描述:根据节点ID获取拼团活动信息
	* @参数与返回说明:活动id（节点id）
	* @算法描述:
	 */
	@GetMapping("/getassembleacty")
	public ResultDto<CmicAppMarketActyInfo> getAssembleActy(@RequestParam(required = false) String nodeId){
		CmicAppMarketActyInfo actyInfo = bulletinBoardService.setActyInfo(nodeId);
		return new ResultDto<CmicAppMarketActyInfo>(actyInfo);
	}
	/**
	 * 
	* @方法名称:downloadFile
	* @方法描述:下载本地图片
	* @参数与返回说明:图片路径
	* @算法描述:
	 */
	@GetMapping("/download")
	public ResultDto<byte[]> downloadFile(@RequestParam(required = false) String fileId) {
		File file = new File(localDiskPath + File.separator + fileId);
		if (!file.exists()) {
			return null;
		}
		try (FileInputStream fileInputStream = new FileInputStream(file)) {
//			byte[] buff = fileToByte(fileInputStream, file.length());
			byte[] buff = ByteStreams.toByteArray(fileInputStream);
			return new ResultDto<>(buff);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}

	}

	private byte[] fileToByte(InputStream inStream, long fileLength) throws IOException {

		byte[] buffer = new byte[256 * 1024];
		byte[] fileBuffer = new byte[(int) fileLength];

		int count = 0;
		int length = 0;

		while ((length = inStream.read(buffer)) != -1) {
			for (int i = 0; i < length; ++i) {
				fileBuffer[count + i] = buffer[i];
			}
			count += length;
		}
		return fileBuffer;
	}
}

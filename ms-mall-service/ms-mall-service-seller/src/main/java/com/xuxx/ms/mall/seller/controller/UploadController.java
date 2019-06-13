package com.xuxx.ms.mall.seller.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.xuxx.ms.mall.constants.CodeMsgConstants;
import com.xuxx.ms.mall.entity.Result;
import com.xuxx.ms.mall.util.FastDFSClient;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class UploadController {

	@Value("${file.server.url}")
	private String file_server_url;

	@RequestMapping("/upload")
	public Result<String> upload(MultipartFile file) {
		if (file == null) {
			return Result.error(CodeMsgConstants.FILE_IS_EMPTY);
		}
		// 获取文件名
		String originalFilename = file.getOriginalFilename();
		// 得到扩展名
		String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);

		try {
			FastDFSClient client = new FastDFSClient("classpath:config/fdfs_client.conf");
			String fileId = client.uploadFile(file.getBytes(), extName);
			String url = file_server_url + fileId;// 图片完整地址
			return Result.success(url);

		} catch (Exception e) {
			log.error("文件上传", e);
			return Result.error(CodeMsgConstants.FILE_UPLOAD_FAIL, "上传失败");
		}
	}
}

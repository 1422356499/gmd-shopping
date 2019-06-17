package com.springcloud.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.springcloud.common.UploadUtils;
import com.springcloud.vo.ResultValue;

/**
 * 用于用户图片
 * 
 * @author 吴榕兴
 *
 */
@RestController
public class FileUploadController {

	// 从application.properties文件中获得指定键的值,并赋值给相应的成员变量
	@Value("${web.user-path}")
	private String userPath;

	@Value("${web.goods-path}")
	private String goodsPath;

	/**
	 * 用户头像上传
	 * 
	 * @param file 上传头像图片
	 * @return
	 */
	@RequestMapping(value = "/userUpload")
	public ResultValue userUpload(@RequestParam("userImage") MultipartFile file) {
		ResultValue rv = new ResultValue();

		try {
			Map<String, Object> map = fileUpload(file, userPath);

			if (map != null && map.size() > 0) {
				rv.setDataMap(map);
				rv.setCode(0);

				return rv;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		rv.setMessage("用户头像上传失败");
		return rv;
	}

	/**
	 * 用户头像上传
	 * 
	 * @param file 上传头像图片
	 * @return
	 */
	@RequestMapping(value = "/goodsUpload")
	public ResultValue goodsUpload(@RequestParam("goodsImage") MultipartFile file) {
		ResultValue rv = new ResultValue();

		try {
			Map<String, Object> map = fileUpload(file, goodsPath);

			if (map != null && map.size() > 0) {
				rv.setDataMap(map);
				rv.setCode(0);

				return rv;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		rv.setMessage("商品图片上传失败");
		return rv;
	}

	@RequestMapping(value = "/deleteGoodsImg")
	public ResultValue deleteGoodsImg(@RequestParam("goodsImg") String goodsImg) {
		ResultValue rv = new ResultValue();
		try {
			// 从URL中获得商品的名字
			int indexOf = goodsImg.lastIndexOf("/");
			if (indexOf != -1) {
				String fileName = goodsImg.substring(indexOf + 1);
				// System.out.println(fileName);
				File file = new File(this.goodsPath + fileName);
				file.delete();
				rv.setCode(0);
				
				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		rv.setMessage("商品图片删除失败");
		return rv;
	}
	
	/**
	 * 上传文件头像
	 * @param userImg	上传的名称
	 * @return
	 */
	@RequestMapping(value = "/deleteUserImg")
	public ResultValue deleteUserImg(@RequestParam("userImg") String userImg) {
		ResultValue rv = new ResultValue();
		try {
			// 从URL中获得商品的名字
			int indexOf = userImg.lastIndexOf("/");
			if (indexOf != -1) {
				String fileName = userImg.substring(indexOf + 1);
				// System.out.println(fileName);
				File file = new File(this.userPath + fileName);
				file.delete();
				rv.setCode(0);
				
				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		rv.setMessage("用户 头像图片删除失败");
		return rv;                                                                                                                                     
	}

	/**
	 * 上传文件
	 * 
	 * @param file 需要上传的文件
	 * @param path 上传文件的路径
	 * @return 成功返回java.util.Map类型的实例,失败返回Null
	 */
	private Map<String, Object> fileUpload(MultipartFile file, String path) throws IOException {
		Map<String, Object> map = null;

		// 获得新的文件名
		String fileName = UploadUtils.getFileName();

		// 获得上传文件的文件名获得文件的扩展名
		String extendedName = UploadUtils.getExendedName(file.getOriginalFilename());
		// 上传文件
		// 1、将文件转化为字节码的数组
		byte[] bytes = file.getBytes();
		// 2、创建新的File类的对象，并设置新的路径及文件名
		File saveFile = new File(path + fileName + extendedName);
		// 3、上传文件
		FileCopyUtils.copy(bytes, saveFile);

		map = new HashMap<>();
		map.put("fileName", fileName);
		map.put("extendedName", extendedName);

		return map;
	}
}

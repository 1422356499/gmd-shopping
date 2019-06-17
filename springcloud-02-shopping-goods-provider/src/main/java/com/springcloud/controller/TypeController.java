package com.springcloud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.entity.TypeOne;
import com.springcloud.entity.TypeTwo;
import com.springcloud.service.TypeService;
import com.springcloud.vo.ResultValue;

@RestController
@RequestMapping("type")
public class TypeController {

	@Autowired
	private TypeService typeService;

	/**
	 * 查询所有的一级类别
	 * @return 返回com.springcloud.vo.ResultValue类型的实例
	 */
	@RequestMapping(value = "/selectAll")
	public ResultValue selectAll() {
		ResultValue rv = new ResultValue();
		try {
			List<TypeOne> selectAllTypeOne = this.typeService.selectAllTypeOne();
			if(selectAllTypeOne != null && selectAllTypeOne.size() > 0) {
				rv.setCode(0);
				Map<String, Object> map = new HashMap<>();
				map.put("typeOneList", selectAllTypeOne);
				rv.setDataMap(map);
				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		rv.setMessage("查询一级类别失败");
		return rv;
	}
	
	
	/**
	 * 根据一级类别编号查询相应的二级类别信息
	 * 
	 * @param typeOneId 一级类别编号
	 * @return 返回com.springcloud.vo.ResultValue类型的实例
	 */
	@RequestMapping(value = "/selectByTypeOneId")
	public ResultValue selectByTypeOneId(Integer typeOneId) {
		ResultValue rv = new ResultValue();
		try {
			List<TypeTwo> selectAllTypeTwoId = this.typeService.selectAllTypeTwoId(typeOneId);
			if(selectAllTypeTwoId != null && selectAllTypeTwoId.size() > 0) {
				rv.setCode(0);
				Map<String, Object> map = new HashMap<>();
				map.put("typeTwoList", selectAllTypeTwoId);
				rv.setDataMap(map);
				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		rv.setMessage("查询一级类别所对应二级类别信息失败");
		return rv;
	}
}

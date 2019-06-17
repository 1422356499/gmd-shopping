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
	 * ��ѯ���е�һ�����
	 * @return ����com.springcloud.vo.ResultValue���͵�ʵ��
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
		rv.setMessage("��ѯһ�����ʧ��");
		return rv;
	}
	
	
	/**
	 * ����һ������Ų�ѯ��Ӧ�Ķ��������Ϣ
	 * 
	 * @param typeOneId һ�������
	 * @return ����com.springcloud.vo.ResultValue���͵�ʵ��
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
		rv.setMessage("��ѯһ���������Ӧ���������Ϣʧ��");
		return rv;
	}
}

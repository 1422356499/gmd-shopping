package com.springcloud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springcloud.dao.OrderDetailsMapper;
import com.springcloud.entity.OrderDetails;
import com.springcloud.service.OrderDetailsService;

/**
 * ������ϸģ��ģ�Ͳ��ʵ���ࣺ����ʵ�ֶ�����ϸģ�͵ķ���
 * 
 * @author ������
 *
 */
@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {

	@Autowired
	private OrderDetailsMapper orderDateilsMapper;

	@Override
	public PageInfo<OrderDetails> selectByOrderId(Integer orderId, Integer pageNumber) {
		PageHelper.startPage(pageNumber + 1, 5);
		List<OrderDetails> list = this.orderDateilsMapper.selectByOrderId(orderId);
		return new PageInfo<>(list);
	}

}

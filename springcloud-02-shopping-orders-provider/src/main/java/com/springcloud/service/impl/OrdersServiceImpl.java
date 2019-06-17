package com.springcloud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springcloud.common.PageUtils;
import com.springcloud.dao.OrdersMapper;
import com.springcloud.entity.Orders;
import com.springcloud.service.OrdersService;

@Service
public class OrdersServiceImpl  implements OrdersService{

	@Autowired
	public OrdersMapper ordersMapper;
	
	@Transactional
	@Override
	public int deleteByPrimaryKey(Integer orderId) {
		return this.ordersMapper.deleteByPrimaryKey(orderId);
	}

	@Transactional
	@Override
	public int insert(Orders record) {
		return this.ordersMapper.insert(record);
	}

	@Override
	public Orders selectByPrimaryKey(Integer orderId) {
		return this.ordersMapper.selectByPrimaryKey(orderId);
	}

	@Override
	public List<Orders> selectAll() {
		return this.ordersMapper.selectAll();
	}

	@Transactional
	@Override
	public int updateByPrimaryKey(Orders record) {
		return this.ordersMapper.updateByPrimaryKey(record);
	}

	@Override
	public PageInfo<Orders> selectOrders(Orders orders,Integer pageNumber) {
		if(orders.getUser() != null) {
			orders.getUser().setUserName("%" + orders.getUser().getUserName() + "%");
		}
		PageHelper.startPage(pageNumber + 1,PageUtils.PAGE_ROW_COUNT);
		List<Orders> list = this.ordersMapper.selectOrders(orders);
		return new PageInfo<>(list);
	}

	@Transactional
	@Override
	public Integer updateOrdersStatus(Orders orders) {
		return this.ordersMapper.updateOrdersStatus(orders);
	}

	@Override
	public List<Orders> selectGroup(Orders orders) {
		return this.ordersMapper.selectGroup(orders);
	}

}

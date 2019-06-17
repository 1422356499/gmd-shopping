package com.springcloud.service;

import com.github.pagehelper.PageInfo;
import com.springcloud.entity.OrderDetails;


/**
 * 订单明细模块模型层的接口：用于定义订单明细模型的方法
 * 
 * @author 吴榕兴
 *
 */
public interface OrderDetailsService {
	/**
	 * 查询指定编号的订单明细信息
	 * 
	 * @param orderId 订单编号
	 * @param pageNumber 分页信息
	 * @return 成功返回com.github.pagehelper.PageInfo类型的实例,否则返回null
	 */
	public abstract PageInfo<OrderDetails> selectByOrderId(Integer orderId, Integer pageNumber);
}

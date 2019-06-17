package com.springcloud.service;

import java.util.List;


import com.github.pagehelper.PageInfo;
import com.springcloud.entity.Orders;

/**
 * 订单模块模型层的接口：用于定义订单模型的方法
 * 
 * @author 吴榕兴
 *
 */
public interface OrdersService {

	public int deleteByPrimaryKey(Integer orderId);

	public int insert(Orders record);

	public Orders selectByPrimaryKey(Integer orderId);

	public List<Orders> selectAll();

	public int updateByPrimaryKey(Orders record);

	/**
	 * 查询满足条件的订单的信息(分页功能)
	 * 
	 * @param orders 查询条件
	 * @return 成功返回com.github.pagehelper.PageInfo类型的实例，失败返回Null
	 */
	public abstract PageInfo<Orders> selectOrders(Orders orders,Integer pageNumber);
	
	/**
     *	修改ORDERS表中指定ORDER_ID的订单信息
     * @param orders	修改订单的信息
     * @return	成功返回大于0的整数,失败返回0
     */
    public abstract Integer updateOrdersStatus(Orders orders);
    
    /**
     * 查询每个月的销售总额
     * @param orders	查询条件
     * @return	成功返回java.util.List类型的实例,否则返回null
     */
    public abstract List<Orders> selectGroup(Orders orders);
}

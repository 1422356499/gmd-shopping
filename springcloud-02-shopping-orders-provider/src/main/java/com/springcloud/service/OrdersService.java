package com.springcloud.service;

import java.util.List;


import com.github.pagehelper.PageInfo;
import com.springcloud.entity.Orders;

/**
 * ����ģ��ģ�Ͳ�Ľӿڣ����ڶ��嶩��ģ�͵ķ���
 * 
 * @author ������
 *
 */
public interface OrdersService {

	public int deleteByPrimaryKey(Integer orderId);

	public int insert(Orders record);

	public Orders selectByPrimaryKey(Integer orderId);

	public List<Orders> selectAll();

	public int updateByPrimaryKey(Orders record);

	/**
	 * ��ѯ���������Ķ�������Ϣ(��ҳ����)
	 * 
	 * @param orders ��ѯ����
	 * @return �ɹ�����com.github.pagehelper.PageInfo���͵�ʵ����ʧ�ܷ���Null
	 */
	public abstract PageInfo<Orders> selectOrders(Orders orders,Integer pageNumber);
	
	/**
     *	�޸�ORDERS����ָ��ORDER_ID�Ķ�����Ϣ
     * @param orders	�޸Ķ�������Ϣ
     * @return	�ɹ����ش���0������,ʧ�ܷ���0
     */
    public abstract Integer updateOrdersStatus(Orders orders);
    
    /**
     * ��ѯÿ���µ������ܶ�
     * @param orders	��ѯ����
     * @return	�ɹ�����java.util.List���͵�ʵ��,���򷵻�null
     */
    public abstract List<Orders> selectGroup(Orders orders);
}

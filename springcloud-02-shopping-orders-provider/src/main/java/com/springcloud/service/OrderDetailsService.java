package com.springcloud.service;

import com.github.pagehelper.PageInfo;
import com.springcloud.entity.OrderDetails;


/**
 * ������ϸģ��ģ�Ͳ�Ľӿڣ����ڶ��嶩����ϸģ�͵ķ���
 * 
 * @author ������
 *
 */
public interface OrderDetailsService {
	/**
	 * ��ѯָ����ŵĶ�����ϸ��Ϣ
	 * 
	 * @param orderId �������
	 * @param pageNumber ��ҳ��Ϣ
	 * @return �ɹ�����com.github.pagehelper.PageInfo���͵�ʵ��,���򷵻�null
	 */
	public abstract PageInfo<OrderDetails> selectByOrderId(Integer orderId, Integer pageNumber);
}

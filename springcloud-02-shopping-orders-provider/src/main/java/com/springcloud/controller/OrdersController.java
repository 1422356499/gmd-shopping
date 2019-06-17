package com.springcloud.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.springcloud.common.PageUtils;
import com.springcloud.entity.Orders;
import com.springcloud.service.OrdersService;
import com.springcloud.vo.ResultValue;

/**
 * �����Ŀ��Ʋ�
 * 
 * @author ������
 *
 */
@RestController
@RequestMapping("orders")
public class OrdersController {

	@Autowired
	private OrdersService ordersServer;

	/**
	 * ��ѯ���������Ķ�������Ϣ(��ҳ����)
	 * 
	 * @param orders     ��ѯ����
	 * @param pageNumber ҳ��
	 * @return
	 */
	@RequestMapping(value = "/selectOrders")
	public ResultValue selectOrders(Orders orders, @RequestParam("pageNumber") Integer pageNumber) {
		ResultValue rv = new ResultValue();

		try {
			PageInfo<Orders> pageInfo = this.ordersServer.selectOrders(orders, pageNumber);
			List<Orders> list = pageInfo.getList();
			if (list != null && list.size() > 0) {
				rv.setCode(0);
				rv.setMessage("��ѯ������Ϣ�ɹ�");
				Map<String, Object> map = new HashMap<>();
				map.put("ordersList", list);

				PageUtils pageUtils = new PageUtils(pageInfo.getPages() * PageUtils.PAGE_ROW_COUNT);
				pageUtils.setPageNumber(pageNumber);
				map.put("pageUtils", pageUtils);

				rv.setDataMap(map);

				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		rv.setMessage("��ѯ������Ϣʧ��");

		return rv;
	}

	/**
	 * �޸Ķ�����״̬
	 * 
	 * @param orders ��ѯ����
	 * @return
	 */
	@RequestMapping(value = "/updateOrdersStatus")
	public ResultValue updateOrdersStatus(Orders orders) {
		ResultValue rv = new ResultValue();

		try {
			Integer updateOrdersStatus = this.ordersServer.updateOrdersStatus(orders);
			if (updateOrdersStatus != 0) {
				rv.setCode(0);
				rv.setMessage("�޸Ķ���״̬�ɹ�");

				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		rv.setMessage("�޸Ķ���״̬ʧ��");

		return rv;
	}

	/**
	 * ��ѯÿ���µ������ܶ�
	 * 
	 * @param orders ��ѯ����
	 * @return
	 */
	@RequestMapping(value = "/selectGroup")
	public ResultValue selectGroup(Orders orders) {
		ResultValue rv = new ResultValue();

		try {
			List<Orders> selectGroup = this.ordersServer.selectGroup(orders);
			if (selectGroup != null && selectGroup.size() > 0) {
				rv.setCode(0);
				rv.setMessage("��ѯÿ���µ������ܶ�ɹ�");
				ArrayList<String> x = new ArrayList<>();
				ArrayList<Integer> y = new ArrayList<>();
				for (Orders order : selectGroup) {
					x.add(order.getOrderMonth());
					y.add(order.getOrderSum());
				}
				Map<String, Object> map = new HashMap<>();
				map.put("x", x);
				map.put("y", y);
				rv.setDataMap(map);

				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		rv.setMessage("��ѯÿ���µ������ܶ�ʧ��");

		return rv;
	}
}

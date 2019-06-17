package com.springcloud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.springcloud.common.PageUtils;
import com.springcloud.entity.OrderDetails;
import com.springcloud.service.OrderDetailsService;
import com.springcloud.vo.ResultValue;


/**
 * ������ϸ�Ŀ��Ʋ�
 * 
 * @author ������
 *
 */
@RestController
@RequestMapping("orderDetails")
public class OrderDetailsController {
	
	@Autowired
	private OrderDetailsService orderDetailsService;
	
	/**
	 * ��ѯ���������Ķ����������Ϣ(��ҳ����)
	 * 
	 * @param orderId     ��ѯ����
	 * @param pageNumber ҳ��
	 * @return
	 */
	@RequestMapping(value = "/selectByOrders")
	public ResultValue selectByOrders(@RequestParam("orderId") Integer orderId, @RequestParam("pageNumber") Integer pageNumber) {
		ResultValue rv = new ResultValue();

		try {
			PageInfo<OrderDetails> pageInfo = this.orderDetailsService.selectByOrderId(orderId, pageNumber);
			List<OrderDetails> list = pageInfo.getList();
			if (list != null && list.size() > 0) {
				rv.setCode(0);
				rv.setMessage("��ѯ����������Ϣ�ɹ�");
				Map<String, Object> map = new HashMap<>();
				map.put("orderDetailsList", list);

				PageUtils pageUtils = new PageUtils(5,pageInfo.getPages() * 5);
				pageUtils.setPageNumber(pageNumber);
				map.put("pageUtils", pageUtils);

				rv.setDataMap(map);

				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		rv.setMessage("��ѯ����������Ϣʧ��");

		return rv;
	}
}
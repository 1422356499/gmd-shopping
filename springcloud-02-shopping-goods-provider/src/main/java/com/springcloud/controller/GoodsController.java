package com.springcloud.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.springcloud.common.PageUtils;
import com.springcloud.entity.Goods;
import com.springcloud.service.GoodsService;
import com.springcloud.vo.ResultValue;

/**
 * ��Ʒ�Ŀ��Ʋ�
 * 
 * @author ������
 *
 */
@RestController
@RequestMapping("goods")
public class GoodsController {

	@Autowired
	private GoodsService goodsService;
	private List<Goods> list;

	/**
	 * ����µ���Ʒ��Ϣ
	 * 
	 * @param goods ����Ʒ��Ϣ
	 * @return
	 */
	@RequestMapping(value = "/insert")
	public ResultValue insert(Goods goods) {
		ResultValue rv = new ResultValue();

		try {
			Integer insert = this.goodsService.insert(goods);
			if (insert > 0) {
				rv.setCode(0);
				rv.setMessage("��Ʒ��Ϣ¼��ɹ�");
				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		rv.setCode(1);
		rv.setMessage("��Ʒ��Ϣ¼��ʧ��");

		return rv;
	}

	/**
	 * ��ѯ��Ʒ��Ϣ
	 * 
	 * @param goods      ��ѯ���
	 * @param pageNumber ��ҳ����
	 * @return
	 */
	@RequestMapping(value = "/select")
	public ResultValue select(Goods goods, @RequestParam("pageNumber") Integer pageNumber) {
		ResultValue rv = new ResultValue();

		try {
			PageInfo<Goods> pageInfo = this.goodsService.select(goods, pageNumber);
			list = pageInfo.getList();
			if (list != null && list.size() > 0) {
				rv.setCode(0);
				rv.setMessage("��ѯ��Ʒ��Ϣ�ɹ�");
				Map<String, Object> map = new HashMap<>();
				map.put("goodsList", list);

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
		rv.setMessage("��ѯ��Ʒ��Ϣʧ��");

		return rv;
	}

	/**
	 * �޸���Ʒ��Ϣ(����,��Ʒ,״̬,��ƷͼƬ)
	 * 
	 * @param goods �޸���Ʒ��Ϣ
	 * @return
	 */
	@RequestMapping(value = "/updateById")
	public ResultValue updateById(Goods goods) {
		ResultValue rv = new ResultValue();

		try {
			Integer updateGoodsById = this.goodsService.updateGoodsById(goods);
			if (updateGoodsById != null) {
				rv.setCode(0);
				rv.setMessage("��Ʒ��Ϣ�޸ĳɹ�");

				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		rv.setMessage("��Ʒ��Ϣ�޸�ʧ��");

		return rv;
	}

	/**
	 * �޸���Ʒ��Ϣ
	 * 
	 * @param goods �޸���Ʒ��Ϣ
	 * @return
	 */
	@RequestMapping(value = "/update")
	public ResultValue update(Goods goods) {
		ResultValue rv = new ResultValue();

		try {
			Integer update = this.goodsService.update(goods);
			if (update != null) {
				rv.setCode(0);
				rv.setMessage("��Ʒ��Ϣ�޸ĳɹ�");

				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		rv.setMessage("��Ʒ��Ϣ�޸�ʧ��");

		return rv;
	}

	/**
	 * ��ѯ����ǰʮ����Ʒ���ƺ���������
	 * 
	 * @return
	 */
	@RequestMapping(value = "/selectGroup")
	public ResultValue selectGroup() {
		ResultValue rv = new ResultValue();

		try {
			List<Goods> goodsGroup = this.goodsService.goodsGroup();
			if (goodsGroup != null && goodsGroup.size() > 0) {
				rv.setCode(0);
				rv.setMessage("��ѯ����ǰʮ����Ʒ���ƺ����������ɹ�");
				ArrayList<String> x = new ArrayList<>();
				ArrayList<Integer> y = new ArrayList<>();
				for(Goods goods : goodsGroup) {
					x.add(goods.getGoodsName());
					y.add(goods.getGoodsFinalNum());
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
		rv.setMessage("��ѯ����ǰʮ����Ʒ���ƺ���������ʧ��");

		return rv;
	}
}

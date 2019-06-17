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
 * 商品的控制层
 * 
 * @author 吴榕兴
 *
 */
@RestController
@RequestMapping("goods")
public class GoodsController {

	@Autowired
	private GoodsService goodsService;
	private List<Goods> list;

	/**
	 * 添加新的商品信息
	 * 
	 * @param goods 新商品信息
	 * @return
	 */
	@RequestMapping(value = "/insert")
	public ResultValue insert(Goods goods) {
		ResultValue rv = new ResultValue();

		try {
			Integer insert = this.goodsService.insert(goods);
			if (insert > 0) {
				rv.setCode(0);
				rv.setMessage("商品信息录入成功");
				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		rv.setCode(1);
		rv.setMessage("商品信息录入失败");

		return rv;
	}

	/**
	 * 查询商品信息
	 * 
	 * @param goods      查询添加
	 * @param pageNumber 分页条件
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
				rv.setMessage("查询商品信息成功");
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
		rv.setMessage("查询商品信息失败");

		return rv;
	}

	/**
	 * 修改商品信息(热卖,新品,状态,商品图片)
	 * 
	 * @param goods 修改商品信息
	 * @return
	 */
	@RequestMapping(value = "/updateById")
	public ResultValue updateById(Goods goods) {
		ResultValue rv = new ResultValue();

		try {
			Integer updateGoodsById = this.goodsService.updateGoodsById(goods);
			if (updateGoodsById != null) {
				rv.setCode(0);
				rv.setMessage("商品信息修改成功");

				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		rv.setMessage("商品信息修改失败");

		return rv;
	}

	/**
	 * 修改商品信息
	 * 
	 * @param goods 修改商品信息
	 * @return
	 */
	@RequestMapping(value = "/update")
	public ResultValue update(Goods goods) {
		ResultValue rv = new ResultValue();

		try {
			Integer update = this.goodsService.update(goods);
			if (update != null) {
				rv.setCode(0);
				rv.setMessage("商品信息修改成功");

				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		rv.setMessage("商品信息修改失败");

		return rv;
	}

	/**
	 * 查询销量前十的商品名称和销售数量
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
				rv.setMessage("查询销量前十的商品名称和销售数量成功");
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
		rv.setMessage("查询销量前十的商品名称和销售数量失败");

		return rv;
	}
}

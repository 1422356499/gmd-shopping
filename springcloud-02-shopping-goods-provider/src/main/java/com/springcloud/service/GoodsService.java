package com.springcloud.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.springcloud.entity.Goods;

/**	
 * 商品模型层:用于定于对商品模块进行操作的方法 
 * @author 吴榕兴
 *
 */
public interface GoodsService {
	/**
	 * 添加新的商品信息
	 * 
	 * @param goods 新商品信息
	 * @return 成功返回大于0,否则返回0
	 */
	public abstract Integer insert(Goods goods);

	/**
	 * 查询商品详细信息
	 * 
	 * @param goods
	 * @param pageNumber 分页信息
	 * @return 成功返回com.github.pagehelper.PageInfo,失败返回null
	 */
	public PageInfo<Goods> select(Goods goods, Integer pageNumber);

	/**
	 * 根据添加修改商品信息
	 * 
	 * @param goods 修改商品的信息
	 * @return 成功返回大于0的整数,否则返回小于0的整数
	 */
	public abstract Integer updateGoodsById(Goods goods);

	/**
	 * 根据添加修改商品信息
	 * 
	 * @param goods 修改商品的信息
	 * @return 成功返回大于0的整数,否则返回小于0的整数
	 */
	public abstract Integer update(Goods goods);
	
	
	/**
	 * 查询销量前十的商品名称和销售数量
	 * @return 成功返回java.util.List类型,失败返回null
	 */
	public abstract List<Goods> goodsGroup();
}

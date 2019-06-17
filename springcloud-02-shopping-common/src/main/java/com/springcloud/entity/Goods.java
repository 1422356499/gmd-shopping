package com.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goods implements java.io.Serializable {
	private static final long serialVersionUID = 1283543195006501908L;

	/**
	 * 商品编号
	 */
	private Integer goodsId;

	/**
	 * 商品名称
	 */
	private String goodsName;

	/**
	 * 商品价格
	 */
	private Double goodsPrice;

	/**
	 * 商品折扣价
	 */
	private Double goodsDiscount;

	/**
	 * 商品状态：0上架，1下架
	 */
	private Integer goodsStatus;

	/**
	 * 商品数量
	 */
	private Integer goodsNum;

	/**
	 * 是否新品：0是新品，1不是新品
	 */
	private Integer goodsNew;

	/**
	 * 是否热卖：0是热卖，1不是热卖
	 */
	private Integer goodsHot;

	/**
	 * 商品级别：0一星，1二星，2三星，3四星，4五星
	 */
	private Integer goodsLevel;

	/**
	 * 商品简介
	 */
	private String goodsDesc;

	/**
	 * 商品详情
	 */
	private String goodsDetail;

	/**
	 * 商品图片
	 */
	private String goodsImg;

	/**
	 * 类型二编号
	 */
	private Integer typeTwoId;

	/**
	 * 查询条件:商品价格下限
	 */
	private Double goodsPriceMin;

	/**
	 * 查询条件:商品价格上线
	 */
	private Double goodsPriceMax;
	
	/**
	 * 类型二编号
	 */
	private Integer typeOneId;
	
	/**
	 * 销售数量
	 */
	private Integer goodsFinalNum;
}
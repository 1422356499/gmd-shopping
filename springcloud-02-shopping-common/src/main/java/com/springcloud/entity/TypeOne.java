package com.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TypeOne implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3319230104102298435L;

	/**
	 * 类型一编号
	 */
	private Integer typeOneId;

	/**
	 * 类型一名称
	 */
	private String typeOneName;

	/**
	 * 序号
	 */
	private Integer typeOneNum;

	/**
	 * 备注
	 */
	private String typeOneRemark;
}
package com.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TypeTwo implements java.io.Serializable {
	
	private static final long serialVersionUID = 954494404076992660L;

	/**
	 * 类型二编号
	 */
	private Integer typeTwoId;

	/**
	 * 类型二名称
	 */
	private String typeTwoName;

	/**
	 * 类型一编号
	 */
	private Integer typeOneId;

	/**
	 * 备注
	 */
	private String typeTwoRemark;
}
package com.springcloud.vo;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultValue implements java.io.Serializable {

	private static final long serialVersionUID = -7333058567132357663L;
	
	private Integer code;
	
	private String message;
	
	private Map<String,Object> dataMap;
}

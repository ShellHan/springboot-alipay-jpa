package com.springboot.common.constants;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ListResult {
	private Integer count;
	private String msg;
	private String data;
	private String code;
}

package com.springboot.common.constants;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ResultDTO<T> {

	private String status;
	private String msg;
	private T data;
	private String errorCode;
	
}

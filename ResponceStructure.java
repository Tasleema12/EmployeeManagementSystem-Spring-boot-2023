package com.jspr.springBootBasic.Dto;

import lombok.Data;

@Data
public class ResponceStructure<T> {
	String meesage;
	int status;
	T data;

}

package org.ict.domain;

import lombok.Data;

@Data
public class BaseVO {
	// 컨트롤러가 해당 변수들을 url 파라미터로 수집함.
	private String name;
	private int age;
	private String job;
	
	
}

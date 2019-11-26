package com.darian.noomainstream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;

@SpringBootApplication
public class NooMainstreamApplication {

	public static void main(String[] args) {
		SpringApplication.run(NooMainstreamApplication.class, args);
	}


	// 版本意识
	//		JAVA 7
	// 		JAVA 8
	private void updata(Map<String, Object> source){
		if(source == null || source.isEmpty()){
			return ;
		}
	}


}


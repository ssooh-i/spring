package com.ssafy.ws;

import org.springframework.stereotype.Component;

@Component(value = "k3")
public class K3 implements Car {

	@Override
	public String getInfo() {
		return "K3";
	}

}

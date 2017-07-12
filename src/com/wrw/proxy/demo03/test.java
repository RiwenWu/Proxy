package com.wrw.proxy.demo03;

import static org.junit.Assert.*;

import java.io.Serializable;

import org.junit.Test;

public class test {

	@Test
	public void test() throws Exception{
		
		moveable m = (moveable)Proxy.newProxyInstance(moveable.class);
		
	}
	
}

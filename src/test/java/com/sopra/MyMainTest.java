package com.sopra;

import org.junit.jupiter.api.Test;

public class MyMainTest {

	@Test
	public void testFail() {
		//assert(false);
	}
	
	@Test
	public void testing() {
		assert(new MyMain().getTheString().equals("this is my main"));
	}

}
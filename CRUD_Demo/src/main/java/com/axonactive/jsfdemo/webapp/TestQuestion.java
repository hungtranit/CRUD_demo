package com.axonactive.jsfdemo.webapp;

public class TestQuestion {

	public static void main(String[] args) {
		final int ARRAY_SIZE = 5;
		double[] x = new double[ARRAY_SIZE];
		for (int i = 0; i < ARRAY_SIZE; i++) {
			x[i] = 10.0;
		}
		System.out.println(x[4]);

	}

}

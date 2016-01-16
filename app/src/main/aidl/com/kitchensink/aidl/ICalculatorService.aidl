package com.kitchensink.aidl;

// Declare any non-default types here with import statements

interface ICalculatorService {
	
	
	int add(int a, int b);
	
	double average(in double[] doubles);
	
}
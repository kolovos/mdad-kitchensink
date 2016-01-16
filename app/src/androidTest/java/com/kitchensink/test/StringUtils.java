package com.kitchensink.test;

import java.util.Random;

public class StringUtils {
	
	public static String getRandomString(int length) {
	    Random generator = new Random();
	    StringBuilder randomStringBuilder = new StringBuilder();
	    int randomLength = generator.nextInt(length);
	    char tempChar;
	    for (int i = 0; i < randomLength; i++){
	        tempChar = (char) (generator.nextInt(96) + 32);
	        randomStringBuilder.append(tempChar);
	    }
	    return randomStringBuilder.toString();
	}
}

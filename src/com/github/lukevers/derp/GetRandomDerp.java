package com.github.lukevers.derp;

import java.util.ArrayList;
import java.util.Random;

public class GetRandomDerp {
	
	public GetRandomDerp () {
		super();
	}//close constructor
	
    String getRandomDerp(ArrayList <String> doublederps) {
    	Random rand = new Random();
    	if (doublederps.size() > 0) {
    		int r = rand.nextInt(doublederps.size());
        	return doublederps.get(r);
    		}
    	else return "";
        }//close getRandomDerp
	
}//close GetRandomDerp

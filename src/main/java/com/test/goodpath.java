package com.test;

import com.test.calculate.calculatepath;
import com.test.myworld.worldgraph;

public class goodpath {



	public static void main(String[] args) {
		worldgraph wg = new worldgraph();
		for (int i = 0; i< wg.datamap.length ; i++){
			for (int j = 0; j< wg.datamap.length ; j++){
				if (i == 0 || j==0) {
					System.out.print(wg.datamap[i][j] + "\t");
				}else {
					String maxdata ;
					if (wg.getMatrix()[i-1][j-1] == Integer.MAX_VALUE){
						maxdata = "MAX";
					}else{
						maxdata = String.valueOf(wg.getMatrix()[i-1][j-1]);
					}
					System.out.print(maxdata);
				}
			}
			System.out.print("\r\n");
		}
		System.out.println(calculatepath.shortestPathDijstra(wg.getMatrix() , 2 , 5).getCost());
	}
}

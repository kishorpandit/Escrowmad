package com.info;

import java.util.Scanner;

public class ArrayTest {
	
	

	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 System.out.println("Enter the size of matrix: ");
		 int noOfmatrix = sc.nextInt();
		 System.out.println("Enter the "+noOfmatrix*noOfmatrix+" elements :");
		 for(int i=0; i<noOfmatrix*noOfmatrix; i++) {
			 int num = sc.nextInt();
		 }
		// (type[]) collection.toArray(new type[collection.size()])
		 
		// int[][] arr = {{1,2,3},{4,5,6}};
		 
		for(int i=0; i<noOfmatrix; i++) {
			for(int j=i; j<noOfmatrix; j++) {
				
		//	 System.out.print(num[i][j]);	
			 System.out.print(" ");
			}
		}
		
	}

}

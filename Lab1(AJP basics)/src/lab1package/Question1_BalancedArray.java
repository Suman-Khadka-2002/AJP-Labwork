package lab1package;

import java.util.Scanner;

public class Question1_BalancedArray {

	public static void main(String[] args) {
		
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter the number of elements in the array: ");
			int n = sc.nextInt();
			
			int arr[]= new int[n];
			System.out.println("Enter the elements: ");
			
			for (int i=0; i<n; i++) {
				arr[i] = sc.nextInt();
			}

			int result = isBalanced(arr);
			if (result == 1) {
				System.out.println("the array is balanced.");
			} else {
				System.out.println("the array is not balanced.");
			}
		}
	}
	
	public static int isBalanced(int[] arr) {
		for (int i=0; i<arr.length; i++) {
			if (i%2 == 0 && arr[i]%2 != 0) { //index and element of index is checked whether it is even
				return 0;
			}
			else if(i%2!=0 && arr[i]%2==0) {
				return 0;
			}
		}
		return 1;
	}
}


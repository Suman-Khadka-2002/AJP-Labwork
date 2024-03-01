package lab1package;

import java.util.Scanner;

public class OneDArray {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the size of the array: ");
		int n = input.nextInt();
		
		int arr[] = new int[n];
		System.out.println("Enter the elements of the array: ");
		for (int i=0; i<n; i++) {
			arr[i] = input.nextInt();
		}
		input.close();
		
		int result = addArray(arr);
		System.out.println("The sum of elements of the one dimensional array is: "+ result);
		
	}
	public static int addArray(int[] arr) {
		int sum = 0;
		for (int i=0; i<arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	} 
}

package jalgorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Pro1 {

	public static void main(String[] args) {
		String[] message = new String[100]; 
		Scanner scan = new Scanner(System.in);
		int i = 0;
		while(scan.hasNextLine()==true) {
			message[i] = scan.nextLine();
			i++;
		}
		for(int j = 0; j<i;j++) {
			System.out.println(message[j]);
		}

		int[] arr1 = new int[] { 9, 20, 28, 18, 11 };
		int[] arr2 = new int[] { 30, 1, 21, 17, 28 };
		int[] res = method1(5, arr1, arr2);
		System.out.println(Arrays.toString(res));
	}

	static int[] method1(int n, int[] arr1, int[] arr2) {
		int[] res = new int[n];
		for (int i = 0; i < n; i++) {
			res[i] = arr1[i] | arr2[i];
		}
		return res;
	}

	static String[] method2(int[] arr) {
		String[] res = new String[arr.length];
		for (int i = 0; i < arr.length; i++) {
			String str = Integer.toString(arr[i]);
		}
		return res;
	}
}

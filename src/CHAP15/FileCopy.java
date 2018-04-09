package CHAP15;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class FileCopy {

	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("hello_in.txt");
			byte[] outSrc = null;
			ByteArrayOutputStream output = null;
			output = new ByteArrayOutputStream();

			int data = 0;
			while ((data = fis.read()) != -1) {
				// byte c = (byte) data;
				// System.out.println(c);
				output.write(data);
			}

			fis.close();

			outSrc = output.toByteArray();
			System.out.println("Output Source : " + Arrays.toString(outSrc));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main1(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("hello_in.txt");
			FileOutputStream fos = new FileOutputStream("hello_out.txt");

			int data = 0;
			while ((data = fis.read()) != -1) {
				fos.write(data);
			}

			fis.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main2(String[] args) {
		try {
			// FileInputStream fis = new FileInputStream(args[0]);
			FileOutputStream fos = new FileOutputStream("hello_out.txt");

			byte[] inSrc = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
			ByteArrayInputStream input = null;
			input = new ByteArrayInputStream(inSrc);

			int data = 0;
			while ((data = input.read()) != -1) {
				fos.write(data);
			}

			// while ((data = fis.read()) != -1) {
			// fos.write(data);
			// }

			// fis.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

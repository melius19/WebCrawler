package CHAP11;

import java.util.Properties;

public class PropertiesEx4 {

	public static void main(String[] args) {
		Properties sysProp = System.getProperties();
		System.out.println(sysProp.getProperty("java.version"));
		sysProp.list(System.out);
	}
}

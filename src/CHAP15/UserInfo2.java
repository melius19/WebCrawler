package CHAP15;

class SuperUserInfo {
	String name;
	String password;

	SuperUserInfo(String name, String password) {
		this.name = name;
		this.password = password;
	}

	SuperUserInfo() {
		this("Unknown", "1111");
	}
}

public class UserInfo2 extends SuperUserInfo implements java.io.Serializable {
	int age;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

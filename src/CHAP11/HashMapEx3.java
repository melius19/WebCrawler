package CHAP11;

import java.util.*;

public class HashMapEx3 {
	static HashMap phoneBook = new HashMap();

	public static void main(String[] args) {
		addPhoneNo("Friend", "KIM", "32523423");
		addPhoneNo("Friend", "KAM", "12432443");
		addPhoneNo("Friend", "KOM", "22324227");
		addPhoneNo("Compan", "KGM", "42523442");
		addPhoneNo("Compan", "GIM", "53242323");
		addPhoneNo("GGD", "2433242323");
		printList();
	}

	static void addGroup(String groupName) {
		if (!phoneBook.containsKey(groupName))
			phoneBook.put(groupName, new HashMap());
	}

	static void addPhoneNo(String groupName, String name, String tel) {
		addGroup(groupName);
		HashMap group = (HashMap) phoneBook.get(groupName);
		group.put(tel, name);
	}

	static void addPhoneNo(String name, String tel) {
		addPhoneNo("etc", name, tel);
	}

	static void printList() {
		Set set = phoneBook.entrySet();
		Iterator it = set.iterator();

		while (it.hasNext()) {
			Map.Entry e = (Map.Entry) it.next();
			Set subSet = ((HashMap) e.getValue()).entrySet();
			Iterator subIt = subSet.iterator();
			System.out.println("*" + e.getKey() + "[" + subSet.size() + "]");
			while (subIt.hasNext()) {
				Map.Entry subE = (Map.Entry) subIt.next();
				String telNo = (String) subE.getKey();
				String name = (String) subE.getValue();
				System.out.println(name + " " + telNo);
			}
			System.out.println();
		}
	}
}

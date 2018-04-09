package CHAP11;

import java.util.*;

public class HashMapEx1 {

	public static void main(String[] args) {
		HashMap map = new HashMap();
		map.put("KIM", new Integer(90));
		map.put("KIM", new Integer(100));
		map.put("LEE", new Integer(100));
		map.put("KAN", new Integer(90));
		map.put("AHN", new Integer(90));
		System.out.println(map);

		Set set = map.entrySet();
		System.out.println(set);
		Iterator it = set.iterator();

		while (it.hasNext()) {
			Map.Entry e = (Map.Entry) it.next();
			System.out.println(e.getKey() + " " + e.getValue());
		}
		set = map.keySet();
		System.out.println(set);

		Collection values = map.values();
		System.out.println(values);
	}
}

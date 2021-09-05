package MapAnhHashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class Bai1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<Integer, Integer> mapInt = new HashMap<Integer, Integer>();
		int n = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < n; i++) {
			System.out.println("Enter key " + (i+1));
			Integer key = new Integer(sc.nextInt());
			System.out.println("Value " + (i+1));
			Integer value = new Integer(sc.nextInt());;
			mapInt.put(key, value);
		}
		Set<Map.Entry<Integer, Integer>> setMapInt = mapInt.entrySet();
		
		for (Entry<Integer, Integer> entry : setMapInt) {
			System.out.println(entry.getKey() + " ----> " + entry.getValue());
		}
		
		System.out.println("Enter key want to check is contain?");
		Integer keyCheck = new Integer(sc.nextInt());
		for (Integer entry : mapInt.keySet()) {
			if (entry.equals(keyCheck)) {
				System.out.println("Exists");
				break;
			}
		}
		
		System.out.println("Enter value want to check is contain?");
		Integer keyValue = new Integer(sc.nextInt());
		for (Integer entry : mapInt.values()) {
			if (entry.equals(keyValue)) {
				System.out.println("Exists");
				break;
			}
		}
		
		System.out.println("Enter key want to check is contain?");
		Integer keyRemove = new Integer(sc.nextInt());
		for (Integer entry : mapInt.keySet()) {
			if (entry.equals(keyCheck)) {
				System.out.println(mapInt.remove(keyRemove));;
				break;
			}
		}
		
		for (Entry<Integer, Integer> entry : setMapInt) {
			System.out.println(entry.getKey() + " ----> " + entry.getValue());
		}
		
		System.out.println("Enter key want to replace is contain?");
		Integer keyReplace = new Integer(sc.nextInt());
		System.out.println("Enter value want to replace");
		Integer valueReplace = new Integer(sc.nextInt());
		for (Integer entry : mapInt.keySet()) {
			if (entry.equals(keyCheck)) {
				System.out.println(mapInt.replace(keyReplace,valueReplace));;
				break;
			}
		}
		
		for (Entry<Integer, Integer> entry : setMapInt) {
			System.out.println(entry.getKey() + " ----> " + entry.getValue());
		}
		
	}
}

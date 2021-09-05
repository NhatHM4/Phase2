package MapAnhHashMap;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class Dictionary {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		Map<String, String> dictionary = null ;
		
		
		do {
			System.out.println("Enter your option");
			int chose = Integer.parseInt(sc.nextLine());
			switch (chose) {
			case 1:
				dictionary = inputDic(sc);
				break;
			case 2:
				dictionary=changeValue(dictionary,sc);
				break;
			case 3:
				search(dictionary,sc);
				break;
			case 4:
				try {
					saveToFile(dictionary);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 5:
				findAll();
				break;
			case 6:
				System.exit(0);
			}
		}while (true);
		
	}

	private static void findAll() throws IOException {
		Map<String, String> dictionary = new HashMap<String, String>();
		String line = "";
		BufferedReader bff = null;
		try {
			bff = new BufferedReader(new FileReader("D:\\dictionary.txt"));
			while ((line = bff.readLine()) != null) {
				String[] data = line.split(" --> ");
				dictionary.put(data[0], data[1]);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Set<Map.Entry<String, String>> setDic = dictionary.entrySet();
		for (Entry<String, String> entry : setDic) {
				System.out.println(entry.getKey() + " ----> " + entry.getValue());
		}
	}

	private static void saveToFile(Map<String, String> dictionary) throws IOException {
		Set<Map.Entry<String, String>> setDic = dictionary.entrySet();
		File file = null;
		OutputStream outputStream = null;
		OutputStreamWriter outputStreamWriter = null;
		file = new File("D:\\dictionary.txt");
		try {
			outputStream = new FileOutputStream(file);
			outputStreamWriter = new OutputStreamWriter(outputStream);
			for (Entry<String, String> entry : setDic) {
				outputStreamWriter.write(entry.getKey() + " --> " + entry.getValue());
				outputStreamWriter.write("\n");
			}
			outputStreamWriter.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			outputStreamWriter.close();
		}
	}

	private static void search(Map<String, String> dictionary, Scanner sc) {
		Set<Map.Entry<String, String>> setDic = dictionary.entrySet();
		System.out.println("Enter key");
		String key = sc.nextLine();
		for (Entry<String, String> entry : setDic) {
			if (entry.getKey().equals(key)) {
				System.out.println(entry.getKey() + " ----> " + entry.getValue());
			}
		}
	}

	private static Map<String, String> changeValue(Map<String, String> dictionary, Scanner sc) {
		String key = "";
		String value = "";
		String c = "";
		System.out.println("Enter key want to change");
		key = sc.nextLine();
		System.out.println("Enter value");
		value = sc.nextLine();
		for (String string : dictionary.keySet()) {
			if (string.equals(key)) {
				dictionary.replace(key, value);
			}
		}
		return dictionary;
	}

	private static Map<String, String> inputDic(Scanner sc) {
		Map<String, String> dictionary = new HashMap<String, String>();
		String key = "";
		String value = "";
		String c = "";
		do {
			System.out.println("Enter key");
			key = sc.nextLine();
			System.out.println("Enter value");
			value = sc.nextLine();
			dictionary.put(key, value);
			System.out.println("Do you want to continue? (Q)");
			c = sc.nextLine();
		} while (!c.equalsIgnoreCase("q"));
		return dictionary;

	}
}

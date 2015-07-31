package euler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class problem89 {
	
	public static Map<Character, Integer> initializeHashTable() {
		Map<Character, Integer> map = new HashMap<Character,Integer>();
		map.put('I',1);
		map.put('V',5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C',100);
		map.put('D', 500);
		map.put('M',1000);
		return map;
	}
	
	public static int RomanToDecimal(String s) {
		int count=0;
		int lastWeSaw = 0;
		int num;
		Map<Character, Integer> map = initializeHashTable();
		for (int i=s.length()-1; i>=0; i--) {
			num = map.get(s.charAt(i));
			if (num >= lastWeSaw) {
				count+=num;
			}
			else {
				count-=num;
			}
			lastWeSaw = num;
		}
		return count;
	}
	
	public static int minNumberOfCharacters (int n) {
		int count=0;
		count += n/1000; // adding Ms as many as needed
		n=n%1000;
		int current = n/100;
		count+=toRoman(current);
		n = n%100;
		current = n/10;
		count += toRoman(current);
		n = n%10;
		count += toRoman(n);
		return count;
	}
	
	public static int toRoman(int n) {
		/*
		 * To convert (only) hundreds/tens/units to Roman numerals, note that
		 * every array has the same length of string in each cell.
		 * Therefore, we can use the same map for the hundreds, tens and units. 
		 * String hund[]={"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
			String ten[]={"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
			String unit[]={"","I","II","III","IV","V","VI","VII","VIII","IX"};
		 */
		switch (n) {
		case 0: return 0;
		case 1: return 1;
		case 2: return 2;
		case 3: return 3;
		case 4: return 2;
		case 5: return 1;
		case 6: return 2;
		case 7: return 3;
		case 8: return 4;
		case 9: return 2;
		}
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("C:\\Users\\Omer\\workspace_euler\\euler\\src\\euler\\p089_roman.txt");
		BufferedReader textReader = new BufferedReader(fr);
		String line = textReader.readLine();
		int count=0;
		while (line != null) {
			count+=line.length() - minNumberOfCharacters(RomanToDecimal(line));
			line = textReader.readLine();
		}
		textReader.close();
		System.out.println(count);
	}

}

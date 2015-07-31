package euler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;


public class problem59 {
	static String Filename = "p059_cipher.txt";
	static int keyLength=3;
	static Set<Character> AllowedCharacters = new HashSet<Character>();

	public static void main(String[] args) {
		int[] decrypt = readFile();
		int[] key = initializeKey();
		buildAllowedCharacters();
		while (!allZs(key) && checkKey(key, decrypt)) {
			increaseKey(key);
		}
		checkKey(key, decrypt); // in case the correct key is "zzz"
	}
	
	public static int[] readFile() {
		File file = new File(Filename);
		BufferedReader reader = null;
		String text = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			text = reader.readLine();
			reader.close();		
		}
		catch (Exception e) {
			System.out.println("unable to open file");
			System.exit(1);
		}
		String[] StringNumbers = text.split(",");
		int[] nums = new int[StringNumbers.length];
		for (int i= 0; i<nums.length; i++) {
			nums[i]=Integer.parseInt(StringNumbers[i]);
			
		}
		return nums;
	}
	
	public static boolean allLetters(int[] nums) {
		for (int i=0; i< nums.length ; i++) {
			if (!(AllowedCharacters.contains((char)nums[i])))  {
				return false;
			}
		}
		return true;
	}
	public static int[] xoredArray(int[] nums, int[] key) {
		int[] result = new int[nums.length];
		for (int i = 0 ; i<nums.length ; i++) {
			result[i] = (int) (nums[i] ^ key[i%key.length]);
		}
		return result;
	}
	public static void increaseKey(int[] key) {
		for (int i=0; i<key.length; i++) {
			key[i]++;
			if (key[i] <= 'z') return;
			key[i] = 'a';
		}
	}
	public static boolean allZs(int[] keys) {
		for (int i=0; i<keys.length; i++) {
			if (keys[i] != 'z') return false;
		}
		return true;
	}
	public static void printKey(int[] key) {
		for (int i = 0; i<key.length; i++) {
			System.out.print((char)key[i]);
		}
		System.out.println();
	}
	
	public static void buildAllowedCharacters() {
		for (int i = 'a'; i<='z'; i++) {
			AllowedCharacters.add((char)i);
		}
		for (int i = 'A'; i<='Z'; i++) {
			AllowedCharacters.add((char)i);
		}
		for (int i= '0'; i<='9' ; i++) {
			AllowedCharacters.add((char)i);
		}
		AllowedCharacters.add(' ');
		AllowedCharacters.add('!');
		AllowedCharacters.add('.');
		AllowedCharacters.add(',');
		AllowedCharacters.add('?');
		AllowedCharacters.add('\'');
		AllowedCharacters.add('(');
		AllowedCharacters.add(')');
		AllowedCharacters.add(';');
	}
	public static int[] initializeKey() {
		int[] key = new int[keyLength];
		for (int i=0 ; i<key.length; i++) {
			key[i]='a';
		}
		return key;
	}
	public static boolean checkKey(int[] key, int[] decrypt) {
		int[] arr=xoredArray(decrypt, key);
		if (allLetters(arr)) {
			printKey(key);
			int accum=0;
			for (int i=0; i<arr.length; i++) {
				System.out.print((char)(arr[i]));
				accum+=arr[i];
			}
			System.out.println();
			System.out.println(accum);
			return true;
		}
		return false;
	}
}

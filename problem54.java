package euler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class problem54 {
	
	public static int fromCardToNumber(String card) {
		if (card.charAt(0) >= '2' && card.charAt(0) <= '9') return Integer.parseInt(card.substring(0, 1));
		if (card.charAt(0) == 'T') return 10;
		if (card.charAt(0) == 'J') return 11;
		if (card.charAt(0) == 'Q') return 12;
		if (card.charAt(0) == 'K') return 13;
		if (card.charAt(0) == 'A') return 14;
		return -1;
	}
	public static int[] values(String[] cards) {
		int[] answer = new int[cards.length];
		for (int i=0; i<cards.length; i++) {
			answer[i] = fromCardToNumber(cards[i].substring(0, 1));
		}
		return answer;
	}
	public static String[] suits(String[] cards) {
		String[] answer = new String[cards.length];
		for (int i=0; i<cards.length; i++) {
			answer[i] = cards[i].substring(1, 2);
		}
		return answer;
	}
	
	
	public static boolean hasCard(String[] cards, String card) {
		/*
		 * Whether the list of cards contains the specific card
		 */
		for (int i=0; i<cards.length; i++) {
			if (cards[i].compareTo(card) == 0) return true;
		}
		return false;
		
	}
	
	public static int hasRoyalFlush(String[] cards) {
		char suit = cards[0].charAt(1);
		if (hasCard(cards, "T" + suit) && hasCard(cards, "J" + suit) && hasCard(cards, "Q" + suit) && hasCard(cards, "K" + suit) && hasCard(cards, "A" + suit)) return 1;
		return -1;
	}
	
	public static int hasStraightFlush(String[] cards) {
		String[] suits =suits(cards);
		Arrays.sort(suits);
		if (suits[0].compareTo(suits[4]) != 0) return -1;
		return Straight(cards);
	}
	
	public static int FourOfAKind(String[] cards) {
		int[] values = values(cards);
		Arrays.sort(values);
		if (values[0] == values[3] || values[1] == values[4]) return values[1];
		return -1;
	}
	
	public static int FullHouse(String[] cards) {
		int[] values = values(cards);
		Arrays.sort(values);
		if (values[0] == values[1] && values[2] == values[4]) return values[4];
		if (values[0] == values[2] && values[3] == values[4]) return values[2];
		return -1;
	}
	public static int Flush(String[] cards) {
		String[] suits = suits(cards);
		Arrays.sort(cards);
		if (suits[0].compareTo(suits[4]) == 0) return 1;
		return -1;
	}
	public static int Straight(String[] cards) {
		int[] values = values(cards);
		Arrays.sort(values);
		for (int i=0; i<values.length -1; i++) {
			if (values[i+1] - values[i] != 1) return -1;
		}
		return values[values.length-1];
	}
	public static int ThreeOfAKind(String[] cards) {
		int[] values = values(cards);
		Arrays.sort(values);
		for (int i=0; i<3; i++) {
			if (values[i] == values[i]+2) return values[i];
		}
		return -1;
	}
	
	public static int TwoPairs(String[] cards) {
		int[] values = values(cards);
		Arrays.sort(values);
		if (values[0] == values[1] && values[2] == values[3]) return values[3];
		if (values[0] == values[1] && values[3] == values[4]) return values[3];
		if (values[1] == values[2] && values[3] == values[4]) return values[3];
		return -1;
	}
	public static int OnePair(String[] cards) {
		int[] values = values(cards);
		Arrays.sort(values);
		for (int i=0; i<cards.length-1; i++) {
			if (values[i]==values[i+1]) return values[i];
		}
		return -1;
	}
	
	public static int HighestCard(String[] cards) {
		int[] values = values(cards);
		Arrays.sort(values);
		return values[4];
	}
	
	public static boolean player1Wins(String[] cards1, String[] cards2) {
		if (hasRoyalFlush(cards1) > hasRoyalFlush(cards2)) return true;
		if (hasRoyalFlush(cards1) < hasRoyalFlush(cards2)) return false;
		if (hasStraightFlush(cards1) > hasStraightFlush(cards2)) return true;
		if (hasStraightFlush(cards1) < hasStraightFlush(cards2)) return false;
		if (FourOfAKind(cards1) > FourOfAKind(cards2)) return true;
		if (FourOfAKind(cards1) < FourOfAKind(cards2)) return false;
		if (FullHouse(cards1) > FullHouse(cards2)) return true;
		if (FullHouse(cards1) < FullHouse(cards2)) return false;
		if (Flush(cards1) > Flush(cards2)) return true;
		if (Flush(cards1) < Flush(cards2)) return false;
		if (Straight(cards1) > Straight(cards2)) return true;
		if (Straight(cards1) < Straight(cards2)) return false;
		if (ThreeOfAKind(cards1) > ThreeOfAKind(cards2)) return true;
		if (ThreeOfAKind(cards1) < ThreeOfAKind(cards2)) return false;
		if (TwoPairs(cards1) > TwoPairs(cards2)) return true;
		if (TwoPairs(cards1) < TwoPairs(cards2)) return false;
		if (OnePair(cards1) > OnePair(cards2)) return true;
		if (OnePair(cards1) < OnePair(cards2)) return false;
		int[] values1 = values(cards1);
		int[] values2 = values(cards2);
		for (int i=4; i>=0; i--) {
			if (values1[i] > values2[i]) return true;
			if (values1[i] < values2[i]) return false;
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		int count = 0;
		FileReader fr = new FileReader("C:\\Users\\Omer\\workspace_euler\\euler\\src\\euler\\p054_poker.txt");
		BufferedReader textReader = new BufferedReader(fr);
		String line = textReader.readLine();
		String[] arr;
		String[] player1;
		String[] player2;
		while (line != null) {
			arr = line.split(" ");
	        player1 = Arrays.copyOfRange(arr, 0, 5);
	        player2 = Arrays.copyOfRange(arr, 5, 10);
	        if (player1Wins(player1, player2)) count++;
			line = textReader.readLine();
		}
		System.out.println(count);
	}
}

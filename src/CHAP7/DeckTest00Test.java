package CHAP7;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DeckTest00Test {

	@Test
	void test0() {
		// No Rank
		Card[] cardstmp0 = { new Card(1, 8), //
				new Card(2, 3), new Card(3, 9), //
				new Card(4, 4), new Card(4, 1) };
		assertTrue(rankCheck(cardstmp0).equals("No Rank"));
	}

	@Test
	void test1() {
		// One Pair
		Card[] cardstmp1 = { new Card(1, 8), //
				new Card(2, 3), new Card(3, 1), //
				new Card(4, 4), new Card(4, 1) };
		assertTrue(rankCheck(cardstmp1).equals("One Pair"));
	}

	@Test
	void test2() {
		// Two Pair
		Card[] cardstmp2 = { new Card(1, 8), //
				new Card(2, 4), new Card(3, 1), //
				new Card(4, 4), new Card(4, 1) };
		assertTrue(rankCheck(cardstmp2).equals("Two Pair"));
	}

	@Test
	void test3() {
		// Triple
		Card[] cardstmp3 = { new Card(1, 8), //
				new Card(2, 4), new Card(3, 1), //
				new Card(4, 4), new Card(1, 4) };
		assertTrue(rankCheck(cardstmp3).equals("Triple"));
	}

	@Test
	void test4() {
		// Straight
		Card[] cardstmp4 = { new Card(1, 1), //
				new Card(2, 12), new Card(3, 2), //
				new Card(4, 13), new Card(1, 3) };
		assertTrue(rankCheck(cardstmp4).equals("Straight"));
	}

	@Test
	void test5() {
		// Flush
		Card[] cardstmp5 = { new Card(1, 1), //
				new Card(1, 12), new Card(1, 5), //
				new Card(1, 2), new Card(1, 3) };
		assertTrue(rankCheck(cardstmp5).equals("Flush"));
	}

	@Test
	void test6() {
		// Full House
		Card[] cardstmp6 = { new Card(1, 1), //
				new Card(2, 4), new Card(3, 1), //
				new Card(4, 4), new Card(1, 4) };
		assertTrue(rankCheck(cardstmp6).equals("Full House"));
	}

	@Test
	void test7() {
		// Four Card
		Card[] cardstmp7 = { new Card(1, 1), //
				new Card(2, 4), new Card(3, 4), //
				new Card(4, 4), new Card(1, 4) };
		assertTrue(rankCheck(cardstmp7).equals("Four Card"));
	}

	@Test
	void test8() {
		// Straight Flush
		Card[] cardstmp8 = { new Card(1, 1), //
				new Card(1, 12), new Card(1, 2), //
				new Card(1, 13), new Card(1, 3) };
		assertTrue(rankCheck(cardstmp8).equals("Straight Flush"));
	}

	@Test
	void test9() {
		// Royal Straight Flush
		Card[] cardstmp9 = { new Card(1, 1), //
				new Card(1, 12), new Card(1, 11), //
				new Card(1, 13), new Card(1, 10) };
		assertTrue(rankCheck(cardstmp9).equals("Royal Straight Flush"));
	}

	static String rankCheck(Card[] cards) {

		// Radix array for card number
		// Condition of Flush
		int[] count = new int[13];
		boolean flush = false;
		int flushCnt = 0;
		for (int i = 0; i < cards.length; i++) {
			count[cards[i].number - 1]++;
			if (cards[0].kind == cards[i].kind)
				flushCnt++;
			if (flushCnt == 5)
				flush = true;
		}

		// Condition of Straight & Royal
		boolean straight = false;
		boolean royal = false;
		int j = 0;
		for (int i = 0; i < count.length + 4; i++) {
			if (count[i % count.length] == 1) {
				j++;
				if (j == 5) {
					straight = true;
					if (i == 13)
						royal = true;
					break;
				}
			} else
				j = 0;
		}

		// Flush & Straight >>> Flush, Straight, Royal...
		if (flush) {
			if (straight) {
				if (royal)
					return "Royal Straight Flush";
				return "Straight Flush";
			}
			return "Flush";
		} else {
			if (straight)
				return "Straight";
		}

		// number of pairs, Triple, Four Card
		int pairNum = 0; // number of pairs
		boolean triple = false;
		for (int i = 0; i < count.length; i++) {
			if (count[i] == 2)
				pairNum++;
			if (count[i] == 3) {
				triple = true;
			}
			if (count[i] == 4) {
				return "Four Card";
			}
		}

		// Pair >>> One Pair, Two Pair, Triple
		if (triple) {
			if (pairNum > 0)
				return "Full House";
			return "Triple";
		} else {
			if (pairNum > 0) {
				if (pairNum == 2)
					return "Two Pair";
				return "One Pair";
			}
		}
		return "No Rank";
	}
}

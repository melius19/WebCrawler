package CHAP7;

public class DeckTest00 {

	public static void main(String[] args) {
		Deck d = new Deck();
		// Card c = d.pick(0);
		// System.out.println(c);

		Card[][] cards = new Card[10][];
		// No Rank
		cards[0] = new Card[] { new Card(1, 8), //
				new Card(2, 3), new Card(3, 9), //
				new Card(4, 4), new Card(4, 1) };

		// One Pair
		cards[1] = new Card[] { new Card(1, 8), //
				new Card(2, 3), new Card(3, 1), //
				new Card(4, 4), new Card(4, 1) };

		// Two Pair
		cards[2] = new Card[] { new Card(1, 8), //
				new Card(2, 4), new Card(3, 1), //
				new Card(4, 4), new Card(4, 1) };

		// Triple
		cards[3] = new Card[] { new Card(1, 8), //
				new Card(2, 4), new Card(3, 1), //
				new Card(4, 4), new Card(1, 4) };

		// Straight
		cards[4] = new Card[] { new Card(1, 1), //
				new Card(2, 12), new Card(3, 2), //
				new Card(4, 13), new Card(1, 3) };

		// Flush
		cards[5] = new Card[] { new Card(1, 1), //
				new Card(1, 12), new Card(1, 5), //
				new Card(1, 2), new Card(1, 3) };

		// Full House
		cards[6] = new Card[] { new Card(1, 1), //
				new Card(2, 4), new Card(3, 1), //
				new Card(4, 4), new Card(1, 4) };

		// Four Card
		cards[7] = new Card[] { new Card(1, 1), //
				new Card(2, 4), new Card(3, 4), //
				new Card(4, 4), new Card(1, 4) };

		// Straight Flush
		cards[8] = new Card[] { new Card(1, 1), //
				new Card(1, 4), new Card(1, 2), //
				new Card(1, 13), new Card(1, 3) };

		// Royal Straight Flush
		cards[9] = new Card[] { new Card(1, 1), //
				new Card(1, 12), new Card(1, 11), //
				new Card(1, 13), new Card(1, 10) };

		d.shuffle();
		// c = d.pick();
		// System.out.println(c);
		System.out.println("***** Poker *****");
		// System.out.println(rankCheck(d.pick5()));

		for (int i = 0; i < cards.length; i++) {
			System.out.println(rankCheck(cards[i]));
			System.out.println(rankCheck1(cards[i]));
		}

	}

	static String rankCheck(Card[] cards) {

		int[] counter = new int[14]; // 0은 안쓴다. 1~13
		int kindCnt = 0;
		int straightCnt = 0;
		int pair = 0; // 페어 체크하는변수

		boolean fourCard = false;
		boolean triple = false;
		boolean flush = false;
		boolean straight = false;

		for (int i = 0; i < cards.length; i++) {
			counter[cards[i].number]++; // 카운팅하기
			if (cards[0].kind == cards[i].kind) // FLUSH체크
				kindCnt++;
		}
		if (kindCnt == 5)
			flush = true;

		for (int i = 0; i < counter.length; i++) {
			if (counter[i] == 2)
				pair++; // 카운팅한 숫자가 2이상이면 paircheck++
			if (counter[i] == 3)// 카운팅 숫자가 3개인데
				triple = true;
			if (counter[i] == 4)
				fourCard = true;
			;
			if (counter[i] == 1) {
				straightCnt++;
			} else {
				if (straightCnt != 5)
					straightCnt = 0;
			}
		}
		if (straightCnt == 5)
			straight = true;
		// 높은 랭크부터 순서대로 적는다.
		if (flush && straight)
			return "STRAIGHT FLUSH";
		if (flush)
			return "FLUSH";
		if (straight)
			return "STRAIGHT";
		if (triple & pair == 1)
			return "FULL HOUSE";
		if (fourCard)
			return "FOUR CARD";
		if (triple)
			return "TRIPLE";
		if (pair == 2)
			return "TWO PAIR";
		if (pair == 1)
			return "ONE PAIR";
		return "NO RANK";
	}

	static String rankCheck1(Card[] cards) {

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

	static String rankCheck2(Card[] cards) {
		String str = "";

		int flag = 0;
		// 1: One Pair, 2: Two Pair, 3: Triple
		// 4: Straight, 5: Flush, 6: Full House
		// 7: Four Card, 8: Straight Flush
		// 9: Royal Straight Flush

		// Radix array for card number
		int[] count = new int[13];
		for (int i = 0; i < cards.length; i++) {
			count[cards[i].number - 1]++;
		}

		// Condition of Flush
		boolean flush = true;
		for (int i = 0; i < cards.length - 1; i++) {
			if (cards[i].kind != cards[4].kind) {
				flush = false;
				break;
			}
		}

		// Condition of Straight
		boolean straight = false;
		int j = 0, royal = 0; // royal
		for (int i = 0; i < count.length + 4; i++) {
			if (count[i % count.length] == 1) {
				j++;
				if (j == 5) {
					royal = i;
					straight = true;
					break;
				}
			} else
				j = 0;
		}

		// Straight & Flush >>> Straight, Flush, Royal...
		if (flush) {
			if (straight) {
				flag = 8; // Straight Flush
				if (royal == 13)
					flag = 9; // Royal Straight Flush
			} else
				flag = 5; // Flush

		} else {
			if (straight)
				flag = 4; // Straight
		}

		// number of pairs, Triple, Four Card
		int pairNum = 0; // number of pairs
		for (int i = 0; i < count.length; i++) {
			if (count[i] == 2)
				pairNum++;
			if (count[i] == 3) {
				flag = 3; // Triple
			}
			if (count[i] == 4) {
				flag = 7; // Four Card
				break;
			}
		}

		// Pair >>> One Pair, Two Pair, Full House
		if (flag == 3) { // if Triple
			if (pairNum > 0)
				flag = 6; // Full House
		} else { // else Triple
			if (pairNum > 0) {
				flag = 1; // One Pair
				if (pairNum == 2)
					flag = 2; // Two Pair
			}
		} // end of Triple

		switch (flag) {
		case 1:
			str = "One Pair";
			break;
		case 2:
			str = "Two Pair";
			break;
		case 3:
			str = "Triple";
			break;
		case 4:
			str = "Straight";
			break;
		case 5:
			str = "Flush";
			break;
		case 6:
			str = "Full House";
			break;
		case 7:
			str = "Four Card";
			break;
		case 8:
			str = "Straight Flush";
			break;
		case 9:
			str = "Royal Straight Flush";
			break;
		default:
			str = "No Rank"; // str + "No Rank";
		}
		return str;
	}

	static String rankCheck3(Card[] cards) {
		String str = "";
		// for (int i = 0; i < cards.length; i++) {
		// str = str + cards[i] + "\n";
		// }

		int flag = 0;
		// 1: One Pair, 2: Two Pair, 3: Triple
		// 4: Straight, 5: Flush, 6: Full House
		// 7: Four Card, 8: Straight Flush
		// 9: Royal Straight Flush

		// Radix sort for card number
		int[] count = new int[13];
		for (int i = 0; i < cards.length; i++) {
			count[cards[i].number - 1]++;
		}

		int[] pairNum = new int[3];
		// [0]: number of pairs
		// [1]: number of Triple
		// [2]: number of Four Card
		for (int i = 0; i < count.length; i++) {
			// System.out.print(count[j]);
			if (count[i] == 2)
				pairNum[0]++; // number of pairs
			if (count[i] == 3)
				pairNum[1]++; // number of Triple
			if (count[i] == 4)
				pairNum[2]++; // number of Four Card
		}
		// System.out.println();

		// Pair >>> Pair, Triple, Full House, Four Card
		if (pairNum[2] > 0) { // if Four Card
			flag = 7; // Four Card
		} else { // else Four Card
			if (pairNum[1] > 0) { // if Triple
				flag = 3; // Triple
				if (pairNum[0] > 0) {
					flag = 6; // Full House
				}
			} else { // else Triple
				if (pairNum[0] > 0) {
					flag = 1; // One Pair
					if (pairNum[0] == 2)
						flag = 2; // Two Pair
				}
			} // end of Triple
		} // end of Four Card

		// Condition of Straight
		boolean straight = false;
		int j = 0, royal = 0; // royal
		int[] count2 = new int[count.length + 4];
		for (int i = 0; i < count2.length; i++) {
			count2[i] = count[i % count.length];
			// System.out.print(count2[i]);
			if (count2[i] == 0)
				j = 0;
			else
				j++;
			if (j == 5) {
				royal = i;
				straight = true;
				break;
			}
		}

		// Condition of Flush
		boolean flush = true;
		for (int i = 0; i < cards.length - 1; i++) {
			if (cards[i].kind != cards[4].kind) {
				flush = false;
			}
		}

		// Straight & Flush >>> Straight, Flush, Royal...
		if (flag == 0) {
			if (straight && flush) {
				flag = 8; // Straight Flush
				if (royal == 13)
					flag = 9; // Royal Straight Flush
			}
			if (!straight && flush)
				flag = 5; // Flush
			if (straight && !flush)
				flag = 4; // Straight
		}
		// System.out.println("j:" + j);

		switch (flag) {
		case 1:
			str = "One Pair";
			break;
		case 2:
			str = "Two Pair";
			break;
		case 3:
			str = "Triple";
			break;
		case 4:
			str = "Straight";
			break;
		case 5:
			str = "Flush";
			break;
		case 6:
			str = "Full House";
			break;
		case 7:
			str = "Four Card";
			break;
		case 8:
			str = "Straight Flush";
			break;
		case 9:
			str = "Royal Straight Flush";
			break;
		default:
			str = "No Rank"; // str + "No Rank";
		}
		return str;
	}
}

class Card {
	static final int KIND_MAX = 4;
	static final int NUM_MAX = 13;

	static final int SPADE = 4;
	static final int DIAMOND = 3;
	static final int HEART = 2;
	static final int CLOVER = 1;

	int kind;
	int number;

	Card(int kind, int number) {
		this.kind = kind;
		this.number = number;
	}

	Card() {
		this(SPADE, 1);
	}

	public String toString() {
		String[] kinds = { //
				"", "CLOVER", "HEART", "DIAMOND", "SPADE" };
		String numbers = "0123456789XJQK";

		return "kind : " + kinds[this.kind] + //
				", number : " + numbers.charAt(this.number);
	}
}

class Deck {
	final int CARD_NUM = 52;
	Card cardArr[] = new Card[CARD_NUM];

	Deck() {
		int i = 0;
		for (int k = Card.KIND_MAX; k > 0; k--) {
			for (int n = 0; n < Card.NUM_MAX; n++) {
				cardArr[i++] = new Card(k, n + 1);
			}
		}
	}

	Card pick(int index) {
		return cardArr[index];
	}

	Card pick() {
		int index = (int) (Math.random() * CARD_NUM);
		return pick(index);
	}

	Card[] pick5() {
		int num = 5;
		Card[] cards = new Card[num];
		for (int i = 0; i < num; i++) {
			cards[i] = pick(i);
		}
		return cards;
	}

	void shuffle() {
		for (int i = 0; i < cardArr.length; i++) {
			int r = (int) (Math.random() * CARD_NUM);
			Card temp = cardArr[i];
			cardArr[i] = cardArr[r];
			cardArr[r] = temp;
		}
	}
}

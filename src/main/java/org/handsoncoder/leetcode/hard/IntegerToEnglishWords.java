package org.handsoncoder.leetcode.hard;

public class IntegerToEnglishWords {
	private static final int BILLION = 1000000000;
	private static final int MILLION = 1000000;
	private static final int THOUSAND = 1000;
	private static final int HUNDRED = 100;

	private static final String BILLION_W = " Billion ";
	private static final String MILLION_W = " Million ";
	private static final String THOUSAND_W = " Thousand ";
	private static final String HUNDRED_W = " Hundred ";

	private String units(int num) {
		switch (num) {
		case 1:
			return " One ";
		case 2:
			return " Two ";
		case 3:
			return " Three ";
		case 4:
			return " Four ";
		case 5:
			return " Five ";
		case 6:
			return " Six ";
		case 7:
			return " Seven ";
		case 8:
			return " Eight ";
		case 9:
			return " Nine ";
		default:
			return "";
		}
	}

	private String tenToNineteen(int num) {
		switch (num) {
		case 10:
			return "Ten";
		case 11:
			return "Eleven";
		case 12:
			return "Twelve";
		case 13:
			return "Thirteen";
		case 14:
			return "Fourteen";
		case 15:
			return "Fifteen";
		case 16:
			return "Sixteen";
		case 17:
			return "Seventeen";
		case 18:
			return "Eighteen";
		case 19:
			return "Nineteen";
		default:
			return "";
		}
	}

	private String tens(int num) {
		switch (num) {
		
		case 2:
			return "Twenty";
		case 3:
			return "Thirty";
		case 4:
			return "Forty";
		case 5:
			return "Fifty";
		case 6:
			return "Sixty";
		case 7:
			return "Seventy";
		case 8:
			return "Eighty";
		case 9:
			return "Ninety";
		default:
			return "";
		}
	}

	private String twoDigit(int num) {
		int ten = num / 10;
		int unit = num % 10;
		return unit == 0 ? tens(num) : tens(ten) + "" + units(unit);
	}

	private String threeDigit(int num) {
		if (num <= 9) {
			return units(num);
		} else if (num <= 20) {
			return tenToNineteen(num);
		} else if (num <= 99) {
			return twoDigit(num);
		} else {
			return units(num / HUNDRED) + HUNDRED_W + twoDigit(num % HUNDRED);
		}
	}

	public String numberToWords(int num) {
		StringBuffer words = new StringBuffer();
		if (num / BILLION != 0) {
			words.append(threeDigit(num / BILLION));
			words.append(BILLION_W);
			num = num % BILLION;
		}
		if (num / MILLION != 0) {
			words.append(threeDigit(num / MILLION));
			words.append(MILLION_W);
			num = num % MILLION;
		}
		if (num / THOUSAND != 0) {
			words.append(threeDigit(num / THOUSAND));
			words.append(THOUSAND_W);
			num = num % THOUSAND;
		}
		words.append(threeDigit(num));
		return words.toString();

	}

	public static void main(String[] args) {
		IntegerToEnglishWords testObj = new IntegerToEnglishWords();
		System.out.println(testObj.numberToWords(1900019));

	}

}

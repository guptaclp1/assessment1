package com.test.pelindrom;

public class SearchPalindrome {

	public static void main(String[] args) {
		
		String str = "HelloWelcomeemoclewHelloolle";
		SearchPalindrome searchPalindrome = new SearchPalindrome();
		String palindrome =searchPalindrome.searchPalindrome(str);
		System.out.println("Longest Palindrome: "+palindrome);
	}

	public String searchPalindrome(String s) {
		if (s == null){
			return null;
		}
		String longestPalindrome = s.substring(0, 1);
		for (int i = 0; i < s.length() - 1; i++) {

			String palindrome = terminalPalindrome(s, i, i);
			if (palindrome.length() > longestPalindrome.length()) {
				longestPalindrome = palindrome;
			}

			palindrome = terminalPalindrome(s, i, i + 1);
			if (palindrome.length() > longestPalindrome.length()) {
				longestPalindrome = palindrome;
			}
		}
		return longestPalindrome;
	}

	public String terminalPalindrome(String s, int leftIndex, int rightIndex) {
		if (leftIndex > rightIndex){
			return null;
		}
		while (leftIndex >= 0 && rightIndex < s.length()
				&& s.toUpperCase().charAt(leftIndex) == s.toUpperCase().charAt(rightIndex)) {
			leftIndex--;
			rightIndex++;
		}
		return s.substring(leftIndex + 1, rightIndex);
	}
}
package lab1;

import java.util.Scanner;

public class MyCaesar {
	public static final char[] ALPHABET = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
			'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
	public static final int ALPHABET_SIZE = 26;
	
	private int n;

	public MyCaesar(int shiftSteps) {
		this.n = shiftSteps;
	}

	public char encryptChar(char c) {
		if (Character.isLetter(c)) {
			char upperC = Character.toUpperCase(c);
			int index = upperC - 'A';
			int encryptedIndex = (index + n) % 26;
			return ALPHABET[encryptedIndex];
		}
		
		return c;
	}

	public String encrypt(String input) {
		StringBuilder encryptedText = new StringBuilder();
		for (char c : input.toCharArray()) {
			encryptedText.append(encryptChar(c));
		}
		return encryptedText.toString();
		
	}
	 public String decrypt(String encryptedText) {
	        StringBuilder decryptedText = new StringBuilder();
	        for (char c : encryptedText.toCharArray()) {
	            decryptedText.append(decryptChar(c));
	        }
	        return decryptedText.toString();
	    }
	    
	    private char decryptChar(char c) {
	        if (Character.isLetter(c)) {
	            char base = Character.isLowerCase(c) ? 'a' : 'A';
	            int offset = c - base;
	            int decryptedOffset = (offset - n + ALPHABET_SIZE) % ALPHABET_SIZE;
	            
	            return (char) (base + decryptedOffset);
	        }
	        
	        return c;
	    }
	 public static void main(String[] args) {
		 MyCaesar caesar = new MyCaesar(3);

		    String plaintext = "Thanh Ngan, Dai hoc Nong Lam!";
		    String ciphertext = caesar.encrypt(plaintext);
		    String decryptedText = caesar.decrypt(ciphertext);

		    System.out.println("Plaintext: " + plaintext);
		    System.out.println("Ciphertext: " + ciphertext);
		    System.out.println("Decrypted Text: " + decryptedText);
	    }
	}


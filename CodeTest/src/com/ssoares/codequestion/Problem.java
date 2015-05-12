package com.ssoares.codequestion;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Given an input stream of ASCII character, prints the first unique character
 * @author Solange Soares
 * 
 */
public class Problem {
	
	/**
	 * @author It is a given source code
	 */
	private static class Stream {
		private static InputStream in = System.in;

		public char getNextCharacter() {
			try {
				return (char) in.read();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		public boolean isEnd() {
			boolean isEnd;
			try {
				in.mark(0);
				isEnd = (in.read() == -1);
				in.reset();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}

			return isEnd;
		}
	}

	public static void main(String[] args) {
		Stream stream = new Stream();
		printFirstUniqueCharacter(stream);
	}
	
	/**
	 * Iterates over the input, if there is a unique char this method prints it
	 * If not it prints ERROR
	 * @author Solange Soares
	 * @param stream
	 */
	private static void printFirstUniqueCharacter(Stream stream) {
		
		Map<Character, Boolean> map = new LinkedHashMap<>();
		
		while(!stream.isEnd()) {
			
			Character nextCharacter = stream.getNextCharacter();
			
			if(map.get(nextCharacter) != null) {				
				map.put(nextCharacter, Boolean.FALSE);							
			} else {
				map.put(nextCharacter, Boolean.TRUE);
			}
		}
		
		for(Character key : map.keySet()) {
			if(map.get(key)) {
				System.out.println(key);
				return;
			}
		}
		System.out.println("ERROR");
	}
	
}
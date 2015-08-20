/*package com.src.ir;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Tokenizer {
	
	@SuppressWarnings("unused")
	private Parser fileParser;
	private Map<String, Integer> termIndexTable;
	private Porter porterStemmer; 

	public Map<String, Integer> buildTermFreqTable(File file) throws Exception {
	    termIndexTable = new  HashMap<String, Integer>();	
		if (file.isFile()) {
			SAXHandler handler = new SAXHandler();
			String plainText = Parser.parse(file, handler);
			plainText = plainText.replaceAll("[^\\w\\s-']+", " ").toLowerCase();		
			Scanner scanner = new Scanner(plainText);
			while (scanner.hasNext()) {
				String token = scanner.next();	
				processAndInsertToken(token);
			}
			scanner.close();
		}
	return termIndexTable;
}

private void processAndInsertToken(String token ) {	
	if(token.endsWith("'s")){
		insertInToTable(token.replace("'s", ""));
	} else if(token.contains("-")){
		splitAndInsertToken(token, "-");
	} else if(token.contains("_")){
		splitAndInsertToken(token, "_");
	} else {
		insertInToTable(token);
	}
		
}

private void splitAndInsertToken(String token, String splitBy) {
	String[] newTokens = token.split(splitBy);
	for(String newToken : newTokens){
		insertInToTable(newToken);
	}
}

private void insertInToTable(String token) {
	token = token.replaceAll("[']+", "");
	if(token.length() > 0 )
		token = porterStemmer.stripAffixes(token);
	if(token.length() > 0 ){
		if (termIndexTable.containsKey(token)) {
			termIndexTable.put(token, termIndexTable.get(token) + 1);
		} else {
			termIndexTable.put(token, 1);
		}
	}
}

}
*/
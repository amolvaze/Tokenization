// Date of program submission:- 10-06-2014
/* Program for Tokenization and Stemming by asv130130 (Name:- AMOL VAZE )*/
// Code for main function

package com.src.ir;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
public class Parser {
	public static HashMap<String, Integer> map;
	static int count1 = 0;
	static int count2 = 0;
	static int a;

	public static void main(String[] args) throws Exception {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		System.currentTimeMillis();

		SAXHandler handler = new SAXHandler();
		map = new HashMap<String, Integer>();
		// String filepath= args[0];
		String filepath = "./Cranfield";
		File folder = new File(filepath);
		// File folder = new File("C:/Workspace/Stemmer/New folder/Text1.txt");

		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
			File filename = listOfFiles[i];

			handler.setMap(map);
			parser.parse(filename, handler);

			map = handler.getHasMap();

		}
		System.currentTimeMillis();
		SAXHandler.print(map);
		// SAXHandler.writeToFile(map);
		//System.out.println("Time Taken = " + (endTime - startTime)+ " milliseconds");
		// System.out.println(map);
		//System.out.println("The total number of tokens are:"+ (SAXHandler.counter));
		//System.out.println("The number of distinct tokens in the cranfield text collection are: ");
		//System.out.print(map.size());
		Set<String> setOfKeys = map.keySet();

		Iterator<String> iterator = setOfKeys.iterator();

		while (iterator.hasNext()) {

			String key = (String) iterator.next();

			Integer value = (Integer) map.get(key);

			if (value == 1) {
				count1++;
			}

		}
		System.out.println("");
		//System.out.println("The number of tokens that occurs ony once: "+ count1);
		System.out.println("");
		a = listOfFiles.length;
		//System.out.println("Average number of words tokens per documents:"+ (SAXHandler.counter) / a);

		function();

		// Code for Index_building
		String STOP_WORD_FILE_NAME = "./stopwords";
		Set<String> stopWords = readStopWords(STOP_WORD_FILE_NAME);
		//new IndexBuilder(stopWords);
		
		System.currentTimeMillis();
		Map<String, IndexBuilder.DictionaryEntry> uncompressedIndex = IndexBuilder.buildIndex(filepath);
		 System.out.println(uncompressedIndex);	
		System.currentTimeMillis();
		IndexBuilder.getAvgDocLength();
 
		Utility.getSizeOfUnCompressedIndex(uncompressedIndex);
		Map<String, Utility.DictionaryEntry> compressedIndex = Utility.createCompressedIndex(uncompressedIndex);
		Utility.getSizeOfCompressedIndex(compressedIndex);

		}	/*System.out.println("**************************************************************************");
		System.out.println("1. Time required to build index = "+ (endingTime - startingTime) + " milliseconds");
		System.out.println("2. Size of the index uncompressed = "+ lenghtWithoutCompression + " bytes");
		System.out.println("3. Size of the index compressed   = "+ lenghtWithCompression + " bytes");
		System.out.println("4. number of inverted lists in the index = "+ uncompressedIndex.size());*/

	

	public static void function() throws IOException {
		String file = "C:/Computer_Data/Workspace/Tokenization/Text.txt";
		Stemmer.Stem(file);
		//System.out.println("The total number of stemmed tokens are:"+ (Stemmer.wordcount));
		//System.out.println("The number of distinct stems in the cranfield text collection are: ");
		//System.out.print(Stemmer.treemap.size());
		Set<String> setOfKeys1 = Stemmer.treemap.keySet();

		Iterator<String> iterator1 = setOfKeys1.iterator();

		while (iterator1.hasNext()) {

			String key = (String) iterator1.next();

			Integer value = (Integer) Stemmer.treemap.get(key);

			if (value == 1) {
				count2++;
			}

		}
		System.out.println("");
		//System.out.println("The number of stems that occurs ony once: "+ count2);
		System.out.println("");
		SAXHandler.printdata(Stemmer.treemap);
		System.out.println("");
		//System.out.println("Average number of words stems per documents:"+ (Stemmer.wordcount) / a);
	}

	public static Set<String> readStopWords(String filename)
			throws FileNotFoundException {
		Set<String> stopWords = new HashSet<>();
		Scanner scanner = new Scanner(new File(filename));
		while (scanner.hasNext()) {
			stopWords.add(scanner.next());
		}
		scanner.close();
		return stopWords;
	}

	
}

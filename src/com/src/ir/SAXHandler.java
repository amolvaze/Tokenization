// Date of program submission:- 10-06-2014
/* Program for Tokenization and Stemming by asv130130 (Name:- AMOL VAZE )*/
// Code for SAXHandler and various methods needed by the program

package com.src.ir;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

//import org.xml.sax.helpers.DefaultHandler;

public class SAXHandler extends DefaultHandler {

	private List<Data> dList;
	private HashMap<String, Integer> map;
	public static int counter = 0;
	public static TreeMap<String, Integer> sorted_map;
	public static TreeMap<String, Integer> sorted_map1;

	public HashMap<String, Integer> getMap() {
		return map;
	}

	public void setMap(HashMap<String, Integer> map) {
		this.map = map;
	}

	public List<Data> getDataList(File filename)
			throws ParserConfigurationException, SAXException, IOException {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		parser.parse(filename, this);

		return dList;
	}

	public HashMap<String, Integer> getHasMap() {

		return map;
	}

	String docNo = "close";
	String title = "close";
	String author = "close";
	String biblio = "close";
	String plaintext = "close";

	@Override
	public void startDocument() throws SAXException {
		// System.out.println("Start document");
	}

	@Override
	public void endDocument() throws SAXException {
		// System.out.println("End document");
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {

		if (qName.equalsIgnoreCase("docNo")) {
			docNo = "open";
		} else if (qName.equalsIgnoreCase("title")) {
			title = "open";
		} else if (qName.equalsIgnoreCase("author")) {
			author = "open";
		} else if (qName.equalsIgnoreCase("biblio")) {
			biblio = "open";
		} else if (qName.equalsIgnoreCase("text")) {
			plaintext = "open";
		}

		// System.out.println("Start element: " + qName);

		if (plaintext.equals("open")) {
			// System.out.println("PlainText:");
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {

		// set boolean values for fields, will be used in setting Data
		// variables
		if (qName.equalsIgnoreCase("docNo")) {

			docNo = "close";
		}
		if (qName.equalsIgnoreCase("title")) {
			title = "close";
		}
		if (qName.equalsIgnoreCase("author")) {
			author = "close";
		}
		if (qName.equalsIgnoreCase("biblio")) {
			biblio = "close";
		}

		if (qName.equalsIgnoreCase("plaintext")) {
			plaintext = "close";
		}
		// System.out.println("End element: " + qName);
	}

	@Override
	public void characters(char ch[], int start, int length)
			throws SAXException {

		if (docNo.equals("open")) {

			try {
				storeInMap(getSplitTokens(new String(ch, start, length)));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// System.out.println("docNo : " + new String(ch, start, length));
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (title.equals("open")) {
			try {
				storeInMap(getSplitTokens(new String(ch, start, length)));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// System.out.println("title : " + new String(ch, start, length));
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (author.equals("open")) {
			try {
				storeInMap(getSplitTokens(new String(ch, start, length)));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// System.out.println("author : " + new String(ch, start, length));
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (biblio.equals("open")) {
			try {
				storeInMap(getSplitTokens(new String(ch, start, length)));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// System.out.println("biblio : " + new String(ch, start, length));
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (plaintext.equals("open")) {
			try {
				storeInMap(getSplitTokens(new String(ch, start, length)));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public String[] getSplitTokens(String token) {
		// String pattern = "[-_\"\'/,<>?.$#@%*~^&()/\\n\\t ]";
		String pattern = "[-_\"\'/,<>=?.$#@%*~^&+();:!?{}/\\n\\t\\r ]";
		String tokens[] = token.split(pattern);
		return tokens;
	}

	public void storeInMap(String[] tokenArray) throws IOException {

		String Filename = "C:/Computer_Data/Workspace/Tokenization/Text.txt";
		FileWriter f = new FileWriter(Filename, true);
		BufferedWriter bf = new BufferedWriter(f);
		if (tokenArray != null) {
			for (int i = 0; i < tokenArray.length; i++) {
				int val = 0;
				String token = tokenArray[i].toLowerCase();
				// System.out.println(token);
				if (!token.trim().isEmpty()) {
					String STOP_WORD_FILE_NAME = "./stopwords";
					Set<String> stopWords = Parser.readStopWords(STOP_WORD_FILE_NAME);
					
					bf.write(token);
					bf.newLine();
				

					if (map.get(token) != null) {
						val = map.get(token);
					}

					map.put(token, val + 1);
					counter++;

				}

			}
			bf.close();

		}

	}

	public static void print(HashMap<String, Integer> map) {
		{
			ValueComparator bvc = new ValueComparator(
					(Map<String, Integer>) map);
			 sorted_map = new TreeMap<String, Integer>(
					bvc);

			sorted_map.putAll(map);
          
			//System.out.println(sorted_map);
			//System.out.println(" The 30 most frequent words in the Crantfield collection:");
			int i = 1;
			for (Entry<String, Integer> entry : sorted_map.entrySet()) {

				//System.out.println("Top" + i + ": Key:" + entry.getKey()+ " And Value:" + entry.getValue());
				if (i == 30) {
					break;
				}
				i++;
			}

		}
	}

	public static void printdata(TreeMap<String, Integer> treemap) {
		ValueComparator bvc = new ValueComparator(
				(Map<String, Integer>) treemap);
		sorted_map1 = new TreeMap<String, Integer>(bvc);
		sorted_map1.putAll(treemap);

		//System.out.println(sorted_map);
		//System.out.println(" The 30 most frequent stems in the Crantfield collection:");
		int i = 1;
		for (@SuppressWarnings("unused") Entry<String, Integer> entry : sorted_map1.entrySet()) {

			//System.out.println("Top" + i + ": Key:" + entry.getKey()+ " And Value:" + entry.getValue());
			if (i == 30) {
				break;
			}
			i++;
		}

	}
	
	
	
	
	

}
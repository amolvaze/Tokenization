package com.src.ir;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigInteger;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.regex.Pattern;
public class IndexBuilder implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private static Set<String> stopWords;
	private static Map<String, DictionaryEntry> dictionary;
	public static Map<Integer, DocumentInfo> documentDetails;
	private static Integer documentIdIndex = 0;
	static Pattern pattern = Pattern.compile("<.?title>",Pattern.CASE_INSENSITIVE);
	static HashMap<String, Integer> termFreqTable;
	
	public IndexBuilder(Set<String> stopWords) {
		IndexBuilder.stopWords = stopWords;
		IndexBuilder.dictionary = new HashMap<String,DictionaryEntry>();
		IndexBuilder.documentDetails = new HashMap<Integer,DocumentInfo>();
	}
	
	public static Map<String, DictionaryEntry> buildIndex(String directoryPath) throws Exception{
		File directory = new File(directoryPath);
		termFreqTable = new HashMap<String, Integer>();
		for (File file : directory.listFiles()) {
			if (file.isFile()) {
			SAXHandler.print(Parser.map);
			Parser.map.putAll(termFreqTable);
			System.out.println(termFreqTable);
			String title = getTitle(file);
		updateIndex(++documentIdIndex, file.getName(), title, termFreqTable);
			}
			 		
			
		}
		
		return dictionary;
	}
	
	public static void updateIndex(Integer docId, String docName,String title, Map<String, Integer> termFreqTable) {		
		long maxTermFrequency = 0L, docLength = 0L;
		for(String term : termFreqTable.keySet()){
			int termFrequency = termFreqTable.get(term);			
			docLength +=  termFrequency;
			if(termFrequency > maxTermFrequency){
				maxTermFrequency = termFrequency;
			}
			
			if(!stopWords.contains(term)){
				updatePostingList(docId, term, termFreqTable.get(term));
			}
		}
		documentDetails.put(docId, new DocumentInfo(docId, docName, title, maxTermFrequency, docLength));
		//System.out.println(", docId = " + docId + " maxTermFreq = " + maxTermFrequency + ", docLength = " + docLength);
	}

	public static void updatePostingList(Integer docId, String term, Integer termFrequency) {
		DictionaryEntry entry = dictionary.get(term);
		if(entry == null){
			entry = new DictionaryEntry(term, 0, 0, new LinkedList<PostingEntry>());
			dictionary.put(term, entry);
		}
		entry.postingList.add(new PostingEntry(docId, termFrequency));
		entry.docFrequency += 1;
		entry.termFrequency += termFrequency;
	}
		
	@Override
	public String toString() {
		String[] terms = dictionary.keySet().toArray(new String[1]);
		Arrays.sort(terms);
		StringBuilder stringBuilder = new StringBuilder("");
		for(String term : terms){
			IndexBuilder.DictionaryEntry entry = dictionary.get(term);
			stringBuilder.append(entry);
		}
		return stringBuilder.toString();
	}
	
	static class DictionaryEntry implements Serializable {
	
		private static final long serialVersionUID = 1L;
		String term;
		Integer	docFrequency;
		Integer termFrequency;
		List<PostingEntry> postingList;
	
		public DictionaryEntry(String term, int docFrequency, int termFrequency, List<PostingEntry> postingList) {
			this.term = term;
			this.docFrequency = docFrequency;
			this.termFrequency = termFrequency;
			this.postingList = postingList;
		}

		@Override
		public String toString() {
			StringBuilder stringBuilder =   new StringBuilder("");
			stringBuilder.append("\n" + term + " " + docFrequency + "/" + termFrequency +"->"); 
			for(PostingEntry postingEntry : postingList){
				stringBuilder.append(postingEntry); 
			}
			stringBuilder.length();
			return stringBuilder.toString();
		}
	}
	
	static class PostingEntry implements Serializable {
		
		private static final long serialVersionUID = 1L;
		Integer docID;
		Integer frequency;
		
		public PostingEntry(Integer docID, Integer frequency) {
			this.docID = docID;
			this.frequency = frequency;
		}

		@Override
		public String toString() {
			return docID + "/" + frequency + ",";
		}
	}

	static class DocumentInfo implements Serializable{
		
		private static final long serialVersionUID = 1L;
		long docId, maxFreq; 
		Long docLength;
		String docName,title;
		public DocumentInfo(long docId, String docName, String title, long maxFreq, long docLength) {
			this.docId = docId;
			this.maxFreq = maxFreq;
			this.docLength = docLength;
			this.docName = docName;
			this.title = title;
		}
	}

	public static int getAvgDocLength() {
		BigInteger length = new BigInteger(Integer.toString(0));
		for(Integer docId : documentDetails.keySet()){
			length = length.add(new BigInteger(documentDetails.get(docId).docLength.toString()));
		}
		
		length =  length.divide(new BigInteger(Integer.toString(documentDetails.size())));
		return length.intValue();
	}

	public static String getTitle(File file) {
		try {
			String data = new String(Files.readAllBytes(file.toPath()));
			String[] parts= pattern.split(data);
			if(parts.length>1){
				return parts[1].replace("\n", " ");
			}else 
				System.out.println("...."+file.getPath());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}

// Date of program submission:- 10-06-2014
/* Program for Tokenization and Stemming by asv130130 (Name:- AMOL VAZE )*/
// Code for storing info

package com.src.ir;
public class Data {
	private String docNo;
	private String title;
	private String author;
	private String biblio;
	private String plaintext;

	public Data() {

	}

	public Data(String docNo, String title, String author, String biblio,
			String plaintext) {
		this.docNo = docNo;
		this.title = title;
		this.author = author;
		this.biblio = biblio;
		this.plaintext = plaintext;
	}

	public String toString() {
		String Data = "docNo:" + docNo + "\title:" + title + "author:" + author
				+ "\biblio:" + biblio + "plaintext:" + plaintext;
		return Data;

	}

	public void setdocNo(String docNo) {
		this.docNo = docNo;
	}

	public String getdocNo() {
		return docNo;
	}

	public void settitle(String title) {
		this.title = title;
	}

	public String gettitle() {
		return title;
	}

	public void setauthor(String author) {
		// TODO Auto-generated method stub
		this.author = author;
	}

	public String getauthor() {
		return author;
	}

	public void setbiblio(String biblio) {
		this.biblio = biblio;
	}

	public String getbiblio() {
		return biblio;
	}

	public void setplaintext(String plaintext) {
		this.plaintext = plaintext;
	}

	public String getplaintext() {
		return plaintext;

	}

}

package com.src.Stemmer;


public class Dummy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String name = "AA BB^CC\"DD\nwirthU.S)";
		
		String tokens[] = name.split("[-_\"\'/,<>?.$#@%*~^&()/\\n\\t ]");
		
		int length = tokens.length;
		
		System.out.println(length);
		for(int i=0;i<length;i++)
		{
			System.out.println(tokens[i]);
		}
		String test = "";
		if(test.trim().isEmpty())
		{
			System.out.println("test is empty");
		}
		else 
		{
			System.out.println("Not empty");
		}
		
	}

}

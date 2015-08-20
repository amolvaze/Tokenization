// Date of program submission:- 10-06-2014
/* Program for Tokenization and Stemming by asv130130 (Name:- AMOL VAZE )*/
// Code for sorting hashmap with respect to values

package com.src.ir;

import java.util.Comparator;
import java.util.Map;

public class ValueComparator implements Comparator<String> {
	Map<String, Integer> base;

	public ValueComparator(Map<String, Integer> map) {
		this.base = map;
	}

	// Note: this comparator imposes orderings that are inconsistent with
	// equals.
	public int compare(String a, String b) {
		if (base.get(a) >= base.get(b)) {
			return -1;
		} else {
			return 1;
		} // returning 0 would merge keys
	}
}
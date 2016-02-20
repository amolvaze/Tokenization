# Tokenization - Project.
Detailed solution with output of the program:- By Amol Vaze.

1. How long the program took to acquire the text characteristics.
Ans : The amount of time taken by the program is on an average around 2
second.
2. How the program handles:
A. Upper and lower case words (e.g. "People", "people", "Apple",
"apple");
Ans : The program converts all tokens to lowercase (String.toLowercase()
function is used.)
B. Words with dashes (e.g. "1996-97", "middle-class", "30-year", "teanager")
Ans : It basically splits the tokens on dashes due to the pattern used in
the program.
C. Possessives (e.g. "sheriff's", "university's")
Ans : It is able to remove all "'s" from token which is mentioned in the
pattern itself.
D. Acronyms (e.g., "U.S.", "U.N.")
Ans : It is able to remove it e.g US , UN
3. Major algorithms and data structures used by the program.
 3.1 Program uses a class named "Data" which basically holds all
the necessary object information needed by the other classes.
 3.2 Used SAXParser which basically implements DefaultHandler
interface and its overriddden methods are reponsible for parsing the file
data.
 3.3 Used HashMap<String, Integer> for dictionary or for the storage
purpose.
 3.4 Program keeps track of counter to display total no of tokens
and no of distinct tokens in the dictionary.
 3.5 Program Uses TreeSet and ValueComparator class that implements
Comparator interface to sort hashmap by values and print top 30 words
with their frequencies.
*************************************************************************
Output- Part-1- Tokenization
*************************************************************************
*
1. Time Taken = 2079 milliseconds
2. The total number of tokens = 272662
3. The number of unique/distinct tokens in the cranfield collection =
10425
4. The number of tokens that occur only once = 2464
5. The average number of word tokens per document = 194
*************************************************************************
6. The 30 most frequent words in the Cranfield collection:
Top1: Key:the And Value:20202
Top2: Key:of And Value:14064
Top3: Key:and And Value:7644
Top4: Key:a And Value:7157
Top5: Key:in And Value:5031
Top6: Key:to And Value:4717
Top7: Key:is And Value:4118
Top8: Key:for And Value:3716
Top9: Key:with And Value:2444
Top10: Key:are And Value:2431
Top11: Key:on And Value:2332
Top12: Key:flow And Value:2179
Top13: Key:at And Value:2076
Top14: Key:by And Value:1807
Top15: Key:j And Value:1769
Top16: Key:that And Value:1569
Top17: Key:an And Value:1513
Top18: Key:boundary And Value:1341
Top19: Key:pressure And Value:1321
Top20: Key:be And Value:1273
Top21: Key:from And Value:1165
Top22: Key:layer And Value:1161
Top23: Key:as And Value:1123
Top24: Key:this And Value:1080
Top25: Key:number And Value:1032
Top26: Key:which And Value:981
Top27: Key:r And Value:966
Top28: Key:mach And Value:915
Top29: Key:results And Value:896
Top30: Key:theory And Value:871
*************************************************************************
Output- Part-2-Stemming
*************************************************************************
*
The total number of stemmed tokens are:260378
The number of distinct/unique stems in the cranfield text collection are:
5697
The number of stems that occurs ony once: 1325
Average number of words stems per documents:185
*************************************************************************
*
The 30 most frequent stems in the Crantfield collection:
Top1: Key:the And Value:20214
Top2: Key:of And Value:14076
Top3: Key:and And Value:7645
Top4: Key:a And Value:7211
Top5: Key:in And Value:5047
Top6: Key:to And Value:4722
Top7: Key:is And Value:4118
Top8: Key:for And Value:3718
Top9: Key:on And Value:2659
Top10: Key:ar And Value:2480
Top11: Key:flow And Value:2455
Top12: Key:with And Value:2446
Top13: Key:at And Value:2078
Top14: Key:by And Value:1809
Top15: Key:j And Value:1773
Top16: Key:that And Value:1570
Top17: Key:an And Value:1517
Top18: Key:pressur And Value:1513
Top19: Key:number And Value:1448
Top20: Key:boundari And Value:1372
Top21: Key:be And Value:1370
Top22: Key:layer And Value:1320
Top23: Key:from And Value:1165
Top24: Key:effect And Value:1147
Top25: Key:as And Value:1124
Top26: Key:result And Value:1101
Top27: Key:thi And Value:1082
Top28: Key:it And Value:1054
Top29: Key:r And Value:1037
Top30: Key:heat And Value:988
*************************************************************************

Note->1. I have used the dynamic file path in the program, so it is
needed to run configuration for running the program.

Note-> 2. Also, I have used 2 text files viz Text.txt and Text1.txt in
the program respectively. First one, Text.txt is basically used to store
all the tokens of Cranfeild collection and second one Text1.txt is used
where it contains all stemmed tokens after applying stemming. Hence,
while running the program it is required to create these two text files
and then hardcode the path in the respective locations.

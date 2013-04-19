//Assignemnt 5 DP Count Sequence Problem A
//A similar problem to Longest Common Subsequence, using DP
//and a hashtable for memoization

import java.util.*;
public class countseq {
	//Make our Hashmap global
	static HashMap<String, Integer> hashy;

	public static void main(String[] args){
	//To take in input from console
		Scanner stdin = new Scanner(System.in);

		int index1 =0, index2 =0;

		//Scan in num cases
		int cases = stdin.nextInt();

		//For each case
		while(cases != 0){
			//Create a new hash map for the case
			hashy = new HashMap<String, Integer>();

			//Take in the sequence we're looking at
			String seq = stdin.next();

			//And the subsequence we are looking for
			String subseq = stdin.next();

				System.out.println(findshtuff(seq, subseq, index1, index2));

			cases--;
		}
	}


	public static int findshtuff(String seq, String subseq, int index1, int index2) {
		int answer = 0;

		//Base case, if
		if(index2 == subseq.length())
			return 1;

		//If we've already done the work, just return what's stored index of the sequence and the substring at index2
		if(hashy.containsKey(index1 + subseq.substring(index2)))
		{
			return hashy.get(index1 + subseq.substring(index2));
		}

		//We start index1 at the beginning of the sequence we are looking at
		for(int i = index1; i < seq.length(); i++){

			//If at position i in the sequence we find the same character at position i in the subsequence
			if (seq.charAt(i) == subseq.charAt(index2)){

				//We increase the answer and move the indexes up by 1
				answer += findshtuff(seq, subseq, i+1, index2+1);
			}
		}

		//Either way, we make the the index of the sequence + the substring at index2 as our key, and store the answer as our value
		hashy.put(index1 + subseq.substring(index2), answer); //substring takes whatever the string is from the given index and onward

		return answer;
	}
}

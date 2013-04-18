import java.util.*;
public class countseq {

	static HashMap<String, Integer> hashy;

	public static void main(String[] args){

		Scanner stdin = new Scanner(System.in);

		int index1 =0, index2 =0;

		int cases = stdin.nextInt();

		while(cases != 0){

			hashy = new HashMap<String, Integer>(); //Reseting

			String seq = stdin.next();
			String subseq = stdin.next();

				System.out.println(findshtuff(seq, subseq, index1, index2));

			cases--;
		}
	}

	public static int findshtuff(String seq, String subseq, int index1, int index2) {
		int answer = 0;

		//Base case
		if(index2 == subseq.length())
			return 1;

		if(hashy.containsKey(index1 + " " + subseq.substring(index2)))
		{
			return hashy.get(index1 + " " + subseq.substring(index2));
		}


		for(int i = index1; i < seq.length(); i++){
			if (seq.charAt(i) == subseq.charAt(index2)){
				answer += findshtuff(seq, subseq, i+1, index2+1);

			}

		}

		hashy.put(index1+ " " + subseq.substring(index2), answer);

		return answer;

	}
}

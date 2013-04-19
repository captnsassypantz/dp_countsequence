//CS2
//Assignment 5 DP Sticks Problem C
//Program similar to the coin changing problem, except we find
//the min cost to make cuts to a stick using DP and a hashtable for memoization

import java.util.*;

public class sticks {

	//Making my hashmap "hashy" global
	static HashMap<Integer, Integer> hashy;

	public static void main(String[]args){

		//New scanner to read in input from console
		Scanner stdin = new Scanner(System.in);

		//Take in number of cases
		int cases = stdin.nextInt();

		//Self explanatory
		while(cases != 0){

			//Creates a new instance of the hashmap, "hashy", effectively resetting it for every case
			hashy = new HashMap<Integer, Integer>(); //Reseting

			int minCost;

			//Take in the stick length
			int sticklength = stdin.nextInt();

			//Take in the number of cuts to be made to the stick
			int numCuts = stdin.nextInt();

			//Make an array out of the positions at which the stick needs to be cut
			ArrayList<Integer> arrCuts = new ArrayList<Integer>();

			//For however many cuts there are
			for(int i = 0; i < numCuts; i++)
			{	//Add the position of the cut to the arrayList
				arrCuts.add(stdin.nextInt());
			}

			//Send the original stick length and cut list to the function
			minCost = findshtuff(sticklength, arrCuts);

			System.out.println(minCost);
		}
			//Move to next case
			cases--;
		}


	public static int findshtuff(int sticklength, ArrayList<Integer> arrCuts) {

		//Set the cost high to compare it to lowest case
		int cost = 65535, tempcost;
		ArrayList<Integer> newarr, newarr2;

		//Base case
		if(arrCuts.isEmpty())
			return 0;

		//If my hash map contains the key of original sticklength, we've already
		//done the work, so return the value stored there
		if(hashy.containsKey(sticklength))
		{
			return hashy.get(sticklength);
		}

		//For the size of the array list (# of cuts)...
			for(int i = 0; i < arrCuts.size(); i++){

				//Make new stick length after cut??
				int stickRight = sticklength, stickLeft;

				//CHOP
				//Now we have two sticks, on the right side, we have the stick cut down to whatever
				//It's original length was, minus the part we chopped off
				stickRight -= arrCuts.get(i);

				//The stick on the left is now just the size of whatever the cut was we just made
				stickLeft = arrCuts.get(i);

				//Now we make a new ArrayList
				newarr2 = new ArrayList<Integer>();

				//Add the arraylist of cuts to the new array
				for(int j = 0; j < i; j++){
					newarr2.add(arrCuts.get(j));
				}

				//Same as above except..
				newarr = new ArrayList<Integer>();

				//We put the original cuts from our first array at index k, minus the same cut at index before it
				for(int k = i+1; k < arrCuts.size(); k++){
					newarr.add(arrCuts.get(k) - arrCuts.get(i));

				}

				//The temporary cost is the original stick length, plus the cost of cutting the right and left stick
				tempcost = sticklength + findshtuff(stickRight, newarr) + findshtuff(stickLeft, newarr2);

				//If the tempcost is smaller than the current mincost
				if(tempcost < cost)
					cost = tempcost;

				//Put the value of the minimum cost plus the sticks length into the hashmap
				hashy.put(sticklength, cost); //This aint gonna work
			}

			return cost;
	}

}

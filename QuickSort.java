/**
 * This is an implementation of QuickSort as discussed in lectures
 * for the course: Algorithm Desing and Analysis (Stanfort University)
 * TODO: link!
 * 
 * Created on 21-10-2016
 * @author Marit van Dijk
 */

package Algo1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QuickSort {
	public static void main (String[] args) throws IOException{
// Test cases:
		List<Integer> input = new ArrayList<>(Arrays.asList(3, 8, 2, 5, 1, 4, 7, 6)); // Unsorted - ANS: 3
		
// From FILE:		
//		// Input: Read input from file (create array of Integers, size n)
//		List<Integer> numbers = new ArrayList<>(); // Original list
//		try (BufferedReader in = new BufferedReader(new FileReader("/Users/Marit/workspace/coursera/src/Algo1/IntegerArray.txt"));){			
//			String line;
//			while((line = in.readLine()) != null){
//				numbers.add(Integer.parseInt(line));
//			}
//		}
//		System.out.println("File read...");
		
		// 1. If n = 1 return
		if (input.size() == 1) {
			return;
		} else {
// 2. Choose pivot
			// Note; Assume pivot is first element of array
			// If not, swap pivot and first element of array
			int p = choosePivot(input); // from array A, with length n
			Collections.swap(input, p, 0);			

			// 3. Partition A around p:
			// Partition (array A, from left element l, to right element r)
			int l = 0;
			int r = input.size() - 1;
			partition(input, l, r);
			
			// 4. resursively sort left (how?)
			// 5. resursively sort right (how?)
			
		}
		System.out.println(input);

	}

	private static void partition(List<Integer> input, int l, int r) {
		int p = input.get(0); // Start with leftmost element as pivot p
		int i = l + 1;
		int j = l + 1;
		int n = r + 1;
		
		for (j = j; j < n; j++){
			System.out.println("j is " + j);
			System.out.println(input);
			if (input.get(j) < p) {
				Collections.swap(input, i, j);
				i++;
			}
			// if (input.get(j) > p) { // do nothing )
			// if (input.get(j) == p) { // assume there are no duplicates, so do nothing (exercise; how to deal with duplicates )
		}
		Collections.swap(input, i - 1, 0); 	// original pivot now in correct place.
	} // end partition
	

	// Note: random does not work (yet)
	public static int choosePivot(List<Integer> list){
		List<Integer> l = list;
		int n = l.size();
		// Use random element of array as pivot
		int r = (int) Math.random() * n; // should return an index within range (check??)
//		int p = l.get(r); 
		return r;
		
	}
	
	
}

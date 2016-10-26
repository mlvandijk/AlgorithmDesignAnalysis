/**
 * This is an implementation of MergeSort as discussed in lectures
 * for the course: Algorithm Design and Analysis (Stanford University)
 * https://www.coursera.org/learn/algorithm-design-analysis/exam/YLbzP/programming-assignment-1
 * 
 * Created on 15-10-2016
 * @author Marit van Dijk
 */

package Algo1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {
	static long count = 0; // Number of inversions
	public static void main (String[] args) throws IOException{
// Test cases:
//		List<Integer> numbers = new ArrayList<>(Arrays.asList(1,3,5,2,4,6)); // Unsorted - ANS: 3
//		List<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6)); // Sorted - ANS: 0
//		List<Integer> numbers = new ArrayList<>(Arrays.asList(4,5,6,1,2,3)); // Unsorted (sorted halves) - ANS: 9
//		List<Integer> numbers = new ArrayList<>(Arrays.asList(1,6,3,2,4,5)); // Unsorted - ANS: 5
		
//		Test Case - #1 - 15 numbers
//		List<Integer> numbers = new ArrayList<>(Arrays.asList(9, 12, 3, 1, 6, 8, 2, 5, 14, 13, 11, 7, 10, 4, 0));
//		Ans - 56
		
//		Test Case - #2 - 50 numbers
//		List<Integer> numbers = new ArrayList<>(Arrays.asList(37, 7, 2, 14, 35, 47, 10, 24, 44, 17, 34, 11, 16, 48, 1, 39, 6, 33, 43, 26, 40, 4, 28, 5, 38, 41, 42, 12, 13, 21, 29, 18, 3, 19, 0, 32, 46, 27, 31, 25, 15, 36, 20, 8, 9, 49, 22, 23, 30, 45));
//		Ans - 590

//		Test Case - #3 - 100 numbers
//		List<Integer> numbers = new ArrayList<>(Arrays.asList(4, 80, 70, 23, 9, 60, 68, 27, 66, 78, 12, 40, 52, 53, 44, 8, 49, 28, 18, 46, 21, 39, 51, 7, 87, 99, 69, 62, 84, 6, 79, 67, 14, 98, 83, 0, 96, 5, 82, 10, 26, 48, 3, 2, 15, 92, 11, 55, 63, 97, 43, 45, 81, 42, 95, 20, 25, 74, 24, 72, 91, 35, 86, 19, 75, 58, 71, 47, 76, 59, 64, 93, 17, 50, 56, 94, 90, 89, 32, 37, 34, 65, 1, 73, 41, 36, 57, 77, 30, 22, 13, 29, 38, 16, 88, 61, 31, 85, 33, 54));
//		Ans - 2372 
		
		
// From FILE:		
		// Input: Read input from file (create array of Integers, size n)
		List<Integer> numbers = new ArrayList<>(); // Original list
		try (BufferedReader in = new BufferedReader(new FileReader("/Users/Marit/workspace/coursera/src/Algo1/IntegerArray.txt"));){			
			String line;
			while((line = in.readLine()) != null){
				numbers.add(Integer.parseInt(line));
			}
		}
		System.out.println("File read...");
		
		// Split into 2 sub-arrays A and B and copy elements / read into 2 arrays
		int n = numbers.size();
		List<Integer> A = numbers.subList(0, n/2);
		List<Integer> B = numbers.subList(n/2, n);
		List<Integer> C = new ArrayList<>();
		
		// Recursively sort both arrays A and B (and increment count with nr of inversions)
		System.out.println("Sorting A...");
		A = sort(A);
		System.out.println("Sorting B...");
		B = sort(B);
		System.out.println("A: "+ A + ", B: " + B + " count: " + count);
		
		// Merge sorted arrays:
		int i = 0;
		int j = 0;
		for (int k = 0; k < n; k++){
			if (i == A.size() || j == B.size()) { // Check for end of sub-array
				// Add remaining nrs from B -> no inversions
				break;
			}
			if (A.get(i) < B.get(j)){
				C.add(k, A.get(i));
				i++;
			} else { // if (A[i] > B[j]){
				C.add(k, B.get(j));
				j++;
				count += A.size() - i;
			}
		 }	 
		System.out.println(count);
	}
	
	
	public static List<Integer> sort(List<Integer> listIn){
		List<Integer> list = listIn;	
		boolean unordered = true;
		while (unordered){
			unordered = false;
			for (int i = 1; i < list.size(); i++){	
				if (list.get(i) < list.get(i-1)){
					int swap = list.get(i-1);
					list.set(i-1, list.get(i));
					list.set(i, swap);
					count++;
					unordered = true;
				}
			}		
		}
		System.out.println("List is: " + list);
		return list;
	}

}

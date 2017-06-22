package sorts;
// File: Mergesort.java
// A Java application to illustrate the use of a merge sort
// Additional javadoc documentation is available at:
//   http://www.cs.colorado.edu/~main/docs/Mergesort.html
// MODIFIED: S. Haller 11/19/07
public class MergeSort extends Sorter {
	// Constructor
	public MergeSort (int [] data,int m) {
		super(data,m);
	}

	public void sort ()  {
		mergesort(0, array.length);
		gui.complete();
	}


	// Sort an array of elements from smallest to largest, using a merge sort
	// algorithm.
	// 
	// Parameters:
	//   first -   start index for the portion of the array that will be sorted
	//   n -  the number of elements to sort
	// Precondition:
	//   a[first] through a[first+n-1] are valid  parts of the array.
	// Postcondition:
	//   If n is one, zero or negative then no work is done. Otherwise, 
	//   the elements of data have been rearranged so that 
	//   a[first] <= a[first+1] <= ... <= a[first+n-1].
	private  void mergesort(int first, int n)  {
		if (n <= 1)
			return;
		// Compute sizes of the two halves
		int n1 = n / 2;
		int n2 = n - n1;
		// Sort a[first] through a[first+n1-1]
		mergesort(first, n1); 
		// Sort a[first+n1] to the end
		mergesort(first + n1, n2);

		// Merge the two sorted halves.
		merge(first, n1, n2);
	} 

	// Merge the sorted halves
	// Precondition: data has at least n1 + n2 components starting at
	//    a[first]. The first  n1 elements (from a[first] to 
	//    a[first + n1 - 1] are sorted from smallest 
	//    to largest, and the last n2 (from a[first + n1] to 
	//    a[first + n1 + n2 - 1]) are also sorted from smallest to largest. 
	// Postcondition: Starting at a[first], n1 + n2 elements of data
	//    have been rearranged to be sorted from smallest to largest.
	private  void merge(int first, int n1, int n2)  {
		while(gui.bNum()==3){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Integer[] temp = new Integer[n1+n2];

		// Number copied to temp
		int copied = 0;
		// Number copied from the first half of a 
		int copied1 = 0;
		// Number copied from the second half of a
		int copied2 = 0; 

		// Merge elements, copying from two halves of a to the
		// temporary array.
		while ((copied1 < n1) && (copied2 < n2))      {
			if (array[first + copied1] <array[first + n1 + copied2]) 
				temp[copied++] = array[first + (copied1++)];
			else
				temp[copied++] = array[first + n1 + (copied2++)];
		}

		// Copy any remaining entries in the left and right subarrays.
		while (copied1 < n1) {
			temp[copied++] = array[first + (copied1++)];
		}

		while (copied2 < n2) {
			temp[copied++] = array[first + n1 + (copied2++)];
		}

		// Copy from temp back to the real array.
		for (int i = 0; i < n1+n2; i++) {
			array[first + i] = temp[i];
		}
		update();
	}

}



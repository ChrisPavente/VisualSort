package sorts;
public class QuickSort extends Sorter {

	public QuickSort(int [] a,int m) {
		super(a,m);
	}


	// Rearranges the elements of a into sorted order using
	// the quicksort algorithm.
	public  void sort() {
		quickSort(0, array.length);
		gui.complete();
	}

	// Parameters: first - first position to start sorting at
	//             n - number of values to sort starting from "first"
	public void quickSort(int first, int n) {
		// if we are sorting one or fewer places, it's sorted!!!!
		if (n <= 1) 
			return;

		// partition the n items around the item in a[first] (the pivot)
		// and return where a[first] is now located
		int pivotIndex = partition(first, n);

		// get the size of the pieces on either side of the pivot
		int n1 = pivotIndex - first;
		int n2 = n - n1 - 1;

		// and quicksort the two pieces on either side of the pivot
		quickSort(first, n1);
		quickSort(pivotIndex+1, n2);
	}

	// Parameters: first - first position  in the position (also the pivot)
	//             n - number of values to partition
	// Postcondition: a[first]-a[pivotIndex-1] <= a[pivotIndex] 
	//                a[pivotIndex] < a[pivotIndex+1]-a[first + n]
	private  int partition(int first, int n)  {
		while(gui.bNum()==3){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		int pivotIndex = first;
		setIndexA(pivotIndex);
		int last = first + n - 1;
		int pivotValue = array[first];
		while (first <= last) {
			while (first <= last && array[first] <= pivotValue) {
				first++;
			}
			while (last >= first && array[last] > pivotValue) {
				last--;
			}
			if (first < last)  {
				swap(first, last);
			}
		}
		swap(pivotIndex, last);
		update();
		return last;
	}



}

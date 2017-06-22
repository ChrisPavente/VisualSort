A simple sort visualizer,
supports the following sorts: Insertion, Bubble, Counting

InsertionSort: Starting at index i, all elements of index less then i are assumed sorted, the remaining unsorted portion of the array is scanned to find the least integer remaining. Once the least element is found, the ith element is swapped with the least element. Then i is incremented.

Bubble Sort: Compares adjacent element of the array, swaps them if they are out of order. If a pass of the entire array is made with no swap, the sort is complete.

Counting: Makes an extra array whose size is determined by the largest element in the array to be sorted. The sort then sweeps the array, counting the number of times each number occurs. After the sweep the sort can put the orignal array in order by running through the extra array starting at index 1, which holds the number of occurences of the number 1 in the original array, and then puts that many 1's at the start of the to be sorted array. Then continues this process until the extra array has only zeros in it.


To run, compile MainMenu.java in the gui folder then run it.

Created by:
Christopher Pavente
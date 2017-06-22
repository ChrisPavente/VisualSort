package sorts;
/**
 * 
 */

/**
 * @author Chris
 *
 */
public abstract class Sorter {
	protected int[] array;
	private int indexA;
	private int indexB;
	protected boolean sorted;
	private int max; //Used for graphics, and counting sort uses this to cheat
	
	public Sorter(int[] a,int m){
		array=a;
		setIndexA(-1);
		setIndexB(-1);
		sorted=false;
		max=m;
	}
	
	public int getAtIndex(int i){
		return array[i];
	}
	
	public int getMax(){
		return max;
	}
	
	public boolean isSorted(){
		return sorted;
	}
	public int getIndexA() {
		return indexA;
	}
	
	public int getIndexB() {
		return indexB;
	}
	protected void setIndexA(int indexA) {
		this.indexA = indexA;
	}
	protected void setIndexB(int indexB) {
		this.indexB = indexB;
	}
	
	//Should make the underlying sorter take one step in the sort algorithm
	//to be implemented by subclass.
	public abstract void step();
	//
	/*
	 * @Return returns the index of the first integer in a comparison, returns -1 if using 
	 * a non-comparison based sort.
	 */
	public int indexOfA(){
		return getIndexA();
	}
	/*
	 * @Return returns the index of the second integer in a comparison, returns -1 if using
	 * a non-comparison based sort.
	 */
	public int indexOfB(){
		return getIndexB();
	}
	
	
	
	/*
	 * @Returns the length of the array being sorted
	 */
	public int Length(){
		return array.length;
	}
	
	/*
	 * Swaps the i and j entry of the array
	 */
	protected void swap(int i,int j){
		int hold = array[i];
		array[i]=array[j];
		array[j]=hold;
	}
	
	
		

	//Fills the given array with random integers between 1-max
	public static void fillRandom(int[] a,int max){
		for(int i=0;i<a.length;i++){
			a[i]= (int) (1+Math.random()*max);
		}
	}


}

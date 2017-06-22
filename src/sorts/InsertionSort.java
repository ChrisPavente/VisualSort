package sorts;
/**
 * @author Chris Pavente
 * Insertion Sort: Assumes everything before indexA has been sorted, then finds the smallest
 * number remaining in the array and swaps it with the value at indexA 
 */
public class InsertionSort extends Sorter {
	int indexOfSmallest;
	public InsertionSort(int[] a,int m) {
		super(a,m);
		setIndexA(0);
		setIndexB(0);
		indexOfSmallest=0;
	}

	@Override
	public void step() {
		if(array[getIndexB()]<=array[indexOfSmallest]){
			indexOfSmallest=getIndexB();
		}
		setIndexB(getIndexB() + 1);
		if(getIndexB()==array.length){
			if(indexOfSmallest>getIndexA()){
				swap(indexOfSmallest,getIndexA());
			}
			//reset
			if(getIndexA()==array.length-1){
				sorted=true;
				setIndexA(-1);
				setIndexB(-1);
			}
			else{
				setIndexA((getIndexA() + 1));
				setIndexB(getIndexA());
				indexOfSmallest=getIndexA();
			}
		}
	}
	
	public String toString(){
		return "InsertionSort";
	}

}

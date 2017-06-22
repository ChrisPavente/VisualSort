package sorts;
/**
 * @author Chris Pavente
 * Bubble Sort: Swaps adjacent entries of the array that are not in the correct order, largest
 * element is put at the end after first full pass.
 */
public class BubbleSort extends Sorter {
	int swaps;
	public BubbleSort(int[] a, int m) {
		super(a, m);
		setIndexA(0);
		setIndexB(1);
		swaps=0;
	}

	@Override
	public void step() {
		if(getIndexB() < array.length){
			if(array[getIndexB()]<array[getIndexA()]){
				swaps++;
				swap(getIndexB(),getIndexA());
			}
			setIndexA(getIndexA() + 1);
			setIndexB(getIndexB() + 1);
		}
		if(getIndexB()==array.length){
			setIndexB(1);
			setIndexA(0);
			if(swaps==0){
				sorted=true;
			}
			swaps=0;
		}
	}
	
	public String toString(){
		return "BubbleSort";
	}

}

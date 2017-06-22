package sorts;
/**
 * @author Chris Pavente
 * Bubble Sort: Swaps adjacent entries of the array that are not in the correct order, largest
 * element is put at the end after first full pass.
 */
public class BubbleSort extends Sorter {
	boolean swap;
	public BubbleSort(int[] a, int m) {
		super(a, m);
		setIndexA(0);
		setIndexB(1);
		swap=false;
	}

	public void sort(){
		while(!sorted){
			if(gui.bNum() !=3){
				step();
				update();
			}
		}
		gui.complete();
	}
	
	public void step() {
		if(getIndexB() < array.length){
			if(array[getIndexB()]<array[getIndexA()]){
				swap=true;;
				swap(getIndexB(),getIndexA());
			}
			setIndexA(getIndexA() + 1);
			setIndexB(getIndexB() + 1);
		}
		if(getIndexB()==array.length){
			setIndexB(1);
			setIndexA(0);
			if(!swap){
				sorted=true;
			}
			swap=false;
		}
	}
	
	public String toString(){
		return "BubbleSort";
	}

}

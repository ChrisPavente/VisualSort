package sorts;
/**
 * @author Chris Pavente
 * Counting Sort: a cheap sorting algorithm that just counts the occurrences of numbers
 * in the array and fills up the array accordingly.
 */

import java.util.Arrays;

//A cheating sort algorithm that uses a ton of extra space
public class CountingSort extends Sorter {
	int[] cheat;
	public CountingSort(int[] a, int m) {
		super(a, m);
		cheat = new int[m];//Needs a whole bunch more space!
		Arrays.fill(cheat,0);
		setIndexA(0);
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
		if(getIndexA()<array.length){
			cheat[array[getIndexA()]]++;
			setIndexA(getIndexA()+1);
		}
		else{
			sorted=true;
			setIndexA(0);
			int i=0;
			for(int j=0;j<cheat.length;j++){
				while(cheat[j]>0){
					array[i]=j;
					cheat[j]--;
					i++;
				}
			}
		}
	}
	
	public String toString(){
		return "Counting";
	}

}

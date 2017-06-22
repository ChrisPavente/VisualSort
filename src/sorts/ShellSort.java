package sorts;
/*
 Name:Chris Pavente
 Course: CIS 203
 Assignment: 8
 Due: 10/31/14
 */
public class ShellSort extends Sorter{

	//Constructors
	public ShellSort(int[] a,int m) {
		super(a,m);
		setIndexA(0);
		setIndexB(0);
		//indexOfSmallest=0;
	}

	//Postcondition:The Array is sorted using the ShellSort algorithim
	public void sort(){
		for(int skipDistance = array.length/2;skipDistance>0;skipDistance/=2){
			//divides our skip distance in half until it is 0 
			for(int startPosition =0;startPosition<skipDistance;
					startPosition++){
				//Runs an insertionsort on our subarray starting at 
				//startPosition and accounting for our skipDistance
				subSetSorter(startPosition,skipDistance);
			}
			
		}
		gui.complete();
	}

	//Parameters: start-the index we are starting our Shellsort on
	//            skip-our skip distance
	//Postcondition:our subArray  is sorted
	private void subSetSorter(int start, int skip){
		setIndexA(start);
		for(int i=start+skip;i<array.length;i+=skip){
			int temp = array[i];
			int insertPosition =start;
			setIndexB(i);
			while(gui.bNum() ==3){
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			for(int pos =i-skip;pos>=0 && insertPosition==start;
					pos-=skip){
				if(array[pos] <= temp){
					insertPosition =pos+skip;
					setIndexA(insertPosition);
				}
				else{
					array[pos+skip] = array[pos];
				}
			}
			array[insertPosition] =temp;
			update();
		}
	}

}

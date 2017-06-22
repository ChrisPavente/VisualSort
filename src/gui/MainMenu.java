/**
 * @author Chris Pavente
 * Allows the user to choose a sorting algorithm to watch
 */
package gui;
import javax.swing.JFrame;
import javax.swing.JLabel;

import sorts.CountingSort;
import sorts.BubbleSort;
import sorts.InsertionSort;
import sorts.Sorter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
public class MainMenu extends JFrame {
	JButton[] size; //stores the 3 buttons corresponding to the sorter array size
	JButton[] max;//stores the 3 buttons corresponding to the max integer size for the sorter
	JButton[] sort;//stores the buttons corresponding to the different sorts implemented
	int arraySize=10;
	int maxInt=10;
	int sortChoice=-1;
	
	public MainMenu(){
		this.setTitle("Visual Sort");
		this.getContentPane().setLayout(null);
		this.setBounds(0, 0, 600, 440);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		size = new JButton[3];
		max = new JButton[3];
		sort = new JButton[3];
		Setup();
	}
	
	//Arranges the buttons and labels on the Frame
	private void Setup(){
		size[0] = makeSizeButton(1,"Small");
		size[1] = makeSizeButton(2,"Medium");
		size[2] = makeSizeButton(3,"Large");
		for(JButton j:size){
			this.add(j);
		}
		JLabel t=new JLabel();
		t.setText("Array Size:");
		t.setBounds(103, 10, 100, 30);
		this.add(t);
		max[0] = makeMaxButton(1,"Small");
		max[1] = makeMaxButton(2,"Medium");
		max[2] = makeMaxButton(3,"Large");
		for(JButton j:max){
			j.setEnabled(false);
			this.add(j);
		}
		t=new JLabel();
		t.setText("Max Integer:");
		t.setBounds(103, 110, 100, 30);
		this.add(t);
		
		sort[0] = makeSortButton(0,"Insertion");
		sort[1] = makeSortButton(1,"Bubble");
		sort[2] = makeSortButton(2,"Counting");
		for(JButton j:sort){
			j.setEnabled(false);
			this.add(j);
		}
		t=new JLabel();
		t.setText("Sort Type:");
		t.setBounds(103, 210, 100, 30);
		this.add(t);
		this.setVisible(true);
		while(sortChoice ==-1){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		int[] a = new int[arraySize];
		Sorter.fillRandom(a, maxInt);
		
		Sorter s;
		if(sortChoice==0){
			s = new InsertionSort(a,maxInt+5);
		}
		else if(sortChoice==1){
			s=new BubbleSort(a,maxInt+5);
		}
		else{
			s =new CountingSort(a,maxInt+5);
		}
		this.setVisible(false);
		s.update();
		s.sort();
		//ui.drawState();

	}
		
	//Returns a SizeButton with corresponding listener and label
	private JButton makeSizeButton(int i, String s){
		JButton b = new JButton();
		b.setText(s);
		b.setBounds(40*(i-1)*3+100, 40, 100, 30);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				arraySize =15*(i)*(5/3);
				for(JButton j: size){
					j.setEnabled(false);
				}
				for(JButton j: max){
					j.setEnabled(true);
				}
				b.setEnabled(true);
				
			}
		});
		return b;
	}
	
	//Returns a SortButton with corresponding listener and label
	private JButton makeSortButton(int i, String s){
		JButton b = new JButton();
		b.setText(s);
		b.setBounds(40*(i)*3+100, 240, 100, 30);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(JButton j: sort){
					j.setEnabled(false);
				}
				b.setEnabled(true);
				sortChoice=i;
			}
		});
		return b;
	}
	
	
	
	//Returns a MaxButton with corresponding listener and label
	private JButton makeMaxButton(int i, String s){
		JButton b = new JButton();
		b.setText(s);
		b.setBounds(40*(i-1)*3+100, 140, 100, 30);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(JButton j: max){
					j.setEnabled(false);
				}
				for(JButton j: sort){
					j.setEnabled(true);
				}
				b.setEnabled(true);
				maxInt = i*15;
			}
		});
		return b;
	}
	
	
	public static void main(String[] args) {
		new MainMenu();
	}

}

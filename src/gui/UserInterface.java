
/**
 * @author Chris Pavente
 * Allows the user to watch simple comparison based sorts
 */
package gui;
import javax.swing.JFrame;
import javax.swing.JPanel;

import sorts.Sorter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

public class UserInterface extends JFrame {
	private Sorter sort;//Sorter being used
	private int bNum=3; //Stores which of the 3 buttons are currently "pressed"
	//Run=1, Step=2, Stop=3
	private long timeStep=200;
	private boolean finish=false;
	
	public UserInterface(Sorter s){
		super();
		sort=s;
		setup();
	}
	
	//Setup the window
	private void setup(){
		this.setTitle("Visual Sorter: " + sort.toString());
		this.getContentPane().setLayout(null);
		this.setBounds(0, 0, 600, 640);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add(makeButton(1,"Run"));
		this.add(makeButton(2,"Step"));
		this.add(makeButton(3,"Stop"));
		this.add(speedButton(1,"Slower"));
		this.add(speedButton(2,"Restore"));
		this.add(speedButton(3,"Faster"));
		this.setVisible(true);
	}
	
	/*
	 * @param int i: button number String s: label
	 * @Return a JButton with corresponding string and listener.
	 */
	private JButton makeButton(int i, String s){
		JButton b = new JButton();
		b.setText(s);
		b.setBounds(40*(i-1)*3+100, 510, 100, 30);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bNum=i; //Sets bNum corresponding to the button pressed
			}
		});
		return b;
	}
	
	/*
	 * @param int i: button number String s: label
	 * @Return a JButton with corresponding string and listener.
	 */
	private JButton speedButton(int i,String s){
		JButton b = new JButton();
		b.setText(s);
		b.setBounds(40*(i-1)*3+100, 560, 100, 30);
		if(i==1){
			b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					timeStep *=2;
				}
			});
		}
		else if(i==2){
			b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						timeStep =100;
					}
				});
		}
		else if(i==3){
			b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						timeStep /=2;
					}
				});
		}
		//Changes the timeStep accordingly
		return b;
	}
	
	
	
	/*
	 * Draws the sorting algorithm as it takes place.
	 * After completion a dialog prompts the user to restart
	 */
	public void drawState(){
		int height=500;
		int width=600;
		JPanel j = new JPanel();
		this.add(j);
		j.setBounds(0, 0, width+40, height);
		j.setVisible(true);
		Graphics g= j.getGraphics();
		do{//Since bNum is defaulted to 3, always draws initial state on the first loop
			if(bNum<3){
				sort.step();
			}
			if(bNum==2){
				bNum++;//after the single step was taken, stops further steps
			}
			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(0, 0, width+40, height);
			for(int i=0;i<sort.Length();i++){
				g.setColor(Color.BLACK);
				g.fillRect(5+ (int) (i*width/(sort.Length()*1.05)), (height/sort.getMax())*(sort.getMax()-sort.getAtIndex(i)), (int) (width/(sort.Length()*1.10)), height);
			}
			if(sort.getIndexA()!=-1 && sort.getIndexA()<sort.Length()){
				//draw red box for A
				g.setColor(Color.RED);
				g.fillRect(5+ (int) (sort.getIndexA()*width/(sort.Length()*1.05)), (height/sort.getMax())*(sort.getMax()-sort.getAtIndex(sort.getIndexA())), (int) (width/(sort.Length()*1.10)), height);
			}
			if(sort.getIndexB()!=-1){
				//draw blue box for B
				g.setColor(Color.BLUE);
				g.fillRect(5 + (int) (sort.getIndexB()*width/(sort.Length()*1.05)), (height/sort.getMax())*(sort.getMax()-sort.getAtIndex(sort.getIndexB())), (int) (width/(sort.Length()*1.10)), height);
			}
			
			try {
				Thread.sleep(timeStep);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}while(!sort.isSorted());
		JDialog dialog = new JDialog(this, "Sort Complete!");
		dialog.setBounds(0, 0, 100, 100);
		JButton b = new JButton();
		b.setText("Restart");
		b.setBounds(10, 10, 100, 30);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finish=true; //sets a flag to start up a new instance of MainMenu
			}
		});
		dialog.add(b);
		dialog.setVisible(true);
		
		
		while(!finish){
			try {
				Thread.sleep(50);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
		this.setVisible(false);
		new MainMenu();;
	}
}
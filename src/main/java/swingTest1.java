import java.awt.EventQueue;
import java.awt.*;

import javax.swing.*;
import javax.swing.JFrame;

public class swingTest1 {

	private JFrame frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					swingTest1 window = new swingTest1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public swingTest1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setLayout(new BoxLayout();
		for(int i=0;i<10;++i){
		JLabel lab=new JLabel(String.valueOf(i));
		frame.getContentPane().add(lab);
		frame.getContentPane().add(Box.createHorizontalGlue());
		}frame.setSize(400,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

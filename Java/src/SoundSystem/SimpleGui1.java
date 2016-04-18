package SoundSystem;
import javax.swing.*;
import java.awt.event.*;

public class SimpleGui1 implements ActionListener{

	JButton button;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleGui1 gui = new SimpleGui1();
		gui.go();
	}
	
	public void go(){
		JFrame frame = new JFrame();
		button = new JButton("Click Me");
		//argument should be an object from a class that implements Listener interface
		button.addActionListener(this);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(button);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		button.setText("Clicked");
		
	}

}

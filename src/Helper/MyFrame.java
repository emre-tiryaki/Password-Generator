package Helper;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MyFrame extends JFrame{
	public MyFrame(String title, ImageIcon icon){
		this.setTitle(title);
		this.setSize(Constants.NORMAL_FRAME.dimension);
		this.setIconImage(icon.getImage());
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		//this.setVisible(true);
	}
}

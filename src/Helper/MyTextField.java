package Helper;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyTextField extends JPanel{

	private JLabel label;
	public JTextField textField;
	
	public MyTextField(int width, int height, String label) {
		this.setPreferredSize(new Dimension(width, height));
		//this.setBackground(Color.black);
		
		this.label = new JLabel(label);
		this.label.setFont(new Font("Arial", Font.PLAIN, (int)(width*0.1)));
		
		this.textField = new JTextField();
		this.textField.setPreferredSize(new Dimension((int)(width*0.9), (int)(height*0.3)));
		this.textField.addKeyListener(new TextFieldKeyListener());
		
		this.add(this.label);
		this.add(this.textField, BorderLayout.WEST);
	}
}

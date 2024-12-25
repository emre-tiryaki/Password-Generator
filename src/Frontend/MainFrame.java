package Frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Backend.Generation;
import Helper.Constants;
import Helper.MyButton;
import Helper.MyFrame;
import Helper.MyTextField;
import Helper.TextFieldKeyListener;

public class MainFrame extends MyFrame{
	
	// Things that we will use
	private JPanel allowPanel;
	private JCheckBox specialCharacterBox;
	private JCheckBox numberBox;
	private JCheckBox letterBox;
	private JCheckBox upperletterBox;
	private JPanel generatePanel;
	private MyTextField passwordSizeTextField;
	private MyButton generateButton;
	private JPanel resultPanel;
	private JTextField resultPasswordField;
	private JButton copyButton;
	private Generation generate;
	
	
	public MainFrame() {
		super("Password Generator", Constants.PASSWORD_ICON.icon);
		
		//checkboxes panel
		allowPanel = new JPanel();
		allowPanel.setPreferredSize(new Dimension(this.getWidth()/2, (int)(this.getHeight()*0.8)));
		allowPanel.setLayout(new GridLayout(4, 1));
		//allowPanel.setBackground(Color.red);
		
		specialCharacterBox = new JCheckBox("Special Character");
		numberBox = new JCheckBox("Number");
		letterBox = new JCheckBox("letter");
		upperletterBox = new JCheckBox("upper letter");
		
		allowPanel.add(specialCharacterBox);
		allowPanel.add(numberBox);
		allowPanel.add(letterBox);
		allowPanel.add(upperletterBox);
		
		//second panel
		generatePanel = new JPanel();
		generatePanel.setSize(new Dimension(this.getWidth()/2, (int)(this.getHeight()*0.8)));
		generatePanel.setPreferredSize(new Dimension(this.getWidth()/2, (int)(this.getHeight()*0.8)));
		generatePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 15));
		//generatePanel.setBackground(Color.BLUE);

		passwordSizeTextField = new MyTextField((int)(generatePanel.getWidth()*0.6), (int)(generatePanel.getHeight()*0.4), "Size of password:");
		
		generateButton = new MyButton("GENERATE");
		generateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!upperletterBox.isSelected() && !letterBox.isSelected() && !specialCharacterBox.isSelected() && !numberBox.isSelected())
					JOptionPane.showMessageDialog(null, "choose at least 1 condition!");
				else if(passwordSizeTextField.textField.getText().isBlank() || Integer.parseInt(passwordSizeTextField.textField.getText()) > 20)
					JOptionPane.showMessageDialog(null, "Please enter a valid size value!");
				else {
					generate = new Generation(upperletterBox.isSelected(), letterBox.isSelected(), specialCharacterBox.isSelected(), numberBox.isSelected());
					resultPasswordField.setText(generate.generatePassword(Integer.parseInt(passwordSizeTextField.textField.getText())));
					if(!copyButton.isEnabled())
						copyButton.setEnabled(true);					
				}
			}
		});
		
		generatePanel.add(passwordSizeTextField);
		generatePanel.add(generateButton);
		
		//the resultpanel
		resultPanel = new JPanel();
		resultPanel.setSize(new Dimension(this.getWidth(), (int)(this.getHeight()*0.2)));
		resultPanel.setPreferredSize(new Dimension(this.getWidth(), (int)(this.getHeight()*0.2)));
		resultPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0,10));
		//resultPanel.setBackground(Color.green);
		
		resultPasswordField = new JTextField();
		resultPasswordField.setPreferredSize(new Dimension((int)(resultPanel.getWidth()*0.6), (int)(resultPanel.getHeight()*0.6)));
		resultPasswordField.setCursor(Cursor.getDefaultCursor());
		resultPasswordField.setFocusable(false);
		
		copyButton = new JButton();
		copyButton.setIcon(Constants.COPY_ICON.icon);
		copyButton.setForeground(Color.black);
		copyButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		copyButton.setFocusable(false);
		copyButton.setEnabled(false);
		copyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String textToCopy = resultPasswordField.getText();
                StringSelection stringSelection = new StringSelection(textToCopy);
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

                try {
                    clipboard.setContents(stringSelection, null);
                    JOptionPane.showMessageDialog(null, "Text copied to clipboard!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error copying to clipboard.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

		
		resultPanel.add(resultPasswordField);
		resultPanel.add(copyButton);
		
		this.add(allowPanel, BorderLayout.WEST);
		this.add(generatePanel, BorderLayout.EAST);
		this.add(resultPanel, BorderLayout.SOUTH);
		
		this.setVisible(true);
	}
}

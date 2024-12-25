package Helper;

import java.awt.Dimension;

import javax.swing.ImageIcon;

public enum Constants {
	NORMAL_FRAME(new Dimension(300, 250)),
	NORMAL_BUTTON(new Dimension(100,50)),
	PASSWORD_ICON(new ImageIcon("C:\\Users\\tirya\\eclipse-workspace\\PasswordGenerator\\Resources\\password.png")),
	COPY_ICON(new ImageIcon("C:\\Users\\tirya\\eclipse-workspace\\PasswordGenerator\\Resources\\copy.png"));

	public final Dimension dimension;
	public final ImageIcon icon;
	
	Constants(Dimension dimension){
		this.dimension = dimension;
		this.icon = null;
	}
	
	Constants(ImageIcon icon){
		this.icon = icon;
		this.dimension = null;
	}
}

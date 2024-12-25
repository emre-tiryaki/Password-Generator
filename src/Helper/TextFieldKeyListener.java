package Helper;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TextFieldKeyListener implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        if (!Character.isDigit(c) && c != KeyEvent.VK_DELETE)
            e.consume();	//for ignoring non numerical characters
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Not used in this implementation
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Not used in this implementation
    }
}
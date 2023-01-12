package Sonido;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.border.*;

public class Borde implements Border{

    
    private int radio;

    Borde(int radio) {
        this.radio = radio;
    }

    public Insets getBorderInsets(Component c) {
        return new Insets(this.radio+1, this.radio+1, this.radio+2, this.radio);
    }

    public boolean isBorderOpaque() {
        return true;
    }

    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawRoundRect(x, y, width-1, height-1, radio, radio);
    }
}

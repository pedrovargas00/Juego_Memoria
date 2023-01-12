/**
García Cruz Ricardo Emmanuel
Ramos López Lizbeth
Tepoz Romero Belén
Vargas Arenas Pedro
 */
package Menú;

import java.awt.*; 
import javax.swing.*; 

public class boton  extends JButton{
    private boolean round; 
    private Color colorFondo, colorPresionado; 
    private int f, f1; 
//Constructor forma rectangulo bordes curvos 
    public boton(String rotulo, Color fon, Color pre, int i, int i1) { 
        super(rotulo); 
        f=i; 
        f1=i1; 
        round = false; 
        colorFondo = fon; 
        colorPresionado = pre; 
        setContentAreaFilled(false); 
    } 

 @ Override 
    protected void paintComponent(Graphics g) { 
        if (getModel().isArmed()) { 
            g.setColor(colorPresionado); 
        } else { 
            g.setColor(colorFondo); 
        } 
        if (round) { 
            g.fillOval(0, 0, getSize().width - 1, getSize().height - 1); 
        } else { 
            g.fillRoundRect(0, 0, getSize().width - 1, getSize().height - 1, f, f1); 
        } 
        super.paintComponent(g); 
    } 
//Sobreescritura del borde 
@ Override 
    protected void paintBorder(Graphics g) { 
        g.setColor(Color.black); 

        if (round)  
            g.drawOval(0, 0, getSize().width - 1, getSize().height - 1); 
        else  
            g.drawRoundRect(0, 0, getSize().width - 1, getSize().height - 1, f, f1);  
    } 
 Shape figura; 
    } 
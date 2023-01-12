/**
García Cruz Ricardo Emmanuel
Ramos López Lizbeth
Tepoz Romero Belén
Vargas Arenas Pedro
 */
package Menú;

import Coordinador.*;
import java.awt.*;
import javax.swing.*;

public class PanelPrincipal extends JPanel  {
    
    private Coordinador coordinador;

    public void paintComponent(Graphics g){
        Dimension tam = getSize();
	//imagen de fondo
	ImageIcon imgFondo = new ImageIcon( getClass().getResource("fq.jpg"));
	g.drawImage(imgFondo.getImage(), 0, 0, 
	tam.width,tam.height, null);
	setOpaque(false);	
	super.paintComponent(g);	
    }
    
    
    public void setCoordinador(Coordinador coordinador){
        this.coordinador = coordinador;
    }
}

/*
García Cruz Ricardo Emmanuel
Ramos López Lizbeth
Tepoz Romero Belén
Vargas Arenas Pedro
 */

package Menú;

import Coordinador.*;


import java.awt.Color;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class NivelesUI extends JFrame{
    
    private Coordinador coordinador;
    private PanelPrincipal pBase;
    private JPanel psur,pcentro,pnorte;
    private boton nivel1,nivel2,nivel3,salir;
    private JButton b;
    private JLabel lb;
    
    public NivelesUI( ) {
        super("Diferente");
        this.setSize(600, 600);
        this.setResizable(false); 
        initcomponentes();     
    }
    
    public void setCoordinador(Coordinador coordinador){
        this.coordinador = coordinador;
    }
    
    private void initcomponentes() {
        ImageIcon icon=new ImageIcon ("icon.png");
             this.setIconImage(icon.getImage());
        ImageIcon imt=new ImageIcon ("c2.png");
        ImageIcon can=new ImageIcon ("can.png");
        Color c = new Color(0,180,255);
        
        pBase = new PanelPrincipal();
        pBase.setLayout(new BorderLayout());
        psur =new JPanel();
        pcentro=new JPanel();
        pnorte= new JPanel();
        psur.setOpaque(false);
        pcentro.setOpaque(false);
        pnorte.setOpaque(false);
        lb=new JLabel("");
        lb.setIcon(imt);
        b=new JButton();
        
        nivel1=new boton("NIVEL1", c, Color.pink,30,30);
        setBoton(nivel1,20,140,110,55); 
        nivel2=new boton("NIVEL2", c, Color.pink,30,30);
        setBoton(nivel2,20,140,110,55); 
        nivel3=new boton("NIVEL3", c, Color.pink,30,30);
        setBoton(nivel3,20,140,110,55); 
        salir=new boton("REGRESAR", c, Color.pink,30,30);
        setBoton(salir,140,140,110,55); 
        salir.setForeground(Color.white);
        salir.setFont(new Font("Tahoma", Font.LAYOUT_LEFT_TO_RIGHT, 15));
           
        pcentro.setLayout(new GridLayout(1,3,3,3)); 
        nivel2.setEnabled(false);
        nivel3.setEnabled(false);
        pcentro.add(nivel1);
        pcentro.add(nivel2);
        pcentro.add(nivel3);
        nivel1.setIcon(can);
        nivel2.setIcon(can);
        nivel3.setIcon(can);
        b.setVisible(false);
        psur.setLayout(new GridLayout(2,1,10,10)); 
        psur.add(b);
        psur.add(salir);
        pnorte.add(lb);
        pBase.add(pnorte,BorderLayout.NORTH);
        pBase.add(pcentro ,BorderLayout.CENTER);
        pBase.add(psur,BorderLayout.SOUTH);
        add(pBase);
         nivel1.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                coordinador.mostrarDiferente(1);
                cerrar();
                }
                  });
         nivel2.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                coordinador.mostrarDiferente(2);
                cerrar();
                }
                  });
         nivel3.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                coordinador.mostrarDiferente(3);
                cerrar();
                }
                  });
        salir.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                coordinador.regresarMenu();
                cerrar();
                }
                  });
        
      }
      public void cerrar(){
            this.setVisible(false);
       }
       public void mostrarN1(){
           this.setVisible(true);
       }
        public void des2(){
           nivel2.setEnabled(true);
       }
       public void des3(){
           nivel3.setEnabled(true);
       }
      
       private static void setBoton(boton boton,int x, int y, int p ,int p1){ 
        boton.setBounds(x, y, p, p1); 
        boton.setFocusPainted(false); 
        boton.setForeground(Color.white);               
    }
       
}

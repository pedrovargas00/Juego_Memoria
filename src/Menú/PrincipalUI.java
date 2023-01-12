package Menú;

import Coordinador.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PrincipalUI  extends JFrame{
    
    private Coordinador coordinador;
    private PanelPrincipal pBase;
    private JPanel pcentro,tu,fin;
    private JLabel l2,l3,l4;
    private boton bizq;
    private JButton j1,j2,j3;
    
    public PrincipalUI( ) {
         super("Juegos de Memoria");
        
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
        Dimension d = new Dimension(200,200); 
           
        pBase = new PanelPrincipal();
        pcentro = new JPanel();
        pcentro.setOpaque(false);
        tu = new JPanel();
        tu.setOpaque(false);
        fin = new JPanel();
        fin.setOpaque(false);
            
                
                ImageIcon imt=new ImageIcon ("c2.png");
                ImageIcon ims=new ImageIcon ("su.jpg");
                ImageIcon imsong=new ImageIcon ("song.jpg");
                ImageIcon juego=new ImageIcon ("juego.gif");
                ImageIcon de=new ImageIcon ("de.gif");
                ImageIcon memoria=new ImageIcon ("memoria.gif");
          
                l2=new JLabel();
                l3=new JLabel();  
                l4=new JLabel();
                j1=new JButton("");
                j2=new JButton("");
                j3=new JButton("");  
                 j1.setToolTipText("¿QUIEN ES DIFERENTE?"); 
                 j2.setToolTipText("SUCESION DE NUMEROS");  
                 j3.setToolTipText("SONIDOS E IMAGENES");
                 j1.setIcon(imt); 
                 j2.setIcon(ims);
                 j3.setIcon(imsong);
               
                 pcentro.add(j1);
                 pcentro.add(j2);
                 pcentro.add(j3);
                 fin.setLayout(new BorderLayout());
                bizq= new boton("SALIR", Color.white, Color.blue,30,30);  
                setBoton(bizq,20,140,110,55); 
                j1.setSize(d);
                Color c = new Color(0,180,255);
                bizq.setForeground(c);
                bizq.setFont(new Font("Tahoma", Font.LAYOUT_LEFT_TO_RIGHT, 20));
           
                fin.add(bizq,BorderLayout.SOUTH);
                l2.setIcon(juego);
                l3.setIcon(de); 
                l4.setIcon(memoria);
                tu.add(l2);;
                tu.add(l3);
                tu.add(l4);
                pBase.setLayout(new GridLayout(3,1,2,2));
               pcentro.setLayout(new GridLayout(1,3,10,2));
                
                        
                  pBase.add(tu); 
                  pBase.add(pcentro);
                  pBase.add(fin); 
   
                add(pBase);
                
                //eventos de los botones
                //abrir niveles memorama
                j1.addActionListener(new ActionListener(){
                @Override
                    public void actionPerformed(ActionEvent e) {
                   coordinador.mostrar(1);
                    cerrarMenu();
                    }
                });
                   j2.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                          coordinador.mostrar(2);
                cerrarMenu();
                }
                  });
                 j3.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                coordinador.mostrar(3);
                cerrarMenu();
                }
                  });
                    bizq.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                cerrar();
                      
                }
                  });
 }
           
    public void mostrarMenu(){
     this.show(true);
    }
     public void cerrar(){
        System.exit(0);
    }
     public void cerrarMenu(){
        this.dispose();
    }
    
    private static void setBoton(boton boton,int x, int y, int p ,int p1){ 
        boton.setBounds(x, y, p, p1); 
        boton.setFocusPainted(false); 
        boton.setForeground(Color.white); 
                   
    }
}

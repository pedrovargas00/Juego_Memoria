package Diferente;

import Coordinador.*;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class DiferenteUI extends JFrame{
    
    private Coordinador coordinador;
    //se declaran los componentes de la ventana o Frame
    private JPanel base, lateral, inferior, centro, superior;
    private JButton bt1, bt2, bt3, bt4, salir, mostrar, iniciar;
    private JLabel nivel,instrucciones;
    private JProgressBar barra;
    private JTextArea area;
    private Icon logro, falla;
    private Timer t;
    private ActionListener a;
    int u;
    static int i =0;
  
    //Constructor de la clase Memorama, primer nivel
        public DiferenteUI(){
        super("DIFERENTE");
        this.setSize(600, 600);
        this.setLocation(0,0);
        this.setResizable(false);
        a=new ActionListener(){ 
            @Override
                public void actionPerformed(ActionEvent e) {
                        if (barra.getValue() <=1500)
                                barra.setValue(barra.getValue()+1);
                                
                        else 
                                t.stop();
                        if (barra.getValue()==6){
                            JOptionPane.showMessageDialog(null, "SE ACABÓ EL TIEMPO", "", JOptionPane.DEFAULT_OPTION, falla);
                            barra.setValue(0); 
                            coordinador.regresarNivelesDiferente(); 
                            cerrar(t);}
                        
                }
        };
        t=new Timer(1500,a);
      
        //se llama al método, para iniciar los componentes del Frame y agregarlos al mismo
        iniComponentes();
    }

    public void setCoordinador(Coordinador coordinador){
        this.coordinador = coordinador;
    }
    
    public void iniComponentes(){
        ImageIcon icon=new ImageIcon ("icon.png");
             this.setIconImage(icon.getImage());
        
        logro = new ImageIcon(getClass().getResource("/Recursos/Premio.png"));
        falla = new ImageIcon(getClass().getResource("/Recursos/Fallar.png"));
        u=1;
        Color color = new Color(152,251,152);
        Dimension d = new Dimension(200,200);
        bt1 = new JButton();
        bt1.setSize(d);
        ImageIcon imagen = new ImageIcon("02m.png");
        ImageIcon im02 = new ImageIcon("02.png");
        ImageIcon im03 = new ImageIcon("03.jpg");
        ImageIcon im04= new ImageIcon("04.png");
            
          
        bt1.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(bt1.getWidth(), bt1.getHeight(), Image.SCALE_SMOOTH)));
        bt1.setBackground(Color.WHITE);
        bt1.setVisible(false);
        bt2 = new JButton();
        bt2.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(bt1.getWidth(), bt1.getHeight(), Image.SCALE_SMOOTH)));
        bt2.setBackground(Color.WHITE);
        bt2.setVisible(false);
        bt3 = new JButton();
        bt3.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(bt1.getWidth(), bt1.getHeight(), Image.SCALE_SMOOTH)));
        bt3.setBackground(Color.WHITE);
        bt3.setVisible(false);
        bt4 = new JButton();
        bt4.setIcon(new ImageIcon(im02.getImage().getScaledInstance(bt1.getWidth(), bt1.getHeight(), Image.SCALE_SMOOTH)));
        bt4.setBackground(Color.WHITE);
        bt4.setVisible(false);
        barra = new JProgressBar(0,6); //son los limites de la barra de progreso
        ; //va incrementando el porcentaje de la barra de progreso
           
        barra.setStringPainted(true); //hace que muestre el porcentaje en la barra

           salir = new JButton("Salir");
        salir.setFont(new Font("Arial",Font.BOLD,20));
        
        nivel = new JLabel("Nivel 1");
        nivel.setFont(new Font("Arial",Font.BOLD,20));
        
        iniciar = new JButton("Iniciar");
        iniciar.setFont(new Font("Arial",Font.BOLD,20));
        
        instrucciones = new JLabel("Instrucciones");
        instrucciones.setFont(new Font("Arial",Font.PLAIN,20));
        
        area = new JTextArea("IMAGEN DIFERENTE\n\n¿Puedes encontrar la\nimagen diferente?\n\nPreste mucha"
                            + "\natención, a simple\nvista todas son\niguales, pero el\ncerebro puede\njugarnos chueco."
                + "\n\nEncuentre la imagen\nque es diferente\na las otras antes\nde que termine el\ntiempo.\nPara pasar al\nsiguiente nivel, no\ndebe equivocarse.\n"
                + "¡A oxigenar el\ncerebro!");
        area.setFont(new Font("Rockwell", Font.ITALIC, 15));
        area.setBackground(new Color(224, 255, 255));
        area.setEditable(false);
        
        mostrar = new JButton("Ocultar");
        mostrar.setFont(new Font("Arial",Font.BOLD,20));
        
//se agregan los componentes al panel  central
        centro = new JPanel();
        centro.setLayout(new GridLayout(2, 2, 2, 2)); 
        centro.setBackground(color);
        centro.add(bt1);
        centro.add(bt2);
        centro.add(bt3);
        centro.add(bt4);
        
        //se agregan los componentes al panel inferior
        inferior = new JPanel();
        inferior.setLayout(new BorderLayout(2,1));
        inferior.add(mostrar, BorderLayout.WEST);
        inferior.add(salir,BorderLayout.EAST);
        inferior.add(iniciar,BorderLayout.CENTER);
        inferior.setBackground(color);
        //se agregan los componentes al panel superior
        superior =new JPanel();
        superior.setLayout(new FlowLayout());
        superior.add(this.nivel);
        superior.add(this.barra);
        superior.setBackground(color);
        //se agregan componentes al panel lateral.
        lateral = new JPanel();
        lateral.setLayout(new BorderLayout());
        lateral.add(instrucciones, BorderLayout.NORTH);
        lateral.add(area, BorderLayout.CENTER);
        lateral.setBackground(color);
        lateral.setVisible(true);
        
        //se agregan los paneles a la base.
        base = new JPanel();
        base.setLayout(new BorderLayout());
        base.setBackground(color);
        base.add(superior, BorderLayout.NORTH);
        base.add(centro, BorderLayout.CENTER);
        base.add(inferior, BorderLayout.SOUTH);
        base.add(lateral, BorderLayout.WEST);
        add(base, BorderLayout.CENTER);
      
 /*
        BOTON 4 DIFERENTE
*/          
           iniciar.addActionListener(new ActionListener(){
                     @Override
                     public void actionPerformed(ActionEvent e) {
                           if (!t.isRunning()){
                        t.start();
                    }   
                          bt1.setVisible(true);
                          bt2.setVisible(true);
                          bt3.setVisible(true);
                          bt4.setVisible(true);
                    }
           });
           bt1.addActionListener(new ActionListener(){
                     @Override
                     public void actionPerformed(ActionEvent e) {
                         JOptionPane.showMessageDialog(null, "INCORRECTO", "", JOptionPane.DEFAULT_OPTION, falla);
                     }
           });
            
           bt2.addActionListener(new ActionListener(){
                     @Override
                     public void actionPerformed(ActionEvent e) {
                         JOptionPane.showMessageDialog(null, "INCORRECTO", "", JOptionPane.DEFAULT_OPTION, falla);      
           }
           });  
        
        bt3.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "INCORRECTO", "", JOptionPane.DEFAULT_OPTION, falla);
            }
        });
         bt4.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    t.stop();
                    JOptionPane.showMessageDialog(null, "HA GANADO", "", JOptionPane.DEFAULT_OPTION, logro);
                     
                     desN2();
                     cerrar(t);
                
            }
        });
       
         salir.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                  coordinador.regresarNivelesDiferente();
              cerrar(t);
                }
                  });  
         
         mostrar.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (mostrar.getText()=="Instrucciones")
                       mostrarI();
                    else {
                        ocultarI();
                    }
                }
                  });  
          
    }
    public void mostrarM1()
    {
        this.setVisible(true);
    }
     public void cerrar(Timer t)
    {
       this.setVisible(false);
       t.stop();
    }
     public void desN2()
    {
        coordinador.desbloqNivel2Di();
        coordinador.regresarNivelesDiferente();
        
    }
     
     public void mostrarI(){
         lateral.setVisible(true);
         mostrar.setText("Ocultar");
     }
     public void ocultarI(){
         lateral.setVisible(false);
         mostrar.setText("Instrucciones");
     }
   
     
}
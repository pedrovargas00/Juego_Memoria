package Diferente;

import Coordinador.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DiferenteUI2 extends JFrame{
    
    private Coordinador coordinador;
    //se declaran los componentes de la ventana o Frame
    private JPanel base, lateral, inferior, centro, superior;
    private JButton bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8,bt9, salir, mostrar,iniciar;
    private JLabel nivel,instrucciones;
    private JProgressBar barra;
    private JTextArea area;
    private Icon logro, falla;
     private Timer t;
    private ActionListener a;
    int u;
    static int i =0;
  
    //Constructor de la clase Memorama, primer nivel
        public DiferenteUI2(){
        super("DIFERENTE");
        this.setSize(600, 600);
        this.setLocation(0, 0);
        this.setResizable(false);
        a=new ActionListener(){ 
            @Override
                public void actionPerformed(ActionEvent e) {
                        if (barra.getValue() <=1500)
                                barra.setValue(barra.getValue()+1);
                                
                        else 
                                t.stop();
                         if (barra.getValue()==10){
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
        Color color = new Color(152,251,152);
        Dimension d = new Dimension(150,150);
        ImageIcon imagen = new ImageIcon("01.jpg");
        ImageIcon dif = new ImageIcon("01m.jpg");
        
        bt1 = new JButton();
        bt1.setSize(d);
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
        bt4.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(bt1.getWidth(), bt1.getHeight(), Image.SCALE_SMOOTH)));
        bt4.setBackground(Color.WHITE);
        bt4.setVisible(false);
        bt5 = new JButton();
        bt5.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(bt1.getWidth(), bt1.getHeight(), Image.SCALE_SMOOTH)));
        bt5.setBackground(Color.WHITE);
        bt5.setVisible(false);
        bt6 = new JButton();
        bt6.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(bt1.getWidth(), bt1.getHeight(), Image.SCALE_SMOOTH)));
        bt6.setBackground(Color.WHITE);
        bt6.setVisible(false);
        bt7 = new JButton();
        bt7.setIcon(new ImageIcon(dif.getImage().getScaledInstance(bt1.getWidth(), bt1.getHeight(), Image.SCALE_SMOOTH)));
        bt7.setBackground(Color.WHITE);
        bt7.setVisible(false);
        bt8 = new JButton();
        bt8.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(bt1.getWidth(), bt1.getHeight(), Image.SCALE_SMOOTH)));
        bt8.setBackground(Color.WHITE);
        bt8.setVisible(false);
        bt9 = new JButton();
        bt9.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(bt1.getWidth(), bt1.getHeight(), Image.SCALE_SMOOTH)));
        bt9.setBackground(Color.WHITE);
        bt9.setVisible(false);
        
        salir = new JButton("Salir");
        salir.setFont(new Font("Arial",Font.BOLD,20));
        
        nivel = new JLabel("Nivel 2");
        nivel.setFont(new Font("Arial",Font.BOLD,20));
        
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
        
        iniciar = new JButton("Iniciar");
        iniciar.setFont(new Font("Arial",Font.BOLD,20));
        
        barra = new JProgressBar(0,10); //son los limites de la barra de progreso
        barra.setValue(0); //va incrementando el porcentaje de la barra de progreso
        barra.setStringPainted(true); //hace que muestre el porcentaje en la barra
        
        centro = new JPanel();
        centro.setLayout(new GridLayout(3, 3, 2, 2)); 
        centro.add(bt1);
        centro.add(bt2);
        centro.add(bt3);
        centro.add(bt4);
        centro.add(bt5);
        centro.add(bt6);
        centro.add(bt7);
        centro.add(bt8);
        centro.add(bt9);
        centro.setBackground(color);
        
        inferior = new JPanel();
        inferior.setLayout(new BorderLayout(2,1));
        inferior.add(mostrar, BorderLayout.WEST);
        inferior.add(salir,BorderLayout.EAST);
        inferior.setBackground(color);
        inferior.add(iniciar,BorderLayout.CENTER);
        
        superior =new JPanel();
        superior.setLayout(new FlowLayout());
        superior.add(this.nivel);
        superior.add(this.barra);
        superior.setBackground(color);
        
        lateral = new JPanel();
        lateral.setLayout(new BorderLayout());
        lateral.add(instrucciones, BorderLayout.NORTH);
        lateral.add(area, BorderLayout.CENTER);
        lateral.setVisible(true);
        lateral.setBackground(color);
        
        base = new JPanel();
        base.setLayout(new BorderLayout());
        base.setBackground(color);
        base.add(superior, BorderLayout.NORTH);
        base.add(centro, BorderLayout.CENTER);
        base.add(inferior, BorderLayout.SOUTH);
        base.add(lateral, BorderLayout.WEST);
        add(base, BorderLayout.CENTER);
            
 /*
        BOTON 7 DIFERENTE
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
                        bt5.setVisible(true); 
                        bt6.setVisible(true); 
                        bt7.setVisible(true); 
                        bt8.setVisible(true); 
                        bt9.setVisible(true); 
                     
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
                         JOptionPane.showMessageDialog(null, "INCORRECTO", "", JOptionPane.DEFAULT_OPTION, falla);
                       
                
            }
        });
         bt5.addActionListener(new ActionListener(){
                     @Override
                     public void actionPerformed(ActionEvent e) {
                         JOptionPane.showMessageDialog(null, "INCORRECTO", "", JOptionPane.DEFAULT_OPTION, falla);
                       }
           });
            
           bt6.addActionListener(new ActionListener(){
                     @Override
                     public void actionPerformed(ActionEvent e) {
                         JOptionPane.showMessageDialog(null, "INCORRECTO", "", JOptionPane.DEFAULT_OPTION, falla);
                       }
           });  
        
        bt7.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    t.stop();
                    JOptionPane.showMessageDialog(null, "HA GANADO", "", JOptionPane.DEFAULT_OPTION, logro);
                      desN3();
                      cerrar(t); }
        });
         bt8.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                         JOptionPane.showMessageDialog(null, "INCORRECTO", "", JOptionPane.DEFAULT_OPTION, falla);
                         
                
            }
        });
       bt9.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                         JOptionPane.showMessageDialog(null, "INCORRECTO", "", JOptionPane.DEFAULT_OPTION, falla);
                       
                
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
     public void mostrarM2()
    {
        this.setVisible(true);
    }
      public void cerrar(Timer t)
    {
        t.stop();
        this.setVisible(false);
    }

        public void desN3()
    {
        coordinador.desbloqNivel3Di();
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

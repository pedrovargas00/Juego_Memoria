package Sucesión;

/**
García Cruz Ricardo Emmanuel
Ramos López Lizbeth
Tepoz Romero Belén
Vargas Arenas Pedro
 */
import Coordinador.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

//interfaz nivel uno, Juego de ordenamiento de números
public class OrdenarUIN1 extends JFrame {
     
    private Coordinador coordinador;
    
    //declaración de componentes
    private JPanel base,norte,sur,instruccion,botones;
    private JLabel nivel,instruc;
    private JButton boton1,boton2,boton3,boton4,boton5,boton6,salir,esconder,iniciar;
    private JProgressBar barraNivel;
    private JTextArea instrucciones; 
    private Icon logro, falla;
    static int b = 1 ;
    
    public OrdenarUIN1(){
       super("juego ordenar"); 
       //intanciar componentes
       inicomponentes();
       this.setSize(600, 600);
       this.setResizable(false);
    }

    public void setCoordinador(Coordinador coordinador){
        this.coordinador = coordinador;
    }
    
    private void inicomponentes() {
ImageIcon icon=new ImageIcon ("icon.png");
             this.setIconImage(icon.getImage());
        logro = new ImageIcon(getClass().getResource("/Recursos/Premio.png"));
        falla = new ImageIcon(getClass().getResource("/Recursos/Fallar.png"));
        //creamos el tipo de fuente y tamaño de letra que vamos a utilizar para los botones
        Font fuente = new Font("mensaje",Font.BOLD,15);
        Font f = new Font("Arial", Font.BOLD, 25);
        //color de los paneles
        //152 251 15   46 139 87 
        Color col = new Color(224, 255, 255 );
        Color color = new Color(186, 85, 211 );
        
        //instanciar componentes, agrecandoles sus caracteristicas
        nivel = new JLabel("NIVEL1");
        nivel.setFont(new Font("nivel", Font.BOLD, 20));
        instruc =  new JLabel("Ocultar");
        instruc.setFont(fuente);
        
        barraNivel = new JProgressBar(0,6); //limites de la barra
        barraNivel.setStringPainted(true); //hace que muestre el porcentaje en la barra
 
        
        instrucciones = new JTextArea("SUCESIÓN NUMÉRICA\n\nOrdene los números \nde menor a mayor.\nPonga mucha\n"
                            + "\natención y pulse\nlos botones en el\norden correcto para\npasar al siguiente\nnivel."
                + "\n\nSi se equivoca,\nperderá el\nprogreso en la\nbarra de nivel\ny tendrá que\nvolver a empezar.\n"
                + "Para comenzar a\njugar, presione el\n boton 'Iniciar'\n\npresione 'Ocultar'\npara ocultar esto.");
        instrucciones.setFont(new Font("Rockwell", Font.ITALIC, 15));
        instrucciones.setBackground(new Color(224, 255, 255));
        instrucciones.setEditable(false);
        
        salir = new JButton("SALIR");
        salir.setFont(fuente);
        esconder = new JButton("OCULTAR");
        esconder.setFont(fuente);
        iniciar = new JButton("INICIAR");
        iniciar.setFont(fuente);
        //utilizamos la funcion random para agregar numeros aleatorios a los botones
        boton1 = new JButton(""+(int) ((Math.random()*20)+ 1));
        boton1.setFont(f);
        boton1.setBackground(col);
        boton1.setEnabled(false);
        boton2 = new JButton(""+(int) ((Math.random()*20)+ 1));
        boton2.setBackground(col);
        boton2.setFont(f);
        boton2.setEnabled(false);
        boton3 = new JButton(""+(int) ((Math.random()*20)+ 1));
        boton3.setFont(f);
        boton3.setBackground(col);
        boton3.setEnabled(false);
        boton4 = new JButton(""+(int) ((Math.random()*20)+ 1));
        boton4.setFont(f);
        boton4.setBackground(col);
        boton4.setEnabled(false);
        boton5 = new JButton(""+(int) ((Math.random()*20)+ 1));
        boton5.setEnabled(false);
        boton5.setFont(f);
        boton5.setBackground(col);
        boton6 = new JButton(""+(int) ((Math.random()*20)+ 1));
        boton6.setFont(f);
        boton6.setEnabled(false);
        boton6.setBackground(col);
        //crear paneles
        base = new JPanel();
        base.setBackground(color);
        base.setLayout(new BorderLayout(2,4));
        
        norte = new JPanel();
        norte.setBackground(color);
        norte.setSize(600, 100);
        norte.setLayout(new FlowLayout());
        
        sur = new JPanel();
        sur.setLayout(new BorderLayout(2,1));
        sur.setBackground(color);
        
        instruccion = new JPanel();
        instruccion.setBackground(color);
        instruccion.setLayout(new BorderLayout());
        instruccion.setVisible(true);
        
        botones = new JPanel();
        botones.setLayout(new GridLayout(3,3, 15, 15));
        botones.setBackground(color);
        
        //agregamos los componentes a sus paneles corresponientes
        botones.add(boton1);
        botones.add(boton2);
        botones.add(boton3);
        botones.add(boton4);
        botones.add(boton5);
        botones.add(boton6);
        
        norte.add(nivel);
        norte.add(barraNivel);
        
        instruccion.add(instruc,BorderLayout.NORTH);
        instruccion.add(instrucciones, BorderLayout.CENTER);
        
        sur.add(esconder, BorderLayout.WEST);
        sur.add(salir, BorderLayout.EAST);
        sur.add(iniciar,BorderLayout.CENTER);
        
        // agregamos los paneles al panel base
        base.add(norte,BorderLayout.NORTH);
        base.add(sur,BorderLayout.SOUTH);
        base.add(instruccion,BorderLayout.WEST);
        base.add(botones,BorderLayout.CENTER);
        add(base,BorderLayout.CENTER);
        
        //eventos
        salir.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                //se abre la interfaz de los niveles, y se cierra la ventana actual
                coordinador.regresarNivelesSucesion();
                cerrar();
                }
        });
        // evento para ocultar y mostrar instrucciones
        esconder.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(esconder.getText()=="OCULTAR")
                    ocultar();
                else
                    mostrar();
            }
        });
        
        iniciar.addActionListener(new ActionListener(){
        @Override
        
            public void actionPerformed(ActionEvent e) {
                //inhabilitamos el boton iniciar, habilitamos los botones, y extraemos su contenido para conparar posteriormente
                iniciar.setEnabled(false);
                valoresBoton(); 
                habilitarBoton();
                coordinador.valorI();
                boton1.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        if(coordinador.comparar(boton1.getText()) == true){
                            barraNivel.setValue(b++);
                            boton1.setEnabled(false);
                            if(b==7){
                                JOptionPane.showMessageDialog(null, "HA GANADO", "", JOptionPane.DEFAULT_OPTION, logro);
                                b = 1;
                                desNiv2Su();
                                    
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "HA PERDIDO", "", JOptionPane.DEFAULT_OPTION, falla);
                            habilitarBoton();
                            barraNivel.setValue(b=1);
                            coordinador.valorI();
                        }
                    }
                });
                
                boton2.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        
                         if(coordinador.comparar(boton2.getText()) == true){
                            barraNivel.setValue(b++);
                            boton2.setEnabled(false);
                            if(b==7){
                                JOptionPane.showMessageDialog(null, "HA GANADO", "", JOptionPane.DEFAULT_OPTION, logro);
                                b = 1;
                                desNiv2Su();
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "HA PERDIDO", "", JOptionPane.DEFAULT_OPTION, falla);
                            habilitarBoton();
                            barraNivel.setValue(b=1);
                            coordinador.valorI();
                        }
                    }
                });
                
                boton3.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        
                         if(coordinador.comparar(boton3.getText()) == true){
                            barraNivel.setValue(b++);
                            boton3.setEnabled(false);
                            
                            if(b==7){
                                JOptionPane.showMessageDialog(null, "HA GANADO", "", JOptionPane.DEFAULT_OPTION, logro);
                                b = 1;
                                desNiv2Su();
                            }
                                    
                        }else{
                            JOptionPane.showMessageDialog(null, "HA PERDIDO", "", JOptionPane.DEFAULT_OPTION, falla);
                            habilitarBoton();
                            barraNivel.setValue(b=1);
                            coordinador.valorI();
                        }
                    }
                });
                
                boton4.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        
                         if(coordinador.comparar(boton4.getText()) == true){
                            barraNivel.setValue(b++);
                            boton4.setEnabled(false);
                            
                            if(b==7){
                                JOptionPane.showMessageDialog(null, "HA GANADO", "", JOptionPane.DEFAULT_OPTION, logro);
                                b = 1;
                                desNiv2Su();
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "HA PERDIDO", "", JOptionPane.DEFAULT_OPTION, falla);
                            habilitarBoton();
                            barraNivel.setValue(b=1);
                            coordinador.valorI();
                        }
                    }
                });
                
                boton5.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        
                         if(coordinador.comparar(boton5.getText()) == true){
                            barraNivel.setValue(b++);
                            boton5.setEnabled(false);
                            
                            if(b==7){
                                JOptionPane.showMessageDialog(null, "HA GANADO", "", JOptionPane.DEFAULT_OPTION, logro);
                                b = 1;
                                desNiv2Su();
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "HA PERDIDO", "", JOptionPane.DEFAULT_OPTION, falla);
                            habilitarBoton();
                            barraNivel.setValue(b=1);
                            coordinador.valorI();
                        }
                    }
                });
                
                boton6.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        
                         if(coordinador.comparar(boton6.getText()) == true){
                            barraNivel.setValue(b++);
                            boton6.setEnabled(false);
                            
                            if(b==7){
                                JOptionPane.showMessageDialog(null, "HA GANADO", "", JOptionPane.DEFAULT_OPTION, logro);
                                b = 1;
                                desNiv2Su();
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "HA PERDIDO", "", JOptionPane.DEFAULT_OPTION, falla);
                            habilitarBoton();
                            barraNivel.setValue(b=1);
                            coordinador.valorI();
                        }
                    }
                });
            }
        });
    }
     public void mostrarSu1(){
           this.setVisible(true);
       }
       public void cerrar(){
           this.setVisible(false);
       }
    
    public void desNiv2Su(){
        coordinador.desbloqNivel2Su();
        coordinador.regresarNivelesSucesion();
        cerrar();
    }
    
    private void valoresBoton(){
        
        //agregar el contenido de los botones a un vector
        coordinador.agregar(boton1.getText());
        coordinador.agregar(boton2.getText());
        coordinador.agregar(boton3.getText());
        coordinador.agregar(boton4.getText());
        coordinador.agregar(boton5.getText());
        coordinador.agregar(boton6.getText());
        //se ordena el vector de menor a mayor
        coordinador.ordena();       
    }
    
    private void habilitarBoton() {
        //se habilitan los botones :D
        boton1.setEnabled(true);
        boton2.setEnabled(true);
        boton3.setEnabled(true);
        boton4.setEnabled(true);
        boton5.setEnabled(true);
        boton6.setEnabled(true);
    }
    
    public void mostrar(){
        instruccion.setVisible(true);
        esconder.setText("OCULTAR");
    }
    
    public void ocultar(){
        instruccion.setVisible(false);
        esconder.setText("INSTRUCCIONES");    
    }
}

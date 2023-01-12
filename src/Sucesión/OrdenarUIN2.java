package Sucesión;

import Coordinador.*;
import static Sucesión.OrdenarUIN1.b;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
García Cruz Ricardo Emmanuel
Ramos López Lizbeth
Tepoz Romero Belén
Vargas Arenas Pedro
 */
//interfaz nivel dos, Juego de ordenamiento de números
public class OrdenarUIN2 extends JFrame{
    
    private Coordinador coordinador;
    
    //declaración de componentes
    private JPanel base,norte,sur,instru,botones;
    private JLabel instruc,nivel;
    private JButton boton1,boton2,boton3,boton4,boton5,boton6,boton7,boton8,boton9,salir,esconder,iniciar;
    private JProgressBar barraNivel;
    private JTextArea instrucciones; 
    private Icon logro, falla;
    
    public OrdenarUIN2(){
        //instanciar componentes
        super("juego ordenar"); 
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
        Color col = new Color(224, 255, 255 );
        Color color = new Color(186, 85, 211 );
        //instanciar componentes, agrecandoles sus caracteristicas
        nivel = new JLabel("NIVEL2");
        nivel.setFont(new Font("nivel", Font.BOLD, 20));
        instruc = new JLabel("instrucciones");
        instruc.setFont(fuente);
        
        barraNivel = new JProgressBar(0,9); //limites de la barra
        barraNivel.setStringPainted(true); //hace que muestre el porcentaje en la barra
        
        salir = new JButton("SALIR");
        salir.setFont(fuente);
        esconder = new JButton("OCULTAR");
        esconder.setFont(fuente);
        iniciar = new JButton("INICIAR");
        iniciar.setFont(fuente);
        
         instrucciones = new JTextArea("SUCESIÓN NUMÉRICA\n\nOrdene los números \nde menor a mayor.\nPonga mucha\n"
                            + "\natención y pulse\nlos botones en el\norden correcto para\npasar al siguiente\nnivel."
                + "\n\nSi se equivoca,\nperderá el\nprogreso en la\nbarra de nivel\ny tendrá que\nvolver a empezar.\n"
                + "Para comenzar a\njugar, presione el\n boton 'Iniciar'\n\npresione 'Ocultar'\npara ocultar esto.");
        instrucciones.setFont(new Font("Rockwell", Font.ITALIC, 15));
        instrucciones.setBackground(new Color(224, 255, 255));
        instrucciones.setEditable(false);
    
        //utilizamos la funcion random para agregar numeros aleatorios a los botones
        boton1 = new JButton(""+(int) ((Math.random()*30)+ 1));
        boton1.setFont(f);
        boton1.setEnabled(false);
        boton2 = new JButton(""+(int) ((Math.random()*30)+ 1));
        boton2.setFont(f);
        boton2.setEnabled(false);
        boton3 = new JButton(""+(int) ((Math.random()*30)+ 1));
        boton3.setFont(f);
        boton3.setEnabled(false);
        boton4 = new JButton(""+(int) ((Math.random()*30)+ 1));
        boton4.setFont(f);
        boton4.setEnabled(false);
        boton5 = new JButton(""+(int) ((Math.random()*30)+ 1));
        boton5.setFont(f);
        boton5.setEnabled(false);
        boton6 = new JButton(""+(int) ((Math.random()*30)+ 1));
        boton6.setFont(f);
        boton6.setEnabled(false);
        boton7 = new JButton(""+(int) ((Math.random()*30)+ 1));
        boton7.setFont(f);
        boton7.setEnabled(false);
        boton8 = new JButton(""+(int) ((Math.random()*30)+ 1));
        boton8.setFont(f);
        boton8.setEnabled(false);
        boton9 = new JButton(""+(int) ((Math.random()*30)+ 1));
        boton9.setFont(f);
        boton9.setEnabled(false);
        boton1.setBackground(col);
        boton2.setBackground(col);
        boton3.setBackground(col);
        boton4.setBackground(col);
        boton5.setBackground(col);
        boton6.setBackground(col);
        boton7.setBackground(col);
        boton8.setBackground(col);
        boton9.setBackground(col);
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
        instru = new JPanel();
        instru.setBackground(color);
        instru.setLayout(new BorderLayout());
        instru.setVisible(true);
        botones = new JPanel();
        botones.setLayout(new GridLayout(3,3, 10, 10));
        botones.setBackground(color);
        
        // añadimos los componentes al panel correspondiente
        botones.add(boton1);
        botones.add(boton2);
        botones.add(boton3);
        botones.add(boton4);
        botones.add(boton5);
        botones.add(boton6);
        botones.add(boton7);
        botones.add(boton8);
        botones.add(boton9);
        norte.add(nivel);
        norte.add(barraNivel);
        instru.add(instruc,BorderLayout.NORTH);
        instru.add(instrucciones, BorderLayout.CENTER);
        sur.add(esconder, BorderLayout.WEST);
        sur.add(salir, BorderLayout.EAST);
        sur.add(iniciar, BorderLayout.CENTER);
        
        //agregamos los paneles a panel principal
        base.add(norte,BorderLayout.NORTH);
        base.add(sur,BorderLayout.SOUTH);
        base.add(instru,BorderLayout.WEST);
        base.add(botones,BorderLayout.CENTER);
        add(base,BorderLayout.CENTER);
        salir.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                coordinador.regresarNivelesSucesion();
                cerrar();
            }
        });
        
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
                iniciar.setEnabled(false);
                valoresBoton(); 
                habilitarBoton();
                coordinador.valorI();
                barraNivel.setValue(b=1);
                boton1.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        if(coordinador.comparar(boton1.getText()) == true){
                            barraNivel.setValue(b++);
                            boton1.setEnabled(false);
                            if(b==10){
                                JOptionPane.showMessageDialog(null, "HA GANADO", "", JOptionPane.DEFAULT_OPTION, logro);
                                b = 1;
                                desNiv3Su();
                                    
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
                            if(b==10){
                                JOptionPane.showMessageDialog(null, "HA GANADO", "", JOptionPane.DEFAULT_OPTION, logro);
                                b = 1;
                                desNiv3Su();
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
                            if(b==10){
                                JOptionPane.showMessageDialog(null, "HA GANADO", "", JOptionPane.DEFAULT_OPTION, logro);
                                b = 1;
                                desNiv3Su();
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
                            if(b==10){
                                JOptionPane.showMessageDialog(null, "HA GANADO", "", JOptionPane.DEFAULT_OPTION, logro);
                                b = 1;
                                desNiv3Su();
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
                            if(b==10){
                                JOptionPane.showMessageDialog(null, "HA GANADO", "", JOptionPane.DEFAULT_OPTION, logro);
                                b = 1;
                                desNiv3Su();
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
                                if(b==10){
                                    JOptionPane.showMessageDialog(null, "HA GANADO", "", JOptionPane.DEFAULT_OPTION, logro);
                                    b = 1;
                                    desNiv3Su();
                                }
                        }else{
                            JOptionPane.showMessageDialog(null, "HA PERDIDO", "", JOptionPane.DEFAULT_OPTION, falla);
                            habilitarBoton();
                            barraNivel.setValue(b=1);
                            coordinador.valorI();
                        }
                    }
                });

                boton7.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        
                         if(coordinador.comparar(boton7.getText()) == true){
                            barraNivel.setValue(b++);
                            boton7.setEnabled(false);
                                if(b==10){
                                    JOptionPane.showMessageDialog(null, "HA GANADO", "", JOptionPane.DEFAULT_OPTION, logro);
                                    b = 1;
                                    desNiv3Su();
                                }
                        }else{
                            JOptionPane.showMessageDialog(null, "HA PERDIDO", "", JOptionPane.DEFAULT_OPTION, falla);
                            habilitarBoton();
                            barraNivel.setValue(b=1);
                            coordinador.valorI();
                        }
                    }
                });

                boton8.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        
                         if(coordinador.comparar(boton8.getText()) == true){
                            barraNivel.setValue(b++);
                            boton8.setEnabled(false);
                                if(b==10){
                                    JOptionPane.showMessageDialog(null, "HA GANADO", "", JOptionPane.DEFAULT_OPTION, logro);
                                    b = 1;
                                    desNiv3Su();
                                }
                        }else{
                            JOptionPane.showMessageDialog(null, "HA PERDIDO", "", JOptionPane.DEFAULT_OPTION, falla);
                            habilitarBoton();
                            barraNivel.setValue(b=1);
                            coordinador.valorI();
                        }
                    }
                });   

                boton9.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        
                         if(coordinador.comparar(boton9.getText()) == true){
                            barraNivel.setValue(b++);
                            boton9.setEnabled(false);
                                if(b==10){
                                    JOptionPane.showMessageDialog(null, "HA GANADO", "", JOptionPane.DEFAULT_OPTION, logro);
                                    b = 1;
                                    desNiv3Su();
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
    public void mostrarSu2(){
           this.setVisible(true);
       }
       public void cerrar(){
           this.setVisible(false);
       }
       
    public void desNiv3Su(){
        coordinador.desbloqNivel3Su();
        coordinador.regresarNivelesSucesion();
        cerrar();
    }
    
    private void valoresBoton(){
        coordinador.limpiarArreglo();
        //agregar el contenido de los botones a un vector
        coordinador.agregar(boton1.getText());
        coordinador.agregar(boton2.getText());
        coordinador.agregar(boton3.getText());
        coordinador.agregar(boton4.getText());
        coordinador.agregar(boton5.getText());
        coordinador.agregar(boton6.getText());
        coordinador.agregar(boton7.getText());
        coordinador.agregar(boton8.getText());
        coordinador.agregar(boton9.getText());
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
        boton7.setEnabled(true);
        boton8.setEnabled(true);
        boton9.setEnabled(true);
    }

    public void mostrar(){
        instru.setVisible(true);
        esconder.setText("OCULTAR");
    }
    
    public void ocultar(){
        instru.setVisible(false);
        esconder.setText("INSTRUCCIONES");    
    }
}
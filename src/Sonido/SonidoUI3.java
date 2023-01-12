package Sonido;

import Coordinador.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import javax.swing.border.*;

public class SonidoUI3 extends JFrame{

    private Coordinador coordinador;
    
    // Inicialización de los componentes a usar.
    private JPanel pBase, pCentro, pLateral,pSuperior, pInferior;
    private JButton btSalir, btIniciar, btMostrar;
    private JButton boton1, boton2, boton3, boton4, boton5, boton6, boton7, boton8;
    private JLabel lbNivel, lbInstrucciones;
    private JTextArea area;
    private JProgressBar pbBarra;
    private ImageIcon imPerro, imGato, imGallo, imBuho, imOveja, imDelfin, imSerpiente, imVaca;    
    private Dimension dimension;
    private Color color, color1;
    private Icon correcto, incorrecto, logro;
    private int b = 0;
    
    //Constructor de la clase
    public SonidoUI3(){
        
        super("RECUERDA EL SONIDO");
        this.setSize(600, 600);
        this.setResizable(false);
        iniComponentes();
    }
    
    public void setCoordinador(Coordinador coordinador){
        this.coordinador = coordinador;
    }
    
    // Método para instanciar los componentes
    public void iniComponentes(){
        ImageIcon icon=new ImageIcon ("icon.png");
             this.setIconImage(icon.getImage());
        correcto = new ImageIcon(getClass().getResource("/Recursos/Correcto.png"));
        incorrecto = new ImageIcon(getClass().getResource("/Recursos/Incorrecto.png"));
        logro = new ImageIcon(getClass().getResource("/Recursos/Premio.png"));
        color = new Color(100, 149, 237);
        color1 = new Color(240, 248, 255);
        // Instancia de los botones.
        btSalir = new JButton("SALIR");
        btSalir.setFont(new Font("Helvetica", Font.BOLD, 15));
        btSalir.setBackground(color1);
        btIniciar = new JButton("INICIAR");
        btIniciar.setFont(new Font("Arial", Font.BOLD, 18));
        btIniciar.setBackground(color1);
        btMostrar = new JButton("OCULTAR");
        btMostrar.setFont(new Font("Helvetica", Font.BOLD, 15));
        btMostrar.setBackground(color1);
        
        // Instancia de los botones para imágenes.
        dimension = new Dimension(130, 130);
        boton1 = new JButton("0");
        boton1.setSize(dimension);
        boton1.setFont(new Font("Arial", 1, 1));
        setBoton(boton1);
        boton1.setEnabled(false);
        boton2 = new JButton("1");
        boton2.setSize(dimension);
        boton2.setFont(new Font("Arial", 1, 1));
        setBoton(boton2);
        boton2.setEnabled(false);
        boton3 = new JButton("2");
        boton3.setSize(dimension);
        boton3.setFont(new Font("Arial", 1, 1));
        setBoton(boton3);
        boton3.setEnabled(false);
        boton4 = new JButton("3");
        boton4.setSize(dimension);
        boton4.setFont(new Font("Arial", 1, 1));
        setBoton(boton4);
        boton4.setEnabled(false);
        boton5 = new JButton("4");
        boton5.setSize(dimension);
        boton5.setFont(new Font("Arial", 1, 1));
        setBoton(boton5);
        boton5.setEnabled(false);
        boton6 = new JButton("5");
        boton6.setSize(dimension);
        boton6.setFont(new Font("Arial", 1, 1));
        setBoton(boton6);
        boton6.setEnabled(false);
        boton7 = new JButton("6");
        boton7.setSize(dimension);
        boton7.setFont(new Font("Arial", 1, 1));
        setBoton(boton7);
        boton7.setEnabled(false);
        boton8 = new JButton("7");
        boton8.setSize(dimension);
        boton8.setFont(new Font("Arial", 1, 1));
        setBoton(boton8);
        boton8.setEnabled(false);
        
        // Se agrega el color a los botones.
        boton1.setBackground(Color.WHITE);
        boton2.setBackground(Color.WHITE);
        boton3.setBackground(Color.WHITE);
        boton4.setBackground(Color.WHITE);
        boton5.setBackground(Color.WHITE);
        boton6.setBackground(Color.WHITE);
        boton7.setBackground(Color.WHITE);
        boton8.setBackground(Color.WHITE);
        
        // Se agregan bordes redondeados a los botones,
        boton1.setBorder(new Borde(40));
        boton2.setBorder(new Borde(40));
        boton3.setBorder(new Borde(40));
        boton4.setBorder(new Borde(40));
        boton5.setBorder(new Borde(40));
        boton6.setBorder(new Borde(40));
        boton7.setBorder(new Borde(40));
        boton8.setBorder(new Borde(40));
        
        // Instancia de etiquetas.
        lbNivel = new JLabel("NIVEL 3");
        lbNivel.setFont(new Font("Arial", 1, 20));
        lbInstrucciones = new JLabel("Instrucciones");
        lbInstrucciones.setFont(new Font("Arial", Font.BOLD, 20));
        area = new JTextArea("IDENTIFICAR EL SONIDO\n\nCon el mouse pulse\nel botón 'Iniciar'. Se"
                            + "\nreproduce un audio. \nDebe identificar al\nanimal que lo hace\npulsando sobre la\nimagen."
                + "\n\nSi acierta,\naumenta su barra\ny se bloquea\nla imagen. Si falla,\nel juego se reinicia.\nContinúe "
                + "hasta que\nla barra esté al 100%\n\nPara ocultar esto\npresione 'Ocultar'");
        area.setFont(new Font("Rockwell", Font.ITALIC, 15));
        area.setBackground(new Color(224, 255, 255));
        area.setEditable(false);
        
        // Instancia de la barra de progreso
        pbBarra = new JProgressBar(0, 8);
        pbBarra.setValue(0);
        pbBarra.setStringPainted(true);
        
        //Instancia de imágenes.
        imBuho = new ImageIcon("buho.jpeg");
        imGallo = new ImageIcon("gallo.png");
        imPerro = new ImageIcon("perro.png");
        imGato = new ImageIcon("gato.png");
        imOveja = new ImageIcon("oveja.jpeg");
        imDelfin = new ImageIcon("delfin.jpeg");
        imSerpiente = new ImageIcon("serpiente.jpeg");
        imVaca = new ImageIcon("vaca.jpeg");
        
        // Se asignan las imágenes a los botones.
        boton1.setIcon(new ImageIcon(imBuho.getImage().getScaledInstance(boton1.getWidth(), boton1.getHeight(), Image.SCALE_SMOOTH)));
        boton2.setIcon(new ImageIcon(imGallo.getImage().getScaledInstance(boton2.getWidth(), boton2.getHeight(), Image.SCALE_SMOOTH)));
        boton3.setIcon(new ImageIcon(imPerro.getImage().getScaledInstance(boton3.getWidth(), boton3.getHeight(), Image.SCALE_SMOOTH)));
        boton4.setIcon(new ImageIcon(imGato.getImage().getScaledInstance(boton4.getWidth(), boton4.getHeight(), Image.SCALE_SMOOTH)));
        boton5.setIcon(new ImageIcon(imOveja.getImage().getScaledInstance(boton5.getWidth(), boton5.getHeight(), Image.SCALE_SMOOTH)));
        boton6.setIcon(new ImageIcon(imDelfin.getImage().getScaledInstance(boton6.getWidth(), boton6.getHeight(), Image.SCALE_SMOOTH)));
        boton7.setIcon(new ImageIcon(imVaca.getImage().getScaledInstance(boton7.getWidth(), boton7.getHeight(), Image.SCALE_SMOOTH)));
        boton8.setIcon(new ImageIcon(imSerpiente.getImage().getScaledInstance(boton8.getWidth(), boton8.getHeight(), Image.SCALE_SMOOTH)));
        
        // Instancia de los paneles.
        pBase = new JPanel();
        pBase.setBackground(color);
        pBase.setLayout(new BorderLayout());
        pLateral = new JPanel();
        pLateral.setLayout(new BorderLayout());
        pLateral.setBackground(color);
        pCentro = new JPanel();
        pCentro.setLayout(new GridLayout(4, 2, 8, 8));
        pCentro.setBackground(color);
        pInferior = new JPanel();
        pInferior.setLayout(new BorderLayout());
        pInferior.setBackground(color);
        pSuperior = new JPanel();
        pSuperior.setLayout(new FlowLayout(FlowLayout.CENTER));
        pSuperior.setBackground(color);
        
        Border borde = new CompoundBorder(new EmptyBorder(10, 10, 10, 10), new SoftBevelBorder(SoftBevelBorder.LOWERED));
        pLateral.setBorder(borde);
        
        // Se agregan los componentes a los paneles correspondientes.
        pLateral.add(lbInstrucciones, BorderLayout.NORTH);
        pLateral.add(area, BorderLayout.CENTER);
        pInferior.add(btIniciar, BorderLayout.CENTER);
        pInferior.add(btSalir, BorderLayout.EAST);
        pInferior.add(btMostrar, BorderLayout.WEST);
        pSuperior.add(lbNivel);
        pSuperior.add(pbBarra);
        pCentro.add(boton1);
        pCentro.add(boton2);
        pCentro.add(boton3);
        pCentro.add(boton4);
        pCentro.add(boton5);
        pCentro.add(boton6);
        pCentro.add(boton7);
        pCentro.add(boton8);
        
        // Se agregan los paneles al panel base.
        pBase.add(pLateral, BorderLayout.WEST);
        pBase.add(pInferior, BorderLayout.SOUTH);
        pBase.add(pSuperior, BorderLayout.NORTH);
        pBase.add(pCentro, BorderLayout.CENTER);
        add(pBase, BorderLayout.CENTER);
    //Eventos.
        btIniciar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                  coordinador.reproducirN1();
                } catch (FileNotFoundException ex) {
                    ex.getMessage();
                } catch (Exception ex){
                    ex.getMessage();
                }
                btIniciar.setEnabled(false);
                habilitarBotonSo();
               
                boton1.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        if (coordinador.compararSo(boton1.getText()) == true){
                            JOptionPane.showMessageDialog(null, "Correcto", "", JOptionPane.DEFAULT_OPTION, correcto);
                            boton1.setEnabled(false);
                            pbBarra.setValue(++b);
                            if (estadoBarra(b) == false){
                                try {
                                    coordinador.reproducirN3();
                                } catch (FileNotFoundException ex) {
                                    ex.getMessage();
                                }
                            }
                            else{
                                //cerrar ventana
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Incorrecto", "", JOptionPane.DEFAULT_OPTION, incorrecto);
                            coordinador.arreglo();
                            habilitarBotonSo();
                            pbBarra.setValue(b = 0);
                            try {
                                coordinador.reproducirN3();
                            } catch (FileNotFoundException ex) {
                                ex.getMessage();
                            }
                        }
                    }
                });
                
                boton2.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        if (coordinador.compararSo(boton2.getText()) == true){
                            JOptionPane.showMessageDialog(null, "Correcto", "", JOptionPane.DEFAULT_OPTION, correcto);
                            boton2.setEnabled(false);
                            pbBarra.setValue(++b);
                            if (estadoBarra(b) == false){
                                try {
                                    coordinador.reproducirN3();
                                } catch (FileNotFoundException ex) {
                                    ex.getMessage();
                                }
                            }
                            else{
                                //cerrar ventana
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Incorrecto", "", JOptionPane.DEFAULT_OPTION, incorrecto);
                            coordinador.arreglo();
                            habilitarBotonSo();
                            pbBarra.setValue(b = 0);
                            try {
                               coordinador.reproducirN3();
                            } catch (FileNotFoundException ex) {
                                ex.getMessage();
                            }
                        }
                    }
                });               
                
                boton3.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        if (coordinador.compararSo(boton3.getText()) == true){
                            JOptionPane.showMessageDialog(null, "Correcto", "", JOptionPane.DEFAULT_OPTION, correcto);
                            boton3.setEnabled(false);
                            pbBarra.setValue(++b);
                            if (estadoBarra(b) == false){
                                try {
                                    coordinador.reproducirN3();
                                } catch (FileNotFoundException ex) {
                                    ex.getMessage();
                                }
                            }
                            else{
                                //cerrar ventana
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Incorrecto", "", JOptionPane.DEFAULT_OPTION, incorrecto);
                            coordinador.arreglo();
                            habilitarBotonSo();
                            pbBarra.setValue(b = 0);
                            try {
                                coordinador.reproducirN3();
                            } catch (FileNotFoundException ex) {
                                ex.getMessage();
                            }
                        }
                    }
                });
                
                boton4.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        if (coordinador.compararSo(boton4.getText()) == true){
                            JOptionPane.showMessageDialog(null, "Correcto", "", JOptionPane.DEFAULT_OPTION, correcto);
                            boton4.setEnabled(false);
                            pbBarra.setValue(++b);
                            if (estadoBarra(b) == false){
                                try {
                                    coordinador.reproducirN3();
                                } catch (FileNotFoundException ex) {
                                    ex.getMessage();
                                }
                            }
                            else{
                                //cerrar ventana
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Incorrecto", "", JOptionPane.DEFAULT_OPTION, incorrecto);
                            coordinador.arreglo();
                            habilitarBotonSo();
                            pbBarra.setValue(b = 0);
                            try {
                                coordinador.reproducirN3();
                            } catch (FileNotFoundException ex) {
                                ex.getMessage();
                            }
                        }
                    }
                });
                
                boton5.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        if (coordinador.compararSo(boton5.getText()) == true){
                            JOptionPane.showMessageDialog(null, "Correcto", "", JOptionPane.DEFAULT_OPTION, correcto);
                            boton5.setEnabled(false);
                            pbBarra.setValue(++b);
                            if (estadoBarra(b) == false){
                                try {
                                    coordinador.reproducirN3();
                                } catch (FileNotFoundException ex) {
                                    ex.getMessage();
                                }
                            }
                            else{
                                //cerrar ventana
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Incorrecto", "", JOptionPane.DEFAULT_OPTION, incorrecto);
                            coordinador.arreglo();
                            habilitarBotonSo();
                            pbBarra.setValue(b = 0);
                            try {
                                coordinador.reproducirN3();
                            } catch (FileNotFoundException ex) {
                                ex.getMessage();
                            }
                        }
                    }
                });
                
                boton6.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        if (coordinador.compararSo(boton6.getText()) == true){
                            JOptionPane.showMessageDialog(null, "Correcto", "", JOptionPane.DEFAULT_OPTION, correcto);
                            boton6.setEnabled(false);
                            pbBarra.setValue(++b);
                            if (estadoBarra(b) == false){
                                try {
                                    coordinador.reproducirN3();
                                } catch (FileNotFoundException ex) {
                                    ex.getMessage();
                                }
                            }
                            else{
                                //cerrar ventana
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Incorrecto", "", JOptionPane.DEFAULT_OPTION, incorrecto);
                            coordinador.arreglo();
                            habilitarBotonSo();
                            pbBarra.setValue(b = 0);
                            try {
                                coordinador.reproducirN3();
                            } catch (FileNotFoundException ex) {
                                ex.getMessage();
                            }
                        }
                    }
                });
                
                 boton7.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        if (coordinador.compararSo(boton7.getText()) == true){
                            JOptionPane.showMessageDialog(null, "Correcto", "", JOptionPane.DEFAULT_OPTION, correcto);
                            boton7.setEnabled(false);
                            pbBarra.setValue(++b);
                            if (estadoBarra(b) == false){
                                try {
                                    coordinador.reproducirN3();
                                } catch (FileNotFoundException ex) {
                                    ex.getMessage();
                                }
                            }
                            else{
                                //cerrar ventana
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Incorrecto", "", JOptionPane.DEFAULT_OPTION, incorrecto);
                            coordinador.arreglo();
                            habilitarBotonSo();
                            pbBarra.setValue(b = 0);
                            try {
                                coordinador.reproducirN3();
                            } catch (FileNotFoundException ex) {
                                ex.getMessage();
                            }
                        }
                    }
                });
                 
                 boton8.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        if (coordinador.compararSo(boton8.getText()) == true){
                            JOptionPane.showMessageDialog(null, "Correcto", "", JOptionPane.DEFAULT_OPTION, correcto);
                            boton8.setEnabled(false);
                            pbBarra.setValue(++b);
                            if (estadoBarra(b) == false){
                                try {
                                    coordinador.reproducirN3();
                                } catch (FileNotFoundException ex) {
                                    ex.getMessage();
                                }
                            }
                            else{
                                //cerrar ventana
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Incorrecto", "", JOptionPane.DEFAULT_OPTION, incorrecto);
                            coordinador.arreglo();
                            habilitarBotonSo();
                            pbBarra.setValue(b = 0);
                            try {
                                coordinador.reproducirN3();
                            } catch (FileNotFoundException ex) {
                                ex.getMessage();
                            }
                        }
                    }
                });
               
            }
        });
        
        btMostrar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (pLateral.isVisible() == true){
                    pLateral.setVisible(false);
                     btMostrar.setText("INSTRUCCIONES");
                }
                else{
                    btMostrar.setText("OCULTAR");
                    pLateral.setVisible(true);
                }
            }
        });
        
         btSalir.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               coordinador.regresarNivelesSonido();
              cerrar();
            }
        });
    
    }
    
     public static void setBoton(JButton boton){
        
        boton.setFocusPainted(false);
        boton.setForeground(Color.GREEN);
     }
     
     private boolean estadoBarra(int b){
        if (b == 8){
            JOptionPane.showMessageDialog(null, "HA GANADO", "", JOptionPane.DEFAULT_OPTION, logro);
            
            coordinador.regresarNivelesSonido();
            return true;
        }
        else
            return false;
    }
    
    private void habilitarBotonSo(){
        boton1.setEnabled(true);
        boton2.setEnabled(true);
        boton3.setEnabled(true);
        boton4.setEnabled(true);
        boton5.setEnabled(true);
        boton6.setEnabled(true);
        boton7.setEnabled(true);
        boton8.setEnabled(true);
    }
      public void cerrar()
    {
       this.setVisible(false);
    
    }
}

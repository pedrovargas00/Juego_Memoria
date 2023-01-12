/**
García Cruz Ricardo Emmanuel
Ramos López Lizbeth
Tepoz Romero Belén
Vargas Arenas Pedro
 */
package Menú;


import javax.swing.*;
import Menú.*;
import Coordinador.*;
import java.io.FileNotFoundException;

public class PrincipalMain {
 
    //Falta instanciar las clases encargadas de la lógica.
    public static void main(String [] args ) throws FileNotFoundException {  
        
        Coordinador coordinador = new Coordinador();
        
        //Instancias a las clases para el menú.
        
        
        NivelesUISo nivel2So = new NivelesUISo();
        NivelesUISu nivel3Su= new NivelesUISu();
     
        PrincipalUI principalUI = new PrincipalUI();
        nivel2So.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        nivel3Su.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        principalUI.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        //Dentro de un método.
        
        principalUI.setVisible(true);   
     
        principalUI.setCoordinador(coordinador);
       
        nivel2So.setCoordinador(coordinador);
        nivel3Su.setCoordinador(coordinador);
        
        coordinador.setNivel2(nivel2So);
        coordinador.setNivel3(nivel3Su);
        
        coordinador.setPrincipalUI(principalUI);

        NivelesUI nivel = new NivelesUI();
        coordinador.setNivel( nivel);
        nivel.setCoordinador(coordinador);
        nivel.setVisible(false);
        nivel.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
      
        
        
      
               
    }
    


 
}

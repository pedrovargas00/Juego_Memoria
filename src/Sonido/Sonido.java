package Sonido;

import Coordinador.*;
import java.io.IOException;
import java.util.logging.*;
import javax.sound.sampled.*;

public class Sonido {
    
   private Coordinador coordinador;
    private Clip audioBuho;
    private Clip audioPerro;
    private Clip audioGato;
    private Clip audioGallo;
    private Clip audioDelfin;
    private Clip audioSerpiente;
    private Clip audioVaca;
    private Clip audioOveja;
    private Clip audioVacío;
    private Clip vector[];

    public Sonido(){     
        vector = new Clip[8];
        try {
            //Instancia de los sonidos.
            audioBuho  = AudioSystem.getClip();
            audioGallo  = AudioSystem.getClip();
            audioPerro  = AudioSystem.getClip();
            audioGato = AudioSystem.getClip();
            audioOveja  = AudioSystem.getClip();
            audioDelfin  = AudioSystem.getClip();
            audioVaca  = AudioSystem.getClip();
            audioSerpiente  = AudioSystem.getClip();
            audioVacío = AudioSystem.getClip();
            iniciarVector();
        } catch (LineUnavailableException ex) {
            Logger.getLogger(Sonido.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
    public void setCoordinador(Coordinador coordinador){
        this.coordinador = coordinador;
    }
    
    public void seleccionador(int n){
        switch(n){
            case 0: reproducirBuho(vector[n]);
                break;
            case 1: reproducirGallo(vector[n]);
                break;
            case 2: reproducirPerro(vector[n]);
                break;
            case 3: reproducirGato(vector[n]);
                break;
            case 4: reproducirOveja(vector[n]);
                break;
            case 5: reproducirDelfin(vector[n]);
                break;
            case 6: reproducirVaca(vector[n]);
                break;
            case 7: reproducirSerpiente(vector[n]);
                break;
        }
    }
    //Método para reproducir los audios.
    public void reproducirBuho(Clip sonido){

        try {
            try {
                sonido.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream("/Recursos/Buho.wav")));
            } catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(Sonido.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Sonido.class.getName()).log(Level.SEVERE, null, ex);
            }
            sonido.start();
            try {
                Thread.sleep(1900);
            } catch (InterruptedException ex) {
                Logger.getLogger(Sonido.class.getName()).log(Level.SEVERE, null, ex);
            }
            sonido.close();
        } catch (LineUnavailableException ex) {
            Logger.getLogger(Sonido.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void reproducirGallo(Clip sonido){

        try {
            try {
                sonido.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream("/Recursos/Gallo.wav")));
            } catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(Sonido.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Sonido.class.getName()).log(Level.SEVERE, null, ex);
            }
            sonido.start();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Sonido.class.getName()).log(Level.SEVERE, null, ex);
            }
            sonido.close();
        } catch (LineUnavailableException ex) {
            Logger.getLogger(Sonido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void reproducirPerro(Clip sonido){

        try {
            try {
                sonido.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream("/Recursos/Perro.wav")));
            } catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(Sonido.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Sonido.class.getName()).log(Level.SEVERE, null, ex);
            }
            sonido.start();
            try {
                Thread.sleep(2600);
            } catch (InterruptedException ex) {
                Logger.getLogger(Sonido.class.getName()).log(Level.SEVERE, null, ex);
            }
            sonido.close();
        } catch (LineUnavailableException ex) {
            Logger.getLogger(Sonido.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void reproducirGato(Clip sonido){

        try {
            try {
                sonido.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream("/Recursos/Gato.wav")));
            } catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(Sonido.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Sonido.class.getName()).log(Level.SEVERE, null, ex);
            }
            sonido.start();
            try {
                Thread.sleep(900);
            } catch (InterruptedException ex) {
                Logger.getLogger(Sonido.class.getName()).log(Level.SEVERE, null, ex);
            }
            sonido.close();
        } catch (LineUnavailableException ex) {
            Logger.getLogger(Sonido.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void reproducirOveja(Clip sonido){

        try {
            try {
                sonido.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream("/Recursos/Oveja.wav")));
            } catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(Sonido.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Sonido.class.getName()).log(Level.SEVERE, null, ex);
            }
            sonido.start();
            try {
                Thread.sleep(1400);
            } catch (InterruptedException ex) {
                Logger.getLogger(Sonido.class.getName()).log(Level.SEVERE, null, ex);
            }
            sonido.close();
        } catch (LineUnavailableException ex) {
            Logger.getLogger(Sonido.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void reproducirDelfin(Clip sonido){

        try {
            try {
                sonido.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream("/Recursos/Delfín.wav")));
            } catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(Sonido.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Sonido.class.getName()).log(Level.SEVERE, null, ex);
            }
            sonido.start();
            try {
                Thread.sleep(4500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Sonido.class.getName()).log(Level.SEVERE, null, ex);
            }
            sonido.close();
        } catch (LineUnavailableException ex) {
            Logger.getLogger(Sonido.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void reproducirVaca(Clip sonido){

        try {
            try {
                sonido.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream("/Recursos/Vaca.wav")));
            } catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(Sonido.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Sonido.class.getName()).log(Level.SEVERE, null, ex);
            }
            sonido.start();
            try {
                Thread.sleep(5500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Sonido.class.getName()).log(Level.SEVERE, null, ex);
            }
            sonido.close();
        } catch (LineUnavailableException ex) {
            Logger.getLogger(Sonido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void reproducirSerpiente(Clip sonido){

        try {
            try {
                sonido.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream("/Recursos/Serpiente.wav")));
            } catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(Sonido.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Sonido.class.getName()).log(Level.SEVERE, null, ex);
            }
            sonido.start();
            try {
                Thread.sleep(6500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Sonido.class.getName()).log(Level.SEVERE, null, ex);
            }
            sonido.close();
        } catch (LineUnavailableException ex) {
            Logger.getLogger(Sonido.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    //Coloca los objetos de audio en un arreglo de tipo Clip.
    public void iniciarVector(){
        
        vector[0] = audioBuho;
        vector[1] = audioGallo;
        vector[2] = audioPerro;
        vector[3] = audioGato;
        vector[4] = audioOveja;
        vector[5] = audioDelfin;
        vector[6] = audioVaca;
        vector[7] = audioSerpiente;
    } 
    
    /*Método para reproducir un audio aleatoriamente usando
    la función Random. Como en el nivel 1 se tienen cuatro imágenes, sólo se 
    toman los primeros cuatro audios.
    */
    public int reproducirN1(){
        
        int n = (int)(Math.random()*4);
        //Para revisar si un audio es nulo y evitar su reproducción.
        while (vector[n] == audioVacío){
            n = (int)(Math.random()*4);
        //Manda a llamar el método para reproducir el audio que se manda como parámetro.
        }
        //Y se regresa la posición del audio.
        seleccionador(n);
        return n;
    }
    
    //Lo mismo pero para el segundo nivel el cuál tiene seis imágenes.
    public int reproducirN2(){
        
        int n = (int)(Math.random()*6);
        while (vector[n] == audioVacío)
            n = (int)(Math.random()*6);
        seleccionador(n);
        return n;
    }
    
    //Lo mismo pero para el segundo nivel el cuál tiene ocho imágenes.
    public int reproducirN3(){
        
        int n = (int)(Math.random()*8);
        while (vector[n] == audioVacío)
            n = (int)(Math.random()*8);
        seleccionador(n);
        return n;
    }
    
    //Compara el "valor" del botón con el sonido.
    public boolean comparar(int boton, int posicion){
        if (boton == posicion){
            //En caso de que la posición del audio en el arreglo sea igual.
            //Al "valor" del boton, entonces se quita ese audio.
            //y evitar que se reproduzca de nueva cuenta, ya que el botón se bloquea.
            vector[posicion] = audioVacío;
            return true;
        }
        else
            return false;
    }
}

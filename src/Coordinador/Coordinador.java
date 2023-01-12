package Coordinador;

import Diferente.*;
import Sonido.*;
import Sucesión.*;
import Menú.*;
import java.io.FileNotFoundException;
import javax.swing.JFrame;

public class Coordinador {
    
    
    Coordinador c;
    //Referencias a las clases para el menú.
    NivelesUI nivel;
    NivelesUISo nivel2So;
    NivelesUISu nivel3Su;
    PanelPrincipal principal;
    PrincipalUI principalUI;
    PrincipalMain pri;
    
    //Referencias a las clases que componen el juego de sonidos.
    Sonido logicaSo;
    SonidoUI vistaSo1;
    SonidoUI2 vistaSo2;
    SonidoUI3 vistaSo3;
    
    //Referencias a las clases que componen el juego de memorama.
    Diferente logicaDi;
    DiferenteUI vistaDi1;
    DiferenteUI2 vistaDi2;
    DiferenteUI3 vistaDi3;
    
    //Referencias a las clases que componen el juego de sucesión.
    Ordenar logicaSu;
    OrdenarUIN1 vistaSu1;
    OrdenarUIN2 vistaSu2;
    OrdenarUIN3 vistaSu3;

    public PrincipalMain getPri() {
        return pri;
    }

    public void setPri(PrincipalMain pri) {
        this.pri = pri;
    }

    public void setNivel(NivelesUI nivel) {
        this.nivel = nivel;
        
    }

    public NivelesUISo getNivel2() {
        return nivel2So;
    }

    public void setNivel2(NivelesUISo nivel2) {
        this.nivel2So = nivel2;
    }

    public NivelesUISu getNivel3() {
        return nivel3Su;
    }

    public void setNivel3(NivelesUISu nivel3) {
        this.nivel3Su= nivel3;
    }
     public void mostrar(int n) {
       switch(n){
           case 1: 
               nivel.mostrarN1();
              
               break;
            case 2: 
                nivel3Su.mostrarN3();
            break;
             case 3: nivel2So.mostrarN2();break;
       }
       
    }
       public void mostrarDiferente(int n) {
      
       switch(n){
           case 1:
                mostrarD1();
               break;
            case 2: 
                mostrarD2();
            break;
             case 3:  
                mostrarD3();
                 break;
       }
       
    }
        public void mostrarSucesion(int n) {
      
       switch(n){
           case 1: 
               mostrarSu1();
               break;
            case 2: 
                mostrarSu2();
            break;
             case 3:  
                 mostrarSu3();break;
       }
       
    }
           public void mostrarSonido(int n) throws FileNotFoundException{
      
       switch(n){
           case 1: 
               mostrarSo1();
               break;
            case 2: 
                 mostrarSo2();
            break;
             case 3:  
                 mostrarSo3();
                 break;
       }
       
       
    }
    
        public void regresarMenu() {
            principalUI.mostrarMenu();
    }
        
         public void regresarNivelesDiferente() {
         nivel.mostrarN1();
    }
         
 public void regresarNivelesSucesion() {
       nivel3Su.mostrarN3();
    }
 public void regresarNivelesSonido() {
       nivel2So.mostrarN2();
    }
    public void setPrincipal(PanelPrincipal principal) {
        this.principal = principal;
    }

    public void setPrincipalUI(PrincipalUI principalUI) {
        this.principalUI = principalUI;
    }

    public void setLogicaSo(Sonido logicaSo) {
        this.logicaSo = logicaSo;
    }

    public void setVistaSo1(SonidoUI vistaSo1) {
        this.vistaSo1 = vistaSo1;
    }

    public void setVistaSo2(SonidoUI2 vistaSo2) {
        this.vistaSo2 = vistaSo2;
    }

    public void setVistaSo3(SonidoUI3 vistaSo3) {
        this.vistaSo3 = vistaSo3;
    }

    public void setLogicaDi(Diferente logicaDi) {
        this.logicaDi = logicaDi;
    }

    public void setVistaDi1(DiferenteUI vistaDi1) {
        this.vistaDi1 = vistaDi1;
    }

    public void setVistaDi2(DiferenteUI2 vistaDi2) {
        this.vistaDi2 = vistaDi2;
    }

    public void setVistaDi3(DiferenteUI3 vistaDi3) {
        this.vistaDi3 = vistaDi3;
    }

    public void setLogicaSu(Ordenar logicaSu) {
        this.logicaSu = logicaSu;
    }

    public void setVistaSu1(OrdenarUIN1 vistaSu1) {
        this.vistaSu1 = vistaSu1;
    }

    public void setVistaSu2(OrdenarUIN2 vistaSu2) {
        this.vistaSu2 = vistaSu2;
    }

    public void setVistaSu3(OrdenarUIN3 vistaSu3) {
        this.vistaSu3 = vistaSu3;
    }

      public void desbloqNivel2Di() {
       nivel.des2();
    }
        public void desbloqNivel3Di() {
       nivel.des3();
    }


    public void desbloqNivel2Su() {
        nivel3Su.des2();
    }
    
    public void desbloqNivel3Su() { 
        nivel3Su.des3();
    }
    public void desbloqNivel2So() {
        nivel2So.des2();
    }
    
    public void desbloqNivel3So() { 
        nivel2So.des3();
    }
     public void mostrarD1(){
         DiferenteUI vistaDi1 = new DiferenteUI(); 
         vistaDi1.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);       
         this.setVistaDi1(vistaDi1);
        vistaDi1.setCoordinador(this);
         vistaDi1.setVisible(true);


    }
      public void mostrarD2(){
         DiferenteUI2 vistaDi2 = new DiferenteUI2(); 
         vistaDi2.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setVistaDi2(vistaDi2);
        vistaDi2.setCoordinador(this);
         vistaDi2.setVisible(true);


    }
      public void mostrarD3(){
         DiferenteUI3 vistaDi3 = new DiferenteUI3(); 
         vistaDi3.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
         this.setVistaDi3(vistaDi3);
        vistaDi3.setCoordinador(this);
         vistaDi3.setVisible(true);
  }
       public void mostrarSu1(){
       OrdenarUIN1 vistaSu1 = new OrdenarUIN1();
         vistaSu1.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);        
       this.setVistaSu1(vistaSu1);
        vistaSu1.setCoordinador(this);
        vistaSu1.setVisible(true);
        Ordenar logicaSu = new Ordenar();
         this.setLogicaSu(logicaSu);
        logicaSu.setCoordinador(this);
    
  }
        public void mostrarSu2(){
         OrdenarUIN2 vistaSu2 = new OrdenarUIN2();
         vistaSu2.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);        
         this.setVistaSu2(vistaSu2);
        vistaSu2.setCoordinador(this);
        vistaSu2.setVisible(true);
        Ordenar logicaSu = new Ordenar();
         this.setLogicaSu(logicaSu);
        logicaSu.setCoordinador(this);
  }
         public void mostrarSu3(){
         OrdenarUIN3 vistaSu3 = new OrdenarUIN3();
         vistaSu3.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);       
         this.setVistaSu3(vistaSu3);
        vistaSu3.setCoordinador(this);
        vistaSu3.setVisible(true);
        Ordenar logicaSu = new Ordenar();
         this.setLogicaSu(logicaSu);
        logicaSu.setCoordinador(this);
  }
        public void mostrarSo1() throws FileNotFoundException{
        SonidoUI vistaSo1 = new SonidoUI();
         vistaSo1.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);        
        this.setVistaSo1(vistaSo1);
        vistaSo1.setCoordinador(this);
        vistaSo1.setVisible(true);
         Sonido logicaSo = new Sonido();
         this.setLogicaSo(logicaSo);
        logicaSo.setCoordinador(this);
  }
        public void mostrarSo2() throws FileNotFoundException{
        SonidoUI2 vistaSo2 = new SonidoUI2();
         vistaSo2.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);        
        this.setVistaSo2(vistaSo2);
        vistaSo2.setCoordinador(this);
        vistaSo2.setVisible(true);
         Sonido logicaSo = new Sonido();
         this.setLogicaSo(logicaSo);
        logicaSo.setCoordinador(this);
  }
         public void mostrarSo3() throws FileNotFoundException{
           SonidoUI3 vistaSo3 = new SonidoUI3();
         vistaSo3.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);       
           this.setVistaSo3(vistaSo3);
        vistaSo3.setCoordinador(this);
        vistaSo3.setVisible(true);
         Sonido logicaSo = new Sonido();
         this.setLogicaSo(logicaSo);
        logicaSo.setCoordinador(this);
  }
      public void agregar(String n){
        int m = Integer.parseInt(n);
        logicaSu.agregarNivel1(m);
    }
    public void limpiarArreglo(){
        logicaSu.limpiarArreglo();
    }
    public void ordena(){
        logicaSu.ordena(logicaSu.getNum());
    
    }
    
    public boolean comparar(String n){
        int m = Integer.parseInt(n);
        
        if(logicaSu.comparar(m)==true)
            return true;
        else 
            return false;      
    }
    
    public void valorI(){
        logicaSu.setI(0);
    }
      int sonido;
    public void reproducirN1() throws FileNotFoundException{
        sonido = logicaSo.reproducirN1();
    }
    
    public void reproducirN2() throws FileNotFoundException{
        sonido = logicaSo.reproducirN2();
    }
    
    public void reproducirN3() throws FileNotFoundException{
        sonido = logicaSo.reproducirN3();
    }
    
    public boolean compararSo(String s){
        int p = Integer.parseInt(s);
        return logicaSo.comparar(p, sonido);
    }
    
    public void arreglo(){
        logicaSo.iniciarVector();
    }
    
}

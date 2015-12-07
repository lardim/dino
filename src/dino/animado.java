/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dino;

import java.awt.Color;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author gato
 */
public class animado {
     private JPanel panel=null;
     Graphics g2=null;
      public Thread hilo1=null;
     int ya=0,ya1=0,ya2=0;
    public int x=0,y=0,posx=0,posy=0,img1=1,puntos=0;
    
    
         ImageIcon image =new ImageIcon(new ImageIcon(getClass().getResource("/dino/imagenes/nube.png")).getImage());
         
         ImageIcon imagen =new ImageIcon(new ImageIcon(getClass().getResource("/dino/imagenes/piso.png")).getImage());
  private boolean chocapuerta=true;
    
  public animado(JPanel j){
  panel=j;
  x=panel.getWidth()-100;
  y=panel.getHeight()-450;
  posx=x-889;
  posy=y+220;
      System.out.println("tamaño puerta x"+x+"tamaño puerta y ="+y);
  }
    
  public void paint(Graphics g){
     g2=g;
      
      g.drawImage(image.getImage(), x+100, y,   null);   
      g.drawImage(imagen.getImage(),posx,posy,null);
      //System.out.println("tamaño puerta x"+x+"tamaño puerta y ="+y);
  if(chocapuerta){
//g.setColor(Color.red);   
 //g.drawRect(posx-10, posy, 20, 300);   
  
 //
  ImageIcon image2 =new ImageIcon(new ImageIcon(getClass().getResource("/dino/imagenes/dino-vivo"+img1+".png")).getImage());
                 g.drawImage(image2.getImage(), 50, 280,   null); 
                  if(ya==0 || ya1==0 || ya==1){
                  img1++;
     
                  if(img1>=3){
                  img1=1;
                  } 
                  }
  }  
  }
  
  public void animacion(){

         
   //this.panel.getGraphics().drawLine(30, 30,45, 60);
 if(!hilo2.isAlive()){
            hilo2.start();
   }
  else{
 hilo2.resume();
 chocapuerta=true;
 posx=50;
 }
      
  }
  
  public void salto(){
    if(!salto.isAlive()){
      salto.start();
    }else{
        ya=0;
        ya1=0;
        salto.resume();
    }
  }
  
  public void alto(){
      ya1=1;
  }
  
  public int getPuntos(){
      return puntos;
  }

    /**
     * @return the chocapuerta
     */
    public boolean isChocapuerta() {
        return chocapuerta;
    }

    /**
     * @param chocapuerta the chocapuerta to set
     */
    public void setChocapuerta(boolean chocapuerta) {
        this.chocapuerta = chocapuerta;
    }
    
    
     private Thread hilo2 = new Thread()
    {
        

        @Override
        public void run()
        {
            try
            {
                while(true)
                {
                 if(ya1==0){   
                  if((posx)<=-948)
                  posx=1;  
                 
                  if(x<=-869)
                      x=890;
               panel.repaint();   
                 x-=30;
                 posx-=30;
                 
                 
               
                 hilo2.sleep(100);
                     puntos++;
                 }
                }
            }catch (java.lang.InterruptedException ie) { System.out.println(ie.getMessage()); }
        }
    };
     
     private Thread salto = new Thread()
    {
        

        @Override
        public void run()
        {
            
                
               while(true){                
                    try {
                        panel.repaint();
                        if(posy<=410 && ya==0 && posy>301){
                            posy+=10;
                            y+=10;
                            if(posy==402)
                                ya=1;
                        }
                        else if(ya!=2){
                            posy-=10;
                            y-=10;
                        }
                        if(posy==302)
                            ya=2;
                        if(ya!=2)
                            salto.sleep(50);
                        else if(ya==2)
                            salto.sleep(250);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(animado.class.getName()).log(Level.SEVERE, null, ex);
                    }
               }               
        }
    };

    /**
     * @return the panel
     */
    public JPanel getPanel() {
        return panel;
    }

    /**
     * @param panel the panel to set
     */
    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    /**
     * @return the hilo2
     */
    public Thread getHilo2() {
        return hilo2;
    }

    /**
     * @param hilo2 the hilo2 to set
     */
    public void setHilo2(Thread hilo2) {
        this.hilo2 = hilo2;
    }
}

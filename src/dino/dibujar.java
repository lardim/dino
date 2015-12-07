/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dino;

import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 *
 * @author gato
 */
public class dibujar extends JComponent{
     private animado anima;

       public dibujar(JComponent contenedor,JPanel j){
                 super();
       this.setBounds(0, 0,contenedor.getWidth() , contenedor.getHeight());
       contenedor.add(this);
       anima= new animado(j);
       }
       
       public void animacion(){
       anima.animacion();
       }
       
       public void salto(){
           anima.salto();
       }
       
       public int alto(){
           anima.alto();
           return 1;
       }
       public boolean isalivehilo(){
      return anima.getHilo2().isAlive();
       }
       
       public int getPuntos(){
           return anima.getPuntos();
       }
       
         @Override
    public void paint(Graphics g){
        super.paint(g);
        anima.paint(g);
    }
             
}

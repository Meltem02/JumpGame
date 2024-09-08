
package nesne;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import poli.Kaynak;

/**
 *
 * @author LENOVO
 */
public class Fındık extends Düşman{
    
      private BufferedImage image;
    private int posX,posY;
    private Rectangle rect;//nesnesinin genişliği ve yüksekliği ortak alanlardır.(x,y) koordinatını ayarlar
     private MainKarekter mainKarekter;
    private boolean isSkorGot=false;
    
    
    public Fındık(MainKarekter mainKarekter) {
        this.mainKarekter=mainKarekter;
            image=Kaynak.getKaynakImage("data/findik2.png");
        posX=400;
        posY=260;
        rect= new Rectangle();
        
    }


 
    @Override
    public void update(){
         posX-=5;
         rect.x=posX;
         rect.y=posY;
         rect.height=image.getHeight();
         rect.width=image.getWidth();
    }
    
    @Override
    public Rectangle getBound(){
        
       return rect;
        
    }
    @Override
    public void draw (Graphics g){
        g.drawImage(image, posX, posY, null);
    }

  
    public void setX(int x){
        posX=x;
    }
     public void setY(int y){
        posY=y;
    }
     public void setImage(BufferedImage image){
         this.image = image;
     }

    @Override
    public boolean isOutOfScreen() {
        return(posX + image.getWidth() < 0);
    }
    @Override
    public boolean isOver(){
        return (mainKarekter.getX() > posX);
    }
    
    @Override
    public boolean isSkorGot() {
          return isSkorGot;
    }
      @Override
    public void setIsSkorGot(boolean isSkorGot) {
         this.isSkorGot=isSkorGot;
    }
}
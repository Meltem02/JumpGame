
package nesne;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import poli.Kaynak;
import static userinterface.OyunEkrani.GRAVITY;
import static userinterface.OyunEkrani.GROUNDY;



public class MainKarekter {
    private float x= 0;
    private float y= 0;
    private float speedY=0;
    private BufferedImage karekterImage;
    private Rectangle rect;
    private boolean isAlive=true;
  
    
    public MainKarekter() {
        karekterImage = Kaynak.getKaynakImage("data/scart.png");
        rect = new Rectangle();
    }
            
            
            
            
    public void update(){
        // tüm bu satır kodu atlama için      
               
             if(y >=GROUNDY -karekterImage.getHeight()){
                    speedY=0;
                    y= GROUNDY-karekterImage.getHeight();
                }
                else{
                speedY+=GRAVITY;
              y+=speedY;
               }
             rect.x= (int) x;
             rect.y =(int) y;
             rect.width=karekterImage.getWidth();
              rect.height=karekterImage.getHeight();
             
    }
    public Rectangle getBound(){
        return rect;
    }
    public void draw(Graphics g){
         g.setColor(Color.BLACK);
      // g.drawRect((int) x,(int) y,karekterImage.getWidth(),karekterImage.getHeight());//etrafındak, siyah
      //dikdörtgeni yok etmek için yorum satırına alındı.
         g.drawImage(karekterImage, (int) x, (int) y, null);
    }
     
    public void jump(){  //y ekseninde ne kadar zıplayacağı kod
        speedY=-6;
        y+=speedY;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getSpeedY() {
        return speedY;
    }

    public void setSpeedY(float speedY) {
        this.speedY = speedY;
    }
    public void setAlive(boolean alive){
        isAlive= alive;
    }
    public boolean getAlive(){
        return isAlive;
    }
    
}

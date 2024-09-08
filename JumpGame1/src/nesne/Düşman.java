
package nesne;

import java.awt.Graphics;
import java.awt.Rectangle;


public abstract class Düşman {
    public abstract Rectangle getBound();
    public abstract void draw(Graphics g);
    public abstract void update();
    public abstract boolean isOutOfScreen();
    public abstract boolean isOver();
    public abstract boolean isSkorGot();
      public abstract void setIsSkorGot(boolean isSkorGot);
}
//abstract class açım sebebim :
//1-Türetilmiş sınıflara ortak bir temel sınıf uygulaması 
//2-Bir arabirimde, tüm yöntemler herkese açık olmalıdır.

package userinterface;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import nesne.ArkaPlan;
import nesne.DüşmanlarYöneticisi;
import nesne.MainKarekter;
import poli.Kaynak;

public class OyunEkrani extends JPanel implements Runnable, KeyListener{
    public static final int GAME_FIRST_STATE=0;
       public static final int GAME_PLAY_STATE=1;
          public static final int GAME_OVER_STATE=2;
    public static final float GRAVITY= 0.1f;
    public static final float GROUNDY= 350;
    
    
    private MainKarekter mainKarekter;
    private Thread thread;
    private ArkaPlan arkaPlan;
    private DüşmanlarYöneticisi düşmanlarYöneticisi;
    private int oyunDurumu=GAME_FIRST_STATE;
    private BufferedImage imageGameOverText;
    
   
    private int skor;
    public OyunEkrani() {  
        thread= new Thread(this);
        mainKarekter= new MainKarekter();
        mainKarekter.setX(10);
        mainKarekter.setY(100); // karekterin nerede başlayacağının konumu
        arkaPlan = new ArkaPlan(this);
        düşmanlarYöneticisi= new DüşmanlarYöneticisi(mainKarekter,  this);
        imageGameOverText=Kaynak.getKaynakImage("data/finish.jpg");
      
    }
        public void startGame(){
           thread.start();
        }
        
   
    @Override
    public void run() {
        while (true) {            
            try {
                update();
                repaint();
                Thread.sleep(10); //oyun hızını ayarlamak için 
            }
            catch(InterruptedException ex){
                ex.printStackTrace();
            }
}
}
    
    public void update(){
        switch(oyunDurumu){
            case GAME_PLAY_STATE:
              mainKarekter.update();
              arkaPlan.update();
              düşmanlarYöneticisi.update();
              if(!mainKarekter.getAlive()){
                  oyunDurumu=GAME_OVER_STATE;
              }
                break;
        }
        
    }
    public void plusSkor(int skor){
        this.skor+=skor;
    }
    
    
    @Override
    public void paint(Graphics g){
        g.setColor(Color.decode("#f7f7f7"));
        g.fillRect(0, 0, getWidth(), getHeight());
      //  g.setColor(Color.red);
       //  g.drawLine(0,(int) GROUNDY, getWidth(),(int)GROUNDY );
         
         switch(oyunDurumu){
             case GAME_FIRST_STATE:
              mainKarekter.draw(g);
                 
             break;
             case GAME_PLAY_STATE:
                     arkaPlan.draw(g);
                     mainKarekter.draw(g);
                     düşmanlarYöneticisi.draw(g);
                     g.drawString("SKOR=" +String.valueOf(skor), 900,20 ); //skorun konumu
                     
                    break;
                    case GAME_OVER_STATE:
                     arkaPlan.draw(g);
                     mainKarekter.draw(g);
                     düşmanlarYöneticisi.draw(g);
                     g.drawImage(imageGameOverText, 190, 130, null);  //game over konumu
                    break;
            }
         
   
             }

    public void resetGame(){
        mainKarekter.setAlive(true);
        mainKarekter.setX(50);
        mainKarekter.setY(100);  //tekrar başladığındaki konum 
        düşmanlarYöneticisi.reset();
    }
    
    

    @Override
    public void keyTyped(KeyEvent e) {//bir anahtar yazıldığında bu method çağırılır.
    }

    @Override
    public void keyPressed(KeyEvent e) {//onun yöntemi bir tuşa basıldığında çağrılır.

    }

    @Override
    public void keyReleased(KeyEvent e) {//Bu yöntem, bir anahtar bırakıldığında çağrılır.
        switch(e.getKeyCode()){
            case KeyEvent.VK_SPACE:
                if(oyunDurumu==GAME_FIRST_STATE){
                    oyunDurumu=GAME_PLAY_STATE;
                }
                else if (oyunDurumu==GAME_PLAY_STATE){
                    mainKarekter.jump();
                }
                else if(oyunDurumu==GAME_OVER_STATE){
                    resetGame();
                    oyunDurumu=GAME_PLAY_STATE;
                }
                break;
        }
    }
}
    


    


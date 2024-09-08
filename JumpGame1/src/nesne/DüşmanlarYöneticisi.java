
package nesne;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;//çeşitli veri tiplerinden rastgele bir değer almamızı sağlamaktadır.
import poli.Kaynak;
import userinterface.OyunEkrani;
public class DüşmanlarYöneticisi {
      private List<Düşman> düşmanlar;
    private Random random;
    private BufferedImage imageFındık1;
    private MainKarekter mainKarekter;
    private OyunEkrani oyunEkrani;
 
    
   public DüşmanlarYöneticisi(MainKarekter mainKarekter, OyunEkrani oyunEkrani){
       this.oyunEkrani=oyunEkrani;
       this.mainKarekter = mainKarekter;
        düşmanlar= new ArrayList<Düşman>();
         imageFındık1=Kaynak.getKaynakImage("data/findik2.png");
         random= new Random();
         düşmanlar.add(getRandomFındık());
         
    }

    
    public void update() {
        for(Düşman d:düşmanlar){
            d.update();
            if(d.isOver() && !d.isSkorGot()){
                oyunEkrani.plusSkor(20);
                d.setIsSkorGot(true);
                
            }
            if(d.getBound().intersects(mainKarekter.getBound())){
                mainKarekter.setAlive(false);   
            }
        }
        Düşman ilkDüşman=düşmanlar.get(0);
        if(ilkDüşman.isOutOfScreen()){
        düşmanlar.remove(ilkDüşman);  //son sürümün çalışmasını sağlar remove
        düşmanlar.add(getRandomFındık());
    }
        }
    
   
    public void draw(Graphics g){
        for(Düşman d:düşmanlar){
            d.draw(g);
        }
    }
    public void reset(){
        düşmanlar.clear();
         düşmanlar.add(getRandomFındık());
    }
    private Fındık getRandomFındık() {
        Fındık fındık;
         fındık = new Fındık(mainKarekter);
         fındık.setX(700); //düşmanın x eksenindeki konum kodu 
        if(random.nextBoolean()){
           fındık.setImage(imageFındık1);
        }
        else{
            fındık.setImage(imageFındık1);
        }
        return fındık;
    }
}



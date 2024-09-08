
package nesne;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import poli.Kaynak;
import userinterface.OyunEkrani;
import static userinterface.OyunEkrani.GROUNDY;


public class ArkaPlan {
    private List<ImageArkaPlan> listImage;
    private BufferedImage imageArkaPlan1,imageArkaPlan2 ;
    private Random random;
 
   public ArkaPlan(OyunEkrani oyun)  {
       random = new Random();
       imageArkaPlan1=Kaynak.getKaynakImage("data/no1.jpg");
       imageArkaPlan2=Kaynak.getKaynakImage("data/no2.jpg");
        
         listImage = new ArrayList<ImageArkaPlan>();      
         int numberOfLandTitle =850 / imageArkaPlan1.getWidth()+2;
         System.out.println(numberOfLandTitle);
         for(int i=0; i<numberOfLandTitle;i++) {
             ImageArkaPlan imageArkaPlan = new ImageArkaPlan();
             imageArkaPlan.posX = (int) (i * imageArkaPlan1.getWidth());
             imageArkaPlan.image=imageArkaPlan1;
             listImage.add(imageArkaPlan);
         }
   }
   public void update(){//ekranın x ekseni yönünde kaymaası
       for(ImageArkaPlan imageArkaPlan: listImage){
           imageArkaPlan.posX--;
       }
       ImageArkaPlan ilkElement = listImage.get(0);
       if(ilkElement.posX + imageArkaPlan1.getWidth() <0) {
           ilkElement.posX = listImage.get(listImage.size() -1).posX + imageArkaPlan1.getWidth();
           listImage.add(ilkElement);
           listImage.remove(0);
       }
       
   }
    
    public void draw(Graphics g){//arka plan resmin ekrana tam oturması için yapılna kod 
        for(ImageArkaPlan imageArkaPlan:listImage) {
          g.drawImage(imageArkaPlan.image,imageArkaPlan.posX,(int) GROUNDY-400, null);  
        }
        
    }
         private BufferedImage getImageArkaPlan(){
          int i = random.nextInt(10);
           switch(i){
              case 0: return imageArkaPlan1;
               default: return imageArkaPlan2;

}
         }
   
     private class ImageArkaPlan {
    int posX;
    BufferedImage image;

 }
  
}





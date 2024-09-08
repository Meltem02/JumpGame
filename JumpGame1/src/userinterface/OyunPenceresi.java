package userinterface;

import javax.swing.JFrame;//Boyutları değişebilen, hareket edebilen, üzerinde
//bir ad şeridi ve kapatma düğmesi olan swing aracıdır.
 


public class OyunPenceresi extends JFrame {
    private final OyunEkrani oyunEkrani;
    private OyunEkrani OyunEkrani;

       public OyunPenceresi(){
           super("JumpGame1");
        setSize(1000,400); 
        setLocation(150,150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Varsayılan davranış, kullanıcı 
                                                      //pencereyi kapattığında JFrame'i basitçe gizlemektir. 
        
        oyunEkrani = new OyunEkrani();
        addKeyListener(oyunEkrani);
        add(oyunEkrani);
       }
       
    public void startGame(){
        oyunEkrani.startGame();
    }

	public static void main(String args[])  {
		OyunPenceresi gw =new OyunPenceresi();
                gw.setVisible(true);//çerçevenin ekranda gözükmesini saplayan kod
                gw.startGame();
        }
 
    }



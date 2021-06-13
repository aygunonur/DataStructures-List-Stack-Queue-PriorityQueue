import java.util.ArrayList;
import java.util.List;
import java.util.Random;


class Musteri {
    
    public String MusteriAdi;
    public int UrunSayisi;

    
    public Musteri(String MusteriAdi, int UrunSayisi) {
        this.MusteriAdi=MusteriAdi;
        this.UrunSayisi=UrunSayisi;
    }

    @Override
    public String toString() {
        return "(" + MusteriAdi + "," + UrunSayisi + ")";
    }
      
}

class Program {
     
    public static int RandomCagir() {
        Random random = new Random();
        double randomDouble = Math.random();
        int randomInt = (int)(randomDouble*4+1);
        return randomInt;
    }
    
    public static void main(String[] args) {
        String[] MusteriAdi = {"Ali","Merve","Veli","Gülay","Okan","Zekiye","Kemal","Banu","İlker","Songül","Nuri","Deniz"};
        int[] UrunSayisi = {8, 11, 16, 5, 15, 14, 19, 3, 18, 17, 13, 15 };
        
        ArrayList arrayList = new ArrayList();
        int sayac1=0;
        int sayac2=0;
        Musteri musteri;
        List<Musteri> genericList = null;
                
        while (sayac1<MusteriAdi.length) {
            
            genericList = new ArrayList<Musteri>();
            int genericlistLength = RandomCagir() ;
            
            for (int i=0; i<genericlistLength; i++) {
                musteri = new Musteri(MusteriAdi[sayac1],UrunSayisi[sayac1]);
                genericList.add(musteri);
                sayac1++;
                
                if (sayac1== MusteriAdi.length) {
                    break;  
                }
            
            sayac2++;
            }
        arrayList.add(genericList);

        }
        for (int i = 0; i <arrayList.size();i++) {     		      
            System.out.println(arrayList.get(i).toString()); 		
        }
        
        double musterisay = MusteriAdi.length;
        double arraysay = arrayList.size();
        double ortalama = musterisay/arraysay;
        System.out.println("ArrayList Eleman Sayısı: " + (int) arraysay);
        System.out.println("Listelerin Ortalama Eleman Sayısı: " + ortalama);

        
   
    }  
    
}
    
        
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    


import java.util.*; 

class OncelikliKuyruk {
    
    private int nItems;
    private int maxsize; 
    List<Musteri> liste1 ;

    public OncelikliKuyruk() {  
    }
    
    public OncelikliKuyruk(int maxsize) {
        this.maxsize = maxsize;
        liste1= new ArrayList<>(maxsize);

        nItems=0;
    }
    
    public void ekle(Musteri newMusteri) {
        liste1.add(newMusteri);
        nItems++;      
    }
    
     public boolean bosMu() {
        return (nItems==0);
    }

    public boolean doluMu() {
        return (nItems == maxsize);
    }
   
    public Musteri sil(String data) {
        if(data.equals("maximum")){
            int maximum = 0;

            for (int i = 0; i < liste1.size(); i++) {
                if (liste1.get(maximum).UrunSayisi < liste1.get(i).UrunSayisi) {
                    maximum = i;
                }
            }
            Musteri musteri = liste1.get(maximum);
            liste1.remove((musteri));
            return musteri ;
        }

        else {
            int minimum = 0;
            for(int i =0;i<liste1.size();i++){
                if(liste1.get(minimum).UrunSayisi > liste1.get(i).UrunSayisi){
                    minimum = i;
                }
            }
            Musteri musteri1 = liste1.get(minimum);
            liste1.remove((musteri1));
            return musteri1;
        }
    
    }
           
    public static void main(String[] args) {
        
        String[] MusteriAdi = {"Ali","Merve","Veli","Gülay","Okan","Zekiye","Kemal","Banu","İlker","Songül","Nuri","Deniz"};
        int[] UrunSayisi = {8, 11, 16, 5, 15, 14, 19, 3, 18, 17, 13, 15 };
        
        int zaman =0;
        int toplamzaman=0;
        
        int musterisayisi = MusteriAdi.length;
        
        OncelikliKuyruk priorityQ = new OncelikliKuyruk(musterisayisi);
        OncelikliKuyruk ReversepriorityQ = new OncelikliKuyruk(musterisayisi);
        OncelikliKuyruk priorityQ2 = new OncelikliKuyruk(musterisayisi);
        OncelikliKuyruk priorityQ3 = new OncelikliKuyruk(musterisayisi);
                      
        for (int i=0; i<musterisayisi; i++) {
            Musteri newMusteri = new Musteri(MusteriAdi[i], UrunSayisi[i]);
            priorityQ.ekle(newMusteri);
            ReversepriorityQ.ekle(newMusteri); 
            priorityQ2.ekle(newMusteri);
            priorityQ3.ekle(newMusteri);
        }
        System.out.println("------------------------------------------------------------");
        for(int i = 0 ; i < musterisayisi ; i++){
            
            System.out.println(ReversepriorityQ.sil("maximum").toString());
           
        }

        System.out.println("------------------------------------------------------------");

        for(int i = 0 ; i < musterisayisi ; i++){
            System.out.println(priorityQ.sil("minimum").toString());
        }
        System.out.println("------------------------------------------------------------");
        for(int i=0; i<musterisayisi; i++) {
            zaman += priorityQ2.sil("minimum").UrunSayisi;
            toplamzaman += zaman;
            System.out.println(priorityQ3.sil("minimum").MusteriAdi +"--" + zaman );
            
        }
        System.out.println("------------------------------------------------------------");
        float ortalama = (float)toplamzaman / musterisayisi;
        System.out.print("Ortalama Süre: ");
        System.out.println(ortalama);
      
    }

}



        
class StackX {
    
    public int maxsize;
    public Object[] stackArray;
    public int top;
    
    public StackX() {
        
    }
    
    public StackX(int maxsize) {
        this.maxsize = maxsize ;
        stackArray = new Object[maxsize];
        top=-1;      
    }
    
    public void push(Object object) {
        stackArray[++top] = object;
    }
    
    public Object pop() {
  
        return stackArray[top--];
    }  
    
    public boolean isEmpty()  { 
    
        return (top == -1);
    }
             
}

class QueueX {
      
    public int maxSize;
    public Object[] queArray;
    public int front;
    public int rear;
    public int nItems;
      
    public QueueX(int maxsize) {

        this.maxSize = maxsize;
        queArray = new Object[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }   
    public Object remove() {
        Object temp = queArray[front++];
        if(front == maxSize)
        front = 0;
        nItems--;
        return temp;
    }   
    public void insert(Object object1)  {

        if(rear == maxSize-1)
        rear = -1;
        queArray[++rear] = object1; 
        nItems++; 
    }
    
    public boolean isEmpty() {

        return (nItems==0);
    }  
}

class StackQueue {
           
    public static void main(String[] args) {
        
        String[] MusteriAdi = {"Ali","Merve","Veli","Gülay","Okan","Zekiye","Kemal","Banu","İlker","Songül","Nuri","Deniz"};
        int[] UrunSayisi = {8, 11, 16, 5, 15, 14, 19, 3, 18, 17, 13, 15 };
        
        int musterisayisi = MusteriAdi.length;
           
        StackX yigit = new StackX(musterisayisi);
         
        for (int i = 0; i < musterisayisi; i++) {
            Musteri newmusteri = new Musteri(MusteriAdi[i], UrunSayisi[i]);
            yigit.push(newmusteri);           
        }
        
        System.out.println("Stack Yazdırılıyor..");
        System.out.println("--------------------");
        
        while (!yigit.isEmpty()) {
            System.out.println(yigit.pop());
            
        }
        System.out.println();
        QueueX kuyruk = new QueueX(musterisayisi);
               
        
        for (int i = 0; i < musterisayisi; i++) {
            Musteri newMusteri = new Musteri(MusteriAdi[i], UrunSayisi[i]);
            kuyruk.insert(newMusteri);
            
        }
        System.out.println("Queque yazdırılıyor..");
        System.out.println("---------------------");
        
        while (!kuyruk.isEmpty()) {
            System.out.println(kuyruk.remove());
            
        }
        System.out.println("---------------------");
        double zaman=0.0;
        double toplamzaman=0.0;
        
        int j;
        for(j=0; j<musterisayisi; j++) {
            Musteri newMusteri = new Musteri(MusteriAdi[j], UrunSayisi[j]);
            zaman += newMusteri.UrunSayisi;
            System.out.println(newMusteri.MusteriAdi + ": " + zaman);
            toplamzaman += zaman;
            
        }
        System.out.println("---------------------");
        double ort = toplamzaman / musterisayisi;
        System.out.println("ORTALAMA SÜRE:" + ort);
    }
     
}

package LinkedList2;

//&Çift Yönlü Doğrusal Bağlı Liste
public class Liste {
    Node head = null;
    Node tail = null;

    void basaEkle(int data) {// ^ Başa Ekle
        Node eleman = new Node(data);
        if (head == null) {
            head = eleman;
            tail = eleman;
            System.out.println("İlk eleman oluşturuldu");
        } else {
            eleman.next = head;
            head.prev = eleman;
            head = eleman;
            System.out.println("Listenin başına eleman eklendi");
        }
    }

    void sonaEkle(int data) {// ^ Sona Ekle
        Node eleman = new Node(data);
        if (head == null) {
            head = eleman;
            tail = eleman;
            System.out.println("İlk eleman oluşturuldu");
        } else {
            tail.next = eleman;
            eleman.prev = tail;
            tail = eleman;
            System.out.println("Listenin sonuna eleman eklendi");
        }
    }

    void arayaEkle(int position, int data) {// ^Araya Ekle
        Node eleman = new Node(data); // Yeni düğüm oluşturuluyor.
        eleman.data = data; // Veriyi atıyoruz.

        // Eğer liste boşsa
        if (head == null) {
            head = eleman;
            tail = eleman;
            System.out.println("Liste boştu, eleman eklendi.");
            return;
        }

        // Eğer pozisyon başa eklemekse (pozisyon 0)
        if (position == 0) {
            basaEkle(data);
            return;
        }

        // Araya veya sona ekleme işlemi
        Node temp = head; // Başlangıç olarak temp'e head'i veriyoruz.

        // Pozisyona kadar ilerliyoruz
        for (int i = 0; i < position - 1; i++) {
            if (temp.next == null) {
                break; // Eğer pozisyon listeden büyükse dur.
            }
            temp = temp.next; // Temp'i bir sonraki düğüme taşı.
        }

        // Eğer sona ekleme yapılacaksa
        if (temp.next == null) {
            sonaEkle(data);
            return;
        }

        // Araya ekleme işlemi
        eleman.next = temp.next; // Yeni düğümün next'i, temp'in next'i olacak.
        eleman.prev = temp; // Yeni düğümün prev'i, temp olacak.
        temp.next.prev = eleman; // Temp'in sonraki düğümünün prev'ini yeni düğüm yapıyoruz.
        temp.next = eleman; // Temp'in next'ini yeni düğüm yapıyoruz.

        System.out.println("İndeks " + position + " konumuna eleman eklendi.");
    }

    void bastanSil() {// ^Baştan Sil
        if (head == null) {
            // Liste boş
            System.out.println("Liste zaten boş.");
        } else if (head == tail) {
            // Listede tek bir eleman var
            System.out.println("Listedeki son eleman silindi");
            head = null;
            tail = null;
        } else {
            // Listede birden fazla eleman var
            System.out.println("Listenin başındaki eleman silindi");
            head = head.next; // Head'i bir sonraki düğüme kaydır
            head.prev = null; // Yeni head'in prev referansını null yap
        }
    }

    void sondanSil() {// ^Sondan Sil
        if (head == null) {
            // Liste boş
            System.out.println("Liste zaten boş.");
        } else if (head == tail) {
            // Listede tek bir eleman var
            System.out.println("Listedeki son eleman silindi");
            head = null;
            tail = null;
        } else {
            // Listede birden fazla eleman var
            System.out.println("Listenin sonundaki eleman silindi");
            tail = tail.prev;// Tail'i bir önceki düğüme kaydır
            tail.next = null;// Yeni tail'in next referansını null yap
        }
    }

    void aradanSil(int index) {// ^Aradan Sil
        if (head == null) {
            // Liste boş
            System.out.println("Liste boş, silinecek eleman yok.");
            return;
        }

        if (index == 0) {
            // İlk elemanı silmek istiyoruz
            bastanSil(); // Daha önce yazdığımız baştan silme metodunu çağırıyoruz
            return;
        }

        Node temp = head;
        int currentIndex = 0;

        // İstediğimiz düğüme gitmek için temp'i index'e kadar ilerletiyoruz
        while (temp != null && currentIndex < index) {
            temp = temp.next;
            currentIndex++;
        }

        // Eğer temp null ise, yani index sınırların dışındaysa
        if (temp == null) {
            System.out.println("Geçersiz index, eleman silinemedi.");
            return;
        }

        // Eğer temp son eleman ise, sondan silme işlemi yapıyoruz
        if (temp == tail) {
            sondanSil(); // Daha önce yazdığımız sondan silme metodunu çağırıyoruz
            return;
        }

        // Aradaki elemanı silme işlemi
        System.out.println("Silinen eleman: " + temp.data);
        temp.prev.next = temp.next; // Önceki düğümün next referansını, silinen düğümün sonrasına bağla
        temp.next.prev = temp.prev; // Sonraki düğümün prev referansını, silinen düğümün öncesine bağla

        temp = null; // Silinen düğümü serbest bırak
    }

    void yazdir() {// ^Yazdır
        Node temp = head;
        System.out.print("[");
        while (temp != null) {
            System.out.print(" " + temp.data + " ");
            temp = temp.next;
        }
        System.out.print("]");
        System.out.println();
    }

    void terstenYazdir() {// ^Tersten Yazdır
        Node temp = tail;
        System.out.print("[");
        while (temp != null) {
            System.out.print(" " + temp.data + " ");
            temp = temp.prev;
        }
        System.out.print("]");
        System.out.println();
    }

}

package LinkedList2;

public class Uygulama {
    public static void main(String[] args) {
        Liste liste = new Liste();
        liste.yazdir();
        liste.basaEkle(1);
        liste.yazdir();
        liste.sonaEkle(2);
        liste.yazdir();
        liste.sonaEkle(3);
        liste.yazdir();
        liste.basaEkle(0);
        liste.yazdir();
        liste.arayaEkle(3, 25);
        liste.yazdir();
        liste.arayaEkle(0, -1);
        liste.yazdir();
        liste.arayaEkle(6, 44);
        liste.yazdir();
        liste.bastanSil();
        liste.yazdir();
        liste.sondanSil();
        liste.yazdir();
    }
}

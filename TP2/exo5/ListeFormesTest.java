package exo5;

public class ListeFormesTest {

    public static void main(String[] args) {
        Carre a = new Carre(2);
        Cercle b = new Cercle(1);
        ListeFormes liste = new ListeFormes(a,b);
        System.out.println(liste.aireTotale());
    }

}

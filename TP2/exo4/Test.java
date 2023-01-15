package exo4;

public class Test {
    public static void main(String[] args) {
        Joueur j = new Joueur();
        j.ramasser(new BonusTemps());
        j.ramasser(new BonusScore());
    }
}

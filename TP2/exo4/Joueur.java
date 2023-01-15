package exo4;

/**
 * 
 * Ici, on a un problème de substitution de Liskov
 * Si on passe à Joueur une implémentation de Bonus
 * autre que BonusTemps et BonusScore, le code existant
 * ne fonctionne pas correctement (à moins qu'on corrige Joueur)
 * 
 * On travaille alors par délégation et on confie aux Bonus
 * la responsabilité d'accorder effectivement les bonus
 * 
 */

public class Joueur {
    public void ramasser(Bonus b) {
        b.donnerBonus();
    }
}

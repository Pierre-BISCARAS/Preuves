package exo1;
import java.util.ArrayList;
import java.util.List;
/**
 * Inventaire est une clase haut niveau couplée à une classe concrète
 * on rempt le principe d'inversion des dépendances DIP 
 * Faut Ajouter une Interface entre Inventaire et Ordinateur pour que Inventaire ne dépende plus des détails d'implémentation 
 * 
 * Le Système devient aussi ouvert (à l'extention) et fermé à la modification (en conformité avec Principe du OCP -Open Closed Principle )
 */ 
public class Inventaire {

    private List<Materiel> liste = new ArrayList<>();

    public void ajouter(Ordinateur ordinateur) { this.liste.add(ordinateur);

    }

    public void lister() {

        for (Materiel materiel : this.liste) { 
            System.out.println(" - " + materiel);

        }  
    }

}
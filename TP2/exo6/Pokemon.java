

/**
 * Ici, on a un problème de responsabilité unique
 * Pokemon essaye de tout faire : à la fois de la logique (saluer())
 * et de la persistance
 * Cela s'accompagne d'un problème ouvert / fermé
 * On casse Pokemon en plusieurs morceaux de façon à préserver l'interface de Pokemon
 * tout en séparant les responsabilités
 * 
 */
public class Pokemon {
    Enregistreur enregistreurPokemon;
    Logique logiquePokemon;
    
    public Pokemon(Logique logiquePokemon, Enregistreur enregistreurPokemon) {
        this.logiquePokemon = logiquePokemon;
        this.enregistreurPokemon = enregistreurPokemon;
    }

    public String saluer() {
        return this.logiquePokemon.saluer();
    }

    public void enregistrer() {
        this.enregistreurPokemon.enregistrer();
    }
}

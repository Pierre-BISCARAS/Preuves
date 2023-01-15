
public class LogiqueSuperPokemon implements Logique {

    EtatPokemon etat;

    public LogiqueSuperPokemon(EtatPokemon etat) {
        this.etat = etat;
    }

    @Override
    public String saluer() {
        
        return "Je suis le super Pokemon " + etat.nom;
    }
    
}

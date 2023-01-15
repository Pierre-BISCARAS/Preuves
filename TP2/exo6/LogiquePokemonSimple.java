public class LogiquePokemonSimple implements Logique {

    EtatPokemon etat;

    public LogiquePokemonSimple(EtatPokemon etat) {
        this.etat = etat;
    }

    @Override
    public String saluer() {
        return "Bonjour, je suis " + etat.nom + " !";
    }
}

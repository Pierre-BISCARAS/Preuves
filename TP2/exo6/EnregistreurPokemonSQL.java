public class EnregistreurPokemonSQL implements Enregistreur {
    EtatPokemon etat;

    public EnregistreurPokemonSQL(EtatPokemon etat) {
        this.etat = etat;
    }

    @Override
    public void enregistrer() {
        System.out.println("Persistance de " + etat.nom);
    }
}

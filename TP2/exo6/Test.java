public class Test {
    public static void main(String[] args) {
        EtatPokemon etat = new EtatPokemon("Robert");

        Pokemon p = new Pokemon(
            new LogiqueSuperPokemon(etat),
            new EnregistreurPokemonSQL(etat)
        );

        System.out.println(p.saluer());
        p.enregistrer();
    }
}

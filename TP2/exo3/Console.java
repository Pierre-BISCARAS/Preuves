package exo3;

public class Console implements Jeux,Musique {
 
    @Override
    
    public void jouerMusique() {
    
    System.out.println("De la musique sur ma console");
    
    }

    
    @Override
    public void jouerJeu() {
    
    System.out.println("C'est fun de jouer sur console");
    
    }    
}
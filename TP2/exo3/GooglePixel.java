package exo3;

public class GooglePixel implements Telephone,Jeux,Musique {

    @Override
    
    public void jouerMusique() {
    
        System.out.println("De la musique sur téeléphone Google");
    
    }
    
    @Override
    
    public void telephoner() {
    
        System.out.println("Un téléphone Google pour téléphoner");
    
    }
    
    @Override
    
    public void jouerJeu() {
    
        System.out.println("Google me regarde jouer sur mon Pixel");
    
    }
    
}
package exo1;
public class Ordinateur implements Materiel{

    private String modele;
    
    private String id;
    
    public Ordinateur(String modele) {
    
    this.modele = modele;
    
    this.id = this.genererId();
    
    }
    
    public String genererId() {
        String pass = new String();
        return pass;
    // une recette secrète pour générer un id
    
    }
    
    @Override
    
    public String toString() {
    
    return modele + "(id = " + this.id + ")";
    
    }
    
}
    
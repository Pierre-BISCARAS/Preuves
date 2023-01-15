package exo5;

public class Carre implements Forme {

    private double cote;

    public Carre(double cote) {
        this.cote = cote;
    }

    @Override
    public double aire() {
        return cote * cote;
    }
    
}

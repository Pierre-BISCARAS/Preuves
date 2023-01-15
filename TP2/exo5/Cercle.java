package exo5;

public class Cercle implements Forme {

    private double rayon;

    public Cercle(double rayon) {
        this.rayon = rayon;
    }
    
    @Override
    public double aire() {
        return 3.1415 * this.rayon * this.rayon;
    }
    
}

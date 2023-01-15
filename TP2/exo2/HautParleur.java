package exo2;

public class HautParleur {

    private String son;
    
    public void setSon(String son) {
    
    this.son = son;
    
    }
    
    public String demarrer() {
    
        switch(this.son) {
        
            case "chanson":
            
                return "Tralalala";
            
            case "klaxon":
            
                return "Pouet";
            
            case "sirène":
            
                return "PIN PON!";
            
            default:
            
                return "Bip";
        
    }
    
    }
    
}
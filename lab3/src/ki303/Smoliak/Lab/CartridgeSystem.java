package ki303.Smoliak.Lab;

public class CartridgeSystem {
    private int inkLevel;
    private boolean ecoMode;

    
    public CartridgeSystem() {
        this.inkLevel = 100;
        this.ecoMode = false;
    }

   
    public CartridgeSystem(int inkLevel) {
        this.inkLevel = inkLevel;
        this.ecoMode = false;
    }

    
    public boolean hasEnoughInk() {
        return inkLevel > 0;
    }

    
    public void useInk() {
        inkLevel -= ecoMode ? 1 : 2;
        if (inkLevel < 0) inkLevel = 0;
    }

    
    public void replace() {
        inkLevel = 100;
    }

    
    public int getInkLevel() {
        return inkLevel;
    }

   
    public void enableEcoMode() {
        ecoMode = true;
    }

    
    public void disableEcoMode() {
        ecoMode = false;
    }
}

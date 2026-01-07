package ki303.Smoliak.Lab2;

public class PrintingMechanism {
    private boolean ready;

    
    public PrintingMechanism() {
        this.ready = true;
    }

    
    public boolean isReady() {
        return ready;
    }

   
    public void clean() {
        ready = true;
    }

    
    public void calibrate() {
        ready = true;
    }
}

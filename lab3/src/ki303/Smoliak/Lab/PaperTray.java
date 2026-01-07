package ki303.Smoliak.Lab;

public class PaperTray {
    private int paperCount;
    private final int capacity;

   
    public PaperTray() {
        this.capacity = 100;
        this.paperCount = 0;
    }

    
    public PaperTray(int capacity) {
        this.capacity = capacity;
        this.paperCount = 0;
    }

    
    public boolean hasPaper() {
        return paperCount > 0;
    }

   
    public void usePaper() {
        if (paperCount > 0) paperCount--;
    }

    
    public void addPaper(int sheets) {
        paperCount = Math.min(paperCount + sheets, capacity);
    }

   
    public int getPaperCount() {
        return paperCount;
    }
}

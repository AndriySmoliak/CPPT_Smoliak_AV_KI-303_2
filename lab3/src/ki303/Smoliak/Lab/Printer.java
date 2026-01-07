package ki303.Smoliak.Lab;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public abstract class Printer {
    protected CartridgeSystem cartridgeSystem;
    protected PaperTray paperTray;
    protected PrintingMechanism printingMechanism;
    protected Logger logger;
    protected List<String> printHistory;

    
    public Printer() throws IOException {
        this.cartridgeSystem = new CartridgeSystem();
        this.paperTray = new PaperTray();
        this.printingMechanism = new PrintingMechanism();
        this.printHistory = new ArrayList<>();
        this.logger = new Logger("printer_log.txt");
        logger.log(String.format("Принтер %s створено.", this.toString()));
    }

    
    public Printer(CartridgeSystem cartridgeSystem, PaperTray paperTray, PrintingMechanism printingMechanism) throws IOException {
        this.cartridgeSystem = cartridgeSystem;
        this.paperTray = paperTray;
        this.printingMechanism = printingMechanism;
        this.printHistory = new ArrayList<>();
        this.logger = new Logger("printer_log.txt");
        logger.log(String.format("Принтер %s створено.", this.toString()));
    }

    
    public abstract boolean print(String document) throws IOException;

   
    public void replaceCartridge() throws IOException {
        logger.log("Заміна картриджа");
        System.out.println("Заміна картриджа");

        cartridgeSystem.replace();
    }

    
    public void addPaper(int sheets) throws IOException {
        logger.log(String.format("Додавання %s аркушів паперу", sheets));
        System.out.printf("Додавання %s аркушів паперу\n", sheets);

        paperTray.addPaper(sheets);
    }

    
    public String checkStatus() throws IOException {
        String status = "Стан принтера: \n" +
                "Рівень чорнила: " + cartridgeSystem.getInkLevel() + "%\n" +
                "Кількість паперу: " + paperTray.getPaperCount() + " аркушів\n" +
                "Механізм друку: " + (printingMechanism.isReady() ? "готовий" : "не готовий");

        logger.log(String.format("Перевірка стану принтера: %s", status));
        System.out.printf("Перевірка стану принтера: %s\n", status);

        return status;
    }

   
    public void cleanPrintHead() throws IOException {
        logger.log("Очищення друкуючої головки");
        System.out.println("Очищення друкуючої головки");

        printingMechanism.clean();
    }

   
    public void calibrate() throws IOException {
        logger.log("Калібрування принтера");
        System.out.println("Калібрування принтера");

        printingMechanism.calibrate();
    }

    public void enableEcoMode() throws IOException {
        logger.log("Увімкнення режиму економії чорнила");
        System.out.println("Увімкнення режиму економії чорнила");

        cartridgeSystem.enableEcoMode();
    }

    
    public void disableEcoMode() throws IOException {
        logger.log("Вимкнення режиму економії чорнила");
        System.out.println("Вимкнення режиму економії чорнила");

        cartridgeSystem.disableEcoMode();
    }

    
    public boolean needsCartridgeReplacement() throws IOException {
        boolean needs = cartridgeSystem.getInkLevel() < 10;
        logger.log("Перевірка необхідності заміни картриджа: " + (needs ? "потрібна заміна" : "заміна не потрібна"));
        System.out.println("Перевірка необхідності заміни картриджа: " + (needs ? "потрібна заміна" : "заміна не потрібна"));

        return needs;
    }

    
    public List<String> viewPrintHistory() throws IOException {
        logger.log("Перегляд історії друку");
        System.out.println("Історія друку:");

        for (String entry : printHistory) {
            System.out.println(entry);
        }
        return new ArrayList<>(printHistory);
    }

    
    public void clearPaperTray() throws IOException {
        int removedPaper = paperTray.getPaperCount();
        while (paperTray.getPaperCount() > 0) {
            paperTray.usePaper();
        }
        logger.log(String.format("Очищення лотка для паперу. Видалено %d аркушів.", removedPaper));
        System.out.printf("Лоток для паперу очищено. Видалено %d аркушів.\n", removedPaper);
    }

    
    public void closeLogger() throws IOException {
        logger.close();
    }
}

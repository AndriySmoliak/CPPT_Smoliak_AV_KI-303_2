package ki303.Smoliak.Lab;

import java.io.IOException;


public class MultifunctionalDeviceDriver {
   
    public static void main(String[] args) {
        try {
            MultifunctionalDevice device = new MultifunctionalDevice();
            device.addPaper(10);
            device.print("Документ 1");
            device.scan("Сканований документ 1");
            device.copy("Документ для копіювання");
            device.replaceCartridge();
            device.checkStatus();
            device.cleanPrintHead();
            device.calibrate();
            device.enableEcoMode();
            device.disableEcoMode();
            device.needsCartridgeReplacement();
            device.viewPrintHistory();
            device.clearPaperTray();

            device.closeLogger();
        } catch (IOException e) {
            // Обробка помилок, що виникають під час запису в файл
            throw new RuntimeException("Сталася помилка при записі в файл: " + e.getMessage());
        }
    }
}
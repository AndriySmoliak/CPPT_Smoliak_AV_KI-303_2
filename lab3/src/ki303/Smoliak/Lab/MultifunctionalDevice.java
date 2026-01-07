package ki303.Smoliak.Lab;

import java.io.IOException;


public class MultifunctionalDevice extends Printer implements Scannable {

    
    public MultifunctionalDevice() throws IOException {
        super();
    }

   
    @Override
    public boolean print(String document) throws IOException {
        logger.log("Початок друку документа на багатофункціональному пристрої");
        System.out.println("Початок друку документа на багатофункціональному пристрої");

        if (cartridgeSystem.hasEnoughInk() && paperTray.hasPaper() && printingMechanism.isReady()) {
            cartridgeSystem.useInk();
            paperTray.usePaper();
            printHistory.add(document);

            System.out.println("Друкую: " + document);
            logger.log("Документ успішно надруковано на багатофункціональному пристрої");
            return true;
        }

        logger.log("Друк неможливий: недостатньо ресурсів");
        System.out.println("Друк неможливий: недостатньо ресурсів");
        return false;
    }

   
    @Override
    public void scan(String documentName) throws IOException {
        logger.log("Початок сканування документа: " + documentName);
        System.out.println("Сканування документа: " + documentName);
        // Логіка сканування документа
        logger.log("Документ успішно відскановано");
        System.out.println("Документ успішно відскановано");
    }

    
    public void copy(String documentName) throws IOException {
        logger.log("Початок копіювання документа: " + documentName);
        System.out.println("Копіювання документа: " + documentName);

        scan(documentName);
        print("Копія: " + documentName);

        logger.log("Документ успішно скопійовано");
        System.out.println("Документ успішно скопійовано");
    }
}

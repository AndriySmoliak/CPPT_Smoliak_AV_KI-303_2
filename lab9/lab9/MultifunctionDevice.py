from Printer import Printer


class MultifunctionDevice(Printer):
    """
    Клас MultifunctionDevice розширює функціональність базового класу Printer,
    додаючи можливість сканування, копіювання та технічного обслуговування.
    """

    def __init__(self, model, weight, paper_capacity, maintenance_interval):
        """
        Ініціалізує об'єкт багатофункціонального пристрою.

        :param model: Модель пристрою.
        :param weight: Вага пристрою в кг.
        :param paper_capacity: Максимальна кількість аркушів паперу.
        :param maintenance_interval: Інтервал між технічними обслуговуваннями.
        """
        super().__init__(model, weight, paper_capacity)
        self.maintenance_interval = maintenance_interval
        self.pages_processed = 0
        self.needs_maintenance = False
        self.scanned_documents = []

    def scan_document(self, document_name):
        """
        Сканує документ.

        :param document_name: Назва документа для сканування.
        """
        print(f"Сканування документа '{document_name}'.")
        self.scanned_documents.append(document_name)

    def copy_document(self, document_name, copies):
        """
        Копіює документ.

        :param document_name: Назва документа.
        :param copies: Кількість копій.
        """
        if self.needs_maintenance:
            print("Пристрій потребує технічного обслуговування, копіювання неможливе.")
            return
        print(f"Копіювання документа '{document_name}' ({copies} копій).")
        self.print_document(document_name, copies)
        self.scan_document(document_name)
        self.pages_processed += copies
        if self.pages_processed >= self.maintenance_interval:
            self.needs_maintenance = True

    def perform_maintenance(self):
        """
        Виконує технічне обслуговування пристрою.
        """
        print(f"Виконано технічне обслуговування {self.model}.")
        self.needs_maintenance = False
        self.pages_processed = 0

    def get_status(self):
        """
        Отримує поточний стан багатофункціонального пристрою.

        :return: Строка зі статусом пристрою.
        """
        basic_status = super().get_status()
        maintenance_status = "потребує обслуговування" if self.needs_maintenance else "справний"
        return (f"{basic_status}, стан: {maintenance_status}, "
                f"оброблено сторінок: {self.pages_processed}, "
                f"відскановані документи: {self.scanned_documents}")
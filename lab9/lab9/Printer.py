class Printer:
    """
    Базовий клас Printer представляє пристрій для друку документів.
    """

    def __init__(self, model, weight, paper_capacity):
        """
        Ініціалізує об'єкт принтера.

        :param model: Модель принтера.
        :param weight: Вага принтера в кг.
        :param paper_capacity: Максимальна кількість аркушів паперу.
        """
        self.model = model
        self.weight = weight
        self.paper_capacity = paper_capacity
        self.current_paper = paper_capacity

    def print_document(self, document_name, pages):
        """
        Друкує документ, якщо є достатньо паперу.

        :param document_name: Назва документа.
        :param pages: Кількість сторінок для друку.
        """
        if self.current_paper < pages:
            print(f"Недостатньо паперу для друку {pages} сторінок документа '{document_name}'.")
            return
        print(f"Друк документа '{document_name}' ({pages} сторінок).")
        self.current_paper -= pages

    def add_paper(self, amount):
        """
        Додає папір до принтера.

        :param amount: Кількість доданих аркушів.
        """
        self.current_paper = min(self.current_paper + amount, self.paper_capacity)
        print(f"Додано {amount} аркушів паперу. Зараз у принтері {self.current_paper} аркушів.")

    def get_status(self):
        """
        Отримує поточний стан принтера.

        :return: Строка зі статусом принтера.
        """
        return f"Модель: {self.model}, вага: {self.weight} кг, папір: {self.current_paper}/{self.paper_capacity} аркушів"
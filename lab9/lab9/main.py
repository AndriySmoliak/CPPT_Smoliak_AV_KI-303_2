from MultifunctionDevice import MultifunctionDevice

if __name__ == "__main__":
    # Створюємо багатофункціональний пристрій
    mfd = MultifunctionDevice("HP MFP 3000", 20, 200, 1000)

    # Виводимо початковий стан
    print("\n1. Початковий стан пристрою:")
    print(mfd.get_status())

    # Друк документів
    print("\n2. Друк документів:")
    mfd.print_document("Документ 1", 10)
    mfd.print_document("Документ 2", 5)
    print(mfd.get_status())

    # Сканування документів
    print("\n3. Сканування документів:")
    mfd.scan_document("Документ 3")
    print(mfd.get_status())

    # Копіювання документів
    print("\n4. Копіювання документів:")
    mfd.copy_document("Документ 4", 15)
    print(mfd.get_status())

    # Спроба друку без паперу
    print("\n5. Спроба друку без паперу:")
    mfd.print_document("Документ 5", 190)

    # Додавання паперу
    print("\n6. Додавання паперу:")
    mfd.add_paper(100)
    print(mfd.get_status())

    # Виконання технічного обслуговування
    print("\n7. Технічне обслуговування:")
    mfd.perform_maintenance()
    print(mfd.get_status())

    # Робота після обслуговування
    print("\n8. Друк і сканування після обслуговування:")
    mfd.print_document("Документ 6", 50)
    mfd.scan_document("Документ 7")
    print(mfd.get_status())

    # Фінальний стан
    print("\n9. Фінальний стан пристрою:")
    print(mfd.get_status())
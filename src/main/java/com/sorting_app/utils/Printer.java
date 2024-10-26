package com.sorting_app.utils;
public final class Printer {
    private Printer() {
        // Подавляет появление конструктора по умолчанию, а заодно
        // и создание экземпляров класса
        throw new AssertionError();
    }
    public static void printHelp() {
        System.out.println();
        System.out.println("Возможные команды: ");
        System.out.println("1 - Заполнение коллекции;");
        System.out.println("2 - Сортировка коллекции;");
        System.out.println("3 - Поиск элемента;");
        System.out.println("4 - Записать коллекции в файл;");
        // System.out.println("5 - Записать найденные элементы в файл;");
        //
//        System.out.println("help - Вывод help;");
        System.out.println("5 - Вывод коллекции в консоль;");
        System.out.println("6 - Выход из программы.");
        System.out.println();
    }
}
package com.sorting_app.strategy;

import com.sorting_app.data.DataObject;
import com.sorting_app.handler.ValidationException;
import com.sorting_app.input.SortByEven;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SortByEvenStrategy implements IStrategy {
    private final DataObject dataObject;

    public SortByEvenStrategy(DataObject dataObject) {
        this.dataObject = dataObject;
    }


    @Override
    public void generationResult() {
        SortByEven sort = new SortByEven(dataObject);
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nВведите цифру от 1 до 4 для cортировки объектов по четным значениям\n" +
                    "1 - АВТОМОБИЛЬ;  " +
                    "2 - КНИГИ;  " +
                    "3 - КОРНЕПЛОД  " +
                    "4 - СОРТИРОВКА ВСЕХ ОБЪЕКТОВ");
            int choose = scanner.nextInt();
            switch (choose) {
                case 1: {
                    sort.carSortByEven();
                    break;
                }
                case 2: {
                    sort.bookSortByEven();
                    break;
                }
                case 3: {
                    sort.rootVegetableSortByEven();
                    break;
                }
                case 4: {
                    sort.carSortByEven();
                    sort.bookSortByEven();
                    sort.rootVegetableSortByEven();
                    break;
                }
                default:
                    System.out.println("Неверный ввод, введите цифру от 1 до 4");
            }
        } catch (ValidationException validationException) {
            System.out.println(validationException.getMessage());
        }
    }
}

package com.sorting_app.strategy;

import com.sorting_app.data.DataObject;
import com.sorting_app.handler.ValidationException;
import com.sorting_app.input.RandomInput;

import java.util.InputMismatchException;
import java.util.Scanner;


public class InputRandomStrategy implements IStrategy{
    DataObject dataObject;

    public InputRandomStrategy(DataObject dataObject) {
        this.dataObject = dataObject;
    }

    private void selectRandomObject() throws ValidationException {
        RandomInput randomInput = new RandomInput(dataObject);
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Выберите цифру от 1 до 4 для рандомного заполнения\n" +
                    "1 - АВТОМОБИЛЬ;  " +
                    "2 - КНИГИ;  " +
                    "3 - КОРНЕПЛОД" +
                    "4 - ЗАПИСЬ ВО ВСЕ ОБЪЕКТЫ");
            int choose = scanner.nextInt();
            System.out.println("Введите количество создаваемых объектов");
            int count = scanner.nextInt();
            switch (choose) {
                case 1: {
                    randomInput.loadCarCSV();
                    randomInput.generateCarList(count);
                    break;
                }
                case 2: {
                    randomInput.loadBooksCSV();
                    randomInput.generateBookList(count);
                    break;
                }
                case 3: {
                    randomInput.loadRootVegetableCSV();
                    randomInput.generateRootVegetables(count);
                    break;
                }
                case 4: {
                    randomInput.loadCarCSV();
                    randomInput.generateCarList(count);
                    randomInput.loadBooksCSV();
                    randomInput.generateBookList(count);
                    randomInput.loadRootVegetableCSV();
                    randomInput.generateRootVegetables(count);
                    break;
                }
                default:
                    System.out.println("Неверный ввод, введите цифру от 1 до 4");
            }
        } catch (InputMismatchException e) {
            throw new ValidationException("Неверный ввод, введите цифры от 1 до 4");
        } catch (Exception e) {
            throw new ValidationException("Проверьте файл на соответствие");
        }
    }


    @Override
    public void getResult() {
        try {
           selectRandomObject();
        }catch (ValidationException validationException){
            System.out.println(validationException.getMessage());
        }
        System.out.println("<<<Выборочное добавление данных в коллекцию выполнено>>>");
    }
}

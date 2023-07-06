package com.example.lab6_var4;

import javafx.scene.control.Alert;

public class Alerts {

    public static void BlankFields(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText("Заполните все поля");
        alert.setTitle("Ошибка");
        alert.showAndWait();
    }


    public static void WrongMark(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText("Неверно заполнено поле 'Марка'. Повторите попытку ввода");
        alert.setTitle("Ошибка");
        alert.showAndWait();
    }
    public static void WrongModel(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText("Неверно заполнено поле 'Модель'. Повторите попытку ввода");
        alert.setTitle("Ошибка");
        alert.showAndWait();
    }
    public static void WrongYear(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText("Неверно заполнено поле 'Год выпуска'. Повторите попытку ввода");
        alert.setTitle("Ошибка");
        alert.showAndWait();
    }
    public static void WrongColor(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText("Неверно заполнено поле 'Цвет'. Повторите попытку ввода");
        alert.setTitle("Ошибка");
        alert.showAndWait();
    }
    public static void WrongVIN(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText("Неверно заполнено поле 'VIN-номер'. Повторите попытку ввода");
        alert.setTitle("Ошибка");
        alert.showAndWait();
    }

    public static void MarkNotFound(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText("Автомобиля данной марки в таблице не найдено. Повторите попытку поиска");
        alert.setTitle("Ошибка");
        alert.showAndWait();
    }
}

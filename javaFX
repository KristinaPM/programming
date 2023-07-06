package com.example.laba5;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.RandomAccessFile;



public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {


        Text vk_txt = new Text("ВКонтакте");
        vk_txt.setFont(Font.font("Times New Roman", FontWeight.BOLD, 30));
        Text reg_txt = new Text("Регистрация");
        reg_txt.setFont(Font.font(21));
        VBox lay1 = new VBox(4, vk_txt, reg_txt);
        lay1.setAlignment(Pos.CENTER);


        Text user_txt = new Text("Имя пользователя:");
        user_txt.setFont(Font.font(14));
        TextField user_fld = new TextField();
        user_fld.setPrefWidth(190);
        HBox lay2 = new HBox(50, user_txt, user_fld);
        lay2.setAlignment(Pos.CENTER_LEFT);
        lay2.setPadding(new Insets(0,0,0,30));


        Text phone_txt = new Text("Номер телефона:");
        phone_txt.setFont(Font.font(14));
        TextField phone_fld = new TextField();
        phone_fld.setPrefWidth(190);
        HBox lay3 = new HBox(60, phone_txt, phone_fld);
        lay3.setAlignment(Pos.CENTER_LEFT);
        lay3.setPadding(new Insets(0,0,0,30));


        Text password_txt = new Text("Пароль:");
        password_txt.setFont(Font.font(14));
        PasswordField passwordField = new PasswordField();
        passwordField.setPrefWidth(160);
        CheckBox checkBox = new CheckBox();
        checkBox.setTooltip(new Tooltip("Нажмите если хотите сохранить пароль в браузере"));
        checkBox.setFont(Font.font(18));
        HBox pass = new HBox(5, passwordField, checkBox);
        pass.setAlignment(Pos.CENTER_LEFT);
        HBox lay4 = new HBox(120, password_txt, pass);
        lay4.setAlignment(Pos.CENTER_LEFT);
        lay4.setPadding(new Insets(0,0,0,30));
 

        Text birthday_txt = new Text("Дата рождения:");
        birthday_txt.setFont(Font.font(14));
        DatePicker datePicker = new DatePicker();
        datePicker.setPrefWidth(190);
        HBox lay5 = new HBox(70, birthday_txt, datePicker);
        lay5.setAlignment(Pos.CENTER_LEFT);
        lay5.setPadding(new Insets(0,0,0,30));


        Text gender_txt = new Text("Ваш пол:");
        gender_txt.setFont(Font.font(14));
        ToggleGroup toggleGroup = new ToggleGroup();
        RadioButton male = new RadioButton("мужской");
        male.setFont(Font.font(14));
        male.setToggleGroup(toggleGroup);
        RadioButton female = new RadioButton("женский");
        female.setFont(Font.font(14));
        female.setToggleGroup(toggleGroup);
        HBox buttons = new HBox(30, male, female);
        HBox lay6 = new HBox(110, gender_txt, buttons);
        lay6.setAlignment(Pos.CENTER_LEFT);
        lay6.setPadding(new Insets(0,0,0,30));


        Button clear_btn = new Button("ОЧИСТИТЬ");
        clear_btn.setFont(Font.font(15));
        Button reg_btn = new Button("ЗАРЕГИСТРИРОВАТЬ");
        reg_btn.setFont(Font.font(15));
        HBox lay7 = new HBox(30, clear_btn, reg_btn);
        lay7.setAlignment(Pos.CENTER);



        VBox root = new VBox(42, lay1, lay2, lay3, lay4, lay5, lay6, lay7);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 430, 525);
        stage.setTitle("РЕГИСТРАЦИЯ ПОЛЬЗОВАТЕЛЯ");
        stage.setScene(scene);
        stage.show();



        clear_btn.setOnAction(e->{
            user_fld.clear();
            phone_fld.clear();
            passwordField.clear();
            checkBox.setSelected(false);
            datePicker.setValue(null);
            male.setSelected(false);
            female.setSelected(false);
        });

        reg_btn.setOnAction(e->{

            String save_pass = "";
            if(checkBox.isSelected() == true) save_pass = " - пароль сохранён";
            else save_pass = " - пароль не сохранён";

            String gender = "";
            if(male.isSelected() == true) gender = "мужской";
            else gender = "женский";

            // для удобства записываем все данные для вывода в одну переменную для записи в файл
            String user_info = "\n\nИмя пользователя: " +user_fld.getText() +"\nНомер телефона: " +phone_fld.getText()
                    +"\nПароль: " +passwordField.getText() +save_pass +"\nДата рождения: " +datePicker.getValue()
                    +"\nПол: " +gender;

            Alert alert = new Alert(Alert.AlertType.WARNING);


            if(!(user_fld.getText()!="" && phone_fld.getText()!="" && passwordField.getText()!="" && datePicker.getValue()!=null
                    && (male.isSelected()==true || female.isSelected()==true))){
                alert.setContentText("Вы заполнили не все поля");
                alert.showAndWait();
            }
            else if(!(phone_fld.getText().matches("[0-9 +]+")&& phone_fld.getText().matches("^[+]\\d{12}$"))){
                alert.setContentText("Вы некорректно ввели номер телефона");
                alert.showAndWait();
                phone_fld.clear();
            }
            else if(!passwordField.getText().matches("\\w{8,32}")){
                alert.setContentText("Пароль должен содержать от 8 до 16 символов");
                alert.showAndWait();
                passwordField.clear();
            }
            else{
                try{

                    RandomAccessFile file = new RandomAccessFile("USERS_BASE.txt", "rw");
                    file.seek(file.length());
                    file.writeUTF(user_info);
                    file.close();


                    user_fld.clear();
                    phone_fld.clear();
                    passwordField.clear();
                    checkBox.setSelected(false);
                    datePicker.setValue(null);
                    male.setSelected(false);
                    female.setSelected(false);

                } catch (IOException ex){
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public static void main(String[] args) {
        launch();
    }
}

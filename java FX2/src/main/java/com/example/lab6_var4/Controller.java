package com.example.lab6_var4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller {

    @FXML
    TextField mark_fld, model_fld, year_fld, color_fld, vin_fld, search_fld;
    @FXML
    Button add_btn, delete_btn, display_btn, cleanFields_btn, edit_btn, search_btn, cleanSearcher_btn;
    @FXML
    TableView<Car> table;
    @FXML
    TableColumn colMark, colModel, colYear, colColor, colVIN;

    ObservableList<Car> list = FXCollections.observableArrayList();


    @FXML
    public void initialize(){

        colMark.setCellValueFactory(new PropertyValueFactory<>("mark"));
        colModel.setCellValueFactory(new PropertyValueFactory<>("model"));
        colYear.setCellValueFactory(new PropertyValueFactory<>("year"));
        colColor.setCellValueFactory(new PropertyValueFactory<>("color"));
        colVIN.setCellValueFactory (new PropertyValueFactory<>("vin"));


        list.add(new Car("BMW", "X5", 2019, "белый", "ZFA22300005556777"));
        list.add(new Car("Audi", "A4", 2014, "синий", "ZFA18800004473122"));
        list.add(new Car("Lada", "Vesta", 2009, "коричневый", "KMHBT31GP3U013758"));
        list.add(new Car("BMW", "X1", 2018, "светло-серый", "KL1UF756E6B195928"));
        list.add(new Car("Skoda", "Rapid", 2005, "чёрный", "SALFA28B57H011265"));


        display_btn.setOnAction(e->{

            Car car = table.getSelectionModel().getSelectedItem();
            mark_fld.setText(car.getMark());
            model_fld.setText(car.getModel());
            year_fld.setText(car.getYear().toString());
            color_fld.setText(car.getColor());
            vin_fld.setText(car.getVin());
        });

        delete_btn.setOnAction(e->{

            Car car = table.getSelectionModel().getSelectedItem();
            list.remove(car);
        });

        cleanFields_btn.setOnAction(e->{

            mark_fld.clear();
            model_fld.clear();
            year_fld.clear();
            color_fld.clear();
            vin_fld.clear();
        });

        cleanSearcher_btn.setOnAction(e->{

            search_fld.clear();
            table.setItems(list);
        });

        search_btn.setOnAction(e->{

            ObservableList<Car> list1 = FXCollections.observableArrayList();
            if(Car.FindMark(search_fld.getText(), list)!=null){

                list1 = Car.FindMark(search_fld.getText(), list);
                table.setItems(list1);
            }
            else {
                Alerts.MarkNotFound();
                search_fld.clear();
            }
        });

        add_btn.setOnAction(e->{

            if(!(mark_fld.getText()!="" && model_fld.getText()!="" && year_fld.getText()!="" && color_fld.getText()!="" && vin_fld.getText()!="")){

                Alerts.BlankFields();
            }
            else if(!mark_fld.getText().matches("[a-zA-Z \s -]+")){

                Alerts.WrongMark();
                mark_fld.clear();
            }
            else if(!model_fld.getText().matches("[a-zA-Z \s 0-9 -]+")){

                Alerts.WrongModel();
                model_fld.clear();
            }
            else if(!year_fld.getText().matches("\\d{4}")){

                Alerts.WrongYear();
                year_fld.clear();
            }
            else if(!color_fld.getText().matches("[а-яА-Яa-zA-Z ё \s -]+")){

                Alerts.WrongColor();
                color_fld.clear();
            }
            else if(!vin_fld.getText().matches("\\b[(A-H|J-N|P|R-Z|0-9)]{17}\\b")){

                Alerts.WrongVIN();
                vin_fld.clear();
            }
            else {

                Car car = new Car(mark_fld.getText(), model_fld.getText(), Integer.parseInt(year_fld.getText()), color_fld.getText(), vin_fld.getText());
                list.add(car);
/*
                cleanFields_btn.fire();
*/
                table.getSortOrder().addAll(colYear);
            }

        });

        edit_btn.setOnAction(e->{

            if(!(mark_fld.getText()!="" && model_fld.getText()!="" && year_fld.getText()!="" && color_fld.getText()!="" && vin_fld.getText()!="")){

                Alerts.BlankFields();
            }
            else if(!mark_fld.getText().matches("[a-zA-Z \s -]+")){

                Alerts.WrongMark();
                mark_fld.clear();
            }
            else if(!model_fld.getText().matches("[a-zA-Z \s 0-9 -]+")){

                Alerts.WrongModel();
                model_fld.clear();
            }
            else if(!year_fld.getText().matches("\\d{4}")){

                Alerts.WrongYear();
                year_fld.clear();
            }
            else if(!color_fld.getText().matches("[а-яА-Яa-zA-Z ё \s -]+")){

                Alerts.WrongColor();
                color_fld.clear();
            }
            else if(!vin_fld.getText().matches("\\b[(A-H|J-N|P|R-Z|0-9)]{17}\\b")){

                Alerts.WrongVIN();
                vin_fld.clear();
            }
            else {

                Car newCar = new Car(mark_fld.getText(), model_fld.getText(), Integer.parseInt(year_fld.getText()), color_fld.getText(), vin_fld.getText());
                Car car = table.getSelectionModel().getSelectedItem();
                list.add(newCar);
                list.remove(car);
                cleanFields_btn.fire();
                table.getSortOrder().addAll(colYear);
            }
        });



        table.setItems(list);
        table.getSortOrder().addAll(colYear);
    }
}
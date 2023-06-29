package org.example;

import org.example.model.City;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner console = new Scanner(new File("Задача ВС Java Сбер.csv"));
        console.useDelimiter(";");
        List<City> cityList = new ArrayList<>();
        while (console.hasNextLine()) {
            cityList.add(new City(console.nextLine()));
        }
        console.close();

        cityList.forEach(System.out::println);
    }
}
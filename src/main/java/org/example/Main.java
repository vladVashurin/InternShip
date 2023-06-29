package org.example;

import org.example.model.City;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
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
        findBiggestPopulation(cityList);

    }

    private static void findBiggestPopulation(List<City>cities){
        Integer[]array = new Integer[cities.size()];
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for(int i = 0; i < cities.size(); i++){
            array[i]=cities.get(i).getPopulation();
            if(array[i]>max){
                max = array[i];
                maxIndex = i;
            }
        }
        System.out.println("[" + maxIndex + "] = " + max);
    }
    private static List<City> sortNameASC(List<City> cityList) {
        cityList.sort(new Comparator<City>() {
            @Override
            public int compare(City o1, City o2) {
                return o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase());
            }
        });
        return cityList;
    }

    private static List<City> sortRegionNameASC(List<City> cityList) {
        cityList.sort(new Comparator<City>() {
            @Override
            public int compare(City o1, City o2) {
                return o1.getRegion().compareTo(o2.getRegion());
            }
        });
        List<City> cities = new ArrayList<>();
        List<City> temp = new ArrayList<>();
        String lastRegion = "";
        for (City c : cityList) {
            if (c.getRegion().equals(lastRegion)) {
                temp.add(c);
            } else {
                temp = sortNameASC(temp);
                cities.addAll(temp);
                temp = new ArrayList<>();
                temp.add(c);
            }
        }
        return cities;
    }
}
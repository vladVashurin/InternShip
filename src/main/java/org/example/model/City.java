package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class City {
    private String name;
    private String region;
    private String distinct;
    private Integer population;
    private String foundation;

    public City(String line) {
        String[] arr = line.split(";");
        name = arr[1];
        region = arr[2];
        distinct = arr[3];
        population = Integer.parseInt(arr[4]);
        if (arr.length > 5) foundation = arr[5];
    }

}

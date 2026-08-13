package bms.demo.lld.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class City extends BaseModel {
    private String id;
    private String name;
    private Map<String, Theater> theaterMap;

    public City(String id, String name) {
        this.id = id;
        this.name = name;
        theaterMap = new HashMap<>();
    }

    public void addTheater(Theater theater) {
        getTheaterMap().put(theater.getId(), theater);
    }
}

package bms.demo.lld.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Theater extends BaseModel {
    private String id;
    private String name;
    private String address;
    private Map<String, Auditorium> auditoriumMap;

    public Theater(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
        auditoriumMap = new HashMap<>();
    }

    public void addAuditorium(Auditorium auditorium) {
        auditoriumMap.put(auditorium.getId(), auditorium);
    }
}

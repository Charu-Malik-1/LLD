package lld.criteria.design.pattern.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Brand {
    private String name;

    public Brand(String name){
        this.name=name;
    }
}

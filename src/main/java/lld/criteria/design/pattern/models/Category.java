package lld.criteria.design.pattern.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Category {
    private String name;
    public Category(String name){
        this.name=name;
    }
}

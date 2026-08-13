package bms.demo.lld.models;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Movie extends BaseModel {
    private String id;
    private String name;
    private String poster;

    public Movie(String movieId, String name) {
        this.id = movieId;
        this.name = name;
    }

    public void print(){
        System.out.println(" id:"+id+" ,name:"+name);
    }
}

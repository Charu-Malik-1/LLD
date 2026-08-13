package bms.demo.lld.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class User1 extends BaseModel{
    private long userId;
    private String name;
    private String email;
    private List<Ticket> tickets;
    public User1(int id,String name){
        userId=id;
        this.name=name;
    }
}

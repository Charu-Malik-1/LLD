package low_level_design1.vending_machine;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class Product {
    private String name;
    private int id;
    private double price;
}

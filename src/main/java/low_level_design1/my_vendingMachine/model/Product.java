package low_level_design1.my_vendingMachine.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Product {
    private final int id;
    private final String name;
    private final int price;
}

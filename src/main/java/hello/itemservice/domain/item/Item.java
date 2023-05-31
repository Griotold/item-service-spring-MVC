package hello.itemservice.domain.item;

import lombok.Data;


@Data
public class Item {

    private Long id;
    private String itemName;

    private Integer price;

    private Integer quantity;

    // 기본 생성자와 아이디를 뺀 생성자
    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}

package store;

import java.math.BigDecimal;
import java.util.UUID;

public class ProductItem {
    private UUID id;
    private String title;
    private BigDecimal price;

    public ProductItem(String title, BigDecimal price) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.price = price;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public BigDecimal getPrice() {
        return price;
    }
}

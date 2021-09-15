package store;

import java.math.BigDecimal;
import java.util.UUID;


public class ProductItem {
    private UUID id;
    private String title;
    private String description;
    private BigDecimal price;
    private int size;

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getSize() {
        return size;
    }
}

package store;

//import org.springframework.stereotype.Repository; // todo later
//import jdk.nashorn.internal.objects.annotations.Getter;

import java.util.ArrayList;
import java.util.List;


//@Repository
//@AllArgsConstructor
public class ProductItemRepository {

    //    @Getter
    private List<ProductItem> listOfProductItems;

    public ProductItemRepository() {
        this(new ArrayList<>());
    } //todo походу это не работает без спринг бут


    public ProductItemRepository(ArrayList<ProductItem> productItems) {
    }

    public void addProductItemInRepo(ProductItem productItem) {
        listOfProductItems.add(productItem);
    }


}

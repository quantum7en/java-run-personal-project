package store;

import java.util.List;

public class InstaAccount implements InstaAccountStore{
    // private List<ProductItem> listOfProductItems;

    private String instaAccountName;


    public InstaAccount(String instaAccountName){
        this.instaAccountName = instaAccountName;
    }


    @Override
    public void addToCart(ProductItem productItem){

    }
}

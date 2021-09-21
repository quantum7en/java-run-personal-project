package store;

public class InstaAccount implements InstaAccountStore{
    // private List<ProductItem> listOfProductItems;

    private String instaAccountName;
    private ProductItemRepository productItemRepository;

    public InstaAccount(String instaAccountName){
        this.instaAccountName = instaAccountName;
    }


    @Override
    public void addToCart(ProductItem productItem){
        productItemRepository.addProductItemInRepo(productItem);
    }
}

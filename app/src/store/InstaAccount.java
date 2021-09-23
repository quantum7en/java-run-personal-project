package store;

public class InstaAccount implements InstaAccountStore {
    // private List<ProductItem> listOfProductItems;

    private String instaAccountName;
    private ProductItemRepository productItemRepository;

    public InstaAccount(String instaAccountName) {
        this.instaAccountName = instaAccountName;
    }

    public String getInstaAccountName() {
        return instaAccountName;
    }

    @Override
    public void addToCart(ProductItem productItem) {
        productItemRepository.addProductItemInRepo(productItem);
    }
}

package src.store;

public class InstaAccount implements InstaAccountStore {

    private final String instaAccountName;

    public InstaAccount(String instaAccountName) {
        this.instaAccountName = instaAccountName;
    }

    public String getInstaAccountName() {
        return instaAccountName;
    }

    @Override
    public void addToCart(ProductItem productItem) {
    }
}

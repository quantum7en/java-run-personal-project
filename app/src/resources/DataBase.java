package resources;

import store.InstaAccount;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//todo jdbc
public class DataBase {
    private final List<InstaAccount> instaAccountArrayList = new ArrayList<>();

    private final InstaAccount [] shops = new InstaAccount[]{new InstaAccount("StyleNanda shop"),
            new InstaAccount("Zara"),
            new InstaAccount("Forever 21"),
            new InstaAccount("Pazzolini"),
            new InstaAccount("awesome_shoes"),
            new InstaAccount("Lacoste")};

    private void fillInstaAccountArrayList() {
        instaAccountArrayList.addAll(Arrays.asList(shops));
    }

    public DataBase(){
        fillInstaAccountArrayList();
    }
}

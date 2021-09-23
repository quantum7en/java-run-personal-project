package resources;

import store.InstaAccount;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class DataBase {
    private static final Logger logger = Logger.getLogger("DataBase");
    private static DataBase dataBaseInstance;
    private final List<InstaAccount> instaAccountArrayList = new ArrayList<>();

    private final InstaAccount[] shops = new InstaAccount[]{new InstaAccount("StyleNanda shop"),
            new InstaAccount("Zara"),
            new InstaAccount("Forever_21"),
            new InstaAccount("Pazzolini"),
            new InstaAccount("awesome_shoes"),
            new InstaAccount("Lacoste")};

    public DataBase() {
        logger.info("filling Database...");
        fillInstaAccountArrayList();
    }

    public static DataBase getDataBaseInstance() {
        if (dataBaseInstance == null) {
            dataBaseInstance = new DataBase() {
            };
        }
        return dataBaseInstance;
    }

    private void fillInstaAccountArrayList() {
        instaAccountArrayList.addAll(Arrays.asList(shops));
    }

    public String searchByInstaAccountName(String instaAccountName) {

        for (InstaAccount account : instaAccountArrayList) {
            if (account.getInstaAccountName().equals(instaAccountName))
                return account.getInstaAccountName();
        }
        return null;
    }
}

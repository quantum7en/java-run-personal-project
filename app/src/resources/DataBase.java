package resources;

import store.InstaAccount;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class DataBase {
    private static final Logger logger = Logger.getLogger(DataBase.class.getName());
    private static final DataBase dataBaseInstance = new DataBase();
    private final List<InstaAccount> instaAccountArrayList = new ArrayList<>();

    private DataBase() {
        logger.info("filling Database...");
        instaAccountArrayList.addAll(Arrays.asList(
                new InstaAccount("StyleNanda shop"),
                new InstaAccount("Zara"),
                new InstaAccount("Forever_21"),
                new InstaAccount("Pazzolini"),
                new InstaAccount("awesome_shoes"),
                new InstaAccount("Lacoste"))
        );
    }

    public static DataBase getDataBaseInstance() {
        return dataBaseInstance;
    }

    public static void start() {
    }

    public String searchByInstaAccountName(String instaAccountName) {

        for (InstaAccount account : instaAccountArrayList) {
            if (account.getInstaAccountName().equals(instaAccountName)) {
                return account.getInstaAccountName();
            }
        }
        return null;
    }
}

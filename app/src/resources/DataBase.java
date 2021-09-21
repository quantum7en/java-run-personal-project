package resources;

import logic.BusinessLogic;
import store.InstaAccount;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataBase {
    private static DataBase dataBaseInstance;
    private static final Logger logger = Logger.getLogger(BusinessLogic.class.getCanonicalName());
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
        logger.log(Level.INFO, "filling Database...");
        fillInstaAccountArrayList();
    }

    public static DataBase getDataBaseInstance(){
        if(dataBaseInstance == null){
            dataBaseInstance = new DataBase() {};
        }
        return dataBaseInstance;
    }

    public InstaAccount searchByInstaAccountName(){
        InstaAccount instaAccount = null;
        return instaAccount;
    }
}

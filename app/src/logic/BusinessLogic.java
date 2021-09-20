package logic;

import java.util.logging.Level;
import java.util.logging.Logger;

// todo maybe make this class Interface
public class BusinessLogic {
    private static final Logger logger = Logger.getLogger(BusinessLogic.class.getCanonicalName());
    private static BusinessLogic BusinessLogicInstance;
    private BusinessLogic(){}

    public static BusinessLogic getBusinessLogicInstance(){
        if(BusinessLogicInstance == null){
            BusinessLogicInstance = new BusinessLogic() {
            };
        }
        return BusinessLogicInstance;
    }

    public void startBusinessLogic(){
        // todo где лучше создавать юзера? , впилить сюда try catch


        logger.log(Level.INFO, "Business logic started");
    }
}

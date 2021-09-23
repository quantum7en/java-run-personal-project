package logic;

import java.util.logging.Logger;

// todo maybe make this class Interface
public class BusinessLogic {
    private static final Logger logger = Logger.getLogger("BusinessLogic");
    private static BusinessLogic BusinessLogicInstance;

    private BusinessLogic() {
    }

    public static BusinessLogic getBusinessLogicInstance() {
        if (BusinessLogicInstance == null) {
            BusinessLogicInstance = new BusinessLogic() {
            };
            logger.info("One and only logic created");
        }
        return BusinessLogicInstance;
    }

    public void startBusinessLogic() {

//        try ( Socket socket = new Socket("127.0.0.1", 8000);
//             BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
//             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))){
//            logger.info( "Connected to server");
//            String request = "awesome_shoes";
//            writer.write(request);
//            writer.newLine();
//            writer.flush();
//        } catch (IOException ex){
//            ex.printStackTrace();
//        }


        logger.info("Business logic started");
    }
}

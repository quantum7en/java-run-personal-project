package logic;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
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
            logger.log(Level.INFO, "One and only logic created");
        }
        return BusinessLogicInstance;
    }

    public void startBusinessLogic(){

        //todo нужно запускать в отдельном мейне, если много юзеров и создавать каждого?

//        try ( Socket socket = new Socket("127.0.0.1", 8000);
//             BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
//             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))){
//            logger.log(Level.INFO, "Connected to server");
//            String request = "awesome_shoes";
//            writer.write(request);
//            writer.newLine();
//            writer.flush();
//        } catch (IOException ex){
//            ex.printStackTrace();
//        }


        logger.log(Level.INFO, "Business logic started");
    }
}

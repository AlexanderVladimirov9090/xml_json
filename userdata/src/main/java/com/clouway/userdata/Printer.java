package com.clouway.userdata;

import com.clouway.obectserealization.JSONCodec;
import com.clouway.obectserealization.XMLCodec;

import javax.xml.bind.JAXBException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by clouway on 26.07.16.
 *
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 */
class Printer {
    private Validator validator = new Validator();

    /**
     * Print average stats from Json and Xml files from Users class.
     *
     * @param args given arguments from user type of file, path and command to be execute.
     * @return number of users and average.
     */
    String printStats(String[] args) {

        if (!validator.correctNumbersOf(args) || !validator.checkType(args)) {
            throw new BadInputArgumentsException();
        }

        return getContent(args);
    }

    /**
     * Gets content from imported objects
     *
     * @param args given arguments from the user.
     * @return number of users and average.
     */
    private String getContent(String[] args) {
        if (args[1].equals("json")) {
            return getJsonString(args);
        } else if (args[1].equals("xml")) {
            return getXmlString(args);
        }
        return "Wrong format.";
    }

    /**
     * Reads Json file and return average age and number of users.
     *
     * @param args
     * @return number of users and average.
     */
    private String getXmlString(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(args[2]));
            String line;
            String message = "";
            while ((line = bufferedReader.readLine()) != null) {
                message += line;

            }
            if (validator.checkCommand(args)) {
                XMLCodec xmlCodec = new XMLCodec();
                UserRepository userRepository1 = new UserRepository();
                UserRepository userRepository = xmlCodec.fromMessage(message, userRepository1.getClass());
                return "Users Count: " + userRepository.numberOfUsers() + "\nAverage Age: " + userRepository.averageAge();
            }
        } catch (IOException e) {
            throw new WrongSyntaxException();
        }
        return "Did you meant to type --printAverageStats";
    }

    /**
     * Reads Json file and return average age and number of users.
     *
     * @param args given arguments from user type of file, path and command to be execute.
     * @return number of users and average.
     */
    private String getJsonString(String[] args) {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(args[2]));
            if (validator.checkCommand(args)) {
                JSONCodec jsonCodec = new JSONCodec();
                UserRepository userRepository1 = new UserRepository();
                UserRepository userRepository = jsonCodec.fromMessage(bufferedReader.readLine(), userRepository1.getClass());
                return "Users Count: " + userRepository.numberOfUsers() + "\nAverage Age: " + userRepository.averageAge();
            }
        } catch (IOException e) {
            throw new WrongSyntaxException();
        }
        return "Error";
    }
}
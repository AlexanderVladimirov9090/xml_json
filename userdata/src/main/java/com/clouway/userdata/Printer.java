package com.clouway.userdata;

import com.clouway.obectserealization.JSONCodec;

import java.util.LinkedList;

/**
 * Created by clouway on 26.07.16.
 *
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 */
public class Printer {

  /**
   * Print average stats from Json and Xml files from Users class.
   * @param args given arguments from user type of file, path and command to be execute.
   * @return
   */
  public String printStats(String[] args) {
   CheckPoint checkPoint = new CheckPoint();
    if (!checkPoint.correctNumbersOf(args)||!checkPoint.checkPath(args)||!checkPoint.checkCommand(args)){
      throw new BadInputArgumentsException();
    }
    if (args[1].equals("json")) {
      String userRepository = getJsonString(args);
      if (userRepository != null) return userRepository;
    }
    return null;
  }

  /**
   * Reads Json file and return average age and number of users.
   * @param args given arguments from user type of file, path and command to be execute.
   * @return
   */
  private String getJsonString(String[] args) {
    if (args[3].equals("--printAverageStats")) {
      JSONCodec jsonCodec = new JSONCodec();
      UserRepository userRepository = (UserRepository) jsonCodec.importObject(new UserRepository(new LinkedList<User>()), args[2]);
      return "Users Count: " + userRepository.numberOfUsers() + "\nAverage Age: " + userRepository.averageAge();
    }
    return null;
  }
}

package com.clouway.userdata;

import java.io.File;

/**
 * Created by clouway on 25.07.16.
 *
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 */
public class CheckPoint {
  /**
   * Checks if number of arguments are correct.
   * @param args given arguments from user.
   * @return
   */
  public boolean correctNumbersOf(String[] args) {
    if (args.length < 4 || args.length > 4) {
      return false;
    }
    return true;
  }

  /**
   * Check if -type is missing
   * @param args give arguments from user.
   * @return
   */
  public boolean checkCommand(String[] args) {
    if (args[0].equals("-type")) {
      return true;
    }
    return false;
  }

  /**
   * Checks path of given file.
   * @param args given arguments from user.
   * @return
   */
  public boolean checkPath(String[] args) {
    return new File(args[2]).isFile();
  }
}

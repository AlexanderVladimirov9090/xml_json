package com.clouway.userdata;


/**
 * Created by clouway on 25.07.16.
 *
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 */
public class Main {
  public static void main(String[] args) {
    Printer printer = new Printer();
    System.out.println(printer.printStats(args));
    System.out.println("Bye!");

  }
}

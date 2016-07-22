package com.clouway.userdata;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by clouway on 26.07.16.
 *
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 */
public class PrinterTest {

  @Test
  public void givenJSONFile() throws Exception {
    Printer printer = new Printer();
    String[] args = {"-type", "json", "/home/clouway/developmnet/xml_json/TestFolder/users.json", "--printAverageStats"};

    assertThat(printer.printStats(args), is(equalTo("Users Count: 7\n" + "Average Age: 34")));
  }

  @Test(expected = BadInputArgumentsException.class)
  public void noTypeCommand() {
    Printer printer = new Printer();
    String[] args = {"", "json", "/home/clouway/developmnet/xml_json/TestFolder/users.json", "--printAverageStats"};
    printer.printStats(args);
  }

  @Test
  public void noTypeGiven() {
    Printer printer = new Printer();
    String[] args = {"-type", "", "/home/clouway/developmnet/xml_json/TestFolder/users.json", "--printAverageStats"};
   assertThat(printer.printStats(args),is(equalTo(null)));
  }

  @Test(expected = BadInputArgumentsException.class)
  public void noPathGiven() {
    Printer printer = new Printer();
    String[] args = {"-type", "json", "", "--printAverageStats"};
    printer.printStats(args);
  }

  @Test
  public void noCommandGiven() {
    Printer printer = new Printer();
    String[] args = {"-type", "json", "/home/clouway/developmnet/xml_json/TestFolder/users.json", ""};

    assertThat(printer.printStats(args), is(equalTo(null)));
  }
}
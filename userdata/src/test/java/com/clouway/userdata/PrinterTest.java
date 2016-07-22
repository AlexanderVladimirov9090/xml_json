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
    public void givenJSONFile() {
        Printer printer = new Printer();
        java.lang.String[] args = {"-type", "json", "/home/clouway/workspace/workspace/xml_json/users/users.json", "--printAverageStats"};

        assertThat(printer.printStats(args), is(equalTo("Users Count: 7\nAverage Age: 34")));
    }

    @Test
    public void givenXMLFile() {

        Printer printer = new Printer();
        java.lang.String[] args = {"-type", "xml", "/home/clouway/workspace/workspace/xml_json/users/users.xml", "--printAverageStats"};

        assertThat(printer.printStats(args), is(equalTo("Users Count: 7\nAverage Age: 24")));
    }

    @Test(expected = BadInputArgumentsException.class)
    public void noTypeCommand() {

        Printer printer = new Printer();
        java.lang.String[] args = {"", "json", "/home/clouway/developmnet/multiProject/xml_json/users/users.json", "--printAverageStats"};

        printer.printStats(args);
    }

    @Test
    public void noTypeGiven() {

        Printer printer = new Printer();
        java.lang.String[] args = {"-type", "", "/home/clouway/developmnet/multiProject/xml_json/users/users.json", "--printAverageStats"};

        assertThat(printer.printStats(args), is(equalTo("Wrong format.")));
    }

    @Test(expected = WrongSyntaxException.class)
    public void noPathGiven() {

        Printer printer = new Printer();
        java.lang.String[] args = {"-type", "json", "", "--printAverageStats"};

        printer.printStats(args);
    }

    @Test(expected = WrongSyntaxException.class)
    public void noCommandGiven() {

        Printer printer = new Printer();
        java.lang.String[] args = {"-type", "json", "/home/clouway/developmnet/multiProject/xml_json/users/users.json", ""};

        printer.printStats(args);
    }

    @Test(expected = WrongSyntaxException.class)
    public void jsonTypeToXmlFile() {
        Printer printer = new Printer();
        java.lang.String[] args = {"-type", "json", "/home/clouway/developmnet/multiProject/xml_json/users/users.xml", "--printAverageStats"};

        printer.printStats(args);
    }

    @Test(expected = WrongSyntaxException.class)
    public void xmlTypeToJSONFile() {
        Printer printer = new Printer();
        java.lang.String[] args = {"-type", "json", "/home/clouway/developmnet/multiProject/xml_json/users/users.xml", "--printAverageStats"};

        printer.printStats(args);
    }
}
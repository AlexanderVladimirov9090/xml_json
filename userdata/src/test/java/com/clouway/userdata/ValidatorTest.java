package com.clouway.userdata;

import com.sun.org.apache.xpath.internal.operations.String;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by clouway on 31.08.16.
 *
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 */
public class ValidatorTest {

    @Test
    public void happyPathLengthOfArgs() {
        Validator validator = new Validator();
        java.lang.String[] args = {"1", "2", "3", "4"};

        assertThat(validator.correctNumbersOf(args), is(true));
    }

    @Test
    public void lengthOfArgsLess() {
        Validator validator = new Validator();
        java.lang.String[] args = {"1", "2", "3"};

        assertThat(validator.correctNumbersOf(args), is(false));
    }

    @Test
    public void lengthOfArgsMoreThan() {
        Validator validator = new Validator();
        java.lang.String[] args = {"1", "2", "3", "4", "5"};

        assertThat(validator.correctNumbersOf(args), is(false));
    }

    @Test
    public void firstArgumentCorrect() {
        Validator validator = new Validator();
        java.lang.String[] args = {"-type", "2", "3", "4", "5"};

        assertThat(validator.checkType(args), is(true));
    }

    @Test
    public void incorrectFirstArgument() {
        Validator validator = new Validator();
        java.lang.String[] args = {"none", "2", "3", "4", "5"};

        assertThat(validator.checkType(args), is(false));
    }

    @Test
    public void executeCorrectCommand() {
        Validator validator = new Validator();
        java.lang.String[] args = {"1", "2", "3", "--printAverageStats"};

        assertThat(validator.checkCommand(args), is(true));
    }

    @Test
    public void executeIncorrectCommand() {
        Validator validator = new Validator();
        java.lang.String[] args = {"1", "2", "3", "-rins"};

        assertThat(validator.checkCommand(args), is(false));
    }
}
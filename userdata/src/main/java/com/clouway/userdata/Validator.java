package com.clouway.userdata;


/**
 * Created by clouway on 25.07.16.
 *
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 */
class Validator {
    /**
     * Checks if number of arguments are correct.
     *
     * @param args given arguments from user.
     * @return
     */
    boolean correctNumbersOf(String[] args) {
        return !(args.length < 4 || args.length > 4);
    }

    /**
     * Check if -type is missing
     *
     * @param args give arguments from user.
     * @return
     */
    boolean checkType(String[] args) {
        return args[0].equals("-type");
    }

    /**
     * Check argument 4 for proper command.
     *
     * @param args given arguments from the user.
     * @return
     */
    boolean checkCommand(String[] args) {
        return args[3].equals("--printAverageStats");
    }
}
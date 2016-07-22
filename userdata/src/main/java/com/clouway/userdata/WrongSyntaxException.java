package com.clouway.userdata;

/**
 * Created by clouway on 31.08.16.
 *
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 */
class WrongSyntaxException extends RuntimeException {
    WrongSyntaxException() {
        super("This exception is thrown when you give wrong file or wrong type to be deserialized.");
    }
}
package com.clouway.obectserealization;

/**
 * Created by clouway on 01.09.16.
 *
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 */
public class CanNotReadMessageException extends RuntimeException {
    public CanNotReadMessageException(String message){
        super(message);
    }
}
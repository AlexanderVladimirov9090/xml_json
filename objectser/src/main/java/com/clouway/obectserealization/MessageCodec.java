package com.clouway.obectserealization;

import java.lang.reflect.Type;

/**
 * Created by clouway on 26.07.16.
 *
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 *         This interface provides methods for serialization and deserialization of objects.
 */
public interface MessageCodec {

    /**
     * Serialization of object.
     *
     * @param object for serialization.
     * @return serialized object to any given format.
     */
    <T> String toMessage(T object);

    /**
     * Deserialization of object.
     *
     * @param message for deserialization .
     * @param type   for casting in to given class.
     * @return derialized object from any serialized format.
     */
    <T> T fromMessage(String message, Type type);
}
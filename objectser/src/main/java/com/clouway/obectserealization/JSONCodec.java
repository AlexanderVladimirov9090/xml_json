package com.clouway.obectserealization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;

/**
 * Created by clouway on 21.07.16.
 *
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 */
public class JSONCodec implements MessageCodec {

    /**
     * Serialization object to json format.
     *
     * @param object for serialization to json format .
     * @return serialize object to json format.
     */
    public <T> String toMessage(T object) {
        Gson gson = new Gson();
        return gson.toJson(object);
    }

    /**
     * DeSerialize json message to object.
     *
     * @param message for deserialization from json format.
     * @param type for casting message to the given class.
     * @return deserialized object from json.
     */
    public <T> T fromMessage(String message, Type type) {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(message, type);
    }
}
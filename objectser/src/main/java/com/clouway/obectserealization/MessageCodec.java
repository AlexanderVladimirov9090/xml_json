package com.clouway.obectserealization;

/**
 * Created by clouway on 26.07.16.
 *
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 * This interface provides methods for serialization and deserialization of objects.
 */
public interface MessageCodec<T> {

  /**
   * Serialization of object
   * @param object any type of object will be exported to file.
   * @param path of file that object will be exported.
   * @return true when done.
   */
  boolean exportObject(T object, String path);

  /**
   * Deserialization of object.
   * @param object any type of object will be imported to application.
   * @param path of file that will be exported.
   * @return will return object.
   */
  T importObject(T object, String path);
}

package com.clouway.obectserealization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.lang.reflect.Type;

/**
 * Created by clouway on 21.07.16.
 *
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 */
public class JSONCodec<T> implements MessageCodec<T> {

  /**
   * Export object to json format.
   * @param object any type of object will be exported to file.
   * @param path of file that object will be exported.
   * @return
   */
  public boolean exportObject(T object, String path) {

    if (path.length() == 0) {
      return false;
    }

    try {
      Writer writer = new FileWriter(path);
      Gson gson = new Gson();
      Type fooType = new TypeToken<T>() {
      }.getType();
      gson.toJson(object, fooType, writer);
      writer.close();

      return true;
    } catch (Exception e) {
      e.printStackTrace();
    }

    return false;
  }

  /**
   * Import object from json format.
   * @param object any type of object will be imported to application.
   * @param path of file that will be exported.
   * @return
   */
  public T importObject(T object, String path) {
    BufferedReader br;
    try {
      br = new BufferedReader(new FileReader(path));
      Gson gson = new GsonBuilder().create();
      return (T) gson.fromJson(br, object.getClass());
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    throw new RuntimeException();
  }
}

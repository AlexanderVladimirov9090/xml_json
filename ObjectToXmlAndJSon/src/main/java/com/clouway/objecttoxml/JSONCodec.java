package com.clouway.objecttoxml;

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
public class JSONCodec {

  /**
   * Creates json file for given objects.
   *
   * @param users wrapper for user object.
   * @param path  of json file.
   * @return true if file is created.
   */
  public boolean createJSON(Users users, String path) {
    if (path.length() == 0) {
      return false;
    }
    try {
      Writer writer = new FileWriter(path);
      Gson gson = new Gson();
      Type fooType = new TypeToken<Users<User>>() {
      }.getType();
      gson.toJson(users, fooType, writer);
      writer.close();

      return true;
    } catch (Exception e) {
      e.printStackTrace();
    }

    return false;
  }

  /**
   * Reads form JSON file and creates object.
   *
   * @param path of file.
   * @return object from json file.
   * @throws FileNotFoundException
   */
  public Users objectFromJSON(String path) throws FileNotFoundException {

    BufferedReader br = new BufferedReader(new FileReader(path));
    Gson gson = new GsonBuilder().create();

    return gson.fromJson(br, Users.class);
  }
}

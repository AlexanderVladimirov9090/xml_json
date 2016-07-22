package com.clouway.obectserealization;

import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by clouway on 25.07.16.
 *
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 */
public class JSONCodecTest {

  @Test
  public void happyPath() throws IOException {
    String path = "/home/clouway/developmnet/xml_json/Wrapper.json";
    Object object = new Object();
    JSONCodec jsonCodec = new JSONCodec();


    assertThat(jsonCodec.exportObject(object, path), is(true));
    assertThat(jsonCodec.importObject(object, "/home/clouway/developmnet/xml_json/Wrapper.json"), is(instanceOf(Object.class)));
  }

  @Test
  public void pathNotGiven() throws IOException {
    String path = "";
    Object object = new Object();
    JSONCodec jsonCodec = new JSONCodec();


    assertThat(jsonCodec.exportObject(object, path), is(false));
  }

  @Test
  public void many() throws IOException {

    String path = "/home/clouway/developmnet/xml_json/Wrapper.json";
    Object object = new Object();
    Object object2 = new Object();
    Object object3 = new Object();

    JSONCodec jsonCodec = new JSONCodec();

    assertThat(jsonCodec.exportObject(object, path), is(true));
    assertThat(jsonCodec.importObject(object,"/home/clouway/developmnet/xml_json/object.json"), is(instanceOf(Object.class)));

    assertThat(jsonCodec.exportObject(object2, path), is(true));
    assertThat(jsonCodec.importObject(object2,"/home/clouway/developmnet/xml_json/object.json"), is(instanceOf(Object.class)));

    assertThat(jsonCodec.exportObject(object3, path), is(true));
    assertThat(jsonCodec.importObject(object3,"/home/clouway/developmnet/xml_json/object.json"), is(instanceOf(Object.class)));


  }

}
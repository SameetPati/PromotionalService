package handler;

import java.util.Scanner;

import data.sku;

public class skuData {
  public sku setData(String inputString) {
    sku skuObject = new sku();
    try {
      inputString = inputString.replaceAll("\\s", "");
      Scanner inputStr = new Scanner(inputString).useDelimiter(",");
      while (inputStr.hasNext()) {
        String[] x = inputStr.next().split("=");
        String xx = (String) x[0];
        int ix = Integer.parseInt(x[1]);
        skuObject.setSKUData(xx, ix);
      }
      inputStr.close();
    } catch (Exception e) {
      throw new Error("Unable to parse the string");
    }
    return skuObject;
  }
}

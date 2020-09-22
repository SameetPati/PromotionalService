package data;

import java.util.HashMap;

public class sku {
  private HashMap<String, Integer> skuData = new HashMap<>();

  public void setSKUData(String ch, Integer I) {
    skuData.put(ch, I);
  }

  public HashMap<String, Integer> getSKUData() {
    return skuData;
  }
}

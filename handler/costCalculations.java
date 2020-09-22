package handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import data.sku;

public class costCalculations {
  public Integer returnCost(String inputString, sku skuObject, HashMap<List<String>, Integer> promoObj) {
    int finalCost = 0;
    HashMap<String, Integer> aa = skuObject.getSKUData();
    Set<String> skuKeyObject = aa.keySet();
    String[] itemsBrought = inputString.split(",");
    List<String> validItemsBrought = new ArrayList<String>();
    for (String single : itemsBrought) {
      if (skuKeyObject.contains(single)) {
        validItemsBrought.add(single);
      } else {
        System.out.println("Invalid Item, " + single + " Item Not Present in the SKU. Ignoring the Item");
      }
    }

    for (List<String> mapElement : promoObj.keySet()) {
      if (mapElement.size() == 1) {
        while (validItemsBrought.contains(mapElement.get(0))) {
          System.out.println("Adding " + promoObj.get(mapElement) + " for " + mapElement.get(0));
          finalCost += promoObj.get(mapElement);
          validItemsBrought.remove(mapElement.get(0));
        }
      } else {
        boolean allItemsPresent = true;
        for (int i = 0; i < mapElement.size(); i++) {
          if (!validItemsBrought.contains(mapElement.get(i))) {
            allItemsPresent = false;
          }
        }
        if (allItemsPresent) {
          // all promo are present
          for (int i = 0; i < mapElement.size(); i++) {
            validItemsBrought.remove(mapElement.get(i));
          }
          System.out.println("Adding " + promoObj.get(mapElement) + " for " + mapElement);
          finalCost += promoObj.get(mapElement);
        }
      }
    }
    while (!validItemsBrought.isEmpty()) {
      System.out.println("Adding " + aa.get(validItemsBrought.get(0)) + " for " + validItemsBrought.get(0));
      finalCost += aa.get(validItemsBrought.get(0));
      validItemsBrought.remove(0);
    }
    try {
    } catch (Exception e) {
      throw new Error("Unable to parse the string");
    }
    return finalCost;
  }
}

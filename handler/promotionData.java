package handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import data.sku;

public class promotionData {
  public HashMap<List<String>, Integer> formatData(String inputString, sku skuObject) {
    HashMap<List<String>, Integer> promoObject = new HashMap<List<String>, Integer>();
    try {
      HashMap<String, Integer> aa = skuObject.getSKUData();
      Scanner inputStr = new Scanner(inputString).useDelimiter("EOL ");
      while (inputStr.hasNext()) {
        String x = inputStr.next();
        int count = 0;
        List<String> listData = new ArrayList<String>();
        for (String mapElement : aa.keySet()) {
          if (x.contains(mapElement)) {
            listData.add(mapElement);
            count++;
          }
        }
        if (count == 1) {
          int cost = 0;
          int num = 0;
          String[] breakstr = x.split("of");
          if (breakstr[0] != null) {
            if (!breakstr[0].contains("%")) {
              num = Integer.parseInt(breakstr[0].replaceAll("\\s", ""));
              for (int i = 1; i < num; i++) {
                listData.add(listData.get(0));
              }
              String[] breakfor = breakstr[1].split("for");
              cost = Integer.parseInt(breakfor[1].replaceAll("\\s", ""));
              promoObject.put(listData, cost);
            } else {
              num = Integer.parseInt(breakstr[0].replaceAll("\\s", "").replaceAll("%", ""));
              cost = aa.get(listData.get(0)) - ((aa.get(listData.get(0)) * num) / 100);
              promoObject.put(listData, cost);
            }

          }
        } else {
          String[] breakst = x.split("for");
          int value = Integer.parseInt(breakst[1].replaceAll("\\s", ""));
          promoObject.put(listData, value);
        }

      }
      inputStr.close();
    } catch (Exception e) {
      throw new Error("Unable to parse the string");
    }
    return promoObject;
  }
}

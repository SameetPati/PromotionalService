
import data.sku;
import handler.promotionData;
import handler.skuData;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class index {
  public static void main(String args[]) throws IOException {
    System.out.println("Welcome to Promotion service.");

    // Getting the SKU value
    Scanner input = new Scanner(System.in);
    String skuData = checkWithUser("files//skuData", " A=30,B=40", "", input);
    skuData obj = new skuData();
    sku skuObj = obj.setData(skuData);

    // Getting the promotional value file/promotionData 3 of A's for 130 EOL 2 of
    // B's for 45
    File fileData = new File("files//promotionData.txt");
    BufferedReader br = new BufferedReader(new FileReader(fileData));
    String st;
    String promotionalData = "";
    while ((st = br.readLine()) != null) {
      promotionalData = promotionalData + st + " EOL ";
    }
    promotionData datObj = new promotionData();
    HashMap<List<String>, Integer> promoObj = datObj.formatData(promotionalData, skuObj);
    System.out.println(promoObj);
    System.out.println("Enter the Buying Data in format A,A,A,B,B,B etc");
    String inputString = input.nextLine();
    input.close();
  }

  public static String checkWithUser(String file, String format, String srparator, Scanner scan) throws IOException {
    String finalData = "";
    String inputString = "";
    while (true) {
      System.out.println("Do you want to use the preDefined SKU Data from " + file + ".txt (Y/N/Q)");
      inputString = scan.nextLine();
      if (inputString.equalsIgnoreCase("Y")) {
        File fileData = new File(file + ".txt");
        BufferedReader br = new BufferedReader(new FileReader(fileData));
        String st;
        while ((st = br.readLine()) != null) {
          finalData += st;
        }
        System.out.println("Using Data = " + finalData);
        break;
      } else if (inputString.equalsIgnoreCase("N")) {
        System.out.println("Enter the Promition details in format " + format + " etc.");
        inputString = scan.nextLine();
        finalData = inputString;
        break;
      } else if (inputString.equalsIgnoreCase("Q")) {
        throw new Error("Program terminated");
      } else {
        System.out.println("Not a valid input enter again.");
        continue;
      }
    }
    return finalData;
  }
}
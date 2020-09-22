

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

    // Getting thr SKU value from the user
    Scanner input = new Scanner(System.in);
    String skuData = checkWithUser("files//skuData", " A=30,B=40", "", input);
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
package final_exam;

import java.io.File;
import java.util.Scanner;

public class ReadFile {

    public static void processFile(){
        try{
            Scanner sc = new Scanner(new File("shop"));

            // retrieve each line of the file which contains the item name, price, minimum price, and maximum buying price
            while(sc.hasNext()){
                String itemLine = sc.nextLine();
                String[] itemToParse = itemLine.split(" ");

                String name = itemToParse[0];
                Double price = Double.parseDouble(itemToParse[1]);
                Double minPrice = Double.parseDouble(itemToParse[2]);
                Double maxPrice = Double.parseDouble(itemToParse[3]);

                AuctionItem item = new AuctionItem(name, price, minPrice, maxPrice);  // create a new AuctionItem from the item entry
            }

        }
        catch(Exception e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }
    }



}

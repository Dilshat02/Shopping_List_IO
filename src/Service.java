import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class Service {
    public static void saveItems(ArrayList <GoodItem> goodItems){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("goodItems.txt"));
            for (GoodItem goodItem : goodItems){
                bw.write(goodItem.getName() + "\n");
                bw.write(goodItem.getPrice() + "\n");
            }
            bw.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static ArrayList<GoodItem> getGoodItemList(){
        ArrayList<GoodItem> goodItems = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("goodItems.txt"));
            String line = "";
            while ((line = br.readLine()) != null){
                int price = Integer.parseInt(br.readLine());
                goodItems.add(new GoodItem(line,price));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return goodItems;
    }

    public static ArrayList<BuyHistory> getBuyHistory(){
        ArrayList<BuyHistory> buyHistory = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("buyHistory.txt"));
            String line = "";
            while ((line = br.readLine()) != null){
                int goodPrice = Integer.parseInt(br.readLine());
                buyHistory.add(new BuyHistory(line,goodPrice));
            }
        }catch (Exception e){

        }
        return buyHistory;
    }

    public static void saveBuyHistory(ArrayList<BuyHistory> buyHistory){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("buyHistory.txt"));
            for (BuyHistory b : buyHistory){
                bw.write(b.getGoodName() + "\n");
                bw.write(b.getGoodPrice() + "\n");
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

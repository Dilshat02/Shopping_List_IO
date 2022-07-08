import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<GoodItem> goodItems;
        ArrayList<BuyHistory> buyHistories = new ArrayList<>();

        while (true){
            System.out.println("PRESS [1] LIST GOODS");
            System.out.println("PRESS [2] BUY GOOD");
            System.out.println("PRESS [3] LIST BUY HISTORY");
            System.out.println("PRESS [0] TO EXIT");
            String choice = in.next();

            if (choice.equals("1")){
                goodItems = Service.getGoodItemList();
                for (int i = 0; i < goodItems.size(); i++) {
                    System.out.println((i + 1) + ")" + goodItems.get(i));
                }
            }
            if (choice.equals("2")){
                goodItems = Service.getGoodItemList();
                for (int i = 0; i < goodItems.size(); i++) {
                    System.out.println((i + 1) + ")" + goodItems.get(i));
                }
                System.out.println("Выебрите товар который вам нужен");
                String goodName = in.next();
                for (GoodItem g: goodItems) {
                    if (goodName.equals(g.getName())){
                        BuyHistory buyHistory = new BuyHistory(goodName,g.price);
                        buyHistories.add(buyHistory);
                        Service.saveBuyHistory(buyHistories);
                        System.out.println("Товар успешно добавлен в список покупок");
                    }
                }
            }
            if (choice.equals("3")){
                buyHistories = Service.getBuyHistory();
                for (int i = 0; i < buyHistories.size(); i++) {
                    System.out.println(i + 1 + ")" + buyHistories.get(i));
                }
            }
            if (choice.equals("0")){
                break;
            }
        }
    }
}

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Admin {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<GoodItem> goodItems = new ArrayList<>();

        while (true){
            System.out.println("PRESS [1] ADD GOOD");
            System.out.println("PRESS [2] LIST GOODS");
            System.out.println("PRESS [3] DELETE GOOD");
            System.out.println("PRESS [0] TO EXIT");
            String choice = in.next();

            if (choice.equals("1")){
                try {
                    System.out.println("Введите название товара");
                    String name = in.next();
                    System.out.println("Введите цену товара");
                    int price = in.nextInt();
                    GoodItem goodItem = new GoodItem(name, price);
                    goodItems = Service.getGoodItemList();
                    goodItems.add(goodItem);
                    Service.saveItems(goodItems);
                }catch (InputMismatchException exception){
                    System.out.println("d");
                }
            }
            else if (choice.equals("2")){
                goodItems = Service.getGoodItemList();
                for (int i = 0; i < goodItems.size(); i++) {
                    System.out.println((i + 1) + ") " + goodItems.get(i));
                }
            }
            else if (choice.equals("3")) {
                try {
                    System.out.println("Введите номер товара");
                    int index = in.nextInt();
                    goodItems.remove(index - 1);
                    Service.saveItems(goodItems);
                }catch (IndexOutOfBoundsException exception){
                    System.out.println("Товар не нвйден");
                }
            }
            else if (choice.equals("0")){
                break;
            }
        }
    }
}
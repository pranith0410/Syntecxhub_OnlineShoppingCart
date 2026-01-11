import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class OnlineShoppingCart {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<String> items = new ArrayList<>();
        HashMap<String, Double> priceMap = new HashMap<>();
        HashMap<String, Integer> quantityMap = new HashMap<>();

        int choice;

        do {
            System.out.println("\n===== ONLINE SHOPPING CART =====");
            System.out.println("1. Add Item");
            System.out.println("2. View Cart");
            System.out.println("3. Calculate Total Price");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {

                case 1:
                    System.out.print("Enter item name: ");
                    String itemName = sc.nextLine();

                    System.out.print("Enter item price: ");
                    double price = sc.nextDouble();

                    System.out.print("Enter quantity: ");
                    int quantity = sc.nextInt();

                    if (items.contains(itemName)) {
                        quantityMap.put(itemName,
                                quantityMap.get(itemName) + quantity);
                    } else {
                        items.add(itemName);
                        priceMap.put(itemName, price);
                        quantityMap.put(itemName, quantity);
                    }

                    System.out.println("Item added successfully!");
                    break;

                case 2:
                    if (items.isEmpty()) {
                        System.out.println("Cart is empty!");
                    } else {
                        System.out.println("\n--- Your Cart ---");
                        for (String item : items) {
                            System.out.println(
                                    item + " | Price: ₹" +
                                    priceMap.get(item) +
                                    " | Quantity: " +
                                    quantityMap.get(item));
                        }
                    }
                    break;

                case 3:
                    double total = 0;
                    for (String item : items) {
                        total += priceMap.get(item) * quantityMap.get(item);
                    }
                    System.out.println("Total Price: ₹" + total);
                    break;

                case 4:
                    System.out.println("Thank you for shopping!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again!");
            }

        } while (choice != 4);

        sc.close();
    }
}

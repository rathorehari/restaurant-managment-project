package com.order;

import com.admin.Item;
import com.user.InsertData;
import com.user.User;
import java.util.ArrayList;
import java.util.Scanner;

public class UserOrder {
    private ArrayList<Item> items;
    private InsertData insertData;
    private Scanner sc;


    public UserOrder(ArrayList<Item> items, Scanner sc) {
        this.items = items;
        this.insertData = new InsertData();
        this.sc = new Scanner(System.in);
    }
    private ArrayList<Item> orderedItems = new ArrayList<>();
    private double totalPrice = 0.0;
    public ArrayList<Item> getOrderedItems() {
        return orderedItems;
    }

    public void orderItems(User user) {
        System.out.println("Available items in menu");
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i).getName() + " - " + items.get(i).getPrice());
        }

        System.out.println("Enter the numbers of the items you want to order (type '0' to finish):");
        while (true) {
            int itemNumber = sc.nextInt();
            sc.nextLine(); 
            if (itemNumber == 0) {
                break;
            }
            if (itemNumber > 0 && itemNumber <= items.size()) {
                Item item = items.get(itemNumber - 1);
                orderedItems.add(item);
                totalPrice += item.getPrice();
            } else {
                System.out.println("Invalid item number. Please try again.");
            }
        }
        
        System.out.println("Order placed. Total price: " + totalPrice);
        insertData.storeOrder(user.getUsername(), user.getPhoneNumber(), totalPrice);
    }
}

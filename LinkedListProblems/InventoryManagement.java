class Item {
    String itemName;
    int itemId;
    int quantity;
    double price;
    Item next;

    public Item(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }

    @Override
    public String toString() {
        return "Item Name: " + itemName + ", Item ID: " + itemId + ", Quantity: " + quantity + ", Price: $" + price;
    }
}

class InventoryManagementSystem {
    private Item head = null;

    // Add an item at the beginning
    public void addItemAtBeginning(String itemName, int itemId, int quantity, double price) {
        Item newItem = new Item(itemName, itemId, quantity, price);
        newItem.next = head;
        head = newItem;
    }

    // Add an item at the end
    public void addItemAtEnd(String itemName, int itemId, int quantity, double price) {
        Item newItem = new Item(itemName, itemId, quantity, price);
        if (head == null) {
            head = newItem;
        } else {
            Item temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newItem;
        }
    }

    // Add an item at a specific position
    public void addItemAtPosition(String itemName, int itemId, int quantity, double price, int position) {
        Item newItem = new Item(itemName, itemId, quantity, price);
        if (position <= 0 || head == null) {
            addItemAtBeginning(itemName, itemId, quantity, price);
        } else {
            Item temp = head;
            int count = 1;
            while (temp != null && count < position) {
                if (temp.next == null) break; // If position is out of bounds, append to the end
                temp = temp.next;
                count++;
            }
            newItem.next = temp.next;
            temp.next = newItem;
        }
    }

    // Remove an item based on Item ID
    public void removeItemById(int itemId) {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }

        if (head.itemId == itemId) {
            head = head.next;
            System.out.println("Item with ID " + itemId + " removed.");
            return;
        }

        Item temp = head;
        while (temp.next != null && temp.next.itemId != itemId) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Item with ID " + itemId + " not found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Item with ID " + itemId + " removed.");
        }
    }

    // Update the quantity of an item by Item ID
    public void updateItemQuantity(int itemId, int newQuantity) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                temp.quantity = newQuantity;
                System.out.println("Quantity updated for Item ID " + itemId + " to " + newQuantity + ".");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item with ID " + itemId + " not found.");
    }

    // Search for an item by Item ID
    public void searchItemById(int itemId) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                System.out.println("Item found: " + temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item with ID " + itemId + " not found.");
    }

    // Search for an item by Item Name
    public void searchItemByName(String itemName) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemName.equalsIgnoreCase(itemName)) {
                System.out.println("Item found: " + temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item with Name '" + itemName + "' not found.");
    }

    // Calculate and display the total value of the inventory
    public void calculateTotalInventoryValue() {
        double totalValue = 0;
        Item temp = head;
        while (temp != null) {
            totalValue += temp.price * temp.quantity;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: $" + totalValue);
    }

    // Sort the inventory based on Item Name in ascending order
    public void sortInventoryByName(boolean ascending) {
        if (head == null || head.next == null) return;

        for (Item i = head; i != null; i = i.next) {
            for (Item j = i.next; j != null; j = j.next) {
                if (ascending ? i.itemName.compareToIgnoreCase(j.itemName) > 0 : i.itemName.compareToIgnoreCase(j.itemName) < 0) {
                    // Swap
                    String tempName = i.itemName;
                    int tempId = i.itemId;
                    int tempQuantity = i.quantity;
                    double tempPrice = i.price;

                    i.itemName = j.itemName;
                    i.itemId = j.itemId;
                    i.quantity = j.quantity;
                    i.price = j.price;

                    j.itemName = tempName;
                    j.itemId = tempId;
                    j.quantity = tempQuantity;
                    j.price = tempPrice;
                }
            }
        }
    }

    // Sort the inventory based on Price in ascending or descending order
    public void sortInventoryByPrice(boolean ascending) {
        if (head == null || head.next == null) return;

        for (Item i = head; i != null; i = i.next) {
            for (Item j = i.next; j != null; j = j.next) {
                if (ascending ? i.price > j.price : i.price < j.price) {
                    // Swap
                    String tempName = i.itemName;
                    int tempId = i.itemId;
                    int tempQuantity = i.quantity;
                    double tempPrice = i.price;

                    i.itemName = j.itemName;
                    i.itemId = j.itemId;
                    i.quantity = j.quantity;
                    i.price = j.price;

                    j.itemName = tempName;
                    j.itemId = tempId;
                    j.quantity = tempQuantity;
                    j.price = tempPrice;
                }
            }
        }
    }

    // Display all items in the inventory
    public void displayInventory() {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }

        Item temp = head;
        System.out.println("Inventory List:");
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }
}

// Main class to test the Inventory Management System
public class InventoryManagement {
    public static void main(String[] args) {
        InventoryManagementSystem inventory = new InventoryManagementSystem();

        inventory.addItemAtEnd("Laptop", 101, 10, 1000);
        inventory.addItemAtEnd("Mouse", 102, 50, 20);
        inventory.addItemAtBeginning("Keyboard", 103, 20, 50);
        inventory.addItemAtPosition("Monitor", 104, 15, 200, 2);

        System.out.println("\nDisplaying inventory:");
        inventory.displayInventory();

        System.out.println("\nUpdating quantity for Item ID 101:");
        inventory.updateItemQuantity(101, 5);

        System.out.println("\nSearching for Item ID 102:");
        inventory.searchItemById(102);

        System.out.println("\nSearching for Item Name 'Monitor':");
        inventory.searchItemByName("Monitor");

        System.out.println("\nCalculating total inventory value:");
        inventory.calculateTotalInventoryValue();

        System.out.println("\nSorting inventory by Name (Ascending):");
        inventory.sortInventoryByName(true);
        inventory.displayInventory();

        System.out.println("\nSorting inventory by Price (Descending):");
        inventory.sortInventoryByPrice(false);
        inventory.displayInventory();

        System.out.println("\nRemoving Item with ID 102:");
        inventory.removeItemById(102);
        inventory.displayInventory();
    }
}

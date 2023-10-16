package lab4;

import java.util.Arrays;

public class Task1_4 {
	public static void selectionSort(Order[] orders) {
		int n = orders.length;
		for (int i = 0; i < n - 1; i++) {
			int maxIndex = i;
			for (int j = i + 1; j < n; j++) {
				if (orders[j].getQuantity() > orders[maxIndex].getQuantity()) {
					maxIndex = j;
				}
			}
			// Swap the found maximum element with the first element
			Order temp = orders[i];
			orders[i] = orders[maxIndex];
			orders[maxIndex] = temp;
		}
	}

	// Order class for Task 1.4
	static class Order {
		private String itemName;
		private int quantity;

		public Order(String itemName, int quantity) {
			this.itemName = itemName;
			this.quantity = quantity;
		}

		public int getQuantity() {
			return quantity;
		}

		@Override
		public String toString() {
			return "Order{" + "itemName='" + itemName + '\'' + ", quantity=" + quantity + '}';
		}

	}
	public static void main(String[] args) {
        // Example for sorting an array of order items
        Order[] orders = {
                new Order("Coca", 20),
                new Order("Candy", 9),
                new Order("Snack", 10)
        };
        // Sorting orders by quantity in descending order
        
        selectionSort(orders);
        System.out.println("Orders Sorted by Quantity (Descending):" + Arrays.toString(orders));
    
}
}

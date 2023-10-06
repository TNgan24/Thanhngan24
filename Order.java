package lab3;

import java.util.Arrays;

public class Order {
	private OrderItem[] items;

	public Order(OrderItem[] items) {
		super();
		this.items = items;

	}

	public double cost() {
		double re = 0;
		for (int i = 0; i < items.length; i++) {
			re += items[i].getPrice();
		}
		return re;

	}

	public boolean contains(Product p) {
		Arrays.sort(this.items);
		int low = 0;
		int high = items.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (p.compareTo(items[mid].getProduct()) == 0) {
				return true;
			}
			if (p.compareTo(items[mid].getProduct()) < 0)
				high = mid - 1;
			else
				low = mid + 1;
		}
		return false;

	}

	public Product[] filter(String type) {
		int count = 0;
		for (int i = 0; i < items.length; i++) {
			if (items[i].getType().equals(type))
				count++;
		}
		Product[] result = new Product[count];
		for (int i = 0; i < items.length; i++) {
			if (items[i].getType().equals(type)) {
				result[--count] = items[i].getProduct();
			}
		}
		return result;

	}
}

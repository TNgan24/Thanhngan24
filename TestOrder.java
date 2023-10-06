package lab3;

import java.util.Arrays;

public class TestOrder {
	public static void main(String[] args) {
		Product p1 = new Product("01", "Coca Cola", 9, "Soft Drink");
		Product p2 = new Product("02", "KFC", 89, "fast food");
		Product p3 = new Product("03", "Sting", 10, "Soft Drink");
		Product p4 = new Product("04","Chips",5,"Snacks");
		
		OrderItem it1 = new OrderItem(p1,9);
		OrderItem it2 = new OrderItem(p2,2);
		OrderItem it3 = new OrderItem(p3,7);
		OrderItem it4 = new OrderItem(p4,5);
		OrderItem []or1 = {it1, it2, it3, it4};

		Arrays.sort(or1);
		System.out.println(Arrays.toString(or1));
	}
	
	
	
}

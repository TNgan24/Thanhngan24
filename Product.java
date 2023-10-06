package lab3;

public class Product implements Comparable<Product>{
	private String id;
	private String name;
	private double price;
	private String type;
	
	public Product(String id, String name, double price, String type) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.type = type;
	}
	public double getPrice() {
		return this.price;
	}
	public String getType() {
		return null;
	}

	@Override
	public int compareTo(Product o) {
		int byID = this.id.compareTo(o.id);
		if (byID == 0) {
			return Double.compare(this.price, o.price);
		}
		return byID;
	}
	
	public String toString() {
		return id + " : " + name + " : " + price + " : " + type;
	}
	

	
}




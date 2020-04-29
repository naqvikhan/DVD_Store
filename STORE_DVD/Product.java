//the purpose of the abstract class is to store common properties of the products so they can be displayed 
//in the cart
abstract public class Product implements Comparable<Product> {
	String title = "";
	double price = 0; 
	int inventory = 0;
	
    //abstract method to be overwritten
	abstract public String toString();
	
	//Constructor for Cart subchild
	public Product(){}
	
	public Product(String title, double price){
		this.title = title;
		this.price = price;
	}
	
	//Getter methods
	public String getTitle(){
		return title;
	}
	
	public double getPrice(){
		return price;
	}
	
	public int getInv(){
		return inventory;
	}
	
	public void setInv(int inventory){
		this.inventory = inventory;
	}
	
	//compareTo method for comparing products
	public int compareTo(Product obj) 
	{
		//int compareValue = this.getPrice() - obj.getPrice();
		if(this.getPrice() == obj.getPrice())
			return 0;
		else if(this.getPrice() < obj.getPrice())
			return -1;
		else
			return 1;
		//return compareValue;
    }
}
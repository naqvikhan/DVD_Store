public class Cart extends Product
{
    public Cart(){}
	
	public Cart(String name, double price){
		super(name, price);
	}
	
	public String toString(){
		return String.format("%-17s$%6.2f\n", title, price);
	}
}
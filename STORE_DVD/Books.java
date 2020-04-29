
public class Books extends Product
{   
   private double discount = 0.9;
   String author;
   int isbn;

   public Books (){}

   public Books (int isbnNum, String authorName, String title, double price, int inventory)
   {
       isbn = isbnNum;
       author = authorName;
       this.title = title;
       this.price = price*discount;
       this.inventory = inventory;
   }

   public int getISBN ()
   {
       return this.isbn;
   }

   public String getAuthor() 
   {
       return this.author;
   }

   public double getPrice()
   { 
    return super.price * discount;
   }


    public String toString() {
        return String.format("%d | Title: %s| Author: %s| Price: %.2f| ISBN: %d%n",
                inventory, title, this.getAuthor(), this.getPrice(), this.getISBN());
    }
}

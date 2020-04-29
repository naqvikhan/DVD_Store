public class AudioBook extends Books
{
    private double discount = 0.5;
    double runningTime; 

    public AudioBook (){}

    public AudioBook (int isbnNum, String authorName, String title, double price, double runTime, int inventory)
    {
        super(isbnNum, authorName, title, price, inventory);
        runningTime = runTime;
    }

    public double getRunningTime ()
   {
       return this.runningTime;
   }

   public double getPrice ()
   {
       return super.price * discount;
   }

   public String toString() {
       return String.format("%d | Title: %s | Author: %s | Price: %.2f | ISBN: %d | Running Time: %.2f%n",
               inventory, title, this.getAuthor(), this.getPrice(), this.getISBN(), this.getRunningTime());
   }


}

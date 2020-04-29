public class Dvd extends Product
{
    private double discount = 0.8;
    String director;
    int year;
    int dvdcode;

public Dvd (){}

    public Dvd (int codeDVD, String directorName, String title, int movieYear, double price, int inventory)
    {
        dvdcode = codeDVD;
        director = directorName;
        year = movieYear;
        this.title = title;
        this.price = price*discount;
        this.inventory = inventory;
    }

    public int getDvdCode ()
    {
        return this.dvdcode;
    }

    public String getDirector() {
        return this.director;
    }


    public int getYear ()
    {
        return this.year;
    }

    public double getPrice() {
        return super.price * discount;
    }



    public String toString() {
        return String.format("%d | Title: %s | Director: %s | Price: %.2f | Year: %d | DvdCode: %d%n",
               inventory, title, this.getDirector(), this.getPrice(), this.getYear(), this.getDvdCode());
    }
 
 

}
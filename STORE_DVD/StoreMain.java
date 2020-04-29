//Assignment 5
//This is the main file of the program 
//Name: M Naqvi Aziz Khan
//NetID: mak171830

//This code shifts between 2 programs
//That of a store manager and a customer

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

    public class StoreMain
    {

        static Scanner input = new Scanner(System.in);
        // static Validator valid = new Validator();
        static ArrayList<Dvd> dvd = new ArrayList<Dvd>();
        static ArrayList<Books> book = new ArrayList<Books>();
        static ArrayList<Cart> cart = new ArrayList<Cart>();

        public static void main (String arg [])
        {
            char menu;

            do
            {
            System.out.println("\n**Welcome to the Comets Books and DVDs Store **");
            System.out.println("Please select your role: ");
            System.out.println("A – store manager");
            System.out.println("B – customer");
            System.out.println("C – exit store");
          
            do
            {
            System.out.print("\nEnter your option: (Please use Capital letter) ");
            
            menu = input.next().charAt(0);
            } while (menu != 'A' && menu !=  'C' && menu != 'B');
    
            switch(menu)
            {
            
            case 'A' :
            {
            if (checkManager())
            {
                ManagerMain();
            }
            
            break;
            }
            
            case 'B':
            CustomerMain();
            break;
            
            case 'C':
            System.out.println ("\nThanks for shopping at Comets Books and DVDs Store!");
            System.exit(0);
            
            default:
            System.out.println("This option is not acceptable");
            }
            System.out.println();
            } 
            while (true);
        }
        

        //Store Manager Section
        //this contains all sections of code that will deal with manager side
        

        //to check if the username and password is correct
        public static boolean checkManager()
        {
            FileOperations fo = new FileOperations();
		
		System.out.print("Please enter your username: ");
		String username = input.next();
		System.out.print("Please enter your password: ");
		String password = input.next();
		
		if(fo.userAuthentication(username, password)){
			return true;
		}
        else
        {
            return false;
        }
			
        }

        //if username and password is correct manager mode can be accessed
        public static void ManagerMain()
        {
            int choice = 0;

            while (choice != 9)
				{
					choice = ManagerMenu();
						
						//switch for different user options
					switch(choice){
					
					case 1 : addBook();
							 break;

					case 2: addAudioBook();
							break;
					
					case 3: addDvd();
							break;

					case 4: removeBook();
							break;

					case 5: removeDvd();
							break;

					case 6: displayAll();
                            break;
                            
                    case 7: createBackup();        

					case 9: break; //does not do anything but break, as userChoice is within the loop, statement exits

					default: System.out.println("You have not selected a valid option. Please select valid option:");
						
					}
				
				}

        }

        //menu option for manager mode
        public static int ManagerMenu()	
        {             
                    int x = 0;
                    
                    System.out.println ("\nChoose from the following options:");
                    System.out.println ("1 - Add Book");
                    System.out.println ("2 - Add AudioBook");
                    System.out.println ("3 - Add DVD");
                    System.out.println ("4 - Remove Book");
                    System.out.println ("5 - Remove DVD");
                    System.out.println ("6 - Display Catalog");
                    System.out.println ("7 - Create Backup File");
                    System.out.println ("9 - Exit Manager Mode");
                    
                    
                    x = input.nextInt(); //taking input from user
                    return x;     
        }

        //add book to catalog method
        public static void addBook()
     {

        
        int isbn = 0, inventory = book.size() + 1;;
        double price= 0;
        String title;
        String author;
        
        System.out.println("Enter the ISBN number: ");
        isbn = input.nextInt();
		
		while(isbn <= 0)
        {
        System.out.println("Enter a valid ISBN number:");
        isbn = input.nextInt();
        }
        
        for(int i = 0; i < book.size(); i++)
        {
        if(isbn == (book.get(i)).getISBN())
        {
        System.out.println("This book already exists in the catalog.");
        return;
		}

		}

		System.out.print("Enter the Book price: ");
		price = input.nextDouble();
		while(price <= 0)
		{
			System.out.println("Enter valid price:");
			price = input.nextDouble();
		}

		System.out.print("Enter the Book Title: ");
		title = input.next();
		while(title == "")
		{
			System.out.println("Enter valid Title:");
			title = input.next();		
		}

		System.out.print("Enter the Book Author: ");
		author = input.next();
		while(author == "")
		{
			System.out.println("Enter valid Author Name:");
			author = input.next();		
		}

		book.add(new Books(isbn, author, title, price, inventory));

		return;
    }
    
    //add audiobook to catalog
    public static void addAudioBook()
     {
        
        int isbn = 0, inventory = book.size() + 1;;
        double price= 0;
        String title;
		String author;
		double runningTime;
        
        System.out.println("Enter the ISBN number: ");
        isbn = input.nextInt();
		
		while(isbn <= 0)
        {
        System.out.println("Enter a valid ISBN number:");
        isbn = input.nextInt();
        }
        
        for(int i = 0; i < book.size(); i++)
        {
        if(isbn == (book.get(i)).getISBN())
        {
        System.out.println("This book already exists in the catalog.");
        return;
		}

		}

		System.out.print("Enter the Book price: ");
		price = input.nextDouble();
		while(price <= 0)
		{
			System.out.println("Enter valid price:");
			price = input.nextDouble();
		}

		System.out.print("Enter the Book Title: ");
		title = input.next();
		while(title == "")
		{
			System.out.println("Enter valid Title:");
			title = input.next();		
		}

		System.out.print("Enter the Book Author: ");
		author = input.next();
		while(author == "")
		{
			System.out.println("Enter valid Author Name:");
			author = input.next();		
		}

		System.out.print("Enter the Running Time: ");
		runningTime = input.nextDouble();
		while(runningTime <= 0)
		{
			System.out.println("Enter valid Running Time:");
			runningTime = input.nextDouble();
		}

		book.add(new AudioBook(isbn, author, title, price, runningTime, inventory));

		return;
	}

    //add dvd to catalog method
    public static void addDvd ()
	{

		String title, director;
		int year = 0;
		int dvdcode = 0, inventory = dvd.size() + 1;; 
		double price = 0;

		System.out.print("Enter the DVD code: ");
		dvdcode = input.nextInt();

		while(dvdcode <= 0)
		{
			System.out.println("Enter valid DVD Code: ");
			dvdcode = input.nextInt();
		}

		for(int i = 0; i < dvd.size(); i++) 
		{
			if (dvdcode == dvd.get(i).getDvdCode ()) {
				System.out.println("This DVD already exists in the catalog");
				return;
			}
		}
		System.out.print("Enter the DVD year: ");
		year = input.nextInt();
		while(year <= 0)
		{
			System.out.println("Enter valid year:");
			year = input.nextInt();
		}

		System.out.print("Enter the DVD price: ");
		price = input.nextDouble();
		while(price <= 0)
		{
			System.out.println("Enter valid price:");
			price = input.nextDouble();
		}

		System.out.print("Enter the DVD title: ");
		title = input.next();
		while(title == "")
		{
			System.out.println("Enter valid title:");
			title = input.next();		
		}

		System.out.print("Enter the DVD director: ");
		director = input.next();
		while(director == "")
		{
			System.out.println("Enter valid director:");
			director = input.next();		
		}

		dvd.add(new Dvd(dvdcode, director, title, year, price, inventory));

		return;
    }
    
    //method to remove book from catalog

	public static void removeBook ()
	{
		int isbnNum=0;
		System.out.println("Please enter the ISBN number of the book you want to remove:");
		isbnNum = input.nextInt();
		for(int i = 0; i < book.size(); i++)
        {
        if(isbnNum == (book.get(i)).getISBN())
        {
			book.remove(i);
        System.out.println("This book has been succesfully removed.");
        return;
		}

		System.out.println("This book does not exist in the Catalog.");
		return;
		}
	}	

	//method to remove dvd from catalog

	public static void removeDvd ()
	{
		int dvdCode=0;
		System.out.println("Please enter the DVD Code of the DVD you want to remove:");
		dvdCode = input.nextInt();
		for(int i = 0; i < dvd.size(); i++)
        {	
		if (dvdCode == dvd.get(i).getDvdCode ())
		{
			dvd.remove(i);
		System.out.println("This DVD has been successfully been removed.");
		return;
		}

		System.out.println("This DVD does not exist in the Catalog.");
		return;
		}
    }
    //to display both books and dvds in the catalog
    public static void displayAll(){
		
		//Displays an error message when user tries to display an empty catalog
		if(book.isEmpty() && dvd.isEmpty()){
			System.out.println("\nThe catalog is empty");
			return;
		}
		//Otherwise displays the catalog
		else{
			System.out.println();
			System.out.println("CATALOG:");
			System.out.println("--------");
			for(int i = 0; i < book.size(); i++){
				System.out.println(book.get(i));
			}
			if(!book.isEmpty() & !dvd.isEmpty())
				System.out.println("-----------------------------------------------------------------------------------------------------------------");
			for(int i = 0; i < dvd.size(); i++){
				System.out.println(dvd.get(i));
			}	
		}
	}

    public static void createBackup(){
		FileOperations fo = new FileOperations();
		
		fo.fileBackup(book, dvd);
	}


        //customer section
        // this contains all the sections of the code that will deal with customer side

        // connecting the user options to customer methods
        public static void CustomerMain()
        {
            int choice = 0;
            int customerChoice = 0;
            while (choice!= 8)
            {
           choice = CustomerMenu();

           switch (choice){
           case 1:
						{
                        displayBooks();
                        break;
                        }
                 
            case 2:
					    {
                        displayDvd();
                        break;
                        }  
             case 3:
						{
                        customerChoice = getInventoryNumber();
                        
                        if(customerChoice >= 1 && customerChoice <= book.size()){ //For valid choices, adds the specific
                        //book to the cart
                        for(int i = 0; i < book.size(); i++) 
                        {
                        if(customerChoice == book.get(i).getInv())
                        {
                        cart.add(new Cart(book.get(i).getTitle(), book.get(i).getPrice()));
                        }
                        }
                        }
                        else{ //For invalid choices displays error message
                        System.out.println("The inventory number is invalid");
                        break;
                        }}
            case 4:
						{
                            customerChoice = getInventoryNumber();
                            if(customerChoice >= 1 && customerChoice <= dvd.size()){ //For valid choices, adds the specific
                                //book to the cart
                            for(int i = 0; i < dvd.size(); i++) {
                            if(customerChoice == dvd.get(i).getInv()){
                            cart.add(new Cart(dvd.get(i).getTitle(), dvd.get(i).getPrice()));
                            break;
                            }
                            }
                            }
                            else{ //For invalid choices displays error message
                            System.out.println("The inventory number is invalid");
                            break;
                            }
                        }
            case 5: //delete book from cart 
						{
                            customerChoice = getInventoryNumber();
                            if(customerChoice >= 1 && customerChoice <= book.size()){ //For valid choices, adds the specific
                                //book to the cart
                            for(int i = 0; i < book.size(); i++) {
                            if(customerChoice == book.get(i).getInv()){
                            cart.remove(i);
                            break;
                            }
                            }
                            }
                            else{ //For invalid choices displays error message
                            System.out.println("The inventory number is invalid");
                            break;
                            }
                    
                        } 
            case 6: //delete dvd from cart
						{
                            customerChoice = getInventoryNumber();
                            if(customerChoice >= 1 && customerChoice <= dvd.size()){ //For valid choices, adds the specific
                                //book to the cart
                            for(int i = 0; i < dvd.size(); i++) {
                            if(customerChoice == dvd.get(i).getInv()){
                            cart.remove(i);
                            break;
                            }
                            }
                            }
                            else{ //For invalid choices displays error message
                            System.out.println("The inventory number is invalid");
                            break;
                            }}
						
						
            case 7: //cart
            {
                displayCart();
                break;
            
            }

            case 8: 
                    {displayCart();
					System.out.println("------------------------");
					//Displays the total price plus tax
					System.out.printf("%-17s$%6.2f\n", "Total + tax", getTotal());}

            case 9: System.out.println("Thank you for shopping at Comets Books and DVDs Store. Goodbye!");
						break; //Displays goodbye message and exits the program
			default: System.out.println("This option is not acceptable."); //Redisplays menu for invalid choice
						 CustomerMenu();
						 choice = input.nextInt();                  
                        
            }
        }
        }


        //main menu for customer side of program
        public static int CustomerMenu()	
        {
            Scanner input = new Scanner(System.in);
            int x = 0;
            
            System.out.println ("\nChoose from the following options:");
            System.out.println ("1 - Browse books inventory (price low to high)");
            System.out.println ("2 - Browse DVDs inventory (price low to high)");
            System.out.println ("3 - Add a book to the cart");
            System.out.println ("4 - Add a DVD to the cart");
            System.out.println ("5 - Delete a book from cart");
            System.out.println ("6 - Delete a DVD from cart");
            System.out.println ("7 - View Cart");
            System.out.println ("8 - CheckOut");
            System.out.println ("9 - Done Shopping\n");
            
            x = input.nextInt(); //taking input from user
            
            if (x < 1 || x > 8)  
            {
                System.out.println ("Hmmm, we don't seem to have this option!");
                System.out.println ("Fortunately, we do have valid options 1 through 8, so maybe try those!");
                    
                    return x;
            }
            else 
            {
                return x;
            }
            
        }

        //to display books in store
        public static void displayBooks(){
            ArrayList<Books> tempBook = new ArrayList<>();
            for(int i = 0; i < book.size(); i++){
                tempBook.add(book.get(i));
            }
            
            Collections.sort(tempBook);
            
            System.out.printf("%-20s%-23s%6s", "Inventory Number", "Books", "Prices"); //Heading
            System.out.println("\n-------------------------------------------------");
            //Displays the table of books
            for(int i = 0; i < tempBook.size(); i++){
                System.out.printf("%-20s%-22s$%6.2f%n", tempBook.get(i).getInv(), tempBook.get(i).getTitle(), tempBook.get(i).getPrice());
            }
        }

        //to display dvds in store
        public static void displayDvd(){
            ArrayList<Dvd> temporaryDVD = new ArrayList<>();
            for(int i = 0; i < dvd.size(); i++){
                temporaryDVD.add(dvd.get(i));
            }
            
            Collections.sort(temporaryDVD);
            
            System.out.printf("%-20s%-23s%6s", "Inventory Number", "Dvds", "Prices"); //Heading
            System.out.println("\n-------------------------------------------------");
            //Displays the table of dvds
            for(int i = 0; i < temporaryDVD.size(); i++){
                System.out.printf("%-20s%-22s$%6.2f%n", temporaryDVD.get(i).getInv(), temporaryDVD.get(i).getTitle(), temporaryDVD.get(i).getPrice());
            }
        }

        
        public static int getInventoryNumber(){
            int inv = 0;
            System.out.print("Enter the inventory number you wish to purchase/remove");
            inv = input.nextInt(); //Takes input from user for the inventory number
            
            return inv; //Returns the choice
        }

        //to display
        public static void displayCart(){
            if(cart.isEmpty()){ //Checks whether cart is empty
                System.out.println("Your cart is empty.");
                return;
            }
            
            System.out.printf("%-17s%7s", "Items", "Prices"); //Heading
            System.out.println("\n------------------------");
            //Table body for cart items
            for(int i = 0; i < cart.size(); i++){
                System.out.print(cart.get(i));
            }
        }


        //method to calculate total of cart
        public static double getTotal(){
            double total = 0.0;
            
            //Calculation for total price of all the items in the cart
            for(int i = 0; i < cart.size(); i++){
                total += cart.get(i).getPrice();
            }
            total *= 1.0825; // Addition of 8.25% tax
            
            return total; //Returns total
        }
        
        
    }
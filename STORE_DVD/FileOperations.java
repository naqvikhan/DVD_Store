import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

public class FileOperations {
	File authFile = new File("credentials.txt");
	Scanner files;
	
	public boolean userAuthentication(String user, String pass){
		try{
			files = new Scanner(authFile);
			while(files.hasNextLine()){
				String[] a = {"", ""};
				String line = files.nextLine();
				a = line.split(",");
				if(user.equals(a[0]) && pass.equals(a[1])){
					System.out.println("\nSuccessfully logged in...");
					return true;
				}
			}
			System.out.println("\nAuthentication failed...");
		}catch(FileNotFoundException fnfx){
			System.out.println("File " + fnfx + " was not found.");
			return false;
		}finally{
			files.close();			
		}
		return false;
	}
	
	public void fileBackup(ArrayList<Books> book, ArrayList<Dvd> dvd){
		Date currentTime = new Date();
		String timeFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(currentTime);
		String fileName = "catalog_backup_" + timeFormat + ".txt";
		
		if(book.isEmpty() && dvd.isEmpty()){
			System.out.println("\nThe catalog is empty");
			return;
		}
		else{
			try(PrintWriter pw = new PrintWriter(fileName)){
				pw.println("Catalog (" + timeFormat + "):");
				pw.println("------------------------------");
				for(int i = 0; i < book.size(); i++){
					pw.println(book.get(i));
				}
				if(!book.isEmpty() & !dvd.isEmpty())
					pw.println("-----------------------------------------------------------------------------------------------------------------");
				for(int i = 0; i < dvd.size(); i++){
					pw.println(dvd.get(i));
				}
				System.out.println("Backup created successfully...");
			}catch(FileNotFoundException fnfx){
				System.out.println("File " + fnfx + " was not found.");
			}
		}
	}
}
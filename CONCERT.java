import javax.swing.JOptionPane;
import java.io.*;
public class CONCERT
{
   //array of customer objects
   private CUSTOMER customerList[];
   // number of customers to be calculated after reading file
   int NoOfCustomers;
   FILEREADCSV customerFile;
   
   public CONCERT()
   { 
       // initialise instance variables
       customerFile = new FILEREADCSV(); 
   }
   
   public void processCustomer() throws IOException
   {
       setUpCustomerList();
       showyear();
       countmethod();
       counttotal();
       savefridaynightfile();
   }
   
   public void setUpCustomerList() throws IOException
   {
       //first user message
       System.out.println("Concert Sales: Customer Update");
       System.out.println("** Preparing to read data file");
       // read file, fetch data as String array containing the rows
       String[] dataRows = customerFile.readCSVtable();
       // calculate the number of customer rows with customer details
       NoOfCustomers = dataRows.length;
       // ipdate user 
       System.out.println("**" + NoOfCustomers + " rows read.\n\n");
       customerList = new CUSTOMER[NoOfCustomers];
       for (int i = 0; i < NoOfCustomers; i++)
       {
           customerList[i] = new CUSTOMER();
           customerList[i].readCustomerDetails(dataRows[i]);
       }
   }
   
   public void showyear()
   {
       //placeholder
   }
   
   public void countmethod()
   {
       //placeholder
   }
   
   public void counttotal()
   {
       //placeholder
   }
   
   public void savefridaynightfile()
   {
       //placeholder
   }
}
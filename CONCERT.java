import javax.swing.JOptionPane;
import java.io.*;
import java.time.*;
public class CONCERT
{
    //array of customer objects
    private CUSTOMER customerList[];
    // number of customers to be calculated after reading file
    int NoOfCustomers;
    FILEREADCSV customerFile;
    FILEWRITECSV resultFile;

    public CONCERT()
    { 
        // initialise instance variables
        customerFile = new FILEREADCSV(); 
        resultFile  = new FILEWRITECSV();
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
        System.out.println(Year.now().getValue() + "\n");
    }

    public void countmethod()
    {
        //placeholder
        System.out.print("A report of which method was used the most : ");
        // start the count
        int countS = 0;
        int countW = 0;
        // loop for each item : member
        for (int i = 0; i < NoOfCustomers; i++)
        {
            // decide if current item: member matches target: bmi
            if (customerList[i].getmethod() == 'S')
            {
                // add 1 to count: for OK bmi
                countS = countS + 1;
            }
            else if (customerList[i].getmethod() == 'W')
            {
                countW = countW + 1;
            }
        }

        if (countS > countW)
        {
            System.out.println("\n Most customers bought tickets in the school");
        }
        else if (countS < countW)
        {
            System.out.println("\n Most customers bought tickets on the website");
        }
        else
        {
            System.out.println("\n Same number of customers bought tickets in school and on the website");
        }
        // A blank line to separate this report from others.
        System.out.println();
    }

    public void counttotal()
    {
        // start the count 
        float total = 0.00f; 
        for (int i = 0; i < NoOfCustomers; i++)
        { if  ((customerList[i].getnight().equals ("F1")) || (customerList[i].getnight().equals ("F2")) || (customerList[i].getnight().equals ("F3")))
            {
                total = total + customerList[i].getNumOfTickets()*10; 
            } 
            else 
            {
                total = total + customerList[i].getNumOfTickets()*5;
            }
        }
        System.out.print("total money raised for charity : £" + total );
    }

    public void savefridaynightfile() throws IOException
    {
        // placeholder
        String fileContent = ""; 
        int count = 0;
        for (int i = 0; i < NoOfCustomers; i ++) 

        { 

            if ((customerList[i].getnight().equals ("F1")) || (customerList[i].getnight().equals ("F2")) || (customerList[i].getnight().equals ("F3")))
            { 
                count = count + 1; 

                if (count>1) 
                { 
                    fileContent = fileContent.concat("\n"); 
                } 
                fileContent = fileContent.concat(customerList[i].writeDetails());
            }
        } 

        System.out.println("** Preparing to write friday night file.");
        resultFile.writeCSVtable(fileContent);
        System.out.println(" ** File written and closed.**");

    }
}
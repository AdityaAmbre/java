// JAVA - MySQL Database Connectivity [JDBC].
/*
 * @Author: Aditya Ambre 
 * @Date: 2021-01-09 11:25:00 
 * @Last Modified by: Aditya Ambre
 * @Last Modified time: 2021-01-10 16:00:02
 */

// Import java-sql package.
import java.sql.*;
import java.util.Scanner;

class DB extends App{
    static int n;
    // Establish Connection to DB.
    public static void connect(){
        try{
            Class.forName(driver);  // Register JDBC Driver
            Connection con = DriverManager.getConnection(url, user, pass);  // Connect to DB
            Statement smt = con.createStatement();  // Creating a Statement
            if(n>1)
                smt.executeUpdate(sql);  // Update the DB
            else{
                sql = "SELECT * FROM laptop";  // Query [TABLE: 'laptop' & COLUMNS: 'id:name:price:stock']
                ResultSet rs = smt.executeQuery(sql);  // Execute the Query
                // Display DB Results.
                System.out.println("\n\nLaptop Details: \n\n " + "Id" + " " + "Name" + "\t" + "Price" + "\t" + "Stock");
                while(rs.next()){
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    int price = rs.getInt("price");
                    String stock = rs.getString("stock");
                    System.out.println("\n " + id + ". " + name + "\t$" + price + "\t" + stock);
                }
                rs.close();
            }
            smt.close();
            // Terminate Connection to DB.
            con.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    // User's Choice Menu for Executing Query.
    static void choice(){
        boolean x=true;
        while(x==true){  // Loop User's Choice Menu until EXIT
            System.out.print("\n<-- Privileges --> \n\n 1. Select DB\n 2. Insert DB\n 3. Update DB\n 4. Delete DB\n 5. EXIT DB\n\n");
            System.out.print("Enter your choice: ");
            n = sc.nextInt();
            switch(n){
                case 1:
                    sql = "SELECT id, name, price, stock FROM laptop";
                    DB.connect();
                    break;
                case 2:
                    sql = "INSERT INTO laptop (name, price, stock) VALUES ('MACBOOK', 2013.45, 'Yes'), ('LENOVO', 496, 'No'), ('SURFACE', 2345.99, 'Yes'), ('HP', 537, 'No')";
                    System.out.println("\n Columns Inserted Successfully!\n");
                    DB.connect();
                    break;
                case 3:
                    sql = "UPDATE laptop SET stock='No' WHERE name='MACBOOK'";
                    System.out.println("\n Columns Updated Successfully!\n");
                    DB.connect();
                    break;
                case 4:
                    sql = "DELETE FROM laptop WHERE name='HP'";
                    System.out.println("\n Columns Deleted Successfully!\n");
                    DB.connect();
                    break;
                case 5:
                    System.out.println("\n Shutting Down ....\n\n DB Closed Successfully!\n");
                    x=false;  // EXIT Loop
                    break;
                default:
                    System.out.println("\n Incorrect Choice!");
                    break;
            }
        }
        sc.close();
    }
}

public class App{
    static final String driver = "com.mysql.cj.jdbc.Driver";  // JDBC Driver
    static final String url = "jdbc:mysql://localhost/computers";  // DB Url [DB: 'computers']
    static final String user = "root";  // DB Username
    static final String pass = "";  // DB Password
    static Scanner sc = new Scanner(System.in);
    static String sql = "";  // Query
    // Main Method.
    public static void main(String args[]){
        DB.connect();
        DB.choice();
    }
}

// Copyrights © - 2021 By, Aditya Ambre. │ All Rights Reserved.
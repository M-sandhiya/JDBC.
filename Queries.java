import java.sql.*;
import java.util.Scanner;

public class Queries
{
    public static void selectQuery(String name) throws ClassNotFoundException, SQLException
    {
        String url="jdbc:mysql://localhost:3306/bank";
        String username="root";
        String password="root123";
        Class.forName("com.mysql.cj.jdbc.Driver");
        // System.out.println("Driver classLoading");
        Connection con= DriverManager.getConnection(url,username,password);

        PreparedStatement ps=con.prepareStatement("select balance_amount from customer where cus_name=?;");
        ps.setString(1,name);
        ResultSet rs=ps.executeQuery();
        while(rs.next())
        {
            System.out.println(rs.getInt("balance_amount"));
        }


//        Statement s=con.createStatement();
//        ResultSet rs=s.executeQuery("select * from customer ");

//        while(rs.next())
//        {
//            System.out.println(rs.getInt("cus_accNo")+" "+rs.getInt("cus_pin")+" "+
//                    rs.getString("cus_name")+" "+rs.getInt("balance_amount")+" "+
//                    rs.getString("acc_type")+" "+rs.getString("cus_panNo")+" "+
//                    rs.getString("cus_contactNo")+" "+rs.getString("cus_address")+" "+
//                    rs.getString("branch_id"));
//        }
    }

    public static void insertQuery(int c_accNo,int c_pin,String c_name,int acc_balance,String acc_type,String c_panNo,
                                   String c_contact,String c_address,String b_id) throws ClassNotFoundException, SQLException
    {
        String url = "jdbc:mysql://localhost:3306/bank";
        String username = "root";
        String password = "sandhiya1012";
        Class.forName("com.mysql.cj.jdbc.Driver");
        // System.out.println("Driver classLoading");
        Connection con = DriverManager.getConnection(url, username, password);
        PreparedStatement ps = con.prepareStatement("insert into customer values(?,?,?,?,?,?,?,?,?)");
        ps.setInt(1, c_accNo);
        ps.setInt(2, c_pin);
        ps.setString(3, c_name);
        ps.setInt(4, acc_balance);
        ps.setString(5, acc_type);
        ps.setString(6, c_panNo);
        ps.setString(7, c_contact);
        ps.setString(8, c_address);
        ps.setString(9, b_id);

        int row = ps.executeUpdate();
        if (row > 0)
        {
            System.out.println("values are inserted");
        } else
        {
            System.out.println("values are not inserted");
        }
    }

    public static void updateCustomer(String id,int pin,String phone) throws ClassNotFoundException, SQLException
    {
        String url = "jdbc:mysql://localhost:3306/bank";
        String username = "root";
        String password = "sandhiya1012";
        Class.forName("com.mysql.cj.jdbc.Driver");
        // System.out.println("Driver classLoading");
        Connection con = DriverManager.getConnection(url, username, password);
        PreparedStatement ps = con.prepareStatement("update customer set cus_pin=?,cus_contactNo=? where branch_id=?;");
        ps.setInt(1,pin);
        ps.setString(2,phone);
        ps.setString(3,id);
        int row=ps.executeUpdate();
        if(row>0)
        {
            System.out.println("values are updated successfully");
        }
        else
        {
            System.out.println("values are not updates successfully");
        }
    }


    public static void main(String[] args) throws ClassNotFoundException, SQLException
    {
        //select
        Scanner sc=new Scanner(System.in);

        System.out.println("enter the name");
        String name=sc.next();
        System.out.println("balance amount");

        selectQuery(name);




        //insert

        //Scanner sc=new Scanner(System.in);

        System.out.println("enter the c_accNo");
        int c_accNo=sc.nextInt();

        System.out.println("enter the c_pin");
        int c_pin=sc.nextInt();

        System.out.println("enter the c_name");
        String c_name=sc.next();

        System.out.println("enter the acc_balance");
        int acc_balance=sc.nextInt();

        System.out.println("enter the acc_type");
        String acc_type=sc.next();

        System.out.println("enter the c_panNo");
        String c_panNo=sc.next();

        System.out.println("enter the c_contact");
        String c_contact=sc.next();

        System.out.println("enter the c_address");
        String c_address=sc.next();

        System.out.println("enter the b_id");
        String b_id=sc.next();

        insertQuery(c_accNo, c_pin,c_name,acc_balance,acc_type,c_panNo,c_contact,c_address,b_id);

        //update

        //Scanner sc=new Scanner(System.in);

        System.out.println("enter the id");
        String id=sc.next();

        System.out.println("enter the pin number");
        int pin=sc.nextInt();

        System.out.println("enter the phone number");
        String phone=sc.next();

        updateCustomer(id,pin,phone);

    }

}

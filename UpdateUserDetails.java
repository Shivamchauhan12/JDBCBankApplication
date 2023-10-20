import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Statement;

public class UpdateUserDetails
{
    public void UpdateUserDetails(Connection conn,int Account_no)
    {
        System.out.println("Enter a if you want to update the Account Email Id");
        System.out.println("Enter b if you want to update the Account Mobile Number");
        Scanner sc=InputTaker.getScanner();
        String UpdateField=sc.nextLine();
        if(UpdateField.equalsIgnoreCase("a")) {
            System.out.println("Enter Email_id");
            String email=sc.nextLine();
            if(!UpdateField.contains("@"))
            {
             String set="UPDATE user set Email_id='"+email+"'where Account_no="+Account_no;
             try{
                Statement st=conn.createStatement();
                int status =st.executeUpdate(set);
                if(status>0){
                    System.out.println("User email is Updated!!!");
                }else{
                    System.out.println("Unknown Server Error");
                    return;
                }
                conn.close();
             }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
          }
        }
        if(UpdateField.equalsIgnoreCase("b")) {
            System.out.println("Enter Mobile Number");
            String Update_mobile=sc.nextLine();

            String set="UPDATE user set  Mobile_no='"+Update_mobile+"'where Account_no="+Account_no;
                try{
                    Statement st=conn.createStatement();
                    int status =st.executeUpdate(set);
                    if(status>0){
                        System.out.println("User Mobile Number is Updated!!!");
                    }else{
                        System.out.println("Unknown Server Error");
                        return;
                    }
                    conn.close();
                }catch(SQLException ex){
                    System.out.println(ex.getMessage());
                }

        }
    }
}

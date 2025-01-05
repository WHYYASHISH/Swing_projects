import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DbDemo {
    public static void main(String[] args) {
        createTableForReg();
    }

    private static void createTableForReg() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "9889");
            Statement st = con.createStatement();
            String query = "create table reg(id int,name varchar(20),\n"
                    + "       city varchar(20),gender varchar(20),\n"
                    + "       address varchar(20),gmail varchar(30),password varchar(20))";
            int i = st.executeUpdate(query);
            System.out.println("Create Table....");
        } catch (Exception e) {
            System.out.println("failed....");
            e.printStackTrace();
        }
    }
}
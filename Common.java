import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



public class Common {



    public static void getLabel(JFrame frame, String title, int x, int y, int w, int h) {

        JLabel label = new JLabel(title);

        label.setBounds(x, y, w, h);

        frame.add(label);

    }



    public static JComboBox getDropDown(JFrame frame, int x, int y, int w, int h) {

        JComboBox box = new JComboBox();

        box.setBounds(x, y, w, h);

        frame.add(box);

        return box;

    }



    public static JTextField getTextBox(JFrame frame, int x, int y, int w, int h) {

        JTextField field = new JTextField();

        field.setBounds(x, y, w, h);

        frame.add(field);

        return field;

    }



    public static JButton getBtn(JFrame frame, String title, int x, int y, int w, int h) {

        JButton btn = new JButton(title);

        btn.setBounds(x, y, w, h);

        frame.add(btn);

        return btn;

    }



    public static JPasswordField getPasswordTextBox(JFrame frame, int x, int y, int w, int h) {

        JPasswordField field = new JPasswordField();

        field.setBounds(x, y, w, h);

        frame.add(field);

        return field;

    }



    public static Connection getConnection(String demo) {

        Connection con = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + demo, "root",

                    "9889");

        } catch (Exception e) {

            e.printStackTrace();

        }

        return con;
    }

    
    


    
}
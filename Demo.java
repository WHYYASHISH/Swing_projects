import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo {
    public static void main(String[] args) {
        getSignUpPage();
    }

    public static void getSignUpPage() {

        JFrame frame = new JFrame();
        frame.setBounds(100, 100, 300, 500);

        JLabel label = new JLabel("Demo Page");
        label.setBounds(80, 50, 100, 30);
        frame.add(label);

        JLabel name = new JLabel("Name :");
        name.setBounds(30, 80, 100, 30);
        frame.add(name);

        JTextField fieldName = new JTextField();
        fieldName.setBounds(130, 80, 100, 30);
        frame.add(fieldName);

        JLabel city = new JLabel("City :");
        city.setBounds(30, 110, 100, 30);
        frame.add(city);

        JComboBox box = new JComboBox();
        box.setBounds(130, 110, 100, 30);
        frame.add(box);

        box.addItem("-select city-");

        try {
            Connection con = Common.getConnection("demo");
            Statement st = con.createStatement();
            String query = "Select name,cid from city";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                box.addItem(rs.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel gender = new JLabel("Gender :");
        gender.setBounds(30, 140, 100, 30);
        frame.add(gender);

        JRadioButton r1 = new JRadioButton("Male");
        r1.setBounds(130, 140, 100, 30);
        frame.add(r1);

        JRadioButton r2 = new JRadioButton("Female");
        r2.setBounds(130, 170, 100, 30);
        frame.add(r2);

        ButtonGroup group = new ButtonGroup();
        group.add(r1);
        group.add(r2);

        JLabel address = new JLabel("Address :");
        address.setBounds(30, 200, 100, 30);
        frame.add(address);

        JTextField gmail = new JTextField();
        gmail.setBounds(130, 200, 100, 30);
        frame.add(gmail);

        JLabel pass = new JLabel("Password :");
        pass.setBounds(30, 230, 100, 30);
        frame.add(pass);

        JPasswordField pwd = new JPasswordField();
        pwd.setBounds(130, 230, 100, 30);
        frame.add(pwd);

        JCheckBox checkBox = new JCheckBox("Done CheckBox");
        checkBox.setBounds(30, 260, 200, 30);
        frame.add(checkBox);

        JButton button = new JButton("Submit");
        button.setBounds(40, 290, 100, 30);
        frame.add(button);

        JTextField find = new JTextField();
        find.setBounds(30, 320, 100, 30);
        frame.add(find);

        JButton findBtn = new JButton("find");
        findBtn.setBounds(30, 350, 100, 30);
        frame.add(findBtn);

        JButton updateBtn = new JButton("Update");
        updateBtn.setBounds(130, 350, 100, 30);
        frame.add(updateBtn);

        JButton deleteBtn = new JButton("Delete");
        deleteBtn.setBounds(30, 380, 100, 30);
        frame.add(deleteBtn);

        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkBox.isSelected()) {
                    String selectGender = "";
                    // text.setText(fieldName.getText());
                    // dropDown.setText(box.getSelectedItem().toString());
                    if (r1.isSelected()) {
                        selectGender = "Male";
                    } else if (r2.isSelected()) {
                        selectGender = "Female";
                    }
                    // gen.setText(selectGender);
                    // add.setText(area.getText());
                    // passw.setText(pwd.getText());

                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root",
                                "9889");
                        Statement st = con.createStatement();
                        String query = "insert into reg(id,name,city,gender,gmail,password,cngPwd) values(1,'"
                                + fieldName.getText() + "','"
                                + box.getSelectedItem() + "','" + selectGender + "','" + gmail.getText() + "','"
                                + pwd.getText() + "',0);";
                        int i = st.executeUpdate(query);
                        if (i > 0) {
                            System.out.println("insert...");
                            JOptionPane.showConfirmDialog(frame, "insert ");
                            frame.dispose();
                            Login.getLogInPage();
                        } else {
                            System.out.println("failed...");
                        }
                    } catch (Exception exp) {
                        exp.printStackTrace();
                    }

                    fieldName.setText("");
                    box.setSelectedItem("-select city-");
                    // r1.setSelected(false);
                    // r2.setSelected(false);
                    group.clearSelection();
                    gmail.setText("");
                    pwd.setText("");
                    checkBox.setSelected(false);
                } else {
                    System.out.println("select CheckBox...");
                    JOptionPane.showMessageDialog(frame, "select CheckBox...");
                }
            }

        });

        findBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root",
                            "9889");
                    Statement st = con.createStatement();
                    String query = "select * from reg where id = '" + find.getText() + "';";
                    ResultSet rs = st.executeQuery(query);
                    while (rs.next()) {
                        fieldName.setText(rs.getString("name"));
                        pwd.setText(rs.getString("password"));
                        gmail.setText(rs.getString("address"));
                        if (rs.getString("gender").equals("Male")) {
                            r1.setSelected(true);
                        } else {
                            r2.setSelected(true);
                        }

                        box.setSelectedItem("kanpur");

                    }
                } catch (Exception exp) {
                    exp.printStackTrace();
                }
            }

        });

        updateBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root",
                            "9889");
                    Statement st = con.createStatement();
                    String query = "UPDATE reg SET name = '" + fieldName.getText() + "',address='" + gmail.getText()
                            + "' where id = '" + find.getText()
                            + "'";
                    int i = st.executeUpdate(query);
                    if (i > 0) {
                        System.out.println("update");

                        fieldName.setText("");
                        box.setSelectedItem("-select city-");
                        r1.setSelected(false);
                        r2.setSelected(false);
                        gmail.setText("");
                        pwd.setText("");
                        checkBox.setSelected(false);
                    } else {
                        System.out.println("failed");
                    }

                } catch (Exception exp) {
                    exp.printStackTrace();
                }
            }

        });

        deleteBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection con = Common.getConnection("demo");

                    PreparedStatement pst = con.prepareStatement("delete from reg where id= ?");
                    pst.setString(1, find.getText());
                    // Statement st = con.createStatement();
                    int i = pst.executeUpdate();
                    if (i > 0) {
                        System.out.println("Delete");

                        fieldName.setText("");
                        box.setSelectedItem("-select city-");
                        r1.setSelected(false);
                        r2.setSelected(false);
                        gmail.setText("");
                        pwd.setText("");
                        checkBox.setSelected(false);
                    } else {
                        System.out.println("failed");
                    }
                    con.close();
                } catch (Exception exp) {
                    exp.printStackTrace();
                }
            }

        });

        frame.setLayout(null);
        frame.setVisible(true);
    }
}
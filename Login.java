import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login {

    public static void main(String[] args) {
        getLogInPage();
    }

    public static void getLogInPage() {
        JFrame frame = new JFrame();
        frame.setBounds(300, 100, 500, 300);

        // Assuming Common.getLabel creates JLabel (check Common class implementation)
        Common.getLabel(frame, "Login Page", 200, 50, 100, 30);
        Common.getLabel(frame, "User Name", 80, 80, 100, 30);
        Common.getLabel(frame, "Password", 80, 110, 100, 30);

        JTextField userName = Common.getTextBox(frame, 180, 80, 200, 30); // assuming it returns JTextField
        JPasswordField pwd = Common.getPasswordTextBox(frame, 180, 110, 200, 30); // assuming it returns JPasswordField

        JButton logIn = Common.getBtn(frame, "Login", 80, 150, 150, 30); // assuming it returns JButton
        JButton signUP = Common.getBtn(frame, "Sign up", 230, 150, 150, 30); // assuming it returns JButton

        logIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Check if fields are empty
                    if (userName.getText().equals("") || new String(pwd.getPassword()).equals("")) {
                        JOptionPane.showMessageDialog(frame, "Please fill in both fields.");
                        return;
                    }

                    // Secure database connection and query execution
                    Connection con = Common.getConnection("demo");
                    String query = "SELECT name, cngPwd FROM reg WHERE gmail = ? AND password = ?";
                    PreparedStatement st = con.prepareStatement(query);
                    st.setString(1, userName.getText());
                    st.setString(2, new String(pwd.getPassword()));
                    ResultSet rs = st.executeQuery();

                    if (rs.next()) {
                        frame.dispose(); // close the login frame

                        if (rs.getInt("cngPwd") != 0) {
                            getHome(); // Open home page
                        } else {
                            getChangePasswordPage(userName.getText()); // Open change password page
                        }
                    } else {
                        JOptionPane.showMessageDialog(frame, "Invalid user...");
                    }
                } catch (Exception exp) {
                    exp.printStackTrace();
                    JOptionPane.showMessageDialog(frame, "Database error: " + exp.getMessage());
                }
            }
        });

        signUP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Demo.getSignUpPage();  // Assuming Demo.getSignUpPage() method exists
            }
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }

    private static void getHome() {
        JFrame frame = new JFrame();
        frame.setBounds(300, 100, 500, 300);
        Common.getLabel(frame,"Home Page", 200, 50, 100, 30);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    private static void getChangePasswordPage(String userId) {
        JFrame frame = new JFrame();
        frame.setBounds(300, 100, 500, 300);
        Common.getLabel(frame,"Change Password Page", 200, 50, 100, 30);
        Common.getLabel(frame, "Old Password", 80, 80, 100, 30);
        Common.getLabel(frame, "New Password", 80, 110, 100, 30);

        JPasswordField oldPwd = Common.getPasswordTextBox(frame, 180, 80, 200, 30); // assuming it returns JPasswordField
        JPasswordField newPwd = Common.getPasswordTextBox(frame, 180, 110, 200, 30); // assuming it returns JPasswordField

        JButton changePwd = Common.getBtn(frame, "Change Password", 80, 150, 150, 30); // assuming it returns JButton

        changePwd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Check if password fields are empty
                    if (new String(oldPwd.getPassword()).equals("") || new String(newPwd.getPassword()).equals("")) {
                        JOptionPane.showMessageDialog(frame, "Please fill in both fields.");
                        return;
                    }

                    // Secure database connection and password update
                    Connection con = Common.getConnection("demo");
                    String query = "UPDATE reg SET password = ?, cngPwd = 1 WHERE gmail = ? AND password = ?";
                    PreparedStatement st = con.prepareStatement(query);
                    st.setString(1, new String(newPwd.getPassword()));
                    st.setString(2, userId);
                    st.setString(3, new String(oldPwd.getPassword()));

                    int i = st.executeUpdate();
                    if (i > 0) {
                        JOptionPane.showMessageDialog(frame, "Password updated successfully.");
                        frame.dispose();
                        getLogInPage(); // Show login page again after password change
                    } else {
                        JOptionPane.showMessageDialog(frame, "Failed to update password. Please check old password.");
                    }
                } catch (Exception exp) {
                    exp.printStackTrace();
                    JOptionPane.showMessageDialog(frame, "Database error: " + exp.getMessage());
                }
            }
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }
}

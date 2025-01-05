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

public class Display {
    public static void main(String[] args) {

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
        box.addItem("Kanpur");
        box.addItem("Unnao");

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

        JTextArea area = new JTextArea();
        area.setBounds(130, 200, 100, 30);
        frame.add(area);

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

        JLabel text = new JLabel("");
        text.setBounds(30, 320, 100, 30);
        frame.add(text);

        JLabel dropDown = new JLabel("");
        dropDown.setBounds(30, 350, 100, 30);
        frame.add(dropDown);

        JLabel gen = new JLabel("");
        gen.setBounds(30, 380, 100, 30);
        frame.add(gen);

        JLabel add = new JLabel("");
        add.setBounds(30, 410, 100, 30);
        frame.add(add);

        JLabel passw = new JLabel("");
        passw.setBounds(30, 440, 100, 30);
        frame.add(passw);

        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkBox.isSelected()) {
                    String selectGender = "";
                    text.setText(fieldName.getText());
                    dropDown.setText(box.getSelectedItem().toString());
                    if (r1.isSelected()) {
                        selectGender = "Male";
                    } else if (r2.isSelected()) {
                        selectGender = "Female";
                    }
                    gen.setText(selectGender);
                    add.setText(area.getText());
                    passw.setText(pwd.getText());


                    fieldName.setText("");
                    box.setSelectedItem("-select city-");
                    r1.setSelected(false);
                    r2.setSelected(false);
                    area.setText("");
                    pwd.setText("");
                    checkBox.setSelected(false);
                } else {
                    System.out.println("select CheckBox...");
                    JOptionPane.showMessageDialog(frame, "select CheckBox...");
                }
            }

        });

        frame.setLayout(null);
        frame.setVisible(true);
    }
}
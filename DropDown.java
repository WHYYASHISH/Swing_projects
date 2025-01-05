import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class DropDown {
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setBounds(100, 100, 300, 500);

        // Common.getLabel(frame, "Demo Page", 80, 50, 100, 30);

        // JComboBox coBox = Common.getDropDown(frame, 30, 110, 200, 30);
        // JComboBox stateBox = Common.getDropDown(frame, 30, 140, 200, 30);

        // coBox.addItem("-select Country-");
        // coBox.addItem("India");
        // coBox.addItem("Us");

        // stateBox.addItem("-select State-");

        // coBox.addItemListener(new ItemListener() {

        // @Override
        // public void itemStateChanged(ItemEvent e) {

        // if (coBox.getSelectedItem().equals("India")) {
        // stateBox.removeAllItems();
        // stateBox.addItem("Up");
        // stateBox.addItem("Mp");
        // } else if (coBox.getSelectedItem().equals("Us")) {
        // stateBox.removeAllItems();
        // stateBox.addItem("-select State-");
        // stateBox.addItem("vasdsadsafadsf");
        // }
        // }
        // });

        JTextField fieldName = new JTextField();
        fieldName.setBounds(30, 110, 200, 30);
        frame.add(fieldName);

        JTextField name = new JTextField();
        name.setBounds(30, 140, 200, 30);
        frame.add(name);

        JTextField field = new JTextField();
        field.setBounds(30, 170, 200, 30);
        frame.add(field);
        field.setEditable(false);

        name.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                int a = 0, b = 0;
                a = Integer.parseInt(fieldName.getText());
                b = Integer.parseInt(name.getText());
                if (b > 0) {
                    field.setText(Integer.toString(a + b));
                } else {
                    JOptionPane.showMessageDialog(frame, "invaild data..");
                }

            }

        });

        frame.setLayout(null);
        frame.setVisible(true);


    
    }
}

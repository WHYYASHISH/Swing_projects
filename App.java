import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class App {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setBounds(300, 100, 500, 500);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 500, 500);
        panel.setBackground(Color.CYAN);
        panel.setLayout(null);
        frame.add(panel);

        JPanel headPanel = new JPanel();
        headPanel.setBounds(0, 0, 500, 40);
        headPanel.setBackground(Color.LIGHT_GRAY);
        headPanel.setLayout(null);
        headPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        panel.add(headPanel);

        JLabel label = new JLabel("Header");
        label.setBounds(30, 10, 100, 20);
        label.setFont(new Font("Arial",Font.BOLD,16));
        headPanel.add(label);
        JPanel workingPanel = new JPanel();
        workingPanel.setBounds(0, 40, 500, 300);
        workingPanel.setBackground(Color.LIGHT_GRAY);
        workingPanel.setLayout(null);
        workingPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        panel.add(workingPanel);
        int x = 20, y = 20;
        for (int i = 1; i <= 8; i++) {
            JPanel cardPanel = new JPanel();
            cardPanel.setBounds(x, y, 100, 100);
            cardPanel.setBackground(Color.LIGHT_GRAY);
            cardPanel.setLayout(null);
            cardPanel.setBorder(BorderFactory.createLineBorder(Color.black));
            workingPanel.add(cardPanel);

            JLabel label1 = new JLabel(new ImageIcon("C:\\Users\\91988\\OneDrive\\Desktop\\Java Project\\Java project\\Ashish pic"));
            label1.setBounds(0, 0, 100, 100);
            cardPanel.add(label1);

            System.out.println("card " + x);
            x += 120;
            if (x > 380) {
                y += 120;
                x = 20;
            }
        }


        frame.setLayout(null);
        frame.setVisible(true);
    }
}
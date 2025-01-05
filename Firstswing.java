import java.awt.*;
import javax.swing.*;
public class Firstswing {
    public static void main(String[]args){
        JFrame frame=new JFrame();
        frame.setBounds(100,100,250,450);
        frame.setBackground(Color.RED);
        

        JLabel label1=new JLabel("CALCULATOR");
        label1.setBounds(20,05,100,50);
        frame.add(label1);
        
        JLabel label2=new JLabel("Standard");
        label2.setBounds(20,30,100,50);
        frame.add(label2);
       
        JLabel label3=new JLabel("0");
        label3.setBounds(200,90,60,70);
        frame.add(label3);

        JButton button1=new JButton("%");
       button1.setBounds(20,150,50,50);
       frame.add(button1);

       JButton button2=new JButton("CE");
       button2.setBounds(70,150,50,50);
       frame.add(button2);


       JButton button3=new JButton("C");
       button3.setBounds(120,150,50,50);
       frame.add(button3);

       JButton button4=new JButton("x");
       button4.setBounds(170,150,50,50);
       frame.add(button4);

       JButton button5=new JButton("1/x");
       button5.setBounds(20,200,50,50);
       frame.add(button5);

       JButton button6=new JButton("X*2");
       button6.setBounds(70,200,50,50);
       frame.add(button6);


       JButton button7=new JButton("2");
       button7.setBounds(120,200,50,50);
       frame.add(button7);

       JButton button8=new JButton("/");
       button8.setBounds(170,200,50,50);
       frame.add(button8);

       JButton button9=new JButton("7");
       button9.setBounds(20,250,50,50);
       frame.add(button9);

       JButton button10=new JButton("8");
       button10.setBounds(70,250,50,50);
       frame.add(button10);


       JButton button11=new JButton("9");
       button11.setBounds(120,250,50,50);
       frame.add(button11);

       JButton button12=new JButton("*");
       button12.setBounds(170,250,50,50);
       frame.add(button12);

       JButton button13=new JButton("4");
       button13.setBounds(20,250,50,50);
       frame.add(button13);

       JButton button14=new JButton("5");
       button14.setBounds(70,250,50,50);
       frame.add(button14);


       JButton button15=new JButton("6");
       button15.setBounds(120,250,50,50);
       frame.add(button15);

       JButton button16=new JButton("-");
       button16.setBounds(170,250,50,50);
       frame.add(button16);

       JButton button17=new JButton(" 1");
       button17.setBounds(20,300,50,50);
       frame.add(button17);

       JButton button18=new JButton("2");
       button18.setBounds(70,300,50,50);
       frame.add(button18);


       JButton button19=new JButton("3");
       button19.setBounds(120,300,50,50);
       frame.add(button19);

       JButton button20=new JButton("+");
       button20.setBounds(170,300,50,50);
       frame.add(button20);

       JButton button21=new JButton("+/-");
       button21.setBounds(20,350,50,50);
       frame.add(button21);

       JButton button22=new JButton("0");
       button22.setBounds(70,350,50,50);
       frame.add(button22);


       JButton button23=new JButton(".");
       button23.setBounds(120,350,50,50);
       frame.add(button23);

       JButton button24=new JButton("=");
       button24.setBounds(170,350,50,50);
       frame.add(button24);

       

       








        frame.setLayout(null);
        frame.setVisible(true);


    }
}

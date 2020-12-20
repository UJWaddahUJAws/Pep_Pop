
package pep_pop_games;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class login extends JFrame implements ActionListener {

    JPanel info = new JPanel();
    JPanel i = new JPanel();

    JTextField txtusername = new JTextField(10);
    JPasswordField txtpass = new JPasswordField(15);
    JLabel lblusername = new JLabel("Enter your User Name:");
    JLabel lblpass = new JLabel("Enter your Password:");
    JButton b = new JButton("Enter");
    JPanel x = new JPanel();

    public login() {

        setSize(800, 500);
        setContentPane(new JLabel(new ImageIcon("C:\\Users\\wddah\\Desktop\\x.gif")));
        i.setBackground(Color.DARK_GRAY);
        info.setBackground(new Color(106, 75, 53));
        info.setSize(210, 110);
        setSize(800, 500);

        info.setBounds(225, 150, 350, 200);
        i.setBounds(215, 140, 370, 220);

        b.addActionListener(this);
        lblusername.setBackground(Color.BLUE);
        add(lblusername).setBounds(250, 180, 200, 40);
        add(txtusername).setBounds(400, 180, 150, 30);
        add(lblpass).setBounds(250, 230, 200, 40);
        add(txtpass).setBounds(400, 230, 150, 30);
        add(b).setBounds(325, 300, 150, 30);

        lblusername.setForeground(Color.lightGray);
        lblpass.setForeground(Color.LIGHT_GRAY);

        add(info);
        add(i);

        setTitle("Login");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }

  
    @Override
    public void actionPerformed(ActionEvent ae) {

        if (txtusername.getText().matches("[A-Z][A-Za-z0-9-._]+")) {

            if (txtpass.getText().matches("[A-Za-z0-9@*]{3,}")) {
                try {
                    Scanner in = new Scanner(new File("C:\\Users\\wddah\\Desktop\\gg.txt"));
                    while (in.hasNextLine()) {
                        String s = in.nextLine();
                        String[] sArray = s.split(",");
                      
                        
                        if (txtusername.getText().equals(sArray[0]) && txtpass.getText().equals(sArray[1])) {
                            Pep_Pop_Games x = new Pep_Pop_Games();
                            setVisible(false);
                        } else {
                            String message = "You are not registered yet :(";
                            JOptionPane.showMessageDialog(new JFrame(), message, "Error",
                                    JOptionPane.ERROR_MESSAGE);
                            break;
                        }
                    }

                    in.close();

                } catch (FileNotFoundException e) {
                    JOptionPane.showMessageDialog(null,
                            "User Database Not Found", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }

            } else {
                String message = "Please Enter a Valid password :(";
                JOptionPane.showMessageDialog(new JFrame(), message, "Error",
                        JOptionPane.ERROR_MESSAGE);

            }
        } else {
            String message = "User name is incorrect, please enter a valid User name :(";
            JOptionPane.showMessageDialog(new JFrame(), message, "Error",
                    JOptionPane.ERROR_MESSAGE);

        }

    }

}
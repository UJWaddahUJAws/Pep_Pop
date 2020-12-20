/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pep_pop_games;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class register extends JFrame implements ActionListener {

    JPanel info = new JPanel();
    JPanel i = new JPanel();

    JLabel lblusername = new JLabel("Enter your User Name:");
    JTextField txtusername = new JTextField(10);
    JLabel lblpass = new JLabel("Enter your Password:");
    JPasswordField txtpass = new JPasswordField(15);
    JLabel lblpassagain = new JLabel("Enter Password again:");
    JPasswordField txtpassagain = new JPasswordField(15);

    JButton b = new JButton("Login");

    public register() throws IOException {

        setContentPane(new JLabel(new ImageIcon("C:\\Users\\wddah\\Desktop\\x.gif")));
        i.setBackground(Color.DARK_GRAY);
        info.setBackground(new Color(106, 75, 53));
        info.setSize(210, 110);
        setSize(800, 500);

        info.setBounds(225, 130, 350, 220);
        i.setBounds(215, 120, 370, 240);

        lblusername.setBackground(Color.BLUE);
        add(lblusername).setBounds(250, 150, 200, 40);
        add(txtusername).setBounds(400, 150, 150, 30);
        add(lblpass).setBounds(250, 200, 200, 40);
        add(txtpass).setBounds(400, 200, 150, 30);
        add(lblpassagain).setBounds(250, 250, 200, 40);
        add(txtpassagain).setBounds(400, 250, 150, 30);
        add(b).setBounds(325, 300, 150, 30);
        b.addActionListener(this);

        lblusername.setForeground(Color.lightGray);
        lblpass.setForeground(Color.LIGHT_GRAY);
        lblpassagain.setForeground(Color.LIGHT_GRAY);

        setTitle("Register");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(800, 500);
        add(info);
        add(i);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (txtusername.getText().matches("[A-Z][A-Za-z0-9-._]+")) {
        
            if (txtpass.getText().matches("[A-Za-z0-9@*]{3,}")) {
            
                if (txtpass.getText().equals(txtpassagain.getText())) {
                    if (b == ae.getSource()) {
                        try {
                            login x = new login();
                        } catch (Exception ex) {
                            System.out.println(ex.getMessage());
                        }
                        setVisible(false);
                    }

                    if (ae.getSource() == b) {

                        try {
                            PrintWriter out = new PrintWriter(new FileWriter("C:\\Users\\wddah\\Desktop\\gg.txt"));

                            txtusername.getText();
                            txtusername.write(out);
                            
                            out.format(",");

                            txtpass.getText();
                            txtpass.write(out);
                            
                            
                            out.close();

                        } catch (IOException e1) {
                            System.err.println("Error occurred");
                            e1.printStackTrace();
                        }
                    }

                } else {
                    while (!txtpass.getText().equals(txtpassagain.getText())) {
                        String message = "Password doesn't match :(";
                        JOptionPane.showMessageDialog(new JFrame(), message, "Error",
                                JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                }
            } 

        }

    }

}

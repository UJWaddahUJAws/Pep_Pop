/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pep_pop_games;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Gola extends JFrame implements ActionListener {

    JPanel info = new JPanel();
    JPanel i = new JPanel();

    JLabel hi = new JLabel("Welcome to Chess game ^v^..");
    JButton login = new JButton("Login");
    JButton regist = new JButton("Register");

    JLabel pic = new JLabel(new ImageIcon("C:\\Users\\aws-a\\Desktop\\welcome2.png"));

    public Gola() {

        setContentPane(new JLabel(new ImageIcon("C:\\Users\\wddah\\Desktop\\x.gif")));

        i.setBackground(Color.DARK_GRAY);
        info.setBackground(new Color(106, 75, 53));
        info.setSize(210, 110);
        setSize(800, 500);
        pic.setBounds(150, 10, 500, 500);

        login.addActionListener(this);
        regist.addActionListener(this);
        info.setBounds(225, 150, 350, 200);
        i.setBounds(215, 140, 370, 220);

        //add(hi).setBounds(315, 180, 200, 40);
        add(login).setBounds(240, 300, 150, 30);
        add(regist).setBounds(415, 300, 150, 30);

        hi.setForeground(Color.lightGray);

        add(pic);
        add(info);
        add(i);
        setTitle("Welcome");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }

    public static void main(String[] args) throws IOException {
        new Gola();

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (regist == ae.getSource()) {

            try {
                register x = new register();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            setVisible(false);
        }
        if (login == ae.getSource()) {

            try {
                login x = new login();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            setVisible(false);
        }

    }

}

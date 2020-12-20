/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pep_pop_games;
/**
 *
 * @author aws-a
 */
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import sun.applet.Main;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Pep_Pop_Games extends JFrame implements ActionListener {

    static boolean shouldStop = false;

    static void stopPlayback() {
        shouldStop = true;
    }

    JPanel info = new JPanel();
    JPanel i = new JPanel();
    

    JButton a = new JButton();
    JButton b = new JButton();
    JButton c = new JButton();
    JButton d = new JButton();

    JButton meow = new JButton();
    
    JPanel x = new JPanel();
    ImageIcon a_pic = new ImageIcon("home\\a1.gif");
    ImageIcon b_pic = new ImageIcon("home\\b1.gif");
    ImageIcon c_pic = new ImageIcon("home\\c1.gif");
    ImageIcon d_pic = new ImageIcon("home\\d1.gif");
    

    Clip clip;

    private boolean isCollided = false;

    public Pep_Pop_Games() {

        try {
            File file = new File("snake\\x.wav"); 
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(file));
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        } catch (Exception e) {
            System.err.println("");
        }

        setContentPane(new JLabel(new ImageIcon("home\\LASTONEX.gif")));

        a.setIcon(a_pic);
        b.setIcon(b_pic);
        c.setIcon(c_pic);
        d.setIcon(d_pic);

      
        a.addActionListener(this);
        b.addActionListener(this);
        c.addActionListener(this);
        d.addActionListener(this);

        meow.addActionListener(this);
        
    
        i.setBackground(Color.DARK_GRAY);
        info.setBackground(new Color(106, 75, 53));
        info.setSize(210, 110);
        setSize(1500, 900);

        info.setBounds(40, 150, 775, 200);
        i.setBounds(30, 140, 795, 220);

        add(a).setBounds(34, 240, 163, 165);
        add(b).setBounds(278, 240, 163, 165);
        add(c).setBounds(1044, 242, 163, 165);
        add(d).setBounds(1288, 242, 163, 165);
        add(meow).setBounds(1375, 780, 40, 40);
        
        meow.setBackground(new Color(207,203,225));
        meow.setBorderPainted(false);
        
        
        
        setTitle("Home");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == meow)
        {
             try {
            File file = new File("home\\cat-meow.wav");
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(file));
            clip.start();
        } catch (Exception e) {
            System.err.println("");
        }

        }
        if (ae.getSource() == a) {
            try {
                TicTacToe x = new TicTacToe();
            } catch (IOException ex) {
                System.out.println("GG");
            }

            clip.stop();
            setVisible(false);

        }
        if (ae.getSource() == b) {
            chess x = new chess();
            setVisible(false);
            clip.stop();
        }
        if (ae.getSource() == c) {
            JFrame obj = new JFrame();
            
            Pepball_gameplay gameplay = new Pepball_gameplay();
            obj.setBounds(10, 10, 700, 600);
            obj.setTitle("Pepball");
            obj.setResizable(false);
            obj.setLocationRelativeTo(null);
            obj.setVisible(true);
            obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            obj.add(gameplay);
           
            setVisible(false);
            clip.stop();
        }

        if (ae.getSource() == d) {
            JFrame obj = new JFrame();
            snake_gameplay gameplay = new snake_gameplay();
            obj.setBounds(10, 10, 905, 700);
            obj.setBackground(Color.DARK_GRAY);
            obj.setResizable(false);
            obj.setLocationRelativeTo(null);
            obj.setVisible(true);
            obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            obj.add(gameplay);
            setVisible(false);
            clip.stop();
        }
    }

}

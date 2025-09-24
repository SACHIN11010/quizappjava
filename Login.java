import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {
    JButton rules, back;
    JTextField tfname;

    Login() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/login.jpeg"));
        Image img = i1.getImage().getScaledInstance(600, 500, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(img);

        JLabel image = new JLabel(scaledIcon);
        image.setBounds(0, 0, 600, 500);
        add(image);


        JLabel heading = new JLabel("QUIZ APP");
        heading.setBounds(750, 60, 300, 45);
        heading.setFont(new Font("Segoe UI Black", Font.BOLD, 40)); // modern bold font
        heading.setForeground(new Color(30, 30, 30)); // dark gray for contrast
        add(heading);

        JLabel name = new JLabel("Enter Your Name");
        name.setBounds(810, 150, 300, 20);
        name.setFont(new Font("Segoe UI", Font.BOLD, 18));
        name.setForeground(new Color(50, 50, 50)); // dark gray text
        add(name);


        tfname = new JTextField();
        tfname.setBounds(735, 200, 300, 35);
        tfname.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        tfname.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200), 2),
            BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        tfname.addActionListener(this);
        add(tfname);


        rules = new JButton("Rules");
        rules.setBounds(735, 270, 120, 30);
        rules.setBackground(new Color(34, 139, 34)); // forest green
        rules.setForeground(Color.WHITE);
        rules.setFont(new Font("Segoe UI", Font.BOLD, 14));
        rules.addActionListener(this);
        add(rules);


        back = new JButton("Back");
        back.setBounds(915, 270, 120, 30);
        back.setBackground(new Color(178, 34, 34)); 
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Segoe UI", Font.BOLD, 14));
        back.addActionListener(this);
        add(back);

        setSize(1200, 500);
        setLocation(200, 150);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == rules || ae.getSource() == tfname) {
            String name = tfname.getText().trim();
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter your name to continue!", "Name Required", JOptionPane.WARNING_MESSAGE);
                tfname.requestFocus();
                return;
            }
            if (name.length() < 2) {
                JOptionPane.showMessageDialog(this, "Please enter a valid name (at least 2 characters)!", "Invalid Name", JOptionPane.WARNING_MESSAGE);
                tfname.requestFocus();
                return;
            }
            setVisible(false);
            new Rules(name);
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener {

    String name;
    JButton start, back;

    Rules(String name) {
        this.name = name;

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Welcome " + name + " to Java Quiz");
        heading.setBounds(50, 20, 700, 30);
        heading.setFont(new Font("Segoe UI", Font.BOLD, 28));
        heading.setForeground(new Color(34, 34, 34));
        add(heading);

        JLabel rulesText = new JLabel();
        rulesText.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        rulesText.setText(
            "<html>" +
            "1. You are given 10 multiple choice questions.<br><br>" +
            "2. Only one option is correct for each question.<br><br>" +
            "3. You have 25 seconds to answer each question.<br><br>" +
            "4. Click on 'Next' to go to the next question.<br><br>" +
            "5. Once submitted, you cannot go back.<br><br>" +
            "6. You can use '50-50' lifeline once per game.<br><br>" +
            "7. Final score will be displayed after submission.<br><br>" +
            "8. No negative marking for incorrect answers.<br><br>" +
            "Good luck!" +
            "</html>"
        );

        JScrollPane scrollPane = new JScrollPane(rulesText);
        scrollPane.setBounds(20, 80, 740, 320);
        scrollPane.setBorder(null);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(scrollPane);

        back = new JButton("Back");
        back.setBounds(250, 430, 100, 30);
        back.setBackground(new Color(178, 34, 34));
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Segoe UI", Font.BOLD, 14));
        back.addActionListener(this);
        add(back);

        start = new JButton("Start");
        start.setBounds(400, 430, 100, 30);
        start.setBackground(new Color(34, 139, 34));
        start.setForeground(Color.WHITE);
        start.setFont(new Font("Segoe UI", Font.BOLD, 14));
        start.addActionListener(this);
        add(start);

        setSize(800, 550);
        setLocation(350, 150);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == start) {
            setVisible(false);
            new Quiz();
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new Rules("User");
    }
}

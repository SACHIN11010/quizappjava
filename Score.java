import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Score extends JFrame implements ActionListener {
    
    Score(int score) {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Header image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/score.png"));
        Image img = i1.getImage().getScaledInstance(300, 250, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(img);

        JLabel image = new JLabel(scaledIcon);
        image.setBounds(0, 200, 300, 250);
        add(image);

        // Score display
        JLabel heading = new JLabel("Thank you for playing!");
        heading.setBounds(45, 30, 700, 30);
        heading.setFont(new Font("Segoe UI", Font.BOLD, 26));
        heading.setForeground(new Color(30, 30, 30));
        add(heading);

        JLabel scoreText = new JLabel("Your Score: " + score + " out of 10");
        scoreText.setBounds(350, 200, 300, 30);
        scoreText.setFont(new Font("Segoe UI", Font.BOLD, 20));
        scoreText.setForeground(new Color(34, 139, 34));
        add(scoreText);

        // Performance message
        String performance;
        Color performanceColor;
        if (score >= 8) {
            performance = "Excellent! Outstanding performance!";
            performanceColor = new Color(34, 139, 34);
        } else if (score >= 6) {
            performance = "Good job! Well done!";
            performanceColor = new Color(255, 140, 0);
        } else if (score >= 4) {
            performance = "Not bad! Keep practicing!";
            performanceColor = new Color(255, 165, 0);
        } else {
            performance = "Better luck next time! Keep learning!";
            performanceColor = new Color(220, 20, 20);
        }

        JLabel performanceLabel = new JLabel(performance);
        performanceLabel.setBounds(350, 250, 400, 30);
        performanceLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        performanceLabel.setForeground(performanceColor);
        add(performanceLabel);

        // Percentage
        int percentage = (score * 100) / 10;
        JLabel percentageLabel = new JLabel("Percentage: " + percentage + "%");
        percentageLabel.setBounds(350, 290, 200, 30);
        percentageLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        percentageLabel.setForeground(new Color(50, 50, 50));
        add(percentageLabel);

        // Buttons
        JButton playAgain = new JButton("Play Again");
        playAgain.setBounds(380, 350, 120, 30);
        playAgain.setBackground(new Color(34, 139, 34));
        playAgain.setForeground(Color.WHITE);
        playAgain.setFont(new Font("Segoe UI", Font.BOLD, 14));
        playAgain.addActionListener(this);
        add(playAgain);

        JButton exit = new JButton("Exit");
        exit.setBounds(520, 350, 120, 30);
        exit.setBackground(new Color(178, 34, 34));
        exit.setForeground(Color.WHITE);
        exit.setFont(new Font("Segoe UI", Font.BOLD, 14));
        exit.addActionListener(this);
        add(exit);

        setSize(750, 550);
        setLocation(400, 150);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Play Again")) {
            setVisible(false);
            new Login();
        } else {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Score(0);
    }
}



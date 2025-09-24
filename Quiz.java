import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Quiz extends JFrame implements ActionListener
{
    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String useranswers[][] = new String[10][1];
    JLabel qno, question, image, timerLabel;
 
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup bg;
    JButton next, lifeline, submit;
    public static int timer = 25;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;
    public static boolean lifelineUsed = false;
    Timer gameTimer;
    Quiz() 
    {
        setBounds(50, 0, 1440, 850);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/quiz.jpg"));
        Image img = i1.getImage().getScaledInstance(1440, 392, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(img);

        image = new JLabel(scaledIcon);
        image.setBounds(0, 0, 1440, 392);
        add(image);

        qno = new JLabel();
        qno.setBounds(100, 450, 50, 30);
        qno.setFont(new Font("Segoe UI", Font.BOLD, 24));
        qno.setForeground(new Color(34, 34, 34));
        add(qno);

        question = new JLabel();
        question.setBounds(150, 450, 900, 30);
        question.setFont(new Font("Segoe UI", Font.BOLD, 24));
        question.setForeground(new Color(34, 34, 34));
        add(question);

        questions[0][0] = "Which is used to find and fix bugs in the Java programs.?";
        questions[0][1] = "JVM";
        questions[0][2] = "JDB";
        questions[0][3] = "JDK";
        questions[0][4] = "JRE";

        questions[1][0] = "What is the return type of the hashCode() method in the Object class?";
        questions[1][1] = "int";
        questions[1][2] = "Object";
        questions[1][3] = "long";
        questions[1][4] = "void";

        questions[2][0] = "Which package contains the Random class?";
        questions[2][1] = "java.util package";
        questions[2][2] = "java.lang package";
        questions[2][3] = "java.awt package";
        questions[2][4] = "java.io package";

        questions[3][0] = "An interface with no fields or methods is known as?";
        questions[3][1] = "Runnable Interface";
        questions[3][2] = "Abstract Interface";
        questions[3][3] = "Marker Interface";
        questions[3][4] = "CharSequence Interface";

        questions[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        questions[4][1] = "Stack";
        questions[4][2] = "String memory";
        questions[4][3] = "Random storage space";
        questions[4][4] = "Heap memory";

        questions[5][0] = "Which of the following is a marker interface?";
        questions[5][1] = "Runnable interface";
        questions[5][2] = "Remote interface";
        questions[5][3] = "Readable interface";
        questions[5][4] = "Result interface";

        questions[6][0] = "Which keyword is used for accessing the features of a package?";
        questions[6][1] = "import";
        questions[6][2] = "package";
        questions[6][3] = "extends";
        questions[6][4] = "export";

        questions[7][0] = "In java, jar stands for?";
        questions[7][1] = "Java Archive Runner";
        questions[7][2] = "Java Archive";
        questions[7][3] = "Java Application Resource";
        questions[7][4] = "Java Application Runner";

        questions[8][0] = "Which of the following is a mutable class in java?";
        questions[8][1] = "java.lang.StringBuilder";
        questions[8][2] = "java.lang.Short";
        questions[8][3] = "java.lang.Byte";
        questions[8][4] = "java.lang.String";

        questions[9][0] = "Which of the following option leads to the portability and security of Java?";
        questions[9][1] = "Bytecode is executed by JVM";
        questions[9][2] = "The applet makes the Java code secure and portable";
        questions[9][3] = "Use of exception handling";
        questions[9][4] = "Dynamic binding between objects";

        answers[0][1] = "JDB";
        answers[1][1] = "int";
        answers[2][1] = "java.util package";
        answers[3][1] = "Marker Interface";
        answers[4][1] = "Heap memory";
        answers[5][1] = "Remote interface";
        answers[6][1] = "import";
        answers[7][1] = "Java Archive";
        answers[8][1] = "java.lang.StringBuilder";
        answers[9][1] = "Bytecode is executed by JVM";

        opt1 = new JRadioButton();
        opt1.setBounds(150, 500, 700, 35);
        opt1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        opt1.setBackground(Color.WHITE);
        opt1.setFocusPainted(false);
        add(opt1);

        opt2 = new JRadioButton();
        opt2.setBounds(150, 545, 700, 35);
        opt2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        opt2.setBackground(Color.WHITE);
        opt2.setFocusPainted(false);
        add(opt2);

        opt3 = new JRadioButton();
        opt3.setBounds(150, 590, 700, 35);
        opt3.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        opt3.setBackground(Color.WHITE);
        opt3.setFocusPainted(false);
        add(opt3);

        opt4 = new JRadioButton();
        opt4.setBounds(150, 635, 700, 35);
        opt4.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        opt4.setBackground(Color.WHITE);
        opt4.setFocusPainted(false);
        add(opt4);

        bg = new ButtonGroup();
        bg.add(opt1);
        bg.add(opt2);
        bg.add(opt3);
        bg.add(opt4);

        next = new JButton("Next");
        next.setBounds(1100, 500, 120, 40);
        next.setBackground(new Color(34, 139, 34)); 
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Segoe UI", Font.BOLD, 14));
        next.setFocusPainted(false);
        next.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        next.addActionListener(this);
        add(next);

        lifeline = new JButton("50-50");
        lifeline.setBounds(1100, 550, 120, 40);
        lifeline.setBackground(new Color(255, 140, 0));
        lifeline.setForeground(Color.WHITE);
        lifeline.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lifeline.setFocusPainted(false);
        lifeline.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        lifeline.addActionListener(this);
        add(lifeline);

        submit = new JButton("Submit");
        submit.setBounds(1100, 600, 120, 40);
        submit.setBackground(new Color(178, 34, 34));
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Segoe UI", Font.BOLD, 14));
        submit.setFocusPainted(false);
        submit.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);

        // Timer label
        timerLabel = new JLabel("Time Left: 25 seconds");
        timerLabel.setBounds(1100, 400, 200, 30);
        timerLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        timerLabel.setForeground(new Color(220, 20, 20));
        add(timerLabel);

        // Initialize game timer
        gameTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer--;
                timerLabel.setText("Time Left: " + timer + " seconds");
                if (timer <= 0) {
                    gameTimer.stop();
                    autoNext();
                }
            }
        });
        
        start(count);
        gameTimer.start();

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            if (bg.getSelection() == null && count < 9) {
                int choice = JOptionPane.showConfirmDialog(this, 
                    "No answer selected. Do you want to skip this question?", 
                    "Skip Question?", 
                    JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.NO_OPTION) {
                    return;
                }
            }
            nextQuestion();
        } else if (ae.getSource() == submit) {
            calculateScore();
            showResults();
        } else if (ae.getSource() == lifeline && !lifelineUsed) {
            useLifeline();
        } else if (ae.getSource() == lifeline && lifelineUsed) {
            JOptionPane.showMessageDialog(this, "50-50 lifeline has already been used!", "Lifeline Used", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void nextQuestion() {
        // Store current answer
        if (bg.getSelection() == null) {
            useranswers[count][0] = "";
        } else {
            useranswers[count][0] = bg.getSelection().getActionCommand();
        }
        
        count++;
        if (count >= 10) {
            calculateScore();
            showResults();
        } else {
            resetForNextQuestion();
        }
    }

    private void autoNext() {
        // Auto-advance when time runs out
        if (bg.getSelection() == null) {
            useranswers[count][0] = "";
        } else {
            useranswers[count][0] = bg.getSelection().getActionCommand();
        }
        
        count++;
        if (count >= 10) {
            calculateScore();
            showResults();
        } else {
            resetForNextQuestion();
        }
    }

    private void resetForNextQuestion() {
        timer = 25;
        gameTimer.restart();
        bg.clearSelection();
        start(count);
        
        // Enable submit button on last question
        if (count == 9) {
            submit.setEnabled(true);
            next.setText("Finish");
        }
    }

    private void useLifeline() {
        lifelineUsed = true;
        lifeline.setEnabled(false);
        
        // Find correct answer
        String correctAnswer = answers[count][1];
        String correctText = "";
        
        // Find which radio button has the correct answer
        if (opt1.getText().equals(correctAnswer)) {
            correctText = opt1.getActionCommand();
            opt2.setEnabled(false);
            opt3.setEnabled(false);
        } else if (opt2.getText().equals(correctAnswer)) {
            correctText = opt2.getActionCommand();
            opt1.setEnabled(false);
            opt3.setEnabled(false);
        } else if (opt3.getText().equals(correctAnswer)) {
            correctText = opt3.getActionCommand();
            opt1.setEnabled(false);
            opt4.setEnabled(false);
        } else if (opt4.getText().equals(correctAnswer)) {
            correctText = opt4.getActionCommand();
            opt2.setEnabled(false);
            opt3.setEnabled(false);
        }
        
        JOptionPane.showMessageDialog(this, "50-50 lifeline used! Two incorrect options have been removed.");
    }

    private void calculateScore() {
        score = 0;
        for (int i = 0; i < 10; i++) {
            if (useranswers[i][0] != null && useranswers[i][0].equals(answers[i][1])) {
                score++;
            }
        }
    }

    private void showResults() {
        gameTimer.stop();
        setVisible(false);
        new Score(score);
    }

    public void start(int count)
    {
        qno.setText(""+(count+1)+". ");
        question.setText(questions[count][0]);
        
        // Reset radio button states
        opt1.setEnabled(true);
        opt2.setEnabled(true);
        opt3.setEnabled(true);
        opt4.setEnabled(true);
        
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);
        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);
        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);
        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);
        
    }
    public static void main(String[] args) 
    {
        new Quiz();
    }
}

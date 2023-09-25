import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartHomePage implements ActionListener {

    JFrame frame = new JFrame();
    JTextField textfield = new JTextField();
    JTextArea textArea = new JTextArea();
    JButton buttonA = new JButton("A");
    JButton buttonB = new JButton("B");
    JLabel answerLabelA = new JLabel();
    JLabel answerLabelB = new JLabel();

    String currentUser;


    public StartHomePage(String username){
        currentUser = username;

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650,650);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(null);
        frame.setResizable(false);


        textfield.setBounds(0,0,650,50);
        textfield.setBackground(new Color(25,25,25));
        textfield.setForeground(new Color(25,255,0));
        textfield.setFont(new Font("Ink Free", Font.BOLD,25));
        textfield.setBorder(BorderFactory.createBevelBorder(1));
        textfield.setHorizontalAlignment(JTextField.CENTER);
        textfield.setEditable(false);
        textfield.setText("Welcome "+currentUser+" to Coding Mania");


        textArea.setBounds(0,50,650,50);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBackground(new Color(25,25,25));
        textArea.setForeground(new Color(25,255,0));
        textArea.setFont(new Font("Mv Boli", Font.BOLD,25));
        textArea.setBorder(BorderFactory.createBevelBorder(1));
        textArea.setEditable(false);
        textArea.setText("What do you wanna do?");


        buttonA.setBounds(0,100,100,100);
        buttonA.setFont(new Font("Mv Boli", Font.BOLD,35));
        buttonA.setFocusable(false);
        buttonA.addActionListener(this);



        buttonB.setBounds(0,200,100,100);
        buttonB.setFont(new Font("Mv Boli", Font.BOLD,35));
        buttonB.setFocusable(false);
        buttonB.addActionListener(this);




        answerLabelA.setBounds(125,100,500,100);
        answerLabelA.setBackground(new Color(50,50,50));
        answerLabelA.setForeground(new Color(25,255,0));
        answerLabelA.setFont(new Font("Mv Boli", Font.PLAIN,35));
        answerLabelA.setText("I want to solve questions");

        answerLabelB.setBounds(125,200,500,100);
        answerLabelB.setBackground(new Color(50,50,50));
        answerLabelB.setForeground(new Color(25,255,0));
        answerLabelB.setFont(new Font("Mv Boli", Font.PLAIN,35));
        answerLabelB.setText("I want to quit");



        frame.add(textfield);
        frame.add(textArea);
        frame.add(buttonA);
        frame.add(buttonB);
        frame.add(answerLabelA);
        frame.add(answerLabelB);
        frame.setVisible(true);




    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Button Clicked");

        if(e.getSource() == buttonA){
            frame.dispose();
            Quiz quiz = new Quiz(currentUser);
        }

        if(e.getSource() == buttonB){
            IdandPasswords idandpasswords = new IdandPasswords();
            frame.dispose();
            LoginPage loginPage = new LoginPage(idandpasswords.getLoginCredentials());
        }


    }
}
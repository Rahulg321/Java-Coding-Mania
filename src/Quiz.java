import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class Quiz implements ActionListener {

    String [] questions = {
            "Peform Linear Search on an Array",
            "Peform Binary Search on an Array",
            "Peform Merge Sort on an Array",
            "Peform Quick Sort on an Array",
            "Traverse a Linked List",
            "Find whether two linked lists are intersecting",
            "Traverse a binary Search Tree",
    };


    char guess;
    char answer;
    int index = 0;
    int correct_guesses = 0;
    int totalQuestions = questions.length;
    int result;
    int minutes = 30;

    JFrame frame = new JFrame();
    JTextField textfield = new JTextField();
    JTextArea textArea = new JTextArea();
    JButton buttonA = new JButton("A");
    JButton buttonB = new JButton("B");
    JButton buttonC = new JButton("C");
    JButton buttonD = new JButton("D");


    JLabel answerLabelA = new JLabel();
    JLabel answerLabelB = new JLabel();
    JLabel answerLabelC = new JLabel();
    JLabel answerLabelD = new JLabel();


    JLabel timeLabel = new JLabel();
    JLabel minutes_left = new JLabel();



    String currentuser;





    public Quiz(String userName){
        currentuser = userName;


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650,650);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(null);
        frame.setResizable(false);

        textfield.setBounds(0,0,650,50);
        textfield.setBackground(new Color(25,25,25));
        textfield.setForeground(new Color(25,255,0));
        textfield.setFont(new Font("Ink Free", Font.BOLD,30));
        textfield.setBorder(BorderFactory.createBevelBorder(1));
        textfield.setHorizontalAlignment(JTextField.CENTER);
        textfield.setEditable(false);
        textfield.setText("Coding Mania");


        textArea.setBounds(0,50,650,50);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBackground(new Color(25,25,25));
        textArea.setForeground(new Color(25,255,0));
        textArea.setFont(new Font("Mv Boli", Font.BOLD,25));
        textArea.setBorder(BorderFactory.createBevelBorder(1));
        textArea.setEditable(false);
        textArea.setText(questions[index]);

        buttonA.setBounds(0,100,100,100);
        buttonA.setFont(new Font("Mv Boli", Font.BOLD,35));
        buttonA.setFocusable(false);
        buttonA.addActionListener(this);


        buttonB.setBounds(0,200,100,100);
        buttonB.setFont(new Font("Mv Boli", Font.BOLD,35));
        buttonB.setFocusable(false);
        buttonB.addActionListener(this);

        buttonC.setBounds(0,300,100,100);
        buttonC.setFont(new Font("Mv Boli", Font.BOLD,35));
        buttonC.setFocusable(false);
        buttonC.addActionListener(this);



        buttonD.setBounds(0,400,100,100);
        buttonD.setFont(new Font("Mv Boli", Font.BOLD,35));
        buttonD.setFocusable(false);
        buttonD.addActionListener(this);


        answerLabelA.setBounds(125,100,500,100);
        answerLabelA.setBackground(new Color(50,50,50));
        answerLabelA.setForeground(new Color(25,255,0));
        answerLabelA.setFont(new Font("Mv Boli", Font.PLAIN,35));
        answerLabelA.setText("Solve question");

        answerLabelB.setBounds(125,200,500,100);
        answerLabelB.setBackground(new Color(50,50,50));
        answerLabelB.setForeground(new Color(25,255,0));
        answerLabelB.setFont(new Font("Mv Boli", Font.PLAIN,35));
        answerLabelB.setText("Next question");


        answerLabelC.setBounds(125,300,500,100);
        answerLabelC.setBackground(new Color(50,50,50));
        answerLabelC.setForeground(new Color(25,255,0));
        answerLabelC.setFont(new Font("Mv Boli", Font.PLAIN,35));
        answerLabelC.setText("Previous Question");


        answerLabelD.setBounds(125,400,500,100);
        answerLabelD.setBackground(new Color(50,50,50));
        answerLabelD.setForeground(new Color(25,255,0));
        answerLabelD.setFont(new Font("Mv Boli", Font.PLAIN,35));
        answerLabelD.setText("Go Back to Home Page");


        timeLabel.setBounds(535,475,100,25);
        timeLabel.setBackground(new Color(50,50,50));
        timeLabel.setForeground(new Color(255,0,0));
        timeLabel.setFont(new Font("Mv Boli", Font.PLAIN,25));
        timeLabel.setHorizontalAlignment(JTextField.CENTER);
        timeLabel.setText("timer:::");

        minutes_left.setBounds(535,510,100,100);
        minutes_left.setBackground(new Color(25,25,25));
        minutes_left.setForeground(new Color(255,0,0));
        minutes_left.setFont(new Font("Mv Boli", Font.BOLD,65));
        minutes_left.setBorder(BorderFactory.createBevelBorder(1));
        minutes_left.setOpaque(true);
        minutes_left.setHorizontalAlignment(JTextField.CENTER);
        minutes_left.setText(String.valueOf(minutes));


        frame.add(timeLabel);
        frame.add(minutes_left);
        frame.add(answerLabelA);
        frame.add(answerLabelB);
        frame.add(answerLabelC);
        frame.add(answerLabelD);
        frame.add(buttonA);
        frame.add(buttonB);
        frame.add(buttonC);
        frame.add(buttonD);
        frame.add(textArea);
        frame.add(textfield);
        frame.setVisible(true);

    }


    public void nextQuestion(){
            if(index <  questions.length - 1){
                index++;
                textArea.setText(questions[index]);
            }else{
                System.out.println("cannot retrieve next question");
            }

    }

    public void prevQuestion(){
        if(index > 0){
            index--;
            textArea.setText(questions[index]);
        }else{
            System.out.println("Cannot retrieve prev question");
        }

    }




    @Override
    public void actionPerformed(ActionEvent e) {
            if(e.getSource() == buttonA){
                System.out.println("Button A was clicked");
                TextEditor texteditor = new TextEditor();
            }

        if(e.getSource() == buttonB){
            System.out.println("Button B was clicked");
            nextQuestion();
        }


        if(e.getSource() == buttonC){
            System.out.println("Button C was clicked");
            prevQuestion();
        }


        if(e.getSource() == buttonD){
            frame.dispose();
            StartHomePage homePage = new StartHomePage(currentuser);
        }
    }
}

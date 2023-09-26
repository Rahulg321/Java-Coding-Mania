import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.util.HashMap;
import java.awt.event.FocusEvent;


public class LoginPage implements ActionListener  {
    JFrame frame = new JFrame();
    JTextField textfield = new JTextField();
    JTextArea textArea = new JTextArea();
    JButton loginButton = new JButton("LOGIN");
    JButton resetButton = new JButton("RESET");
    JTextField userIDField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JLabel messageLabel = new JLabel();

    JLabel headerLabel = new JLabel("LeetCode");
    HashMap<String,String> loginInfo;
    LoginPage(HashMap<String,String> loginInfoOriginal){
        loginInfo = loginInfoOriginal;


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650,550);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(null);
        frame.setResizable(false);


        textfield.setBounds(0,0,650,50);
        textfield.setBackground(new Color(25,25,25));
        textfield.setForeground(new Color(213,210,212));
        textfield.setFont(new Font("DejaVu Sans", Font.BOLD,30));

        textfield.setBorder(BorderFactory.createBevelBorder(1));
        textfield.setHorizontalAlignment(JTextField.CENTER);
        textfield.setEditable(false);
        textfield.setText("Welcome to Coding Mania");


        textArea.setBounds(0,50,650,50);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBackground(new Color(25,25,25));
        textArea.setForeground(new Color(213,210,212));
        textArea.setFont(new Font("Ink Free", Font.BOLD,25));
        textArea.setBorder(BorderFactory.createBevelBorder(1));
        textArea.setEditable(false);
        textArea.setText("Login or Register to Continue");



        userIDField.setBounds(100,150,400,60);
        userIDField.setText("Your Username.......");
        userIDField.setBackground(new Color(25, 25, 25));
        userIDField.setForeground(new Color(213,210,212));
        userIDField.setFont(new Font("Arial", Font.BOLD, 25));
        userIDField.setBorder(BorderFactory.createBevelBorder(1));
        userIDField.setHorizontalAlignment(JTextField.LEFT);
        userIDField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // When the field gains focus, clear the text if it's the placeholder
                if (userIDField.getText().equals("Your Username.......")) {
                    userIDField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                // When the field loses focus and is empty, set the placeholder text
                if (userIDField.getText().isEmpty()) {
                    userIDField.setText("Your Username.......");
                }
            }
        });


        passwordField.setBounds(100,240,400,60);
        passwordField.setText("Password");
        passwordField.setBackground(new Color(25, 25, 25));
        passwordField.setForeground(new Color(213,210,212));
        passwordField.setFont(new Font("Ink Free", Font.PLAIN, 20));
        passwordField.setBorder(BorderFactory.createBevelBorder(1));
        passwordField.setHorizontalAlignment(JTextField.LEFT);

        passwordField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // When the field gains focus, clear the text if it's the placeholder
                char[] password = passwordField.getPassword();
                if (password != null && password.length > 0 && new String(password).equals("Password")) {
                    passwordField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                // When the field loses focus and is empty, set the placeholder text
                char[] password = passwordField.getPassword();
                if (password == null || password.length == 0) {
                    passwordField.setText("Password");
                }
            }
        });


        loginButton.setBounds(100,320,150,50);
        loginButton.setFont(new Font("Mv Boli", Font.BOLD, 30));
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);


        resetButton.setBounds(300,320,150,50);
        resetButton.setFont(new Font("Mv Boli", Font.BOLD, 30));
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);



        messageLabel.setBounds(100,400,550,50);
        messageLabel.setFont(new Font("Mv Boli", Font.ITALIC, 25));
//        messageLabel.setForeground(new Color(255,0,0));
//        messageLabel.setText("Invalid Login credentials");




        frame.add(loginButton);
        frame.add(resetButton);
        frame.add(messageLabel);
        frame.add(userIDField);
        frame.add(passwordField);
        frame.add(textfield);
        frame.add(textArea);

        frame.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
            if(e.getSource() == resetButton){

                userIDField.setText("");
                passwordField.setText("");
                messageLabel.setText("");

            }
            if(e.getSource() == loginButton){
                    String username = userIDField.getText();
                    String password = String.valueOf(passwordField.getPassword());

                    System.out.println(username);
                    System.out.println(password);

//                    first we will check the username whether it exists or not
//                    then we will match the password
                    if(loginInfo.containsKey(username)){
                        if(loginInfo.get(username).equals(password)){
                            System.out.println("login successful");
                            messageLabel.setForeground(Color.GREEN);
                            messageLabel.setText("valid credentials");

                            frame.dispose();
                            StartHomePage homePage = new StartHomePage(username);
                        } else{
                            messageLabel.setForeground(Color.RED);
                            messageLabel.setText("InValid Password");
                        }
                    }else{
                        messageLabel.setForeground(Color.RED);
                        messageLabel.setText("InValid Username or Password");
                    }
            }
    }
}

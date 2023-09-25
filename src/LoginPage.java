import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class LoginPage implements ActionListener {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JButton loginButton = new JButton("LOGIN");
    JButton resetButton = new JButton("RESET");
    JTextField userIDField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JLabel userIDLabel = new JLabel("userId:- ");
    JLabel passwordLabel = new JLabel("password ");
    JLabel messageLabel = new JLabel();

    JLabel headerLabel = new JLabel("LeetCode");
    HashMap<String,String> loginInfo = new HashMap<String,String>();
    LoginPage(HashMap<String,String> loginInfoOriginal){
        loginInfo = loginInfoOriginal;

        userIDLabel.setBounds(50,100,125,25);
        passwordLabel.setBounds(50,150,125,25);


        messageLabel.setBounds(100,250,350,35);
        messageLabel.setFont(new Font("Arial", Font.PLAIN, 18));


        userIDField.setBounds(125,100,200,25);
        passwordField.setBounds(125,150,200,25);



        loginButton.setBounds(125,200,100,25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);
        loginButton.setFont(new Font("Arial", Font.BOLD, 14));
        loginButton.setBackground(Color.GREEN);
        loginButton.setForeground(Color.WHITE);

        resetButton.setBounds(225,200,100,25);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);
        resetButton.setFont(new Font("Arial", Font.BOLD, 14));
        resetButton.setBackground(Color.RED);
        resetButton.setForeground(Color.WHITE);


        Insets padding = new Insets(5, 10, 5, 10);
        userIDField.setMargin(padding);
        passwordField.setMargin(padding);


        Font labelFont = new Font("Tahoma", Font.BOLD, 20); // Custom font and larger font size
        userIDLabel.setFont(labelFont);
        passwordLabel.setFont(labelFont);

        // Set styles for the header
        headerLabel.setBounds(200, 10, 175, 40);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headerLabel.setForeground(Color.BLUE);

        frame.add(headerLabel);


        frame.add(userIDLabel);
        frame.add(passwordLabel);
        frame.add(messageLabel);
        frame.add(userIDField);
        frame.add(passwordField);
        frame.add(loginButton);
        frame.add(resetButton);

        panel.setBackground(new Color(240, 240, 240)); // Light gray

        panel.setLayout(null);
        frame.add(panel);

        frame.setTitle("JAVA Project");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);

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
                            HomePage homePage = new HomePage(username);
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

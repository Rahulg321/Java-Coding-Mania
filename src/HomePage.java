import javax.swing.*;
import java.awt.*;

public class HomePage {
    JFrame frame = new JFrame();
    JLabel welcomeLabel = new JLabel();
    String username;

    HomePage(String user){
        username = user;

        welcomeLabel.setText("welcome "+ username);
        welcomeLabel.setBounds(0,0,400,35);
        welcomeLabel.setFont(new Font(null,Font.BOLD,20));

        frame.add(welcomeLabel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}

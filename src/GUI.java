import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    private int count;
    private JLabel label;
    private JFrame frame;
    private JPanel panel;


    public GUI(){
         frame = new JFrame();
         panel = new JPanel();
        JButton button = new JButton("Save");
        button.addActionListener(this);
        label = new JLabel("number of clicks: 1");

        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));

        panel.setLayout(new GridLayout(0,1));
        panel.add(button);
        panel.add(label);

        frame.add(panel,BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("my first Gui");
        frame.pack();
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        new GUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        count++;
        label.setText("number of clicks: "+count);
    }
}

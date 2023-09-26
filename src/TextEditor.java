import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TextEditor extends JFrame implements ActionListener {

    JTextArea textArea;
    JScrollPane scrollPane;
    JSpinner fontSizeSpinner;
    JLabel fontLabel;
    JButton fontColorButton;
    JComboBox fontBox;
    JMenuBar menuBar;
    JMenu fileMenu;
    JMenuItem saveFile;
    JMenuItem openFile;
    JMenuItem exitFile;


    String questionAsked;
    String currentUser;



     TextEditor(String questionSelected, String username){
         questionAsked = questionSelected;
         currentUser = username;


         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         this.setSize(500,500);
         this.setTitle("solve problem");
         this.setLocationRelativeTo(null);
         this.setLayout(new FlowLayout());

         textArea = new JTextArea();
//         textArea.setPreferredSize(new Dimension(450,450));
         textArea.setWrapStyleWord(true);
         textArea.setLineWrap(true);
         textArea.setText(questionAsked);
         textArea.setFont(new Font("Arial", Font.PLAIN,18));


         fontLabel = new JLabel("font: ");


         scrollPane = new JScrollPane(textArea);
         scrollPane.setPreferredSize(new Dimension(450,450));
         scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

         fontSizeSpinner = new JSpinner();
         fontSizeSpinner.setPreferredSize(new Dimension(50,25));
         fontSizeSpinner.setValue(18);

         fontSizeSpinner.addChangeListener(new ChangeListener() {

             @Override
                 public void stateChanged(ChangeEvent e) {
//                 whenever value changes of the spinner
//                 get the current font and the user entered spinner value
                     textArea.setFont(new Font(textArea.getFont().getFamily(), Font.PLAIN,(int) fontSizeSpinner.getValue()));
             }
         });


         fontColorButton = new JButton("Color");
         fontColorButton.addActionListener(this);

         String [] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
         fontBox = new JComboBox(fonts);
         fontBox.addActionListener(this);
         fontBox.setSelectedItem("Arial");


         // ---***********MENUBAR*************---
            menuBar = new JMenuBar();
            fileMenu = new JMenu("File");
            openFile = new JMenuItem("Open");
            saveFile = new JMenuItem("Save");
            exitFile = new JMenuItem("Exit");


            openFile.addActionListener(this);
         saveFile.addActionListener(this);
         exitFile.addActionListener(this);


            fileMenu.add(openFile);
            fileMenu.add(saveFile);
            fileMenu.add(exitFile);
            menuBar.add(fileMenu);
         // ---***********/MENUBAR*************---
         this.setJMenuBar(menuBar);
         this.add(fontLabel);
        this.add(fontSizeSpinner);
         this.add(fontColorButton);
         this.add(fontBox);
         this.add(scrollPane);
         this.setVisible(true);

     }

    @Override
    public void actionPerformed(ActionEvent e) {
            if(e.getSource() == fontColorButton){
                    JColorChooser colorChooser = new JColorChooser();
                    Color color = colorChooser.showDialog(null,"Choose a color",Color.BLACK);

                    textArea.setForeground(color);
            }

        if(e.getSource() == fontBox){
            textArea.setFont(new Font((String) fontBox.getSelectedItem(), Font.PLAIN,textArea.getFont().getSize()));
        }
        if(e.getSource() == openFile){
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("."));

            FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
            fileChooser.setFileFilter(filter);

            int response = fileChooser.showOpenDialog(null);
            if (response == JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                Scanner fileIn = null;
                try {
                    fileIn = new Scanner(file);
//                    check for a true file
                    if(file.isFile()){
                        while(fileIn.hasNextLine()){
                            String line = fileIn.nextLine() + "\n";
                            textArea.append(line);
                        }
                    }
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }finally {
                    fileIn.close();
                }
            }

        }
        if(e.getSource() == saveFile){
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("."));

            int response = fileChooser.showSaveDialog(null);

            if(response == JFileChooser.APPROVE_OPTION){
                File file;
                PrintWriter fileout = null;

                file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                try{
                    fileout = new PrintWriter(file);
                    fileout.println(textArea.getText());
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                } finally {
                        fileout.close();
                }

            }


        }
        if(e.getSource() == exitFile){
            this.dispose();
            Quiz quiz = new Quiz(currentUser);
        }


    }
}

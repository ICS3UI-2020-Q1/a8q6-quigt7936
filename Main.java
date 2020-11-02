import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/* 
 * this program simulates a passcode
 * @author Thomas Quigley
*/
public class Main implements Runnable, ActionListener{

  // Class Variables  
  JPanel mainPanel;
  JPanel buttonPanel;

  JButton[] numberButtons;
  JButton clearButton;
  JButton enterButton;

  JTextField display;

  // the users guess and the number of astrics to be outputed
  String codeGuess = "";
  int astrics = 0;
  
  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Title");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(800,600);
    frame.setVisible(true);

    // make the main panel
    mainPanel = new JPanel();
    mainPanel.setLayout(new BorderLayout());
    frame.add(mainPanel);

    // make the button panel
    buttonPanel = new JPanel();
    buttonPanel.setLayout(new GridLayout(4,3));

    // make the display
    display = new JTextField("CLOSE");
    display.setEnabled(false);
    display.setPreferredSize(new Dimension(800, 100));

    // make the buttons
    numberButtons = new JButton[10];
    
    // goes from 0 - 9
    for (int i = 0; i < numberButtons.length; i++) {
      // create a button
      JButton button = new JButton("" + i);
      button.setActionCommand("" + i);
      button.addActionListener(this);

      // add button to the area
      numberButtons[i] = button;
    }

    // make the rest of the buttons
    clearButton = new JButton("Clear");
    enterButton = new JButton("Enter");

    clearButton.setActionCommand("clear");
    enterButton.setActionCommand("enter");

    clearButton.addActionListener(this);
    enterButton.addActionListener(this);

    // add everything to the panels
    buttonPanel.add(numberButtons[1]);
    buttonPanel.add(numberButtons[2]);
    buttonPanel.add(numberButtons[3]);
    buttonPanel.add(numberButtons[4]);
    buttonPanel.add(numberButtons[5]);
    buttonPanel.add(numberButtons[6]);
    buttonPanel.add(numberButtons[7]);
    buttonPanel.add(numberButtons[8]);
    buttonPanel.add(numberButtons[9]);
    buttonPanel.add(clearButton);
    buttonPanel.add(numberButtons[0]);
    buttonPanel.add(enterButton);
    
    mainPanel.add(display, BorderLayout.PAGE_START);
    mainPanel.add(buttonPanel, BorderLayout.CENTER);

  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();
    
    // finds out what button was pressed
    switch (command) {
      // adds the number pressed to your guess, adds one to astrics and performs the print astrics method
      case "0":
        codeGuess = codeGuess + "0";
        astrics = astrics + 1;
        printAstrics(astrics); 
        return;
      case "1":
        codeGuess = codeGuess + "1";
        astrics = astrics + 1;
        printAstrics(astrics); 
        return;
      case "2":
        codeGuess = codeGuess + "2";
        astrics = astrics + 1;
        printAstrics(astrics); 
        return;
      case "3":
        codeGuess = codeGuess + "3";
        astrics = astrics + 1;
        printAstrics(astrics); 
        return;
      case "4":
        codeGuess = codeGuess + "4";
        astrics = astrics + 1;
        printAstrics(astrics); 
        return;
      case "5":
        codeGuess = codeGuess + "5";
        astrics = astrics + 1;
        printAstrics(astrics); 
        return;
      case "6":
        codeGuess = codeGuess + "6";
        astrics = astrics + 1;
        printAstrics(astrics); 
        return;
      case "7":
        codeGuess = codeGuess + "7";
        astrics = astrics + 1;
        printAstrics(astrics); 
        return;
      case "8":
        codeGuess = codeGuess + "8";
        astrics = astrics + 1;
        printAstrics(astrics); 
        return;
      case "9":
        codeGuess = codeGuess + "9";
        astrics = astrics + 1;
        printAstrics(astrics); 
        return;
      // sees if your guess is right, if yes open if not says wrong pin
      case "enter":
        if (codeGuess.equals("1234")) {
          display.setText("OPEN");
        } else {
          display.setText("WRONG PIN");
        }
        return;
      // clear all the variables and outputs close
      case "clear":
        codeGuess = "";
        astrics = 0;
        display.setText("CLOSE");
        return;
    }

  }
  // method to print astrics
  public void printAstrics(int astrics) {
    // output the amount of astrics as the astric variable says
    String outputAstrics = "";
    for (int i = 0; i < astrics; i++) {
      outputAstrics = outputAstrics + "*";
    }
    // output the astric string
    display.setText("" + outputAstrics);
  }
  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}

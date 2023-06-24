package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {
    //Instance fields.
    JFrame mJFrame;
    JTextField mJTextField;
    JButton[] numberButtons; //for all the number buttons.
    JButton[] functionButtons; //for all the function buttons like addition, subtraction...
    JButton additionButton, subtractionButton, multiplicationButton, divisionButton;
    JButton decimalButton, equalButton, deleteButton, clearButton, negativeButton;
    JPanel jPanel;

    //Font used for buttons.
    Font usedFonts = new Font("Ink Free", Font.BOLD, 30);

    double numberOne = 0, numberTwo = 0, result = 0;
    char operators;

    /**
     * A parameterless constructor to create
     * the whole calculator.
     */
    public Calculator() {
        //Create a new JFrame for calculator.
        mJFrame = new JFrame("Calculator");
        //Exit whenever the user maximizes the program.
        mJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mJFrame.setSize(420, 550);
        mJFrame.setLayout(null);

        //Create a text field.
        mJTextField = new JTextField(); //instantiate text field.
        mJTextField.setBounds(50, 25, 300, 50); //bounds of the text field.
        mJTextField.setFont(usedFonts); //Font used in Text field.
        mJTextField.setEditable(false); //Makes the text field uneditable.

        //Instantiating function buttons.
        additionButton = new JButton("+");
        subtractionButton = new JButton("-");
        multiplicationButton = new JButton("*");
        divisionButton = new JButton("/");
        decimalButton = new JButton(".");
        equalButton = new JButton("=");
        deleteButton = new JButton("Delete");
        clearButton = new JButton("Clear");
        negativeButton = new JButton("(-)");

        //Creating the functionButtons array.
        functionButtons = new JButton[9];

        //Adding buttons to the functionButtons array.
        functionButtons[0] = additionButton;
        functionButtons[1] = subtractionButton;
        functionButtons[2] = multiplicationButton;
        functionButtons[3] = divisionButton;
        functionButtons[4] = decimalButton;
        functionButtons[5] = equalButton;
        functionButtons[6] = deleteButton;
        functionButtons[7] = clearButton;
        functionButtons[8] = negativeButton;

        //Using for loop to add action listener, font and setting focusable
        //on each button.
        for(int i = 0; i < functionButtons.length; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(usedFonts);
            functionButtons[i].setFocusable(false); //remove the outline when button is clicked.
        }

        //Creating the numberButtons array.
        numberButtons = new JButton[10];

        //Using the for loop to add
        for(int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(usedFonts);
            numberButtons[i].setFocusable(false);
        }

        //Setting bounds for each button.
        negativeButton.setBounds(50, 430, 80, 50);
        deleteButton.setBounds(140, 430, 100, 50);
        clearButton.setBounds(250, 430, 100, 50);

        //Instantiating JPanel in JFrame.
        jPanel = new JPanel();
        jPanel.setBounds(50, 100, 300, 300);
        jPanel.setLayout(new GridLayout(4, 4, 10, 10));

        jPanel.add(numberButtons[1]);
        jPanel.add(numberButtons[2]);
        jPanel.add(numberButtons[3]);
        jPanel.add(additionButton); //Adding addition buttons alongside the numbers.
        jPanel.add(numberButtons[4]);
        jPanel.add(numberButtons[5]);
        jPanel.add(numberButtons[6]);
        jPanel.add(subtractionButton); //Adding subtraction button alongside the numbers.
        jPanel.add(numberButtons[7]);
        jPanel.add(numberButtons[8]);
        jPanel.add(numberButtons[9]);
        jPanel.add(multiplicationButton); //Adding multiplication button alongside the numbers.
        jPanel.add(decimalButton); //Adding decimal button alongside the numbers.
        jPanel.add(numberButtons[0]);
        jPanel.add(equalButton); //Adding equal button alongside the numbers.
        jPanel.add(divisionButton); //Adding division button alongside the numbers.



        mJFrame.add(jPanel); //Adding panel to the content pane.
        mJFrame.add(negativeButton); //Adding negative button to the content pane.
        mJFrame.add(deleteButton); //Adding delete button to the content pane.
        mJFrame.add(clearButton); //Adding clear button to the content pane.
        mJFrame.add(mJTextField); //Adding JTextField to the content pane.
        //Display the frame with command.
        mJFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        for(int i = 0; i < numberButtons.length; i++) {
            if(actionEvent.getSource() == numberButtons[i]) {
                mJTextField.setText(mJTextField.getText().concat(String.valueOf(i)));
            }
        }

        //This selection statement adds decimal (.) on the text field.
        if(actionEvent.getSource() == decimalButton) {
            mJTextField.setText(mJTextField.getText().concat("."));
        }

        //This selection statement adds addition sign (+) on the text field.
        if(actionEvent.getSource() == additionButton) {
            numberOne = Double.parseDouble(mJTextField.getText());
            operators = '+';
            mJTextField.setText("");
        }

        //This selection statement adds subtraction sign (-) on the text field.
        if(actionEvent.getSource() == subtractionButton) {
            numberOne = Double.parseDouble(mJTextField.getText());
            operators = '-';
            mJTextField.setText("");
        }

        //This selection statement adds multiplication sign (*) on the text field.
        if(actionEvent.getSource() == multiplicationButton) {
            numberOne = Double.parseDouble(mJTextField.getText());
            operators = '*';
            mJTextField.setText("");
        }

        //This selection statement adds division sign (/) on the text field.
        if(actionEvent.getSource() == divisionButton) {
            numberOne = Double.parseDouble(mJTextField.getText());
            operators = '/';
            mJTextField.setText("");
        }

        if(actionEvent.getSource() == equalButton) {
            numberTwo = Double.parseDouble(mJTextField.getText());

            switch(operators) {
                case '+':
                    result = numberOne + numberTwo;
                    break;
                case '-':
                    result = numberOne - numberTwo;
                    break;
                case '*':
                    result = numberOne * numberTwo;
                    break;
                case '/':
                    result = numberOne / numberTwo;
            }

            mJTextField.setText(String.valueOf(result));
            numberOne = result;
        }

        //This selection statement clears every sign/number from the text field.
        if(actionEvent.getSource() == clearButton) {
            mJTextField.setText("");
        }

        //This selection statement removes the last character of the string of text field.
        if(actionEvent.getSource() == deleteButton) {
            String string = mJTextField.getText();
            mJTextField.setText("");
            for(int i = 0; i < string.length() - 1; i++) {
                mJTextField.setText(mJTextField.getText() + string.charAt(i));
            }
        }

        //This selection statement makes the number into negative.
        if(actionEvent.getSource() == negativeButton) {
            double temporary = Double.parseDouble(mJTextField.getText());
            temporary *= -1;
            mJTextField.setText(String.valueOf(temporary));
        }
    }
}

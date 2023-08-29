import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SimpleCalculator extends JFrame implements ActionListener {
    private JTextField textField;
    private JButton[] numberButtons;
    private JButton[] operatorButtons;
    private JButton addButton, subButton, mulButton, divButton, equalButton, dotButton, clearButton;
    private JPanel panel;

    private double num1, num2, result;
    private char operator;

    public SimpleCalculator() {
        setTitle("Simple Calculator");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        textField = new JTextField();
        textField.setFont(new Font("Arial", Font.PLAIN, 20));
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setEditable(false);

        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(new Font("Arial", Font.PLAIN, 20));
            numberButtons[i].addActionListener(this);
        }

        operatorButtons = new JButton[4];
        operatorButtons[0] = new JButton("+");
        operatorButtons[1] = new JButton("-");
        operatorButtons[2] = new JButton("*");
        operatorButtons[3] = new JButton("/");
        for (int i = 0; i < 4; i++) {
            operatorButtons[i].setFont(new Font("Arial", Font.PLAIN, 20));
            operatorButtons[i].addActionListener(this);
        }

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        equalButton = new JButton("=");
        dotButton = new JButton(".");
        clearButton = new JButton("C");
        
        addButton.setFont(new Font("Arial", Font.PLAIN, 20));
        subButton.setFont(new Font("Arial", Font.PLAIN, 20));
        mulButton.setFont(new Font("Arial", Font.PLAIN, 20));
        divButton.setFont(new Font("Arial", Font.PLAIN, 20));
        equalButton.setFont(new Font("Arial", Font.PLAIN, 20));
        dotButton.setFont(new Font("Arial", Font.PLAIN, 20));
        clearButton.setFont(new Font("Arial", Font.PLAIN, 20));
        
        addButton.addActionListener(this);
        subButton.addActionListener(this);
        mulButton.addActionListener(this);
        divButton.addActionListener(this);
        equalButton.addActionListener(this);
        dotButton.addActionListener(this);
        clearButton.addActionListener(this);

        panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4, 10, 10));

        panel.add(clearButton);
        panel.add(divButton);
        panel.add(mulButton);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(equalButton);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(dotButton);
        panel.add(numberButtons[0]);

        setLayout(new BorderLayout());
        add(textField, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText() + i);
            }
        }

        if (e.getSource() == dotButton) {
            if (!textField.getText().contains(".")) {
                textField.setText(textField.getText() + ".");
            }
        }

        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }

        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }

        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }

        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }

        if (e.getSource() == equalButton) {
            num2 = Double.parseDouble(textField.getText());

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }

            textField.setText(String.valueOf(result));
        }

        if (e.getSource() == clearButton) {
            textField.setText("");
        }
    }

    public static void main(String[] args) {
        new SimpleCalculator();
    }
}

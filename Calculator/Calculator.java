package calculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import javax.swing.JButton;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

/**
 *  created by Christine Anne Catubig
 */

public class Calculator {
    
    GridLayout grid = new GridLayout(6, 4);
    JTextField input;
    
    // initialize buttons
    JButton plus = new JButton("+");
    JButton minus = new JButton("-");
    JButton times = new JButton("x");
    JButton divide = new JButton("/");
    JButton equals = new JButton("=");
    JButton clear = new JButton("AC");
    JButton point = new JButton(".");
    JButton percent = new JButton("%");
    JButton one = new JButton("1");
    JButton two = new JButton("2");
    JButton three = new JButton("3");
    JButton four = new JButton("4");
    JButton five = new JButton("5");
    JButton six = new JButton("6");
    JButton seven = new JButton("7");
    JButton eight = new JButton("8");
    JButton nine = new JButton("9");
    JButton zero = new JButton("0");
    JButton pn = new JButton("+/-");
    
    BigDecimal sum = new BigDecimal("0");
    BigDecimal difference = new BigDecimal("0");
    BigDecimal product = new BigDecimal("0");
    BigDecimal quotient = new BigDecimal("0");
    BigDecimal num1 = new BigDecimal("0");
    BigDecimal num2 = new BigDecimal("0");
    int oper = -1;
    BigDecimal percentage = new BigDecimal("0");
    BigDecimal place = new BigDecimal("1");
    
    public Calculator() {
        JFrame frame = new JFrame("Simple Calculator");
        
        JPanel panel = new JPanel(new BorderLayout(5, 0));
        panel.setBorder(new EmptyBorder(0, 0, 0, 0));
        frame.setContentPane(panel);
        
        JPanel buttons = new JPanel(new GridLayout(5,4));
        
        input = new JTextField(" ");
        input.setEditable(false);
        input.setBackground(Color.darkGray);
        input.setFont(new Font("Verdana", Font.PLAIN, 15));
        input.setForeground(Color.white);
        input.setHorizontalAlignment(JTextField.RIGHT);
        input.setColumns(14);
        input.setPreferredSize(new Dimension(400, 90));
        panel.add(input, BorderLayout.NORTH);
        
        // change font, size and background of buttons
        clear.setFont(new Font("Verdana", Font.BOLD, 15));
        clear.setBackground(Color.darkGray);
        clear.setForeground(Color.pink);
        changeOperatorFormat(pn);
        changeOperatorFormat(percent);
        changeOperatorFormat(divide);
        changeOperatorFormat(times);
        changeOperatorFormat(minus);
        changeOperatorFormat(plus);
        changeOperatorFormat(point);
        changeOperatorFormat(equals);
        
        changeNumberFormat(one);
        changeNumberFormat(two);
        changeNumberFormat(three);
        changeNumberFormat(four);
        changeNumberFormat(five);
        changeNumberFormat(six);
        changeNumberFormat(seven);
        changeNumberFormat(eight);
        changeNumberFormat(nine);
        changeNumberFormat(zero);
        
        // add buttons to buttons(JPanel)
        buttons.add(clear);
        buttons.add(pn);
        buttons.add(percent);
        buttons.add(divide);
        buttons.add(seven);
        buttons.add(eight);
        buttons.add(nine);
        buttons.add(times);
        buttons.add(four);
        buttons.add(five);
        buttons.add(six);
        buttons.add(minus);
        buttons.add(one);
        buttons.add(two);
        buttons.add(three);
        buttons.add(plus);
        buttons.add(zero);
        buttons.add(point);
        buttons.add(equals);
        
        panel.add(buttons, BorderLayout.CENTER);
        frame.pack();
        
        panel.setVisible(true);
        frame.setBounds(100, 50, 300, 400);
        frame.setResizable(false);
        frame.setSize(300, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        action();
    }
    
    // sets font style, color and background color of operator
    private void changeOperatorFormat(JButton button){
        button.setFont(new Font("Verdana", Font.BOLD, 17));
        button.setBackground(Color.darkGray);
        button.setForeground(Color.green);
    }
    
    // sets font style, color and background color of operator
    private void changeNumberFormat(JButton button){
        button.setFont(new Font("Verdana", Font.BOLD, 17));
        button.setBackground(Color.darkGray);
        button.setForeground(Color.orange);
    }
    
    // adding actionListeners to the buttons
    private void action(){
        clear.addActionListener(new ClearListener());
        pn.addActionListener(new PNListener());
        percent.addActionListener(new PercentListener());
        divide.addActionListener(new DivideListener());
        times.addActionListener(new TimesListener());
        minus.addActionListener(new MinusListener());
        plus.addActionListener(new PlusListener());
        one.addActionListener(new OneListener());
        two.addActionListener(new TwoListener());
        three.addActionListener(new ThreeListener());
        four.addActionListener(new FourListener());
        five.addActionListener(new FiveListener());
        six.addActionListener(new SixListener());
        seven.addActionListener(new SevenListener());
        eight.addActionListener(new EightListener());
        nine.addActionListener(new NineListener());
        zero.addActionListener(new ZeroListener());
        point.addActionListener(new PointListener());
        equals.addActionListener(new EqualsListener());
    }
    
    // clears the screen and the values assigned
    class ClearListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            num1 = new BigDecimal("0");
            num2 = new BigDecimal("0");
            sum = new BigDecimal("0");
            difference = new BigDecimal("0");
            quotient = new BigDecimal("0");
            product = new BigDecimal("0");
            oper = -1;
            input.setText("");
        }
    }
    
    
    class PercentListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            oper = 5;
            place = new BigDecimal("1");
            input.setText(" " + num1.toString() + " % ");
        }
    }
    
    class PNListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            BigDecimal multiplyTwo = new BigDecimal("2");
            if(oper < 0){
                if(num1.intValue() > 0){
                    num1 = num1.subtract(num1.multiply(multiplyTwo));
                }else if(num1.intValue() < 0){
                    num1 = num1.add(num1.multiply(multiplyTwo));
                }
                input.setText(" " + num1.toString());
            }else{
                if(num2.intValue() > 0){
                    num2 = num2.subtract(num2.multiply(multiplyTwo));
                }else if(num2.intValue() < 0){
                    num2 = num2.add(num2.multiply(multiplyTwo));
                }
                input.setText(" " + num1.toString() + getOperator() + num2.toString());
            }
            
        }
    }
    
    class DivideListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            oper = 4;
            place = new BigDecimal("1");
            input.setText(" " + num1.toString() + " / ");
        }
    }
    
    class TimesListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            oper = 3;
            place = new BigDecimal("1"); 
            input.setText(" " + num1.toString() + " * ");
        }
    }
    
    class MinusListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            oper = 2;
            place = new BigDecimal("1");
            input.setText(" " + num1.toString() + " - ");
        }
    }
    
    class PlusListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            oper = 1;
            place = new BigDecimal("1");
            input.setText(" " + num1.toString() + " + ");
        }
    }
    
    class OneListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            if(oper < 0){
                num1 = num1.multiply(place).add(new BigDecimal("1"));
                input.setText(" " + num1.toString());
            } else{
                num2 = num2.multiply(place).add(new BigDecimal("1"));
                input.setText(" " + num1.toString() + " " + getOperator() + " " + num2.toString());
            }
            place = place.multiply(new BigDecimal("10"));
        }
    }
    
    class TwoListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            if(oper < 0){
                num1 = num1.multiply(place).add(new BigDecimal("2"));
                input.setText(" " + num1.toString());
            } else{
                num2 = num2.multiply(place).add(new BigDecimal("2"));
                input.setText(" " + num1.toString() + " " + getOperator() + " " + num2.toString());
            }
            place = place.multiply(new BigDecimal("10"));
        }
    }
    
    class ThreeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            if(oper < 0){
                num1 = num1.multiply(place).add(new BigDecimal("3"));
                input.setText(" " + num1.toString());
            } else{
                num2 = num2.multiply(place).add(new BigDecimal("3"));
                input.setText(" " + num1.toString() + " " + getOperator() + " " + num2.toString());
            }
            place = place.multiply(new BigDecimal("10"));
        }
    }
    
    class FourListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            if(oper < 0){
                num1 = num1.multiply(place).add(new BigDecimal("4"));
                input.setText(" " + num1.toString());
            } else{
                num2 = num2.multiply(place).add(new BigDecimal("4"));
                input.setText(" " + num1.toString() + " " + getOperator() + " " + num2.toString());
            }
            place = place.multiply(new BigDecimal("10"));
        }
    }
    
    class FiveListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            if(oper < 0){
                num1 = num1.multiply(place).add(new BigDecimal("5"));
                input.setText(" " + num1.toString());
            } else{
                num2 = num2.multiply(place).add(new BigDecimal("5"));
                input.setText(" " + num1.toString() + " " + getOperator() + " " + num2.toString());
            }
            place = place.multiply(new BigDecimal("10"));
        }
    }
    
    class SixListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            if(oper < 0){
                num1 = num1.multiply(place).add(new BigDecimal("6"));
                input.setText(" " + num1.toString());
            } else{
                num2 = num2.multiply(place).add(new BigDecimal("6"));
                input.setText(" " + num1.toString() + " " + getOperator() + " " + num2.toString());
            }
            place = place.multiply(new BigDecimal("10"));
        }
    }
    
    class SevenListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
           if(oper < 0){
                num1 = num1.multiply(place).add(new BigDecimal("7"));
                input.setText(" " + num1.toString());
            } else{
                num2 = num2.multiply(place).add(new BigDecimal("7"));
                input.setText(" " + num1.toString() + " " + getOperator() + " " + num2.toString());
            }
            place = place.multiply(new BigDecimal("10"));
        }
    }
    
    class EightListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            if(oper < 0){
                num1 = num1.multiply(place).add(new BigDecimal("8"));
                input.setText(" " + num1.toString());
            } else{
                num2 = num2.multiply(place).add(new BigDecimal("8"));
                input.setText(" " + num1.toString() + " " + getOperator() + " " + num2.toString());
            }
            place = place.multiply(new BigDecimal("10"));
        }
    }
    
   class NineListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            if(oper < 0){
                num1 = num1.multiply(place).add(new BigDecimal("9"));
                input.setText(" " + num1.toString());
            } else{
                num2 = num2.multiply(place).add(new BigDecimal("9"));
                input.setText(" " + num1.toString() + " " + getOperator() + " " + num2.toString());
            }
            place = place.multiply(new BigDecimal("10"));
        }
    }
   
   class ZeroListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            if(oper < 0){
                num1 = num1.multiply(place);
                input.setText(" " + num1.toString());
            } else{
                num2 = num2.multiply(place);
                input.setText(" " + num1.toString() + " " + getOperator() + " " + num2.toString());
            }
            place = place.multiply(new BigDecimal("10"));
        }
    }
   
   class PointListener implements ActionListener { 
        @Override
        public void actionPerformed(ActionEvent e){
            String tmp;
            if(oper < 0){
                tmp = point.getText() + num1.toString();
                num1 = (new BigDecimal(tmp));
            }else{
                tmp = point.getText() + num2.toString();
                num2 = (new BigDecimal(tmp));
            }
        }
    }
   
   class EqualsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            input.setText(" " + num1.toString() + getOperator() + num2.toString() + " = " + String.valueOf(getEquals()));
            sum = null;
            difference = null;
            product = null;
            quotient = null;
            percentage = null;
        }
    }
   
   // returns operator
   private String getOperator(){
       switch(oper){
           case 1:
               return " + ";
           case 2:
               return " - ";
           case 3:
               return " * ";
           case 4:
               return " / ";
           default:
               return " ";
       }
   }
   
   // returns sum/difference/product/quotient/percentage of the two numbers whichever fits the operation
   private BigDecimal getEquals(){ // doesnt work
       BigDecimal empty = new BigDecimal("");
       switch(oper){
           case 1:
               sum = num1.add(num2);
               return sum;
           case 2:
               difference = num1.subtract(num2);
               return difference;
           case 3:
               product = num1.multiply(num2);
               return product;
           case 4:
               try{
                   int comparison = num1.compareTo(num2);
                   if(comparison == -1){
                       quotient = num1.divide(num2, 2, RoundingMode.HALF_UP);
                   }else{
                       if(num1.remainder(num2).equals(BigDecimal.ZERO))
                           quotient = num1.divide(num2);
                       else
                           quotient = num1.divide(num2, 2, RoundingMode.HALF_UP);
                   }
               }catch(ArithmeticException e){
                   quotient = null;
               }
               quotient = num1.divide(num2);
               return quotient;
           case 5:
               percentage = num1.multiply(num2).divide(new BigDecimal(100));
           default:
               return empty;
       }
   } 
   
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Calculator(); // Let the constructor do the job
            }
	});
    }

}

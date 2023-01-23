import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Random;

public class FirsPage implements ActionListener {
    private int count =1;
    private int wrongAnswer = 0;


    JFrame frame = new JFrame();
    JButton checkExample = new JButton("Check Example");
    JButton newExample = new JButton("New Example");
    JTextField firstNum = new JTextField();
    JTextField secondNumber = new JTextField();
    JTextField answer = new JTextField();
    JLabel firsLabel = new JLabel("First Number");
    JLabel secondLabel = new JLabel("Second Number");
    JLabel answerLabel = new JLabel("Yours Answer");
    JLabel massegeLabel = new JLabel();
    JLabel examplesHistory = new JLabel("History of Examples");
    JTextField example1 = new JTextField();
    JTextField example2 = new JTextField();
    JTextField example3 = new JTextField();
    JTextField example4 = new JTextField();
    JTextField example5 = new JTextField();
    JTextField example6 = new JTextField();
    JTextField example7 = new JTextField();
    JTextField example8 = new JTextField();
    JTextField example9 = new JTextField();
    JTextField example10 = new JTextField();
    JTextField finResAnswer = new JTextField();
    JTextField scoreAnswer = new JTextField();
 protected void window () {
     Font textFont = new Font(null,Font.PLAIN,15);
     Font numFont = new Font(null, Font.ITALIC,20);
     Font hisFont = new Font(null,Font.ITALIC,15);
     Font finResFont = new Font(null,Font.ITALIC,25);
     checkExample.setBounds(200,310,190,50);
     checkExample.setHorizontalTextPosition(SwingConstants.CENTER);
     checkExample.setFont(numFont);
     checkExample.setFocusable(false);
     checkExample.setEnabled(false);
     checkExample.addActionListener(this);

     newExample.setBounds(10,310,190,50);
     newExample.setFont(numFont);
     newExample.setFocusable(false);
     newExample.setEnabled(true);
     newExample.addActionListener(this);
     firsLabel.setBounds(50,10,140,50);
     firsLabel.setHorizontalAlignment(SwingConstants.CENTER);
     firsLabel.setFont(textFont);
     firstNum.setBounds(50,50,140,50);
     firstNum.setHorizontalAlignment(SwingConstants.CENTER);
     firstNum.setEditable(false);
     firstNum.setFont(numFont);
     secondLabel.setBounds(200,10,140,50);
     secondLabel.setHorizontalAlignment(SwingConstants.CENTER);
     secondLabel.setFont(textFont);
     secondNumber.setBounds(200,50,140,50);
     secondNumber.setHorizontalAlignment(SwingConstants.CENTER);
     secondNumber.setEditable(false);
     secondNumber.setFont(numFont);
     answerLabel.setBounds(130,110,140,50);
     answerLabel.setHorizontalAlignment(SwingConstants.CENTER);
     answerLabel.setFont(textFont);
     answer.setBounds(130,150,140,50);
     answer.setHorizontalAlignment(SwingConstants.CENTER);
     answer.setFont(numFont);
     massegeLabel.setBounds(150,220 ,200,50);
     massegeLabel.setHorizontalTextPosition(SwingConstants.CENTER);
     massegeLabel.setText("Try to do it");
     massegeLabel.setFont(numFont);
     examplesHistory.setText("HISTORY");
     examplesHistory.setBounds(450,10,100,50);
     examplesHistory.setFont(textFont);
     example1.setFont(hisFont);
     example1.setBounds(450,50,150,30);
     example1.setEditable(false);
     example2.setFont(hisFont);
     example2.setBounds(450,81,150,30);
     example2.setEditable(false);
     example3.setFont(hisFont);
     example3.setBounds(450,112,150,30);
     example3.setEditable(false);
     example4.setFont(hisFont);
     example4.setBounds(450,143,150,30);
     example4.setEditable(false);
     example5.setFont(hisFont);
     example5.setBounds(450,174,150,30);
     example5.setEditable(false);
     example6.setFont(hisFont);
     example6.setBounds(450,205,150,30);
     example6.setEditable(false);
     example7.setFont(hisFont);
     example7.setBounds(450,236,150,30);
     example7.setEditable(false);
     example8.setFont(hisFont);
     example8.setBounds(450,267,150,30);
     example8.setEditable(false);
     example9.setFont(hisFont);
     example9.setBounds(450,298,150,30);
     example9.setEditable(false);
     example10.setFont(hisFont);
     example10.setBounds(450,329,150,30);
     example10.setEditable(false);
     finResAnswer.setFont(finResFont);
     finResAnswer.setBounds(10,370,380,60);
     finResAnswer.setHorizontalAlignment(SwingConstants.CENTER);
     finResAnswer.setVisible(false);
     scoreAnswer.setFont(finResFont);
     scoreAnswer.setBounds(400,370, 200,60);
     scoreAnswer.setVisible(false);

     frame.add(checkExample);
     frame.add(newExample);
     frame.add(firsLabel);
     frame.add(firstNum);
     frame.add(secondLabel);
     frame.add(secondNumber);
     frame.add(answer);
     frame.add(answerLabel);
     frame.add(massegeLabel);
     frame.add(examplesHistory);
     frame.add(example1);
     frame.add(example2);
     frame.add(example3);
     frame.add(example4);
     frame.add(example5);
     frame.add(example6);
     frame.add(example7);
     frame.add(example8);
     frame.add(example9);
     frame.add(example10);
     frame.add(finResAnswer);
     frame.add(scoreAnswer);

     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setSize(650, 480);
     frame.setLayout(null);
     frame.setVisible(true);
 }


    @Override
    public void actionPerformed(ActionEvent e) throws MyException {



        if (e.getSource() == checkExample) {

            CheckExampleFunction check = new CheckExampleFunction();
            int a = Integer.valueOf(firstNum.getText());
            int b = Integer.valueOf(secondNumber.getText());
            int res = 0;
            try {
                res = Integer.valueOf(answer.getText());
            } catch (NumberFormatException exception) {
                answer.setForeground(Color.RED);
                res = -1;
            }


            if (check.checkExampleFunction(a, b, res)) {
                massegeLabel.setForeground(Color.GREEN);
                answer.setForeground(Color.GREEN);
                massegeLabel.setText("Right");

            } else {
                massegeLabel.setForeground(Color.RED);
                massegeLabel.setText("WRONG");
                answer.setForeground(Color.RED);
                wrongAnswer++;


            }
            answer.setText("");
            NewExample newEx =new NewExample();
            firstNum.setText(String.valueOf(newEx.newExam()));
            secondNumber.setText(String.valueOf(newEx.newExam()));
            addHistory(a,b);
        }

        if (count == 11) {

            if (wrongAnswer == 0) {
                finResAnswer.setForeground(Color.GREEN);
                finResAnswer.setText("You Are Super");
                scoreAnswer.setForeground(Color.GREEN);
                scoreAnswer.setText("Your score is 5");
            } else if ( wrongAnswer < 2) {
                finResAnswer.setForeground(Color.BLUE);
                finResAnswer.setText("You Are Good");
                scoreAnswer.setForeground(Color.BLUE);
                scoreAnswer.setText("Your score is 4");

            } else if ( wrongAnswer < 3) {
                finResAnswer.setForeground(Color.ORANGE);
                finResAnswer.setText("You Are NOT Good");
                scoreAnswer.setForeground(Color.ORANGE);
                scoreAnswer.setText("Your score is 3");

            } else {
                finResAnswer.setForeground(Color.RED);
                finResAnswer.setText("Very BAD try again");
                scoreAnswer.setForeground(Color.RED);
                scoreAnswer.setText("Your score is 2");
            }
            checkExample.setEnabled(false);
            newExample.setEnabled(true);
            finResAnswer.setVisible(true);
            scoreAnswer.setVisible(true);


        }

        if (e.getSource() == newExample){

            count = 1;
            example1.setText("");
            example2.setText("");
            example3.setText("");
            example4.setText("");
            example5.setText("");
            example6.setText("");
            example7.setText("");
            example8.setText("");
            example9.setText("");
            example10.setText("");
            scoreAnswer.setText("");
            finResAnswer.setText("");
            wrongAnswer = 0;
            finResAnswer.setVisible(false);
            scoreAnswer.setVisible(false);
            NewExample newEx =new NewExample();
            firstNum.setText(String.valueOf(newEx.newExam()));
            secondNumber.setText(String.valueOf(newEx.newExam()));
            answer.setText("");
            answer.setForeground(Color.orange);
            massegeLabel.setText("Try to do it");
            checkExample.setEnabled(true);
            newExample.setEnabled(false);


        }

 }
     private void addHistory (int a, int b) {
         if (count == 1) {
             example1.setText(a + " * " + b + " = " + answer.getText() + " " + massegeLabel.getText());
             if (massegeLabel.getText().equals("WRONG")){
                 example1.setForeground(Color.red);
             } else {
                 example1.setForeground(Color.BLUE);
             }

         } else if (count == 2) {
             example2.setText(a + " * " + b + " = " + answer.getText() + " " + massegeLabel.getText());
             if (massegeLabel.getText().equals("WRONG")){
                 example2.setForeground(Color.red);
             } else {
                 example2.setForeground(Color.BLUE);
             }

         } else if (count == 3) {
             example3.setText(a + " * " + b + " = " + answer.getText() + " " + massegeLabel.getText());
             if (massegeLabel.getText().equals("WRONG")){
                 example3.setForeground(Color.red);
             } else {
                 example3.setForeground(Color.BLUE);
             }

         } else if (count == 4) {
             example4.setText(a + " * " + b + " = " + answer.getText() + " " + massegeLabel.getText());
             if (massegeLabel.getText().equals("WRONG")){
                 example4.setForeground(Color.red);
             } else {
                 example4.setForeground(Color.BLUE);
             }

         }else if (count == 5) {
             example5.setText(a + " * " + b + " = " + answer.getText() + " " + massegeLabel.getText());
             if (massegeLabel.getText().equals("WRONG")){
                 example5.setForeground(Color.red);
             } else {
                 example5.setForeground(Color.BLUE);
             }

         }else if (count == 6) {
             example6.setText(a + " * " + b + " = " + answer.getText() + " " + massegeLabel.getText());
             if (massegeLabel.getText().equals("WRONG")){
                 example6.setForeground(Color.red);
             } else {
                 example6.setForeground(Color.BLUE);
             }

         }else if (count == 7) {
             example7.setText(a + " * " + b + " = " + answer.getText() + " " + massegeLabel.getText());
             if (massegeLabel.getText().equals("WRONG")){
                 example7.setForeground(Color.red);
             } else {
                 example7.setForeground(Color.BLUE);
             }

         }else if (count == 8) {
             example8.setText(a + " * " + b + " = " + answer.getText() + " " + massegeLabel.getText());
             if (massegeLabel.getText().equals("WRONG")){
                 example8.setForeground(Color.red);
             } else {
                 example8.setForeground(Color.BLUE);
             }

         }else if (count == 9) {
             example9.setText(a + " * " + b + " = " + answer.getText() + " " + massegeLabel.getText());
             if (massegeLabel.getText().equals("WRONG")){
                 example9.setForeground(Color.red);
             } else {
                 example9.setForeground(Color.BLUE);
             }


         }else if (count == 10) {
             example10.setText(a + " * " + b + " = " + answer.getText() + " " + massegeLabel.getText());
             if (massegeLabel.getText().equals("WRONG")){
                 example10.setForeground(Color.red);
             } else {
                 example10.setForeground(Color.BLUE);
             }
         }
         count++;
     }


}

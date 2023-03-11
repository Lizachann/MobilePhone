import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Standard_Calculator extends JFrame{
    private JFrame frame;
    private JTextField tf1;
    public Standard_Calculator(){
        Font font1 = new Font("Times New Roman", Font.BOLD,18);

        frame = new JFrame("Standard Calculator");

        ImageIcon imgIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("image\\calculator.jpg")));
        frame.setIconImage(imgIcon.getImage());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setBounds(100, 100, 360, 500);  //Size of Scientific Calculator
//        frame.setBorder(new EmptyBorder(5, 5, 5, 5));
//        frame.setContentPane(frame);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        //		------------------------- Change Button -------------------------
        JButton btnChange = new JButton("Scientific Mode");
        btnChange.setFont(font1);
        btnChange.setBackground(new Color(203, 224, 234));
        btnChange.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                frame.dispose();
                frame.setVisible(false);
                new Scientific_Calculator();
            }
        });
        btnChange.setBounds(90, 70, 165, 60);
        frame.add(btnChange);

        //		-------------------------- Output Label -------------------------
        tf1 = new JTextField("0");
        tf1.setHorizontalAlignment(SwingConstants.RIGHT);
        tf1.setFont(new Font("Times New Roman", Font.BOLD, 32));
        tf1.setBounds(5, 5, 335, 60);
        frame.add(tf1);
        tf1.setColumns(10);
        tf1.setEditable(false);

        //		------------------------- Number Button -------------------------
        JButton btn0 = new JButton("0");
        btn0.setFont(font1);
        btn0.setBackground(new Color(213, 213, 223, 255));
        btn0.setBounds(90, 330, 80, 60);
        frame.add(btn0);
        btn0.addActionListener(new NumberActionListener(tf1, "0"));

        JButton btn1 = new JButton("1");
        btn1.setFont(font1);
        btn1.setBackground(new Color(213, 213, 223));
        btn1.setBounds(5, 265, 80, 60);
        frame.add(btn1);
        btn1.addActionListener(new NumberActionListener(tf1, "1"));

        JButton btn2 = new JButton("2");
        btn2.setFont(font1);
        btn2.setBackground(new Color(213, 213, 223));
        btn2.setBounds(90, 265, 80, 60);
        frame.add(btn2);
        btn2.addActionListener(new NumberActionListener(tf1, "2"));

        JButton btn3 = new JButton("3");
        btn3.setFont(font1);
        btn3.setBackground(new Color(213, 213, 223));
        btn3.setBounds(175, 265, 80, 60);
        frame.add(btn3);
        btn3.addActionListener(new NumberActionListener(tf1, "3"));

        JButton btn4 = new JButton("4");
        btn4.setFont(font1);
        btn4.setBackground(new Color(213, 213, 223));
        btn4.setBounds(5, 200, 80, 60);
        frame.add(btn4);
        btn4.addActionListener(new NumberActionListener(tf1, "4"));

        JButton btn5 = new JButton("5");
        btn5.setFont(font1);
        btn5.setBackground(new Color(213, 213, 223));
        btn5.setBounds(90, 200, 80, 60);
        frame.add(btn5);
        btn5.addActionListener(new NumberActionListener(tf1, "5"));

        JButton btn6 = new JButton("6");
        btn6.setFont(font1);
        btn6.setBackground(new Color(213, 213, 223));
        btn6.setBounds(175, 200, 80, 60);
        frame.add(btn6);
        btn6.addActionListener(new NumberActionListener(tf1, "6"));

        JButton btn7 = new JButton("7");
        btn7.setFont(font1);
        btn7.setBackground(new Color(213, 213, 223));
        btn7.setBounds(5, 135, 80, 60);
        frame.add(btn7);
        btn7.addActionListener(new NumberActionListener(tf1, "7"));

        JButton btn8 = new JButton("8");
        btn8.setFont(font1);
        btn8.setBackground(new Color(213, 213, 223));
        btn8.setBounds(90, 135, 80, 60);
        frame.add(btn8);
        btn8.addActionListener(new NumberActionListener(tf1, "8"));

        JButton btn9 = new JButton("9");
        btn9.setFont(font1);
        btn9.setBackground(new Color(213, 213, 223));
        btn9.setBounds(175, 135, 80, 60);
        frame.add(btn9);
        btn9.addActionListener(new NumberActionListener(tf1, "9"));

        JButton btnDot = new JButton(".");
        btnDot.setFont(font1);
        btnDot.setBackground(new Color(213, 213, 223));
        btnDot.setBounds(5, 330, 80, 60);
        frame.add(btnDot);
        btnDot.addActionListener(new NumberActionListener(tf1, "."));

        //		------------------------ Operator Button ------------------------
        JButton btnEqual = new JButton("=");
        btnEqual.setFont(font1);
        btnEqual.setBackground(new Color(50, 192, 67));
        btnEqual.setBounds(260, 330, 80, 60);
        frame.add(btnEqual);
        btnEqual.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    tf1.setText(Calculator_Answer.answerMain(tf1.getText()).toString());
                } catch (Exception exception) {
                    tf1.setText("Incorrect Expression");
                }
            }
        });

        JButton btnBackspace = new JButton("←");
        btnBackspace.setFont(font1);
        btnBackspace.setBackground(new Color(130, 140, 194, 255));
        btnBackspace.setBounds(260,70,80,60);
        frame.add(btnBackspace);
        btnBackspace.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String backspace = null;

                if (tf1.getText().length() > 0) {
                    StringBuilder strB = new StringBuilder(tf1.getText());
                    strB.deleteCharAt(tf1.getText().length() - 1);
                    backspace = String.valueOf(strB);
                    tf1.setText(backspace);
                }
            }
        });

        JButton btnPlus = new JButton("+");
        btnPlus.setFont(font1);
        btnPlus.setBackground(new Color(130, 140, 194, 255));
        btnPlus.setBounds(260, 265, 80, 60);
        frame.add(btnPlus);
        btnPlus.addActionListener(new OperatorActionListener(tf1, "+"));

        JButton btnSub = new JButton("-");
        btnSub.setFont(font1);
        btnSub.setBackground(new Color(130, 140, 194, 255));
        btnSub.setBounds(260, 200, 80, 60);
        frame.add(btnSub);
        btnSub.addActionListener(new OperatorActionListener(tf1, "-"));

        JButton btnMul = new JButton("*");
        btnMul.setFont(font1);
        btnMul.setBackground(new Color(130, 140, 194, 255));
        btnMul.setBounds(260, 135, 80, 60);
        frame.add(btnMul);
        btnMul.addActionListener(new OperatorActionListener(tf1, "*"));

        JButton btnDiv = new JButton("/");
        btnDiv.setFont(font1);
        btnDiv.setBackground(new Color(130, 140, 194, 255));
        btnDiv.setBounds(175, 330, 80, 60);
        frame.add(btnDiv);
        btnDiv.addActionListener(new OperatorActionListener(tf1, "/"));

        //reset button
        JButton btnRes = new JButton("AC");
        btnRes.setFont(font1);
        btnRes.setBackground(new Color(130, 140, 194, 255));
        btnRes.setBounds(5, 70, 80, 60);
        frame.add(btnRes);
        btnRes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tf1.setText("0");
            }
        });

        JButton  btnHome = new Main.RoundButton("");
        btnHome.setBounds(150,410,45,45);
        btnHome.setBackground(new Color(0xBBBBBB));
        btnHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                frame.setVisible(false);
                new MainInterface();
            }
        });
        frame.add(btnHome);

        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new Standard_Calculator();
    }
}
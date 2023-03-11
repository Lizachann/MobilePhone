import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import javax.swing.*;

public class Scientific_Calculator extends JFrame {
    private JFrame frame;
    private JTextField tf1;

    //		------------------------- Creating Frame ------------------------
    public Scientific_Calculator() {
        Font font1 = new Font("Times New Roman", Font.BOLD,18);
        frame = new JFrame("Scientific Calculator");

        ImageIcon imgIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("image\\calculator.jpg")));
        frame.setIconImage(imgIcon.getImage());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setBounds(100, 100, 500, 370);  //Size of Scientific Calculator

//        frame.setBorder(new EmptyBorder(5, 5, 5, 5));
//        frame.setContentPane(frame);
        frame.setLayout(null);

        frame.setLocationRelativeTo(null);

//		------------------------- Change Button -------------------------
        JButton btnChange = new JButton("Standard Mode");
        btnChange.setFont(font1);
        btnChange.setBackground(new Color(203, 224, 234));
        btnChange.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                frame.dispose();
                frame.setVisible(false); //sci calc invisible
//                new Standard_Calculator().setVisible(true);  //std calc visible
                new Standard_Calculator();
            }
        });
        btnChange.setBounds(85, 55, 155, 50);
        frame.add(btnChange);

//		-------------------------- Output Label -------------------------
        tf1 = new JTextField("0");
        tf1.setHorizontalAlignment(SwingConstants.RIGHT);
        tf1.setFont(new Font("Times New Roman", Font.BOLD, 32));
        tf1.setBounds(5, 5, 475, 45);
        frame.add(tf1);
        tf1.setColumns(10);
        tf1.setEditable(false);  //textField cannot be edited

//		------------------------- Number Button -------------------------
        JButton btn0 = new JButton("0");
        btn0.setFont(font1);
        btn0.setBackground(new Color(213, 213, 223));
        btn0.setBounds(85, 275, 75, 50);
        frame.add(btn0);
        btn0.addActionListener(new NumberActionListener(tf1, "0"));

        JButton btn1 = new JButton("1");
        btn1.setFont(font1);
        btn1.setBackground(new Color(213, 213, 223));
        btn1.setBounds(5, 220, 75, 50);
        frame.add(btn1);
        btn1.addActionListener(new NumberActionListener(tf1, "1"));

        JButton btn2 = new JButton("2");
        btn2.setFont(font1);
        btn2.setBackground(new Color(213, 213, 223));
        btn2.setBounds(85, 220, 75, 50);
        frame.add(btn2);
        btn2.addActionListener(new NumberActionListener(tf1, "2"));

        JButton btn3 = new JButton("3");
        btn3.setFont(font1);
        btn3.setBackground(new Color(213, 213, 223));
        btn3.setBounds(165, 220, 75, 50);
        frame.add(btn3);
        btn3.addActionListener(new NumberActionListener(tf1, "3"));

        JButton btn4 = new JButton("4");
        btn4.setFont(font1);
        btn4.setBackground(new Color(213, 213, 223));
        btn4.setBounds(5, 165, 75, 50);
        frame.add(btn4);
        btn4.addActionListener(new NumberActionListener(tf1, "4"));

        JButton btn5 = new JButton("5");
        btn5.setFont(font1);
        btn5.setBackground(new Color(213, 213, 223));
        btn5.setBounds(85, 165, 75, 50);
        frame.add(btn5);
        btn5.addActionListener(new NumberActionListener(tf1, "5"));

        JButton btn6 = new JButton("6");
        btn6.setFont(font1);
        btn6.setBackground(new Color(213, 213, 223));
        btn6.setBounds(165, 165, 75, 50);
        frame.add(btn6);
        btn6.addActionListener(new NumberActionListener(tf1, "6"));

        JButton btn7 = new JButton("7");
        btn7.setFont(font1);
        btn7.setBackground(new Color(213, 213, 223));
        btn7.setBounds(5, 110, 75, 50);
        frame.add(btn7);
        btn7.addActionListener(new NumberActionListener(tf1, "7"));

        JButton btn8 = new JButton("8");
        btn8.setFont(font1);
        btn8.setBackground(new Color(213, 213, 223));
        btn8.setBounds(85, 110, 75, 50);
        frame.add(btn8);
        btn8.addActionListener(new NumberActionListener(tf1, "8"));

        JButton btn9 = new JButton("9");
        btn9.setFont(font1);
        btn9.setBackground(new Color(213, 213, 223));
        btn9.setBounds(165, 110, 75, 50);
        frame.add(btn9);
        btn9.addActionListener(new NumberActionListener(tf1, "9"));

        JButton btnDot = new JButton(".");
        btnDot.setFont(font1);
        btnDot.setBackground(new Color(213, 213, 223));
        btnDot.setBounds(5, 275, 75, 50);
        frame.add(btnDot);
        btnDot.addActionListener(new NumberActionListener(tf1, "."));


//		------------------------ Operator Button ------------------------
        JButton btnEqual = new JButton("=");
        btnEqual.setFont(font1);
        btnEqual.setBackground(new Color(50, 192, 67));
        btnEqual.setBounds(245, 275, 75, 50);
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

        JButton btnPlus = new JButton("+");
        btnPlus.setFont(font1);
        btnPlus.setBackground(new Color(130, 140, 194, 255));
        btnPlus.setBounds(245, 220, 75, 50);
        frame.add(btnPlus);
        btnPlus.addActionListener(new OperatorActionListener(tf1, "+"));

        JButton btnSub = new JButton("-");
        btnSub.setFont(font1);
        btnSub.setBackground(new Color(130, 140, 194, 255));
        btnSub.setBounds(245, 165, 75, 50);
        frame.add(btnSub);
        btnSub.addActionListener(new OperatorActionListener(tf1, "-"));

        JButton btnMul = new JButton("*");
        btnMul.setFont(font1);
        btnMul.setBackground(new Color(130, 140, 194, 255));
        btnMul.setBounds(245, 110, 75, 50);
        frame.add(btnMul);
        btnMul.addActionListener(new OperatorActionListener(tf1, "*"));

        JButton btnDiv = new JButton("/");
        btnDiv.setFont(font1);
        btnDiv.setBackground(new Color(130, 140, 194, 255));
        btnDiv.setBounds(165, 275, 75, 50);
        frame.add(btnDiv);
        btnDiv.addActionListener(new OperatorActionListener(tf1, "/"));

        JButton btnLeftBracket = new JButton("(");
        btnLeftBracket.setFont(font1);
        btnLeftBracket.setBackground(new Color(130, 140, 194, 255));
        btnLeftBracket.setBounds(325, 55, 75, 50);
        frame.add(btnLeftBracket);
        btnLeftBracket.addActionListener(new BracketActionListener(tf1, "("));

        JButton btnRightBracket = new JButton(")");
        btnRightBracket.setFont(font1);
        btnRightBracket.setBackground(new Color(130, 140, 194, 255));
        btnRightBracket.setBounds(405, 55, 75, 50);
        frame.add(btnRightBracket);
        btnRightBracket.addActionListener(new BracketActionListener(tf1, ")"));

        //reset button
        JButton btnRes = new JButton("AC");
        btnRes.setFont(font1);
        btnRes.setBackground(new Color(130, 140, 194, 255));
        btnRes.setBounds(5, 55, 75, 50);
        frame.add(btnRes);
        btnRes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tf1.setText("0");
            }
        });

        JButton btnBackspace = new JButton("←");
        btnBackspace.setFont(font1);
        btnBackspace.setBackground(new Color(130, 140, 194, 255));
        btnBackspace.setBounds(245,55,75,50);
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

//		------------------ Mathematical Function Button ------------------
        JButton btnSin = new JButton("sin");
        btnSin.setFont(font1);
        btnSin.setBackground(new Color(130, 140, 194, 255));
        btnSin.setBounds(325, 110, 75, 50);
        frame.add(btnSin);
        btnSin.addActionListener(new MathematicalFunctionActionListener(tf1, "sin"));

        JButton btnCos = new JButton("cos");
        btnCos.setFont(font1);
        btnCos.setBackground(new Color(130, 140, 194, 255));
        btnCos.setBounds(325, 165, 75, 50);
        frame.add(btnCos);
        btnCos.addActionListener(new MathematicalFunctionActionListener(tf1, "cos"));

        JButton btnTan = new JButton("tan");
        btnTan.setFont(font1);
        btnTan.setBackground(new Color(130, 140, 194, 255));
        btnTan.setBounds(405, 110, 75, 50);
        frame.add(btnTan);
        btnTan.addActionListener(new MathematicalFunctionActionListener(tf1, "tan"));

        JButton btnPi = new JButton("\u03C0");
        btnPi.setFont(font1);
        btnPi.setBackground(new Color(130, 140, 194, 255));
        btnPi.setBounds(405, 165, 75, 50);
        frame.add(btnPi);
        btnPi.addActionListener(new MathematicalFunctionActionListener(tf1, "\u03C0"));

        JButton btnE = new JButton("e");
        btnE.setFont(font1);
        btnE.setBackground(new Color(130, 140, 194, 255));
        btnE.setBounds(325, 220, 75, 50);
        frame.add(btnE);
        btnE.addActionListener(new MathematicalFunctionActionListener(tf1, "e"));

        JButton btnRoot = new JButton("\u221A");
        btnRoot.setFont(font1);
        btnRoot.setBackground(new Color(130, 140, 194, 255));
        btnRoot.setBounds(405, 220, 75, 50);
        frame.add(btnRoot);
        btnRoot.addActionListener(new MathematicalFunctionActionListener(tf1, "\u221A")); // \u221A is √

        JButton btnSq = new JButton("x\u00B2");
        btnSq.setFont(font1);
        btnSq.setBackground(new Color(130, 140, 194, 255));
        btnSq.setBounds(325, 275, 75, 50);
        frame.add(btnSq);
        btnSq.addActionListener(new powerActionListener(tf1, "(^2)"));

        JButton btnLog = new JButton("log");
        btnLog.setFont(font1);
        btnLog.setBackground(new Color(130, 140, 194, 255));
        btnLog.setBounds(405, 275, 75, 50);
        frame.add(btnLog);
        btnLog.addActionListener(new MathematicalFunctionActionListener(tf1, "log"));

        frame.setVisible(true);
    }
    //		--------------------- Launch the application --------------------
    public static void main(String[] args) {
//        Scientific_Calculator frame = new Scientific_Calculator();
//        frame.setVisible(true);
        new Scientific_Calculator();
    }
}

//------------------------ Number ActionListener ------------------------
class NumberActionListener implements ActionListener {
    private JTextField textField;
    private String input;
    public NumberActionListener(JTextField textField, String input) {
        this.textField = textField;
        this.input = input;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String current = textField.getText();

        /* "0" is what alr in the textField so check if the input is 0 or not
         *   if the input is zero the same as what in textField do nothing */
        if ("0".equals(current) && "0".equals(input)) {
            return;
        }
        else if ("0".equals(current) && ".".equals(input)){
            textField.setText("0" + input);
        }
        else if ("0".equals(current)) {
            textField.setText(input);
        }
        else {
            textField.setText(current + input);
        }
    }
}

//----------------------- Operator ActionListener -----------------------
class OperatorActionListener implements ActionListener {
    private JTextField textField;
    private String input;
    public OperatorActionListener(JTextField textField, String input) {
        this.textField = textField;
        this.input = input;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /*Example if we have textField = 2+1 and user input + operation it's mean this current is 2+1 */
        String current = textField.getText();
//        System.out.println(current);

        /* Example 2+1 , 2+ is length=2, then length-1=1 = index 1
         * which means plus sign will be at index 1 */
        char recent = textField.getText().charAt(textField.getText().length() - 1);

        /* If the current textField is "0" applying *+/ do nothing */
        if ("0".equals(current) && ("*".equals(input) || "/".equals(input) || "+".equals(input))) {
            return;
        }
        /* If the current textField is "0" apply - will override "0" tp "-" */
        else if ("0".equals(current) && "-".equals(input)) {
            textField.setText(input);
            return;
        }
        /*if the new operator input is NOT '-" and the recent is * + / ( - do nothing
         * or the new operator is "-" and the recent is also "-" or recent is "."
         * also do nothing */
        else if ( (!"-".equals(input) && (recent == '(' || recent == '*'
                || recent == '/' || recent == '+' || recent == '-') )
                || ("-".equals(input) && recent == '-') || recent == '.') {
            return;
        }
        else {
            textField.setText(current + input);
        }
    }
}

//----------------------- Bracket ActionListener -----------------------
class BracketActionListener implements ActionListener {
    private JTextField textField;
    private String input;
    public BracketActionListener(JTextField textField, String input) {
        this.textField = textField;
        this.input = input;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String current = textField.getText();
        int leftBracket = 0, rightBracket = 0;

        for (int i = 0; i<current.length(); i++) {
            leftBracket = current.charAt(i) == '(' ? ++leftBracket : leftBracket;
            rightBracket = current.charAt(i) == ')' ? ++rightBracket : rightBracket;
        }

        /* if current textField = 0 can input "(" */
        if ("(".equals(input) && "0".equals(current)) {
            textField.setText(input);
        }
        /* Whatever they input "(" or ")" if leftbrack > rightbrack, they can input */
        else if ( ("(".equals(input)) || (")".equals(input) && leftBracket > rightBracket) ) {
            textField.setText(current + input);
        }
        else {
            return;
        }
    }
}

//-------------------- Mathematical Function ActionListener --------------------
class MathematicalFunctionActionListener implements ActionListener {
    private JTextField textField;
    private String input;
    public MathematicalFunctionActionListener(JTextField textField, String input) {
        this.textField = textField;
        this.input = input;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (("\u03C0".equals(input) || "e".equals(input)) && "0".equals(textField.getText())) { // \u03C0 is π
            textField.setText(input);
        }
        else if (("\u03C0".equals(input) || "e".equals(input)) && !"0".equals(textField.getText())) {
            textField.setText(textField.getText() + input);
        }
        else if ("0".equals(textField.getText())) {
            textField.setText(input + "(");
        }
        else {
            textField.setText(textField.getText() + input + "(");
        }
    }
}

//---------------------------- Power ActionListener ----------------------------
class powerActionListener implements ActionListener {
    private JTextField textField;
    private String input;
    public powerActionListener(JTextField textField, String input) {
        this.textField = textField;
        this.input = input;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        char recent = textField.getText().charAt(textField.getText().length() - 1);

        if (!"0".equals(textField.getText()) && ((recent >= 48 && recent <= 57) || recent == 'e' || recent == '\u03C0')) { // \u03C0 is π
            textField.setText(textField.getText() + input);
        }
        else {
            return;
        }
    }
}

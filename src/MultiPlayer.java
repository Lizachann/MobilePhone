import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class MultiPlayer {
    public JFrame frame;
    public JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,home,newGame;
    public JLabel l1,l2,l3,l4;
    public int count=0;
    public int xWin=0,oWin=0;
    public int checkWin(){

//        if(b1.getText().equals("X") && b2.getText()=="X" && b3.getText()=="X") return 1;
//        else if(b4.getText()=="X" && b5.getText()=="X" && b6.getText()=="X") return 1;
//        else if(b7.getText()=="X" && b8.getText()=="X" && b9.getText()=="X") return 1;
//        else if(b1.getText()=="X" && b4.getText()=="X" && b7.getText()=="X") return 1;
//        else if(b2.getText()=="X" && b5.getText()=="X" && b8.getText()=="X") return 1;
//        else if(b3.getText()=="X" && b6.getText()=="X" && b9.getText()=="X") return 1;
//        else if(b1.getText()=="X" && b5.getText()=="X" && b9.getText()=="X") return 1;
//        else if(b3.getText()=="X" && b5.getText()=="X" && b7.getText()=="X") return 1;
//        else if(b1.getText()=="O" && b2.getText()=="O" && b3.getText()=="O") return 2;
//        else if(b4.getText()=="O" && b5.getText()=="O" && b6.getText()=="O") return 2;
//        else if(b7.getText()=="O" && b8.getText()=="O" && b9.getText()=="O") return 2;
//        else if(b1.getText()=="O" && b4.getText()=="O" && b7.getText()=="O") return 2;
//        else if(b2.getText()=="O" && b5.getText()=="O" && b8.getText()=="O") return 2;
//        else if(b3.getText()=="O" && b6.getText()=="O" && b9.getText()=="O") return 2;
//        else if(b1.getText()=="O" && b5.getText()=="O" && b9.getText()=="O") return 2;
//        else if(b3.getText()=="O" && b5.getText()=="O" && b7.getText()=="O") return 2;
//        else return 0;

        if(b1.getText().equals(b2.getText())&&b2.getText().equals(b3.getText())&&b1.getText()!=""&&b2.getText()!=""&&b3.getText()!=""){
            if (b1.getText().equals("X"))  return 1;
            else if (b1.getText().equals("O")) return 2;
        }else if(b4.getText().equals(b5.getText())&&b5.getText().equals(b6.getText())&&b4.getText()!=""&&b5.getText()!=""&&b6.getText()!=""){
            if (b4.getText().equals("X"))  return 1;
            else if (b4.getText().equals("O")) return 2;
        }else if(b7.getText().equals(b8.getText())&&b8.getText().equals(b9.getText())&&b7.getText()!=""&&b8.getText()!=""&&b9.getText()!=""){
            if (b7.getText().equals("X"))  return 1;
            else if (b7.getText().equals("O")) return 2;
        }else if(b1.getText().equals(b4.getText())&&b4.getText().equals(b7.getText())&&b1.getText()!=""&&b4.getText()!=""&&b7.getText()!=""){
            if (b1.getText().equals("X"))  return 1;
            else if (b1.getText().equals("O")) return 2;
        }else if(b2.getText().equals(b5.getText())&&b5.getText().equals(b8.getText())&&b2.getText()!=""&&b5.getText()!=""&&b8.getText()!=""){
            if (b2.getText().equals("X"))  return 1;
            else if (b2.getText().equals("O")) return 2;
        }else if(b3.getText().equals(b6.getText())&&b6.getText().equals(b9.getText())&&b3.getText()!=""&&b6.getText()!=""&&b9.getText()!=""){
            if (b3.getText().equals("X"))  return 1;
            else if (b3.getText().equals("O")) return 2;
        }else if(b1.getText().equals(b5.getText())&&b5.getText().equals(b9.getText())&&b1.getText()!=""&&b5.getText()!=""&&b9.getText()!=""){
            if (b1.getText().equals("X"))  return 1;
            else if (b1.getText().equals("O")) return 2;
        }else if(b3.getText().equals(b5.getText())&&b5.getText().equals(b7.getText())&&b3.getText()!=""&&b5.getText()!=""&&b7.getText()!=""){
            if (b3.getText().equals("X"))  return 1;
            else if (b3.getText().equals("O")) return 2;
        }
        return 0;
    }
    public void clearBoard(){
        count=0;

        b1.setText("");
        b2.setText("");
        b3.setText("");
        b4.setText("");
        b5.setText("");
        b6.setText("");
        b7.setText("");
        b8.setText("");
        b9.setText("");
        l4.setForeground(Color.RED);
        l4.setText("X Turn");

    }
    public void whoWin(){
        int winner = checkWin();
        if(winner==1){
            JOptionPane.showMessageDialog(frame,"X Win");
            xWin++;
            l1.setText("Player X : " + xWin);
            clearBoard();
        }else if(winner==2){
            JOptionPane.showMessageDialog(frame,"O Win");
            oWin++;
            l2.setText("Player O : " + oWin);
            clearBoard();
        }else if(count==9&&winner==0){
            JOptionPane.showMessageDialog(frame,"draw");
            clearBoard();
        }
    }
    public void whoTurn(JButton button){
        if(count%2==0){
            button.setForeground(Color.BLUE);
            button.setText("O");
        }else if(count%2==1){
            button.setForeground(Color.RED);
            button.setText("X");
        }
        if(button.getText()=="X"){
            l4.setText("O Turn");
            l4.setForeground(Color.BLUE);
        }else if(button.getText()=="O"){
            l4.setText("X Turn");
            l4.setForeground(Color.RED);
        }
    }
    public MultiPlayer(){
        frame = new JFrame("Tic-Tac-Toe");

        frame.setContentPane(new JLabel(new ImageIcon(Objects.requireNonNull(getClass().getResource("image\\tic_tac_toe.jpg")))));

        ImageIcon img = new ImageIcon(Objects.requireNonNull(getClass().getResource("image\\tic-tac-toe-icon.jpg")));
        frame.setIconImage(img.getImage());

        l1=new JLabel("Player X : 0");
        l1.setForeground(Color.RED);
        l1.setBounds(50,65,100,30);
        frame.add(l1);

        l2=new JLabel("Player O : 0");
        l2.setForeground(Color.BLUE);
        l2.setBounds(50,95,100,30);
        frame.add(l2);

        l3=new JLabel("Tic Tac Toe");
        l3.setBounds(100,15,300,30);
        l3.setFont(new Font("Times New Roman", Font.BOLD,30));
        l3.setForeground(new Color(70, 255, 255));
        frame.add(l3);

        l4=new JLabel("X Turn");
        l4.setForeground(Color.red);
        l4.setBounds(155,360,100,30);
        frame.add(l4);

        newGame = new JButton("New Game");
        newGame.setBounds(200,70,100,50);
        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                oWin=0;
                xWin=0;
                l1.setText("Player X : " + xWin);
                l2.setText("Player O : " + oWin);
                clearBoard();
            }
        });
        frame.add(newGame);


        b1 = new JButton();
        b1.setBackground(new Color(0xE6E6FF));
        b1.setBounds(70,150,70,70);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(b1.getText()==""|| b1.getText() ==null){
                    count++;
                    whoTurn(b1);
                }
                whoWin();
            }
        });
        frame.add(b1);

        b2 = new JButton();
        b2.setBackground(new Color(0xE6E6FF));
        b2.setBounds(140,150,70,70);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(b2.getText()==""|| b2.getText() ==null) {
                    count++;
                    whoTurn(b2);
                }
                whoWin();

            }
        });
        frame.add(b2);

        b3 = new JButton();
        b3.setBackground(new Color(0xE6E6FF));
        b3.setBounds(210,150,70,70);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(b3.getText()==""|| b3.getText() ==null){
                    count++;
                    whoTurn(b3);
                }
                whoWin();

            }
        });
        frame.add(b3);

        b4 = new JButton();
        b4.setBackground(new Color(0xE6E6FF));
        b4.setBounds(70,220,70,70);
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(b4.getText()==""|| b4.getText() ==null){
                    count++;
                    whoTurn(b4);
                }
                whoWin();

            }
        });
        frame.add(b4);

        b5 = new JButton();
        b5.setBackground(new Color(0xE6E6FF));
        b5.setBounds(140,220,70,70);
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(b5.getText()==""|| b5.getText() ==null){
                    count++;
                    whoTurn(b5);
                }
                whoWin();

            }
        });
        frame.add(b5);

        b6 = new JButton();
        b6.setBackground(new Color(0xE6E6FF));
        b6.setBounds(210,220,70,70);
        b6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(b6.getText()==""|| b6.getText() ==null){
                    count++;
                    whoTurn(b6);
                }
                whoWin();
            }
        });
        frame.add(b6);

        b7 = new JButton();
        b7.setBackground(new Color(0xE6E6FF));
        b7.setBounds(70,290,70,70);
        b7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(b7.getText()==""|| b7.getText() ==null){
                    count++;
                    whoTurn(b7);
                }
                whoWin();
            }
        });
        frame.add(b7);

        b8 = new JButton();
        b8.setBackground(new Color(0xE6E6FF));
        b8.setBounds(140,290,70,70);
        b8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(b8.getText()==""|| b8.getText() ==null){
                    count++;
                    whoTurn(b8);
                }
                whoWin();
            }
        });
        frame.add(b8);

        b9 = new JButton();
        b9.setBackground(new Color(0xE6E6FF));
        b9.setBounds(210,290,70,70);
        b9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(b9.getText()==""|| b9.getText() ==null){
                    count++;
                    whoTurn(b9);
                }
                whoWin();
            }
        });
        frame.add(b9);

        home= new Main.RoundButton("");
        home.setBounds(150,410,45,45);
        home.setBackground(new Color(0xBBBBBB));

        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                frame.setVisible(false);
                new Tic_Tac_Toe();
            }
        });
        frame.add(home);

        frame.setLayout(null);
        frame.setSize(360,500);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main (String args[]) {
        new MultiPlayer();
    }
}
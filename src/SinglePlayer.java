import javax.swing.*;
import javax.swing.plaf.metal.MetalButtonUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.Random;

public class SinglePlayer implements ActionListener{
    public JFrame frame;
    public JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,home,newGame;
    public JLabel l1,l2,l3,l4;
    public int count=0;
    public int xWin=0,oWin=0;
    public int checkWin(){
        if(b1.getText().equals("X") && b2.getText()=="X" && b3.getText()=="X") return 1;
        else if(b4.getText()=="X" && b5.getText()=="X" && b6.getText()=="X") return 1;
        else if(b7.getText()=="X" && b8.getText()=="X" && b9.getText()=="X") return 1;
        else if(b1.getText()=="X" && b4.getText()=="X" && b7.getText()=="X") return 1;
        else if(b2.getText()=="X" && b5.getText()=="X" && b8.getText()=="X") return 1;
        else if(b3.getText()=="X" && b6.getText()=="X" && b9.getText()=="X") return 1;
        else if(b1.getText()=="X" && b5.getText()=="X" && b9.getText()=="X") return 1;
        else if(b3.getText()=="X" && b5.getText()=="X" && b7.getText()=="X") return 1;
        else if(b1.getText()=="O" && b2.getText()=="O" && b3.getText()=="O") return 2;
        else if(b4.getText()=="O" && b5.getText()=="O" && b6.getText()=="O") return 2;
        else if(b7.getText()=="O" && b8.getText()=="O" && b9.getText()=="O") return 2;
        else if(b1.getText()=="O" && b4.getText()=="O" && b7.getText()=="O") return 2;
        else if(b2.getText()=="O" && b5.getText()=="O" && b8.getText()=="O") return 2;
        else if(b3.getText()=="O" && b6.getText()=="O" && b9.getText()=="O") return 2;
        else if(b1.getText()=="O" && b5.getText()=="O" && b9.getText()=="O") return 2;
        else if(b3.getText()=="O" && b5.getText()=="O" && b7.getText()=="O") return 2;
        else return 0;

//        if(b1.getText().equals(b2.getText())&&b2.getText().equals(b3.getText())&&b1.getText()!=""&&b2.getText()!=""&&b3.getText()!=""){
//            if (b1.getText().equals("X"))  return 1;
//            else if (b1.getText().equals("O")) return 2;
//        }else if(b4.getText().equals(b5.getText())&&b5.getText().equals(b6.getText())&&b4.getText()!=""&&b5.getText()!=""&&b6.getText()!=""){
//            if (b4.getText().equals("X"))  return 1;
//            else if (b4.getText().equals("O")) return 2;
//        }else if(b7.getText().equals(b8.getText())&&b8.getText().equals(b9.getText())&&b7.getText()!=""&&b8.getText()!=""&&b9.getText()!=""){
//            if (b7.getText().equals("X"))  return 1;
//            else if (b7.getText().equals("O")) return 2;
//        }else if(b1.getText().equals(b4.getText())&&b4.getText().equals(b7.getText())&&b1.getText()!=""&&b4.getText()!=""&&b7.getText()!=""){
//            if (b1.getText().equals("X"))  return 1;
//            else if (b1.getText().equals("O")) return 2;
//        }else if(b2.getText().equals(b5.getText())&&b5.getText().equals(b8.getText())&&b2.getText()!=""&&b5.getText()!=""&&b8.getText()!=""){
//            if (b2.getText().equals("X"))  return 1;
//            else if (b2.getText().equals("O")) return 2;
//        }else if(b3.getText().equals(b6.getText())&&b6.getText().equals(b9.getText())&&b3.getText()!=""&&b6.getText()!=""&&b9.getText()!=""){
//            if (b3.getText().equals("X"))  return 1;
//            else if (b3.getText().equals("O")) return 2;
//        }else if(b1.getText().equals(b5.getText())&&b5.getText().equals(b9.getText())&&b1.getText()!=""&&b5.getText()!=""&&b9.getText()!=""){
//            if (b1.getText().equals("X"))  return 1;
//            else if (b1.getText().equals("O")) return 2;
//        }else if(b3.getText().equals(b5.getText())&&b5.getText().equals(b7.getText())&&b3.getText()!=""&&b5.getText()!=""&&b7.getText()!=""){
//            if (b3.getText().equals("X"))  return 1;
//            else if (b3.getText().equals("O")) return 2;
//        }
//        return 0;
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
        l4.setText("Your Turn");
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
    public JButton whichButton(int i){
        JButton button = null ;
        if(i==1) button=b1;
        else if (i==2) button=b2;
        else if (i==3) button=b3;
        else if (i==4) button=b4;
        else if (i==5) button=b5;
        else if (i==6) button=b6;
        else if (i==7) button=b7;
        else if (i==8) button=b8;
        else if (i==9) button=b9;
        return button;
    }

    public int checkComputerMove(String who){

        if((b1.getText()== who && b2.getText()==who) && (b3.getText()==null|| b3.getText()=="")){
            return 3;
        }else if((b3.getText()== who && b2.getText()==who) && (b1.getText()==null|| b1.getText()=="")){
            return 1;
        }else if((b1.getText()== who && b3.getText()==who) && (b2.getText()==null|| b2.getText()=="")){
            return 2;
        }else if((b4.getText()== who && b5.getText()==who) && (b6.getText()==null|| b6.getText()=="")){
            return 6;
        }else if((b5.getText()== who && b6.getText()==who) && (b4.getText()==null|| b4.getText()=="")){
            return 4;
        }else if((b4.getText()== who && b6.getText()==who) && (b5.getText()==null|| b5.getText()=="")){
            return 5;
        }else if((b7.getText()== who && b8.getText()==who) && (b9.getText()==null|| b9.getText()=="")){
            return 9;
        }else if((b8.getText()== who && b9.getText()==who) && (b7.getText()==null|| b7.getText()=="")){
            return 7;
        }else if((b7.getText()== who && b9.getText()==who) && (b8.getText()==null|| b8.getText()=="")){
            return 8;
        }else if((b1.getText()== who && b9.getText()==who) && (b5.getText()==null|| b5.getText()=="")){
            return 5;
        }else if((b5.getText()== who && b9.getText()==who) && (b1.getText()==null|| b1.getText()=="")){
            return 1;
        }else if((b1.getText()== who && b5.getText()==who) && (b9.getText()==null|| b9.getText()=="")){
            return 9;
        }else if((b3.getText()== who && b5.getText()==who) && (b7.getText()==null|| b7.getText()=="")){
            return 7;
        }else if((b3.getText()== who && b7.getText()==who) && (b5.getText()==null|| b5.getText()=="")){
            return 5;
        }else if((b5.getText()== who && b7.getText()==who) && (b3.getText()==null|| b3.getText()=="")){
            return 3;
        }else if((b1.getText()== who && b4.getText()==who) && (b7.getText()==null|| b7.getText()=="")){
            return 7;
        }else if((b1.getText()== who && b7.getText()==who) && (b4.getText()==null|| b4.getText()=="")){
            return 4;
        }else if((b7.getText()== who && b4.getText()==who) && (b1.getText()==null|| b1.getText()=="")){
            return 1;
        }else if((b2.getText()== who && b5.getText()==who) && (b8.getText()==null|| b8.getText()=="")){
            return 8;
        }else if((b2.getText()== who && b8.getText()==who) && (b5.getText()==null|| b5.getText()=="")){
            return 5;
        }else if((b5.getText()== who && b8.getText()==who) && (b2.getText()==null|| b2.getText()=="")){
            return 2;
        }else if((b3.getText()== who && b6.getText()==who) && (b9.getText()==null|| b9.getText()=="")){
            return 9;
        }else if((b3.getText()== who && b9.getText()==who) && (b6.getText()==null|| b6.getText()=="")){
            return 6;
        }else if((b6.getText()== who && b9.getText()==who) && (b3.getText()==null|| b3.getText()=="")){
            return 3;
        }
        return 0;
    }

    public void inputO(JButton button){
        button.setForeground(Color.BLUE);
        button.setUI(new MetalButtonUI() {
            protected Color getDisabledTextColor() {
                return Color.BLUE;
            }
        });
        button.setText("O");
        count++;
        l4.setForeground(Color.RED);
        l4.setText("Your Turn");
    }

    public void computerTurn() {
        Random rand = new Random();
        JButton button;
        int computerMove;
        int winMove = checkComputerMove("O");
        if(winMove == 0){
            int defenseMove = checkComputerMove("X");
            if(defenseMove == 0){
                while ( true ) {
                    computerMove = rand.nextInt(9) + 1;
                    button = whichButton(computerMove);
                    if(button.getText()=="" || button.getText()==null){
                        inputO(button);
                        break;
                    }
                }
            }else {
                button = whichButton(defenseMove);
                inputO(button);
            }
        }else {
            button = whichButton(winMove);
            inputO(button);
        }
    }

    public void userTurn(JButton button){
        button.setForeground(Color.RED);
        button.setUI(new MetalButtonUI() {
            protected Color getDisabledTextColor() {
                return Color.RED;
            }
        });
        button.setText("X");
        count++;
        l4.setForeground(Color.BLUE);
        l4.setText("   Waiting ");
    }
    public void whoTurn(JButton button) {
        userTurn(button);
        new Thread (() -> {
            if(count<9 && checkWin()==0){
                try{
                    b1.setEnabled(false);
                    b2.setEnabled(false);
                    b3.setEnabled(false);
                    b4.setEnabled(false);
                    b5.setEnabled(false);
                    b6.setEnabled(false);
                    b7.setEnabled(false);
                    b8.setEnabled(false);
                    b9.setEnabled(false);
                    Thread.sleep(1000);
                    computerTurn();
                    b1.setEnabled(true);
                    b2.setEnabled(true);
                    b3.setEnabled(true);
                    b4.setEnabled(true);
                    b5.setEnabled(true);
                    b6.setEnabled(true);
                    b7.setEnabled(true);
                    b8.setEnabled(true);
                    b9.setEnabled(true);
                }catch(Exception e) {
                    e.printStackTrace();
                }
            }
            whoWin();
        }).start();
    }
    public SinglePlayer(){
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

        l4=new JLabel("Your Turn");
        l4.setForeground(Color.RED);
        l4.setBounds(145,360,100,30);
        frame.add(l4);

        newGame = new JButton("New Game");
        newGame.setBounds(200,70,100,50);
        newGame.addActionListener(this);
        frame.add(newGame);

        b1 = new JButton();
        b1.setBounds(70,150,70,70);
        b1.setBackground(new Color(0xE6E6FF));
        b1.addActionListener(this);
        frame.add(b1);

        b2 = new JButton();
        b2.setBounds(140,150,70,70);
        b2.setBackground(new Color(0xE6E6FF));
        b2.addActionListener(this);
        frame.add(b2);

        b3 = new JButton();
        b3.setBounds(210,150,70,70);
        b3.setBackground(new Color(0xE6E6FF));
        b3.addActionListener(this);
        frame.add(b3);

        b4 = new JButton();
        b4.setBounds(70,220,70,70);
        b4.setBackground(new Color(0xE6E6FF));
        b4.addActionListener(this);
        frame.add(b4);

        b5 = new JButton();
        b5.setBounds(140,220,70,70);
        b5.setBackground(new Color(0xE6E6FF));
        b5.addActionListener(this);
        frame.add(b5);

        b6 = new JButton();
        b6.setBounds(210,220,70,70);
        b6.setBackground(new Color(0xE6E6FF));
        b6.addActionListener(this);
        frame.add(b6);

        b7 = new JButton();
        b7.setBounds(70,290,70,70);
        b7.setBackground(new Color(0xE6E6FF));
        b7.addActionListener(this);
        frame.add(b7);

        b8 = new JButton();
        b8.setBounds(140,290,70,70);
        b8.setBackground(new Color(0xE6E6FF));
        b8.addActionListener(this);
        frame.add(b8);

        b9 = new JButton();
        b9.setBounds(210,290,70,70);
        b9.setBackground(new Color(0xE6E6FF));
        b9.addActionListener(this);
        frame.add(b9);


        home= new Main.RoundButton("");
        home.setBounds(150,410,45,45);
        home.setBackground(new Color(0xBBBBBB));

        home.addActionListener(this);

        frame.add(home);


        frame.setLayout(null);
        frame.setSize(360,500);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            if(b1.getText()==""|| b1.getText() ==null){
                    whoTurn(b1);
                }
        }
        if(e.getSource()==b2){
            if(b2.getText()==""|| b2.getText() ==null){
                whoTurn(b2);
            }
        }
        if(e.getSource()==b3){
            if(b3.getText()==""|| b3.getText() ==null){
                whoTurn(b3);
            }
        }
        if(e.getSource()==b4){
            if(b4.getText()==""|| b4.getText() ==null){
                whoTurn(b4);
            }
        }
        if(e.getSource()==b5){
            if(b5.getText()==""|| b5.getText() ==null){
                whoTurn(b5);
            }
        }
        if(e.getSource()==b6){
            if(b6.getText()==""|| b6.getText() ==null){
                whoTurn(b6);
            }
        }
        if(e.getSource()==b7){
            if(b7.getText()==""|| b7.getText() ==null){
                whoTurn(b7);
            }
        }
        if(e.getSource()==b8){
            if(b8.getText()==""|| b8.getText() ==null){
                whoTurn(b8);
            }
        }
        if(e.getSource()==b9){
            if(b9.getText()==""|| b9.getText() ==null){
                whoTurn(b9);
            }
        }
        if(e.getSource()==newGame) {
            oWin = 0;
            xWin = 0;
            l1.setText("Player X : " + xWin);
            l2.setText("Player O : " + oWin);
            clearBoard();
        }
        if(e.getSource()==home){
            frame.dispose();
            frame.setVisible(false);
            new Tic_Tac_Toe();
        }
    }
    public static void main (String args[]) {
        new SinglePlayer();
    }

}

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Objects;

public class Contact extends JFrame{
    public JFrame frame;
    public JButton btnAdd, btnDelete, btnUpdate, btnHome;
    public JLabel l1;
    public JPanel panel;
    Contact() throws SQLException {
        frame = new JFrame("Contact");

        ImageIcon imgIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("image\\contact-book.jpg")));
        frame.setIconImage(imgIcon.getImage());

        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel = new JPanel(null);

        /*CONTACT LABEL*/
        l1 = new JLabel("Contact");
        l1.setFont(new Font("Times New Roman",Font.BOLD,30));
        l1.setForeground(new Color(80, 75, 139));
        l1.setBounds(110,5,400,40);
        frame.add(l1);

        /*BUTTON ADD, BUTTON UPDATE, BUTTON DELETE*/
        btnAdd = new JButton("Add");
        btnAdd.setBounds(20,60,100,20);
        btnAdd.setBackground(new Color(64, 194, 212));
        frame.add(btnAdd);
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                frame.setVisible(false);
                new AddContact();
            }
        });

        btnUpdate = new JButton("Update");
        btnUpdate.setBackground(new Color(104, 194, 104));
        btnUpdate.setBounds(130,60,100,20);
        frame.add(btnUpdate);
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                frame.setVisible(false);
                new UpdateContact();
            }
        });

        btnDelete = new JButton("Delete");
        btnDelete.setBackground(new Color(195, 122, 122));
        btnDelete.setBounds(240,60,100,20);
        frame.add(btnDelete);
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                frame.setVisible(false);
                new DeleteContactFromDB();
            }
        });

        btnHome= new Main.RoundButton("");
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

        // Create a table model
        DefaultTableModel model = new DefaultTableModel();
        // Add the columns to the model
        model.addColumn("Name");
        model.addColumn("Number");
        model.addColumn("Other");

        // Connect to the database
        String DB_URL = "jdbc:mysql://localhost:3306/cst4_oop_finalproject";
        String DB_Username = "root";
        String DB_Password = "";
        Connection con = DriverManager.getConnection(DB_URL, DB_Username, DB_Password);

        String query = "SELECT * FROM contact order by name asc";
        // Execute the query and retrieve the results
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);

//         Add the rows to the model
        while (rs.next()) {

            String col1 = rs.getString("name");
            String col2 = rs.getString("number");
            String col3 = rs.getString("other");
            model.addRow(new Object[] { col1, col2, col3 });
        }

        // Create a JTable and set the model
        JTable table = new JTable();
        table.setModel(model);
        table.setEnabled(false);

        // Add the table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20,0,320,300);
        panel.add(scrollPane);

        frame.add(panel);

        panel.setBounds(0,100,360,350);
        frame.setSize(360,500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) throws SQLException {
        new Contact();
    }
}




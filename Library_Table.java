
package library_management_system;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Library_Table extends JFrame implements ActionListener{
    private JTable table;
    private JScrollPane scroll;
    private DefaultTableModel model;
    private Container c;
    private JLabel titleLabel, wfnLabel, wlnLabel,bookLabel, tbLabel,biLabel,siLabel;
    private JTextField wfnTf ,wlnTf, bookTf , tbTf,biTf,siTf;
    private JButton addButton,updateButton,deleteButton,clearButton;
    
    private String[] rows = {"Writer First Name","Writer Last Name","Book Name","Types Of Book","Book Issue Date","Student ID"};
    private String[] columns = new String[6];
    
    
    Library_Table()
    {
        initComponents();
    }
    
    public void initComponents()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,700);
        this.setLocationRelativeTo(null);
        this.setTitle("Library Table");
        
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.GREEN);
        
        Font font = new Font("Arial",Font.BOLD,16);
        
        titleLabel = new JLabel("Book Registration");
        titleLabel.setFont(font);
        titleLabel.setBounds(140, 10, 250, 50);
        c.add(titleLabel);
        
        wfnLabel = new JLabel("First Name : ");
        wfnLabel.setBounds(10, 80, 140, 30);
        wfnLabel.setFont(font);
        c.add(wfnLabel);
        
        wfnTf = new JTextField();
        wfnTf.setBounds(110, 80, 200, 30);
        wfnTf.setFont(font);
        c.add(wfnTf);
        
        addButton = new JButton("Add");
        addButton.setBounds(400, 80, 100, 30);
        addButton.setFont(font);
        c.add(addButton);
        
        wlnLabel = new JLabel("Last Name : ");
        wlnLabel.setBounds(10, 130, 150, 30);
        wlnLabel.setFont(font);
        c.add(wlnLabel);
        
        wlnTf = new JTextField();
        wlnTf.setBounds(110, 130, 200, 30);
        wlnTf.setFont(font);
        c.add(wlnTf);
        
        updateButton = new JButton("Update");
        updateButton.setBounds(400, 130, 100, 30);
        updateButton.setFont(font);
        c.add(updateButton);
        
        bookLabel = new JLabel("B_Name     : ");
        bookLabel.setBounds(10, 180, 150, 30);
        bookLabel.setFont(font);
        c.add(bookLabel);
        
        bookTf = new JTextField();
        bookTf.setBounds(110, 180, 200, 30);
        bookTf.setFont(font);
        c.add(bookTf);
        
        deleteButton = new JButton("Delete ");
        deleteButton.setBounds(400, 180, 100, 30);
        deleteButton.setFont(font);
        c.add(deleteButton);
        
        tbLabel = new JLabel("T_O_Book : ");
        tbLabel.setBounds(10, 230, 150, 30);
        tbLabel.setFont(font);
        c.add(tbLabel);
        
        tbTf = new JTextField();
        tbTf.setBounds(110, 230, 200, 30);
        tbTf.setFont(font);
        c.add(tbTf);
        
        biLabel = new JLabel("B_I_Date : ");
        biLabel.setBounds(10, 230, 200, 140);
        biLabel.setFont(font);
        c.add(biLabel);
        
        biTf = new JTextField();
        biTf.setBounds(110, 280, 200, 30);
        biTf.setFont(font);
        c.add(biTf);
        
        siLabel = new JLabel("S_ID : ");
        siLabel.setBounds(10, 230, 250, 250);
        siLabel.setFont(font);
        c.add(siLabel);
        
        siTf = new JTextField();
        siTf.setBounds(110, 330, 200, 30);
        siTf.setFont(font);
        c.add(siTf);
        
        clearButton = new JButton("Clear ");
        clearButton.setBounds(400, 230, 100, 30);
        clearButton.setFont(font);
        c.add(clearButton);
        
        table = new JTable();
        
        model = new DefaultTableModel();
       
        model.setColumnIdentifiers(rows);
        table.setModel(model);
        table.setFont(font);
        table.setSelectionBackground(Color.green);
        table.setBackground(Color.WHITE);
        table.setRowHeight(30);
        
        
        scroll = new JScrollPane(table);
        scroll.setBounds(10, 380, 740, 265);
        c.add(scroll);
        
        addButton.addActionListener(this);
        clearButton.addActionListener(this);
        deleteButton.addActionListener(this);
        updateButton.addActionListener(this);
        
        table.addMouseListener(new MouseAdapter(){
            
            public void mouseClicked(MouseEvent me)
                {
                   int numberOfRow = table.getSelectedRow();
                   
                   String wf_name = model.getValueAt(numberOfRow, 0).toString();
                   String wl_name = model.getValueAt(numberOfRow, 1).toString();
                   String book = model.getValueAt(numberOfRow, 2).toString();
                   String tb = model.getValueAt(numberOfRow, 3).toString();
                   String bi = model.getValueAt(numberOfRow, 4).toString();
                   String si = model.getValueAt(numberOfRow, 5).toString();
                   
                   wfnTf.setText(wf_name);
                   wlnTf.setText(wl_name);
                   bookTf.setText(book);
                   tbTf.setText(tb);
                   biTf.setText(bi);
                   siTf.setText(si);
                }
            
        });
        
    }
    
     @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == addButton)
        {
            rows[0] = wfnTf.getText();
            rows[1] = wlnTf.getText();
            rows[2] = bookTf.getText();
            rows[3] = tbTf.getText();
            rows[4] = biTf.getText();
            rows[5] = siTf.getText();
            model.addRow(rows);
        }
        
        else if(e.getSource() == clearButton)
        {
            wfnTf.setText("");
            wlnTf.setText("");
            bookTf.setText("");
            tbTf.setText("");
            biTf.setText("");
            siTf.setText("");
        }
        
        else if(e.getSource() == deleteButton)
        {
            int numberOfRow = table.getSelectedRow();
            
            if(numberOfRow >= 0)
            {
                model.removeRow(numberOfRow);
            }
            
            else
            {
                JOptionPane.showMessageDialog(null, "No Row Has Been Selected or No Row Exist");
            }
        }
        
        else if(e.getSource() == updateButton)
        {
            int numberOfRow = table.getSelectedRow();
            
            String wf_name = wfnTf.getText();
            String wl_name = wlnTf.getText();
            String book = bookTf.getText();
            String tb = tbTf.getText();
            String bi = biTf.getText();
            String si = siTf.getText();
            
            model.setValueAt(wf_name, numberOfRow, 0);
            model.setValueAt(wl_name, numberOfRow, 1);
            model.setValueAt(book, numberOfRow, 2);
            model.setValueAt(tb, numberOfRow, 3);
            model.setValueAt(bi, numberOfRow, 4);
            model.setValueAt(si, numberOfRow, 5);
        }
       
    }
    
    public static void main(String[] args) {
        
        Library_Table frame = new Library_Table();
        frame.setVisible(true);
    }
}

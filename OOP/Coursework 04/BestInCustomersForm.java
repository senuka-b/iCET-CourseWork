import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.border.EmptyBorder;
import javax.swing.table.*;;

class BestInCustomersForm extends JFrame {
    
    private JButton buttonBack;

    private DefaultTableModel dtm;
    private JTable table; 

    BestInCustomersForm(ReportForm reportForm) {
         
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650, 500);
        //setMinimumSize(new Dimension(getSize().width + 50, getSize().height + 30)); 
        setLocationRelativeTo(null);

        setTitle("Best In Customers");

        buttonBack = new JButton("Back");
        buttonBack.setOpaque(true);
        buttonBack.setBackground(Color.RED);
        buttonBack.setForeground(Color.WHITE);
        buttonBack.setFont(new Font(null, Font.BOLD, 20));

        JPanel buttonBackPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonBackPanel.add(buttonBack);

        Object[] headers = new Object[]{"Customer ID", "QTY", "Amount"};
        dtm = new DefaultTableModel(headers, 0);
        table = new JTable(dtm);

        JScrollPane scrollPane = new JScrollPane(table);

        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBorder(new EmptyBorder(20,40,60,40));
        tablePanel.add(scrollPane);

        add("North", buttonBackPanel);
        add("Center", tablePanel);

        String[][] bestInCustomersRow = CustomerController.getBestInCustomersRows();

        table.setRowHeight(40);

        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

        for (Object column : headers) {
            table.getColumn(column).setCellRenderer(cellRenderer);    
        }

        for (String[] row : bestInCustomersRow) {
            dtm.addRow(row);
        }

        buttonBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                reportForm.setVisible(true);
                dispose();
            }    
        
        });
    }
}

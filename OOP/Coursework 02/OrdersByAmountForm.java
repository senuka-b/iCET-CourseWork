import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.border.EmptyBorder;
import javax.swing.table.*;;

class OrdersByAmountForm extends JFrame {
    
    private JButton buttonBack;

    private DefaultTableModel dtm;
    private JTable table; 

    OrdersByAmountForm(ReportForm reportForm, CustomerCollection customerCollection) {
         
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 500);
        //setMinimumSize(new Dimension(getSize().width + 50, getSize().height + 30)); 
        setLocationRelativeTo(null);

        setTitle("Orders By Amount");

        buttonBack = new JButton("Back");
        buttonBack.setOpaque(true);
        buttonBack.setBackground(Color.RED);
        buttonBack.setForeground(Color.WHITE);
        buttonBack.setFont(new Font(null, Font.BOLD, 20));

        JPanel buttonBackPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonBackPanel.add(buttonBack);

        Object[] headers = new Object[]{"Order ID", "Customer ID", "Size", "QTY", "Amount", "Status"};

        dtm = new DefaultTableModel(headers, 0);
        table = new JTable(dtm);

        JScrollPane scrollPane = new JScrollPane(table);

        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBorder(new EmptyBorder(20,40,60,40));
        tablePanel.add(scrollPane);

        add("North", buttonBackPanel);
        add("Center", tablePanel);

        String[][] ordersByAmountRows = customerCollection.getOrderByAmountRows();

        table.setRowHeight(40);

        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

        for (Object column : headers) {
            table.getColumn(column).setCellRenderer(cellRenderer);    
        }

        for (String[] row : ordersByAmountRows) {
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

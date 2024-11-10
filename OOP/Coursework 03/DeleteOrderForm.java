import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;

class DeleteOrderForm extends JFrame {

    
    private JLabel labelCustomerID;
    private JTextField textFieldOrderID;

    private JLabel labelSize;
    private JLabel labelQty;
    private JLabel labelAmount;
    private JLabel labelStatus;

    private JLabel labelCustomerIDValue;
    private JLabel labelSizeValue;
    private JLabel labelQtyValue;
    private JLabel labelAmountValue;
    private JLabel labelStatusValue;

    private JButton buttonBack;
    private JButton buttonSearch;

    private CustomerCollection customerCollection;

    private Order currentOrder;

    DeleteOrderForm(HomeForm homeForm, CustomerCollection customerCollection) {

        this.customerCollection = customerCollection;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650, 520);
        //setMinimumSize(new Dimension(getSize().width + 50, getSize().height + 30)); 
        setLocationRelativeTo(null);

        setTitle("Change Status");

        
        JPanel subTopPanel = new JPanel(new GridLayout(1,3));
        subTopPanel.setBorder(new EmptyBorder(0,0,20,0));

        labelCustomerID = new JLabel("Enter Order ID : ");
        labelCustomerID.setFont(new Font(null, Font.BOLD, 16));
        labelCustomerID.setHorizontalAlignment(JLabel.CENTER);

        textFieldOrderID = new JTextField();

        buttonSearch = new JButton("Search");
        buttonSearch.setOpaque(true);
        buttonSearch.setBackground(Color.decode("#00cccb"));
        buttonSearch.setForeground(Color.WHITE);
        buttonSearch.setFont(new Font(null, Font.BOLD,14));

        JPanel buttonSearchPanel = new JPanel(new BorderLayout());
        buttonSearchPanel.setBorder(new EmptyBorder(0,40,0,40));
        buttonSearchPanel.add(buttonSearch);

        subTopPanel.add(labelCustomerID);
        subTopPanel.add(textFieldOrderID);
        subTopPanel.add(buttonSearchPanel);

        JPanel labelPanel = new JPanel(new GridLayout(5, 1, 10,0));
        labelPanel.setBorder(new EmptyBorder(10,40,50,30));

        labelCustomerID = new JLabel("Customer ID : ");
        labelSize = new JLabel("Size : ");
        labelQty = new JLabel("QTY : ");
        labelAmount = new JLabel("Amount : ");
        labelStatus = new JLabel("Status : ");

        JLabel[] labels = new JLabel[]{labelCustomerID, labelSize, labelQty, labelAmount, labelStatus};

        for (JLabel label : labels) {
            label.setFont(new Font(null, Font.BOLD, 17));

            labelPanel.add(label);
        }


        JPanel valuePanel = new JPanel(new GridLayout(5, 1, 10,0));
        valuePanel.setBorder(new EmptyBorder(10,40,50,30));


        labelCustomerIDValue = new JLabel("");
        labelSizeValue = new JLabel("");
        labelQtyValue = new JLabel("");
        labelStatusValue = new JLabel("");
        labelAmountValue = new JLabel("");


        JLabel[] values = new JLabel[]{labelCustomerIDValue, labelSizeValue, labelQtyValue, labelAmountValue, labelStatusValue};

        for (JLabel value : values) {
            value.setFont(new Font(null, Font.BOLD, 15));

            valuePanel.add(value);
        }


        buttonBack = new JButton("Back");
        buttonBack.setOpaque(true);
        buttonBack.setBackground(Color.RED);
        buttonBack.setForeground(Color.WHITE);
        buttonBack.setFont(new Font(null, Font.BOLD, 20));

        JPanel topPanel = new JPanel(new GridLayout(2,1,0,10));
        
        JPanel buttonBackPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonBackPanel.add(buttonBack);

        topPanel.add(buttonBackPanel);
        topPanel.add(subTopPanel);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton buttonDelete = new JButton("Delete");
        buttonDelete.setOpaque(true);
        buttonDelete.setBackground(Color.decode("#993300"));
        buttonDelete.setForeground(Color.WHITE);
        buttonDelete.setFont(new Font(null, Font.BOLD, 18));

        buttonDelete.setEnabled(false);
        buttonDelete.setContentAreaFilled(false);

        bottomPanel.add(buttonDelete);

        
        add("North", topPanel);
        add("West", labelPanel);
        add("Center", valuePanel);
        add("South", bottomPanel);


        buttonBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                homeForm.setVisible(true);

                dispose();
            }
        });

        buttonDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                int choice = JOptionPane.showOptionDialog(null,
                        "Do you want to delete this order?",
                        "Delete Confirmation",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.YES_NO_OPTION,
                        null, 
                        new Object[]{"Yes", "No"}, "No");

                switch (choice) {
                    case 0:
                        customerCollection.deleteOrder(currentOrder);

                        textFieldOrderID.setText("");

                        labelCustomerIDValue.setText("");
                        labelSizeValue.setText("");
                        labelQtyValue.setText("");
                        labelAmountValue.setText("");
                        labelStatusValue.setText("");

                        JOptionPane.showMessageDialog(null, "Order Deleted ! ", "Delete Information", JOptionPane.INFORMATION_MESSAGE);
                        
                        buttonDelete.setEnabled(false);
                        buttonDelete.setContentAreaFilled(false);

                        break;
                
                    default:
                        break;
                }

                
            }
        });

        buttonSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                String input = textFieldOrderID.getText();

                if (Order.isValidOrderID(input) && Order.isExists(customerCollection.getCustomers(), input)) {

                    Order order = customerCollection.getOrderByID(input);
                    currentOrder = order;

                    buttonDelete.setEnabled(true);
                    buttonDelete.setContentAreaFilled(true);

                    labelCustomerIDValue.setText(customerCollection.getCustomerIDByOrder(order).getCustomerID());
                    labelSizeValue.setText(order.getTSize());
                    labelQtyValue.setText(String.format("%d", order.getQuantity()));
                    labelAmountValue.setText(String.format("%.2f", order.calculateAmount()));
                    labelStatusValue.setText(order.getStatuString().toUpperCase());

                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Order ID ! ", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });



    }
}


import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;

class ChangeStatusForm extends JFrame {

    
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

    ChangeStatusForm(HomeForm homeForm, CustomerCollection customerCollection) {

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
        JButton buttonChangeStatus = new JButton("Change Status");
        buttonChangeStatus.setOpaque(true);
        buttonChangeStatus.setBackground(Color.decode("#6599fe"));
        buttonChangeStatus.setForeground(Color.WHITE);
        buttonChangeStatus.setFont(new Font(null, Font.BOLD, 18));

        buttonChangeStatus.setEnabled(false);
        buttonChangeStatus.setContentAreaFilled(false);


        bottomPanel.add(buttonChangeStatus);

        
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

        buttonChangeStatus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {


                String status = currentOrder.getStatuString();

                Object[] options;
                switch (status) {
                    case "processing":
                        options = new Object[]{"Delievering", "Delievered"};
                        break;
                
                    default:
                        options = new Object[]{"Delievered"};
                        break;
                }

                int choice = JOptionPane.showOptionDialog(null, "Please select the status", "Status", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, "Delievered");

                if (status.equals("processing")) {
                    currentOrder.setStatus(choice+1);
                } else {
                    currentOrder.setStatus(2);
                }

                if (currentOrder.getStatuString().equals("delievered")) {
                    buttonChangeStatus.setEnabled(false);
                    buttonChangeStatus.setContentAreaFilled(false);
                }

                labelStatusValue.setText(currentOrder.getStatuString().toUpperCase());
                
            }
        });

        buttonSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                String input = textFieldOrderID.getText();

                if (Order.isValidOrderID(input) && Order.isExists(customerCollection.getCustomers(), input)) {

                    Order order = customerCollection.getOrderByID(input);
                    currentOrder = order;

                    if (!order.getStatuString().equals("delievered")) {

                        buttonChangeStatus.setEnabled(true);
                        buttonChangeStatus.setContentAreaFilled(true);

                    }

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


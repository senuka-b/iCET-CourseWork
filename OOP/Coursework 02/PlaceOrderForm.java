import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;

class PlaceOrderForm extends JFrame {

    private JLabel labelOrderID;
    private JLabel labelCustomerID;
    private JLabel labelSize;
    private JLabel labelSizeList;
    private JLabel labelQty;
    private JLabel labelAmount;

    private JLabel labelOrderIDValue;
    private JTextField textFieldCustomerID;
    private JTextField textFieldSize;
    private JTextField textFieldQty;
    private JLabel labelAmountValue;

    private JButton buttonBack;
    private JButton buttonPlaceOrder;

    private CustomerCollection customerCollection;

    private boolean isValidCustomerID = false;
    private boolean isValidSize = false;
    private boolean isValidQty = false;

    PlaceOrderForm(HomeForm homeForm, CustomerCollection customerCollection) {

        this.customerCollection = customerCollection;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650, 520);
        //setMinimumSize(new Dimension(getSize().width + 50, getSize().height + 30)); 
        setLocationRelativeTo(null);

        setTitle("Place Order");

        JPanel labelPanel = new JPanel(new GridLayout(5, 1, 10,0));
        labelPanel.setBorder(new EmptyBorder(30,40,50,30));

        labelOrderID = new JLabel("Order ID : ");
        labelCustomerID = new JLabel("Customer ID : ");
        labelSize = new JLabel("Size : ");
        labelQty = new JLabel("QTY : ");
        labelAmount = new JLabel("Amount : ");

        JLabel[] labels = new JLabel[]{labelOrderID, labelCustomerID, labelSize, labelQty, labelAmount};

        for (JLabel label : labels) {
            label.setFont(new Font(null, Font.BOLD, 17));

            labelPanel.add(label);
        }

        JPanel valuePanel = new JPanel(new GridLayout(5, 1, 10,0));
        valuePanel.setBorder(new EmptyBorder(30,40,50,30));


        labelOrderIDValue = new JLabel("orderID");
        labelOrderIDValue.setFont(new Font(null, Font.BOLD, 20));

        textFieldCustomerID = new JTextField();
        textFieldSize = new JTextField();
        textFieldQty = new JTextField();

        labelAmountValue = new JLabel("amount...");
        labelAmountValue.setFont(new Font(null, Font.BOLD, 16));

        setAmount();

        valuePanel.add(labelOrderIDValue);

        JTextField[] values = new JTextField[]{textFieldCustomerID, textFieldSize, textFieldQty};

        for (JTextField value : values) {
            JPanel emptyPanel = new JPanel(new GridLayout(1,1));
            emptyPanel.setBorder(new EmptyBorder(20,0,0,0));

            emptyPanel.add(value);

            valuePanel.add(emptyPanel);
        }


        valuePanel.add(labelAmountValue);

        labelSizeList = new JLabel("(XS/S/M/L/XL/XXL)");
        labelSizeList.setFont(new Font(null, Font.BOLD, 15));
        labelSizeList.setHorizontalAlignment(JLabel.LEFT);
        labelSizeList.setBorder(new EmptyBorder(0,0,0,10));

        buttonBack = new JButton("Back");
        buttonBack.setOpaque(true);
        buttonBack.setBackground(Color.RED);
        buttonBack.setForeground(Color.WHITE);
        buttonBack.setFont(new Font(null, Font.BOLD, 20));

        JPanel buttonBackPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonBackPanel.add(buttonBack);

        buttonPlaceOrder = new JButton("Place");
        buttonPlaceOrder.setOpaque(true);
        buttonPlaceOrder.setBackground(Color.decode("#00cccb"));
        buttonPlaceOrder.setForeground(Color.WHITE);
        buttonPlaceOrder.setFont(new Font(null, Font.BOLD, 20));

        JPanel buttonPlaceOrderPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPlaceOrderPanel.add(buttonPlaceOrder);

        add("North", buttonBackPanel);
        add("West", labelPanel);
        add("Center", valuePanel);
        add("East", labelSizeList);
        add("South", buttonPlaceOrderPanel);


        buttonBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                homeForm.setVisible(true);

                dispose();
            }
        });

        generateOrderID();

        textFieldCustomerID.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent event) {}
            public void keyPressed(KeyEvent event) {}

            public void keyReleased(KeyEvent event) {
                String input = textFieldCustomerID.getText();
                
                isValidCustomerID = Customer.isValidCustomerID(input);

                setAmount();
            }
        });

        textFieldSize.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent event) {}
            public void keyPressed(KeyEvent event) {}

            public void keyReleased(KeyEvent event) {
                String input = textFieldSize.getText();
                
                isValidSize = Order.isValidSize(input);

                setAmount();
            }
        });

        textFieldQty.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent event) {}
            public void keyPressed(KeyEvent event) {}

            public void keyReleased(KeyEvent event) {
                String input = textFieldQty.getText();

                // Checking if it's an integer.
                for (int i = 0; i < input.length(); i++) {
                    if (!Character.isDigit(input.charAt(i))) {
                        isValidQty = false;
                        setAmount();
                        return;
                    }
                }
                
                isValidQty = Order.isValidQty(input);

                setAmount();
            }
        });

        buttonPlaceOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                if (isValidCustomerID && isValidQty && isValidSize) {

                    customerCollection.placeOrder(
                        textFieldCustomerID.getText(),
                        textFieldSize.getText(),
                        Integer.parseInt(textFieldQty.getText())
                    );

                    JOptionPane.showMessageDialog(null, "Order placed !", "Information", JOptionPane.INFORMATION_MESSAGE);

                    refreshWindow();

                } else {
                    JOptionPane.showMessageDialog(null, "Unable to place order !\n" + getInvalidText(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


    }

    private void refreshWindow() {
        JTextField[] values = new JTextField[]{textFieldCustomerID, textFieldSize, textFieldQty};
        
        for (JTextField field : values) {
            field.setText("");
        }


        labelAmountValue.setText("");

        isValidCustomerID = isValidQty = isValidSize = false;

        generateOrderID();
        setAmount();
    }

    private void generateOrderID() {
        labelOrderIDValue.setText(
            new Order(customerCollection.getOrderCount()+1).createOrderString()
        );
    }

    private String getInvalidText() {
        if (!isValidCustomerID) {

            if (!isValidSize) {

                if (!isValidQty) {

                    return "Invalid Customer ID, Size & Qty";

                } else {
                    return "Invalid Customer ID and Size";
                }

            } else if (!isValidQty) {
                return "Invalid Customer ID and Qty";

            } else {
                return "Invalid Customer ID";
            }

        } else if (!isValidSize) {

            if (!isValidQty) {
                return "Invalid Size & Qty";
            } else {
                return "Invalid Size";
            }

        } else if (!isValidQty) {
            return "Invalid Qty";

        } else {
           return "ok";
        }
    }

    private void setAmount() {
        labelAmountValue.setForeground(Color.RED);

        if (!getInvalidText().equals("ok")) {
            labelAmountValue.setText(getInvalidText());
        } else {

            labelAmount.setFont(new Font(null, Font.BOLD, 20));
            labelAmountValue.setForeground(Color.BLACK);

            double amount = Order.calculateAmount(textFieldSize.getText(), Integer.parseInt(textFieldQty.getText()));

            labelAmountValue.setText(String.format("%.2f", amount));
        }

       

    }

}

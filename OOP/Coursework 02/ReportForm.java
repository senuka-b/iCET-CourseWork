import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;

class ReportForm extends JFrame {
    
    private JButton buttonBack;

    private JButton buttonViewCustomers;
    private JButton buttonBestInCustomers;
    private JButton buttonAllCustomers;

    private JButton buttonByQty;
    private JButton buttonByAmount;

    private JButton buttonOrdersByAmount;
    private JButton buttonAllOrders;

    private ReportForm reportForm;

    ReportForm(HomeForm homeForm, CustomerCollection customerCollection) {

        reportForm = this;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 300);
        //setMinimumSize(new Dimension(getSize().width + 50, getSize().height + 30)); 
        setLocationRelativeTo(null);

        setTitle("Reports");

        buttonBack = new JButton("Back");
        buttonBack.setOpaque(true);
        buttonBack.setBackground(Color.RED);
        buttonBack.setForeground(Color.WHITE);
        buttonBack.setFont(new Font(null, Font.BOLD, 20));

        JPanel buttonBackPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonBackPanel.add(buttonBack);

        buttonViewCustomers = new JButton("View Customers");
        buttonBestInCustomers = new JButton("Best in Customers");
        buttonAllCustomers = new JButton("All Customers");

        buttonByQty = new JButton("Categorized by QTY");
        buttonByAmount = new JButton("Categorized by Amount");

        buttonOrdersByAmount = new JButton("Orders by Amount");
        buttonAllOrders = new JButton("All Orders");

        JButton[] greenButtons = new JButton[]{buttonViewCustomers, buttonBestInCustomers, buttonAllCustomers};

        JPanel leftPanel = new JPanel(new GridLayout(3,1,20,20));

        for (JButton button : greenButtons) {
            button.setOpaque(true);
            button.setFont(new Font(null, Font.BOLD, 14));
            button.setBackground(Color.GREEN);
            button.setForeground(Color.WHITE);

            leftPanel.add(button);
        }


        JPanel rightPanel = new JPanel(new GridLayout(1,2,20,20));

        JPanel subLeftPanel = new JPanel(new GridLayout(2,1,20,20));

        JButton[] blueButtons = new JButton[]{buttonByQty, buttonByAmount};

        for (JButton button : blueButtons) {
            button.setOpaque(true);
            button.setFont(new Font(null, Font.BOLD, 14));
            button.setBackground(Color.BLUE);
            button.setForeground(Color.WHITE);

            subLeftPanel.add(button);
        }

        JPanel subRightPanel = new JPanel(new GridLayout(2,1,60,20));

        JButton[] greyButtons = new JButton[]{buttonOrdersByAmount, buttonAllOrders};

        for (JButton button : greyButtons) {
            button.setOpaque(true);
            button.setFont(new Font(null, Font.BOLD, 14));
            button.setBackground(Color.GRAY);
            button.setForeground(Color.WHITE);

            subRightPanel.add(button);
        }

        rightPanel.add(subLeftPanel);
        rightPanel.add(subRightPanel);

        JPanel rightPanelContainer = new JPanel(new BorderLayout());
        rightPanelContainer.setBorder(new EmptyBorder(15,10,15,0));

        rightPanelContainer.add("Center", rightPanel);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(40,20,50,20));

        mainPanel.add("West", leftPanel);
        mainPanel.add("Center", rightPanelContainer);

        add("North", buttonBackPanel);
        add("Center", mainPanel);


        buttonBestInCustomers.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                setVisible(false);
                new BestInCustomersForm(reportForm, customerCollection).setVisible(true);
            }
        });

        buttonViewCustomers.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                setVisible(false);
                new ViewCustomersForm(reportForm, customerCollection).setVisible(true);
            }
        });

        buttonAllCustomers.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                setVisible(false);
                new AllCustomersForm(reportForm, customerCollection).setVisible(true);
            }
        });

        buttonBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                homeForm.setVisible(true);
                dispose();
            }
        });

    }
}

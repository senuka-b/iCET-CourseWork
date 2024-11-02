import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class HomeForm extends JFrame {
    
    private JLabel labelHeader;

    private JButton buttonSearch;
    private JButton buttonStatus;
    private JButton buttonReport;
    private JButton buttonDelete;

    private JButton buttonPlaceOrder;

    private JLabel labelFooter;

    HomeForm() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 560);
        //setMinimumSize(new Dimension(getSize().width + 50, getSize().height + 30)); 
        setLocationRelativeTo(null);


        JPanel mainPanel = new JPanel(new GridLayout(1, 2, 40, 0));

        buttonSearch = new JButton("Search");
        buttonStatus = new JButton("Status");
        buttonReport = new JButton("Report");
        buttonDelete = new JButton("Delete");

        buttonPlaceOrder = new JButton("Place Order");
        buttonPlaceOrder.setFont(new Font("null", Font.BOLD, 25));
        buttonPlaceOrder.setBackground(Color.decode("#00cccb"));


        JPanel buttonPanel = new JPanel(new GridLayout(2,1));
        buttonPanel.setBorder(new EmptyBorder(30, 30,30,0));

        JPanel subButtonPanel_1 = new JPanel(new GridLayout(4,1, 0, 20));

        JButton[] buttons = new JButton[]{buttonSearch, buttonStatus, buttonReport, buttonDelete};
        for (JButton button : buttons) {
            button.setFont(new Font("null", Font.BOLD, 12));

            subButtonPanel_1.add(button);
        }

        JPanel subButtonPanel_2 = new JPanel(new GridLayout(1,1));
        subButtonPanel_2.setBorder(new EmptyBorder(60, 0,70,0));

        subButtonPanel_2.add(buttonPlaceOrder);

        buttonPanel.add(subButtonPanel_1);
        buttonPanel.add(subButtonPanel_2);

        mainPanel.add(buttonPanel);

        BufferedImage myPicture;
        try {
            myPicture = ImageIO.read(new File("assets/image.png"));
            
            JLabel picLabel = new JLabel(new ImageIcon(myPicture));

            JPanel picPanel = new JPanel();
            picPanel.add(picLabel);

            mainPanel.add(picPanel);

        } catch (IOException e) {
            
        }
        

        labelHeader = new JLabel("Fashion Shop");
        labelHeader.setFont(new Font("", Font.BOLD, 35));
        labelHeader.setForeground(Color.WHITE);
        labelHeader.setHorizontalAlignment(JLabel.CENTER);
        labelHeader.setOpaque(true);
        labelHeader.setBackground(Color.BLUE);

        labelFooter = new JLabel("Copyrights ©️ iCET 2024");
        labelFooter.setFont(new Font("", Font.BOLD, 14));
        labelFooter.setHorizontalAlignment(JLabel.CENTER);


        add("North", labelHeader);
        add("Center", mainPanel);
        add("South", labelFooter);


    }


}
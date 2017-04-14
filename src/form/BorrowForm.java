package form;
import javax.swing.*;
import javax.swing.border.*;

import component.*;
import java.awt.*;
import java.awt.event.*;

public class BorrowForm {

    public static void BorrowBook(JFrame parent){
        int frameWidth =798;
        int frameHeight =700;
        int spacing =75;



//  i used the Jdialog ,because when i use Jframe.setDefaultCloseOperation
//  it will close all the all
        JDialog dialog = new JDialog(parent);
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(parent);
        JPanel frame = new JPanel();

//        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setBackground(new Color(236, 236, 236));
        frame.setSize( frameWidth,frameHeight);


        dialog.setTitle("BORROWING BOOK(S)");
        MLabel title = new MLabel(0, 190, frame.getWidth(), 50, "BORROWING BOOK(S) FORM");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setBackground(new Color(248,249,250));
        title.setFont(new Font("Consolas", Font.BOLD, 35));

        ImageIcon images = new ImageIcon("src/picture/upadate.png");
        MLabel image = new MLabel(0, 0, images.getIconWidth(), images.getIconHeight(), images);



        // right panel
        JPanel rightPanel = new JPanel();
        rightPanel.setLocation(0,images.getIconHeight()+80);
        rightPanel.setSize(frameWidth/2,frameHeight-images.getIconHeight());
        rightPanel.setLayout(null);

        MLabel lblStudentName = new MLabel(55, 10 , 300, 25, "Student Name");
        MTextField txtStudentName = new MTextField(48, 35 , 300, 40);
        txtStudentName.setEditable(false);

        MLabel lblSex = new MLabel(55, 10+spacing , 300, 25, "Sex");
        MTextField txtSex = new MTextField(48, 35+spacing , 300, 40);
        txtSex.setEditable(false);

        MLabel lblIssueDate = new MLabel(55, 10+spacing*2 , 300, 25, "Issue Date");
        MTextField txtIssueDate = new MTextField(48, 35+spacing*2 , 300, 40);
        

        MLabel lblStatus = new MLabel(55, 10+spacing*3 , 300, 25, "Member's Status");
        MTextField txtStatus = new MTextField(48, 35+spacing*3 , 300, 40);
        txtStatus.setEditable(false);

        rightPanel.add(lblStudentName);
        rightPanel.add(txtStudentName);
        rightPanel.add(lblSex);
        rightPanel.add(txtSex);
        rightPanel.add(txtIssueDate);
        rightPanel.add(lblIssueDate);
        rightPanel.add(lblStatus);
        rightPanel.add(txtStatus);

        MLabel lblStudentID = new MLabel(55, 258 , 300, 25, "Student ID");
        MTextField txtStudentID = new MTextField(48, 282 , 300, 40);

        txtStudentID.addActionListener(e-> frame.add(rightPanel).repaint());
        txtStudentID.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                frame.add(rightPanel).repaint();
            }
        });

        // Left panel
        JPanel leftPanel = new JPanel();
        leftPanel.setLocation(frameWidth/2,images.getIconHeight()+80);
        leftPanel.setSize(frameWidth/2,frameHeight-images.getIconHeight()-200);
        leftPanel.setLayout(null);

        MLabel lblQuantity = new MLabel(55, 10+ spacing , 300, 25, "Quantity");
        MTextField txtQuantity = new MTextField(48, 35 +spacing, 300, 40);


        MLabel lblBookName = new MLabel(55, 10 , 300, 25, "Book Name");
        MTextField txtBookName = new MTextField(48, 35 , 300, 40);
        txtBookName.setText("testing");
        txtBookName.setEditable(false);

        MLabel lblDueDate = new MLabel(55, 10+ spacing *2, 300, 25, "Due Date");
        MTextField txtDueDate = new MTextField(48, 35 +spacing*2, 300, 40);

        leftPanel.add(lblQuantity);
        leftPanel.add(txtQuantity);
        leftPanel.add(lblBookName);
        leftPanel.add(txtBookName);
        leftPanel.add(lblDueDate);
        leftPanel.add(txtDueDate);

        MLabel lblBookID = new MLabel(460, 258, 300, 25, "ISBN");
        MTextField txtBookID = new MTextField(453, 282, 300, 40);

        txtBookID.addActionListener(e-> frame.add(leftPanel).repaint());
        txtBookID.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                frame.add(leftPanel).repaint();
            }
        });

//       the two button ADD and CANCEL
        MButton btnCancel = new MButton(453, 282 + spacing * 4, 135, 40, "Cancel ");
        MButton btnAdd = new MButton(453 + 165, 282 + spacing * 4, 135, 40, "Borrow");

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });


        frame.add(btnAdd);
        frame.add(btnCancel);
        frame.repaint();



// will display for the update and add but just different time
        frame.add(title);
        frame.add(image);

        frame.add(lblBookID);
        frame.add(txtBookID);
        frame.add(txtStudentID);
        frame.add(lblStudentID);

        frame.setVisible(true);

        dialog.add(frame);
        dialog.setSize(frame.getSize());
        dialog.setLocationRelativeTo(frame);
        dialog.setModal(true);
        dialog.setVisible(true);


        
    }

}

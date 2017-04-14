package form;
import component.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ReturnForm {
    public static void ReturnBook(JFrame parent){
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


        dialog.setTitle("RETURNING BOOK(S)");
        MLabel title = new MLabel(0, 175, frame.getWidth(), 50, "RETURNING BOOK");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setBackground(new Color(255,255,255));
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

        MLabel lblDueDate = new MLabel(55, 10+spacing*2 , 300, 25, "Issue /Due Date");
        MTextField txtDueDate = new MTextField(48, 35+spacing*2 , 300, 40);
        txtDueDate.setEditable(false);

        MLabel lblFine = new MLabel(55, 10+spacing*3 , 300, 25, "Fine(In Riel)");
        MTextField txtFine = new MTextField(48, 35+spacing*3 , 300, 40);
        txtFine.setEditable(false);

        rightPanel.add(lblStudentName);
        rightPanel.add(txtStudentName);
        rightPanel.add(lblSex);
        rightPanel.add(txtSex);
        rightPanel.add(txtDueDate);
        rightPanel.add(lblDueDate);
        rightPanel.add(lblFine);
        rightPanel.add(txtFine);

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
        txtQuantity.setEditable(false);

        MLabel lblBookName = new MLabel(55, 10 , 300, 25, "Book Name");
        MTextField txtBookName = new MTextField(48, 35 , 300, 40);
        txtBookName.setEditable(false);

        MLabel lblReturnDate = new MLabel(55, 10+ spacing *2, 300, 25, "Return Date");
        MTextField txtReturnDate = new MTextField(48, 35 +spacing*2, 300, 40);

        leftPanel.add(lblQuantity);
        leftPanel.add(txtQuantity);
        leftPanel.add(lblBookName);
        leftPanel.add(txtBookName);
        leftPanel.add(lblReturnDate);
        leftPanel.add(txtReturnDate);

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
            MButton btnCancel = new MButton(453, 282 + spacing * 4, 135, 40, "Cancel");
            MButton btnAdd = new MButton(453 + 165, 282 + spacing * 4, 135, 40, "Return");

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


        
        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
                dialog.setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
            }
        });
    }

}

package GUI;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class fk extends JFrame{
    JPanel titleBar = new JPanel();
    JPanel navBar = new JPanel();
    JPanel mainPanel = new JPanel();
    JPanel tab1 = new JPanel();
    JPanel tab2 = new JPanel();
    JPanel tab3 = new JPanel();
    JPanel tab4 = new JPanel();
    JPanel tab5 = new JPanel();
    JPanel tab6 = new JPanel();
    JPanel tab7 = new JPanel();
    JPanel tab8 = new JPanel();
    JPanel tab9 = new JPanel();
    Sach panel2 = new Sach();
    DocGia panel3 = new DocGia();
    TacGia panel4 = new TacGia();
    NhaXuatBan panel5 = new NhaXuatBan();
    NhanVien panel6 = new NhanVien();
    PhieuMuon panel7 = new PhieuMuon();
    PhieuNhap panel8 = new PhieuNhap();
    

    public fk() {
        initGUI();            
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int a = JOptionPane.showConfirmDialog(fk.this, 
                        "Bạn chắc chắn muốn thoát chứ?");
                if (a == JOptionPane.YES_OPTION)
                    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                else
                    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            }
        });
    }
    
    public void initGUI(){
        setStyle();
        setTitle("Fuck me in the ass!");
        setSize(1280, 768);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        //layout.setAutoCreateGaps(true);
        //layout.setAutoCreateContainerGaps(true);
        

        CardLayout mainCardLayout = new CardLayout();
        mainPanel.setLayout(mainCardLayout);
        
        mainPanel.add(panel2, "Sach");
        mainPanel.add(panel3, "DocGia");
        mainPanel.add(panel4, "TacGia");
        mainPanel.add(panel5, "NhaSanXuat");
        mainPanel.add(panel6, "NhanVien");
        mainPanel.add(panel7, "PhieuMuon");
        mainPanel.add(panel8, "PhieuNhap");

        
        MouseAdapter tabClicked = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getComponent() == tab2)
                    mainCardLayout.show(mainPanel, "Sach");
                else
                if(e.getComponent() == tab3)
                    mainCardLayout.show(mainPanel, "DocGia");
                else
                if(e.getComponent() == tab4)
                    mainCardLayout.show(mainPanel, "TacGia");
                else
                if(e.getComponent() == tab5)
                    mainCardLayout.show(mainPanel, "NhaSanXuat");
                else
                if(e.getComponent() == tab6)
                    mainCardLayout.show(mainPanel, "NhanVien");
                else
                if(e.getComponent() == tab7)
                    mainCardLayout.show(mainPanel, "PhieuMuon");
                else
                if(e.getComponent() == tab8)
                    mainCardLayout.show(mainPanel, "PhieuNhap");
                                
                                                                // logout still required (Missing)
            }
        };

        tab2.addMouseListener(tabClicked);
        tab3.addMouseListener(tabClicked);
        tab4.addMouseListener(tabClicked);
        tab5.addMouseListener(tabClicked);
        tab6.addMouseListener(tabClicked);
        tab7.addMouseListener(tabClicked);
        tab8.addMouseListener(tabClicked);
        
        navBar.add(tab1);
        navBar.add(Box.createRigidArea(new Dimension(0, 10)));
        navBar.add(tab2);
        navBar.add(Box.createRigidArea(new Dimension(0, 10)));
        navBar.add(tab3);
        navBar.add(Box.createRigidArea(new Dimension(0, 10)));
        navBar.add(tab4);
        navBar.add(Box.createRigidArea(new Dimension(0, 10)));
        navBar.add(tab5);
        navBar.add(Box.createRigidArea(new Dimension(0, 10)));
        navBar.add(tab6);
        navBar.add(Box.createRigidArea(new Dimension(0, 10)));
        navBar.add(tab7);
        navBar.add(Box.createRigidArea(new Dimension(0, 10)));
        navBar.add(tab8);
        navBar.add(Box.createRigidArea(new Dimension(0, 10)));
        navBar.add(Box.createVerticalGlue());
        navBar.add(tab9);



        // Horizontal layout
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(titleBar)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(navBar, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                    .addComponent(mainPanel))
        );

        // Vertical layout
        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addComponent(titleBar, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(navBar)
                    .addComponent(mainPanel))
        );

        setVisible(true);

    }




    public void setStyle() {

        mainPanel.setBackground(Color.gray);
        
        JLabel title = new JLabel("Quản Lý Thư Viện", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setForeground(Color.white);
        
        titleBar.setBackground(Color.darkGray);
        titleBar.setLayout(new BorderLayout());
        titleBar.add(title);

        navBar.setLayout(new BoxLayout(navBar, BoxLayout.Y_AXIS));
        navBar.setBackground(Color.darkGray);

        
        JLabel tablabel1 = new JLabel("", SwingConstants.CENTER); 
        JLabel tablabel2 = new JLabel("Sách", SwingConstants.CENTER); 
        JLabel tablabel3 = new JLabel("Độc Giả", SwingConstants.CENTER); 
        JLabel tablabel4 = new JLabel("Tác Giả", SwingConstants.CENTER); 
        JLabel tablabel5 = new JLabel("Nhà Sản Xuất", SwingConstants.CENTER); 
        JLabel tablabel6 = new JLabel("Nhân Viên", SwingConstants.CENTER); 
        JLabel tablabel7 = new JLabel("Phiếu Mượn", SwingConstants.CENTER); 
        JLabel tablabel8 = new JLabel("Phiếu Nhập", SwingConstants.CENTER); 
        JLabel tablabel9 = new JLabel("Đăng Xuất", SwingConstants.CENTER); 

        ImageIcon img = new ImageIcon("img/iconsgu 3.png");
        tablabel1.setIcon(new ImageIcon(img.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH)));
        tablabel2.setFont(new Font("Arial", Font.BOLD, 18));
        tablabel3.setFont(new Font("Arial", Font.BOLD, 18));
        tablabel4.setFont(new Font("Arial", Font.BOLD, 18));
        tablabel5.setFont(new Font("Arial", Font.BOLD, 18));
        tablabel6.setFont(new Font("Arial", Font.BOLD, 18));
        tablabel7.setFont(new Font("Arial", Font.BOLD, 18));
        tablabel8.setFont(new Font("Arial", Font.BOLD, 18));
        tablabel9.setFont(new Font("Arial", Font.BOLD, 18));

        tablabel1.setForeground(Color.white);
        tablabel2.setForeground(Color.white);
        tablabel3.setForeground(Color.white);
        tablabel4.setForeground(Color.white);
        tablabel5.setForeground(Color.white);
        tablabel6.setForeground(Color.white);
        tablabel7.setForeground(Color.white);
        tablabel8.setForeground(Color.white);
        tablabel9.setForeground(Color.white);
        
        tab1.setLayout(new BorderLayout());
        tab2.setLayout(new BorderLayout());
        tab3.setLayout(new BorderLayout());
        tab4.setLayout(new BorderLayout());
        tab5.setLayout(new BorderLayout());
        tab6.setLayout(new BorderLayout());
        tab7.setLayout(new BorderLayout());
        tab8.setLayout(new BorderLayout());
        tab9.setLayout(new BorderLayout());
        
        tab1.add(tablabel1);
        tab2.add(tablabel2);
        tab3.add(tablabel3);
        tab4.add(tablabel4);
        tab5.add(tablabel5);
        tab6.add(tablabel6);
        tab7.add(tablabel7);
        tab8.add(tablabel8);
        tab9.add(tablabel9);
        
        tab1.setBackground(Color.darkGray);
        tab2.setBackground(Color.darkGray);
        tab3.setBackground(Color.darkGray);
        tab4.setBackground(Color.darkGray);
        tab5.setBackground(Color.darkGray);
        tab6.setBackground(Color.darkGray);
        tab7.setBackground(Color.darkGray);
        tab8.setBackground(Color.darkGray);
        tab9.setBackground(Color.darkGray);

        tab1.setPreferredSize(new Dimension(Integer.MAX_VALUE, 55));
        tab2.setPreferredSize(new Dimension(Integer.MAX_VALUE, 55));
        tab3.setPreferredSize(new Dimension(Integer.MAX_VALUE, 55));
        tab4.setPreferredSize(new Dimension(Integer.MAX_VALUE, 55));
        tab5.setPreferredSize(new Dimension(Integer.MAX_VALUE, 55));
        tab6.setPreferredSize(new Dimension(Integer.MAX_VALUE, 55));
        tab7.setPreferredSize(new Dimension(Integer.MAX_VALUE, 55));
        tab8.setPreferredSize(new Dimension(Integer.MAX_VALUE, 55));
        tab9.setPreferredSize(new Dimension(Integer.MAX_VALUE, 55));

        tab1.setMaximumSize(new Dimension(Integer.MAX_VALUE, 55));
        tab2.setMaximumSize(new Dimension(Integer.MAX_VALUE, 55));
        tab3.setMaximumSize(new Dimension(Integer.MAX_VALUE, 55));
        tab4.setMaximumSize(new Dimension(Integer.MAX_VALUE, 55));
        tab5.setMaximumSize(new Dimension(Integer.MAX_VALUE, 55));
        tab6.setMaximumSize(new Dimension(Integer.MAX_VALUE, 55));
        tab7.setMaximumSize(new Dimension(Integer.MAX_VALUE, 55));
        tab8.setMaximumSize(new Dimension(Integer.MAX_VALUE, 55));
        tab9.setMaximumSize(new Dimension(Integer.MAX_VALUE, 55));
        

    
        MouseAdapter tabHoverAdapter = new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                e.getComponent().setBackground(Color.BLUE);
                e.getComponent().setForeground(Color.BLACK);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                e.getComponent().setBackground(Color.DARK_GRAY);
                e.getComponent().setForeground(Color.WHITE);
            }
        };


        tab2.addMouseListener(tabHoverAdapter);
        tab3.addMouseListener(tabHoverAdapter);
        tab4.addMouseListener(tabHoverAdapter);
        tab5.addMouseListener(tabHoverAdapter);
        tab6.addMouseListener(tabHoverAdapter);
        tab7.addMouseListener(tabHoverAdapter);
        tab8.addMouseListener(tabHoverAdapter);
        tab9.addMouseListener(tabHoverAdapter);
        
   
    }

    

}

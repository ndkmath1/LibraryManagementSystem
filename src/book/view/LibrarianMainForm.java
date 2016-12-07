package book.view;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

public class LibrarianMainForm extends javax.swing.JFrame implements ILibrarianMainForm{
   
            
    public LibrarianMainForm() {
        initComponents();
        setButtonCloseActionForm();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setTitle("Trang chủ thủ thư");
      
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnBorrowReturnBookManagement = new javax.swing.JButton();
        btnBorrowCardManagement = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        btnBookManagement = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));

        btnBorrowReturnBookManagement.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/borrow_return_book.png"))); // NOI18N
        btnBorrowReturnBookManagement.setText("Quản Lý Mượn Trả");
        btnBorrowReturnBookManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrowReturnBookManagementActionPerformed(evt);
            }
        });

        btnBorrowCardManagement.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/borrow_card_management.png"))); // NOI18N
        btnBorrowCardManagement.setText("Quản Lý Thẻ Mượn");

        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logout_icon.png"))); // NOI18N
        btnLogout.setText("Đăng xuất");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        btnBookManagement.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/book_management.png"))); // NOI18N
        btnBookManagement.setText("Quản Lý Sách");
        btnBookManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookManagementActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel1.setText("TRANG CHỦ THỦ THƯ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnBookManagement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBorrowReturnBookManagement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBorrowCardManagement, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                    .addComponent(btnLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(157, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(156, 156, 156))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBookManagement)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBorrowReturnBookManagement)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBorrowCardManagement)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLogout)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void setButtonCloseActionForm(){
         this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e); 
                setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
                if (JOptionPane.showConfirmDialog(LibrarianMainForm.this, 
                "Bạn có chắc chắn muốn thoát?", "Kết thúc?", 
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION)
                    System.exit(0);
            }   
        });
    }
    
    private void btnBookManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookManagementActionPerformed
       
    }//GEN-LAST:event_btnBookManagementActionPerformed

    private void btnBorrowReturnBookManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrowReturnBookManagementActionPerformed
      
    }//GEN-LAST:event_btnBorrowReturnBookManagementActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
       
    }//GEN-LAST:event_btnLogoutActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBookManagement;
    private javax.swing.JButton btnBorrowCardManagement;
    private javax.swing.JButton btnBorrowReturnBookManagement;
    private javax.swing.JButton btnLogout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void openLibrarianMainForm() {
        this.setVisible(true);
    }

    @Override
    public void hideLibrarianMainForm() {
        this.setVisible(false);
    }

    @Override
    public void setButtonBookManagementActionListener(ActionListener listener) {
        btnBookManagement.addActionListener(listener);
    }

    @Override
    public void setButtonBorrowReturnBookManagementActionListener(ActionListener listener) {
        btnBorrowReturnBookManagement.addActionListener(listener);
    }

    @Override
    public void setButtonBorrowCardManagementActionListener(ActionListener listener) {
        btnBorrowCardManagement.addActionListener(listener);
    }

    @Override
    public void setButtonLogoutActionListener(ActionListener listener) {
        btnLogout.addActionListener(listener);
    }

    
    @Override
    public void closeLibrarianMainForm() {
        this.setVisible(false);
        this.dispose();
    }

    @Override
    public void setVisibleForm(boolean isVisible) {
        setVisible(isVisible);
    }
}

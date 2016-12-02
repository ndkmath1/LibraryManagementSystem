/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account.view;

import utils.AccountHelper;

/**
 *
 * @author Khanh Nguyen
 */
public class SignUpForm extends javax.swing.JFrame {

    /**
     * Creates new form SignUpForm
     */
    public SignUpForm() {
        initComponents();
        
    }
    
    private void init(){
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRegisterForm = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbEmail = new javax.swing.JLabel();
        lbAddress = new javax.swing.JLabel();
        lbGender = new javax.swing.JLabel();
        lbPhone = new javax.swing.JLabel();
        lbName = new javax.swing.JLabel();
        lbBirthday = new javax.swing.JLabel();
        tfUsername = new javax.swing.JTextField();
        tfEmail = new javax.swing.JTextField();
        tfAddress = new javax.swing.JTextField();
        tfName = new javax.swing.JTextField();
        tfDay = new javax.swing.JTextField();
        tfPhoneNumber = new javax.swing.JTextField();
        rbtnMale = new javax.swing.JRadioButton();
        rbtnFemale = new javax.swing.JRadioButton();
        plForStudent = new javax.swing.JPanel();
        lbStudentID = new javax.swing.JLabel();
        tfStudentID = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        rbtnNormal = new javax.swing.JRadioButton();
        rbtnStudent = new javax.swing.JRadioButton();
        btnRegister = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        tfYear = new javax.swing.JTextField();
        tfMonth = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelRegisterForm.setEnabled(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("THÔNG TIN ĐĂNG KÝ");

        jLabel2.setText("Tên đăng nhập(*)");

        jLabel3.setText("Mật khẩu(*)");

        lbEmail.setText("Email");

        lbAddress.setText("Địa chỉ");

        lbGender.setText("Giới tính(*)");

        lbPhone.setText("Điện thoại");

        lbName.setText("Họ, tên(*)");

        lbBirthday.setText("Ngày sinh(*)");

        tfDay.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfDayKeyTyped(evt);
            }
        });

        rbtnMale.setSelected(true);
        rbtnMale.setText("Nam");
        rbtnMale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnMaleActionPerformed(evt);
            }
        });

        rbtnFemale.setText("Nữ");

        plForStudent.setBorder(javax.swing.BorderFactory.createTitledBorder("Dành cho sinh viên"));
        plForStudent.setEnabled(false);

        lbStudentID.setText("MS Sinh viên:");
        lbStudentID.setEnabled(false);

        tfStudentID.setEnabled(false);
        tfStudentID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfStudentIDMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout plForStudentLayout = new javax.swing.GroupLayout(plForStudent);
        plForStudent.setLayout(plForStudentLayout);
        plForStudentLayout.setHorizontalGroup(
            plForStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plForStudentLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lbStudentID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(tfStudentID, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        plForStudentLayout.setVerticalGroup(
            plForStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plForStudentLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(plForStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbStudentID)
                    .addComponent(tfStudentID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58))
        );

        jLabel13.setForeground(new java.awt.Color(255, 51, 51));
        jLabel13.setText("Chú ý: Các trường *  là bắt buộc");

        jLabel14.setText("Đối tượng đăng ký:");

        rbtnNormal.setSelected(true);
        rbtnNormal.setText("Khách");
        rbtnNormal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnNormalActionPerformed(evt);
            }
        });

        rbtnStudent.setText("Sinh viên");
        rbtnStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnStudentActionPerformed(evt);
            }
        });

        btnRegister.setText("Đăng ký");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        btnRefresh.setText("Nhập lại");

        btnBack.setText("Quay lại");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel4.setText("/");

        tfYear.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfYearKeyTyped(evt);
            }
        });

        tfMonth.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfMonthKeyTyped(evt);
            }
        });

        jLabel5.setText("/");

        javax.swing.GroupLayout panelRegisterFormLayout = new javax.swing.GroupLayout(panelRegisterForm);
        panelRegisterForm.setLayout(panelRegisterFormLayout);
        panelRegisterFormLayout.setHorizontalGroup(
            panelRegisterFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRegisterFormLayout.createSequentialGroup()
                .addGroup(panelRegisterFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelRegisterFormLayout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(rbtnNormal)
                        .addGap(18, 18, 18)
                        .addComponent(rbtnStudent))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelRegisterFormLayout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addGroup(panelRegisterFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRegisterFormLayout.createSequentialGroup()
                                .addGroup(panelRegisterFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelRegisterFormLayout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelRegisterFormLayout.createSequentialGroup()
                                        .addGroup(panelRegisterFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(lbName)
                                            .addComponent(lbPhone)
                                            .addComponent(lbEmail)
                                            .addComponent(lbBirthday)
                                            .addComponent(lbAddress)
                                            .addComponent(lbGender))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(panelRegisterFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(panelRegisterFormLayout.createSequentialGroup()
                                                .addComponent(tfDay, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(10, 10, 10)
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(tfMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(5, 5, 5)
                                                .addComponent(jLabel5)
                                                .addGap(9, 9, 9)
                                                .addComponent(tfYear, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRegisterFormLayout.createSequentialGroup()
                                                .addComponent(rbtnMale)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(rbtnFemale))
                                            .addComponent(tfUsername)
                                            .addComponent(tfName)
                                            .addComponent(tfPhoneNumber)
                                            .addComponent(tfEmail)
                                            .addComponent(tfAddress, javax.swing.GroupLayout.Alignment.TRAILING)))
                                    .addGroup(panelRegisterFormLayout.createSequentialGroup()
                                        .addGap(103, 103, 103)
                                        .addComponent(jLabel13))
                                    .addGroup(panelRegisterFormLayout.createSequentialGroup()
                                        .addGap(93, 93, 93)
                                        .addComponent(jLabel1))
                                    .addGroup(panelRegisterFormLayout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addComponent(btnRegister)
                                        .addGap(31, 31, 31)
                                        .addComponent(btnRefresh)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnBack)))
                                .addGap(24, 24, 24))
                            .addComponent(plForStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(107, 107, 107))
        );
        panelRegisterFormLayout.setVerticalGroup(
            panelRegisterFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegisterFormLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addGap(4, 4, 4)
                .addGroup(panelRegisterFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(rbtnNormal)
                    .addComponent(rbtnStudent))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(plForStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(panelRegisterFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRegisterFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(panelRegisterFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbName)
                    .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRegisterFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRegisterFormLayout.createSequentialGroup()
                        .addComponent(lbPhone)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbEmail))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRegisterFormLayout.createSequentialGroup()
                        .addComponent(tfPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(panelRegisterFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbBirthday)
                    .addComponent(tfDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRegisterFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnMale)
                    .addComponent(rbtnFemale)
                    .addComponent(lbGender))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRegisterFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbAddress))
                .addGap(30, 30, 30)
                .addGroup(panelRegisterFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegister)
                    .addComponent(btnRefresh)
                    .addComponent(btnBack))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRegisterForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRegisterForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbtnMaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnMaleActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_rbtnMaleActionPerformed

    private void tfStudentIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfStudentIDMouseClicked

    }//GEN-LAST:event_tfStudentIDMouseClicked

    private void rbtnNormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnNormalActionPerformed
        
    }//GEN-LAST:event_rbtnNormalActionPerformed

    private void rbtnStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnStudentActionPerformed
       
    }//GEN-LAST:event_rbtnStudentActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        if(AccountHelper.validateUsername(tfUsername.getText())) System.out.println("u:true");
        else System.out.println("U:false");
        
        if(AccountHelper.validateEmail(tfEmail.getText())) System.out.println("e:true");
        else System.out.println("e:fasle");
        
        if(AccountHelper.validatePassword(tfPassword.getText())) System.out.println("p:true");
        else System.out.println("p:false");
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
       
    }//GEN-LAST:event_btnBackActionPerformed

    private void tfDayKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfDayKeyTyped
        boolean max = tfDay.getText().length() > 1;
        if ( max ){
            evt.consume();
        }        
    }//GEN-LAST:event_tfDayKeyTyped

    private void tfMonthKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfMonthKeyTyped
        boolean max = tfMonth.getText().length() > 1;
        if ( max ){
            evt.consume();
        }       
    }//GEN-LAST:event_tfMonthKeyTyped

    private void tfYearKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfYearKeyTyped
        boolean max = tfYear.getText().length() > 3;
        if ( max ){
            evt.consume();
        }       
    }//GEN-LAST:event_tfYearKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SignUpForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignUpForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignUpForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignUpForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignUpForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnRegister;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lbAddress;
    private javax.swing.JLabel lbBirthday;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbGender;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbPhone;
    private javax.swing.JLabel lbStudentID;
    private javax.swing.JPanel panelRegisterForm;
    private javax.swing.JPanel plForStudent;
    private javax.swing.JRadioButton rbtnFemale;
    private javax.swing.JRadioButton rbtnMale;
    private javax.swing.JRadioButton rbtnNormal;
    private javax.swing.JRadioButton rbtnStudent;
    private javax.swing.JTextField tfAddress;
    private javax.swing.JTextField tfDay;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfMonth;
    private javax.swing.JTextField tfName;
    private javax.swing.JPasswordField tfPassword;
    private javax.swing.JTextField tfPhoneNumber;
    private javax.swing.JTextField tfStudentID;
    private javax.swing.JTextField tfUsername;
    private javax.swing.JTextField tfYear;
    // End of variables declaration//GEN-END:variables
}

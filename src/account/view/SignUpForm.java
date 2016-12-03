package account.view;

import com.sun.beans.util.Cache;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import utils.AccountHelper;

public class SignUpForm extends javax.swing.JFrame implements ISignUpForm{
    private ButtonGroup btnGroupTypeOfRegister;
    private ButtonGroup btnGroupGender;
    /**
     * Creates new form SignUpForm
     */
    public SignUpForm() {
        initComponents();
        cbBoxBirthDay.setDateFormat(new SimpleDateFormat("dd - MM - yyyy"));
        btnGroupTypeOfRegister=new ButtonGroup();
        btnGroupTypeOfRegister.add(rbtnNormal);
        btnGroupTypeOfRegister.add(rbtnStudent);
        
        btnGroupGender=new ButtonGroup();
        btnGroupGender.add(rbtnFemale);
        btnGroupGender.add(rbtnMale);
    }

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
        tfPassword = new javax.swing.JPasswordField();
        cbBoxBirthDay = new org.freixas.jcalendar.JCalendarCombo();
        lbNationalID = new javax.swing.JLabel();
        tfNationalID = new javax.swing.JTextField();

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
                .addComponent(lbStudentID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
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

        btnRefresh.setText("Nhập lại");

        btnBack.setText("Quay lại");

        cbBoxBirthDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbBoxBirthDayActionPerformed(evt);
            }
        });

        lbNationalID.setText("CMND(*)");

        javax.swing.GroupLayout panelRegisterFormLayout = new javax.swing.GroupLayout(panelRegisterForm);
        panelRegisterForm.setLayout(panelRegisterFormLayout);
        panelRegisterFormLayout.setHorizontalGroup(
            panelRegisterFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegisterFormLayout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(plForStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelRegisterFormLayout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addGroup(panelRegisterFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRegisterFormLayout.createSequentialGroup()
                        .addGroup(panelRegisterFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRegisterFormLayout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addGroup(panelRegisterFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel1))
                                .addGap(0, 62, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRegisterFormLayout.createSequentialGroup()
                                .addGroup(panelRegisterFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(lbName)
                                    .addComponent(lbPhone)
                                    .addComponent(lbEmail)
                                    .addComponent(lbBirthday)
                                    .addComponent(lbGender)
                                    .addComponent(jLabel3)
                                    .addComponent(lbNationalID)
                                    .addComponent(lbAddress)
                                    .addComponent(btnRegister))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelRegisterFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(tfPassword, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelRegisterFormLayout.createSequentialGroup()
                                        .addComponent(rbtnMale)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                                        .addComponent(rbtnFemale))
                                    .addComponent(tfUsername, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfName, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfPhoneNumber, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfEmail, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfAddress)
                                    .addComponent(cbBoxBirthDay, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tfNationalID, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelRegisterFormLayout.createSequentialGroup()
                                        .addComponent(btnRefresh)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnBack)
                                        .addGap(10, 10, 10)))))
                        .addGap(131, 131, 131))
                    .addGroup(panelRegisterFormLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(56, 56, 56)
                        .addComponent(rbtnNormal)
                        .addGap(18, 18, 18)
                        .addComponent(rbtnStudent)
                        .addGap(107, 152, Short.MAX_VALUE))))
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
                .addGroup(panelRegisterFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRegisterFormLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(lbEmail))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRegisterFormLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelRegisterFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbPhone))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(panelRegisterFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbBirthday)
                    .addComponent(cbBoxBirthDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRegisterFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnMale)
                    .addComponent(rbtnFemale)
                    .addComponent(lbGender))
                .addGap(6, 6, 6)
                .addGroup(panelRegisterFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNationalID)
                    .addComponent(tfNationalID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRegisterFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbAddress)
                    .addComponent(tfAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(panelRegisterFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRefresh)
                    .addComponent(btnRegister)
                    .addComponent(btnBack))
                .addGap(45, 45, 45))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRegisterForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelRegisterForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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

    private void cbBoxBirthDayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbBoxBirthDayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbBoxBirthDayActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnRegister;
    private org.freixas.jcalendar.JCalendarCombo cbBoxBirthDay;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lbAddress;
    private javax.swing.JLabel lbBirthday;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbGender;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbNationalID;
    private javax.swing.JLabel lbPhone;
    private javax.swing.JLabel lbStudentID;
    private javax.swing.JPanel panelRegisterForm;
    private javax.swing.JPanel plForStudent;
    private javax.swing.JRadioButton rbtnFemale;
    private javax.swing.JRadioButton rbtnMale;
    private javax.swing.JRadioButton rbtnNormal;
    private javax.swing.JRadioButton rbtnStudent;
    private javax.swing.JTextField tfAddress;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfName;
    private javax.swing.JTextField tfNationalID;
    private javax.swing.JPasswordField tfPassword;
    private javax.swing.JTextField tfPhoneNumber;
    private javax.swing.JTextField tfStudentID;
    private javax.swing.JTextField tfUsername;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setVisibleForm(boolean isVisible) {
        setVisible(isVisible);
    }

    @Override
    public void closeForm() {
        super.dispose();
    }

    @Override
    public String getStudentIDOnSingupForm() {
        return tfStudentID.getText();
    }

    @Override
    public boolean getTypeOfRegisterOnSingupForm() {
        return rbtnNormal.isSelected();
    }

    @Override
    public String getUsernameOnSingupForm() {
        return tfUsername.getText();
    }

    @Override
    public String getPasswordOnSingupForm() {
        return tfPassword.getText();
    }

    @Override
    public String getNameOnSingupForm() {
        return tfName.getText();
    }

    @Override
    public String getEmailOnSingupForm() {
        return tfEmail.getText();
   }

    @Override
    public String getPhoneOnSingupForm() {
        return tfPhoneNumber.getText();
    }

    @Override
    public boolean getGenderOnSingupForm() {
        return rbtnMale.isSelected();
    }

    @Override
    public String getAddressOnSingupForm() {
        return tfAddress.getText();
    }

    @Override
    public void hidePanelEnterStudentInfo() {
        plForStudent.setEnabled(false);
    }

    @Override
    public void showPanelEnterStudentInfo() {
        plForStudent.setEnabled(true);    
    }


    @Override
    public void setButtonRegisterActionListener(ActionListener listener) {
        btnRegister.addActionListener(listener);
    }

    @Override
    public void setButtonRefreshActionListener(ActionListener listener) {
        btnRefresh.addActionListener(listener);
    }

    @Override
    public void setButtonBackActionListener(ActionListener listener) {
        btnBack.addActionListener(listener);
    }

    @Override
    public Date getComboboxBirthdayonSignForm() {
      
        return cbBoxBirthDay.getDate();
    }

    @Override
    public void hideStudentInfoFields() {
        tfStudentID.setEnabled(false);
        plForStudent.setEnabled(false);
        lbStudentID.setEnabled(false);
        tfName.setEnabled(true);
        tfPhoneNumber.setEnabled(true);
        tfEmail.setEnabled(true);
        cbBoxBirthDay.setEnabled(true);
        tfAddress.setEnabled(true);
        rbtnFemale.setEnabled(true);
        rbtnMale.setEnabled(true);
        lbName.setEnabled(true);
        lbPhone.setEnabled(true);
        lbEmail.setEnabled(true);
        lbAddress.setEnabled(true);
        lbBirthday.setEnabled(true);
        lbGender.setEnabled(true);
        lbNationalID.setEnabled(true);
    
    }

    @Override
    public void showStudentInfoFriends() {
        tfStudentID.setEnabled(true);
        plForStudent.setEnabled(true);
        lbStudentID.setEnabled(true);
        tfName.setEnabled(false);
        tfPhoneNumber.setEnabled(false);
        tfEmail.setEnabled(false);
        cbBoxBirthDay.setEnabled(false);
        tfAddress.setEnabled(false);
        rbtnFemale.setEnabled(false);
        rbtnMale.setEnabled(false);
        lbName.setEnabled(false);
        lbPhone.setEnabled(false);
        lbEmail.setEnabled(false);
        lbAddress.setEnabled(false);
        lbBirthday.setEnabled(false);
        lbGender.setEnabled(false);
         lbNationalID.setEnabled(false);
    }

    @Override
    public void setRadioButtonNormalActionListener(ActionListener listener) {
        rbtnNormal.addActionListener(listener);
    }

    @Override
    public void setRadioButtonStudentActionListener(ActionListener listener) {
        rbtnStudent.addActionListener(listener);
    }
    
    @Override
    public void noticeError(String title, String message) {
        JOptionPane.showMessageDialog(this,message, title, JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void noticeSuccessfully(String title, String message) {
        JOptionPane.showMessageDialog(this,message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public String getNationalOnSignupForm() {
        return tfNationalID.getText();
    }
}

package com.resume.panel;

import com.dao.inter.EmploymentHistoryDaoInter;
import com.entity.EmploymentHistory;
import com.entity.Skill;
import com.entity.UserSkill;
import com.main.Context;
import com.resume.config.Config;
import static com.resume.config.Config.loggedUser;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import lombok.SneakyThrows;

public class EmploymentHistoryPanel extends javax.swing.JPanel {

    private EmploymentHistoryDaoInter employmentHistoryDao = Context.instanceEmploymentHistoryDao();

    private List<EmploymentHistory> userEmploymentHistories;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public EmploymentHistoryPanel() {
        initComponents();
    }

    private void fillTable() {
        userEmploymentHistories = employmentHistoryDao.getAllEmploymentHistoryByUserId(Config.loggedUser.getId());

        Vector<Vector> rows = new Vector();

        for (EmploymentHistory item : userEmploymentHistories) {
            Vector row = new Vector();
            row.add(item.getHeader());
            row.add(item.getBeginDate());
            row.add(item.getEndDate());
            row.add(item.getJobDescription());
            rows.add(row);
        }

        Vector columns = new Vector();
        columns.add("Header");
        columns.add("Begin date");
        columns.add("End date");
        columns.add("Job description");

        DefaultTableModel model = new DefaultTableModel(rows, columns);

        tblEmploymentHistory.setModel(model);
    }

    public void fillUserComponents() {
        fillTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblHeader = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaHeader = new javax.swing.JTextArea();
        lblStartDate = new javax.swing.JLabel();
        txtStartDate = new javax.swing.JTextField();
        lblEndDate = new javax.swing.JLabel();
        txtEndDate = new javax.swing.JTextField();
        lblJobDescription = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAreaJobDescription = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblEmploymentHistory = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnChange = new javax.swing.JButton();

        lblHeader.setText("Header");

        txtAreaHeader.setColumns(20);
        txtAreaHeader.setRows(5);
        jScrollPane1.setViewportView(txtAreaHeader);

        lblStartDate.setText("Start date");

        lblEndDate.setText("End date");

        lblJobDescription.setText("Job description");

        txtAreaJobDescription.setColumns(20);
        txtAreaJobDescription.setRows(5);
        jScrollPane2.setViewportView(txtAreaJobDescription);

        tblEmploymentHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tblEmploymentHistory);

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnChange.setText("Change");
        btnChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblHeader)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblStartDate)
                                    .addComponent(txtStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(54, 54, 54)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblEndDate)
                                    .addComponent(txtEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblJobDescription)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAdd)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete)
                        .addGap(18, 18, 18)
                        .addComponent(btnChange)))
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHeader)
                    .addComponent(lblJobDescription))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblStartDate)
                            .addComponent(lblEndDate))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnDelete)
                    .addComponent(btnChange))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int index = tblEmploymentHistory.getSelectedRow();
        EmploymentHistory employmentHistory = userEmploymentHistories.get(index);
        employmentHistoryDao.removeEmploymentHistory(employmentHistory.getId());
        fillTable();
    }//GEN-LAST:event_btnDeleteActionPerformed

    @SneakyThrows
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String header = txtAreaHeader.getText();
        String startDate = txtStartDate.getText();
        String endDate = txtEndDate.getText();
        String jobDescription = txtAreaJobDescription.getText();

        Date sD = new Date(sdf.parse(startDate).getTime());
        Date eD = new Date(sdf.parse(endDate).getTime());
        
        EmploymentHistory newEmploymentHistory = new EmploymentHistory();

        newEmploymentHistory.setId(null);
        newEmploymentHistory.setHeader(header);
        newEmploymentHistory.setBeginDate(sD);
        newEmploymentHistory.setEndDate(eD);
        newEmploymentHistory.setJobDescription(jobDescription);
        newEmploymentHistory.setUser(loggedUser);

        employmentHistoryDao.addEmploymentHistory(newEmploymentHistory);
        
        fillTable();
    }//GEN-LAST:event_btnAddActionPerformed

    @SneakyThrows
    private void btnChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeActionPerformed
        EmploymentHistory selectedEmploymentHistory = userEmploymentHistories.get(tblEmploymentHistory.getSelectedRow());
        String header = txtAreaHeader.getText();
        String startDate = txtStartDate.getText();
        String endDate = txtEndDate.getText();
        String jobDescription = txtAreaJobDescription.getText();
        Date sD = new Date(sdf.parse(startDate).getTime());
        Date eD = new Date(sdf.parse(endDate).getTime());

        selectedEmploymentHistory.setId(selectedEmploymentHistory.getId());
        selectedEmploymentHistory.setHeader(header);
        selectedEmploymentHistory.setBeginDate(sD);
        selectedEmploymentHistory.setEndDate(eD);
        selectedEmploymentHistory.setJobDescription(jobDescription);
        selectedEmploymentHistory.setUser(loggedUser);

        employmentHistoryDao.updateEmploymentHistory(selectedEmploymentHistory);
        
        fillTable();
    }//GEN-LAST:event_btnChangeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnChange;
    private javax.swing.JButton btnDelete;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblEndDate;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblJobDescription;
    private javax.swing.JLabel lblStartDate;
    private javax.swing.JTable tblEmploymentHistory;
    private javax.swing.JTextArea txtAreaHeader;
    private javax.swing.JTextArea txtAreaJobDescription;
    private javax.swing.JTextField txtEndDate;
    private javax.swing.JTextField txtStartDate;
    // End of variables declaration//GEN-END:variables
}

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ScegliPersona extends javax.swing.JFrame
{
    private CreateTicket Dad;
    private DBInterface DB;
    
    public ScegliPersona(CreateTicket Dad, DBInterface DB)
    {
        initComponents();
        
        this.Dad = Dad;
        this.DB = DB;
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = this.getSize().width;
        int h = this.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;
        this.setLocation(x, y);
        
        //Utilizzando la X per chiudere un frame altrimenti terminerebbe tutto il processo
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        btnFiltra.setEnabled(false);
        btnSeleziona.setEnabled(false);
        
        setTable("", "");
    }
    
    private void setTable(String nome, String cognome)
    {
        tblTabella.setAutoCreateRowSorter(true);
        tblTabella.getTableHeader().setReorderingAllowed(false);
        DefaultTableModel model = (DefaultTableModel) tblTabella.getModel();
        model.setRowCount(0);
        model.setColumnCount(0);
        ResultSet rs = DB.cercaPersona(nome, cognome);
        ResultSetMetaData rsmd;
        try
        {
            rsmd = rs.getMetaData();
            int count = rsmd.getColumnCount();
            for(int i = 1; i <= count; i++)
            {
                model.addColumn(rsmd.getColumnName(i));
            }
            
            while (rs.next())
            {
                Object rowdata[] = new Object[count];
                for(int i = 0; i < count; i++)
                {
                    rowdata[i] = rs.getObject(i+1);
                }
                model.addRow(rowdata);
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(QueryResult.class.getName()).log(Level.SEVERE, null, ex);
        }
        tblTabella.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblTabella = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCognome = new javax.swing.JTextField();
        btnFiltra = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnSeleziona = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        tblTabella.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblTabella.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblTabellaMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblTabella);

        jLabel2.setText("Nome");

        txtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNomeKeyReleased(evt);
            }
        });

        jLabel3.setText("Cognome");

        txtCognome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCognomeKeyReleased(evt);
            }
        });

        btnFiltra.setText("Filtra");
        btnFiltra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltraActionPerformed(evt);
            }
        });

        btnSeleziona.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSeleziona.setText("SELEZIONA");
        btnSeleziona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelezionaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCognome, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnFiltra, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 299, Short.MAX_VALUE)
                        .addComponent(btnSeleziona, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtCognome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFiltra)
                    .addComponent(btnSeleziona, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addGap(8, 8, 8))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFiltraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltraActionPerformed
        setTable(txtNome.getText(), txtCognome.getText());
    }//GEN-LAST:event_btnFiltraActionPerformed

    private void btnSelezionaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelezionaActionPerformed
        int row = tblTabella.getSelectedRow();
        Dad.setPersona(tblTabella.getValueAt(row, 0).toString());
        this.setVisible(false);
        dispose();
    }//GEN-LAST:event_btnSelezionaActionPerformed

    private void tblTabellaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTabellaMouseReleased
        if(tblTabella.getSelectedRow() != -1 &&
            tblTabella.getSelectedColumn() != -1)
            btnSeleziona.setEnabled(true);
        else
            btnSeleziona.setEnabled(false);
    }//GEN-LAST:event_tblTabellaMouseReleased

    private void txtNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyReleased
        if (!txtNome.getText().equals("") || !txtCognome.getText().equals(""))
            btnFiltra.setEnabled(true);
        else
            btnFiltra.setEnabled(false);
    }//GEN-LAST:event_txtNomeKeyReleased

    private void txtCognomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCognomeKeyReleased
        if (!txtNome.getText().equals("") || !txtCognome.getText().equals(""))
            btnFiltra.setEnabled(true);
        else
            btnFiltra.setEnabled(false);
    }//GEN-LAST:event_txtCognomeKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFiltra;
    private javax.swing.JButton btnSeleziona;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tblTabella;
    private javax.swing.JTextField txtCognome;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}

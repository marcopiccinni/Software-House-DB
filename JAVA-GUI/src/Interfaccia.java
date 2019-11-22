import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Interfaccia extends javax.swing.JFrame
{
    private DBInterface DB;
    
    public Interfaccia(DBInterface DB)
    {
        initComponents();
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = this.getSize().width;
        int h = this.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;
        this.setLocation(x, y);
        
        btnModifica.setEnabled(false);
        
        this.DB = DB;
        inizializzaTblTicket();
    }
    
    public void aggiornaTabella()
    {
        for(ActionListener a: btnFiltra.getActionListeners())
        {
            a.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null) {});
        }
    }
    
    private void inizializzaTblTicket()
    {
        tblTicket.getColumnModel().getColumn(0).setPreferredWidth(10);  //ID
        tblTicket.getColumnModel().getColumn(1).setPreferredWidth(10);  //PRIORITA
        tblTicket.getColumnModel().getColumn(2).setPreferredWidth(80);  //STATO
        tblTicket.getColumnModel().getColumn(3).setPreferredWidth(200); //DESCRIZIONE
        tblTicket.getColumnModel().getColumn(4).setPreferredWidth(100); //DIVISIONE
        tblTicket.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblTicket.setAutoCreateRowSorter(true);
        tblTicket.getTableHeader().setReorderingAllowed(false);
        
        DefaultTableModel model = (DefaultTableModel) tblTicket.getModel();
        model.setRowCount(0);
        Ticket t[] = DB.tuttiTicket();
        Object rowdata[] = new Object[6];
        
        for(int i = 0; i<t.length; i++)
        {
            rowdata[0] = t[i].getId();
            rowdata[1] = t[i].getPriorita();
            rowdata[2] = t[i].getStato();
            rowdata[3] = t[i].getDescrizione();
            rowdata[4] = t[i].getData().toString();
            rowdata[5] = t[i].getDivisione();
            model.addRow(rowdata);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblTicket = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        cmbStato = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        dtcDataIn = new com.toedter.calendar.JDateChooser();
        dtcDataFin = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        cmbDivisione = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnFiltra = new javax.swing.JButton();
        cmbPrioritaIn = new javax.swing.JComboBox<>();
        cmbPrioritaFin = new javax.swing.JComboBox<>();
        btnModifica = new javax.swing.JButton();
        btnNuovo = new javax.swing.JButton();
        lblQueryTool = new javax.swing.JLabel();
        btnReset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Elenco Ticket");

        tblTicket.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Priorità", "Stato", "Descrizione", "Data", "Divisione"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTicket.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblTicketMouseReleased(evt);
            }
        });
        jScrollPane3.setViewportView(tblTicket);
        if (tblTicket.getColumnModel().getColumnCount() > 0) {
            tblTicket.getColumnModel().getColumn(0).setResizable(false);
            tblTicket.getColumnModel().getColumn(1).setResizable(false);
            tblTicket.getColumnModel().getColumn(2).setResizable(false);
            tblTicket.getColumnModel().getColumn(3).setResizable(false);
            tblTicket.getColumnModel().getColumn(4).setResizable(false);
            tblTicket.getColumnModel().getColumn(5).setResizable(false);
        }

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Filtri");

        jLabel3.setText("Stato");

        cmbStato.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tutti", "Aperti", "Completati", "Approvati", "Schedulat", "In Corsoi", "In Attesa", "Rifiutato" }));

        jLabel4.setText("Data da");

        jLabel5.setText("a");

        jLabel6.setText("Divisione");

        cmbDivisione.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tutti", "Hardware", "Software", "Vendita", "Direzione" }));

        jLabel7.setText("Priorità da");

        jLabel8.setText("a");

        btnFiltra.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnFiltra.setText("FILTRA");
        btnFiltra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltraActionPerformed(evt);
            }
        });

        cmbPrioritaIn.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        cmbPrioritaIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPrioritaInActionPerformed(evt);
            }
        });

        cmbPrioritaFin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        cmbPrioritaFin.setSelectedIndex(8);
        cmbPrioritaFin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPrioritaFinActionPerformed(evt);
            }
        });

        btnModifica.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnModifica.setText("MODIFICA");
        btnModifica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificaActionPerformed(evt);
            }
        });

        btnNuovo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnNuovo.setText("NUOVO TICKET");
        btnNuovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuovoActionPerformed(evt);
            }
        });

        lblQueryTool.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblQueryTool.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblQueryTool.setText("~Query Tool ~");
        lblQueryTool.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblQueryToolMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lblQueryToolMouseReleased(evt);
            }
        });

        btnReset.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnReset.setText("Reset Filtri");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 864, Short.MAX_VALUE)
                            .addComponent(jSeparator1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblQueryTool, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel3))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cmbStato, 0, 100, Short.MAX_VALUE)
                                            .addComponent(cmbDivisione, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addGap(16, 16, 16)
                                                .addComponent(dtcDataIn, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cmbPrioritaIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cmbPrioritaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(dtcDataFin, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                                            .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnFiltra, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(164, 164, 164)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnNuovo, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnModifica, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblQueryTool))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNuovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(cmbStato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4))
                            .addComponent(dtcDataIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dtcDataFin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cmbDivisione, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel6)
                                    .addComponent(cmbPrioritaIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbPrioritaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnFiltra, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnModifica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFiltraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltraActionPerformed
        String dataIn = "", dataFin = "";
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); 
        if(dtcDataIn.getDate() != null && dtcDataFin.getDate() != null)
        {
            java.util.Date a = dtcDataIn.getDate();
            dataIn = dateFormat.format(dtcDataIn.getDate());  
            dataFin = dateFormat.format(dtcDataFin.getDate());
            if(dtcDataIn.getDate().compareTo(dtcDataFin.getDate()) > 0)
            {
                JOptionPane.showMessageDialog(null, "Date inserite non in ordine", "Errore", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }
        String stato = "";
        String divisione = "";
        int prioIn = Integer.parseInt(cmbPrioritaIn.getSelectedItem().toString());
        int prioFin = Integer.parseInt(cmbPrioritaFin.getSelectedItem().toString());
        switch(cmbStato.getSelectedItem().toString())
        {
            case "Tutti":
                stato = "";
                break;
            case "Aperti":
                stato = "Aperti";
                break;
            case "Completati":
                stato = "Completed";
                break;
            case "Schedulati":
                stato = "Scheduled";
                break;
            case "In Attesa":
                stato = "On hold";
                break;
            case "Rifiutato":
                stato = "Rejected";
                break;
            case "Approvati":
                stato = "Approved";
                break;
            case "In Corso":
                stato = "In progress";
                break;
        }
        if (!(cmbDivisione.getSelectedItem().toString()).equals("Tutti"))
            divisione = cmbDivisione.getSelectedItem().toString();
        
        DefaultTableModel model = (DefaultTableModel) tblTicket.getModel();
        model.setRowCount(0);
        Ticket t[] = DB.ticketFiltrati(stato, divisione, prioIn, prioFin, dataIn, dataFin);
        Object rowdata[] = new Object[6];
        
        for(int i = 0; i<t.length; i++)
        {
            rowdata[0] = t[i].getId();
            rowdata[1] = t[i].getPriorita();
            rowdata[2] = t[i].getStato();
            rowdata[3] = t[i].getDescrizione();
            rowdata[4] = t[i].getData().toString();
            rowdata[5] = t[i].getDivisione();
            model.addRow(rowdata);
        }
    }//GEN-LAST:event_btnFiltraActionPerformed

    private void cmbPrioritaInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPrioritaInActionPerformed
        int pr1 = Integer.parseInt(cmbPrioritaIn.getSelectedItem().toString());
        int pr2 = Integer.parseInt(cmbPrioritaFin.getSelectedItem().toString());
        if(pr1 > pr2)
        {
            cmbPrioritaIn.setSelectedIndex(cmbPrioritaFin.getSelectedIndex()-1);
        }
    }//GEN-LAST:event_cmbPrioritaInActionPerformed

    private void cmbPrioritaFinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPrioritaFinActionPerformed
        int pr1 = Integer.parseInt(cmbPrioritaIn.getSelectedItem().toString());
        int pr2 = Integer.parseInt(cmbPrioritaFin.getSelectedItem().toString());
        if(pr1 > pr2)
        {
            cmbPrioritaIn.setSelectedIndex(cmbPrioritaFin.getSelectedIndex()+1);
        }
    }//GEN-LAST:event_cmbPrioritaFinActionPerformed

    private void btnModificaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificaActionPerformed
        int row = tblTicket.getSelectedRow();
        if (row != -1)
        {
            int id = Integer.parseInt(tblTicket.getValueAt(row, 0).toString());
            new ModTicket(this, DB, id).setVisible(true);
        }
    }//GEN-LAST:event_btnModificaActionPerformed

    private void tblTicketMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTicketMouseReleased
        int row = tblTicket.getSelectedRow();
        int col = tblTicket.getSelectedColumn();
        if(row != -1 && col != -1)
            btnModifica.setEnabled(true);
        else
            btnModifica.setEnabled(false);
    }//GEN-LAST:event_tblTicketMouseReleased

    private void btnNuovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuovoActionPerformed
        new CreateTicket(this, DB).setVisible(true);
    }//GEN-LAST:event_btnNuovoActionPerformed

    private void lblQueryToolMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQueryToolMouseReleased
        Font f = lblQueryTool.getFont();
        lblQueryTool.setFont(f.deriveFont(f.getStyle() & ~Font.ITALIC));
        new QueryTool(DB, this).setVisible(true);
    }//GEN-LAST:event_lblQueryToolMouseReleased

    private void lblQueryToolMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQueryToolMousePressed
        Font f = lblQueryTool.getFont();
        lblQueryTool.setFont(f.deriveFont(f.getStyle() | Font.ITALIC));
    }//GEN-LAST:event_lblQueryToolMousePressed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        cmbDivisione.setSelectedIndex(0);
        cmbPrioritaIn.setSelectedIndex(0);
        cmbPrioritaFin.setSelectedIndex(8);
        cmbStato.setSelectedIndex(0);
        dtcDataIn.setDate(null);
        dtcDataFin.setDate(null);
        aggiornaTabella();
    }//GEN-LAST:event_btnResetActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFiltra;
    private javax.swing.JButton btnModifica;
    private javax.swing.JButton btnNuovo;
    private javax.swing.JButton btnReset;
    private javax.swing.JComboBox<String> cmbDivisione;
    private javax.swing.JComboBox<String> cmbPrioritaFin;
    private javax.swing.JComboBox<String> cmbPrioritaIn;
    private javax.swing.JComboBox<String> cmbStato;
    private com.toedter.calendar.JDateChooser dtcDataFin;
    private com.toedter.calendar.JDateChooser dtcDataIn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblQueryTool;
    private javax.swing.JTable tblTicket;
    // End of variables declaration//GEN-END:variables
}

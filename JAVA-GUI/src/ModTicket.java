import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ModTicket extends javax.swing.JFrame
{
    private Interfaccia Dad;
    private DBInterface DB;
    private Ticket T;
    
    public ModTicket(Interfaccia Dad, DBInterface DB, int id)
    {
        initComponents();
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = this.getSize().width;
        int h = this.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;
        this.setLocation(x, y);
        
        this.Dad = Dad;
        this.DB = DB;
        txtId.setEditable(false);
        txtCF.setEditable(false);
        txtData.setEditable(false);
        txtDurata.setEditable(false);
        txtAllegato.setEditable(false);
        cmbDivisione.setEnabled(false);

        infoTicket(id);
        
        //Utilizzando la X per chiudere un frame altrimenti terminerebbe tutto il processo
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    private void infoTicket(int id)
    {
        T = DB.getTicket(id);
        txtId.setText(String.valueOf(T.getId()));
        txtData.setText(T.getData().toString());
        txtDescrizione.setText(T.getDescrizione());
        txtCF.setText(T.getCf());
        
        if(T.getPrezzo() != 0)
            txtPrezzo.setText(String.valueOf(T.getPrezzo()));
        if(T.getDurata_totale() != null)
            txtDurata.setText(String.valueOf(T.getDurata_totale()));
        
        if(T.getId_sw() != 0)
        {
            Software sw = DB.getSoftware(T.getId_sw());
            if (sw != null)
            txtAllegato.setText(sw.getNome());
        }
        else if(T.getId_hw() != 0)
        {
            Hardware hw = DB.getHardware(T.getId_hw());
            if (hw != null)
            txtAllegato.setText(hw.getInfo());
        }
        else
            txtAllegato.setEnabled(false);
            
        cmbPriorita.setSelectedIndex(T.getPriorita()-1);
        
        switch(T.getDivisione())
        {
            case "Hardware":
                cmbDivisione.setSelectedIndex(0);
                break;
            case "Software":
                cmbDivisione.setSelectedIndex(1);
                break;
            case "Vendita":
                cmbDivisione.setSelectedIndex(2);
                break;
            case "Direzione":
                cmbDivisione.setSelectedIndex(3);
                break;
        }
        
        switch(T.getStato())
        {
            case "Completed":
                cmbStato.setSelectedIndex(0);
                break;
            case "Scheduled":
                cmbStato.setSelectedIndex(1);
                break;
            case "Approved":
                cmbStato.setSelectedIndex(2);
                break;
            case "In progress":
                cmbStato.setSelectedIndex(3);
                break;
            case "On hold":
                cmbStato.setSelectedIndex(4);
                break;
            case "Rejected":
                cmbStato.setSelectedIndex(5);
                break;     
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitolo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtId = new javax.swing.JTextField();
        txtPrezzo = new javax.swing.JTextField();
        txtCF = new javax.swing.JTextField();
        txtAllegato = new javax.swing.JTextField();
        txtData = new javax.swing.JTextField();
        txtDurata = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescrizione = new javax.swing.JTextArea();
        btnModifica = new javax.swing.JButton();
        btnElimina = new javax.swing.JButton();
        cmbStato = new javax.swing.JComboBox<>();
        cmbPriorita = new javax.swing.JComboBox<>();
        cmbDivisione = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        lblTitolo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTitolo.setText("Informazioni Ticket");

        jLabel1.setText("ID");

        jLabel2.setText("Stato");

        jLabel3.setText("Data");

        jLabel4.setText("Priorità");

        jLabel5.setText("Prezzo");

        jLabel6.setText("Durata Totale");

        jLabel7.setText("CF");

        jLabel8.setText("Divisione");

        jLabel9.setText("Allegato");

        jLabel11.setText("Descrizione");

        txtDescrizione.setColumns(20);
        txtDescrizione.setRows(5);
        jScrollPane1.setViewportView(txtDescrizione);

        btnModifica.setText("Modifica");
        btnModifica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificaActionPerformed(evt);
            }
        });

        btnElimina.setText("Elimina");
        btnElimina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminaActionPerformed(evt);
            }
        });

        cmbStato.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Completato", "Schedulato", "Approvato", "In Corso", "In Attesa", "Rifiutato" }));

        cmbPriorita.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" }));

        cmbDivisione.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hardware", "Software", "Vendita", "Direzione" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblTitolo)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel7))
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(29, 29, 29)
                                                .addComponent(jLabel3))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txtPrezzo, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                                    .addComponent(txtCF, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                                    .addComponent(cmbStato, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(29, 29, 29)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel8)
                                                    .addComponent(jLabel6)
                                                    .addComponent(jLabel4))))
                                        .addGap(30, 30, 30)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtDurata, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                            .addComponent(txtData, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                            .addComponent(cmbPriorita, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cmbDivisione, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addComponent(txtAllegato)))
                            .addComponent(jLabel11)
                            .addComponent(jScrollPane1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnModifica, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnElimina, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitolo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(cmbStato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPrezzo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAllegato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnModifica, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(12, 12, 12))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbPriorita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtDurata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cmbDivisione, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(btnElimina, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnModificaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificaActionPerformed
        int id = Integer.parseInt(txtId.getText());
        String descrizione = txtDescrizione.getText();
        int priorita = Integer.parseInt(cmbPriorita.getSelectedItem().toString());
        
        double prezzo = 0;
        if(!txtPrezzo.getText().equals(""))
        {
            try
            {
                prezzo = Double.parseDouble(txtPrezzo.getText());
            }
            catch (NumberFormatException e)
            {
                prezzo = -1;
            }
        }
        
        if(descrizione.equals("") || prezzo == -1)
        {
            JOptionPane.showMessageDialog(null, "Valori non validi, riprovare", "Errore", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        String stato;
        switch(cmbStato.getSelectedIndex())
        {
            case 0:
                stato = "Completed";
                break;
            case 1:
                stato = "Scheduled";
                break;
            case 2:
                stato = "Approved";
                break;
            case 3:
                stato = "In progress";
                break;
            case 4:
                stato = "On hold";
                break;
            default:
                stato = "Rejected";
                break;
        }
        
        DB.updateTicket(id, stato, descrizione, priorita, prezzo);
        Dad.aggiornaTabella();
        this.setVisible(false);
        dispose();
    }//GEN-LAST:event_btnModificaActionPerformed

    private void btnEliminaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminaActionPerformed
        int id = Integer.parseInt(txtId.getText());
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(this,
            "Sicuro di voler eliminare il Ticket ID: " + id, "Eliminazione",
            dialogButton);
        if(dialogResult == 0)
        {
            DB.deleteTicket(id);
            Dad.aggiornaTabella();
            this.setVisible(false);
            dispose();
        }
    }//GEN-LAST:event_btnEliminaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnElimina;
    private javax.swing.JButton btnModifica;
    private javax.swing.JComboBox<String> cmbDivisione;
    private javax.swing.JComboBox<String> cmbPriorita;
    private javax.swing.JComboBox<String> cmbStato;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblTitolo;
    private javax.swing.JTextField txtAllegato;
    private javax.swing.JTextField txtCF;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextArea txtDescrizione;
    private javax.swing.JTextField txtDurata;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtPrezzo;
    // End of variables declaration//GEN-END:variables
}

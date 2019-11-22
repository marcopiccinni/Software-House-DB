import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CreateTicket extends javax.swing.JFrame
{
    private Interfaccia Dad;
    private DBInterface DB;
    private Software sw[];
    private Hardware hw[];
    
    public CreateTicket(Interfaccia Dad, DBInterface DB)
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
        
        txtRichiedente.setEditable(false);
        txtData.setEditable(false);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
        txtData.setText(dateFormat.format(date));
        
        cmbStato.setSelectedIndex(4);
        cmbDivisione.setSelectedIndex(2);
        cmbAllegato.setEnabled(false);
        sw = DB.getAllSofware();
        hw = DB.getAllHardware();
    }
    
    public void setPersona(String CF)
    {
        txtRichiedente.setText(CF);
    }
    
    private void caricaHardware()
    {
        cmbAllegato.removeAllItems();
        cmbAllegato.addItem("");
        for (Hardware hw1 : hw)
            cmbAllegato.addItem(hw1.getInfo());
    }
    
    private void caricaSoftware()
    {
        cmbAllegato.removeAllItems();
        cmbAllegato.addItem("");
        for (Software sw1 : sw)
            cmbAllegato.addItem(sw1.getNome());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbStato = new javax.swing.JComboBox<>();
        cmbDivisione = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtData = new javax.swing.JTextField();
        txtRichiedente = new javax.swing.JTextField();
        btnScegli = new javax.swing.JButton();
        cmbAllegato = new javax.swing.JComboBox<>();
        lblAllegato = new javax.swing.JLabel();
        btnCrea = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescrizione = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Creazione Ticket");

        jLabel2.setText("Richiedente");

        jLabel3.setText("Stato");

        cmbStato.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Completato", "Schedulato", "Approvato", "In Corso", "In Attesa", "Rifiutato" }));
        cmbStato.setToolTipText("");

        cmbDivisione.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hardware", "Software", "Vendita", "Direzione" }));
        cmbDivisione.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDivisioneActionPerformed(evt);
            }
        });

        jLabel4.setText("Divisione");

        jLabel5.setText("Data");

        btnScegli.setText("Scegli");
        btnScegli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnScegliActionPerformed(evt);
            }
        });

        lblAllegato.setText("Relativo a");

        btnCrea.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCrea.setText("CREA TICKET");
        btnCrea.setToolTipText("");
        btnCrea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreaActionPerformed(evt);
            }
        });

        jLabel6.setText("Descrizione");

        txtDescrizione.setColumns(20);
        txtDescrizione.setRows(5);
        jScrollPane1.setViewportView(txtDescrizione);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(lblAllegato))
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbAllegato, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cmbDivisione, 0, 134, Short.MAX_VALUE)
                                            .addComponent(txtRichiedente))
                                        .addGap(4, 4, 4)
                                        .addComponent(btnScegli)
                                        .addGap(33, 33, 33)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel5))
                                        .addGap(42, 42, 42)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(cmbStato, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtData, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)))))
                            .addComponent(jLabel6))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(btnCrea, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(cmbStato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRichiedente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnScegli))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbDivisione, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAllegato)
                    .addComponent(cmbAllegato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCrea, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnScegliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnScegliActionPerformed
        new ScegliPersona(this, DB).setVisible(true);
    }//GEN-LAST:event_btnScegliActionPerformed

    private void cmbDivisioneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDivisioneActionPerformed
        switch(cmbDivisione.getSelectedItem().toString())
        {
            case "Hardware":
                cmbAllegato.setEnabled(true);
                caricaHardware();
                break;
            case "Software":
                cmbAllegato.setEnabled(true);
                caricaSoftware();
                break;
            case "Vendita":
            case "Direzione":
                cmbAllegato.removeAllItems();
                cmbAllegato.setEnabled(false);
        }
    }//GEN-LAST:event_cmbDivisioneActionPerformed

    private void btnCreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreaActionPerformed
        String cf = txtRichiedente.getText();
        String divisione = cmbDivisione.getSelectedItem().toString();
        String data = txtData.getText();
        String descrizione = txtDescrizione.getText();
        
        if(!cf.equals("") && !descrizione.equals(""))
        {
            if ((divisione.equals("Hardware") || divisione.equals("Software"))
                    && cmbAllegato.getSelectedIndex() == 0)
            {
                JOptionPane.showMessageDialog(null,
                    "Non tutti i campi sono compilati", "Errore",
                    JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null,
                "Non tutti i campi sono compilati", "Errore",
                JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        String stato = "";
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
        
        int id = -1;
        if ((divisione.equals("Hardware") || divisione.equals("Software"))
                && cmbAllegato.getSelectedIndex() > 0)
        {
            id = cmbAllegato.getSelectedIndex() - 1;
            if(divisione.equals("Hardware"))
                DB.inserisciTicketHardware(data, stato, descrizione,
                        cf, id,divisione);
            if(divisione.equals("Software"))
                DB.inserisciTicketSoftware(data, stato, descrizione,
                        cf, id,divisione);
        }
        else
        {
            DB.inserisciTicket(data, stato, descrizione, cf, id, id, divisione);
        }
        Dad.aggiornaTabella();
        this.setVisible(false);
        dispose();
    }//GEN-LAST:event_btnCreaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrea;
    private javax.swing.JButton btnScegli;
    private javax.swing.JComboBox<String> cmbAllegato;
    private javax.swing.JComboBox<String> cmbDivisione;
    private javax.swing.JComboBox<String> cmbStato;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblAllegato;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextArea txtDescrizione;
    private javax.swing.JTextField txtRichiedente;
    // End of variables declaration//GEN-END:variables
}

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.ResultSet;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class QueryTool extends javax.swing.JFrame
{
    private Interfaccia Dad;
    private DBInterface DB;
    private QueryResult QR;
    
    public QueryTool(DBInterface DB, Interfaccia Dad)
    {
        initComponents();
        
        this.DB = DB;
        this.Dad = Dad;
        
        btnCarica.setEnabled(false);
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = this.getSize().width;
        int h = this.getSize().height;
        int x = (dim.width-w)/5;
        int y = (dim.height-h)/2;
        this.setLocation(x, y);
        
        //Utilizzando la X per chiudere un frame altrimenti terminerebbe tutto il processo
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        DefaultListCellRenderer renderer = (DefaultListCellRenderer) lstDemo.getCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.RIGHT);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstDemo = new javax.swing.JList<>();
        btnEsegui = new javax.swing.JButton();
        btnCarica = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Query Tool");

        txtArea.setColumns(20);
        txtArea.setFont(new java.awt.Font("Candara", 0, 13)); // NOI18N
        txtArea.setRows(5);
        jScrollPane1.setViewportView(txtArea);

        lstDemo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lstDemo.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Interrogazione 1", "Interrogazione 2", "Interrogazione 3", "Interrogazione 4", "Interrogazione 5", "Interrogazione 6" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lstDemo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lstDemoMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(lstDemo);

        btnEsegui.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnEsegui.setText("Esegui");
        btnEsegui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEseguiActionPerformed(evt);
            }
        });

        btnCarica.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCarica.setText("Carica Query");
        btnCarica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCaricaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEsegui, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCarica, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCarica, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEsegui, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lstDemoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstDemoMouseReleased
        if(lstDemo.getSelectedIndex() != -1)
            btnCarica.setEnabled(true);
    }//GEN-LAST:event_lstDemoMouseReleased

    private void btnEseguiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEseguiActionPerformed
        String SQL = txtArea.getText().replace("\n"," ");
        if (QR != null) //ELIMINA PRECEDENTE RESULT, SE SI VOLESSE MANTENERE BASTA COMMENTARE QUESTO IF
            QR.dispose();
        ResultSet rs = DB.eseguiQuery(SQL);
        if (rs == null)
        {
            JOptionPane.showMessageDialog(null, "Query non valida, riprovare", "Errore", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        QR = new QueryResult(this, rs);
        QR.setVisible(true);
    }//GEN-LAST:event_btnEseguiActionPerformed

    private void btnCaricaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCaricaActionPerformed
        //GESTIONE DELLE QUERY DEMO
        String SQL = "";
        switch(lstDemo.getSelectedIndex())
        {
            case 0:
                SQL = "SELECT CF\n"
                    + "FROM PERSONA P\n"
                    + "WHERE CF <> 'VITBOTVQ5T3BB0O4'\n"
                    + "AND NOT EXISTS(SELECT *\n"
                    + "             FROM ORDINE O, DI_S D\n"
                    + "             WHERE O.ID = D.ORDINE\n"
                    + "             AND O.CLIENTE = 'VITBOTVQ5T3BB0O4'\n"
                    + "             AND NOT EXISTS(SELECT *\n"
                    + "                             FROM ORDINE O2, DI_S D2\n"
                    + "                             WHERE O2.ID = D2.ORDINE\n"
                    + "                             AND O2.CLIENTE = P.CF\n"
                    + "                             AND D.SOFTWARE = D2.SOFTWARE\n"
                    + "                             )\n"
                    + "             );";
                break;
            case 1:
                SQL = "SELECT *\n"
                    + "FROM TICKET T1\n"
                    + "WHERE (SELECT COUNT(DISTINCT I2.CF)\n"
                    + "         FROM IN_CARICO I2\n"
                    + "         WHERE I2.ID = T1.ID) = (SELECT COUNT(*)\n"
                    + "                                 FROM DIPENDENTE D3\n"
                    + "                                 WHERE D3.DIVISIONE = T1.DIVISIONE)";
                break;
            case 2:
                SQL = "SELECT SUM(O.PREZZO_TOTALE) AS GUADAGNO_MENSILE, P.NOME, "
                    + "P.COGNOME, P.CF, to_char(O.DATA, 'YYYY-MM') AS PERIODO\n"
                    + "FROM DIPENDENTE D, ORDINE O, PERSONA P\n"
                    + "WHERE O.DIPENDENTE = D.CF\n"
                    + "AND D.CF = P.CF\n"
                    + "GROUP BY 4, 5\n"
                    + "ORDER BY 1 DESC\n"
                    + "LIMIT 1;";
                break;
            case 3:
                SQL = "SELECT MARCA, MODELLO, QUANTITA\n"
                    + "FROM M_VENDITA\n"
                    + "ORDER BY 3,1,2";
                break;
            case 4:
                SQL = "SELECT *\n"
                    + "FROM TICKET\n"
                    + "WHERE STATO NOT IN ('Completed', 'Rejected')\n"
                    + "ORDER BY PRIORITA, DATA";
                break;
            case 5:
                SQL = "SELECT D.CF, P.NOME, P.COGNOME, COUNT(*) AS NUMERO_ORDINI\n"
                    + "FROM DIPENDENTE D, ORDINE O, PERSONA P\n"
                    + "WHERE D.CF = O.DIPENDENTE\n"
                    + "  AND D.CF = P.CF\n"
                    + "  AND O.DATA BETWEEN '2019-1-1' AND '2019-1-31'\n"
                    + "GROUP BY 1, 2, 3\n"
                    + "ORDER BY 4 DESC";
                break;
        }
        txtArea.setText(SQL);
    }//GEN-LAST:event_btnCaricaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCarica;
    private javax.swing.JButton btnEsegui;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JList<String> lstDemo;
    private javax.swing.JTextArea txtArea;
    // End of variables declaration//GEN-END:variables
}

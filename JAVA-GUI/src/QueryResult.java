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

public class QueryResult extends javax.swing.JFrame
{
    private QueryTool CT;
    public QueryResult(QueryTool CT, ResultSet rs)
    {
        initComponents();
        popola(rs);
        
        this.CT = CT;
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = this.getSize().width;
        int h = this.getSize().height;
        int x = (dim.width-w) - (dim.width-w)/5;
        int y = (dim.height-h)/2;
        this.setLocation(x, y);
        
        //Utilizzando la X per chiudere un frame altrimenti terminerebbe tutto il processo
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    private void popola(ResultSet rs)
    {
        tblTable.setAutoCreateRowSorter(true);
        tblTable.getTableHeader().setReorderingAllowed(false);
        DefaultTableModel model = (DefaultTableModel) tblTable.getModel();
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
        tblTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblTable;
    // End of variables declaration//GEN-END:variables
}

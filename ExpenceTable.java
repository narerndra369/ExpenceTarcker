import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ExpenceTable {


    private JTable tabl;
    private DefaultTableModel model;    // Table model to handle data
    public  ExpenceTable(JFrame frame) {
         tabl=new JTable();
        Object[]  columns={"date","description","amount","type"};   // Column names
        
        model = new DefaultTableModel();

        model.setColumnIdentifiers(columns);

        tabl.setModel(model);

        // scroll pane for the table
        JScrollPane pane = new JScrollPane(tabl);
        pane.setBounds(10,10,10,10);
        frame.getContentPane().add(pane);;

    }

    // Method to add a row to the table
    void addrow(Object[] data){
        model.addRow(data);
    }

}

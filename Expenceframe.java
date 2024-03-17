import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Expenceframe {
    
    private Object[] data = new Object[4];  // Array to store expense data

    public void frame(){
        JFrame frame =new JFrame("frame");
        JLabel dateLabel = new JLabel("Date:");
        JLabel descriptionLabel = new JLabel("Description:");
        JLabel amountLabel = new JLabel("Amount:");
        JLabel typeLabel = new JLabel("Type:");
        JLabel balanceLabel1 = new JLabel("Balance:");
        JLabel balanceLabel = new JLabel("0");

        JTextField dateTextField = new JTextField(10);
        JTextField descriptionTextField = new JTextField(20);
        JTextField amountTextField = new JTextField(10);

        String[] types = {"Expense", "Income"};
        JComboBox<String> typeComboBox = new JComboBox<>(types);    // Combo box for selecting expense type
        JButton button = new JButton("add");
        JPanel panel = new JPanel( new GridBagLayout());    //organize components
        GridBagConstraints c = new GridBagConstraints();    // Constraints for GridBagLayout
        c.insets=new Insets(10,10 , 10, 10);
        
        panel.add(dateLabel,c);
        
        panel.add(dateTextField,c);
        
        panel.add(descriptionLabel,c);
        
        panel.add(descriptionTextField,c);
    
        panel.add(amountLabel,c);
    
        panel.add(amountTextField,c);
        
        panel.add(typeLabel,c);
        
        panel.add(typeComboBox,c);
        
        panel.add(button,c);

        panel.add(balanceLabel1,c);

        panel.add(balanceLabel,c);

        panel.setPreferredSize(new Dimension(200,50));  
        frame.add(panel,BorderLayout.NORTH);

        ExpenceTable extable = new ExpenceTable(frame);
        frame.setSize(500, 500);
        frame.setVisible(true);

        

      button.addActionListener(new ActionListener() {
        
        public void actionPerformed(ActionEvent arg0) {
            // Retrieve data from input fields and combo box
            data[0]=dateTextField.getText();
            data[1]=descriptionTextField.getText();
            data[2]=amountTextField.getText();
            data[3]=typeComboBox.getSelectedItem();
            
            extable.addrow(data);

            int bal1;
            String compareCombo = (String)  typeComboBox.getSelectedItem();
            if(compareCombo.equals("Expense"))
            {
                // If expense, subtract the amount from the balance
                System.out.println("Expence");
                bal1=Integer.parseInt(balanceLabel.getText());
                System.out.println(bal1);
                bal1 =bal1-Integer.parseInt(amountTextField.getText().toString());
                System.out.println(bal1);
                balanceLabel.setText(Integer.toString(bal1));
            }
            else
            {
                // If income, Add the amount from the balance
                bal1=Integer.parseInt(balanceLabel.getText());
                System.out.println(bal1);
                bal1 =bal1+Integer.parseInt(amountTextField.getText().toString());
                System.out.println(bal1);
                balanceLabel.setText(Integer.toString(bal1));
            }
        }
        }); 
        
        
    } 
   
}


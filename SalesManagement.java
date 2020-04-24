package sales.management;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.List;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SalesManagement extends javax.swing.JFrame {

	private JPanel contentPane;
	private JTextField txtprice;
	private JTextField txtnumber;
	
	private List lstshop;
	private List lstprice;
	private JLabel lblnumber;
	private JLabel lbltotal;
	
	Double total = 0.0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalesManagement frame = new SalesManagement();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SalesManagement() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 683, 529);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hardware Management");
		lblNewLabel.setForeground(Color.darkGray);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel.setBounds(110, 62, 331, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Product");
		lblNewLabel_1.setBounds(32, 161, 56, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Price");
		lblNewLabel_2.setBounds(32, 237, 56, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Number");
		lblNewLabel_3.setBounds(32, 288, 56, 16);
		contentPane.add(lblNewLabel_3);
		
		JComboBox cmbproduct  = new JComboBox(); 
		cmbproduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				/*Delete the product quantity and 
				 * the price from price and quantity 
				 * field after adding them
				 */
				txtprice.setText("");
				txtnumber.setText("");
				txtprice.requestFocus();
				
			}
		});
		cmbproduct.setModel(new DefaultComboBoxModel(new String[] {"Laptop", "Computer case", "Screen", "Keyboard", "Mous", "Motherboard", "Graphic card", "Soundcard", "Memory Card", "USB"}));
		cmbproduct.setBounds(106, 158, 131, 22);
		contentPane.add(cmbproduct);
		
		txtprice = new JTextField();
		txtprice.setBounds(104, 234, 133, 22);
		contentPane.add(txtprice);
		txtprice.setColumns(10);
		
		txtnumber = new JTextField();
		txtnumber.setBounds(104, 285, 133, 22);
		contentPane.add(txtnumber);
		txtnumber.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Shopping list");
		lblNewLabel_4.setBounds(293, 161, 56, 16);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Amounts");
		lblNewLabel_5.setBounds(430, 161, 56, 16);
		contentPane.add(lblNewLabel_5);
		
		List lstshop = new List();
		lstshop.setBounds(263, 191, 125, 184);
		contentPane.add(lstshop);
		
		List lstprice = new List();
		lstprice.setBounds(412, 191, 125, 184);
		contentPane.add(lstprice);
		
		JLabel lblnumber = new JLabel("");
		lblnumber.setOpaque(true);
		lblnumber.setBackground(Color.WHITE);
		lblnumber.setBounds(263, 381, 125, 16);
		contentPane.add(lblnumber);
		
		JLabel lbltotal = new JLabel("");
		lbltotal.setOpaque(true);
		lbltotal.setBackground(Color.WHITE);
		lbltotal.setBounds(413, 381, 124, 16);
		contentPane.add(lbltotal);
		
		//***Add button***
		JButton btnadd = new JButton("Add");
		
		// Add Button Action
		btnadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String product;
				Double price, amount;
				int number, productQuantity;
				
				// Assign the selected Item to Product and parse it
				product = cmbproduct.getSelectedItem().toString(); 
				
				//Get the price from the user and parse it to Double
				price = Double.parseDouble(txtprice.getText());
				
				// Get the  product quantity  from the user and parse it to integer
				number = Integer.parseInt(txtnumber.getText());

				//Calculate the amount to pay and show it in the list of price and shop
				amount = price*number;
				lstshop.add(product);
				lstprice.add(String.valueOf(amount));

				// Get the product quantity and assign it to the label number
				productQuantity = lstshop.getItemCount();
				lblnumber.setText(String.valueOf(productQuantity));
				
				//Calculate the Total of all product and assign it to the lable total
				total = total + amount;
				lbltotal.setText(String.valueOf(total));
			}
		});
		// Add Button Action
		
		btnadd.setBounds(12, 425, 97, 25);
		contentPane.add(btnadd);
		//***Add button***
		
		//***Remove button***
		JButton btnremove = new JButton("Remove");
		
		// Remove Button Action
		btnremove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index, number;
				Double amount, total;
				
				//Get the quantity of product
				number =Integer.parseInt(lblnumber.getText());
				
				//Get the Text from total label and parse it to double
				total = Double.parseDouble(lbltotal.getText());
				
				//Get the selected index(product)
				index = lstshop.getSelectedIndex();
				
				//Get the selected amount(of the product)
				amount = Double.parseDouble(lstprice.getItem(index));
				
				//Substruct one from the total number of Product
				number = number - 1;
				
				//Substruct the selected amount from the total
				total = total - amount;
				
				lstshop.remove(index);
				lstprice.remove(index);
				
				//Set the new value of product quantity
				lblnumber.setText(String.valueOf(number));
				
				//Set the new value of total
				lbltotal.setText(String.valueOf(total));
			}
		});
		// Remove Button Action
		
		btnremove.setBounds(166, 425, 97, 25);
		contentPane.add(btnremove);
		//***Remove button***
		
		//***Delete button***
		JButton btndelete = new JButton("Delete");
		
		// Delete Button Action
		btndelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Make all Field empty
				txtprice.setText("");
				txtnumber.setText("");
				lstshop.removeAll();
				lstprice.removeAll ();
				lblnumber.setText ("");
				lbltotal.setText ("");
			}
		});
		// Delete Button Action
		
		btndelete.setBounds(325, 425, 97, 25);
		contentPane.add(btndelete);
		//***Delete button***
		
		//***Exit button***
		JButton btnexit = new JButton("Exit");
		
		// Exit Button Action
		btnexit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Exit the System
				System.exit(0);
			}
		});
		// Exit Button Action
		
		btnexit.setBounds(478, 425, 97, 25);
		contentPane.add(btnexit);
		//***Exit button***
		 
	}
}

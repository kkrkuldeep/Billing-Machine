package BillingPanel;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.event.ActionEvent;

public class BillMachine extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel Add;
	private JTextField billnutf;
	private JTextField producttf;
	private JTextField quantitytf;
	private JButton btnAdd;
	private JTextArea txtrPrinttf;
	private JTextField itemtf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BillMachine frame = new BillMachine();
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
	public BillMachine() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 647, 530);
		Add = new JPanel();
		Add.setBackground(new Color(0, 255, 255));
		Add.setBorder(new LineBorder(Color.GREEN, 3));
		setContentPane(Add);
		Add.setLayout(null);

		JLabel lblAnilHosieryBilling = new JLabel("Anil Hosiery Billing Machine");
		lblAnilHosieryBilling.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblAnilHosieryBilling.setBounds(135, 11, 286, 44);
		Add.add(lblAnilHosieryBilling);

		JLabel lblBillNumber = new JLabel("Bill number : ");
		lblBillNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBillNumber.setBounds(10, 86, 120, 26);
		Add.add(lblBillNumber);

		JLabel lblProductName = new JLabel("Product Name : ");
		lblProductName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblProductName.setBounds(10, 134, 120, 26);
		Add.add(lblProductName);

		JLabel lblQuanitiy = new JLabel("Quanitiy :");
		lblQuanitiy.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQuanitiy.setBounds(10, 179, 120, 26);
		Add.add(lblQuanitiy);

		billnutf = new JTextField();
		billnutf.setBounds(135, 91, 104, 20);
		Add.add(billnutf);
		billnutf.setColumns(10);

		producttf = new JTextField();
		producttf.setBounds(135, 139, 104, 20);
		Add.add(producttf);
		producttf.setColumns(10);

		quantitytf = new JTextField();
		quantitytf.setBounds(135, 184, 104, 20);
		Add.add(quantitytf);
		quantitytf.setColumns(10);

		JButton btnPrintReceipt = new JButton("Print Receipt");
		btnPrintReceipt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtrPrinttf.setText(txtrPrinttf.getText() + "\n" + "======================================" + "\n"
						+ "Developed by : Kuldep Singh\n");

				try {
					boolean complete = txtrPrinttf.print();
					if (complete)
						JOptionPane.showMessageDialog(null, "Printng Done!");
					else {
						JOptionPane.showConfirmDialog(null, e);
					}

				} catch (PrinterException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnPrintReceipt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPrintReceipt.setBackground(new Color(0, 255, 0));
		btnPrintReceipt.setBounds(359, 326, 249, 44);
		Add.add(btnPrintReceipt);

		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String billno = billnutf.getText();
				String product = producttf.getText();
				String quantity = quantitytf.getText();
				String item = itemtf.getText();
				float price = Integer.parseInt(quantity) * Float.valueOf(item);

				if (!billno.isEmpty() && !product.isEmpty() && !quantity.isEmpty() && !item.isEmpty()) {
					txtrPrinttf.setText(txtrPrinttf.getText() + "Bill number : " + billno + "\n" + "Product name : "
							+ product + "\n" + "Quantity : " + quantity + "\n" + "Total Amount : " + price + "\n\n");
				}

				if (billno.isEmpty()) {
					txtrPrinttf.setText(txtrPrinttf.getText() + "Product name : " + product + "\n" + "Quantity : "
							+ quantity + "\n" + "Total Amount : " + price + "\n\n");
				}

				billnutf.setText(null);
				producttf.setText(null);
				quantitytf.setText(null);
				itemtf.setText(null);
			}
		});
		btnAdd.setBackground(Color.GREEN);
		btnAdd.setForeground(Color.BLACK);
		btnAdd.setBounds(135, 280, 105, 26);
		Add.add(btnAdd);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(300, 91, 308, 215);
		Add.add(scrollPane);

		txtrPrinttf = new JTextArea();
		txtrPrinttf.setEditable(false);
		scrollPane.setViewportView(txtrPrinttf);

		JLabel lblItemrupees = new JLabel("Item/rupees :");
		lblItemrupees.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblItemrupees.setBounds(10, 226, 104, 32);
		Add.add(lblItemrupees);

		itemtf = new JTextField();
		itemtf.setBounds(135, 229, 104, 20);
		Add.add(itemtf);
		itemtf.setColumns(10);
		companyTag();

	}

	public void companyTag() {
		txtrPrinttf.setText("======================================\n" + "Company name  : Anil Hosiery factory\n"
				+ "Contact number: 98XXXXXX23\n" + "Email-id : AnilHosiery@gmail.com\n"
				+ "======================================\n");
	}
}

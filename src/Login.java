
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtIpaddress;
	private JTextField txtPort;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setTitle("Login");
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 380);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtName = new JTextField();
		txtName.setBounds(85, 35, 130, 26);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(127, 15, 45, 16);
		contentPane.add(lblName);
		
		txtIpaddress = new JTextField();
		txtIpaddress.setBounds(85, 105, 130, 26);
		contentPane.add(txtIpaddress);
		txtIpaddress.setColumns(10);
		
		JLabel lblIpAddress = new JLabel("IP Address: ");
		lblIpAddress.setBounds(113, 85, 74, 16);
		contentPane.add(lblIpAddress);
		
		txtPort = new JTextField();
		txtPort.setBounds(85, 175, 130, 26);
		contentPane.add(txtPort);
		txtPort.setColumns(10);
		
		JLabel lblPort = new JLabel("Port:");
		lblPort.setBounds(133, 155, 34, 16);
		contentPane.add(lblPort);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name = txtName.getText();
				String address = txtIpaddress.getText();
				int port = Integer.parseInt(txtPort.getText());
				login(name, address, port);
				
			}

		});
		btnLogin.setBounds(113, 255, 74, 29);
		contentPane.add(btnLogin);
		
		JLabel lblIPAddressDesc = new JLabel("(eg. 192.168.0.32)");
		lblIPAddressDesc.setBounds(90, 127, 119, 16);
		contentPane.add(lblIPAddressDesc);
		
		JLabel lblPortDesc = new JLabel("(eg. 22)");
		lblPortDesc.setBounds(126, 200, 47, 16);
		contentPane.add(lblPortDesc);
		
		
	}
	private void login(String name, String address, int port) {
		// Login info. Close window and pass input
		dispose();
		
		new Client(name, address, port);
		
		System.out.println(name + "," + address + ":" + port);
		
	}
}

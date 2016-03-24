package Pragmatic.Project.BookStore.GUI;

import java.awt.Dialog;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import Pragmatic.Project.BookStore.Book;
import Pragmatic.Project.BookStore.Bookstore;

public class NewBookUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	// LABEL VARS
	private JLabel labelName = new JLabel("Title ");
	private JLabel labelAuthor = new JLabel("Author ");
	private JLabel labelPrice = new JLabel("Price ");
	private JLabel labelPublisher = new JLabel("Publisher ");
	private JLabel labelOrigin = new JLabel("Origin ");
	private JLabel labelStock = new JLabel("Stock Count ");
	// END OF LABEL VARS

	// FIELD VARS
	private JTextField titleField = new JTextField();
	private JTextField authorField = new JTextField();
	private JTextField priceField = new JTextField();
	private JTextField publisherField = new JTextField();
	private JTextField originField = new JTextField();
	private JTextField stockField = new JTextField();

	// END OF FIELD VARS

	// button
	private JButton addButton = new JButton("ADD");
	private JButton cancelButton = new JButton("CANCEL");

	// separator

	private final JSeparator separator_1 = new JSeparator();
	private final JSeparator separator_2 = new JSeparator();
	private final JSeparator separator_3 = new JSeparator();
	private final JSeparator separator_4 = new JSeparator();
	private final JSeparator separator_5 = new JSeparator();
	private final JSeparator separator_6 = new JSeparator();
	private final JSeparator separator_7 = new JSeparator();

	public NewBookUI() {
		createUI();
	}

	private void createUI() {
		setTitle("Main Menu");
		setSize(433, 415);
		setLayout(null);
		getContentPane().setBackground(SystemColor.textHighlight);
		// labels setting:
		labelName.setBounds(20, 20, 200, 30);
		labelName.setFont(labelName.getFont().deriveFont(20f));
		add(labelName);

		labelAuthor.setBounds(20, 20, 200, 140);
		labelAuthor.setFont(labelAuthor.getFont().deriveFont(20f));
		add(labelAuthor);
		labelPrice.setBounds(20, 20, 200, 240);
		labelPrice.setFont(labelPrice.getFont().deriveFont(20f));
		add(labelPrice);

		labelPublisher.setBounds(20, 20, 200, 340);
		labelPublisher.setFont(labelPublisher.getFont().deriveFont(20f));
		add(labelPublisher);

		labelOrigin.setBounds(20, 20, 200, 440);
		labelOrigin.setFont(labelOrigin.getFont().deriveFont(20f));
		add(labelOrigin);

		labelStock.setBounds(20, 20, 200, 540);
		labelStock.setFont(labelStock.getFont().deriveFont(20f));
		add(labelStock);

		// field setting:
		titleField.setBounds(100, 20, 150, 30);
		add(titleField);

		authorField.setBounds(100, 78, 150, 30);
		add(authorField);

		priceField.setBounds(100, 130, 150, 30);
		add(priceField);

		publisherField.setBounds(120, 178, 150, 30);
		add(publisherField);

		originField.setBounds(100, 230, 150, 30);
		add(originField);

		stockField.setBounds(150, 280, 150, 30);
		add(stockField);

		// buttons setting
		addButton.setBounds(62, 323, 100, 30);
		addButton.addActionListener(this);
		add(addButton);

		cancelButton.setBounds(180, 323, 100, 30);
		cancelButton.addActionListener(this);
		add(cancelButton);
		// separator

		JSeparator separator = new JSeparator();
		separator.setBounds(110, 63, 1, 2);
		add(separator);
		separator_1.setBounds(12, 63, 289, 2);

		add(separator_1);
		separator_2.setBounds(12, 118, 394, 2);

		add(separator_2);
		separator_3.setBounds(12, 173, 288, -8);

		add(separator_3);
		separator_4.setBounds(7, 178, 293, -8);

		add(separator_4);
		separator_5.setBounds(11, 168, 289, 2);

		add(separator_5);
		separator_6.setBounds(20, 221, 280, 2);

		add(separator_6);
		separator_7.setBounds(12, 273, 399, 2);

		add(separator_7);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == cancelButton) {
			dispose();
		} else if (source == addButton) {
			createBook();

		}
	}

	public void createBook() {

		try {
			int price = Integer.parseInt(priceField.getText());
			int stock = Integer.parseInt(stockField.getText());

			Book b = new Book(titleField.getText(), authorField.getText(), price, publisherField.getText(),
					originField.getText(), stock);
			dispose();
		} catch (NumberFormatException e) {

			JOptionPane.showMessageDialog(cancelButton, "Please check Stock Field and Price Field", "ERROR",
					JOptionPane.ERROR_MESSAGE);

		}
	}

}

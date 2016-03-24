package Pragmatic.Project.BookStore.GUI;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JPasswordField;

public class SwingTest extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JButton newBook = new JButton("New Book");
	private JButton sellBookButton = new JButton("Sell Book");
	private JButton listStock = new JButton("List Stock");
	private JButton search = new JButton("Search for a Book");
	ImageIcon bookButtonPic = new ImageIcon("img/book.png");
	ImageIcon sellButtonPic = new ImageIcon("img/sell.png");
	ImageIcon listButtonPic = new ImageIcon("img/list.png");
	ImageIcon searchButtonPic = new ImageIcon("img/search.png");
	
	public SwingTest() {
		createUI();
		
	}

	private void createUI() {
		// setting main frame
		setTitle("Main Menu");
		setSize(730, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		getContentPane().setBackground(SystemColor.textHighlight);
		// buttons setup
		newBook.setBounds(10, 10, 200, 100);
		newBook.setIcon(bookButtonPic);
		newBook.addActionListener(this);
		add(newBook);
		
		sellBookButton.setBounds(500, 10, 200, 100);
		sellBookButton.setIcon(sellButtonPic);
		sellBookButton.addActionListener(this);
		add(sellBookButton);
		
		listStock.setBounds(10, 200, 200, 100);
		listStock.setIcon(listButtonPic);
		listStock.addActionListener(this);
		add(listStock);
		
		search.setBounds(500, 200, 200, 100);
		search.setIcon(searchButtonPic);
		search.addActionListener(this);
		add(search);

	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == newBook){
			newBookUI();
		}else if (source == sellBookButton){
			sellBook();
		}else if (source == listStock){
			listBook();
		}else {
			search();
		}
	}
	
	public void newBookUI(){
		NewBookUI bookUI = new NewBookUI();
		bookUI.setVisible(true);
	}
	
	public void sellBook(){
		JOptionPane.showMessageDialog(null, "Book SOLD", "TEST", JOptionPane.INFORMATION_MESSAGE);

	}
	public void listBook(){
		JOptionPane.showMessageDialog(null, "ALL BOOKS", "TEST", JOptionPane.INFORMATION_MESSAGE);

	}
	public void search(){
	SearchUI searchUI = new SearchUI();
	searchUI.setVisible(true);
		
		
	}
}

	

	



package Pragmatic.Project.BookStore.GUI;

import java.awt.Color;
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
import java.awt.SystemColor;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.Scrollbar;
import javax.swing.JTable;

public class test extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JButton newBook = new JButton("New Book");
	private JButton sellBookButton = new JButton("Sell Book");
	private JButton listStock = new JButton("List Stock");
	private JButton search = new JButton("Search for a Book");
	ImageIcon bookButtonPic = new ImageIcon("img/book.png");
	ImageIcon sellButtonPic = new ImageIcon("img/sell.png");
	ImageIcon listButtonPic = new ImageIcon("img/list.png");
	ImageIcon searchButtonPic = new ImageIcon("img/search.png");
	private JTable table;
	
	public test() {
		createUI();
		
	}

	private void createUI() {
		// setting main frame
		setTitle("Main Menu");
		setSize(730, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setBackground(SystemColor.textHighlight);
		newBook.setBounds(12, 11, 200, 100);
		newBook.setIcon(bookButtonPic);
		newBook.addActionListener(this);
		getContentPane().setLayout(null);
		getContentPane().add(newBook);
		sellBookButton.setBounds(502, 11, 200, 100);
		sellBookButton.setIcon(sellButtonPic);
		sellBookButton.addActionListener(this);
		getContentPane().add(sellBookButton);
		listStock.setBounds(12, 201, 200, 100);
		listStock.setIcon(listButtonPic);
		listStock.addActionListener(this);
		getContentPane().add(listStock);
		search.setBounds(502, 201, 200, 100);
		search.setIcon(searchButtonPic);
		search.addActionListener(this);
		getContentPane().add(search);
		
		Scrollbar scrollbar = new Scrollbar();
		scrollbar.setBounds(435, 22, 27, 279);
		getContentPane().add(scrollbar);
		
		table = new JTable();
		table.setForeground(Color.WHITE);
		table.setBounds(435, 24, -223, 277);
		getContentPane().add(table);

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
		JOptionPane.showInputDialog(null, "Search", "TEST", JOptionPane.INFORMATION_MESSAGE);

	}
}

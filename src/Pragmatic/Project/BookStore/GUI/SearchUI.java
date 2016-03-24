package Pragmatic.Project.BookStore.GUI;

import javax.swing.JFrame;
import javax.swing.JTextField;

import Pragmatic.Project.BookStore.Bookstore;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchUI extends JFrame{


	private static final long serialVersionUID = 1L;
	
	
	private JTextField searchField = new JTextField();
	JButton searchButton = new JButton("Search!");
	
	public SearchUI() {
		createUI();
	}

	public void createUI() {
		
		setAlwaysOnTop(true);
		setBounds(100, 100, 394, 175);		
		getContentPane().setLayout(null);
		
		searchField.setBounds(12, 13, 360, 46);
		add(searchField);
		searchField.setColumns(10);
		String result = searchField.getText();
		
		searchButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				Bookstore b = new Bookstore();
				b.searchBook(result);
			}
		});
		searchButton.setBounds(12, 72, 352, 43);
		add(searchButton);
	}




}

package edu.pragmatic.dictionary.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import edu.pragmatic.dictionary.model.Dictionary;
import edu.pragmatic.dictionary.model.DictionaryTableModel;
import edu.pragmatic.dictionary.model.WordEntity;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class DictionaryUI extends JFrame {

	private JPanel contentPane;
	private JTextField searchTextField;
	private Dictionary dictionary;
	private JTable wordsTable;
	private DictionaryTableModel tableModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DictionaryUI frame = new DictionaryUI();
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
	public DictionaryUI() {
		dictionary = new Dictionary();

		setTitle("Dictionary");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		searchTextField = new JTextField();
		searchTextField.setBounds(6, 6, 309, 28);
		contentPane.add(searchTextField);
		searchTextField.setColumns(10);

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search();
			}
		});
		btnSearch.setBounds(327, 7, 117, 29);
		contentPane.add(btnSearch);

		JButton btnAdd = new JButton("Add word");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addWord();
			}
		});
		btnAdd.setBounds(327, 48, 117, 29);
		contentPane.add(btnAdd);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(16, 46, 299, 214);
		contentPane.add(scrollPane);

		wordsTable = new JTable();
		scrollPane.setViewportView(wordsTable);

		tableModel = new DictionaryTableModel();
		tableModel.setWords(dictionary.getSortedWordEntities());
		wordsTable.setModel(tableModel);
	}

	private void search() {
		String word = searchTextField.getText();
		if (word == null || word.length() == 0) {
			JOptionPane.showMessageDialog(this, "Empty search text", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			WordEntity wordEntity = dictionary.search(word);
			if (wordEntity == null) {
				JOptionPane.showMessageDialog(this, "No such word exists", "Info", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this, "Translation is: " + wordEntity.getTranslation(), "Info",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	private void addWord() {
		AddWordDialog dialog = new AddWordDialog();
		dialog.setModalityType(ModalityType.APPLICATION_MODAL);
		dialog.setVisible(true);

		WordEntity wordEntity = dialog.getWordEntity();
		if (wordEntity != null) {
			try {
				dictionary.addWordEntity(wordEntity);
				tableModel.setWords(dictionary.getSortedWordEntities());
			} catch (IOException e) {
				JOptionPane.showMessageDialog(this, "Unable to add word", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}

package edu.pragmatic.dictionary.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.pragmatic.dictionary.model.WordEntity;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddWordDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField wordTextField;
	private JTextField transcriptionTextField;
	private JTextField translationTextField;
	
	private WordEntity wordEntity;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddWordDialog dialog = new AddWordDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddWordDialog() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 450, 239);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			wordTextField = new JTextField();
			wordTextField.setBounds(63, 6, 134, 28);
			contentPanel.add(wordTextField);
			wordTextField.setColumns(10);
		}
		{
			translationTextField = new JTextField();
			translationTextField.setBounds(63, 56, 134, 28);
			contentPanel.add(translationTextField);
			translationTextField.setColumns(10);
		}
		{
			transcriptionTextField = new JTextField();
			transcriptionTextField.setBounds(63, 116, 134, 28);
			contentPanel.add(transcriptionTextField);
			transcriptionTextField.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 239, 450, 39);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						createWordEntity();
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public WordEntity getWordEntity() {
		return wordEntity;
	}
	
	private void createWordEntity() {
		wordEntity = new WordEntity(wordTextField.getText(), translationTextField.getText(), transcriptionTextField.getText());
	}
	
}

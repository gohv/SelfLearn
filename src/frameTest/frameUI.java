package frameTest;

import javax.swing.JFrame;
import java.awt.Scrollbar;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class frameUI extends JFrame {
	private JTable table;

	public static void main(String[] args) {
		frameUI ui = new frameUI();
		ui.setVisible(true);
	}

	public frameUI() {
createUI();
	}
	private void createUI(){
		getContentPane().setLayout(null);
		Scrollbar scrollbar = new Scrollbar();
		scrollbar.setBounds(248, 10, 21, 220);
		getContentPane().add(scrollbar);
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		table.setBounds(241, 25, -211, 184);
		getContentPane().add(table);
		
		JButton btnNewButton = new JButton("Remove");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(275, 13, 97, 25);
		getContentPane().add(btnNewButton);
	}
}

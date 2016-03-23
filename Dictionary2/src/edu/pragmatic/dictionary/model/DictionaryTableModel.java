package edu.pragmatic.dictionary.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class DictionaryTableModel extends AbstractTableModel {

	private List<WordEntity> words;
	
	@Override
	public int getRowCount() {
		return words.size();
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		WordEntity wordEntity = words.get(rowIndex);
		
		switch(columnIndex) {
		case 0: return wordEntity.getWord();
		case 1: return wordEntity.getTranslation();
		case 2: return wordEntity.getTranscription();
		}
		
		return null;
	}
	
	public void setWords(List<WordEntity> words) {
		this.words = words;
		
		fireTableDataChanged();
	}

}

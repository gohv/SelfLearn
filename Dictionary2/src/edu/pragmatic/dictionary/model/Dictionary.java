package edu.pragmatic.dictionary.model;

import java.io.IOException;
import java.util.*;

import edu.pragmatic.dictionary.utils.FileService;

public class Dictionary {

	private Map<String, WordEntity> words;
	
	public Dictionary() {
		words = new HashMap<>();
		
		try {
			Collection<WordEntity> wordEntities = FileService.load("words.txt");
			for(WordEntity wordEntity : wordEntities) {
				words.put(wordEntity.getWord(), wordEntity);
			}
		} catch (IOException e) {
			
		}
		
	}
	
	/**
	 * Add word entity to the dictionary
	 * @param entity to add
	 * @throws IOException 
	 */
	public void addWordEntity(WordEntity entity) throws IOException {
		words.put(entity.getWord(), entity);
		
		save();
	}
	
	/**
	 * Search for entity with the given word
	 * @param word to use for search
	 * @return Found entity or 'null' if no entity was found with the given word 
	 */
	public WordEntity search(String word) {	
		return words.get(word);
	}
	
	/**
	 * Delete the entity in the dictionary for the provided word
	 * @param word to use for deletion
	 * @return 'true' if the word was deleted and was in the dictionary,
	 *  'false' if the word was not in the dictionary at all
	 * @throws IOException 
	 */
	public boolean delete(String word) throws IOException {
		WordEntity wordEntity = words.remove(word);
		
		if(wordEntity != null) {
			save();
		}
		
		return (wordEntity != null);
	}
	
	/**
	 * 
	 * @return All sorted entities by 'word' 
	 */
	public List<WordEntity> getSortedWordEntities() {
		List<WordEntity> allWordEntities = new ArrayList<>(words.values());
		Collections.sort(allWordEntities, new Comparator<WordEntity>() {

			@Override
			public int compare(WordEntity o1, WordEntity o2) {
				String firstWord = o1.getWord();
				String secondWord = o2.getWord();
				
				return firstWord.compareTo(secondWord);
			}
			
		});
		
		return allWordEntities;
	}
	
	private void save() throws IOException {
		FileService.save(words.values(), "words.txt");
	}
}

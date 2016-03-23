package edu.pragmatic.dictionary.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import edu.pragmatic.dictionary.model.Dictionary;
import edu.pragmatic.dictionary.model.WordEntity;

public class UserInputController {

	private Scanner scanner;
	private Dictionary dictionary;
	
	enum MenuOption {
		ADD,
		SEARCH,
		DELETE,
		SHOW_ALL_SORTED,
		EXIT,
		INVALID
	}
	
	public UserInputController() {
		scanner = new Scanner(System.in);
	
		dictionary = new Dictionary();
	}
	
	public void start() {
		
		boolean shouldExit = false;
		do {
			MenuOption selectedOption = showMenu();
			switch(selectedOption) {
			case ADD:
				addWord();
				break;
			case SEARCH:
				search();
				break;
			case DELETE:
				delete();
				break;
			case SHOW_ALL_SORTED:
				showAllSorted();
				break;
			case EXIT:
				shouldExit = true;
				break;
			case INVALID:
				System.out.println("Option is not valid!!!");
				break;
			}
		} while(shouldExit == false);
		
		System.out.println("Bye!!!");
	}
	
	private MenuOption showMenu() {
		System.out.println("--- MENU ---");
		System.out.println("1. Enter new word");
		System.out.println("2. Search for translation");
		System.out.println("3. Delete word");
		System.out.println("4. Show all words sorted");
		System.out.println("5. Exit");
		System.out.println();
		System.out.print("Your choice: ");
		
		int choice = scanner.nextInt();
		scanner.nextLine();
		switch(choice) {
		case 1: return MenuOption.ADD;
		case 2: return MenuOption.SEARCH;
		case 3: return MenuOption.DELETE;
		case 4: return MenuOption.SHOW_ALL_SORTED;
		case 5: return MenuOption.EXIT;
		default: return MenuOption.INVALID;
		}
	}
	
	private void addWord() {
		System.out.print("Enter <word> = <translation> = <transcription>: ");
		String result = scanner.nextLine();
		String[] tokens = result.split("=");
		if(tokens.length == 3) {
			String word = tokens[0].trim();
			String translation = tokens[1].trim();
			String transcription = tokens[2].trim();
			
			WordEntity entity = new WordEntity(word, translation, transcription);
			try {
				dictionary.addWordEntity(entity);
			} catch (IOException e) {
				System.out.println("Unable to add word. Please try again");
			}
		}
	}
	
	private void search() {
		System.out.println("Enter a word: ");
		String word = scanner.nextLine();
		WordEntity wordEntity = dictionary.search(word);
		if(wordEntity != null) {
			System.out.println("Translation is: " + wordEntity.getTranslation());
			System.out.println("Transcription is: " + wordEntity.getTranscription());			
		} else {
			System.out.println("No such word exists");
		}
	}
	
	private void delete() {
		System.out.println("Enter a word to delete: ");
		String word = scanner.nextLine();
		
		try {
			boolean result = dictionary.delete(word);
			
			if(result) {
				System.out.println("Word was deleted");
			} else {
				System.out.println("The provided word was not part of the dictionary");
			}
		} catch (IOException e) {
			System.out.println("Unable to delete word. Please try again.");
		}
	}
	
	private void showAllSorted() {
		List<WordEntity> wordEntities = dictionary.getSortedWordEntities();
		
		System.out.println("This dictionary has the following words: ");
		
		for(WordEntity wordEntity : wordEntities) {
			System.out.println(wordEntity.getWord() + " - " + wordEntity.getTranslation());
		}
	}
}

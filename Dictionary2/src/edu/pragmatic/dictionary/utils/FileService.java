package edu.pragmatic.dictionary.utils;

import java.io.*;
import java.util.*;
import edu.pragmatic.dictionary.model.WordEntity;

public class FileService {

	private static final String SEPARATOR = "=";
	
	public static boolean save(Collection<WordEntity> wordEntities, String fileName) throws IOException {
		
		if(wordEntities == null || fileName == null) {
			return false;
		}
		
		try(FileWriter writer = new FileWriter(fileName);
			BufferedWriter bufferedWriter = new BufferedWriter(writer); 
			PrintWriter printWriter = new PrintWriter(bufferedWriter)) {
			
			for(WordEntity wordEntity : wordEntities) {
				StringBuilder builder = new StringBuilder();
				builder.append(wordEntity.getWord());
				builder.append(SEPARATOR);
				builder.append(wordEntity.getTranslation());
				builder.append(SEPARATOR);
				builder.append(wordEntity.getTranscription());
				
				printWriter.println(builder.toString());
			}		
		}
		
		return true;
	}
	
	public static Collection<WordEntity> load(String fileName) throws IOException {
		
		if(fileName == null) {
			return Collections.emptyList(); 
		}
		
		Collection<WordEntity> wordEntities = new ArrayList<>();
		try(FileInputStream inputStream = new FileInputStream(fileName);
			BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
			Scanner sc = new Scanner(bufferedInputStream)) {
			
			while(sc.hasNextLine()) {
				String line = sc.nextLine();
				String[] tokens = line.split(SEPARATOR);
				if(tokens.length == 3) {
					WordEntity wordEntity = new WordEntity(tokens[0], tokens[1], tokens[2]);
					wordEntities.add(wordEntity);
				}
			}
			
		}
		
		return wordEntities;
	}
}

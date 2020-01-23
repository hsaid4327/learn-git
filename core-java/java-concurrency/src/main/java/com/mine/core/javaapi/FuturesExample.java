package com.mine.core.javaapi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * This class presents an example of using concurrency Futures object. Based on
 * the user input of starting directory and the word to count, it returns a map
 * containing the file name and the number of times the word occurs in that
 * file. Each directory is handled in a seperate thread returning a Futures
 * object.
 * 
 * @author hsaid-contractor
 *
 */

public class FuturesExample {

	public static void main(String[] args) {
		System.out.println("Print the directory and word to find seperated by space");
		Scanner scanner = new Scanner(System.in);
		String text = scanner.nextLine();
		String[] tokens = text.split(" ");
		String fileName = tokens[0];
		String wordToFind = tokens[1];
		ExecutorService service = Executors.newCachedThreadPool();
		
		
		scanner.close();
		File file = new File(fileName);
		List<Future<Map<String, Integer>>> futures = new ArrayList<Future<Map<String, Integer>>>();
		if(!file.isDirectory()){
			System.out.println("You must provide valid directory and word to find");
			System.exit(0);
		}
		File[] fileList = file.listFiles();
		for(File f: fileList){
			
			futures.add(service.submit(new WordFinder(f, wordToFind)));
		}
		
		
		List<Map<String, Integer>> map = new ArrayList<Map<String, Integer>>();
		for(Future<Map<String, Integer>> f: futures){
			try {
				map.add(f.get());
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.printf("%s\t\t\t\t\t%s%n", "File Name", "Number of Word occourences");
		System.out.printf("%s\t\t\t\t\t%s%n", "---------", "-------------");
		for(Map<String, Integer> result: map){
			printMap(result);
		}

	}
    public static void printMap(Map<String, Integer> map){
    	Set<Entry<String, Integer>> values = map.entrySet();
    	
    	for(Entry<String, Integer> entry: values){
    		System.out.printf("%s\t\t\t\t\t%s%n", entry.getKey(), entry.getValue());
    	}
    }  
	
	public static class WordFinder implements Callable<Map<String, Integer>> {

		private final File file;
		private final String wordToFind;

		public WordFinder(File f, String wordToFind) {

			this.file = f;
			this.wordToFind = wordToFind;
		}

		@Override
		public Map<String, Integer> call() throws Exception {
			Map<String, Integer> wordMap = new HashMap<String, Integer>();
			
			 processFile(file, wordMap);
			return wordMap;
		}

		public Map<String, Integer> processFile(File file, Map<String, Integer> wordMap) {
			
			
			if(file.exists() && file.isDirectory()){
				File[] fileList = file.listFiles();
				for (File f : fileList) {
					processFile(f, wordMap);
				}
			}
			else{
				processSingleFile(file, wordMap);
			}
			return wordMap;
		}
		
		
		public void processSingleFile(File singleFile, Map<String, Integer> wordMap) {
			System.out.printf("Proccesing the single file: %s%n", singleFile.getName());
			int wordCount = 0;
			Scanner scanner = null;
			try {
				scanner = new Scanner(singleFile);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			while (scanner.hasNextLine()) {
				String text = scanner.nextLine();
				if (text.contains(wordToFind)) {
					wordCount += 1;
				}

			}
			scanner.close();
			if (wordCount > 0)
				//try {
					wordMap.put(singleFile.getName(), wordCount);
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}

		}
	}

}

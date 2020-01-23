package com.mine.core.javaapi;

import java.io.File;

public class MultiThreadedFileReader {

	
	public static void main(String[] args) {
		String directoryName = args[0];
		String fileTypeToFind = args[1];
		if (args.length > 1) {
			fileTypeToFind = args[1];
		}
		File file = new File(directoryName);

		if (file.isDirectory()) {

			File[] listOfFiles = file.listFiles();
			for (File f : listOfFiles) {
				if (f.isDirectory()) {
					Thread t = new Thread(new FileFinderRunnable(f,
							fileTypeToFind));
					t.start();
				} else {
					if (f.getName().endsWith(fileTypeToFind)) {
						System.out.println(f.getName());
					}
				}
			}

		} else {
			System.out.println("You must provide a directory for this search");
		}
	}
}

class FileFinderRunnable implements Runnable {

	private final File directoryToSearch;
	private final String filTypeToFind;

	public FileFinderRunnable(File directoryToSearch, String fileType) {
		super();
		this.directoryToSearch = directoryToSearch;
		this.filTypeToFind = fileType;
	
	}

	@Override
	public void run() {
		findFile(directoryToSearch, filTypeToFind);

	}

	private void findFile(File file, String fileTypeToFind) {
		File[] listOfFiles = file.listFiles();
		if(listOfFiles == null){
			System.out.println("This is a null directory:"+file.getAbsolutePath()+file.getName());
			return;
		}
		try {
			for (File f : listOfFiles) {
				if (f.isDirectory()) {
					findFile(f, fileTypeToFind);
				} else {
					if (f.getName().endsWith(filTypeToFind)) {
						System.out.println(f.getName());
					}
				}

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

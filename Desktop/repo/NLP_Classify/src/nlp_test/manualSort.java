package nlp_test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class manualSort {
	
	// These are all your types
	private String[] types = {
			"SECURITY",
			"NETTING",
			"EMPLOYMENT",
			"ELECTION",
			"ELECTION",
			"SALE",
			"SERVICE",
			"SUPPLY",
			"LENDING",
			"CONFIDENTIALITY",
			"TRANSACTION",
			"TRANSPORTATION",
			"SETTLEMENT",
			"AMENDMENT",
			"TRUST",
			"MARGIN",
			"FEE",
			"LINKING",
			"OPERATING",
			"PURCHASE",
			"MASTER",
			"TRADING"
		};
	
	// This is the directory name
	private String dirName = "/Users/nuraymuzaffarova/Desktop/Packaged/Agreements/TXT";
		
	// This is a map of type to list of filenames
	private Map<String, List<String>> sources;	
	
	// Constructor
	public manualSort(){
		this.sources = new HashMap<String, List<String>>();
	}
	
	// Get filenames. Return map
	public Map<String, List<String>> getFilenames(){
		return sources;
	}
	
	// Fet filenames for certain type. Return list
	public List<String> getFilenames(String type){
		return sources.getOrDefault(type, new ArrayList<String>());
	}	
	
	// Sort filenames into respective types
	public void sort() throws IOException{
		File dir = new File(dirName);
		File[] files = dir.listFiles();
		if(files == null){
			System.err.println("Error: " + dirName + " is not a directory!");
			return;
		}
		for(File file : files){
			String lines = getLines(file);
			for(String type : types){
				if(lines.contains(type)){
					List<String> filenames = getFilenames(type);
					// Note: It uses file path, not file name
					// You might as well, as it saves duplicate code
					// having to write the directory twice
					filenames.add(file.getAbsolutePath());
					sources.put(type, filenames);
				}
			}
		}
	}
	
	// Gets the beginning of each file
	private String getLines(File file) throws IOException{
		
		BufferedReader bf = new BufferedReader(new FileReader(file));
		String lines = "";
		for(int counter = 0; counter < 4; counter++){
			lines += bf.readLine();
		}
		bf.close();
		return lines;
	}
	
	// Simple print function for testing
	public void print(){
		int size = 0;
		for(String type : types){
			List<String> files = getFilenames(type);
			System.out.println("Type: " + type);
			System.out.println("Files: \n" + files);
			size += files.size();
		}
		System.out.println("Total Size: " + size);
	}
	

}


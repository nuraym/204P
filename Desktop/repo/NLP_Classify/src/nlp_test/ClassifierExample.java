package nlp_test;

import edu.stanford.nlp.classify.LinearClassifier;
import edu.stanford.nlp.classify.LinearClassifierFactory;
import edu.stanford.nlp.ling.BasicDatum;
import edu.stanford.nlp.ling.Datum;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Sample code that illustrates the training and use of a linear classifier.
 * This toy example is taken from the slides:
 * Christopher Manning and Dan Klein. 2003. Optimization, Maxent Models,
 * and Conditional Estimation without Magic.
 * Tutorial at HLT-NAACL 2003 and ACL 2003.
 *
 * @author Dan Klein
 */
public class ClassifierExample {
	
	/**
	 * Function for creating a Datum for training
	 * String type - the type of your agreement e.g. LEGAL, NATURAL_GAS, etc.
	 * String filename - the name of the file of your training sample
	 * @throws IOException
	  */
	public static Datum<String, String> createTrainingDatum(String type, String filename) throws IOException{
		List<String> list = new ArrayList<>();
		System.out.println("Create training data");
		for(String s : new String(Files.readAllBytes(Paths.get(filename))).split(" ")){
			list.add(s);
		}
		System.out.println("Done list");
		return new BasicDatum<>(list, type);
	}

	/**
	 * Function for creating a Datum for testing
	 * String filename - the name of the file of your testing sample
	 * @param filename
	 * @return
	 * @throws IOException
	 */
    public static Datum<String, String> createTestingDatum(String filename) throws IOException{
    	List<String> list = new ArrayList<>();
    	System.out.println("Create testing data");
    	for(String s : new String(Files.readAllBytes(Paths.get(filename))).split(" ")){
    		list.add(s);
    	}
    	System.out.println("Done list");
    	return new BasicDatum<>(list);
    }

    // Probably don't need this function
    /**
     * Transforms a given String such that each substring has only its first letter capitalised <br>
     * E.g. <br>
     * 	<p><blockquote><pre>
     *  sale -> Sale <br>
     *  security issue 				
     *       -> Security Issue <br>
     *  tHis IS tHE General c a s e 
     *       -> This Is The General C A S E <br>
     *	</pre></blockquote><p>
     * @param string
     * @return
     */
    public static String toGeneralCase(String string){
    	String retStr = "";
    	for(String s : string.split(" ")){
    		if(s.length() < 1) continue;
    		retStr += s.substring(0, 1).toUpperCase() + s.substring(1, s.length()).toLowerCase() + " ";
    	}
    	return retStr.trim();
    }

    public static void main(String[] args) throws IOException {
    	System.out.println("Starting");
   	 	Set<Datum<String,String>> trainingData = new HashSet<>();
   	 	manualSort manualSort = new manualSort();
   	 	System.out.println("Creating object");   	 	
   	 	// This is where we sort
   	 	manualSort.sort();
   	 	System.out.println("Sorted");
   	 	//manualSort.print();a
   	 	// Iterate through each type
   	 	for(String type : manualSort.getFilenames().keySet()){
   	 		// For each type, iterate through its filenames
   	 		for(String filepath : manualSort.getFilenames(type)){
   	 			// Note this is file path, so don't have to include directory (see ManualSort)
   	 			trainingData.add(createTrainingDatum(type, filepath));
   	 			//break;
   	 		}
   	 	}	 
   	 	System.out.println("Finished going through classes");
   	 	// Build a classifier factory
   	 	LinearClassifierFactory<String,String> factory = new LinearClassifierFactory<>();
   	 	System.out.println("Factory");
   	 	LinearClassifier<String,String> classifier = factory.trainClassifier(trainingData);
   	 	System.out.println("Classifier");
   	 	//classifier.dump();
   	 	Datum<String, String> testDatum = 
   	 	createTestingDatum("/Users/nuraymuzaffarova/Desktop/Packaged/Agreements/TXT/3.58887.F1QTAYTZTS3SJB420ETPDM00PI0NUDMSB.1.txt");
   	 	System.out.println("Working instance got: " + classifier.classOf(testDatum));
   	 	System.out.println(classifier.probabilityOf(testDatum) + "/n");
   
   	 	Bag_words bag = new Bag_words();
   	 	bag.main(args);
    
    }		 
}



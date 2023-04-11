package card.game;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FileIO {
	
	 private static void saveDataToFile(String fileName, ArrayList<Player> userData) throws IOException{
		 FileWriter writer = new FileWriter(fileName);
		 
		 for(Player playerData: userData){
			 writer.append(playerData.toString());
		 }
		 writer.flush();
	 }
	 
	 private static ArrayList<Player> readDataFromFile(String fileName) throws IOException{
		 ArrayList<Player> playersData = new ArrayList<Player>();
		 String input = null;
		 Player player = null;
		 ArrayList<String> lineInput = null;
		 Scanner scanner = new Scanner(new File(fileName));
		 
		 while (scanner.hasNextLine()) {
	         input = scanner.nextLine();
	         if(input!=null)
	         {
	        	 lineInput= new ArrayList<>(Arrays.asList(input.split(",")));
	        	 player = new Player(lineInput.get(0), Integer.valueOf(lineInput.get(1)));
	        	 playersData.add(player);
	         }
	      }
		 return playersData;
	 }

}

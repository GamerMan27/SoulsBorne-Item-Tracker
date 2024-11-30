package mainTracker;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.Scanner;

public class ItemTracker {

	//Files.pathSeparator was giving me issues, so I made my own to be used with strings
	private static String pathSeparator = "//";
	
	//File directory. Gets the value of the file path
	private static String fileDir = initWindowsFilePath();
	
	//Scanner variable for the console. Debug use only
	public static Scanner kb = new Scanner(System.in);
		
	public static void main(String[] args) {
		
		int choice = -1;
		int closeApp = 0;
		
		Properties props = new Properties();
		try (InputStream input =  ItemTracker.class.getClassLoader().getResourceAsStream("string.properties")) {
			if (input == null) {
				System.out.println("string.properties not found");
				return;
			}
			props.load(input);
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		
		do {
			Menu();
			choice = kb.nextInt();
			kb.nextLine();
			
			switch (choice) {
			case 0:
				closeApp = 1;
				break;
			case 1:
				
				break;
			case 2:
				
				break;
			case 3:
	
				break;
			case 4:
	
				break;	
			case 5:
	
				break;	
			case 6:
				
				break;	
			case 7:
				
				break;	

			default:
				System.out.print(props.getProperty("misinputnum"));
				choice = -1;
			}
			
		} while (closeApp > 1);
	}
	
	
	//Method to display the console menu. Is modifiable and can be switched for GUI later. Mostly for testing purposes for now
	public static void Menu() {
		System.out.println("0. Close Application");
		System.out.println("1. Demon Souls");
		System.out.println("2. Dark Souls 1");
		System.out.println("3. Dark Souls 2");
		System.out.println("4. Bloodborne");
		System.out.println("5. Dark Souls 3");
		System.out.println("6. Sekiro: Shadows Die Twice");
		System.out.println("7. Elden Ring");

	}
	
	public static void bloodBorne(Scanner kb) {
		
	}
	
	//Method to find the absolute path and return it. Currently only works on MoneyMiser.java, does not work when turned into an .exe file
	public static String initWindowsFilePath() {

		//File declarations
		Path file;

		//Boolean used for validating file access and path repair
		boolean foundDir = false;

		//Temporary variables used for rebuilding the file path.
		String temp1;
		String tempPathArr[];
		StringBuilder tempPath;

		try {
			file = Paths.get("ItemTracker.java");
			file = file.toAbsolutePath();
			temp1 = file.toString();
			tempPathArr = temp1.split("ItemTracker.java", 0);

			tempPath = new StringBuilder(tempPathArr[0]);
			for(int i = 0; i < tempPath.length(); i++) {
				if (tempPath.charAt(i) == '\\' && !foundDir) {
					tempPath.insert(i, "\\");
					foundDir = true;
				}
				else
					foundDir = false;
			}
			foundDir = true;


			return tempPath + "MoneyMiserDATABASE";
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;

		}

	}

}

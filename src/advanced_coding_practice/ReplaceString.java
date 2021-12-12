package advanced_coding_practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReplaceString {

	static void modifyFile(String path, String str1, String str2) {
		File file = new File(path); // Create a File object by passing the path of the file to be modified.

		String a = ""; // Initialize a with an empty string. This String object will hold all the old
						// content of the input text file.

		BufferedReader reader = null;

		FileWriter writer = null;

		try {
			reader = new BufferedReader(new FileReader(file)); // Create BufferedReader object to read the input text
																// file line by line.

			// Reading all the lines of input text file one by one and append it into a

			String line = reader.readLine();

			while (line != null) {
				a = a + line + System.lineSeparator();

				line = reader.readLine();
			}

			// Replacing all the occurrences of str1 with str2. You will get a b.

			String b = a.replaceAll(str1, str2);

			// Rewriting the input text file with b

			writer = new FileWriter(file);

			writer.write(b);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// Closing the resources

				reader.close();

				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		modifyFile("E:\\Eclipse_Workspace\\SeleniumWDTutorialUdemy\\StudentFile.txt", "95", "85");

		System.out.println("done");
	}

}

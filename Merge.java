import java.io.*;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.*;
public class Merge {
	public static void main(String[] args) throws FileNotFoundException {
		int item1 = 0, item2 = 0;
		String fileName1, fileName2, outFileName;
		File dataFile1, dataFile2, outFile;
		boolean hasNext1 = false, hasNext2 = false;
		JFrame myframe = new JFrame(); // the line that creates trouble
		//repaint();
		Scanner keyScanner = new Scanner(System.in);
		System.out.println("Please enter the first file name: ");
		fileName1 = keyScanner.nextLine();
		System.out.println("Please enter the second file name: ");
		fileName2 = keyScanner.nextLine();
		System.out.println("Please enter the output file name: ");
		outFileName = keyScanner.nextLine();		
		dataFile1 = new File(fileName1);
		dataFile2 = new File(fileName2);
		outFile = new File(outFileName);
		Scanner fileScanner1 = new Scanner(dataFile1);
		Scanner fileScanner2 = new Scanner(dataFile2);
		PrintWriter printer = new PrintWriter(outFile);
		if (fileScanner1.hasNext()) {
			hasNext1 = true; 
			item1 = fileScanner1.nextInt();
		} 
		if (fileScanner2.hasNext()) {
			hasNext2 = true; 
			item2 = fileScanner2.nextInt();
		}
		while (hasNext1 && hasNext2) {
			if (item1 < item2) {
				printer.print(item1);
				printer.print(' ');
				if (fileScanner1.hasNext()) {
					item1 = fileScanner1.nextInt();
				} else {
					hasNext1 = false;
				}
			} else {
				printer.print(item2);
				printer.print(' ');
				if (fileScanner2.hasNext()) {
					item2 = fileScanner2.nextInt();
				} else {
					hasNext2 = false;
				}
			}
		}
		while (hasNext1) {
			printer.print(item1);
			printer.print(' ');
			if (fileScanner1.hasNext()) {
				item1 = fileScanner1.nextInt();
			} else {
				hasNext1 = false;
			}
		}
		while (hasNext2) {
			printer.print(item2);
			printer.print(' ');
			if (fileScanner2.hasNext()) {
				item2 = fileScanner2.nextInt();
			} else {
				hasNext2 = false;
			}
		}
		printer.close();
		fileScanner1.close();
		fileScanner2.close();
		keyScanner.close();
		
	}
}

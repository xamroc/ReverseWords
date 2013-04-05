import java.io.*;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Main m = new Main();
		FileReader x = m.openFile(args[0]);
		BufferedReader y = new BufferedReader(x);

		String line;
		try {
			while((line = y.readLine()) != null){
				processLine(line);
			}
		} catch (IOException e) {
			System.out.println("Error reading line");
			e.printStackTrace();
		}
		m.closeFile(x);
	}
	
	private static void processLine(String line) {
		String[] words = line.split(" ");
		int wLen = words.length;
		int wLenHalf = wLen/2;
		//if(wLen%2 == 0){
			for(int i = 0; i < wLenHalf; i++){
				String temp = words[i];
				words[i] = words[wLen-i-1];
				words[wLen-i-1] = temp;
			}
		//}
			for(int i = 0; i < wLen; i++){
				System.out.print(words[i] + " ");
			}
			System.out.println();
	}

	private FileReader openFile(String file) {
		FileReader x = null;
		try {
			x = new FileReader(new File(file));
		} catch (FileNotFoundException e) {
			System.out.println("Error reading file.");
			e.printStackTrace();
		}
		return x;
	}

	private void closeFile(FileReader x) {
		try {
			x.close();
		} catch (IOException e) {
			System.out.println("Error closing file.");
			e.printStackTrace();
		}
	}

}

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*Written as challenge for Project Euler (#022)
 * This programme reads in a list of uppercase names (or words in general), which are assumed to be divided
 * by a comma and each name surrounded by quotation marks.
 * The program stores all of the names in an arrayList and then calculates the "score" of that name, 
 * where the "score" depends on the position of each letter of the word in the alphabet, and the words
 * position alphabetically in the array
 * score=position*(sum of value of letters)
 * The program then prints the sum of the scores of all the names on the list*/
public class PE022NameScores{
	
	/*Calculates the score of each word. The integer value of each letter will be the difference between 
	 * 'A' and the letter itself (assuming the letter is uppercase), as the letters are arranged in alphabetical
	 * order.
	 * '1' is added to each letter because the value of letter 'A' would be treated as 0 otherwise
	 * (and hence all subsequent letters would be off by 1)*/
	public static int wordScore(String word){
		int score=0;
		for(int i=0;i<word.length();i++){
			score+=(int)word.charAt(i)-(int)'A'+1; //assumes all the letters are uppercase, can be modified easily to treat all cases;
		}
		return score;
	}
	
	public static void main (String args[]) throws IOException{
		String fileName="names.txt",word; // the name of the file being read, must be in project folder
		ArrayList <String>wordList=new ArrayList <String>();
		BufferedReader file=new BufferedReader(new FileReader(fileName)); //BufferedReader to read characters and strings
		file.read(); //the first character is a ", so we have to skip past that for the rest of the program to work
		char c;
		int a=0;
		long total=0;
		while((a=file.read())!=-1){//"read()" returns -1 if there is nothing left to read
			word=""+(char)a;// to account for the letter that will be read in progressing the loop
			while((c=(char) file.read())!='\"'){//will continue reading in letters until it reaches the quotation mark at the end of the name
				word+=c;
			}
			file.skip(2); //skipping the ",\"" between names
			wordList.add(word);
		}
		java.util.Collections.sort(wordList); //sorts the elements in alphabetical order
		for(int i=0;i<wordList.size();i++){
			total+=(i+1)*wordScore(wordList.get(i));
		}
		System.out.println("The total score of all these numbers is "+total);
	}
}
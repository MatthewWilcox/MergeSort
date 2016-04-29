import java.util.Random;


public class Driver 
{
	public static void main(String[] args)
	{
		int[] ar = {7,8,1,3,4,2};
		Driver.printIntArray(ar);
		Driver.mergeSort(ar);
		Driver.printIntArray(ar);
	}
	
	
	//Homework
	static void mergeSort(int[] ar)
	{
		Driver.mergeSortHelper(ar, 0, ar.length-1);
	}
	
	static void mergeSortHelper(int[] ar, int begin, int end)
	{
		Driver.display(ar, begin, end);
		if(begin != end)
		{
			int leftBegin = begin;
			int leftEnd = ((end-begin)/2 + begin);
			int rightBegin = ((end-begin)/2 +begin)+1;
			int rightEnd = end;
			Driver.mergeSortHelper(ar, leftBegin, leftEnd);
			Driver.mergeSortHelper(ar, rightBegin, rightEnd); 
			//call mergesort on left
			//call mergesort on right
			//do merge step 
			int[] newArray = new int [ar.length];
		}
	}
	static void display(int[] ar, int begin, int end)
	{
		for(int i = begin; i <= end ; i++)
		{
			System.out.print(ar[i] + " ");
		}
		System.out.println("");
	}
	static void bubbleSort(int[] ar)
	{
		int temp;
		int follower;
		int currStart = 1;
		
		while(currStart < ar.length)
		{
			follower = currStart;
			while(follower != 0 && ar[follower] < ar[follower-1])
			{
				temp = ar[follower];
				ar[follower] = ar[follower - 1];
				ar[follower-1] = temp;
				follower--;
			}
			currStart++;
		}
	}
	
	static void ghettoSort(int[] ar)
	{
		int[] answer = new int[ar.length];
		int[] arCopy = new int[ar.length];
		Driver.copyArray(ar, arCopy);
		int posOfSmallest;
		int currPos = 0;
		while(arCopy.length > 0)
		{
			posOfSmallest = Driver.positionOfSmallest(arCopy);
			answer[currPos] = arCopy[posOfSmallest];
			currPos++;
			arCopy = Driver.removeAtPos(posOfSmallest, arCopy);
		}
		Driver.copyArray(answer, ar);
	}
	
	static void copyArray(int[] source, int[] destination)
	{
		for(int i = 0; i < source.length; i++)
		{
			destination[i] = source[i];
		}
	}
	
	static int[] removeAtPos(int pos, int[] ar)
	{
		int[] answer = new int[ar.length - 1];
		int currPos = 0;
		for(int i = 0; i < pos; i++)
		{
			answer[currPos] = ar[i];
			currPos++;
		}
		for(int i = pos+1; i < ar.length; i++)
		{
			answer[currPos] = ar[i];
			currPos++;
		}
		return answer;
	}
	
	static int positionOfSmallest(int[] ar)
	{
		int winnerPos = 0;
		for(int i = 1; i < ar.length; i++)
		{
			if(ar[i] < ar[winnerPos])
			{
				winnerPos = i;
			}
		}
		return winnerPos;
	}
	
	static void fillArrayWithRandomInts(int[] ar)
	{
		Random r = new Random();
		for(int i = 0; i < ar.length; i++)
		{
			ar[i] = r.nextInt(101);
		}
	}
	
	static void printIntArray(int[] ar)
	{
		for(int i = 0; i < ar.length; i++)
		{
			System.out.print(ar[i] + " ");
		}
		System.out.println();
	}
	
	static String charArrayToString(char[] ar)
	{
		String answer = "";
		for(int i = 0; i < ar.length; i++)
		{
			answer += ar[i];
		}
		return answer;
	}
	
	static char[] stringToCharArray(String s)
	{
		char[] ar = new char[s.length()];
		for(int i = 0; i < s.length(); i++)
		{
			ar[i] = s.charAt(i);
		}
		return ar;
	}
	
	static String substring(String s, int beginPos, int endPos)
	{
		String answer = "";
		for(int i = beginPos; i < endPos; i++)
		{
			answer += s.charAt(i);
		}
		return answer;
	}
	
	static String substring(String s, int pos)
	{
		String answer = "";
		for(int i = pos; i < s.length(); i++)
		{
			answer += s.charAt(i);
			//answer = answer + s.charAt(i)
		}
		return answer;
	}
	
	static char int2Char(int num)
	{
		String map = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		return map.charAt(num);
	}
	
	static String decimalToBase(int dec, int radix)
	{
		String answer = "";
		while(dec != 0)
		{
			answer =  Driver.int2Char(dec % radix) + answer;
			dec /= radix;
		}
		return answer;
	}
	
	static String reverse(String s)
	{
		String answer = "";
		for(int i = s.length()-1; i >= 0; i--)
		{
			answer += s.charAt(i);
		}
		return answer;
	}
	
	static int baseToInteger(String s, int radix)
	{
		int place = 1;
		int total = 0;
		char currChar;
		
		for(int i = s.length()-1; i >= 0; i--)
		{
			currChar = s.charAt(i);
			total += (Driver.charToInt(currChar) * place);
			place *= radix;
		}
		return total;
	}
	
	static int hexToInteger(String hex)
	{
		int place = 1;
		int total = 0;
		char currChar;
		
		for(int i = hex.length()-1; i >= 0; i--)
		{
			currChar = hex.charAt(i);
			total += (Driver.charToInt(currChar) * place);
			place *= 16;
		}
		return total;
	}
	
	static int octalToInteger(String oct)
	{
		int place = 1;
		int total = 0;
		char currChar;
		
		for(int i = oct.length()-1; i >= 0; i--)
		{
			currChar = oct.charAt(i);
			total += (Driver.charToInt(currChar) * place);
			place *= 8;
		}
		return total;
	}
	
	//this guy should take a String representation of a binary number
	//as a parameter and return as a int the decimal equivalent
	//"1011" -> 11
	static int binaryToInteger(String bin)
	{
		int place = 1;
		int total = 0;
		char currChar;
		for(int i = bin.length()-1; i >= 0; i--)
		{
			currChar = bin.charAt(i);
			if(currChar == '1')
			{
				total += place;
			}
			place *= 2;
		}
		return total;
	}
	
	//return the integer version of the char parameter
	static int charToInt(char c)
	{
		return "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(c);
	}
	
	//Converts s, which is a string representation
	//of an int into an int representation
	//"124" -> 124
	static int stringToInt(String s)
	{
		int place = 1;
		int total = 0;
		char currChar;
		for(int i = s.length()-1; i >= 0; i--)
		{
			currChar = s.charAt(i);
			if(currChar == '-')
			{
				return total * -1;
			}
			else
			{
				total += (Driver.charToInt(currChar) * place);
				place *= 10;
			}
		}
		return total;
	}
	
	static String removeChars(String s, String charsToRemove)
	{
		String answer = "";
		for(int i = 0; i < s.length(); i++)
		{
			//should we keep the current character
			if(charsToRemove.indexOf(s.charAt(i)) == -1)
			{
				answer = answer + s.charAt(i);
			}
		}
		return answer;
	}
	
	//returns a new String with all of the vowels
	//removed form the parameter String
	//"hello" -> hll
	static String removeVowels(String s)
	{
		return Driver.removeChars(s, "aeiouAEIOU");
	}
	
	//returns a new String with all of the consonants
	//removed form the parameter String
	//"hello" -> eo
	static String removeConsonants(String s)
	{
		return Driver.removeChars(s, "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ");
	}
		
	//returns a new String with all of the numbers
	//removed form the parameter String
	//"he11o" -> heo
	static String removeDigits(String s)
	{
		return Driver.removeChars(s, "0123456789");
	}
		
	//return the first occurence in s where c is found or -1 if 
	//it was not found - we can't use the String's indexOf
	static int indexOf(String s, char c)
	{
		for(int i = 0; i < s.length(); i = i + 1)
		{
			if(s.charAt(i) == c)
			{
				return i;
			}
		}
		//if we are still kicking....
		return -1;
	}
	
	static void displayString(String s)
	{
		//should display the contents of the String one character per line
		for(int i = 0; i < s.length(); i = i + 1)
		{
			System.out.println(s.charAt(i));
		}
	}
	
	static void displayWithSpaces(String s)
	{
		String answer = "";
		for(int i = 0; i < s.length(); i = i + 1)
		{
			answer = answer + s.charAt(i) + " ";
		}
		System.out.println(answer);
	}
	
	//this method should display on a single line the input String
	//in reverse: "hello" -> "olleh"
	static String reverseString(String s)
	{
		String answer = "";
		for(int i = s.length()-1; i >= 0; i = i - 1)
		{
			answer = answer + s.charAt(i);
		}
		return answer;
	}
}
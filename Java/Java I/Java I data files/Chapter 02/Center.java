/*
	To center the text vertically, divide the number of lines of text by 25. Create that many numbers of \n lines before the text. In this case we have 6 (25 / 4 lines of text). To center the text horizontally, you must take the total length of the string and divide it by 2. Then subtract that amount from 40 (ex: "Mike Brown" is 10 charecters long, 10 / 2 = 5,
	40 - 5 = 35, there needs to be 35 charecters in front of the text Mike Brown).
*/

public class Center{
	public static void main(String[] args){
		System.out.println("\n\n\n\n\n\n");
		System.out.println("\t\t\t\t   Mike Brown");
		System.out.println("\t\t\t\t  Program Name");
		System.out.println("\t\t\t\t Instructor Name");
		System.out.println("\t\t\t\t March 26, 2009");
	}
}

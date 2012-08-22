import java.util.*;

public class LunchPicker
{
	public static void main(String[] args)
	{
		//initialize array
		String[] food = {"McDonald's", "Wendy's","KFC","Pizza","Chinese","Thai","Japanese","Subway","Diner","Chilli's"};

		//initialize random number generator
		Random random = new Random();
		int randomNumber = random.nextInt(9);

		//print results
		for(int i = 0; i<food.length; i++)
		{
		System.out.println("Today you will be eating: " + food[i]);
		}


	}//end main

}//end class
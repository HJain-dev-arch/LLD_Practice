import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
public class game {
	
	private static Queue<Players> queue=new LinkedList<Players>();
	private static List<SnakesAndLadders> snake=new ArrayList<SnakesAndLadders>();
	private static List<SnakesAndLadders> ladders=new ArrayList<SnakesAndLadders>();
	private static Map<String,Integer> currentPosition=new HashMap<String,Integer>();
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of faces on a dice");
		int numberOfFaces=sc.nextInt();
		Dice dice=new Dice(numberOfFaces);
		System.out.println("Enter the board size");
		int size=sc.nextInt();
		System.out.println("Enter the number of players");
		int numberOfPlayers=sc.nextInt();
		while(numberOfPlayers>0)
		{
			System.out.println("Enter Player Name");
			String name=sc.next();
			System.out.println("Enter the Id");
			int id=sc.nextInt();
			Players player=new Players(name,id);
			currentPosition.put(name, 0);
			queue.add(player);
			numberOfPlayers--;
		}
		System.out.println("Enter the number of snakes");
		int numberOfSnakes=sc.nextInt();
		while(numberOfSnakes>0)
		{
			System.out.println("Enter The start Position Of Snake");
			int startPosition=sc.nextInt();
			System.out.println("Enter The end Position Of Snake");
			int endPosition=sc.nextInt();
			if((startPosition>endPosition)&&(startPosition>0)&&(endPosition<size))
			{
				SnakesAndLadders snakes=new SnakesAndLadders(startPosition,endPosition);
				snake.add(snakes);
			}
			numberOfSnakes--;
		}
		System.out.println("Enter the number of ladders");
		int numberOfLadders=sc.nextInt();
		while(numberOfLadders>0)
		{
			System.out.println("Enter the start Position Of Ladder");
			int startPosition=sc.nextInt();
			System.out.println("Enter the end Position Of Ladder");
			int endPosition=sc.nextInt();
			if((startPosition<endPosition)&&(startPosition<size)&&(endPosition>0))
			{
				SnakesAndLadders ladder=new SnakesAndLadders(startPosition,endPosition);
				ladders.add(ladder);
			}
			numberOfLadders--;
		}
		Board board=new Board(dice,queue,snake,ladders,currentPosition,size);
		board.startGame();
	}
}

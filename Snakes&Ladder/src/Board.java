import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Board {
	private Dice dice;
	private Queue<Players> turn;
	private List<SnakesAndLadders> snake;
	private List<SnakesAndLadders> ladder;
	private Map<String,Integer> currentPosition;
	int size;
	
	public Board(Dice dice, Queue<Players> queue, List<SnakesAndLadders> snake, List<SnakesAndLadders> ladders,
			Map<String, Integer> currentPosition, int size) {
		this.dice = dice;
		this.turn = queue;
		this.snake = snake;
		this.ladder = ladders;
		this.currentPosition = currentPosition;
		this.size = size;
	}
	public void startGame()
	{
		while(turn.size()>0)
		{
			Players player=turn.poll();
			int playerCurrentPosition=currentPosition.get(player.getName());
			int diceValue=dice.roll();
			int nextPosition=playerCurrentPosition+diceValue;
			if(nextPosition==size)
			{
				System.out.println(player.getName()+" won the game");
			}
			else if(nextPosition>size)
			{
				turn.add(player);
			}
			else
			{
				int currentPositionPlayer[]=new int[1];
				//boolean b=false;
				currentPositionPlayer[0]=nextPosition;
				snake.forEach(v->{
					if(v.getStartPosition()==currentPositionPlayer[0])
					{
						currentPositionPlayer[0]=v.getEndPosition();
						System.out.println(player.getName()+" is bitten by snake");
					}});
				ladder.forEach(v->{
					if(v.getStartPosition()==currentPositionPlayer[0])
					{
						currentPositionPlayer[0]=v.getEndPosition();
						System.out.println(player.getName()+" got ladder");
					}
				});
				if(currentPositionPlayer[0]==size)
				{
					System.out.println(player.getName()+" won the game");
				}
				else
				{
					currentPosition.put(player.getName(), nextPosition);
					turn.add(player);
				}
			}
		}
	}
	
	
}
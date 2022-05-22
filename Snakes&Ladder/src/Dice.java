
public class Dice {

	private int numberofDice;
	
	public Dice(int numberofDice) {
		super();
		this.numberofDice = numberofDice;
	}

	public int getNumberofDice() {
		return numberofDice;
	}

	public void setNumberofDice(int numberofDice) {
		this.numberofDice = numberofDice;
	}
	int roll()
	{
		return (int)(Math.random()*6*(this.numberofDice))+1;
	}
	
}

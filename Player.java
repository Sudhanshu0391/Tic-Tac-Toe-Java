
public class Player {
	private String name;
	private char symbol;
	
	Player(String name,char symbol)
	{
		SetName(name);
		SetSymbol(symbol);
	}
	public void SetName(String name)
	{
		if(!name.isEmpty())
		{
			this.name=name;
		}
	}
	public String Getname() {
		return this.name;
	}
	public void SetSymbol(char symbol)
	{
		if(symbol !='\0')
		{
			this.symbol=symbol;
		}
	}
	public char GetSymbol() {
		return this.symbol;
	}
}

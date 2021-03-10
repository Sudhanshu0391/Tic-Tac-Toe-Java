import java.util.Scanner;

public class TicTacToe_Manager {
	private Player player1 , player2;
	private Board board;
	
	public static void main(String[] args)
	{
		TicTacToe_Manager t = new TicTacToe_Manager();
		t.startGame();
	}
	
	public void startGame() {
		Scanner s = new Scanner(System.in);
		//Player Input
		player1 = takePlayerInput(1);
		player2 = takePlayerInput(2);
		while(player1.GetSymbol() == player2.GetSymbol())// If both Symbol is same!!..
		{
			System.out.println("Symbol Already taken !! please pick another symbol !!");
			char symbol = s.next().charAt(0);
			player2.SetSymbol(symbol);
		}
		
		//create board
		board = new Board(player1.GetSymbol(), player2.GetSymbol());
		
		//conduct the game
		boolean player1Turn = true;
		int status = Board.Incomplete;
		while(status == Board.Incomplete || status == Board.Invalid)
		{
			if(player1Turn)
			{
				System.out.println("Player 1 - "+player1.Getname()+"'s turn");
				System.out.println("Enter x: ");
				int x = s.nextInt();
				System.out.println("Enter y: ");
				int y = s.nextInt();
				status = board.move(player1.GetSymbol(),x,y);
				if(status != Board.Invalid)
				{
					player1Turn = false;
					board.print();
				}
				else
				{
					System.out.println("Invalid Move !! Try Again !!");
				}
			}
			else
			{
				System.out.println("Player 2 - "+player2.GetSymbol()+"'s turn");
				System.out.println("Enter x: ");
				int x = s.nextInt();
				System.out.println("Enter y: ");
				int y = s.nextInt();
				status = board.move(player2.GetSymbol(),x,y);
				if(status != Board.Invalid)
				{
					player1Turn = true;
					board.print();
				}
				else
				{
					System.out.println("Invalid Move !! Try Again !!");
				}
			}
		}
		if(status == Board.player1_win) {
			System.out.println("Player 1 - "+player1.Getname()+" wins!!");
		}
		else if(status == Board.player2_win) {
			System.out.println("Player 2 - "+player2.Getname()+" wins!!");
		}
		else
		{
			System.out.println("Draw!!");
		}
		
	}
	private Player takePlayerInput(int num)
	{
		Scanner se = new Scanner(System.in);
		System.out.println("Enter Player "+ num +" name: ");
		String name = se.nextLine();
		System.out.println("Enter Player "+ num +" symbol: ");
		char symbol = se.next().charAt(0);
		Player p = new Player(name,symbol);
		return p;
	}
}


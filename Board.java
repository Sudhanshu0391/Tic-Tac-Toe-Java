
public class Board {
	private char board[][];
	private int size = 3;
	private char p1Symbol,p2Symbol;
	private int count;// No. of cells of board that have been marked
	public final static int player1_win = 1;
	public final static int player2_win = 2;
	public final static int draw = 3;
	public final static int Incomplete = 4;
	public final static int Invalid = 5;
	public Board(char p1Symbol,char p2Symbol)
	{
		board = new char[size][size];
		for(int i=0;i<size;i++)
		{
			for(int j=0;j<size;j++)
			{
				board[i][j] = ' ';
			}
		}
		this.p1Symbol = p1Symbol;
		this.p2Symbol = p2Symbol;
	}
	public int move(char Symbol, int x, int y) {
		// TODO Auto-generated method stub
		if(x<0 || x>=size || y<0 || y>=size || board[x][y]!=' ')
		{
			return Invalid; 
		}
		board[x][y] = Symbol;
		count++;
		// check row
		if(board[x][0]==board[x][1] && board[x][0]==board[x][2])
		{
			return Symbol == p1Symbol ? player1_win : player2_win;
		}
		// check column
		if(board[0][y]==board[1][y] && board[0][y]==board[2][y])
		{
			return Symbol == p1Symbol ? player1_win : player2_win;
		}
		// First Diagonal
		if(board[0][0]!=' ' && board[0][0]==board[1][1] && board[0][0]==board[2][2])
		{
			return Symbol == p1Symbol ? player1_win : player2_win;
		}
		// Second Diagonal
		if(board[0][2]!=' ' && board[0][2]==board[1][1] && board[0][2]==board[2][0])
		{
			return Symbol == p1Symbol ? player1_win : player2_win;
		}
		if(count == size*size)
		{
			return draw;
		}
		return Incomplete;
		
		   
	}
	public void print() {
		System.out.println("---------------");
		for(int i=0;i<size;i++)
		{
			for(int j=0;j<size;j++)
			{
				System.out.print("| "+ board[i][j] +" |");
 			}
			System.out.println();
		}
		System.out.println();
		System.out.println("---------------");
	}
}

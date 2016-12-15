import minidungeon.MiniDungeonGUI;

public class Main {
	public static void main (String[]args) throws InterruptedException{

	MiniDungeonGUI gui = new MiniDungeonGUI (50, 50);
	gui.md_println("MiniDungeon");
	gui.setVisible(true);
	
	//inicializo al jugador
	Player player = new Player();

	//Inicializo el tablero

	gui.md_setTextGold(player.getGold());
	gui.md_setTextFood(player.getFood());
	gui.md_setTextHealthCurrent(player.getHealth());
	gui.md_setTextHealthMax(player.getHealthmax());
	gui.md_setTextStrength(player.getStrength());
	gui.md_setTextPerception(player.getPerception());
	
	
	int X=(int)(Math.random()*50);
	int Y=(int)(Math.random()*50);
	
	player.setPosX(X);
	player.setPosY(Y);
	
	int level = 5; 
	
	while(level!=0){
		gui.md_setTextFloor(level);		
		Board board = new Board();
		board.GenerateBoard( player.getPosX(), player.getPosY());
		board.GenerateItem(board, level);
		board.PaintBoard(gui, board);
		player.Move(gui, board, player);
		level --;
	
	}
	}

}

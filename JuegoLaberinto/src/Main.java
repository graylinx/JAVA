import minidungeon.MiniDungeonGUI;

public class Main {
	public static void main (String[]args) throws InterruptedException{

	MiniDungeonGUI gui = new MiniDungeonGUI (50, 50);
	gui.md_println("MiniDungeon");
	gui.setVisible(true);
	
	Player player = new Player(gui);

	int X=(int)(Math.random()*50);
	int Y=(int)(Math.random()*50);
	
	player.setPosX(X);
	player.setPosY(Y);
	
	int level = 0; 
	int eyelevel =(int)(Math.random()*-5);
	
	
	Board board = new Board(gui, player, level, eyelevel);
	board.explorerCellAdyacents(player.getPerception(), player.getPosX(), player.getPosY());
	board.addSprite(gui, "white-queen.png", 1, true, player.getPosX(), player.getPosY());
	player.paintExplorer(gui, board, player.getPerception());
	
	while(level!=-10){
		
		Cell cell = board.getCell(player.getPosX(), player.getPosY());
		//System.out.println(cell.isDoor());
	
		if (!cell.isDoor()){
			player.Move(gui, board);
		}else{
			level --;
			if(level%5==0){
				eyelevel =(int)(Math.random()*(level)+level);
			}
			gui.md_setTextFloor(level);		
			gui.md_clearSprites();
			board = new Board(gui, player, level, eyelevel);
			board.explorerCellAdyacents(player.getPerception(), player.getPosX(), player.getPosY());
			board.addSprite(gui, "white-queen.png", 1, true, player.getPosX(), player.getPosY());
			player.paintExplorer(gui, board, player.getPerception());
			
		}
	}
}
}
import minidungeon.MiniDungeonGUI;

public class Player {
	private int gold, food, health, healthmax, strength, perception, posX, posY;
	
	public int getHealthmax() {
		return healthmax;
	}

	public void setHealthmax(int healthmax) {
		this.healthmax = healthmax;
	}

	Player(){
		this.gold = 0;
		this.food = 500;
		this.health = 20;
		this.healthmax = 20;
		this.strength = 1;
		this.perception = 1;
		this.posX = 1;
		this.posY = 1;
		
	}
	

	public void PaintCell (MiniDungeonGUI gui, Board board, int perception,int x, int y){
		
		Cell cell = board.getCell(x, y);
		gui.md_setSquareColor(x, y, cell.getRed(), cell.getGreen(), cell.getBlue());
		gui.md_moveSprite(1, x, y);
		gui.md_setSpriteVisible(1, true);
		for(int i = 1; i<=perception; i++){
			if (y+i < 50 && y-i >= 0 && x+i < 50 && x-i >= 0 ){
				gui.md_setSquareColor(x, y-i, board.getCell(x, y-i).getRed(),
						board.getCell(x, y-i).getGreen(), board.getCell(x, y-i).getBlue());
				gui.md_setSquareColor(x, y+i, board.getCell(x, y+i).getRed(),
						board.getCell(x, y+i).getGreen(), board.getCell(x, y+i).getBlue());
				gui.md_setSquareColor(x-i, y, board.getCell(x-i, y).getRed(),
						board.getCell(x-i, y).getGreen(), board.getCell(x-i, y).getBlue());
				gui.md_setSquareColor(x+i, y, board.getCell(x+i, y).getRed(),
						board.getCell(x+i, y).getGreen(), board.getCell(x+i, y).getBlue());
				
				if (board.getCell(x, y-i).isItem()){
					gui.md_setSpriteVisible(board.getCell(x, y-i).idItem(), true);
				}else if  (board.getCell(x, y+i).isItem()){
					gui.md_setSpriteVisible(board.getCell(x, y+i).idItem(), true);
				}else if (board.getCell(x-i, y).isItem()){
					gui.md_setSpriteVisible(board.getCell(x-i, y).idItem(), true);
				}else if (board.getCell(x+i, y).isItem()){
					gui.md_setSpriteVisible(board.getCell(x+i, y).idItem(), true);
				}
			}else if(y-i <0){
				gui.md_setSquareColor(x, y+i, board.getCell(x, y+i).getRed(),
						board.getCell(x, y+i).getGreen(), board.getCell(x, y+i).getBlue());
				gui.md_setSquareColor(x-i, y, board.getCell(x-i, y).getRed(),
						board.getCell(x-i, y).getGreen(), board.getCell(x-i, y).getBlue());
				gui.md_setSquareColor(x+i, y, board.getCell(x+i, y).getRed(),
						board.getCell(x+i, y).getGreen(), board.getCell(x+i, y).getBlue());
				
				if  (board.getCell(x, y+i).isItem()){
					gui.md_setSpriteVisible(board.getCell(x, y+i).idItem(), true);
				}else if (board.getCell(x-i, y).isItem()){
					gui.md_setSpriteVisible(board.getCell(x-i, y).idItem(), true);
				}else if (board.getCell(x+i, y).isItem()){
					gui.md_setSpriteVisible(board.getCell(x+i, y).idItem(), true);
				}
				
			}else if(y+i >= 50){
				gui.md_setSquareColor(x, y-i, board.getCell(x, y-i).getRed(),
						board.getCell(x, y-i).getGreen(), board.getCell(x, y-i).getBlue());
				gui.md_setSquareColor(x-i, y, board.getCell(x-i, y).getRed(),
						board.getCell(x-i, y).getGreen(), board.getCell(x-i, y).getBlue());
				gui.md_setSquareColor(x+i, y, board.getCell(x+i, y).getRed(),
						board.getCell(x+i, y).getGreen(), board.getCell(x+i, y).getBlue());
				
				if (board.getCell(x, y-i).isItem()) {
					gui.md_setSpriteVisible(board.getCell(x, y-i).idItem(), true);
				}else if (board.getCell(x-i, y).isItem()){
					gui.md_setSpriteVisible(board.getCell(x-i, y).idItem(), true);
				}else if (board.getCell(x+i, y).isItem()){
					gui.md_setSpriteVisible(board.getCell(x+i, y).idItem(), true);
				}
			}else if(x-i < 0){
				gui.md_setSquareColor(x, y-i, board.getCell(x, y-i).getRed(),
						board.getCell(x, y-i).getGreen(), board.getCell(x, y-i).getBlue());
				gui.md_setSquareColor(x, y+i, board.getCell(x, y+i).getRed(),
						board.getCell(x, y+i).getGreen(), board.getCell(x, y+i).getBlue());
				gui.md_setSquareColor(x+i, y, board.getCell(x+i, y).getRed(),
						board.getCell(x+i, y).getGreen(), board.getCell(x+i, y).getBlue());
				
				if (board.getCell(x, y-i).isItem()) {
					gui.md_setSpriteVisible(board.getCell(x, y-i).idItem(), true);
				}else if  (board.getCell(x, y+i).isItem()){
					gui.md_setSpriteVisible(board.getCell(x, y+i).idItem(), true);
				}else if (board.getCell(x+i, y).isItem()){
					gui.md_setSpriteVisible(board.getCell(x+i, y).idItem(), true);
				}
			}else if(x+1 >=50){
				gui.md_setSquareColor(x, y-i, board.getCell(x, y-i).getRed(),
						board.getCell(x, y-i).getGreen(), board.getCell(x, y-i).getBlue());
				gui.md_setSquareColor(x, y+i, board.getCell(x, y+i).getRed(),
						board.getCell(x, y+i).getGreen(), board.getCell(x, y+i).getBlue());
				gui.md_setSquareColor(x-i, y, board.getCell(x-i, y).getRed(),
						board.getCell(x-i, y).getGreen(), board.getCell(x-i, y).getBlue());
				
				if (board.getCell(x, y-i).isItem()){
					gui.md_setSpriteVisible(board.getCell(x, y-i).idItem(), true);
				}else if  (board.getCell(x, y+i).isItem()){
					gui.md_setSpriteVisible(board.getCell(x, y+i).idItem(), true);
				}else if (board.getCell(x-i, y).isItem()){
					gui.md_setSpriteVisible(board.getCell(x-i, y).idItem(), true);
				}
			}
		}	
		
	}
	
	public void TakeItem(MiniDungeonGUI gui, Board board, Player player){
		if (board.getCell(player.getPosX(), player.getPosY()).isItem()){
			
			if (board.getCell(player.getPosX(), player.getPosY()).idItem()==2){
				player.setStrength(player.getStrength()+300);
				gui.md_setTextStrength(player.getStrength());
				board.getCell(player.getPosX(), player.getPosY()).deleteCell(2);
				gui.md_setSpriteVisible(2, false);
			
			}else if (board.getCell(player.getPosX(), player.getPosY()).idItem()==3){
				player.setFood(player.getFood()+300);
				gui.md_setTextFood(player.getFood());
				board.getCell(player.getPosX(), player.getPosY()).deleteCell(3);
				gui.md_setSpriteVisible(3, false);
				
				
			}else if (board.getCell(player.getPosX(), player.getPosY()).idItem()==4){
				player.setHealthmax(player.getHealthmax()+5);
				gui.md_setTextHealthMax(player.getHealthmax());
				board.getCell(player.getPosX(), player.getPosY()).deleteCell(4);
				gui.md_setSpriteVisible(4, false);
				
				
			}else if (board.getCell(player.getPosX(), player.getPosY()).idItem()==5){
				player.setHealth(player.getHealth()+5);
				gui.md_setTextHealthCurrent(player.getHealth());
				board.getCell(player.getPosX(), player.getPosY()).deleteCell(5);
				gui.md_setSpriteVisible(5, false);
				
				
			}else if (board.getCell(player.getPosX(), player.getPosY()).idItem()==6){
				player.setGold(player.getGold()+5);
				gui.md_setTextGold(player.getGold());
				board.getCell(player.getPosX(), player.getPosY()).deleteCell(6);
				gui.md_setSpriteVisible(6, false);
				
				
			}
			
		}
		
	}
	
	public void Move(MiniDungeonGUI gui, Board board, Player player){
		int perception = player.getPerception();
		int x = player.getPosX();
		int y = player.getPosY();
		board.explorerCellAdyacents(perception, x, y);
		gui.md_addSprite(1, "white-queen.png", true);
		gui.md_setSpriteVisible(1, true);
		gui.md_moveSprite(1, x, y);
		PaintCell(gui, board, perception, x, y);
		Cell cell = board.getCell(x, y);


		while(!cell.isDoor()) {
			cell = board.getCell(x, y);
			String lastAction = gui.md_getLastAction().toLowerCase();
			
			if (lastAction.equals("left") && x > 0 && board.getBoard()[x-1][y].isWay()) {
				player.setFood(player.getFood()-1);
				gui.md_setTextFood(player.getFood());
				x--;
				player.setPosX(x);
				board.explorerCellAdyacents(perception, x, y);
				PaintCell(gui, board, perception, x, y);
				TakeItem(gui, board, player);

			}else if(lastAction.equals("right") && x+1<50 && board.getBoard()[x+1][y].isWay()){
				player.setFood(player.getFood()-1);
				gui.md_setTextFood(player.getFood());
				x++;
				player.setPosX(x);
				board.explorerCellAdyacents(perception, x, y);
				PaintCell(gui, board, perception, x, y);
				TakeItem(gui, board, player);

			}else if(lastAction.equals("up") && y>0 && board.getBoard()[x][y-1].isWay() ){
				player.setFood(player.getFood()-1);
				gui.md_setTextFood(player.getFood());
				y--;
				player.setPosY(y);
				board.explorerCellAdyacents(perception, x, y);
				PaintCell(gui, board, perception, x, y);
				TakeItem(gui, board, player);

			}else if(lastAction.equals("down")&& y+1<50 && board.getBoard()[x][y+1].isWay()){
				player.setFood(player.getFood()-1);
				gui.md_setTextFood(player.getFood());
				y++;
				player.setPosY(y);
				board.explorerCellAdyacents(perception, x, y);
				PaintCell(gui, board, perception, x, y);
				TakeItem(gui, board, player);

			}
		} 
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public int getFood() {
		return food;
	}

	public void setFood(int food) {
		this.food = food;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getPerception() {
		return perception;
	}

	public void setPerception(int perception) {
		this.perception = perception;
	}
	
	

}

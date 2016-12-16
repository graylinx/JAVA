import minidungeon.MiniDungeonGUI;

public class Player {
	private int gold, food, health, healthmax, strength, perception, posX, posY;
	
	Player(MiniDungeonGUI gui){
		this.gold = 0;
		this.food = 500;
		this.health = 20;
		this.healthmax = 20;
		this.strength = 1;
		this.perception = 1;
		this.posX = 1;
		this.posY = 1;
		
		setText(gui, getGold(), getFood(), getHealth(), getHealthmax(), getStrength(), getPerception());
		
	}
	
	public void setText(MiniDungeonGUI gui, int gold, int food, int health, 
			int healthmax, int strength, int perception){
		gui.md_setTextGold(getGold());
		gui.md_setTextFood(getFood());
		gui.md_setTextHealthCurrent(getHealth());
		gui.md_setTextHealthMax(getHealthmax());
		gui.md_setTextStrength(getStrength());
		gui.md_setTextPerception(getPerception());
	}
	
	

	public void paintExplorer (MiniDungeonGUI gui, Board board, int perception){
		int x = getPosX();
		int y = getPosY();
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
			}else if(y-i <0 && x-i<0){
				gui.md_setSquareColor(x, y+i, board.getCell(x, y+i).getRed(),
						board.getCell(x, y+i).getGreen(), board.getCell(x, y+i).getBlue());
				gui.md_setSquareColor(x+i, y, board.getCell(x+i, y).getRed(),
						board.getCell(x+i, y).getGreen(), board.getCell(x+i, y).getBlue());
				
				if  (board.getCell(x, y+i).isItem()){
					gui.md_setSpriteVisible(board.getCell(x, y+i).idItem(), true);
				}else if (board.getCell(x+i, y).isItem()){
					gui.md_setSpriteVisible(board.getCell(x+i, y).idItem(), true);
				}	
			}else if(y-i <0 && x+i>=50){
				gui.md_setSquareColor(x, y+i, board.getCell(x, y+i).getRed(),
						board.getCell(x, y+i).getGreen(), board.getCell(x, y+i).getBlue());
				gui.md_setSquareColor(x-i, y, board.getCell(x-i, y).getRed(),
						board.getCell(x-i, y).getGreen(), board.getCell(x-i, y).getBlue());
				
				if  (board.getCell(x, y+i).isItem()){
					gui.md_setSpriteVisible(board.getCell(x, y+i).idItem(), true);
				}else if (board.getCell(x-i, y).isItem()){
					gui.md_setSpriteVisible(board.getCell(x-i, y).idItem(), true);
				}
			}else if(x-i <0 && y+i>=50){
				gui.md_setSquareColor(x, y-i, board.getCell(x, y-i).getRed(),
						board.getCell(x, y-i).getGreen(), board.getCell(x, y-i).getBlue());
				gui.md_setSquareColor(x+i, y, board.getCell(x+i, y).getRed(),
						board.getCell(x+i, y).getGreen(), board.getCell(x+i, y).getBlue());
				if (board.getCell(x, y-i).isItem()) {
					gui.md_setSpriteVisible(board.getCell(x, y-i).idItem(), true);
				}else if (board.getCell(x+i, y).isItem()){
					gui.md_setSpriteVisible(board.getCell(x+i, y).idItem(), true);
				}
			
			}else if(x+i >=50 && y+i>=50){	
				gui.md_setSquareColor(x, y-i, board.getCell(x, y-i).getRed(),
						board.getCell(x, y-i).getGreen(), board.getCell(x, y-i).getBlue());
				gui.md_setSquareColor(x-i, y, board.getCell(x-i, y).getRed(),
						board.getCell(x-i, y).getGreen(), board.getCell(x-i, y).getBlue());
				
				if (board.getCell(x, y-i).isItem()){
					gui.md_setSpriteVisible(board.getCell(x, y-i).idItem(), true);
				}else if (board.getCell(x-i, y).isItem()){
					gui.md_setSpriteVisible(board.getCell(x-i, y).idItem(), true);
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
			}else if(x+i >=50){
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
	
	public void TakeItem(MiniDungeonGUI gui, Board board){
		Cell cell = board.getCell(getPosX(), getPosY());
		if (cell.isItem()){
			cell.deleteCell(cell.idItem());
			gui.md_setSpriteVisible(cell.idItem(), false);
			
			if (cell.nameItem() == "sword.png"){
				setStrength(getStrength()+300);
				gui.md_setTextStrength(getStrength());
			
			}else if(cell.nameItem() == "apple.png"){
				setFood(getFood()+300);
				gui.md_setTextFood(getFood());
				
			}else if(cell.nameItem() == "heart.png"){
				setHealthmax(getHealthmax()+5);
				gui.md_setTextHealthMax(getHealthmax());
				
			}else if(cell.nameItem() == "potion.png"){
				setHealth(getHealth()+5);
				gui.md_setTextHealthCurrent(getHealth());
				
			}else if(cell.nameItem() == "gold.png"){

				setGold(getGold()+5);
				gui.md_setTextGold(getGold());
				
			}else if(cell.nameItem() == "eye.png"){
				
				setPerception(getPerception()+1);
				gui.md_setTextPerception(getPerception());
			}		
		}
	}
	
	public void Move(MiniDungeonGUI gui, Board board){
		int perception = getPerception();
		int x = getPosX();
		int y = getPosY();

		String lastAction = gui.md_getLastAction().toLowerCase();
		
		if (lastAction.equals("left") && x > 0 && board.getBoard()[x-1][y].isWay()) {
			setFood(getFood()-1);
			gui.md_setTextFood(getFood());
			x--;
			setPosX(x);
			board.explorerCellAdyacents(perception, x, y);
			paintExplorer(gui, board, perception);
			TakeItem(gui, board);

		}else if(lastAction.equals("right") && x+1<50 && board.getBoard()[x+1][y].isWay()){
			setFood(getFood()-1);
			gui.md_setTextFood(getFood());
			x++;
			setPosX(x);
			board.explorerCellAdyacents(perception, x, y);
			paintExplorer(gui, board, perception);
			TakeItem(gui, board);

		}else if(lastAction.equals("up") && y>0 && board.getBoard()[x][y-1].isWay() ){
			setFood(getFood()-1);
			gui.md_setTextFood(getFood());
			y--;
			setPosY(y);
			board.explorerCellAdyacents(perception, x, y);
			paintExplorer(gui, board, perception);
			TakeItem(gui, board);

		}else if(lastAction.equals("down")&& y+1<50 && board.getBoard()[x][y+1].isWay()){
			setFood(getFood()-1);
			gui.md_setTextFood(getFood());
			y++;
			setPosY(y);
			board.explorerCellAdyacents(perception, x, y);
			paintExplorer(gui, board, perception);
			TakeItem(gui, board);

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
	
	public int getHealthmax() {
		return healthmax;
	}

	public void setHealthmax(int healthmax) {
		this.healthmax = healthmax;
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

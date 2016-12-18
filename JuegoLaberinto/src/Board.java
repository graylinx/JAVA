import minidungeon.MiniDungeonGUI;

public class Board {
	private Cell [][] board= new Cell[50][50];
	private String [] arrayItem = {"sword.png", "apple.png", "heart.png", "potion.png", "gold.png", "eye.png"};
	
	public Board( MiniDungeonGUI gui, Player player, int level, int eyelevel){
		
		initBoard();
		GenerateBoard(player);
		GenerateItem(level, eyelevel);
		PaintBoard(gui);
	}
	
	public void initBoard(){
		for(int i=0; i<50; i++){
			for(int j=0; j<50; j++){
				this.board[i][j] = new Cell();
			}
		}
	}
	
	public void createItem (int idItem, String nameItem){
		
		
		boolean generate = false;
		
		while(!generate){
			int n=(int)(Math.random()*50);
			int m=(int)(Math.random()*50);

			if (this.board[n][m].isWay() && !this.board[n][m].isItem()){
				this.board[n][m].itemCell(idItem, nameItem);
				generate = true;
				
			}
		}
	}
	
	public void alotofItems(String apple, String potion, String gold){
		int maxapple = 2;
		int maxpotions = 2;
		int maxgold = 2;
		int napple = (int)(Math.random()*(maxapple)+1);
		int npotions = (int)(Math.random()*(maxpotions)+1);
		int ngold = (int)(Math.random()*(maxgold)+1);
		int total = napple + npotions + ngold;
		for (int jj = 0; jj<total; jj++){
			if (jj<napple){
				int idapple = jj + 8;
				createItem(idapple, apple);
			}else if(jj>=napple&&jj<napple+npotions){
				int idpotion = jj +8;
				createItem(idpotion, potion);
			}else if(jj>=napple+npotions && jj<total){
				int idgold = jj + 8;
				createItem(idgold, gold);
			}
			
		}
	}
	
	public void GenerateItem(int level, int eyelevel){

		for (int ii=2; ii<9; ii++){
			if (ii < 7){
				createItem(ii, arrayItem[ii-2]);
			}else if(ii== 7 && level==eyelevel){
				createItem(ii, arrayItem[ii-2]);
			}else if (ii==8){
				alotofItems(arrayItem[1],arrayItem[3], arrayItem[4]);
			}
		}
	}
	
	public void addSprite(MiniDungeonGUI gui, String nameitems, int id, boolean visible, int x, int y ){
		
		System.out.println(x+";"+y);
		System.out.println(nameitems);
		System.out.println(id);
		gui.md_addSprite(id, nameitems, visible);
		gui.md_setSpriteVisible(id, visible);
		gui.md_moveSprite(id, x, y);

	}
	
	public void paintItem(MiniDungeonGUI gui, Cell cell, int x, int y){
		if (cell.isItem()){	 
    		addSprite(gui, cell.nameItem(), cell.idItem(), true, x, y);
    	}
	}
	
	public void PaintBoard(MiniDungeonGUI gui){
		gui.md_repaintBoard();
	    for (int ii = 0; ii < 50; ii++) {
	        for (int jj = 0; jj < 50; jj++) {
	        	Cell cell = getCell(ii, jj);
	        	if (cell.isWay()){
	        		gui.md_setSquareColor(ii, jj, cell.getRed(), cell.getGreen(), cell.getBlue());
		        	paintItem(gui, cell, ii, jj);
	        	}else{
	        		gui.md_setSquareColor(ii, jj, cell.getRed(), cell.getGreen(), cell.getBlue());
	        		
	        	}
	        }
	    }	        

	}
	
	public void PaintRoom(int x, int y){
		int xweight = x + (int)(Math.random()*5+3);;
		int yheigh = y + (int)(Math.random()*5+3);;
		if (xweight<49 && yheigh<49){
			for(int ii=x; ii<xweight; ii++){
				for(int jj=y; jj<yheigh; jj++){
					if (!this.board[ii][jj].isWay()){
						this.board[ii][jj].wayCell();
					}
				}
			}
		}	
	}
	
	public void GenerateBoard(Player player){
		
	int x = player.getPosX();
	int y = player.getPosY();
    int lastDirection = 1;
    for(int i = 1; i < 100; i++) { 
    	if(i%10==0){
    		PaintRoom(x, y);        		
    	}else{
	    	boolean limit= false;
	    	if(y < 50 && y >= 0 && x >= 0 && x < 50){
	    		int longitud = (int)(Math.random()*17+1);
	    		int direction = (int)(Math.random()*4);
	    		while (direction == lastDirection){
	    			direction = (int)(Math.random()*4);
	    		}
	    		while(!limit && longitud>0){
	            	 lastDirection = direction;
	            	 if(direction == 0){
	                	longitud--;
	                	this.board[x][y].wayCell();
	                    y++;
	                    if(y >= 50){
	                    	limit = true;
	                    	--y;
	                    }
	            	 }else if(direction ==1){
	    				longitud--;
	    				this.board[x][y].wayCell();
	                    y--;
	                    if(y < 0){
	                    	limit = true;
	                    	++y;
	                    }
	            	 }else if(direction == 2){
	    				longitud--;
	    				this.board[x][y].wayCell();
	                    x++;
	                    if(x >= 50){
	                    	limit = true;
	                    	--x;
	                    }
	            	 }else{
	    				longitud--;
	    				this.board[x][y].wayCell();
	                    x--;
	                    if(x < 0){
	                    	limit = true;
	                    	++x;
	                    }
	            	 }
	            	}
	        	}
    		}
       
    	}
    this.board[x][y].doorCell();
	}
	

	public Cell[][] getBoard() {
		return board;
	}
	
	public Cell getCell(int x, int y){
		return this.board[x][y];

	}
	
	public void explorerCellAdyacents(int perception, int x, int y){
		
		this.board[x][y].explorerCell();
		for(int i=1; i<=perception; i++){
			if (y+i < 50 && y-i >= 0 && x+i < 50 && x-i >= 0 ){
				this.board[x+i][y].explorerCell();
				this.board[x-i][y].explorerCell();
				this.board[x][y+i].explorerCell();
				this.board[x][y-i].explorerCell();
			}else if(y-i <0 && x-i<0){
				this.board[x+i][y].explorerCell();
				this.board[x][y+i].explorerCell();
			}else if(y-i <0 && x+i>=50){
				this.board[x-i][y].explorerCell();
				this.board[x][y+i].explorerCell();
			}else if(x-i <0 && y+i>=50){
				this.board[x+i][y].explorerCell();
				this.board[x][y-i].explorerCell();
			}else if(x+i >=50 && y+i>=50){	
				this.board[x-i][y].explorerCell();
				this.board[x][y-i].explorerCell();
			}else if(y-i <0){
				this.board[x+i][y].explorerCell();
				this.board[x-i][y].explorerCell();
				this.board[x][y+i].explorerCell();
			}else if(y+i >= 50){
				this.board[x+i][y].explorerCell();
				this.board[x-i][y].explorerCell();
				this.board[x][y-i].explorerCell();
			}else if(x-i < 0){
				this.board[x+i][y].explorerCell();
				this.board[x][y+i].explorerCell();
				this.board[x][y-i].explorerCell();
			}else if(x+i >= 50){
				this.board[x-i][y].explorerCell();
				this.board[x][y+i].explorerCell();
				this.board[x][y-i].explorerCell();
			}
			
		}
		
		
	}
	
	

	public void setBoard(Cell[][] board) {
		this.board = board;
	}
	
}

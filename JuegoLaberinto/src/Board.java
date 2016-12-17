import minidungeon.MiniDungeonGUI;

public class Board {
	private Cell [][] board= new Cell[50][50];
	private String [] arrayItem = {"sword.png", "apple.png", "heart.png", "potion.png", "gold.png", "eye.png"};
	
	public Board( MiniDungeonGUI gui, Player player, int level){
		
		
		initBoard();
		GenerateBoard(player);
		GenerateItem(level);
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
				System.out.println("Manzanaid:");
				this.board[n][m].itemCell(idItem, nameItem);
				generate = true;
				
			}
		}
	}
	
	public void alotofItems(String apple, String potion, String gold){
		int maxapple = 10;
		int maxpotions = 3;
		int maxgold = 15;
		int napple = (int)(Math.random()*(maxapple)+1);
		int npotions = (int)(Math.random()*(maxpotions)+1);
		int ngold = (int)(Math.random()*(maxgold)+1);
		int total = napple + npotions + ngold;
		System.out.println(napple);
		System.out.println(npotions);
		System.out.println(ngold);
		System.out.println(total);
		for (int jj = 0; jj<total; jj++){
			if (jj<napple){
				int idapple = jj + 8;
				System.out.println("Manzanaid:"+idapple );
				createItem(idapple, apple);
			}else if(jj>=napple&&jj<napple+npotions){

				int idpotion = jj +8;
				System.out.println("Pocionid:"+idpotion );
				createItem(idpotion, potion);
			}else if(jj>=napple+npotions && jj<total){
				int idgold = jj + 8;
				System.out.println("Oroid:"+idgold );
				createItem(idgold, gold);
			}
			
		}
	}
	
	public void GenerateItem(int level){

		for (int ii=2; ii<9; ii++){
			if (ii < 8){
				createItem(ii, arrayItem[ii-2]);
			}else{
				alotofItems(arrayItem[1],arrayItem[3], arrayItem[4]);
			}
		}
	}
	
	public void addSprite(MiniDungeonGUI gui, String nameitems, int id, boolean visible, int x, int y ){
		
		
		gui.md_addSprite(id, nameitems, visible);
		gui.md_setSpriteVisible(id, visible);
		gui.md_moveSprite(id, x, y);

	}
	
	public void paintItem(MiniDungeonGUI gui, Cell cell, int x, int y){
		if (cell.isItem()){	 
			System.out.println(x+";"+y);
    		addSprite(gui, cell.nameItem(), cell.idItem(), true, x, y);
    	}
	}
	
	public void PaintBoard(MiniDungeonGUI gui){
		gui.md_repaintBoard();
	    for (int ii = 0; ii < 50; ii++) {
	        for (int jj = 0; jj < 50; jj++) {
	        	Cell cell = getBoard()[ii][jj];
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
    System.out.println("***"+ i +"***");
   	System.out.print(x + ";");
   	System.out.println(y);
    	if(i%10==0){
    		PaintRoom(x, y);        		
    	}else{
	    	boolean limit= false;
	    	if(y < 50 && y >= 0 && x >= 0 && x < 50){
	    		System.out.println("ENTRA");
	    		int longitud = (int)(Math.random()*17+1);
	    		int direction = (int)(Math.random()*4);
	    		while (direction == lastDirection){
	    			direction = (int)(Math.random()*4);
	    		}
	    		while(!limit && longitud>0){
	    			 System.out.print(x + ";");
	            	 System.out.println(y);
	            	 System.out.println("direccion: "+direction);
	            	 lastDirection = direction;
	            	 if(direction == 0){
	            		System.out.println("longitud: "+longitud);
	                	longitud--;
	                	this.board[x][y].wayCell();
	                    y++;
	                    System.out.println("y: "+ y);
	                    if(y >= 50){
	                    	System.out.println("limite");
	                    	limit = true;
	                    	--y;
	                    	System.out.println("yrecuperada: "+ y);
	                    }
	            	 }else if(direction ==1){
	    				longitud--;
	    				System.out.println("longitud: "+longitud);
	    				this.board[x][y].wayCell();
	                    y--;
	                    System.out.println("y: "+ y);
	                    if(y < 0){
	                    	System.out.println("limite");
	                    	limit = true;
	                    	++y;
	                    	System.out.println("yrecuperada: "+ y);
	                    }
	            	 }else if(direction == 2){
	    				longitud--;
	    				System.out.println("longitud: "+longitud);
	    				this.board[x][y].wayCell();
	                    x++;
	                    System.out.println("x: "+ x);
	                    if(x >= 50){
	                    	System.out.println("limite");
	                    	limit = true;
	                    	--x;
	                    	System.out.println("xrecuperada: "+ x);
	                    }
	            	 }else{
	    				longitud--;
	    				System.out.println("longitud: "+longitud);
	    				this.board[x][y].wayCell();
	                    x--;
	                    System.out.println("x: "+ x);
	                    if(x < 0){
	                    	System.out.println("limite");
	                    	limit = true;
	                    	++x;
	                    	System.out.println("xrecuperada: "+ x);
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

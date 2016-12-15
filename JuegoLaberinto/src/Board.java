import minidungeon.MiniDungeonGUI;

public class Board {
	private Cell [][] board= new Cell[50][50];
	
	
	public Board(){
		for(int i=0; i<50; i++){
			for(int j=0; j<50; j++){
				this.board[i][j] = new Cell();
			}
		}
	}
	
	
	public void createItem (Board board, int idItem){
		boolean generate = false;
		while(!generate){
			int n=(int)(Math.random()*50);
			int m=(int)(Math.random()*50);

			if (this.board[n][m].isWay()){
				this.board[n][m].itemCell(idItem);
				generate = true;
			}
		}
	}
	
	public void PaintBoard(MiniDungeonGUI gui, Board tablero){

	    for (int ii = 0; ii < 50; ii++) {
	        for (int jj = 0; jj < 50; jj++) {
	        	Cell cell = tablero.getBoard()[ii][jj];
	        	if (cell.isWay()){
	        		gui.md_setSquareColor(ii, jj, cell.getRed(), cell.getGreen(), cell.getBlue());
		        	if (cell.isItem()){	
		        		if (cell.idItem() == 2){
			        		
			        		gui.md_addSprite(2, "sword.png", true);
			        		gui.md_setSpriteVisible(2, false);
			        		gui.md_moveSprite(2, ii, jj);
		        		}else if(cell.idItem() == 3){
		        			
			        		gui.md_addSprite(3, "apple.png", true);
			        		gui.md_setSpriteVisible(3, false);
			        		gui.md_moveSprite(3, ii, jj);
		        			
		        		}else if(cell.idItem() == 4){
		        			gui.md_addSprite(4, "heart.png", true);
			        		gui.md_setSpriteVisible(4, false);
			        		gui.md_moveSprite(4, ii, jj);
		        			
		        		}else if(cell.idItem() == 5){
		        			gui.md_addSprite(5, "potion.png", true);
			        		gui.md_setSpriteVisible(5, false);
			        		gui.md_moveSprite(5, ii, jj);
		        			
		        		}else if(cell.idItem() == 6){
		        			gui.md_addSprite(6, "gold.png", true);
			        		gui.md_setSpriteVisible(6, false);
			        		gui.md_moveSprite(6, ii, jj);
		        			
		        		}else if(cell.idItem() == 7){
		        			gui.md_addSprite(7, "eye.png", true);
			        		gui.md_setSpriteVisible(7, false);
			        		gui.md_moveSprite(7, ii, jj);
		        			
		        		}
		        	}
	        	}else{
	        		gui.md_setSquareColor(ii, jj, cell.getRed(), cell.getGreen(), cell.getBlue());
	        		
	        	}
	        }
	    }
		
		
	}
	
	public void GenerateItem(Board board, int level){
		createItem(board, 2);
		createItem(board, 3);
		createItem(board, 4);
		createItem(board, 5);
		createItem(board, 6);
		createItem(board, 7);
		
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
	
	public void GenerateBoard(int x, int y){
		
    int lastDirection = 1;
    for(int i = 1; i < 100; i++) { 
    System.out.println("***"+ i +"***");
   	System.out.print(x + ";");
   	System.out.println(y);
    	if(i%10==0){
    		this.PaintRoom(x, y);        		
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

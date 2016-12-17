
public class Cell {
	
	boolean explored, way, door, item;
	String nameitem;
	


	int red, green, blue, iditem;
	
	public Cell(){
		this.red = 64;
		this.green = 64;
		this.blue = 64;
	}
	
	public void explorerCell(){
			if (!this.isExplored() && !this.isDoor()){
				if (!this.isWay()){
					this.red = 123;
					this.green = 123;
					this.blue = 123;
			        this.explored =true;
				}else{
					this.red = 255;
					this.green = 255;
					this.blue = 244;
			        this.explored =true;
				}
			}
		}
		
	
	public void wayCell(){
		this.red = 80;
		this.green = 80;
		this.blue = 80;
        this.way =true;
	}
	
	public void doorCell(){
		this.red = 255;
		this.green = 0;
		this.blue = 0;
        this.door = true;
        this.way = true;
	}
	
	public void itemCell(int iditem, String nameitem){
		this.iditem = iditem;
		this.nameitem = nameitem;
		this.item = true;
		
	}
	
	
	public void deleteCell(int iditem){
		this.iditem = iditem;
		this.item = false;
		
	}

	public int getRed() {
		return red;
	}

	public void setRed(int red) {
		this.red = red;
	}

	public int getGreen() {
		return green;
	}

	public void setGreen(int green) {
		this.green = green;
	}

	public int getBlue() {
		return blue;
	}

	public void setBlue(int blue) {
		this.blue = blue;
	}

	public boolean isItem() {
		return item;
	}
	

	public String nameItem(){
		return this.nameitem;
	}
	
	public int idItem() {
		return this.iditem;
	}
	
	public boolean isExplored() {
		return explored;
	}

	public void setExplored(boolean explored) {
		this.explored = explored;
	}
	
	public boolean isWay() {
		return way;
	}

	public void setWay(boolean way) {
		this.way = way;
	}
	
	public boolean isDoor() {
		return door;
	}

	public void setDoor(boolean door) {
		this.door = door;
	}
	
	

}

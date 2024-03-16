public abstract class Resource {
	private int[] location = new int[2];

	public Resource(int x, int y) {
		location[0] = x;
		location[1] = y;
	}

	abstract void harvest(Pawn pawn);


	public int getX() {
		return location[0];
	}
	public int getY(){
		return location[1];
	}

}
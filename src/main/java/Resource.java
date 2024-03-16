public abstract class Resource implements Placeable {
	private int[] location = new int[2];

	public Resource(int x, int y) {
		location[0] = x;
		location[1] = y;
	}

	abstract void harvest(Pawn pawn);

	@Override
	public int getX() {
		return location[0];
	}
	@Override
	public int getY(){
		return location[1];
	}

}
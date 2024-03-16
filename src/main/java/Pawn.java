public class Pawn extends Inventory implements Placeable {
	private int health;
	private int hunger;
	private int job;
	// 0 = no job
	// 1 = gather wood
	// 2 = gather food
	private int[] location = new int[2];
	// [x][y] base 1
	final private int maxHealth = 10;
	final private int maxHunger = 5;
	private int tickCount;
	private boolean alive;
	static final char DISPLAY_CHAR = 'i';

	public Pawn(int x, int y) {
		super(0, 0, 5, 5);
		health = maxHealth;
		hunger = maxHunger;
		job = 0;
		location[0] = x;
		location[1] = y;
		tickCount = 0;
		alive = true;
	}

	public void tick() {
		tickCount += 1;

		if (tickCount == 4) {
			if (!this.eat()) {
				this.damage(1);
			}
		}

	}

	public boolean eat() {
		return super.useFood(1);
	}

	public void damage(int damage) {
		if (health - damage <= 0) {
			alive = false;
		} else {
			health -= damage;
		}
	}

	@Override
	public int getX() {
		return location[0];
	}

	@Override
	public int getY() {
		return location[1];
	}

}
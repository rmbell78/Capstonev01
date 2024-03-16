public class Inventory {
	private int wood;
	private int food;
	final private int foodMax;
	final private int woodMax;

	public Inventory() {
		wood = 0;
		food = 0;
		woodMax = 10;
		foodMax = 10;
	}

	public Inventory(int wood, int food, int woodMax, int foodMax) {
		if (isValidResource(woodMax)) {
			this.woodMax = woodMax;
		} else {
			this.woodMax = 10;
		}
		if (isValidResource(foodMax)) {
			this.foodMax = foodMax;
		} else {
			this.foodMax = 10;
		}
		if (isValidResource(wood) && isValidWoodMax(0)) {
			this.wood = wood;
		} else {
			System.out.println("Invalid wood passed to inventory");
			this.wood = 0;
		}
		if (isValidResource(food) && isValidFoodMax(0)) {
			this.food = food;
		} else {
			System.out.println("Invalid food passed to inventory");
			this.food = 0;
		}
	}

	public int getWood() {
		return wood;
	}

	public void setWood(int wood) {
		if (isValidResource(wood)) {
			this.wood = wood;
		} else {
			System.out.println("Invalid wood passed to inventory, no change");
		}
	}

	public int getFood() {
		return food;
	}

	public void setFood(int food) {
		if (isValidResource(food)) {
			this.food = food;
		} else {
			System.out.println("Invalid food passed to inventory, no change");
		}
	}

	public boolean useWood(int numUsed) {
		if (wood - numUsed >= 0) {
			wood -= numUsed;
			return true;
		} else {
			return false;
		}
	}

	public boolean useFood(int numUsed) {
		if (food - numUsed >= 0) {
			food -= numUsed;
			return true;
		} else {
			return false;
		}
	}

	public boolean addWood(int numAdd) {
		if (isValidResource(numAdd)) {
			if (isValidWoodMax(numAdd)) {
				wood += numAdd;
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean addFood(int numAdd) {
		if (isValidResource(numAdd)) {
			if (isValidFoodMax(numAdd)) {
				wood += numAdd;
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	private boolean isValidResource(int resource) {
		return resource >= 0;
	}

	private boolean isValidFoodMax(int foodAdd) {
		return foodAdd + food <= foodMax;
	}

	private boolean isValidWoodMax(int woodAdd) {
		return woodAdd + wood <= woodMax;
	}
}

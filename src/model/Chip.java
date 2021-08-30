package model;

public enum Chip {
	twenty(20),
	fifty(50),
	hundred(100);
	private int chip;
	
	Chip(int i) {
		this.chip = i;
	}
	
	public static int getChipValue(Chip chip) {
		switch (chip) {
		case twenty:
			return 20;
		case fifty:
			return 50;
		case hundred:
			return 100;
		default:
			return 0;
		}
	}
	
}

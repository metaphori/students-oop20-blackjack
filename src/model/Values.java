package model;

public enum Values {
	one(1),two(2),three(3),four(4),five(5),six(6),seven(7),eight(8),
	nine(9),ten(10),jack(10),queen(10),king(10),ace(11);

	private int v;
	Values(int v) {
		// TODO Auto-generated constructor stub
		this.v = v;
	}
	
	public int getV() {
		return this.v;
	}
	
	public int getValues(Values value) {
		switch (value) {
		case one:
			return 1;
		case two:
			return 2;
		case three:
			return 3;
		case four:
			return 4;
		case five:
			return 5;
		case six:
			return 6;
		case seven:
			return 7;
		case eight:
			return 8;
		case nine:
			return 9;
		case ten:
			return 10;
		case jack:
			return 10;
		case queen:
			return 10;
		case king:
			return 10;
		case ace:
			return 11;
		default:
			return 0;
		}

	}
	
	
	
	
}

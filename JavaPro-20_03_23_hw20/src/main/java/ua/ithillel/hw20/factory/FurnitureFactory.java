package ua.ithillel.hw20.factory;

public class FurnitureFactory {
	public static Furniture getByUsing(byUsing bUsing) {
		switch (bUsing) {
		case SeatOn:
			return new Chair();
		case PutOn:
			return new Table();
		default:
			return null;
		}
	}
	
	enum byUsing{
		SeatOn,
		PutOn
	}
}

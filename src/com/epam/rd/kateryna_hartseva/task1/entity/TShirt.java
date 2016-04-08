package com.epam.rd.kateryna_hartseva.task1.entity;

/**
 * @author Kateryna Hartseva
 */
public class TShirt extends UpperBodyGarment {
	private boolean textOnTShirt;

	public TShirt(String model, Size size, String color, double price, ClothType cloth, double sleeveLength,
	              boolean decollete, boolean textOnTShirt) {
		super(model, size, color, price, cloth, sleeveLength, decollete);
		this.textOnTShirt = textOnTShirt;
	}

	public TShirt(String model) {
		super(model);
	}

	public boolean hasTextOnTShirt() {
		return textOnTShirt;
	}

	public void setTextOnTShirt(boolean textOnTShirt) {
		this.textOnTShirt = textOnTShirt;
	}
}
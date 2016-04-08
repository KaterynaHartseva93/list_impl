package com.epam.rd.kateryna_hartseva.task1.entity;

/**
 * @author Kateryna Hartseva
 */
public abstract class UpperBodyGarment extends Clothes {

	//where, for example, 1. == 100% --> full length of the sleeves
	private double sleeveLength;
	private boolean decollete;

	protected UpperBodyGarment(String model) {
		super(model);
	}

	protected UpperBodyGarment(String model, Size size, String color, double price, ClothType cloth, double sleeveLength, boolean decollete) {
		super(model, size, color, price, cloth);
		this.sleeveLength = sleeveLength;
		this.decollete = decollete;
	}

	public double getSleeveLength() {
		return sleeveLength;
	}

	public void setSleeveLength(double sleeveLength) {
		this.sleeveLength = sleeveLength;
	}

	public boolean isDecollete() {
		return decollete;
	}

	public void setDecollete(boolean decollete) {
		this.decollete = decollete;
	}

	@Override
	public String toString() {
		return "UpperBodyGarment{" +
				"sleeveLength=" + sleeveLength +
				", decollete=" + decollete +
				'}';
	}
}

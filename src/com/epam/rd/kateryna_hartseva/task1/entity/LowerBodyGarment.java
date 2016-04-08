package com.epam.rd.kateryna_hartseva.task1.entity;

/**
 * @author Kateryna Hartseva
 */
public abstract class LowerBodyGarment extends Clothes {
	private String fitPlace;

	protected LowerBodyGarment(String model) {
		super(model);
	}

	protected LowerBodyGarment(String model, Size size, String color, double price, ClothType cloth, String fitPlace) {
		super(model, size, color, price, cloth);
		this.fitPlace = fitPlace;
	}

	public String getFitPlace() {
		return fitPlace;
	}

	public void setFitPlace(String fitPlace) {
		this.fitPlace = fitPlace;
	}

	@Override
	public String toString() {
		return "LowerBodyGarment{" +
				"fitPlace='" + fitPlace + '\'' +
				'}';
	}
}

package com.epam.rd.kateryna_hartseva.task1.entity;

/**
 * @author Kateryna Hartseva
 */
public class Skirt extends LowerBodyGarment {

	private String form;
	private boolean isOfficial;

	public Skirt(String model, Size size, String color, double price, ClothType cloth, String fitPlace,
	             String form, boolean isOfficial) {
		super(model, size, color, price, cloth, fitPlace);
		this.form = form;
		this.isOfficial = isOfficial;
	}

	public Skirt(String model) {
		super(model);
	}

	public String getForm() {
		return form;
	}

	public void setForm(String form) {
		this.form = form;
	}

	public boolean isOfficial() {
		return isOfficial;
	}

	public void setOfficial(boolean official) {
		isOfficial = official;
	}

	@Override
	public String toString() {
		return "Skirt{" +
				"form='" + form + '\'' +
				", isOfficial=" + isOfficial +
				'}';
	}
}

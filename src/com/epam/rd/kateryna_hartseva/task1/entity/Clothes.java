package com.epam.rd.kateryna_hartseva.task1.entity;

/**
 * @author Kateryna Hartseva
 */
public abstract class Clothes {

	private final String model;

	private Size size;
	private String color;
	private double price;
	private ClothType cloth;

	protected Clothes(String model, Size size, String color, double price, ClothType cloth) {
		this.model = model;
		this.size = size;
		this.color = color;
		this.price = price;
		this.cloth = cloth;
	}

	protected Clothes(String model) {
		this.model = model;
	}

	public String getModel() {
		return model;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = Size.valueOf(size.toUpperCase());
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public ClothType getCloth() {
		return cloth;
	}

	public void setCloth(ClothType cloth) {
		this.cloth = cloth;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Clothes clothes = (Clothes) o;
		return model.equals(clothes.model);
	}

	@Override
	public int hashCode() {
		return model.hashCode();
	}

	@Override
	public String toString() {
		return "Clothes{" +
				"model='" + model + '\'' +
				", size=" + size +
				", color='" + color + '\'' +
				", price=" + price +
				", cloth=" + cloth +
				'}';
	}
}


package ro.emanuel.rc.pojo;

public class RubicksCube {

	private int id;
	private String brand;
	private double weight;
	private int sides;
	
	public RubicksCube(int id, String brand, double weight, int sides) {
		this.id = id;
		this.brand = brand;
		this.weight = weight;
		this.sides = sides;
	}
	
	public RubicksCube(String brand, double weight, int sides) {
		this.id = id;
		this.brand = brand;
		this.weight = weight;
		this.sides = sides;
	}
	
	public RubicksCube() {} //why do I need an empty constructor?

	@Override
	public String toString() { //where do I use this method?
		return "RubicksCube [id=" + id + ", brand=" + brand + ", weight=" + weight + ", sides=" + sides + "]";
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getSides() {
		return sides;
	}

	public void setSides(int sides) {
		this.sides = sides;
	}
	
	
}

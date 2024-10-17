package ro.emanuel.usb.pojo;

public class Usb {

	private int id;
	private String brand;
	private int storage;
	private String spec_feature;
	
	public Usb(int id, String brand, int storage, String spec_feature) {
		super();
		this.id = id;
		this.brand = brand;
		this.storage = storage;
		this.spec_feature = spec_feature;
	}
	
	public Usb(String brand, int storage, String spec_feature) {
		super();
		this.id = id;
		this.brand = brand;
		this.storage = storage;
		this.spec_feature = spec_feature;
	}
	
	public Usb() {}
	
	@Override
	public String toString() {
		return "usb [id=" + id + ", brand=" + brand + ", storage=" + storage + ", spec_feature=" + spec_feature + "]";
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

	public int getStorage() {
		return storage;
	}

	public void setStorage(int storage) {
		this.storage = storage;
	}

	public String getSpec_feature() {
		return spec_feature;
	}

	public void setSpec_feature(String spec_feature) {
		this.spec_feature = spec_feature;
	}
	
	
}

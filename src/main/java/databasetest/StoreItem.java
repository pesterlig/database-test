package databasetest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;



@Entity
public class StoreItem {

	@Id
	@GeneratedValue
	private Long id;
	private String uriItemId;
	private String itemTagId;
	private String name;
	
	@Lob
	private String description;
	
	private double price;
	private String size;
	private String brand;
	private String upc;
	private String imgUrlSm;
	private String imgUrlMed;
	private String imgUrlLg;
	
	public StoreItem(Long id, String uriItemId, String itemTagId, String name, String description, double price, String size,
			String brand, String upc, String imgUrlSm, String imgUrlMed, String imgUrlLg) {
		this.id = id;
		this.uriItemId = uriItemId;
		this.itemTagId = itemTagId;
		this.name = name;
		this.description = description;
		this.price = price;
		this.size = size;
		this.brand = brand;
		this.upc = upc;
		this.imgUrlSm = imgUrlSm;
		this.imgUrlMed = imgUrlMed;
		this.imgUrlLg = imgUrlLg;
	}

	protected StoreItem() {
	}
	
		
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUriItemId() {
		return uriItemId;
	}

	public void setUriItemId(String uriItemId) {
		this.uriItemId = uriItemId;
	}
		
	public String getItemTagId() {
		return itemTagId;
	}

	public void setItemTagId(String itemTagId) {
		this.itemTagId = itemTagId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getUpc() {
		return upc;
	}

	public void setUpc(String upc) {
		this.upc = upc;
	}

	public String getImgUrlSm() {
		return imgUrlSm;
	}

	public void setImgUrlSm(String imgUrlSm) {
		this.imgUrlSm = imgUrlSm;
	}

	public String getImgUrlMed() {
		return imgUrlMed;
	}

	public void setImgUrlMed(String imgUrlMed) {
		this.imgUrlMed = imgUrlMed;
	}

	public String getImgUrlLg() {
		return imgUrlLg;
	}

	public void setImgUrlLg(String imgUrlLg) {
		this.imgUrlLg = imgUrlLg;
	}


	@Override
    public String toString() {
        return String.format(
                "StoreItem[id=%d, name='%s', description='%s', price='%s',]",
                id, name, description, price);
    }

} //end of class

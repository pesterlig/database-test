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
	private String name;
	
	@Lob
	private String description;
	
	private double price;
	private String url;
	


	//overloaded constructor necessary for JPA 
	protected StoreItem() {
	}

	public void setId(Long id) {
		this.id = id;
	}

	//constructor
	public StoreItem(Long id, String uriItemId, String name, String description, double price, String url) {
		this.id = id;
		this.uriItemId = uriItemId;
		this.name = name;
		this.description = description;
		this.price = price;
		this.url = url;
		
	}


	@Override
    public String toString() {
        return String.format(
                "StoreItem[id=%d, name='%s', description='%s', price='%s', url='%s',]",
                id, name, description, price, url);
    }

	
	public String getUriItemId() {
		return uriItemId;
	}

	public void setUriItemId(String uriItemId) {
		this.uriItemId = uriItemId;
	}

	public Long getId() {
		return id;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}

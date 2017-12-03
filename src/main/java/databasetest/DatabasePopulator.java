package databasetest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.annotation.Resource;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabasePopulator implements CommandLineRunner {
	  
	@Resource
	private StoreItemRepository itemRepo;

	@Override
	public void run(String... args) throws Exception { 
		
		JSONParser parser = new JSONParser();
		
		String basePath = new File("").getAbsolutePath();
        basePath += "\\src\\main\\resources\\walmart-input";
        System.out.println(basePath);
        
		File folder = new File(basePath);
		File[] listOfFiles = folder.listFiles();
//		/database-test/src/main/resources/walmart-input/wmpriceitem10309187.txt
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				System.out.println("File " + listOfFiles[i].getName()); 
				
				try {
					StoreItem genericItem = new StoreItem();
								
//					Object obj = parser.parse(new FileReader("C:/Users/WeCanCodeIT/wcci/default-workspace/database-test/src/main/resources/104514668.txt"));
					Object obj = parser.parse(new FileReader("C:/Users/WeCanCodeIT/wcci/default-workspace/database-test/src/main/resources/walmart-input/" + listOfFiles[i].getName()));
					
					JSONObject jsonObject = (JSONObject) obj;
					System.out.println(jsonObject);
					
					Long uriItemId = ((Number) jsonObject.get("itemId")).longValue();
					String item = uriItemId.toString();
					System.out.println(uriItemId);
					genericItem.setUriItemId(item);
					
					String tagId = (String) jsonObject.get("groceryAppTagId");
					System.out.println(tagId);
					genericItem.setItemTagId(tagId);

					String name = (String) jsonObject.get("name");
					System.out.println(name);
					genericItem.setName(name);
					
					String shortDesc = (String) jsonObject.get("shortDescription");
					System.out.println(shortDesc);
					genericItem.setDescription(shortDesc);

//					String longDesc = (String) jsonObject.get("longDescription");
//					System.out.println(longDesc);
					 
					String size = (String) jsonObject.get("size");
					System.out.println(size);
					genericItem.setSize(size);
					
					String brand = (String) jsonObject.get("brandname");
					System.out.println(brand);
					genericItem.setBrand(brand);
					
					String upc = (String) jsonObject.get("upc");
					System.out.println(upc);
					genericItem.setUpc(upc);
								
					String imgUrlSmall = (String) jsonObject.get("thumbnailImage");
					System.out.println(imgUrlSmall);
					genericItem.setImgUrlSm(imgUrlSmall);
					
					String imgUrlMed = (String) jsonObject.get("mediumImage");
					System.out.println(imgUrlMed);
					genericItem.setImgUrlMed(imgUrlMed);
					
					String imgUrlLg = (String) jsonObject.get("largeImage");
					System.out.println(imgUrlLg);
					genericItem.setImgUrlLg(imgUrlLg);
					
					genericItem.setId(3L);
				
					try {
					if(jsonObject.containsKey("salePrice")) {
						double salePrice = ((Number) jsonObject.get("salePrice")).doubleValue();
						System.out.println(salePrice);
						genericItem.setPrice(salePrice);
					}
					else if(jsonObject.containsKey("msrp")) {
						double salePrice = ((Number) jsonObject.get("msrp")).doubleValue();
						System.out.println(salePrice);
						genericItem.setPrice(salePrice);
					}
					else if(jsonObject.containsKey("groceryAppPrice")) {
						double salePrice = ((Number) jsonObject.get("groceryAppPrice")).doubleValue();
						System.out.println(salePrice);
						genericItem.setPrice(salePrice);	
						
					}}
					catch (Exception ex) {
						throw new IllegalStateException("Failed to execute ApplicationRunner", ex);
					}

					itemRepo.save(genericItem);

//					// loop array
//					JSONArray msg = (JSONArray) jsonObject.get("messages");
//					Iterator<String> iterator = msg.iterator();
//					while (iterator.hasNext()) {
//						System.out.println(iterator.next());
//					}

				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ParseException e) {
					e.printStackTrace();
				}
			
			} else if (listOfFiles[i].isDirectory()) {
				System.out.println("Directory " + listOfFiles[i].getName());
			}
			
		}


//		StoreItem butter = new StoreItem(1L, "WalmartId", "FoodStuff", "Description", 2.00, "size", "brand", "upc", "imgUrlSm", "imgUrlMed", "imgUrlLg");
//		itemRepo.save(butter);
//		
		
		
		
		
	} //run, throws exception
	 
	    }	// to close command line runner



package databasetest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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


		StoreItem butter = new StoreItem(1L, "WalmartId", "LandoLakes", "Description", 2, "url");
		itemRepo.save(butter);
		StoreItem chicken = new StoreItem(2L, "WalmartId", "GreatValue", "Description", 3, "url");
		itemRepo.save(chicken);
		
		JSONParser parser = new JSONParser();

		try {
			StoreItem genericItem = new StoreItem();
			
			
			Object obj = parser.parse(new FileReader("C:/Users/WeCanCodeIT/wcci/default-workspace/database-test/src/main/resources/104514668.txt"));

			JSONObject jsonObject = (JSONObject) obj;
			System.out.println(jsonObject);

			String name = (String) jsonObject.get("name");
			System.out.println(name);
			genericItem.setName(name);
			
			String shortDesc = (String) jsonObject.get("shortDescription");
			System.out.println(shortDesc);
			genericItem.setDescription(shortDesc);

			String longDesc = (String) jsonObject.get("longDescription");
			System.out.println(longDesc);
			
			Long uriItemId = ((Number) jsonObject.get("itemId")).longValue();
			String item = uriItemId.toString();
			System.out.println(uriItemId);
			genericItem.setUriItemId(item);
			
			String imgUrl = (String) jsonObject.get("thumbnailImage");
			System.out.println(imgUrl);
			genericItem.setUrl(imgUrl);
			
			genericItem.setId(3L);
			
			try {
			if(jsonObject.containsKey("salePrice")) {
				double salePrice = ((Number) jsonObject.get("salePrice")).doubleValue();
				System.out.println(salePrice);
				genericItem.setPrice(salePrice);
			}else {
	
			}}
			catch (Exception ex) {
				throw new IllegalStateException("Failed to execute ApplicationRunner", ex);
			}

			itemRepo.save(genericItem);

//			// loop array
//			JSONArray msg = (JSONArray) jsonObject.get("messages");
//			Iterator<String> iterator = msg.iterator();
//			while (iterator.hasNext()) {
//				System.out.println(iterator.next());
//			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}
		
//		@Id
//		@GeneratedValue
//		private Long id;
//		private String uriItemId;
//		private String name;
//		private String description;
//		private double price;
//		private String url;

	} // to close command line runner



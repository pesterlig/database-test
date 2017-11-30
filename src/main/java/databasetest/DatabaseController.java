package databasetest;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DatabaseController {

	

	@Resource
	StoreItemRepository itemRepo;

	

	@RequestMapping("/")
	public String redirectToItems(Model model) {
		return "redirect:/Items";
	}

	

	@RequestMapping("/Items")
	public String showAllItems(Model model) {
		Iterable<StoreItem> c = itemRepo.findAll();
		model.addAttribute("items", itemRepo.findAll());
		return "items";
	}

	
	
	

} // don't touch

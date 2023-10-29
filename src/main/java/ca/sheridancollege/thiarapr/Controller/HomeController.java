package ca.sheridancollege.thiarapr.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.thiarapr.beans.Items;
import ca.sheridancollege.thiarapr.beans.Store;
import ca.sheridancollege.thiarapr.repository.ItemRepository;
import ca.sheridancollege.thiarapr.repository.StoreRepository;
import lombok.AllArgsConstructor;


@Controller
@AllArgsConstructor
public class HomeController {
 private  ItemRepository itemRepo;
 private  StoreRepository storeRepo;
 @GetMapping("/")
 public String root() {
     return "root.html";
 }

 @GetMapping("/store")
 public String store(Model model) {
     model.addAttribute("store", new Store());
     return "store.html";
 }

 @GetMapping("/addItem")
 public String showAddItemPage(Model model) {
	 model.addAttribute("item", new Items());
     model.addAttribute("stores", storeRepo.getStores());
     return "items.html";
 }
 @GetMapping("/goAddStore")
 public String store(Model model,@ModelAttribute Store store) {
     storeRepo.addStore(store);
     return "redirect:/store";

 }


 @GetMapping("/goaddItems")
 public String addItem(Model model, @ModelAttribute Items item) {
     itemRepo.addItem(item);
     System.out.println(item);
     return "redirect:/addItem";

 }
 @GetMapping("/view")
 public String view(Model model,@RequestParam String storeName) {
   model.addAttribute("storeList", storeRepo.getStores());
   model.addAttribute("item",  itemRepo.getItems(storeName));
   
     
     return "view"; 
 }
 @GetMapping("/view1")
public String view1(Model model) {
	 model.addAttribute("storeList", storeRepo.getStores());
	 return "view1";
	 
 }
	@GetMapping("/delete/{id}")
	public String deletePage(@PathVariable int id,Model model ) {
		itemRepo.deletebyid(id);
		return "redirect:/view1";
	}

	@GetMapping("/modify/{id}")
	public String modify(@PathVariable int id,Model model) {
		Items i=itemRepo.getItemById(id);
		model.addAttribute("item",i);
		model.addAttribute("stores", storeRepo.getStores());
		
		return "edit.html";
		
	}
	@GetMapping("/editItem")
	public String modifyDrink(@RequestParam int id,
	@RequestParam String name,@RequestParam String storeName,@RequestParam double price,  @RequestParam String description,Model model) {
	Items  i = new Items(id  ,name, storeName, price, description);
	itemRepo.editItem(i);
	return "redirect:/view1";
	}
}


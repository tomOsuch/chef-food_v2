package pl.tomaszosuch.cheffood;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.tomaszosuch.cheffood.item.Item;
import pl.tomaszosuch.cheffood.item.ItemRepository;

import java.util.List;

@Controller
public class HomeController {

    private ItemRepository itemRepository;

    public HomeController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping("/")
    public String home(Model model){
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "index";
    }
}

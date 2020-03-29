package pl.tomaszosuch.cheffood.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class OrderPanelController {

    private OrderRepository orderRepository;

    @Autowired
    public OrderPanelController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/panel/zamowienia")
    private String getOrder(@RequestParam(required = false) OrderStatus status, Model model){
        List<Order> orders;
        if (status == null){
            orders = orderRepository.findAll();
        } else {
            orders = orderRepository.findByStatus(status);
        }
        model.addAttribute("orders", orders);
        return "panel/orders";
    }
}

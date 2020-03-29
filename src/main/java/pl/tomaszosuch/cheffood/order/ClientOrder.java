package pl.tomaszosuch.cheffood.order;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import pl.tomaszosuch.cheffood.item.Item;

@Component
@SessionScope
public class ClientOrder {

    private Order order;

    public ClientOrder() {
        clear();
    }

    public Order getOrder() {
        return order;
    }

    void add(Item item){
        order.getItems().add(item);
    }

    void clear() {
        order = new Order();
        order.setStatus(OrderStatus.NEW);
    }
}

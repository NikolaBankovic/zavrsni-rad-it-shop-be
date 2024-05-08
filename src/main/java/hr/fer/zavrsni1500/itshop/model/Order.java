package hr.fer.zavrsni1500.itshop.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "`order`")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItemsList;

    private boolean isCompleted;

    public double getTotalAmount() {
        if (orderItemsList != null) {
            return orderItemsList.stream().mapToDouble(OrderItem::getTotalPrice).sum();
//            double total = 0;
//            for (OrderItem orderItem : orderItemsList) {
//                total += orderItem.getTotalPrice();
//            }
//            return total;
        }
        else {
            return 0;
        }
    }

}

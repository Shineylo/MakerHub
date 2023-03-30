package technobel.bart.makerhub.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "\"order\"")
@Getter @Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false)
    private Long id;

    @Column(name = "date_of_order",nullable = false)
    private LocalDateTime dateOfOrder;

    @Column(name = "date_of_delivery",nullable = false)
    private LocalDateTime dateOfDelivery;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private Set<OrderItem> items = new LinkedHashSet<>();

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

}

package technobel.bart.makerhub.service.impl;

import org.springframework.stereotype.Service;
import technobel.bart.makerhub.models.dto.OrderDTO;
import technobel.bart.makerhub.models.entity.Order;
import technobel.bart.makerhub.models.entity.OrderItem;
import technobel.bart.makerhub.models.entity.Product;
import technobel.bart.makerhub.models.form.OrderForm;
import technobel.bart.makerhub.repository.OrderItemRepository;
import technobel.bart.makerhub.repository.OrderRepository;
import technobel.bart.makerhub.repository.ProductRepository;
import technobel.bart.makerhub.service.OrderService;

import java.util.List;
import java.util.Set;

@Service
public class OrderServiceImpl implements OrderService {

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;

    public OrderServiceImpl(ProductRepository productRepository, OrderRepository orderRepository, OrderItemRepository orderItemRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    public void create(OrderForm form) {
        Order order = form.toEntity();

        order = orderRepository.save(order);

        Set<OrderForm.ProductForm> proForms = form.getItems();

        for (OrderForm.ProductForm product : proForms ) {
            OrderItem qttPro = new OrderItem();

            Product pro = productRepository.findById( product.getId() ).orElseThrow();

            qttPro.setQuantity(product.getQuantity());
            qttPro.setOrder(order);
            qttPro.setItem(pro);

            order.getItems().add(qttPro);
        }

        orderItemRepository.saveAll(order.getItems());
    }

    @Override
    public void delete(long id) {
        if(!orderRepository.existsById(id))
            throw new RuntimeException("Order not found");

        orderRepository.deleteById(id);
    }

    @Override
    public void update(long id, OrderForm form) {
        Order toUpdate = form.toEntity();

        toUpdate = orderRepository.save(toUpdate);

        Set<OrderForm.ProductForm> proForms = form.getItems();

        for (OrderForm.ProductForm product : proForms ) {
            OrderItem qttPro = new OrderItem();

            Product pro = productRepository.findById( product.getId() ).orElseThrow();

            qttPro.setQuantity(product.getQuantity());
            qttPro.setOrder(toUpdate);
            qttPro.setItem(pro);

            toUpdate.getItems().add(qttPro);
        }

        orderItemRepository.saveAll(toUpdate.getItems());
    }

    @Override
    public List<OrderDTO> getAll() {
        return orderRepository.findAll().stream()
                .map(OrderDTO::toDto)
                .toList();
    }

    @Override
    public OrderDTO getOne(long id) {
        return orderRepository.findById(id)
                .map(OrderDTO::toDto)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }
}

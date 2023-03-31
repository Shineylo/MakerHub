package technobel.bart.makerhub.service.impl;

import technobel.bart.makerhub.models.dto.OrderDTO;
import technobel.bart.makerhub.models.entity.OrderItem;
import technobel.bart.makerhub.models.form.OrderForm;
import technobel.bart.makerhub.repository.OrderItemRepository;
import technobel.bart.makerhub.repository.OrderRepository;
import technobel.bart.makerhub.repository.ProductRepository;
import technobel.bart.makerhub.service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final OrderItem orderItem;
    private final OrderItemRepository orderItemRepository;

    public OrderServiceImpl(ProductRepository productRepository, OrderRepository orderRepository, OrderItem orderItem, OrderItemRepository orderItemRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
        this.orderItem = orderItem;
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    public void create(OrderForm form) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public void update(long id, OrderForm form) {

    }

    @Override
    public List<OrderDTO> getAll() {
        return null;
    }

    @Override
    public OrderDTO getOne(long id) {
        return null;
    }
}

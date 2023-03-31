package technobel.bart.makerhub.service;

import technobel.bart.makerhub.models.dto.OrderDTO;
import technobel.bart.makerhub.models.form.ProductForm;

import java.util.List;

public interface OrderService {

    void create(OrderForm form);

    void delete(long id);

    void update(long id, OrderForm form);

    List<OrderDTO> getAll();

    OrderDTO getOne(long id);
}

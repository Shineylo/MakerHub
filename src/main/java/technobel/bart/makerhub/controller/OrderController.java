package technobel.bart.makerhub.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import technobel.bart.makerhub.models.dto.OrderDTO;
import technobel.bart.makerhub.models.form.OrderForm;
import technobel.bart.makerhub.service.OrderService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/order")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/new")
    public void neworder(@RequestBody @Valid OrderForm form){
        orderService.create(form);
    }

    @GetMapping("/all")
    public List<OrderDTO> displayAll(){
        return orderService.getAll();
    }

    @GetMapping("/{id:[0-9]+}")
    public OrderDTO displayorderDetails(@PathVariable long id) {
        return orderService.getOne(id);
    }

    @PostMapping("/{id:[0-9]+}/update")
    public void updateorder(@PathVariable long id, @RequestBody @Valid OrderForm form){
        orderService.update(id,form);
    }

    @PostMapping("/{id:[0-9]+}/delete")
    public String deleteorder(@PathVariable long id){
        orderService.delete(id);
        return "redirect:/order/all";
    }
}

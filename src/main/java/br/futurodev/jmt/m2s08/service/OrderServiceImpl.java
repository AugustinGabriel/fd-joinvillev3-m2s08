package br.futurodev.jmt.m2s08.service;

import br.futurodev.jmt.m2s08.entity.OrderEntity;
import br.futurodev.jmt.m2s08.entity.OrderItemEntity;
import br.futurodev.jmt.m2s08.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;

    @Override
    public List<OrderEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public OrderEntity findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public OrderEntity save(OrderEntity order) {
        order.setId(null);
        order.setQtyItems(0);

        for (OrderItemEntity item : order.getItems()) {
            item.setId(null);
            item.setOrder(order);
            if (item.getQuantity() == null || item.getQuantity() == 0) {
                item.setQuantity(1);
            }
            // TODO Verificar se mateiral existe
            order.setQtyItems(item.getQuantity() + order.getQtyItems());
        }
        return repository.save(order);
    }
}

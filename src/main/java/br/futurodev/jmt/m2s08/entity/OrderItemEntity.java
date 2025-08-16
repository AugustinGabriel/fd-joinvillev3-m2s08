package br.futurodev.jmt.m2s08.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "order_items")
public class OrderItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnore
    @ToString.Exclude
    @JoinColumn(nullable = false)
    private OrderEntity order;

    @ManyToOne
    @JoinColumn(nullable = false)
    private MaterialEntity material;

    @Column(nullable = false)
    private Integer quantity;

}

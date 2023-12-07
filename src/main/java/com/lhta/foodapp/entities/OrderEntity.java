package com.lhta.foodapp.entities;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.Set;
import jakarta.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "_order")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "estimate_ship")
    private String estimateShip;

    @Column(name = "deliver_address")
    private String deliverAddress;

    @Column(name = "total_price")
    private float totalPrice;
    
    private int status;
    
    @ManyToOne
    @JoinColumn(name = "id_user")
    @JsonIgnore
    private UserEntity user;
    
    @OneToMany(mappedBy = "order")
    private Set<OrderDetailEntity> orderDetails;
}

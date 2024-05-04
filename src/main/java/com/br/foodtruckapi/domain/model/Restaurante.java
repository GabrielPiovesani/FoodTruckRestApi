package com.br.foodtruckapi.domain.model;


import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.dialect.MySQL57Dialect;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private BigDecimal taxaFrete;

    @ManyToOne
    private Cozinha cozinha;




}

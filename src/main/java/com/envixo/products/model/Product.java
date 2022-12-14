package com.envixo.products.model;

import com.envixo.products.enums.Status;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@Table(indexes = { @Index(name = "IX_product_status", columnList = "status") })
public class Product extends GenericModel {

    private String description;
    private Status status;
    private BigDecimal price;
    private BigDecimal specialPrice;
    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Tag> tags;

    @Transient
    private List<String> imagesBase64;
}

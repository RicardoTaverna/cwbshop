package br.pucpr.cwbshop.domain.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * The type Attribute.
 */
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "attribute")
public class Attribute implements Serializable {

    @Id
    @GeneratedValue
    private int attribute_id;

    @Column(name = "id", length = 50)
    private String id;

    @Column(name = "value_name", length = 100)
    private String value_name;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    @JsonIgnoreProperties("attributes")
    @ApiModelProperty(hidden = true)
    private Product product;

    /**
     * Gets attribute id.
     *
     * @return the attribute id
     */
    public int getAttribute_id() {
        return attribute_id;
    }

    /**
     * Sets attribute id.
     *
     * @param attribute_id the attribute id
     */
    public void setAttribute_id(int attribute_id) {
        this.attribute_id = attribute_id;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets value name.
     *
     * @return the value name
     */
    public String getValue_name() {
        return value_name;
    }

    /**
     * Sets value name.
     *
     * @param value_name the value name
     */
    public void setValue_name(String value_name) {
        this.value_name = value_name;
    }

    /**
     * Gets product.
     *
     * @return the product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Sets product.
     *
     * @param product the product
     */
    public void setProduct(Product product) {
        this.product = product;
    }
}

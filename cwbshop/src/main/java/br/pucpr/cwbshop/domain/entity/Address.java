package br.pucpr.cwbshop.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * The type Address.
 */
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "address")
public class Address implements Serializable {

    @Id
    @GeneratedValue
    private int address_id;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "address")
    @JsonManagedReference
    private City city;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "address")
    @JsonManagedReference
    private State state;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "address")
    @JsonManagedReference
    private Country country;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    @JsonBackReference
    @ApiModelProperty(hidden = true)
    private Product product;

    @Column(name = "id", length = 100)
    private String id;

    /**
     * Gets address id.
     *
     * @return the address id
     */
    public int getAddress_id() {
        return address_id;
    }

    /**
     * Sets address id.
     *
     * @param address_id the address id
     */
    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    /**
     * Gets city.
     *
     * @return the city
     */
    public City getCity() {
        return city;
    }

    /**
     * Sets city.
     *
     * @param city the city
     */
    public void setCity(City city) {
        this.city = city;
    }

    /**
     * Gets state.
     *
     * @return the state
     */
    public State getState() {
        return state;
    }

    /**
     * Sets state.
     *
     * @param state the state
     */
    public void setState(State state) {
        this.state = state;
    }

    /**
     * Gets country.
     *
     * @return the country
     */
    public Country getCountry() {
        return country;
    }

    /**
     * Sets country.
     *
     * @param country the country
     */
    public void setCountry(Country country) {
        this.country = country;
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
}

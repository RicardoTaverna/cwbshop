package br.pucpr.cwbshop.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * The type Product.
 */
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "product")
public class Product implements Serializable {

    @Id
    @GeneratedValue
    private int product_id;

    @Column(name = "id", length = 100)
    private String id;

    @Column(name = "site_id", length = 100)
    private String site_id;

    @Column(length = 100)
    private String title;

    @Column(name = "id_integracao")
    private int id_integracao;

    @Column(length = 50)
    private String subtitle;

    @Column(name = "seller_id", length = 50)
    private String seller_id;

    @Column(name = "price")
    private Double price;

    private Double base_price;

    private Double original_price;

    @Column(length = 10)
    private String currency_id;

    @Column(name = "initial_quantity")
    private int initial_quantity;

    @Column(name = "available_quantity")
    private int available_quantity;

    @Column(name = "start_time")
    private String start_time;

    @Column(name = "stop_time")
    private String stop_time;

    @Column(length = 50, name = "condicao")
    private String condition;

    @Column(length = 100)
    private String permalink;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "product")
    @JsonManagedReference
    @JoinColumn(name = "seller_address")
    private Address seller_address;

    @Column(name = "seller_contact", length = 100)
    private String seller_contact;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "product", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("product")
    private List<Attribute> attributes;

    /**
     * Gets product id.
     *
     * @return the product id
     */
    public int getProduct_id() {
        return product_id;
    }

    /**
     * Sets product id.
     *
     * @param product_id the product id
     */
    public void setProduct_id(int product_id) {
        this.product_id = product_id;
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
     * Gets site id.
     *
     * @return the site id
     */
    public String getSite_id() {
        return site_id;
    }

    /**
     * Sets site id.
     *
     * @param site_id the site id
     */
    public void setSite_id(String site_id) {
        this.site_id = site_id;
    }

    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets id integracao.
     *
     * @return the id integracao
     */
    public int getId_integracao() {
        return id_integracao;
    }

    /**
     * Sets id integracao.
     *
     * @param id_integracao the id integracao
     */
    public void setId_integracao(int id_integracao) {
        this.id_integracao = id_integracao;
    }

    /**
     * Gets subtitle.
     *
     * @return the subtitle
     */
    public String getSubtitle() {
        return subtitle;
    }

    /**
     * Sets subtitle.
     *
     * @param subtitle the subtitle
     */
    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    /**
     * Gets seller id.
     *
     * @return the seller id
     */
    public String getSeller_id() {
        return seller_id;
    }

    /**
     * Sets seller id.
     *
     * @param seller_id the seller id
     */
    public void setSeller_id(String seller_id) {
        this.seller_id = seller_id;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * Gets base price.
     *
     * @return the base price
     */
    public Double getBase_price() {
        return base_price;
    }

    /**
     * Sets base price.
     *
     * @param base_price the base price
     */
    public void setBase_price(Double base_price) {
        this.base_price = base_price;
    }

    /**
     * Gets original price.
     *
     * @return the original price
     */
    public Double getOriginal_price() {
        return original_price;
    }

    /**
     * Sets original price.
     *
     * @param original_price the original price
     */
    public void setOriginal_price(Double original_price) {
        this.original_price = original_price;
    }

    /**
     * Gets currency id.
     *
     * @return the currency id
     */
    public String getCurrency_id() {
        return currency_id;
    }

    /**
     * Sets currency id.
     *
     * @param currency_id the currency id
     */
    public void setCurrency_id(String currency_id) {
        this.currency_id = currency_id;
    }

    /**
     * Gets initial quantity.
     *
     * @return the initial quantity
     */
    public int getInitial_quantity() {
        return initial_quantity;
    }

    /**
     * Sets initial quantity.
     *
     * @param initial_quantity the initial quantity
     */
    public void setInitial_quantity(int initial_quantity) {
        this.initial_quantity = initial_quantity;
    }

    /**
     * Gets available quantity.
     *
     * @return the available quantity
     */
    public int getAvailable_quantity() {
        return available_quantity;
    }

    /**
     * Sets available quantity.
     *
     * @param available_quantity the available quantity
     */
    public void setAvailable_quantity(int available_quantity) {
        this.available_quantity = available_quantity;
    }

    /**
     * Gets start time.
     *
     * @return the start time
     */
    public String getStart_time() {
        return start_time;
    }

    /**
     * Sets start time.
     *
     * @param start_time the start time
     */
    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    /**
     * Gets stop time.
     *
     * @return the stop time
     */
    public String getStop_time() {
        return stop_time;
    }

    /**
     * Sets stop time.
     *
     * @param stop_time the stop time
     */
    public void setStop_time(String stop_time) {
        this.stop_time = stop_time;
    }

    /**
     * Gets condition.
     *
     * @return the condition
     */
    public String getCondition() {
        return condition;
    }

    /**
     * Sets condition.
     *
     * @param condition the condition
     */
    public void setCondition(String condition) {
        this.condition = condition;
    }

    /**
     * Gets permalink.
     *
     * @return the permalink
     */
    public String getPermalink() {
        return permalink;
    }

    /**
     * Sets permalink.
     *
     * @param permalink the permalink
     */
    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    /**
     * Gets seller address.
     *
     * @return the seller address
     */
    public Address getSeller_address() {
        return seller_address;
    }

    /**
     * Sets seller address.
     *
     * @param seller_address the seller address
     */
    public void setSeller_address(Address seller_address) {
        this.seller_address = seller_address;
    }

    /**
     * Gets seller contact.
     *
     * @return the seller contact
     */
    public String getSeller_contact() {
        return seller_contact;
    }

    /**
     * Sets seller contact.
     *
     * @param seller_contact the seller contact
     */
    public void setSeller_contact(String seller_contact) {
        this.seller_contact = seller_contact;
    }

    /**
     * Gets attributes.
     *
     * @return the attributes
     */
    public List<Attribute> getAttributes() {
        return attributes;
    }

    /**
     * Sets attributes.
     *
     * @param attributes the attributes
     */
    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }
}
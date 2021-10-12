package br.pucpr.cwbshop.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "seller")
public class Seller implements Serializable {
    @Id
    @GeneratedValue
    private int id;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "seller")
    @JsonManagedReference
    private Address address;

    @Column(name = "seller_id", length = 50)
    private String seller_id;

    @Column(name = "site_id", length = 100)
    private String site_id;

    @Column(name = "integration_id")
    private int integration_id;

    @Column(name = "seller_contact", length = 100)
    private String seller_contact;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(String seller_id) {
        this.seller_id = seller_id;
    }

    public String getSite_id() {
        return site_id;
    }

    public void setSite_id(String site_id) {
        this.site_id = site_id;
    }

    public int getIntegration_id() {
        return integration_id;
    }

    public void setIntegration_id(int integration_id) {
        this.integration_id = integration_id;
    }

    public String getSeller_contact() {
        return seller_contact;
    }

    public void setSeller_contact(String seller_contact) {
        this.seller_contact = seller_contact;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

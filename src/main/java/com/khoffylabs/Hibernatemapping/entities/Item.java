package com.khoffylabs.Hibernatemapping.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor

public class Item {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long item_id;
    private String designation;
    private Double prix;
    @ManyToOne(fetch = FetchType.EAGER)
    //bidirectional
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    @JsonIgnore
    private Client client;

    public void setClient(Client client) {
        setClient(client, true);
    }

    void setClient(Client client, boolean add) {
        this.client = client;
        if (client != null && add) {
            client.addItem(this, false);
        }
    }
}

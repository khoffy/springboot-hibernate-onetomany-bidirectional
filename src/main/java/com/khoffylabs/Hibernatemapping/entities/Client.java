package com.khoffylabs.Hibernatemapping.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Client {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    private String lastName;
    private String firstName;
    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL)
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        addItem(item, true);
    }

    void addItem(Item item, boolean set) {
        if (item != null) {
            if (getItems().contains(item)) {
                getItems().set(getItems().indexOf(item), item);
            }
            else {
                getItems().add(item);
            }
            if (set) {
                item.setClient(this, false);
            }
        }
        //this.items.add(item);
        //getItems().add(item);
        //item.setClient(this);
    }

    public void removeItem(Item item) {
        getItems().remove(item);
        item.setClient(this);
    }

//    public String toString() {
//        return "Id= " + getId() + " First Name= " +
//                getFirstName() + " Last Name= " + getLastName() +
//                " Items= "+ getItems();
//    }
}

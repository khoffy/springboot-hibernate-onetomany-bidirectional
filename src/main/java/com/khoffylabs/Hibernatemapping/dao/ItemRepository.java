package com.khoffylabs.Hibernatemapping.dao;

import com.khoffylabs.Hibernatemapping.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}

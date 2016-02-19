package io.github.Oleiva.dao;

import io.github.Oleiva.entity.CustomersEntity;
import io.github.Oleiva.entity.ItemsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import io.github.Oleiva.entity.CustomersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemsDao  extends JpaRepository<ItemsEntity, Long> {


}

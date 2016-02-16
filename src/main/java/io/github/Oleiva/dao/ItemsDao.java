package io.github.Oleiva.dao;

import io.github.Oleiva.entity.CustomersEntity;
import io.github.Oleiva.entity.ItemsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import io.github.Oleiva.entity.CustomersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsDao  extends JpaRepository<ItemsEntity, Long> {

//    List<SubscriptionModel> findByIssueId(int issueId);
//
//    SubscriptionModel findByIssueIdAndUserId(int issueId, int userId);
//
//    Collection <SubscriptionModel> findByIssueIdAndIsValid(int issueId, int isValid);



}

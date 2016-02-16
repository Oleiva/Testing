package io.github.Oleiva.dao;

import io.github.Oleiva.entity.CustomersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListOfCustomersDao  extends JpaRepository<CustomersEntity, Integer> {

//    List<SubscriptionModel> findByIssueId(int issueId);
//
//    SubscriptionModel findByIssueIdAndUserId(int issueId, int userId);
//
//    Collection <SubscriptionModel> findByIssueIdAndIsValid(int issueId, int isValid);



}

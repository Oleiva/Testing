package io.github.Oleiva.dao;

import io.github.Oleiva.entity.ListOfCustomersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Collection;
import java.util.List;

public interface ListOfCustomersDao  extends JpaRepository<ListOfCustomersEntity, Integer> {

//    List<SubscriptionModel> findByIssueId(int issueId);
//
//    SubscriptionModel findByIssueIdAndUserId(int issueId, int userId);
//
//    Collection <SubscriptionModel> findByIssueIdAndIsValid(int issueId, int isValid);



}

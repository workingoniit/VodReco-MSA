package com.detail.UserActivityCUD.repository;

import com.detail.UserActivityCUD.domain.UserWish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserWishRepository extends JpaRepository<UserWish, Integer> {
    UserWish findBySubsrAndContentId(String contentId, String subsr);
    List<UserWish> findAllBySubsr(String subsr);
}

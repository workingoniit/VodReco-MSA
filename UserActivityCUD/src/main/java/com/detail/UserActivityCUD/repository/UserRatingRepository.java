package com.detail.UserActivityCUD.repository;

import com.detail.UserActivityCUD.domain.UserRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRatingRepository extends JpaRepository<UserRating, Integer> {

    List<UserRating> findAllByContentId(String contentId);

    List<UserRating> findAllBySubsr(String contentId);

    void deleteByUniqueId(String uniqueId);
}

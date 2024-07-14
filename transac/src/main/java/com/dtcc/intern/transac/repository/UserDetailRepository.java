package com.dtcc.intern.transac.repository;



import com.dtcc.intern.dtcc.model.UserDetailModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailRepository extends JpaRepository<UserDetailModel, Long> {
 UserDetailModel findByEmail(String email);
}

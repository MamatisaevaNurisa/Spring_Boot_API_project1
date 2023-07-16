package repository;

import entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select  u from User u where  upper(u.firstName) like  concat('%',:text,'%')" +
            "or  upper(u.lastName) like  concat('%',:text,'%')" +
            "or  upper(u.role) like  concat('%',:text,'%')" +
            "or  upper(u.studyFormat) like  concat('%',:text,'%')")
    List<User> searchAndPagination(@Param("text")String  text, Pageable pageable);

    Optional<User> findByEmail(String email);
}

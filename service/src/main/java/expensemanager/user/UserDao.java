package expensemanager.user;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserDao extends JpaRepository<User, Long> {

    @Query("select u from User u join fetch u.roles where u.username=:username")
    User findByUsername(@Param("username") String username);
}

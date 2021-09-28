package checkers.repositories;


import checkers.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IUserRepository extends JpaRepository<User,Long> {

}

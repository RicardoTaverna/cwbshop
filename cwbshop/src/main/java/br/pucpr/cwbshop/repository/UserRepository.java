package br.pucpr.cwbshop.repository;

import br.pucpr.cwbshop.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The interface User repository.
 */
@Repository
public interface UserRepository
        extends JpaRepository<User, Long> {

    /**
     * Find user by first name list.
     *
     * @param name the name
     * @return the list
     */
    List<User> findUserByFirstName(String name);

    /**
     * Find by name list.
     *
     * @param name the name
     * @return the list
     */
    @Query("select u from User u where u.firstName=:name")
    List<User> findByName(@Param("name") String name);

    User findFirstByOrderById();

}
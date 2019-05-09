package pers.phd.uaaservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pers.phd.uaaservice.vo.User;

/**
 * @author Pundix055
 * @date 2019-01-19 14:46.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * 根据用户名称查询用户
     * @param username
     * @return
     */
    User findByUsername(String username);
}

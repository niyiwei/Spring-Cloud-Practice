package pers.phd.uaaservice.vo;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

/**
 * 角色
 *
 * @author Pundix055
 * @date 2019-01-19 15:02.
 */
@Data
@Entity
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;

    @Override
    public String getAuthority() {
        return name;
    }
}

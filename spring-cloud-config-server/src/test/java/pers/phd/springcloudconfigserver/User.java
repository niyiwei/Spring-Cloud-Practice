package pers.phd.springcloudconfigserver;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author panhaidong
 * @date 2018-12-13 18:27
 */
@Data
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private int version;
}

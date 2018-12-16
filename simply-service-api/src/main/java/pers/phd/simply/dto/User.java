package pers.phd.simply.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 用户对象
 *
 * @author panhaidong
 * @date 2018-12-16 17:15
 */
@Data
@AllArgsConstructor
public class User {
    /**
     * 姓名.
     */
    private String name;
    /**
     * 年龄.
     */
    private Integer age;

}

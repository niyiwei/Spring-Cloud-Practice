package pers.phd.springcloudconfigserver;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.*;

/**
 * 删除用户测试
 *
 * @author panhaidong
 * @date 2018-12-13 18:27
 */
public class DeleteUserTest {

    private static List<User> userList;

    @BeforeClass
    public static void init() {
        userList = new ArrayList<>(13);
        userList.add(new User(1, "张三", 3));
        userList.add(new User(2, "李四", 3));
        userList.add(new User(3, "王五", 3));
        userList.add(new User(4, "张三", 5));
        userList.add(new User(5, "张三", 3));
        userList.add(new User(6, "张三", 9));
        userList.add(new User(7, "赵六", 2));
        userList.add(new User(8, "张三", 3));
        userList.add(new User(9, "张大", 1));
        userList.add(new User(10, "张飞", 9));
        userList.add(new User(11, "王五", 1));
        userList.add(new User(12, "李四", 6));
        userList.add(new User(13, "张大", 10));
    }

    @Test
    public void deleteTest() {
        // 先把列表排序按姓名和版本号排序
        Collections.sort(userList, (o1, o2) -> {
            if (o1.getName().equals(o2.getName())) {
                return o1.getVersion() == o2.getVersion() ? 0 : o1.getVersion() < o2.getVersion() ? 1 : -1;
            }
            return o1.getName().compareTo(o2.getName());
        });
        printUserList("----------删除前------");
        User tempUser = null;
        // 使用ListIterator遍历列表，效率高并且可以在遍历过程中删除元素
        Iterator<User> userIterator = userList.listIterator();
        User data;
        while (userIterator.hasNext()) {
            data = userIterator.next();
            // 如果tempUser还未赋值表示为第一个元素，跳过，如果不是第一个元素，并且tempUser的名称和当前用户的名词不一致表示为两个不同的人，把当前的赋值给tempUser，然后跳过
            if (null == tempUser || !Objects.equals(tempUser.getName(), data.getName())) {
                tempUser = data;
                continue;
            }
            // 如果名称相等，则删除 以为是根据版本排序了，排在后面的肯定是版本小的
            if (Objects.equals(tempUser.getName(), data.getName())) {
                userIterator.remove();
                continue;
            }
        }
        printUserList("----------删除后------");
    }


    /**
     * 打印UserList里面的值
     *
     * @param currentOperator 当前操作.
     */
    private void printUserList(final String currentOperator) {
        System.out.println(currentOperator + "，当前列表元素数量:" + userList.size());
        Iterator iterator = userList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

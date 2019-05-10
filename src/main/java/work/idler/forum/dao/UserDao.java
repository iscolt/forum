package work.idler.forum.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import work.idler.forum.domain.User;

/**
 * 用户数据访问层
 *
 * @Auther:https://blog.idler.work
 * @Date:2019/5/8
 * @Description:work.idler.forum.dao
 * @version:1.0
 */
@Repository
public interface UserDao {

    /**
     * 根据账户和密码查询
     *
     * @param account
     * @param password
     * @return User
     */
    @Select(value = "select * from t_user where account=#{account} and password=#{password}")
    User findByUserNameAndUserPass(String account, String password);

    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")//加入该注解可以保持对象后，查看对象插入id
    @Insert(value = "insert into t_user (account,password,nickname,avatar,points) " +
            "values (#{account},#{password},#{nickname},#{avatar},#{points})")
    int insertUser(User user);
}

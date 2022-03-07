package com.binbx.mybatix.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.binbx.mybatix.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author bxie
* @description 针对表【t_user】的数据库操作Mapper
* @createDate 2022-03-07 22:20:50
* @Entity com.binbx.mybatix.pojo.User
*/
public interface UserMapper extends BaseMapper<User> {

    int insertSelective(User user);

    int deleteByUidAndUserName(@Param("uid") Long uid, @Param("userName") String userName);

    int updateAgeAndSexByUid(@Param("age") Integer age, @Param("sex") Integer sex, @Param("uid") Long uid);

    List<User> selectAgeAndSexByAgeBetween(@Param("beginAge") Integer beginAge, @Param("endAge") Integer endAge);

    List<User> selectAllOrderByAgeDesc();
}





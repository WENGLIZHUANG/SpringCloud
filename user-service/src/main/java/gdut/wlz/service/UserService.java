package gdut.wlz.service;

import gdut.wlz.domain.User;
import gdut.wlz.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: BUG_BOY
 * DATE:2020/11/28  17:28
 */
@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    public User queryById(Long id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }
}

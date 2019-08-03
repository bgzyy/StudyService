package io.choerodon.exam.app.service.impl;

import io.choerodon.exam.app.service.UserService;
import io.choerodon.exam.infa.dto.UserDTO;
import io.choerodon.exam.infa.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
 * Created by zhao'yin
 * Date 2019/8/3.
 */
@Service
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }


    @Override
    public void insertUser(UserDTO userDTO) {
        userMapper.insert(userDTO);
    }
}
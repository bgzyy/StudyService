package io.choerodon.exam.api.vo;

import io.choerodon.exam.infa.dto.UserDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * Created by zhao'yin
 * Date 2019/8/3.
 */
@Data
@NoArgsConstructor
@ToString
public class UserResult {
    private List<UserDTO> list;
}
package io.choerodon.exam.infa.mapper;

import io.choerodon.exam.infa.dto.ProjectDTO;
import io.choerodon.mybatis.common.Mapper;
import tk.mybatis.mapper.additional.insert.InsertListMapper;

/**
 * Created by zhao'yin
 * Date 2019/8/3.
 */
public interface ProjectMapper extends Mapper<ProjectDTO>, InsertListMapper<ProjectDTO> {
}

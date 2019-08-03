package io.choerodon.exam.app.service;

import io.choerodon.exam.infa.dto.ProjectDTO;

import java.util.List;

/**
 * Created by zhao'yin
 * Date 2019/8/3.
 */
public interface ProjectTypeService {
    void insertProjectList(List<ProjectDTO> projectDTOList);

    List<ProjectDTO> getProjectList();
}

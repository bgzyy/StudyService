package io.choerodon.exam.app.service.impl;

import io.choerodon.exam.app.service.ProjectTypeService;
import io.choerodon.exam.infa.dto.ProjectDTO;
import io.choerodon.exam.infa.mapper.ProjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhao'yin
 * Date 2019/8/3.
 */
@Service
public class ProjectServiceImpl implements ProjectTypeService{

    private ProjectMapper projectMapper;

    public ProjectServiceImpl(ProjectMapper projectMapper) {
        this.projectMapper = projectMapper;
    }

    @Override
    public void insertProjectList(List<ProjectDTO> projectDTOList) {
        projectMapper.insertList(projectDTOList);
    }

    @Override
    public List<ProjectDTO> getProjectList() {
        return projectMapper.selectAll();
    }
}
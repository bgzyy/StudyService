package io.choerodon.exam.api.v1.controller;

import com.github.pagehelper.PageHelper;
import io.choerodon.base.annotation.Permission;
import io.choerodon.base.enums.ResourceType;
import io.choerodon.exam.app.service.ProjectTypeService;
import io.choerodon.exam.infa.dto.ProjectDTO;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by zhao'yin
 * Date 2019/8/3.
 */
@RestController
@RequestMapping(value = "/v1")
public class ProjectController {

    private ProjectTypeService projectTypeService;
    private Logger logger = LoggerFactory.getLogger(getClass());

    public ProjectController(ProjectTypeService projectTypeService) {
        this.projectTypeService = projectTypeService;
    }

    @GetMapping("/projects/num/{pageNum}/size/{pageSize}")
    @Permission(type = ResourceType.SITE)
    @ApiOperation(value = "分页查询返回 Project")
    public List<ProjectDTO> pageQueryProject(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<ProjectDTO> projectList = projectTypeService.getProjectList();
        logger.info("======================== 查出所有 Project 中第 " + pageNum + " 页的信息，每页显示 " + pageSize + " 条信息 ========================");
        return projectList;
    }
}

package io.choerodon.exam.api.v1.controller;

import io.choerodon.base.annotation.Permission;
import io.choerodon.base.enums.ResourceType;
import io.choerodon.exam.api.vo.UserResult;
import io.choerodon.exam.app.service.OrganizationService;
import io.choerodon.exam.app.service.ProjectTypeService;
import io.choerodon.exam.app.service.UserService;
import io.choerodon.exam.infa.dto.OrganizationDTO;
import io.choerodon.exam.infa.dto.ProjectDTO;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by zhao'yin
 * Date 2019/8/3.
 */
@RestController
@RequestMapping(value = "/v1")
public class OrganizationController {

    private OrganizationService organizationService;
    private ProjectTypeService projectTypeService;
    private UserService userService;
    private Logger logger = LoggerFactory.getLogger(getClass());

    public OrganizationController(OrganizationService organizationService, ProjectTypeService projectTypeService, UserService userService) {
        this.organizationService = organizationService;
        this.projectTypeService = projectTypeService;
        this.userService = userService;
    }

    @GetMapping("/organizations/{organization_id}")
    @Permission(type = ResourceType.SITE)
    @ApiOperation(value = "调用 iam 接口查询 organization，并插入数据库")
    public OrganizationDTO queryOrganizationById(@PathVariable("organization_id") Long id) {
        OrganizationDTO organization = organizationService.getOrganizationById(id);
        organizationService.insertOrganization(organization);
        logger.info("========================" + "调用接口查询出 id 为 " + id + " 的组织信息，并将其插入 fd_organization 数据表！" + "========================");

        List<ProjectDTO> projects = organization.getProjects();
        projectTypeService.insertProjectList(projects);
        logger.info("========================" + "将上述查出的组织信息中所有 Project 信息插入 fd_project 数据表！" + "========================");

        return organization;
    }

    @GetMapping("/organizations/{organization_id}/users")
    @Permission(type = ResourceType.SITE)
    @ApiOperation(value = "调用 iam 接口查询 user，并将返回结果插入数据表")
    public UserResult queryUserList(@PathVariable("organization_id") Long organization_id, @RequestParam("id") Long id) {
        UserResult userResult = organizationService.getUserResult(organization_id, id);
        userService.insertUser(userResult.getList().get(0));
        logger.info("========================" + "调用接口查出 id 为 " + id + " 的 user 信息，且组织 id 为" + organization_id + "========================");
        return userResult;
    }
}
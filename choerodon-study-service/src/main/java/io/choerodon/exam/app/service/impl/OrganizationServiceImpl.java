package io.choerodon.exam.app.service.impl;

import io.choerodon.exam.api.vo.UserResult;
import io.choerodon.exam.app.service.OrganizationService;
import io.choerodon.exam.infa.dto.OrganizationDTO;
import io.choerodon.exam.infa.feign.OrganizationFeignClient;
import io.choerodon.exam.infa.mapper.OrganizationMapper;
import org.springframework.stereotype.Service;

/**
 * Created by zhao'yin
 * Date 2019/8/3.
 */
@Service
public class OrganizationServiceImpl implements OrganizationService {

    private OrganizationFeignClient organizationFeignClient;
    private OrganizationMapper organizationMapper;

    public OrganizationServiceImpl(OrganizationFeignClient organizationFeignClient, OrganizationMapper organizationMapper) {
        this.organizationFeignClient = organizationFeignClient;
        this.organizationMapper = organizationMapper;
    }

    @Override
    public OrganizationDTO getOrganizationById(Long id) {
        OrganizationDTO organization = organizationFeignClient.getOrganizationById(id);
        return organization;
    }

    @Override
    public UserResult getUserResult(Long organizationId, Long id) {
        return organizationFeignClient.getUserResult(organizationId, id);
    }


    @Override
    public void insertOrganization(OrganizationDTO organizationDTO) {
        organizationMapper.insert(organizationDTO);
    }
}

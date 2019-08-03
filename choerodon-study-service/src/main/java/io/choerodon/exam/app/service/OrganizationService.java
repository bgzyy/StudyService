package io.choerodon.exam.app.service;

import io.choerodon.exam.api.vo.UserResult;
import io.choerodon.exam.infa.dto.OrganizationDTO;

/**
 * Created by zhao'yin
 * Date 2019/8/3.
 */
public interface OrganizationService {

    OrganizationDTO getOrganizationById(Long id);

    UserResult getUserResult(Long organizationId, Long id);

    void insertOrganization(OrganizationDTO organizationDTO);
}
package io.choerodon.exam.infa.feign;

import io.choerodon.exam.api.vo.UserResult;
import io.choerodon.exam.infa.dto.OrganizationDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by zhao'yin
 * Date 2019/8/3.
 */
@FeignClient(value = "IAM-SERVICE")
public interface OrganizationFeignClient {

    @GetMapping("/v1/organizations/{organization_id}")
    OrganizationDTO getOrganizationById(@PathVariable("organization_id") Long id);

    @GetMapping("/v1/organizations/{organization_id}/users")
    UserResult getUserResult(@PathVariable("organization_id") Long organizationId, @RequestParam("id") Long id);
}
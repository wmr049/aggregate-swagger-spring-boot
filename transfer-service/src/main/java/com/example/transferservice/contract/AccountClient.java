package com.example.transferservice.contract;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("account-service")
public interface AccountClient {

	@RequestMapping(method = RequestMethod.GET, value = "/accounts/{accountId}")
	Account getAccount(@PathVariable("accountId") String accountId);

}

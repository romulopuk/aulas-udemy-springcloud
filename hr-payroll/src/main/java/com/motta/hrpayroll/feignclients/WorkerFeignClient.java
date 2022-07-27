package com.motta.hrpayroll.feignclients;

import com.motta.hrpayroll.entities.Worker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@FeignClient(name = "hr-worker", path = "/workers")
public interface WorkerFeignClient {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    ResponseEntity<Worker> findById(@PathVariable Long id);
}

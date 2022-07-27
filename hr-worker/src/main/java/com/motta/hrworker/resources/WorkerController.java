package com.motta.hrworker.resources;

import com.motta.hrworker.entities.Worker;
import com.motta.hrworker.repositories.WorkerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/workers")
public class WorkerController {

    private static Logger logger = LoggerFactory.getLogger(WorkerController.class);

    @Autowired
    private Environment env;

    @Autowired
    private WorkerRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Worker>> findAll() {
        List<Worker> list = repository.findAll();
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Worker> findById(@PathVariable Long id) {

        logger.info("PORT = " + env.getProperty("local.server.port"));

        Worker worker = repository.findById(id).get();
        return ResponseEntity.ok().body(worker);
    }
}

package dev.jlucasbs.java_with_docker_hello_world.controller;

import dev.jlucasbs.java_with_docker_hello_world.environment.InstanceInformationServer;
import dev.jlucasbs.java_with_docker_hello_world.model.HelloDocker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DockerController {

    Logger logger = LoggerFactory.getLogger(DockerController.class);

    @Autowired
    private InstanceInformationServer service;

    @GetMapping(path = "/")
    public String imUpAndRunning() {
        return "{healthy: true}";
    }

    @RequestMapping("/hello-docker")
    public HelloDocker greeting() {

        logger.info("Endpoint /hello-docker is called!");

//        var hostName = System.getenv("HOSTNAME");

        return new HelloDocker(
                "Hello Docker",
                service.retrieveInstanceInfo()
        );
    }
}

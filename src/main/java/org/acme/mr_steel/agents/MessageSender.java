package org.acme.mr_steel.agents;


import io.quarkus.runtime.Startup;
import io.vertx.core.Vertx;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Startup
@Singleton
public class MessageSender {

    @Inject
    Vertx vertx;

    @PostConstruct
    void init() {
        vertx.setPeriodic(2000, id -> {
           vertx.eventBus().publish("chat", "Hello from backend at " + System.currentTimeMillis());
            System.out.println("Control log on terminal ...");
        });
    }
}

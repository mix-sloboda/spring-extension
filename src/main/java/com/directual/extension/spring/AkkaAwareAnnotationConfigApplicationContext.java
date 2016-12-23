package com.directual.extension.spring;

import akka.actor.ExtendedActorSystem;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created on 23/12/2016.
 */
public class AkkaAwareAnnotationConfigApplicationContext extends AnnotationConfigApplicationContext {

    public AkkaAwareAnnotationConfigApplicationContext(ExtendedActorSystem actorSystem, String... basePackages) {
        super();
        super.setClassLoader(actorSystem.dynamicAccess().classLoader());
        this.getBeanFactory().registerSingleton("ActorSystem", actorSystem);
        scan(basePackages);
        refresh();
    }
}

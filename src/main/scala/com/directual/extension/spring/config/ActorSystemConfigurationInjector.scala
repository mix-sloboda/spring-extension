package com.directual.extension.spring.config

import akka.actor.ActorSystem
import com.directual.extension.spring.SpringCtxExt
import com.typesafe.config.{Config, ConfigFactory}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean

/**
  * Created on 07/12/2016.
  */

trait ActorSystemConfigurationInjector {

  @Autowired
  implicit var ctx: ApplicationContext = _

  /*@Bean
  def actorSystem(config:Config = ConfigFactory.load()) = {
    val system = ActorSystem(config.getString("directual.akking.cluster.name"), config)
    SpringCtxExt(system)
    system
  }

  @Bean
  def config():Config*/
}

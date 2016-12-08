package com.directual.extension.spring.config

import com.typesafe.config.{Config, ConfigFactory}
import org.springframework.context.annotation.{Bean, ComponentScan, Configuration}

/**
  * Created on 08/12/2016.
  */

@Configuration
@ComponentScan(
  Array(
    "com.directual",
    "com.directual.service",
    "com.directual.service.actors"
  )
)
class DefaultAppConfigurator extends ActorSystemConfigurationInjector {

}

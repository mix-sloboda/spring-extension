package com.directual

import akka.actor.{Actor, ActorSystem, Props}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Lazy
import org.springframework.stereotype.Component


/**
  * Created on 23/12/2016.
  */

@Component
class Foo @Autowired()(val akkaSystem:ActorSystem) {
  akkaSystem.log.info("FUFUFUFUFFU")
  akkaSystem.actorOf(Props(new Actor {
    override def receive: Receive = {
      case msg => println(msg)
    }
  })) ! "Msg!"
}

package com.directual

import akka.actor.Actor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

/**
  * Created on 23/12/2016.
  */
@Component("testActor")
@Scope("prototype")
class TestActor @Autowired() (val service:Service) extends Actor {
  override def receive: Receive = {
    case msg =>
      println(self.path.elements.last +  " RECEIVE " +  msg + " " + service.doIt())
      //sender() ! service.doIt()
  }
}

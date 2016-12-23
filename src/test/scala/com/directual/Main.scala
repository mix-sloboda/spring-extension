package com.directual

import akka.actor.{ActorSystem, Props}
import com.directual.extension.spring.SpringCtxExt

/**
  * Created on 23/12/2016.
  */
object Main extends App {
  implicit val system = ActorSystem()

  try {
    println(system == SpringCtxExt(system).springContext.getBean(classOf[ActorSystem]))
    println(SpringCtxExt(system).springContext.getBean("ActorSystem"))
    println(SpringCtxExt(system).springContext.getBean(classOf[Foo]))

    SpringCtxExt(system).actorOf("testActor") ! "Message"

  } catch {
    case e:Throwable =>
      e.printStackTrace()
  }
  Thread.sleep(2000)
  system.terminate()
}

package com.directual

import akka.actor.ActorSystem
import akka.util.Timeout
import com.directual.extension.spring.SpringCtxExt

/**
  * Created on 23/12/2016.
  */
object Main extends App {
  implicit val system = ActorSystem()
  import concurrent.duration._
  implicit val timeout:Timeout = 2.second

  try {

   // println(system == SpringCtxExt(system).springContext.getBean(classOf[ActorSystem]))
   // println(SpringCtxExt(system).springContext.getBean("ActorSystem"))
    println(SpringCtxExt(system).springContext.getBean(classOf[Foo]))

   // SpringCtxExt(system).actorOf("testActor") ask ("Message") onComplete {
   //   result => println(result)
   // }

  } catch {
    case e:Throwable =>
      e.printStackTrace()
  }
  Thread.sleep(2000)
  system.terminate()
}

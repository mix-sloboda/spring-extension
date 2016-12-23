package com.directual.extension.spring

import akka.actor.{ActorSystem, Extension, Props, _}
import org.springframework.context.ApplicationContext

import scala.collection.JavaConverters._

/**
 * The Extension implementation.
 */


class SpringCtxExtImpl(val system:ExtendedActorSystem) extends Extension {

  def packagesToScan = system.settings.config.getStringList("spring-context.extension.packages-to-scan").asScala

  val springContext = new AkkaAwareAnnotationConfigApplicationContext(system, packagesToScan:_*)

  system.log.info("Created SpringContext Extension")

  def props(actorBeanName: String): Props = Props(classOf[ActorProducer], springContext, actorBeanName)

  def actorOf(actorBeanName: String):ActorRef = actorOf(actorBeanName, actorBeanName)

  def actorOf(actorBeanName: String, actorName:String):ActorRef = system.actorOf(props(actorBeanName), actorName)

}

object SpringCtxExt extends AbstractExtensionId[SpringCtxExtImpl] with ExtensionIdProvider {

  override def createExtension(system: ExtendedActorSystem) = new SpringCtxExtImpl(system)

  override def lookup() = SpringCtxExt

  override def get(system: ActorSystem): SpringCtxExtImpl = super.get(system)
}


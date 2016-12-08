package com.directual.extension.spring

import akka.actor.{ActorSystem, Extension, Props, _}
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import collection.JavaConverters._

/**
 * The Extension implementation.
 */
class SpringCtxExtImpl(val system:ExtendedActorSystem) extends Extension {

  private[this] val packagesToScan = system.settings.config.getStringList("spring-context.extension.packages-to-scan").asScala
  private[this] val applicationContext = new AnnotationConfigApplicationContext(packagesToScan:_*) {
    override def setClassLoader(classLoader: ClassLoader): Unit = system.dynamicAccess.classLoader
  }

  system.log.info("Created SpringContext Extension")

  def springContext: AnnotationConfigApplicationContext = applicationContext

  def props(actorBeanName: String): Props = Props(classOf[ActorProducer], applicationContext, actorBeanName)

  def actorOf(actorBeanName: String):ActorRef = actorOf(actorBeanName, actorBeanName)

  def actorOf(actorBeanName: String, actorName:String):ActorRef = system.actorOf(props(actorBeanName), actorName)

}

object SpringCtxExt extends AbstractExtensionId[SpringCtxExtImpl] with ExtensionIdProvider {

  override def createExtension(system: ExtendedActorSystem) = new SpringCtxExtImpl(system)

  override def lookup() = SpringCtxExt

  override def get(system: ActorSystem): SpringCtxExtImpl = super.get(system)
}


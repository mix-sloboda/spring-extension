package com.directual.extension.spring

import akka.actor.{ActorSystem, Extension, Props, _}
import org.springframework.context.ApplicationContext
/**
 * The Extension implementation.
 */
class SpringCtxExtImpl(system:ExtendedActorSystem) extends Extension {

  private[this] var applicationContext:ApplicationContext = _

  private[spring] def init(applicationContext: ApplicationContext):SpringCtxExtImpl = {
    this.applicationContext = applicationContext
    this
  }

  def springContext = applicationContext

  def props(actorBeanName: String): Props =
    Props(classOf[ActorProducer], applicationContext, actorBeanName)

  def actorOf(actorBeanName: String):ActorRef = system.actorOf(props(actorBeanName), actorBeanName)

}

object SpringCtxExt extends AbstractExtensionId[SpringCtxExtImpl] with ExtensionIdProvider {

  override def createExtension(system: ExtendedActorSystem) = new SpringCtxExtImpl(system)

  override def lookup() = SpringCtxExt

  override def get(system: ActorSystem): SpringCtxExtImpl = super.get(system)
}


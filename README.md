# Scala Akka Extension

## Usage

* clone repository
* sbt publishLocal
* add as dependency in SBT project (example: https://github.com/mix-sloboda/service-prototype.git)
* spring-context.extension.packages-to-scan = ["com.example.service"]

```scala 
   ... from within Actor { 
          val actorRef = 
            context.actorOf(
              SpringCtxExt(context.system).props("beanActorName")) 
            }
       }   
````
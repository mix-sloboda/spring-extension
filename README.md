# Scala Akka Extension

## Usage

* spring-context.extension.packages-to-scan = ["com.example.service"]

```scala 
   ... from within Actor { 
          val actorRef = 
            context.actorOf(
              SpringCtxExt(context.system).props("beanActorName")) 
            }
       }   
````
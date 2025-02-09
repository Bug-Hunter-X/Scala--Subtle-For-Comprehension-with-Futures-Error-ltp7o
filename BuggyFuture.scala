```scala
import scala.concurrent.{ExecutionContext, Future}

class MyActor extends Actor {
  implicit val ec: ExecutionContext = ExecutionContext.global

  def receive: Receive = {
    case "start" =>
      val future1: Future[Int] = Future {  // This future returns Unit
        println("future1")
        1
      }

      val future2: Future[String] = Future { //This future returns String
        println("future2")
        "hello"
      }

      val combinedFuture = for {
        result1 <- future1
        result2 <- future2
      } yield (result1, result2)

      combinedFuture.onComplete {
        case Success((a, b)) => println(s"Success: $a, $b")
        case Failure(exception) => println(s"Failure: ${exception.getMessage}")
      }
  }
}
```
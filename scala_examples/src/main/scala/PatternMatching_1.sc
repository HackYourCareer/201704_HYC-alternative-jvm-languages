import scala.annotation.tailrec

// Factorial
def fact(n : Int) : Int = {
  n match {
    case _ if n < 0 ⇒ -1
    case 0 | 1 ⇒ 1
    case _ ⇒ n * fact(n - 1)
  }
}

// Sum of a list
def sum(list: List[Int]): Int = {
  list match {
    case Nil ⇒ 0
    case head :: tail ⇒ head + sum(tail)
  }
}

// Sum of a list : more memory efficient version
def sumTailrec(list: List[Int]): Int = {

  @tailrec
  def internal(list: List[Int], acc: Int): Int = {
    list match {
      case Nil ⇒ 0
      case head :: tail ⇒ internal(tail, acc + head)
    }
  }

  internal(list, 0)
}

// How I would sum only distinct, even numbers in a Scala collection?
val list = List(1,2,2,3,4)
val s = list.distinct.filter(_% 2 == 0).sum
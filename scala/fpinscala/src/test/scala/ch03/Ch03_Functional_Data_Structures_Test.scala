package ch03

import org.scalatest.FreeSpec
import ch03.Ch03_Functional_Data_Structures._
import ch03.Ch03_Functional_Data_Structures.List._

/**
  * Created by EdwinT on 13/06/2017.
  */
class Ch03_Functional_Data_Structures_Test extends FreeSpec{
  "Ex 3.1 What is the result" in {
    val x = List(1,2,3,4,5) match {
      case Cons(x, Cons(2, Cons(4, _))) => x
      case Nil => 42
      case Cons(x, Cons(y, Cons(3, Cons(4, _)))) => x + y
      case Cons(h, t) => h + sum(t)
      case _ => 101
    }

    assert(x == 3)
  }

  "Ex 3.2 tail function"  in {
    assert(tail(List(1,2,3,4)) == List(2,3,4))
  }

  "Ex 3.3 setHead function"  in {
    assert(setHead(List(1,2,3,4), 0) == List(0,2,3,4))
  }

  "Ex 3.4 drop function"  in {
    assert(drop(List(1,2,3,4),2) == List(3,4))
  }

  "Ex 3.5 dropWhile function"  in {
    assert(dropWhile(List(1,2,3,4), (x:Int) => x < 3) == List(3,4))
  }

  "Ex 3.6 init function"  in {
    assert(init(List(1,2,3,4)) == List(1,2,3))
  }

  "Ex 3.9 length of a list using foldRight"  in {
    assert(length(Nil) == 0)
    assert(length(List(1,2,3)) == 3)
  }

  "Ex 3.10 foldLeft" in {
    assert(foldLeft(Nil:List[Int], 0)((a,b)=> a + b) == 0)
    assert(foldLeft(List(1,2,3), 0)((a,b)=> a + b) == 6)
  }

  "Ex. 3.11 sum, product and length using foldLeft" in{
    assert(sumL(Nil) == 0)
    assert(sum(List(1,2,3)) == 6)

    assert(productL(Nil) == 1)
    assert(productL(List(2,2,3)) == 12)

    assert(lengthL(Nil) == 0)
    assert(lengthL(List(2,2,3)) == 3)
  }
}

/*
The sequence of triangle numbers is generated by adding the natural numbers. So the 7th triangle number would be 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28. The first ten terms would be:

1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...

Let us list the factors of the first seven triangle numbers:

 1: 1
 3: 1,3
 6: 1,2,3,6
10: 1,2,5,10
15: 1,3,5,15
21: 1,3,7,21
28: 1,2,4,7,14,28
We can see that 28 is the first triangle number to have over five divisors.

What is the value of the first triangle number to have over five hundred divisors?
 */
import Math.sqrt

object Tdiv {
  def findDivisors(num: Int): List[Int] = {
    var divs = List(): List[Int]
    for (i <- (1 to sqrt(num).toInt).toList) {
      if (num % i == 0) divs = divs :+ i
    }
    if (num % 2 == 0) {
      divs :+ (num/2) :+ num
    } else {
      divs :+ num
    }
  }

  def main(): Int = {
    def genTriNum(n: Int): Int = {
      (1 to n).foldLeft(0)((x,y) => x+y)
    }

    def findTarget(n:Int): Int = {
      val num = genTriNum(n)
      val length = findDivisors(num).length
      length match {
        case l if l >= 500 => num
        case l => findTarget(n+1)
      }
    }
    findTarget(1)
  }
}

/**
 * Created by francescousai on 23/05/16.
 */
import scala.collection.JavaConversions._

// you can write to stdout for debugging purposes, e.g.
// println("this is a debug message")

object Solution {
    def solution(A: Array[Int]): Int = {
        val sum : Long = A.sum
        val B = A.toList  // my bad I did not understand how pattern matching for Arrays work
        
        def innerSolution( l : List[Int], leftSum : Int, index : Int ) : Int = {
            l match{
                case Nil => { -1 }
                case x :: xs => {
                    val rightSum = sum - leftSum - x
                    if( rightSum == leftSum ) index
                    else innerSolution( xs, leftSum + x, (index + 1))
                }
            }            
        }        
        innerSolution( B, 0, 0 )
    }
}
import breeze.linalg._

val matrix1 = DenseMatrix.ones[Int](4,4)
val matrix2 = DenseMatrix.ones[Int](4,4)
val matrix3 = matrix2 * 3
val matrix4 = (matrix1 + matrix2) * matrix3
val diagonal = diag(DenseVector(1,2,3))

import java.io.File
import java.net.URL
import scala.sys.process._

val res = "ls" .!!
val currentDir = "pwd" .!!
val command = ("touch file1.txt" #| "cp file1.txt file2.txt" #| "ls" #| "grep file") .!!

val r = new URL("http://www.scala.org") #> new File("/Users/i326211/test_scala.htlm") !

val fileContents = "cat /Users/i326211/test_scala.htlm" .!!


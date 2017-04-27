class Complex(val im: Double, val re: Double){
  def +(other: Complex) : Complex = {
    Complex(this.im + other.im, this.re + other.re)
  }

  def -(other: Complex) : Complex = {
    Complex(im - other.im, re - other.re)
  }

  def *(other: Complex) : Complex = {
    val newRe = re * other.re - im * other.im
    val newIm = re * other.im + im * other.re

    Complex(newIm, newRe)
  }
}

object Complex{
  def apply(im: Double, re: Double): Complex = {
    new Complex(im, re)
  }
}

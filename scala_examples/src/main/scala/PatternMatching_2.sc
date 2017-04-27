
def copy(src: String, dst: String) = {
  // do the work
  println(s"Copy $src to $dst")
}

// source <path> target <path>
def parseParams(args: List[String]) = {
  args match {
    case Nil ⇒
      println("Empty list")
    case List("source", src, "target", dst) if (src != dst) ⇒
      copy(src, dst)
    case List("source", _, "target", _) ⇒
      println("Source must not equal destination")
    case _ ⇒
      println("Expected arguments: source <source_path> target <target_path>")
  }
}

parseParams(List("source", "~/source_path", "target", "~/target_path"))









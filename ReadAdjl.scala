import scala.io.Source

object ReadAdjl extends App {
  val sources = Source.fromFile(args(0))

  println("init:" + args(0))
  for (line <- sources.getLines) {
    if (line.length <= 0) { println('\t' + line) }
    else if (line(0) == '#') { println('\t' + line) }
    else if (line(0) == '=') { println('\t' + line) }
    else {
      println('\t' + line + " --- processing ...")
      val pp = line.split('#')(0).split(':') // remove comment at line end, and split at ':'
      val prev = pp(0).trim.split('~')
      val post = pp(1).trim.split('~')

      val prevArr = if (prev.length == 1) {Integer.parseInt(prev(0).trim) to Integer.parseInt(prev(0).trim)}
                    else {Integer.parseInt(prev(0).trim) to Integer.parseInt(prev(1).trim)}

      val postArr = if (post.length == 1) {Integer.parseInt(post(0).trim) to Integer.parseInt(post(0).trim)}
                    else {Integer.parseInt(post(0).trim) to Integer.parseInt(post(1).trim)}

      for (i <- prevArr; j <- postArr) {println("\t    ("+i+", "+j+") = 1")}
    }
  }
  println("done!")
}

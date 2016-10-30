import neuron.NeuralNet

import scala.collection.mutable.{ArrayBuffer, ListBuffer}
import scala.util.Random

object Example {
  def main(args: Array[String]): Unit = {

    // has 2 input neurons, 4 hidden, and one output
    val typology = Array(2, 4, 1)
    val net = new NeuralNet(typology)

    // test data for and operator
    val allInputs = ListBuffer[Array[Double]]()
    val allTargets = ListBuffer[Array[Double]]()
    (1 to 10000).foreach{ i =>
      // generate 0 or 1
      val a = Random.nextInt(2)
      val b = Random.nextInt(2)
      // AND principle
      val target = if (a == b && a != 0) 1.0 else 0.0

      allInputs.append(Array(a, b))
      allTargets.append(Array(target))
    }

    // while there is training data
    var trainingIteration = 0
    for (i <- 0 until allInputs.length) {
      //println(s"Pass: $trainingIteration")
      val inputs = allInputs(i)
      val target = allTargets(i)

      trainingIteration += 1

      net.feedForward(inputs)
      val results = net.getResults()
      net.backProp(target)
    }

    // final test!!
    val inputs1 = Array(0.0, 1.0)
    net.feedForward(inputs1)
    net.getResults.foreach(o => println(f"$o%1.5f"))

    val inputs2 = Array(1.0, 1.0)
    net.feedForward(inputs2)
    net.getResults.foreach(o => println(f"$o%1.5f"))
  }
}

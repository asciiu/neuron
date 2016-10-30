package neuron

import scala.collection.mutable.ArrayBuffer

object Example {
  def main(args: Array[String]): Unit = {

    val inputs =  ArrayBuffer[Double]()
    val targets =  ArrayBuffer[Double]()
    val results = ArrayBuffer[Double]()

    // has three layers with 3, 2, & 1 neuron per layer
    val typology = Array(3, 2, 1)
    val net = new NeuralNet(typology)


    // TODO we want to try a typology of ? 9 3
    // three output values with values of
    // first: 1.0 (buy) or 0.0 (sell)
    // second: amount to buy
    // third: the buy price

    // possible inputs
    // volume, delta volume, emas, candle price delta, percent increase, delta ema values, current price
  }
}

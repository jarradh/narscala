package com.narscala.logic.grammar

import com.narscala.Defaults

// TODO: TruthFactory, minimize memory usage of Truth values

object TruthDefaults {
    val frequency:  Double = Defaults.config.getDouble("narscala.defaults.frequency")
    val confidence: Double = Defaults.config.getDouble("narscala.defaults.confidence")
    val k: Double = Defaults.config.getDouble("narscala.defaults.k")
}

case class Truth(   frequency:  Double = TruthDefaults.frequency,
                    confidence: Option[Double] = Some(TruthDefaults.confidence)
    ) {
    require(frequency <= 1.0, "Frequency > 1.0 at " + frequency)
    require(frequency >= 0.0, "Frequency < 0.0 at " + frequency)
    require(confidence.getOrElse(TruthDefaults.confidence) <= 1.0, "Confidence > 1.0 at " + confidence.getOrElse(TruthDefaults.confidence))
    require(confidence.getOrElse(TruthDefaults.confidence) >= 0.0, "Confidence < 0.0 at " + confidence.getOrElse(TruthDefaults.confidence))
}
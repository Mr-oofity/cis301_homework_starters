// #Sireum #Logika

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.pred._
import org.sireum.justification.natded.prop._

//Complete the following natural deduction proof.
//When you are finished, do a Logika check.
//Your file should say "Logika verified".


//∀ x (candy(x) → sweet(x)), candy(Reeses) ⊢ ∃ x sweet(x)

@pure def proof4[T](candy: T=>B @pure, sweet: T=>B @pure, Reeses: T): Unit = {
  Deduce(
    (
      ∀((x: T) => (candy(x) __>: sweet(x))),
      candy(Reeses)
    )
      |-
    (
       ∃((x: T) => sweet(x))
    )
    Proof(
      1 (∀((x: T) => (candy(x) __>: sweet(x)))) by Premise,
      2 (candy(Reeses)) by Premise,

      3 (candy(Reeses) __>: sweet(Reeses)) by AllE[T](1),
      4 (sweet(Reeses)) by ImplyE(3, 2),

      5 ( ∃((x: T) => sweet(x)) ) by ExistsI[T](4)
    )
  )
}

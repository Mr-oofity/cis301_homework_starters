// #Sireum #Logika

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.pred._
import org.sireum.justification.natded.prop._

//Complete the following natural deduction proof.
//When you are finished, do a Logika check.
//Your file should say "Logika verified".


//∀ x (candy(x) → sweet(x)), ∀ x (sweet(x) → hasSugar(x)) ⊢ ∀ x (¬hasSugar(x) __>: ¬candy(x))

@pure def proof3[T](candy: T=>B @pure, sweet: T=>B @pure, hasSugar: T=>B @pure): Unit = {
  Deduce(
    (
      ∀((x: T) => (candy(x) __>: sweet(x))),
      ∀((x: T) => (sweet(x) __>: hasSugar(x)))
    )
      |-
    (
      ∀((x: T) => (!hasSugar(x) __>: !candy(x))),
    )
    Proof(
      //COMPLETE PROOF HERE


    )
  )
}

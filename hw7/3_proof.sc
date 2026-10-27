// #Sireum #Logika

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.pred._
import org.sireum.justification.natded.prop._

//Complete the following natural deduction proof.
//When you are finished, run a Logika check -- your file should say "Logika verified".


// ∀ x (P(x) → ¬Q(x)) ⊢ ¬(∃ x (P(x) ∧ Q(x)))

@pure def proof3[T](P: T=>B @pure, Q: T=>B @pure): Unit = {
  Deduce(
    (
      ∀((x: T) => (P(x) __>: !Q(x)))
      )
      |-
      (
        !(∃((x: T) => (P(x) & Q(x))))
      )
      Proof(
        //COMPLETE PROOF HERE

    )
  )
}

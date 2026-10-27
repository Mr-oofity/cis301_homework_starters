// #Sireum #Logika
import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.pred._
import org.sireum.justification.natded.prop._

//Complete the following natural deduction proof.
//When you are finished, run a Logika check -- your file should say "Logika verified".


//∃ x (ksu(x) ∨ ku(x)), ¬(∃ x ku(x)) ⊢ ∃ x ksu(x)

@pure def proof1[T](ksu: T=>B @pure, ku: T=>B @pure): Unit = {
  Deduce(
    (
      ∃((x: T) => (ksu(x) | ku(x))),
      !(∃((x: T) => ku(x)))
    )
      |-
    (
      ∃((x: T) => ksu(x))
    )
    Proof(
        //COMPLETE PROOF HERE

    )
  )
}

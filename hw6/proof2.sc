// #Sireum #Logika

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.pred._
import org.sireum.justification.natded.prop._

//Complete the following natural deduction proof.
//When you are finished, do a Logika check.
//Your file should say "Logika verified".

//∀ n (child(n) ∨ adult(n)), ∀ n (¬adult(n)) ⊢ ∀ n (child(n))

@pure def proof2[T](child: T=>B @pure, adult: T=>B @pure): Unit = {
  Deduce(
    (
        ∀((n: T) => (child(n) | adult(n))),
        ∀((n: T) => !adult(n))
    )
      |-
    (
        ∀((n: T) => child(n))
    )
    Proof(
      //COMPLETE PROOF HERE


    )
  )
}

// #Sireum #Logika

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.pred._
import org.sireum.justification.natded.prop._


//Complete the following natural deduction proof.
//When you are finished, do a Logika check.
//Your file should say "Logika verified".

//∀ n (child(n) ∨ adult(n)), ¬adult(Jane) ⊢ child(Jane)

@pure def proof1[T](child: T=>B @pure, adult: T=>B @pure, Jane: T): Unit = {
  Deduce(
    (
      ∀((n: T) => (child(n) | adult(n))),
      !adult(Jane)
    )
    |-
    (
      child(Jane)
    )
    Proof(
      //COMPLETE PROOF HERE


    )
  )
}

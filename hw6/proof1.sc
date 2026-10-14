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
      1 (∀((n: T) => (child(n) | adult(n)))) by Premise,
      2 (!adult(Jane)) by Premise,
      3 (child(Jane) | adult(Jane)) by AllE[T](1),

      4 SubProof(
        5 Assume (adult(Jane)),
        6 (F) by NegE(5, 2),
        7 (child(Jane)) by BottomE(6)
      ),

      8 SubProof(
        9 Assume (child(Jane)),
        10 (child(Jane) | adult(Jane)) by OrI1(9)
      ),

      11 (child(Jane)) by OrE(3, 8, 4)

    )
  )
}

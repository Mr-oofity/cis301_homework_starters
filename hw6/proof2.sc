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
      1 (∀((n: T) => (child(n) | adult(n)))) by Premise,
      2 (∀((n: T) => !adult(n))) by Premise,

      3 Let ((a: T) => SubProof(
        4 (child(a) | adult(a)) by AllE[T](1),
        5 (!adult(a)) by AllE[T](2),

        6 SubProof(
          7 Assume (adult(a)),
          8 (F) by NegE(7, 5),
          9 (child(a)) by BottomE(8)
        ),

        10 SubProof(
          11 Assume (child(a)),
          12 (child(a) | adult(a)) by OrI1(11)
        ),

        13 (child(a)) by OrE(4, 10, 6)

      )),
      
      14 (∀((n: T) => child(n))) by AllI[T](3)
    )
  )
}

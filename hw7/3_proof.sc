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
      ∀((x: T) => (P(x) __>: !Q(x))) //Every P is not a Q
    )
    |-
    (
      !(∃((x: T) => (P(x) & Q(x)))) //No one is P and Q
    )
    Proof(
      //COMPLETE PROOF HERE
      1 (∀((x: T) => (P(x) __>: !Q(x)))) by Premise,

      2 SubProof(
        3 Assume((∃((x: T) => (P(x) & Q(x))))), 
        4 Let((flowery: T) => SubProof(
          5 Assume(P(flowery) & Q(flowery)),
          
          6 (P(flowery) __>: !Q(flowery)) by AllE[T](1),
          7 (P(flowery)) by AndE1(5),
          8 (!Q(flowery)) by ImplyE(6, 7),
          9 (Q(flowery)) by AndE2(5),
          
          10 (F) by NegE(9, 8)
        )),
        11 (F) by ExistsE[T](3, 4)
      ),

      12 (!(∃((x: T) => (P(x) & Q(x))))) by NegI(2)

    )
  )
}

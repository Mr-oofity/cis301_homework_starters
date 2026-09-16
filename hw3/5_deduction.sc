// #Sireum #Logika

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.prop._


//Complete the following natural deduction proof.
//When you are finished, your file should say "Logika verified".

//p, q ∧ s, ¬r ⊢ (r ∨ s) ∧ (¬p ∨ q ∧ ¬r)


@pure def deduction5(p: B, q: B, r: B, s: B): Unit = {
  Deduce(
    //@formatter: off

    (p, q & s, !r) |- ((r | s) & (!p | q & !r))
      Proof(
        //Setting premise
        1 ( p) by Premise,
        2 (q & s) by Premise,
        3 (!r) by Premise,

        //proving q & s
        4 (q) by AndE1(2),
        5 (s) by AndE2(2),

        //Proving the left half of the conclusion using the and to show s must be true
        6 (r | s) by OrI2(5),
        
        //Proving right half of concluson, proving q must be true using previous and
        7 (q & !r) by AndI(4, 3),
        8 (!p | q & !r) by OrI2(7),

        //Proving the conclusion
        9 ((r | s) & (!p | q & !r)) by AndI(6, 8)
    )
    //@formatter:on
  )
}
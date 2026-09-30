// #Sireum #Logika

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.prop._


//Complete the following natural deduction proof.
//When you are finished, run a Logika check (Ctrl-Shift-W or Command-Shift-W)
//Your file should say "Logika verified".


//¬(p ∨ q) ⊢ ¬p ∧ ¬q

@pure def hw4_prob4(p: B, q: B, r: B): Unit = {
  Deduce(
    ( !(p | q) ) |-  ( !p & !q)
      Proof(
        //COMPLETE PROOF HERE
        1 (!(p | q)) by Premise,

        //Prove that p being true is bad
        2 SubProof(
          3 Assume(p),
          4 (p | q) by OrI1(3),
          5 (F) by NegE(4, 1)
        ),

        //Prove that q being true is also bad
        6 SubProof(
          7 Assume(q),
          8 (p | q) by OrI2(7),
          9 (F) by NegE(8, 1)
        ),
        
        //create neg variables
        10 (!p) by NegI(2),
        11 (!q) by NegI(6),

        //Prove ending
        12 (!p & !q) by AndI(10, 11)
      )
  )
}

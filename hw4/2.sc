// #Sireum #Logika

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.prop._


//Complete the following natural deduction proof.
//When you are finished, run a Logika check (Ctrl-Shift-W or Command-Shift-W)
//Your file should say "Logika verified".


//(p → q) ∨ (p → r) ⊢ p → q ∨ r

@pure def hw4_prob2(p: B, q: B, r: B): Unit = {
  Deduce(
    ((p __>: q) | (p __>: r) ) |- ( (p __>: q | r ) )
      Proof(
        //Premises
        1((p __>: q) | (p __>: r)) by Premise,

        //Assume that p is active
        2 SubProof (
          3 Assume(p),

          //Prove left half
          4 SubProof(
            5 Assume(p __>: q),
            6 (q) by ImplyE(5, 3),
          ),
          
          //Prove right half
          7 SubProof(
            8 Assume(p __>: r),
            9 (r) by ImplyE(8, 3),
          ),

          10 (q | r) by OrE(1, 4, 7)
        ),

        11 (p __>: q | r) by ImplyI(2)
      )
  )
}

// #Sireum #Logika

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.prop._


//Complete the following natural deduction proof.
//When you are finished, run a Logika check (Ctrl-Shift-W or Command-Shift-W)
//Your file should say "Logika verified".

//p ∧ q → r ⊢ p → (q → r)

@pure def hw4_prob3(p: B, q: B, r: B): Unit = {
  Deduce(
    (p & q __>: r) |-  ( p __>: (q __>: r) )
      Proof(
        //Premise
        1 (p & q __>: r) by Premise,
        
        //Find q __>: r
        3 SubProof(
          4 Assume(p),
          
          5 SubProof( //Find r 
            6 Assume(q),
            7 (p & q) by AndI(4, 6),
            8 (r) by ImplyE(1, 7)
          ),

          9 (q __>: r) by ImplyI(5)
        ),

        10 (p __>: (q __>: r)) by ImplyI(3)
      )
  )
}

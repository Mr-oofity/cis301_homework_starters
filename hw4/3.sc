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
        //COMPLETE PROOF HERE

      )
  )
}

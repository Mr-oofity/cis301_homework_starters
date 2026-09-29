// #Sireum #Logika

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.prop._


//Complete the following natural deduction proof.
//When you are finished, run a Logika check (Ctrl-Shift-W or Command-Shift-W)
//Your file should say "Logika verified".


//p → a ∨ b, a → d, q → ¬b, p ∧ q ⊢ d

@pure def hw4_prob5(p: B, a: B, b: B, q: B, d: B): Unit = {
  Deduce(
    ( p __>: a | b, a __>: d, q __>: !b, p & q ) |-  ( d )
      Proof(
        //COMPLETE PROOF HERE

      )
  )
}

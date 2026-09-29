// #Sireum #Logika

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.prop._

/*
Use natural deduction to prove that the following two statements are equivalent:
    ¬(p → q)
    p ∧ ¬q

You will need to complete BOTH proofs below. When you are finished, run a Logika check 
(Ctrl-Shift-W or Command-Shift-W) Your file should say "Logika verified".
*/

@pure def hw4_prob7_part1(p: B, q: B): Unit = {
  Deduce(
    ( !(p __>: q) ) |-  ( p & !q )
      Proof(
        //COMPLETE PROOF HERE

      )
  )
}

@pure def hw4_prob7_part2(p: B, q: B): Unit = {
  Deduce(
    ( p & !q ) |-  ( !(p __>: q) )
      Proof(
        //COMPLETE PROOF HERE

      )
  )
}

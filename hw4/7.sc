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

/*@pure def hw4_prob7_part1(p: B, q: B): Unit = {
  Deduce(
    ( !(p __>: q) ) |-  ( p & !q )
      Proof(
        1 (!(p __>: q)) by Premise,

        2 SubProof(
          3 Assume(p & !q),
          
          4 (p) by AndE1(3),
          5 (!q) by AndE2(3),

          
        )
      )
  )
}*/

@pure def hw4_prob7_part2(p: B, q: B): Unit = {
  Deduce(
    ( p & !q ) |-  ( !(p __>: q) )
      Proof(
        1 (p & !q) by Premise,
        
        //Set and parts
        2 (p) by AndE1(1),
        3 (!q) by AndE2(1),

        //Show p __>: q must be false
        4 SubProof(
          5 Assume (p __>: q),
          6 (q) by ImplyE(5, 2),
          7 (F) by NegE(6, 3)
        ),

        8 (!(p __>: q)) by NegI(4)

      )
  )
}

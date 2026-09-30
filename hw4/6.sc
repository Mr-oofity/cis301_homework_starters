// #Sireum #Logika

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.prop._

/*
Use natural deduction to prove that the following two statements are equivalent:
    p → q
    ¬p ∨ q

You will need to complete BOTH proofs below. When you are finished, run a Logika check 
(Ctrl-Shift-W or Command-Shift-W) Your file should say "Logika verified".
*/

@pure def hw4_prob6_part1(p: B, q: B): Unit = {
  Deduce(
    ( p __>: q ) |-  ( !p | q )
      Proof(
        1 (p __>: q)   by Premise,
        
        // Use LEM to create an adjacent reference equation to conclusion
        2 SubProof(
          3 Assume(!(p | !p)),

          //Prove for !p
          4 SubProof(
            5 Assume(p),
            6 (p | ! p) by OrI1(5),
            7 (F) by NegE(6, 3)
          ),

          8 (!p) by NegI(4),
          9 (p | !p) by OrI2(8),
          10 (F) by NegE(9, 3)
        ),

        //Find adjacent equation with PCB, which will be used as a base for OrE
        11 (p | !p) by PbC(2), 

        //Use components of adjacent equation to solve OrE for conclusion
        12 SubProof(
          13 Assume(p),
          14 (q) by ImplyE(1, 13), 
          15 (!p | q) by OrI2(14)      
        ),

        16 SubProof(
          17 Assume(!p),
          18 (!p | q) by OrI1(17)
        ),

        //Prove conclusion with OrE
        19 (!p | q) by OrE(11, 12, 16)
      )
  )
}

@pure def hw4_prob6_part2(p: B, q: B): Unit = {
  Deduce(
    ( !p | q ) |-  ( p __>: q )
      Proof(
        1 (!p | q) by Premise,

        //Find q
        2 SubProof(
          3 Assume (p),

          //Show not p can not be true
          4 SubProof(
            5 Assume(!p),
            6 (F) by NegE(3, 5),
            100 (q) by BottomE(6)
          ),
  

          7 SubProof(
            8 Assume(q),
            9 (!p | q) by OrI2(8)
          ),
          
          
          10 (q) by OrE(1, 4, 7)
        ),

        11 (p __>: q) by ImplyI(2)
      )
  )
}

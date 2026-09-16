// #Sireum #Logika

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.prop._


//Complete the following natural deduction proof.
//When you are finished, your file should say "Logika verified".

//(p ∧ q) ∨ (q ∧ r) ⊢  q ∧ (r ∨ p)


@pure def deduction6(p: B, q: B, r: B): Unit = {
  Deduce(
    //@formatter: off

    ((p & q) | (q & r)) |- (q & (r | p))
      Proof(
        //Set premise
        1 ((p & q) | (q & r)) by Premise,
        

        //Prove premise components
        2 SubProof(
          3 Assume (p & q),
          4 (p) by AndE1(3),
          5 (q) by AndE2(3),

          //Goal: solve left of premise
          6 ((p & q) | (q & r)) by OrI1(3),
          100 (r | p) by OrI2(4)
        ),
        7 SubProof(
          8 Assume (q & r),
          9 (q) by AndE1(8),
          10 (r) by AndE2(8),

          //Goal: solve Right of premise
          11 ((p & q) | (q & r)) by OrI2(8),
          12 (r | p) by OrI1(10)
        ),
        
        //Prove right conclusion
        14 (r | p) by OrE(1, 2, 7),

        //Prove left conclusion
        15 (q) by OrE(1, 2, 7),

        //Prove conclusion
        18 (q & (r | p)) by AndI(15, 14)
    )
    //@formatter:on
  )
}
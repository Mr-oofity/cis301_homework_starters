// #Sireum #Logika

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.prop._


//Complete the following natural deduction proof.
//When you are finished, your file should say "Logika verified".

//p ∨ q ∨ r ⊢ r ∨ q ∨ p


@pure def deduction6(p: B, q: B, r: B): Unit = {
  Deduce(
    //@formatter: off

    (p | q | r) |- (r | q | p)
      Proof(
        //Setting premise
        1 (p | q | r) by Premise,

        2 SubProof(
          3 Assume (p | q),
          
          4 SubProof(
            5 Assume (p),
            6 (r | q | p) by OrI2(5)
          ),
          8 SubProof(
            9 Assume (q),
            10 (r | q) by OrI2(9),
            11 (r | q | p) by OrI1(10)
          ),

          12 (r | q | p) by OrE(3,4,8),
        ),

        13 SubProof(
          14 Assume (r),

          15 (r | q) by OrI1(14),
          16 (r | q | p) by OrI1(15)
        ),

        25 (r | q | p) by OrE(1,2,13)
    )
    //@formatter:on
  )
}
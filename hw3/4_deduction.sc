// #Sireum #Logika

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.prop._


//Complete the following natural deduction proof.
//When you are finished, your file should say "Logika verified".

//p ∧ q, m ∧ n ∧ r ∧ t ⊢ n ∧ t ∧ p


@pure def deduction4(p: B, q: B, m: B, n: B, r: B, t: B): Unit = {
    Deduce(
        //@formatter: off

        (p & q, m & n & r & t) |- (n & t & p)
        Proof(
            1 (  p & q            ) by Premise,
            2 (  m & n & r & t  ) by Premise,
            //Proving first premise
            3 ( p ) by AndE1(1),
            4 ( q ) by AndE2(1),
            
            //Proving second premise
            5 (m & n & r) by AndE1(2),
            6 (t) by AndE2(2),

            //Isolating n
            7 (m & n) by AndE1(5), 
            8 (n ) by AndE2(7),
            
            //Proving the conclusion
            9 ( n & t ) by AndI(8, 6),
            10 (n & t & p) by AndI(9, 3)
        )
        //@formatter:on
    )
}
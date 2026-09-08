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
        //WRITE THE PROOF HERE
        
    )
    //@formatter:on
  )
}
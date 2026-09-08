// #Sireum #Logika

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.prop._


//Complete the following natural deduction proof.
//When you are finished, your file should say "Logika verified".

//p, q ∧ s, ¬r ⊢ (r ∨ s) ∧ (¬p ∨ q ∧ ¬r)


@pure def deduction5(p: B, q: B, r: B, s: B): Unit = {
  Deduce(
    //@formatter: off

    (p, q & s, !r) |- ((r | s) & (!p | q & !r))
      Proof(
        //WRITE THE PROOF HERE
        
    )
    //@formatter:on
  )
}
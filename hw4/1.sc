// #Sireum #Logika
import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.prop._


//Complete the following natural deduction proof.
//When you are finished, run a Logika check (Ctrl-Shift-W or Command-Shift-W)
//Your file should say "Logika verified".

//p ∨ q, p → a ∨ b, q → a ∨ b, a → c, b → c ⊢ c

@pure def hw4_prob1(p: B, q: B, a: B, b: B, c: B): Unit = {
  Deduce(
    (p | q, p __>: a | b, q __>: a | b, a __>: c, b __>: c) |- ( c )
      Proof(
        //COMPLETE PROOF HERE

      )
  )
}

// #Sireum #Logika

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.pred._
import org.sireum.justification.natded.prop._

//Complete the following natural deduction proof.
//When you are finished, run a Logika check -- your file should say "Logika verified".

//∀ x (student(x) → csharp(x)), ∃ x ¬csharp(x) ⊢ ∃ x ¬student(x)

@pure def proof2[T](student: T=>B @pure, csharp: T=>B @pure): Unit = {
  Deduce(
    (
      ∀((x: T) => (student(x) __>: csharp(x))),
      ∃((x: T) => !csharp(x))
    )
      |-
      (
        ∃((x: T) => !student(x))
      )
      Proof(
        //COMPLETE PROOF HERE

      )
  )
}

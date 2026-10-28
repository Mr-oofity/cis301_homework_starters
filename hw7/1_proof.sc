// #Sireum #Logika
import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.pred._
import org.sireum.justification.natded.prop._

//Complete the following natural deduction proof.
//When you are finished, run a Logika check -- your file should say "Logika verified".


//∃ x (ksu(x) ∨ ku(x)), ¬(∃ x ku(x)) ⊢ ∃ x ksu(x)

@pure def proof1[T](ksu: T=>B @pure, ku: T=>B @pure): Unit = {
  Deduce(
    (
      ∃((x: T) => (ksu(x) | ku(x))), //Someone is either at KSU or KU
      !(∃((x: T) => ku(x))) //There is no on at KU
    )
      |-
    (
      ∃((x: T) => ksu(x)) //There is someone at KSU
    )
    Proof(
        1 (∃((x: T) => (ksu(x) | ku(x)))) by Premise,
        2 (!(∃((x: T) => ku(x))))  by Premise,


        3 Let ( (jane: T) => SubProof(
          4 Assume(ksu(jane) | ku(jane)),

          5 SubProof(
            6 Assume(ku(jane)),
            7 (∃((x: T) => ku(x))) by ExistsI[T](6),
            8 (F) by NegE(7, 2),
            9 (ksu(jane)) by BottomE(8)
          ),

          10 SubProof(
            11 Assume(ksu(jane))
          ),

          12 (ksu(jane)) by OrE(4, 10, 5),
          13 (∃((x: T) => ksu(x))) by ExistsI[T](12),     
        )),

        14 (∃((x: T) => ksu(x))) by ExistsE[T](1, 3)
    )
  )
}

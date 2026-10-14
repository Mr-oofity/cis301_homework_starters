// #Sireum #Logika

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.pred._
import org.sireum.justification.natded.prop._

//Complete the following natural deduction proof.
//When you are finished, do a Logika check.
//Your file should say "Logika verified".


//∀ x (candy(x) → sweet(x)), ∀ x (sweet(x) → hasSugar(x)) ⊢ ∀ x (¬hasSugar(x) __>: ¬candy(x))

@pure def proof3[T](candy: T=>B @pure, sweet: T=>B @pure, hasSugar: T=>B @pure): Unit = {
  Deduce(
    (
      ∀((x: T) => (candy(x) __>: sweet(x))),
      ∀((x: T) => (sweet(x) __>: hasSugar(x)))
    )
      |-
    (
      ∀((x: T) => (!hasSugar(x) __>: !candy(x))),
    )
    Proof(
      1 (∀((x: T) => (candy(x) __>: sweet(x)))) by Premise,
      2 (∀((x: T) => (sweet(x) __>: hasSugar(x)))) by Premise,

      3 Let ((a: T) => SubProof(
        4 (candy(a) __>: sweet(a)) by AllE[T](1),
        5 (sweet(a) __>: hasSugar(a)) by AllE[T](2),

        //Create a straight forward implication between candy and hassugar
        6 SubProof(
          7 Assume(candy(a)),
          8 (sweet(a)) by ImplyE(4, 7),
          9 (hasSugar(a)) by ImplyE(5, 8)
        ),

        10 (candy(a) __>: hasSugar(a)) by ImplyI(6),
        
        //Use straight forward proof to imply something without sugar can't be candy
        11 SubProof(
          12 Assume(!hasSugar(a)),
          13 SubProof(
            14 Assume(candy(a)),
            15 (hasSugar(a)) by ImplyE(10, 14),
            16 (F) by NegE(15, 12)
          ),
          17 (!candy(a)) by NegI(13)
        ),
        
        18 (!hasSugar(a) __>: !candy(a)) by ImplyI(11)

      )),

      19 (∀((x: T) => (!hasSugar(x) __>: !candy(x)))) by AllI[T](3)

    )
  )
}

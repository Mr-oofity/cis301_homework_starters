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
        //Set up premises
        1 (p | q) by Premise,
        2 (p __>: a | b) by Premise,
        3 (q __>: a | b) by Premise,
        4 (a __>: c) by Premise,
        5 (b __>: c) by Premise,

        //Set up how either p must be true
        6 SubProof(
          7 Assume(p),

          8 (a | b) by ImplyE(2, 7),
          //Find how a and b must be true
          9 SubProof(
            10 Assume(a),

            11 (c) by ImplyE(4, 10)
          ),
          12 SubProof(
            13 Assume(b),

            14 (c) by ImplyE(5, 13)
          ),

          100 (c) by OrE(8, 9, 12)
        ),
        
        //Set up how either p must be true
        15 SubProof(
          16 Assume(q),

          17 (a | b) by ImplyE(3, 16),
          //Find how a and b must be true
          18 SubProof(
            19 Assume(a),

            20 (c) by ImplyE(4, 19)
          ),
          21 SubProof(
            22 Assume(b),

            23 (c) by ImplyE(5, 22)
          ),
          
          101 (c) by OrE(17, 18, 21)
        ),

        102 (c) by OrE(1, 6, 15)
        
      )
  )
}

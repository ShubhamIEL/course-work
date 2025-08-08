//// First, define what a character IS. This part is simple.
//data class Stats(val strength: Int, val intelligence: Int)
//data class GameCharacter(val name: String, val job: String, val stats: Stats)
//
//
//// Now, create one.
//val characterStats = Stats(strength = 8, intelligence = 18)
//val myCharacter = GameCharacter(name = "Gandalf", job = "Mage", stats = characterStats)

// This is the one and only function the user will ever call.
fun main() {

    val hi:(String) -> String = { x -> "Hello $x"}
    println(hi("shuuu"))
    val myCharacter = character { // <-- The starting pistol fires!
        name = "Gandalf"
        job = "Mage"

        stats {
            strength = 8
            intelligence = 18
        }
    }
}
fun character(block: CharacterBuilder.() -> Unit): GameCharacter {
    // 1. Create the temporary workspace (the builder).
    val builder = CharacterBuilder()

    // 2. Run the user's code to fill in the workspace.
    builder.block()

    // 3. Press the "build" button and return the final product.
    return builder.build()
}



// The final, unchangeable product.
data class Stats(val strength: Int, val intelligence: Int)
data class GameCharacter(val name: String, val job: String, val stats: Stats)

// Builder for just the stats
class StatsBuilder {
    var strength: Int = 0 // Default value
    var intelligence: Int = 0 // Default value
}

// Builder for the whole character
class CharacterBuilder {
    var name: String = "" // Starts empty
    var job: String = ""  // Starts empty
    val statsBuilder = StatsBuilder() // It has its own mini-builder for stats!

    // This creates the little "stats { ... }" block inside our DSL
    fun stats(block: StatsBuilder.() -> Unit) {
        statsBuilder.block()
    }

    // THE "BUILD" BUTTON
    fun build(): GameCharacter {
        val finalStats = Stats(statsBuilder.strength, statsBuilder.intelligence)
        return GameCharacter(name, job, finalStats)
    }
}
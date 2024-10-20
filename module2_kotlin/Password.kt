import java.io.Serializable

// The Password class that stores password name, the actual password, and description
// It is Serializable - so that Password objects can be stored to a data file
data class Password (
    val name: String,
    val password: String,
    val description: String
) : Serializable
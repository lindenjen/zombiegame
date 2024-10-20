import java.io.File

class PasswordManager {
    // create Map for storing Password classes
    private var passwordMap = mutableMapOf<String, Password>()
    // create file name with path in temp folder for saving password values
    private val storageFile = System.getProperty("java.io.tmpdir") + System.getProperty("file.separator") + "PasswordManager.data"

    // This will run the first time PasswordManager is created
    // If the storageFile exists, it will load passwordMap with values
    init {
        val file = File(storageFile)

        if (file.exists()) {
            passwordMap = deserializeMap(storageFile)
        }
    }

    // Returns true if Pasword name exists in map
    fun passwordExists(name: String): Boolean {
        return passwordMap.containsKey(name)
    }

    // Returns number of Password classes in passwordMap
    fun getCount() : Int {
        return passwordMap.size
    }

    // Creates a new Password class and adds it to passwordMap
    // Also saves map data to file
    fun createPassword(name: String, password: String, description: String) {
        val newPassword = Password(name, password, description)
        passwordMap[name] = newPassword
        //passwordList.add(newPassword)
        serializeMap(passwordMap, storageFile)

    }

    // Edits the password by removing existing Password class if exists
    // Addes new Password to passwordMap
    fun editPassword(existingName: String, name: String, password: String, description: String) {
        if (passwordExists(existingName)) {
            passwordMap.remove(existingName)
        }
        createPassword(name, password, description)

    }

    // Deletes the Password class from passwordMap
    // Saves the map data to file
    fun deletePassword(name: String) {
        if (passwordExists(name)) {
            passwordMap.remove(name)
            serializeMap(passwordMap, storageFile)
        }

    }

    // Gets a Password class from passwordMap by key (name)
    fun getPassword(name: String): Password? {
        return passwordMap[name]
    }

    // Prints every Password in passwordMap by Name and Description
    fun printPasswords() {
        println("You have ${passwordMap.size} Passwords")
        for (password in passwordMap.values) {
            println("${password.name} - ${password.description}")
        }
    }
}

import java.util.Scanner


fun main() {
    // a Reader for getting values from the user
    val reader = Scanner(System.`in`)

    // item starts at 0 - and is used to loop until the user enters 6 to exit
    var item = 0

    // Create a PasswordManager class to use for managing passwords
    val passwordManager = PasswordManager()

    // Loop and ask the user what they want to do - keep looping until 6
    while (item != 6) {
        println("\n---------------------------")
        println("Welcome to Password Manager")
        println("There are ${passwordManager.getCount()} Password(s)")
        println("1. Create Password")
        println("2. Edit Password")
        println("3. Delete Password")
        println("4. List Password Names")
        println("5. Show Password")
        println("6. Exit")

        // Get an integer value from the user
        print("Enter a number: ")
        item = reader.nextInt()

        // handle option 1 - Create Password
        if (item == 1) {
            print("Enter the name of your password: ")
            val name= readln()
            println("Enter your password: ")
            val password = readln()
            println("Enter password description: ")
            val description = readln()

            passwordManager.createPassword(name, password, description)
            println("Password created!")
        }

        // handle option 2 - Edit Password
        if (item == 2) {
            print("Enter the name of the password you want to edit: ")
            val name= readln()

            if (passwordManager.passwordExists(name)) {
                val password = passwordManager.getPassword(name)

                println("Enter the new name of your password (or press enter to keep same): ")
                var newName = readln()
                if (newName.isEmpty()) {
                    newName = name
                }
                println("Enter your new password (or press enter to keep same): ")
                var newPassword = readln()
                if (newPassword.isEmpty()) {
                    if (password != null) {
                        newPassword = password.password
                    }
                }
                println("Enter your new description (or press enter to keep same): ")
                var newDescription = readln()
                if (newDescription.isEmpty()) {
                    if (password != null) {
                        newDescription = password.description
                    }
                }

                passwordManager.editPassword(name, newName, newPassword, newDescription)
                println("Password settings changed!")
            } else {
                println("Could not find existing password called: $name")
            }


        }

        // handle option 3 - Delete Password
        if (item == 3) {
            print("Enter the name of the password you want to delete: ")
            val name = readln()

            if (passwordManager.passwordExists(name)) {
                passwordManager.deletePassword(name)
                println("Password deleted!")
            } else {
                println("Could not find an existing password called: $name")
            }
        }

        // handle option 4 - Print Password
        if (item == 4) {
            passwordManager.printPasswords()
        }

        // handle option 5 - View Password
        if (item == 5) {
            print("Enter the name of the password you want to view: ")
            val name = readln()

            if (passwordManager.passwordExists(name)) {
                val password = passwordManager.getPassword(name)
                if (password != null) {
                    println("Your password is: " + password.password)
                }
            } else {
                println("Could not find existing password called: $name")
            }
        }

    }
    // handle option 6 - Exit
    println("\nThank you for using your friendly neighborhood password manager!")


}

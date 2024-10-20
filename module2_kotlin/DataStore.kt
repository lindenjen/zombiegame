import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.ObjectOutputStream
import java.io.ObjectInputStream

// This function takes a map with Password and serializes its data and writes it to a file
// takes object in memory and converts to format that can be stored or transmitted
fun serializeMap(map: MutableMap<String, Password>, fileName: String) {
    ObjectOutputStream(FileOutputStream(fileName)).use { oos ->
        oos.writeObject(map)
    }
}

// This function gets data from a File, deserializes it and returns a map with Password
// takes data that has been stored or transmitted and converts to a memory object
fun deserializeMap(fileName: String): MutableMap<String, Password> {
    ObjectInputStream(FileInputStream(fileName)).use { ois ->
        @Suppress("UNCHECKED_CAST")
        return ois.readObject() as MutableMap<String, Password>
    }
}
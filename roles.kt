import java.io.FileInputStream
import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val sc = Scanner(FileInputStream("src/main/kotlin/text.txt"))
    val text: HashMap<String, ArrayList<String>> = HashMap<String, ArrayList<String>>()
    var roles = ArrayList<String>()
    var line = ""
    while (sc.hasNextLine() && line != "textLines:") {
        if (line != "" && line != "roles:") {
            text[line] = ArrayList<String>()
            roles.add(line)
        }
        line = sc.nextLine()
    }
    var i = 1
    while (sc.hasNextLine()){
        line = sc.nextLine()
        val repl = line.replace("\n", "")
        val t = repl.split(":")
        text[t[0]]?.add("$i) ${repl.substring(t[0].length + 1, repl.length)}")
        i++
    }
    for (l in roles) {
        println("$l:")
        for (j in text[l]!!) println(j)
        println()
    }
}
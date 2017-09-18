import com.github.dsaouda.fiaptelembra.model.Cliente
import com.github.dsaouda.fiaptelembra.token.Token
import com.google.gson.Gson
import com.google.gson.JsonParser
import com.google.gson.annotations.SerializedName

data class Topic(
        @SerializedName("id") val id: Long,
        @SerializedName("n") val name: String,
        @SerializedName("i") val image: String,
        @SerializedName("d") val description: String
)


fun main(args: Array<String>) {

    val topic = Topic(1, "teste", "image", "description")
    println(topic)

    println(Gson().toJson(topic))



    println(Gson().fromJson(""" {"id":1,"n":"teste2","i":"image","d":"description2"} """, Topic::class.java))

    val map = Gson().fromJson(""" {"id":1,"n":"teste2","i":"image","d": [1,2,3],"e":{"f":{"g": 1}}} """, Map::class.java)

    println(map)
    println(map["id"])
    println(map["n"])
    println(map["i"])
    println(map["d"])
    println(map["e"])


    val obj = JsonParser().parse(""" {"id":1,"n":"teste2","i":"image","d": [1,2,3],"e":{"f":{"g": 1}}} """).asJsonObject


    println(obj.getAsJsonObject("e").getAsJsonObject("f").getAsJsonPrimitive("g").asInt)

}
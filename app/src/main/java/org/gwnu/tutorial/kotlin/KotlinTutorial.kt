package org.gwnu.tutorial.kotlin

/**************************************************************************************************/

fun main() {

    /**************************************************************************************************/

    //3. String Template
    val name = "been"
    val lastName = "Kim"
    println("my name is ${name + lastName}I'm 27")
    println("is this true? ${1 == 0}")
    println("this is 2\$a")

    /**************************************************************************************************/


//    checkNum(1)

//    forANdWhile()

    nullCheck()
}

/**************************************************************************************************/

//7. Nullable / NonNull
fun nullCheck() {
    //NPE : NULL Pointer Exception

    var name: String = "been" // NonNull

    var nullName: String? = null //Nullable : Null을 사용하고 싶으면 타입뒤에 '?'를 붙여주면 된다는 점!!

    var nameInUpperCase = name.toUpperCase()

    var nullNmaeInUpperCase = nullName?.toUpperCase() //만약 null이 아니면 toUpperCase를 실행하고 null이면 null을 반환해라!!


    //?: (앨비스 연산자?)

    val lastName: String? = "Kim"

    val fullName = name + " " + (lastName ?: "NO lastName")
    println(fullName)
}

/**************************************************************************************************/

fun forANdWhile() {
    val students = arrayListOf("joice", "james", "jenny", "jennifer")

    for (name in students) {
        println(name)
    }


    var sum: Int = 0
    for (i in 1..10) {
        sum += i
    }
    println(sum)

    var index = 0
    while (index < 10) {
        println("current index: $index")
        index++
    }

    for ((index, name) in students.withIndex()) {
        println("${index}번째 학생 : ${name}")
    }
}

/**************************************************************************************************/

//5. Array and List
fun array() {
    val array = arrayOf(1, 2, 3)
    val list = listOf(1, 2, 3)

    val array2 = arrayOf(1, "d", 3.4f)
    val list2 = listOf(1, "d", 11L)

    array[0] = 3

    val arrayList = arrayListOf<Int>()
    arrayList.add(10)
    arrayList.add(20)

}

/**************************************************************************************************/

//4.조건식
fun maxBy(a: Int, b: Int): Int {

    return if (a > b) {
        a
    } else {
        b
    }
}

fun maxBy2(a: Int, b: Int): Int = if (a > b) a else if (a == b) b else b
fun checkNum(score: Int) {
    when (score) {
        0 -> print("this is 0")
        1 -> print("this is 1")
        2, 3 -> print("this is 2 or 3")
    }

    var b = when (score) {
        1 -> 1
        2 -> 2
        else -> 3
    }

    when (score) {
        in 90..100 -> println("You are genius")
        in 10..80 -> println("not bad")
        else -> println("okay")
    }
}
//Expression vs Statement

/**************************************************************************************************/

//2. val vs var
fun hi() {
    val a: Int = 10
    var b: Int = 9

    b = 100

    val c = 100
    var d = 100
    var name = "been"
}

/**************************************************************************************************/

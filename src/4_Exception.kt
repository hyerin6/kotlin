fun main() {

    Thread.sleep(1) // 컴파일 에러 안남

    // try-catch-finally 사용 가능
    try {
        Thread.sleep(1)
    } catch (e: Exception) {
        println("에러 발생 !")
    } finally {
        println("finally 실행 !")
    }

    // 코틀린에서 try-catch는 표현식이기 때문에 값을 전달할 수 있다.
    // (자바에서 try-catch는 구문이다.)
    val a = try {
        "1234".toString()
    } catch (e: Exception) {
        println("예외 발생 !")
    }
    println(a)

    // throw 를 사용하여 Exception을 발생시킬 수 있다. 
    // throw Exception()

    // throw도 표현식이기 때문에 값이 될 수 있다.
    // failFast("예외 발생 !")

    // Nothing
    println("이 메시지는 출력될까?") // Unreachable code


    val b: String? = null
    val c: String = b ?: failFast("b is null")
    println(c.length)
}

fun failFast(message: String): Nothing {
    throw IllegalArgumentException(message)
}
package chap02

import java.time.LocalDateTime

// object 키워드 사용만으로 싱글톤 객체 생성 가능
object Singleton {
    val a = 123
    fun printA() = println(a)
}

object DatetimeUtils {
    val now: LocalDateTime
        get() = LocalDateTime.now()

    const val DEFAULT_FORMAT = "YYYY-MM-DD" // 자바의 상수와 유사

    fun same(a: LocalDateTime, b: LocalDateTime): Boolean {
        return a == b
    }
}

class MyClass {

    private constructor()

    companion object {
        val a = 1234

        fun newInstance() = MyClass()
    }
}

fun main() {
    println(Singleton.a)
    println(Singleton.printA())

    println(DatetimeUtils.now)
    println(DatetimeUtils.DEFAULT_FORMAT)

    val now = LocalDateTime.now()
    println(DatetimeUtils.same(now, now))

    println(MyClass.a)
    println(MyClass.Companion.a)
    println(MyClass.newInstance())
    println(MyClass.Companion.newInstance())
}

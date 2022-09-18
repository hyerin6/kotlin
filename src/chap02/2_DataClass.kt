data class Person(val name: String, val age: Int)

fun main() {
    // non data class 인 경우 프로퍼티 값이 같아도 false 가 출력
    // data class 인 경우 true 가 출력
    val person1 = Person(name = "tony", age = 12)
    val person2 = Person(name = "tony", age = 12)
    println(person1 == person2)

    // equals가 true 이면, hashCode도 true가 출력되어야 한다.
    val set = hashSetOf(person1)
    println(set.contains(person2))

    println(person1.toString())

    // data class 단점

    // 프로퍼티가 var인 경우 Person 객체 자체가 불변은 아님
    // person1.name = "strange"
    // println(set.contains(person1)) // false

    // copy를 사용하면 val로 유지하면서 프로퍼티 값을 변경할 수 있다.
    val person3 = person1.copy(name = "strange")
    println(person3)

    // componentN 함수 사용
    println("이름=${person1.component1()}, 나이=${person2.component2()}")

    // 구조분해할당
    val (name, age) = person1
    println("이름${name}, 나이=${age}")

}

package chap02

// 확장함수 내부에서 공통점 = this를 사용한다.
// this는 실제 확장되는 대상의 객체 참조로 "ABCD" 라는 문자열이다.
// 실제로 디컴파일 해보면 항상 첫번째 인자로 확장 대상이 되는 객체(this)가 들어간다.
fun String.first(): Char {
    return this[0]
}

fun String.addFirst(char: Char): String {
    return char + this.substring(0)
}


// 확장 함수를 썼을 때 주의점
// 확장하는 클래스에 동일한 이름의 메소드가 있으면 클래스의 멤버 함수가 우선이다.
class MyExample {
    fun printMessage() = println("클래스 출력")
}

fun MyExample.printMessage(message: String) = println(message)


// null 인 경우 내부에서 검사를 할 수 있다.
fun MyExample?.printNullOrNotNull() {
    if (this == null) println("null인 경우 출력")
    else println("null이 아닌 경우 출력")
}


fun main() {
    println("ABCD".first())
    println("ABCD".addFirst('Z'))

    // 내부에서 null에 대한 처리를 하고 있기 때문에 NPE가 발생하지 않는다는 것을 알고 있다.
    // 때문에 null 안전 연산자를 사용하지 않아도 함수를 사용할 수 있다.
    var myExample: MyExample? = null
    myExample.printNullOrNotNull() // null인 경우 출력

    myExample = MyExample()
    myExample.printNullOrNotNull() // null이 아닌 경우 출력
}


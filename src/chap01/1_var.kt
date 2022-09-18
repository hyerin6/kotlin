// 변수를 탑레벨에 선언할 수 있다.
var x = 5

fun main() {
    x += 1
    println(x)

    val a: Int = 1

    val b = 1

    val c: Int
    c = 3

//  지연할당 사용 시 타입을 명시하지 않으면 컴파일 오류가 발생한다.
//  val d
//  d = 123

    // val(value) : 자바의 final 키워드 처럼 한 번 값을 할당하면 변경이 불가능하다. 
    // var(variable) : 초기화 후 재할당이 가능하다. 

    val e: String = "Hello"
    // e = "World" 컴파일 오류 발생 

    var f = 123
    // f = "second" 재할당이 가능하지만 최초에 Int 타입으로 고정된 경우, String으로 변경하는 것은 불가능 

}
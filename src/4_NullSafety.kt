fun getNullStr(): String? = null

fun getLengthIfNotNull(str: String?) = str?.length ?: 0

fun main() {

    // val a : String = null // 컴파일 오류 발생
    // var b : String = null // 컴파일 오류 발생
    // var c: String  = "abc"
    // c = null 컴파일 오류 발생

    var a: String? = null

    // a.length 컴파일 오류 발생

    println(a?.length) // null 로 출력된다. 

    // a가 null이 아닐 때 a.length 를 반환하고 null 이면 0을 반환
    val b: Int = if (a != null) a.length else 0
    println(b)

    // 엘비스 연산자
    val c = a?.length ?: 0
    println(c)

    // ====================================================================

    // Java > Kotlin 변환 (NullSafety.java 참고) 
    val nullableStr = getNullStr()

    // val nullableStrLength = nullableStr.length // 컴파일 오류 발생

    val nullableStrLength = nullableStr?.length ?: "null인 경우 반환".length
    println(nullableStrLength)

    val length = getLengthIfNotNull(null)
    println(length)


    // !! 단언 연산자: 무조건 null이 아니다.
    // 이 경우 NPE가 발생할 수 있다.
    val d: String? = null
    val e = d!!.length


    // 코틀린에서 자바 코드 사용하는 경우
    // 코틀린 컴파일러에서 이 메서드가 null을 리턴하는 것을 추론하지 못한다.
    // 항상 null check를 해야 한다. (안전 연산자 사용, 엘비스 연산자 사용)
    println(NullSafety.getNullStr().length) // NPE 발생

}
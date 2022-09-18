import java.util.*

fun main() {
    // immutable
    val currencyList = listOf("달러", "유로", "원")

    // mutable
    val mutableCurrencyList = mutableListOf<String>()
    mutableCurrencyList.add("달러")
    mutableCurrencyList.add("유로")
    mutableCurrencyList.add("원")

    // apply 함수를 사용하면 변수 호출 없이 add 를 바로 사용할 수 있다.
    // mutable list 자체가 apply 안에서 this 참조를 갖고 있기 때문에 가독성이 좋아진다.
    val mutableCurrencyList2 = mutableListOf<String>().apply {
        this.add("달러")
        add("유로")
        add("원")
    }

    // immutable set
    val numberSet = setOf(1, 2, 3)

    // mutable set
    val mutableSet = mutableSetOf<Int>().apply {
        add(1)
        add(2)
        add(3)
    }

    // immutable map
    val numberMap = mapOf("one" to 1, "two" to 2, "three" to 3)

    // mutable map
    val mutableNumberMap = mutableMapOf<String, Int>()
    mutableNumberMap["one"] = 1
    mutableNumberMap.put("two", 2) // 코틀린에서는 put 함수를 직접 쓰는 것 보다는 리터럴 문법 사용을 추천한다.

    // 커렉션 빌더는 내부에서는 mutable 반환은 immutable
    val numberList: List<Int> = buildList {
        add(1)
        add(2)
        add(3)
    }

    // numberList.add(4) 컴파일 에러 발생


    // linkedList
    val linkedList = LinkedList<Int>().apply {
        addFirst(3)
        add(2)
        addLast(1)
    }

    // arrayList
    val arrayList = ArrayList<Int>().apply {
        add(1)
        add(2)
        add(3)
    }

    // 컬렉션 반복 - iterator 사용 
    val iterator = currencyList.iterator()
    while (iterator.hasNext()) {
        println(iterator.next())
    }

    // 컬렉션 반복 - for 사용 
    for (currency in currencyList) {
        println(currency)
    }

    // 코틀린의 표준 라이브러리는 컬렉션 사용 시 자주 사용되는 함수를
    // 인라인 함수로 많이 제공하고 있다.
    currencyList.forEach {
        println(it)
    }

    // [for loop -> map 변환] map 사용하지 않는 경우
    val lowerList = listOf("a", "b", "c")
    val upperList = mutableListOf<String>()
    for (lowerCase in lowerList) {
        upperList.add(lowerCase.uppercase())
    }
    println(upperList)


    // [for loop -> map 변환] map 사용
    val upperList2 = lowerList.map { it.uppercase() }
    println(upperList2)


    // filter 사용 x
    val filteredList = mutableListOf<String>()
    for (upperCase in upperList) {
        if (upperCase == "A" || upperCase == "C") {
            filteredList.add(upperCase)
        }
    }
    println(filteredList)

    // filter 사용
    val filteredList2 = upperList.filter { it == "A" || it == "C" }
    println(filteredList2)

}
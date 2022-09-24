package chap02

// 실드 클래스는 하위 클래스를 제한 조건에 따라 정의해야 하고, 실드 클래스의 하위 클래스는 컴파일러가 컴파일 시점에 판단할 수 있다.
// 제한 조건으로 코틀린 1.6 버전 기준으로 같은 패키지 또는 모듈 안에 있는 경우에만 하위 클래스를 정의할 수 있다.
sealed class Developer {
    abstract val name: String
    abstract fun code(language: String)
}


data class BackendDeveloper(override val name: String) : Developer() {
    override fun code(language: String) {
        println("저는 백엔드 개발자입니다. ${language}를 사용합니다.")
    }
}

data class FrontendDeveloper(override val name: String) : Developer() {
    override fun code(language: String) {
        println("저는 프론트엔드 개발자입니다. ${language}를 사용합니다.")
    }
}


/*
object DeveloperPool {
    val pool = mutableMapOf<String, Developer>()

    // sealed 클래스가 아닌 경우 else 가 없으면 컴파일 오류가 발생함
    // 컴파일러는 Developer를 상속한 하위 클래스가 몇개가 되는지 어떤 클래스가 상속 받고 있는지 모른다.
    fun add(developer: Developer) = when (developer) {
        is BackendDeveloper -> pool[developer.name] = developer
        is FrontentDeveloper -> pool[developer.name] = developer
        else -> {
            println("지원하지 않는 개발자 입니다.")
        }
    }

    fun get(name: String) = pool[name]

}
 */


data class AndroidDeveloper(override val name: String) : Developer() {
    override fun code(language: String) {
        println(" ${language} ")
    }
}

data class IosDeveloper(override val name: String) : Developer() {
    override fun code(language: String) {
        println(" ${language} ")
    }
}

object OtherDeveloper : Developer() {

    override val name: String = "익명"

    override fun code(language: String) {
        TODO("Not yet implemented")
    }

}

// sealed를 사용해서 else 를 제거할 수 있기 때문에 버그가 줄어든다.
object DeveloperPool {
    val pool = mutableMapOf<String, Developer>()

    fun add(developer: Developer) = when (developer) {
        is BackendDeveloper -> pool[developer.name] = developer
        is FrontendDeveloper -> pool[developer.name] = developer
        is AndroidDeveloper -> pool[developer.name] = developer
        is IosDeveloper -> pool[developer.name] = developer
        is OtherDeveloper -> println("지원하지 않는 개발자 종류입니다.")
    }

    fun get(name: String) = pool[name]
}

fun main() {
    val backendDeveloper = BackendDeveloper(name = "토니")
    DeveloperPool.add(backendDeveloper)

    val frontendDeveloper = FrontendDeveloper(name = "헐크")
    DeveloperPool.add(frontendDeveloper)

    println(DeveloperPool.get("토니"))
    println(DeveloperPool.get("헐크"))
}

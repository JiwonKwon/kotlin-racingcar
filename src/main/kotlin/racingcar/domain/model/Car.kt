package racingcar.domain.model

class Car(
    val name: String,
    position: Int = DEFAULT_POSITION,
    private val movingStrategy: MovingStrategy = RandomMovingStrategy()
) {
    init {
        require(isValidName(name)) { "자동차의 이름은 빈 값이거나 5자가 넘어가면 안됩니다" }
    }

    var position: Int = position
        private set

    fun move() {
        if (movingStrategy.tryMove()) position++
    }

    private fun isValidName(name: String) = !(name.isBlank() || name.length > 5)

    companion object {
        private const val DEFAULT_POSITION: Int = 0
    }
}
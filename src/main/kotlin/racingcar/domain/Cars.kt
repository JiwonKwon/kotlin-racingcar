package racingcar.domain

import racingcar.view.OutputView

class Cars(nameOfCars: List<String>, movingConditionStrategy: MovingConditionStrategy) {
    private val cars = mutableListOf<Car>()
    init {
        nameOfCars.map { cars.add(Car(movingConditionStrategy, it)) }
    }

    fun race(gameInputValue: GameInputValue) {
        val outputView = OutputView()
        iterateNumberOfGames(gameInputValue, outputView)
    }

    fun showResult(): String {
        return OutputView().showWinner(WinnerSelector(cars).selectWinner())
    }

    private fun iterateNumberOfGames(gameInputValue: GameInputValue, outputView: OutputView) {
        for (numberOfGames in 0 until gameInputValue.inputNumberOfGames) {
            iterateNumberOfCars(gameInputValue, outputView)
        }
    }

    private fun iterateNumberOfCars(gameInputValue: GameInputValue, outputView: OutputView) {
        for (numberOfCars in 0 until gameInputValue.inputNameOfCars.size) {
            moveCar(numberOfCars)
            showCarPosition(numberOfCars, gameInputValue.inputNameOfCars.size, outputView)
        }
    }

    private fun moveCar(numberOfCars: Int) {
        cars[numberOfCars].move()
    }

    private fun showCarPosition(numberOfCars: Int, nameOfCarsSize: Int, outputView: OutputView) {
        cars[numberOfCars].showPosition(isLastCarCycle(numberOfCars, nameOfCarsSize), outputView)
    }

    private fun isLastCarCycle(numberOfCar: Int, nameOfCarsSize: Int): Boolean {
        return numberOfCar == nameOfCarsSize - 1
    }
}
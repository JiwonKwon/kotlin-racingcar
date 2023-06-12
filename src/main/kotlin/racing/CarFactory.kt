package racing

import racing.domain.Car
import racing.generator.DefaultNumberGenerator

class CarFactory {

    fun createCarsByInputCount(carCount: Int): List<Car> {
        return (0 until carCount).map {
            Car(moveNumber = DefaultNumberGenerator())
        }
    }

    fun createCarsByInputCarName(inputCarName: String): List<Car> {
        return inputCarName.split(",").map { carName ->
            Car(moveNumber = DefaultNumberGenerator(), name = carName)
        }
    }
}

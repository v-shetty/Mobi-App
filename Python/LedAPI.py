from sense_hat import SenseHat
from time import sleep

sense = SenseHat()




def TurnRed() :
    X = [255, 0, 0]
    matrixRed= [
        X, X, X, X, X, X, X, X,
        X, X, X, X, X, X, X, X,
        X, X, X, X, X, X, X, X,
        X, X, X, X, X, X, X, X,
        X, X, X, X, X, X, X, X,
        X, X, X, X, X, X, X, X,
        X, X, X, X, X, X, X, X,
        X, X, X, X, X, X, X, X,
    ]
    sense.set_pixels(matrixRed)
    # sleep(1)
    # sense.clear()

def TurnGreen():
    X = [0, 255, 0]
    matrixGreen = [
        X, X, X, X, X, X, X, X,
        X, X, X, X, X, X, X, X,
        X, X, X, X, X, X, X, X,
        X, X, X, X, X, X, X, X,
        X, X, X, X, X, X, X, X,
        X, X, X, X, X, X, X, X,
        X, X, X, X, X, X, X, X,
        X, X, X, X, X, X, X, X,
    ]
    sense.set_pixels(matrixGreen)
    # sleep(1)
    # sense.clear()

def TurnOn() :
    TurnGreen()

def TurnOff() :
    TurnRed()
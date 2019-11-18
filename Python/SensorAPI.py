from sense_hat import SenseHat
from time import sleep

sense = SenseHat()


# while True :
#
#     event = sense.stick.wait_for_event()
#     print("The joystick was {} {}".format(event.action, event.direction))
#     sleep(1)
#     event = sense.stick.wait_for_event()
#     print("The joystick was {} {}".format(event.action, event.direction))

# while True:
#         event= sense.stick.get_events()
#         if not event :
#             print("pressed")
#         else :
#             print("empty")
#
#         print(event)
#         sleep(1)


def getState() :
    event = sense.stick.get_events()
    if not event:
        return 1
    else:
        return 0

    print(event)

def ReadTemp() :
    temp = sense.get_temperature_from_pressure()
    return temp

def ReadHumidity() :
    humidity = sense.get_humidity()
    return humidity

def ReadPressure() :
    pressure = sense.get_pressure()
    return pressure
def ReadRoll() :
    orientation = sense.get_orientation_degrees()
    roll = orientation["pitch"]
    return roll

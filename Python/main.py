import pyrebase
import time
from time import sleep
from sense_hat import SenseHat
import LedAPI
import SensorAPI




#Firebase Configuration
config = {
  "apiKey": "apiKey",
  "authDomain": "andriodstudiotest.firebaseio.com",
  "databaseURL": "https://andriodstudiotest.firebaseio.com",
  "storageBucket": "andriodstudiotest.appspot.com"
}

#Firebase Database Initialization
firebase = pyrebase.initialize_app(config)

#Firebase get database reference
db = firebase.database()


while True :

    temp = SensorAPI.ReadTemp();
    emission = SensorAPI.ReadHumidity();
    pressure = SensorAPI.ReadPressure()
    battery = SensorAPI.ReadTemp()*2.5;





    door = db.child("Door").get()
    engine = db.child("Engine").get()

    if engine.val() == "0" :

        LedAPI.TurnOff()
        db.child("Temperature").set("----")
        db.child("Emission").set("----")
        db.child("Pressure").set(str(round(pressure, 2)))
        db.child("Battery").set(str(round(battery, 2)))



    elif engine.val() == "1" :

        db.child("Temperature").set(str(round(temp, 2)))
        db.child("Emission").set(str(round(emission, 2)))
        db.child("Pressure").set(str(round(pressure, 2)))
        db.child("Battery").set(str(round(battery, 2)))
        LedAPI.TurnOn()

    status = SensorAPI.getState()

    if status == 1 :
        print("Status OK")
        db.child("Status").set("OK")
        db.child("Service").set("25/12/2019")

    elif status == 0:
        print("Status NOT OK")
        db.child("Status").set("NOT OK")
        db.child("Service").set("16/11/2019")




    sleep(1)










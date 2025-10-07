from ElectricTrain import ElectricTrain

def main():
    train = ElectricTrain("John", wagons=5)
    train.lock_doors()
    train.start()
    train.accelerate(130)
    train.toggle_lights()
    train.brake(80)
    train.stop()
    train.unlock_doors()

if __name__ == "__main__":
    main()
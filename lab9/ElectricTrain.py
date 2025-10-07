from Locomotive import Locomotive
class ElectricTrain(Locomotive):
    def __init__(self, driver_name, wagons=0, max_speed=100, max_passengers=0, route=None):
        super().__init__(driver_name, wagons, max_speed)
        self.max_passengers = max_passengers
        self.current_passengers = 0
        self.route = route
        self.doors_locked = False

    def board(self, count = 1):
        space = self.max_passengers - self.current_passengers
        taking = min(space, count)
        self.current_passengers += taking
        print(f"{taking} passengers boarded ({self.current_passengers}/{self.max_passengers}).")
        if taking < count:
            print(f"{count - taking} passengers could not board: no space.")

    def alight(self, count=1):
        leaving = min(self.current_passengers, count)
        self.current_passengers -= leaving
        print(f"{leaving} passengers alighted ({self.current_passengers}/{self.max_passengers}).")
        if leaving < count:
            print(f"Requested {count} to alight, only {leaving} could leave.")

    def lock_doors(self):
        self.doors_locked = True
        print("Doors locked.")

    def unlock_doors(self):
        self.doors_locked = False
        print("Doors unlocked.")

    def start(self):
        if not self.doors_locked:
            print("Warning: doors are open. Recommended to lock before starting.")
        if self.current_passengers > self.max_passengers:
            print("Cannot start: too many passengers!")
            return
        super().start()
    
    def __str__(self):
        base = super().__str__().rstrip(")")
        return base + f", passengers={self.current_passengers}/{self.max_passengers})"
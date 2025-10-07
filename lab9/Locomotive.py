class Locomotive:
    def __init__(self, driver_name, wagons=0, max_speed=120):
        self.driver_name = driver_name
        self.wagons = wagons
        self.max_speed = max_speed
        self.current_speed = 0
        self.is_running = False
        self.lights_on = False

    def start(self):
        if self.is_running:
            print("Locomotive is already running")
            return
        self.is_running = True
        self.current_speed = 0
        print(f"{self.__class__.__name__} started. Driver: {self.driver_name}")

    def stop(self):
        if not self.is_running:
            print("Locomotive is already stopped.")
            return
        self.current_speed = 0
        self.is_running = False
        print(f"{self.__class__.__name__} stopped.")

    def accelerate(self, delta):
        if not self.is_running:
            print("Cannot accelerate: locomotive is not running.")
            return
        new_speed = self.current_speed + delta
        if new_speed > self.max_speed:
            self.current_speed = self.max_speed
            print(f"Maximum speed reached: {self.max_speed} km/h.")
        else:
            self.current_speed = new_speed
            print(f"Current speed: {self.current_speed} km/h.")
    
    def brake(self, delta):
        self.current_speed = max(0, self.current_speed - delta)
        print(f"Speed after braking: {self.current_speed} km/h.")

    def toggle_lights(self):
        self.lights_on = not self.lights_on
        state = "on" if self.lights_on else "off"
        print(f"Lights {state}")

    def __str__(self):
        return f"{self.__class__.__name__}(driver={self.driver_name}, wagons={self.wagons}, speed={self.current_speed}/{self.max_speed}, running={self.is_running})"

    
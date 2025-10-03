import math
import struct

def calculate_expression(x:float) -> float:
    """
    Calculates the value of the expression y = cos(x) /(x + 2 * cot(x)).
    :param x: variable value (in radians)
    :return: calculation result
    """

    #when sin(x) is close to 0, then it is impossible to solve the equation
    if math.isclose(math.sin(x), 0.0, abs_tol=1e-9):
        raise ValueError("cot(x) не визначено для цього x (sin(x) = 0)")
    
    cot_x = math.cos(x) / math.sin(x)
    denominator = x + 2 * cot_x

    if math.isclose(denominator, 0.0, abs_tol = 1e-9):
        raise ValueError("The divisor is 0, no calculation is possible")

    return math.cos(x) / denominator

def write_text(filename: str, x: float, y:float) -> None:
    """
    Write the results to a text file
    """
    with open(filename, "w", encoding = "utf-8") as f:
        f.write(f"x = {x}\n")
        f.write(f"y = {y}\n")

def read_text(filename: str) -> str:
    """
    Reading results from a text file
    """
    with open(filename, "r", encoding = "utf-8") as f:
        return f.read()
    
def write_binary(filename: str, x: float, y: float) -> None:
    """
    Write results to a binary file
    The format used is 'dd' = two numbers of type double
    """
    with open(filename, "wb") as f:
        f.write(struct.pack("dd",x , y))

def read_binary(filename: str) -> tuple:
    """
    Reading results from a binary file
    """
    with open(filename, "rb") as f:
        data = f.read()
        return struct.unpack("dd", data)
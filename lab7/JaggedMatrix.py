#Module for generating a toothed list with shaded areas
#Author: Yaremchuk Kostiantyn

def gen_jagged_matrix(size: int, fill_char: str) -> list[list[str]]:
    """
    The function generates a square matrix of size x size
    with shaded areas in the shape of "teeth".
    :param size: square matrix size
    :param fill_char: placeholder symbol for "shaded" areas
    :return: matrix in the form of a list of lists
    """
    matrix = []

    for i in range(size):
        row = []
        for j in range(size):
            if j >= (size - i - 1):
                row.append(fill_char)
            else:
                row.append(" ")
        matrix.append(row)
    return matrix

def print_matrix(matrix: list[list[str]]) -> None:
    """
    The function displays the matrix on the screen
    """
    for row in matrix:
        print(" ".join(row))

def main():
    """
    The main function of the module.
    Performs user input and forms a matrix.
    """
    try:
        size_input = input("Enter the size of the square matrix: ")
        size = int(size_input)
        if size <= 0:
            print("The matrix size must be a positive number!")
            return

        fill_char = input("Enter the placeholder symbol: ")
        if len(fill_char) != 1:
            print("Incorrect character entered! There should be only one character.")
            return

    except ValueError:
        print("Incorrect number!")
        return

    matrix = gen_jagged_matrix(size, fill_char)
    
    print("\nGear matrix:")
    print_matrix(matrix)


if __name__ == "__main__":
    main()
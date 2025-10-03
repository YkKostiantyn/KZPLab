def gen_jagged_matrix(size: int, fill_char: str) -> list[list[str]]:
    matrix = []

    for i in range(size):
        row = []
        for j in range(size):
            if j <= (size - i - 1):
                row.append(fill_char)
            else:
                row.append(" ")
        matrix.append(row)
    return matrix

def print_matrix(matrix: list[list[str]]) -> None:
    for row in matrix:
        print(" ".join(row))

def main():
    try:
        size_input = input("Введіть розмір квадратної матриці: ")
        size = int(size_input)
        if size <= 0:
            print("Розмір матриці має бути додатнім числом!")
            return

        fill_char = input("Введіть символ-заповнювач: ")
        if len(fill_char) != 1:
            print("Введено некоректний символ! Повинен бути лише один символ.")
            return

    except ValueError:
        print("Некоректне число!")
        return

    matrix = gen_jagged_matrix(size, fill_char)
    
    print("\nЗубчаста матриця:")
    print_matrix(matrix)


if __name__ == "__main__":
    main()
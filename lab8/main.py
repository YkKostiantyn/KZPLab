from expressionModule import calculate_expression, read_text, read_binary, write_text, write_binary

def main():
    try:
        x = float(input("Enter the value of x (in radians): "))

        # Expression calculation
        y = calculate_expression(x)
        print(f"Result: y = {y}")

        # Write to a text file
        write_text("result.txt", x, y)
        print("The result is saved in a text file result.txt")

        # Reading from a text file
        print("Content of the text file:")
        print(read_text("result.txt"))

        # Writing to a binary file
        write_binary("result.bin", x, y)
        print("The result is saved in a binary file result.bin")

        # Reading from a binary file
        xb, yb = read_binary("result.bin")
        print(f"Read from binary file: x = {xb}, y = {yb}")

    except ValueError as e:
        print("Error:", e)
    except Exception as e:
        print("Unforeseen error:", e)


if __name__ == "__main__":
    main()
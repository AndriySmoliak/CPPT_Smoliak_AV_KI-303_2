
def lengthOfEachSubArray(size):
    arr = [None] * size
    mid = size // 2

    for i in range(size):
        length = 0
        for j in range(size):
            if (i + j >= mid) and (j - i <= mid) and (i - j <= mid) and (j + i <= (3 * mid)):
                length += 1
        arr[i] = [""] * length

    return arr

def printMatrix(arr, symbol, size, file):
    print("Ğåçóëüòàò ìàòğèö³")

    with open(file, "w", encoding="utf-8") as writer:
        mid = size // 2

        for i in range(size):
            index_j = 0
            for j in range(size):
                if (i + j >= mid) and (j - i <= mid) and (i - j <= mid) and (j + i <= (3 * mid)):
                    arr[i][index_j] = symbol
                    writer.write(arr[i][index_j] + " ")
                    print(arr[i][index_j], end=" ")
                    index_j += 1
                else:
                    writer.write("  ")
                    print("  ", end="")
            print()
            writer.write("\n")
        writer.flush()

if __name__ == '__main__':
    size = int(input("Ââåä³òü ğîçì³ğ ìàòğèö³: "))
    symbol = input("Ââåä³òü ñèìâîë çàïîâíşâà÷: ")

    if len(symbol) != 1:
        print("Ââåä³òü êîğåêòíèé ñèìâîë çàïîâíşâà÷")
    else:
        arr = lengthOfEachSubArray(size)
        file_name = "matrix_output.txt"
        printMatrix(arr, symbol, size, file_name)

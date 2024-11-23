import random

def fileIdGenerator(digit):
    nowDigit = 0

    file_id = ""
    
    while nowDigit < digit:
        char = random.randint(1,36)
        file_id += returnChar(char)
        nowDigit += 1

    return file_id

def returnChar(i):
    if i == 1:
        return "1"
    elif i == 2:
        return "2"
    elif i == 3:
        return "3"
    elif i == 4:
        return "4"
    elif i == 5:
        return "5"
    elif i == 6:
        return "6"
    elif i == 7:
        return "7"
    elif i == 8:
        return "8"
    elif i == 9:
        return "9"
    elif i == 10:
        return "0"
    elif i == 11:
        return "a"
    elif i == 12:
        return "b"
    elif i == 13:
        return "c"
    elif i == 14:
        return "d"
    elif i == 15:
        return "e"
    elif i == 16:
        return "f"
    elif i == 17:
        return "g"
    elif i == 18:
        return "h"
    elif i == 19:
        return "i"
    elif i == 20:
        return "j"
    elif i == 21:
        return "k"
    elif i == 22:
        return "l"
    elif i == 23:
        return "m"
    elif i == 24:
        return "n"
    elif i == 25:
        return "o"
    elif i == 26:
        return "p"
    elif i == 27:
        return "q"
    elif i == 28:
        return "r"
    elif i == 29:
        return "s"
    elif i == 30:
        return "t"
    elif i == 31:
        return "u"
    elif i == 32:
        return "v"
    elif i == 33:
        return "w"
    elif i == 34:
        return "x"
    elif i == 35:
        return "y"
    elif i == 36:
        return "z"

#!/bin/python

# Fun
def read(prompt: str = "") -> int:
    val = None
    while True:
        val = input(prompt)
        try:
            val = int(val)
            if val < 1:
                raise Exception()
        except:
            print("Niepoprawne dane")
            continue
        break
    return val

# **********************************************
# nazwa funkcji: NWD
# opis funkcji: Oblicza NWD dla podanych dwóch liczb
# parametry: a (int) - pierwsza liczba (całkowita dodatnia) do obliczenia NWD
#  b (int) - druga liczba (całkowita dodatnia) do obliczenia NWD
# zwracany typ i opis: int - NWD podanych dwóch liczb
# autor: XYZ
# ***********************************************
def NWD(a: int, b: int) -> int:
    while a != b:
        if a > b:
            a -= b
        else:
            b -= a
    return a

# Start
print("Algorytm obliczający NWD, podaj dane")
a = read("A: ")
b = read("B: ")
result = NWD(a, b)
print(f"NWD podanych liczb: {result}")

# Ví dụ: 
# -	Input: s = hello1w5o144rd13gis7pro9gra4mm7in9g 
# 	Output: 
# o	Danh sách các số chính phương là: 144, 9, 4. 
# o	Tổng các chữ số vừa nhập là: 1 + 5 + 1 + 4 + 4 + 1 + 3 + 7 + 9 + 4 + 7 + 9 = 55 là một số Fibonacci. 
# o	Số lần xuất hiện của các kí tự vừa nhập là: h=1; e=1, l=2, o=3, w=1, r=3, d=1, g=3, i=2, s=1, p=1, a=1, m=2, n=1

import re
import math


# 1.	Viết chương trình trên Python cho phép người dùng nhập 1 dãy kí tự bao gồm cả chữ và số sau đó: 
def main():
    s = input("Nhập dãy kí tự: ")
    perfectSquare, digitSum, isFibonacci, charCount = process_string(s)
    
    print("Danh sách các số chính phương là:", perfectSquare)
    print(f"Tổng các chữ số vừa nhập là: {digitSum} {'là một số Fibonacci' if isFibonacci else 'không phải là một số Fibonacci'}")
    print("Số lần xuất hiện của các kí tự vừa nhập là:", end=" ")
    for char, count in charCount.items():
        print(f"{char}={count}", end='; ')
    print()

# Tìm số chính phương
def isPerfectSquare(n):
    if n < 0:
        return False
    root = int(math.isqrt(n))
    return root * root == n

# Kiểm tra số có phải là số Fibonacci 
def isFibonacciNumber(n):
    # Một số là số Fibonacci nếu (5n^2+4) là số chính phương hoặc (5n^2-4) là số chính phương.
    return isPerfectSquare(5 * n * n + 4) or isPerfectSquare(5 * n * n - 4)

# c.	Đếm số lần xuất hiện của các kí tự thuộc dãy kí tự vừa nhập và in kết quả ra ngoài màn hình. 
def process_string(s):
    # Tìm các số trong chuỗi
    numbers = list(map(int, re.findall(r'\d+', s)))
    # a. Kiểm tra xem dãy kí tự vừa nhập có bao nhiêu số chính phương và in ra ngoài màn hình. 
    perfectSquares = {num for num in numbers if isPerfectSquare(num) and num != 1}
    
    # b. Tính tổng các chữ số trong dãy kí tự vừa nhập.
    digitSum = sum(int(digit) for digit in re.findall(r'\d', s))
    
    # b Kiểm tra xem kết quả thu được có phải là một số Fibonacci hay không. 
    isFibonacci = isFibonacciNumber(digitSum)
    
    # Đếm số lần xuất hiện của các kí tự
    charCount = {}
    for char in s:
        if char.isalpha():
            if char in charCount:
                charCount[char] += 1
            else:
                charCount[char] = 1
    
    return perfectSquares, digitSum, isFibonacci, charCount

if __name__ == "__main__":
    main()

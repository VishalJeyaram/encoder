# 🔐 Custom Shift-Based Encoder/Decoder

A Java-based text obfuscation tool that implements a shift cipher using a custom reference table containing letters, numbers, and special symbols. Inspired by classical Caesar and Vigenère ciphers, this encoder allows dynamic shifting based on a selected offset character, creating an effective and customizable encoding/decoding scheme.

## 📌 Features

- Encode plaintext into an obfuscated string using a character-based offset
- Decode encoded messages back to original plaintext
- Custom reference table including `A-Z`, `0-9`, and symbols `()*+,-./`
- Preserves characters not found in the reference table
- Object-Oriented Design with clearly structured `encode()` and `decode()` methods
- Easily extensible and testable

## 🧠 Logic Overview

1. The **first character** of the encoded string is the **offset character**.
2. All valid characters (from the reference table) are **shifted based on the offset**.
3. Characters not found in the table are **left unchanged**.
4. Decoding uses the offset to **reverse the shift** and retrieve the original message.

### 🔄 Example

For offset `'B'` (1-shift):  
Plaintext : `HELLO WORLD`  
Encoded   : `BGDKKN VNQKC`

For offset `'F'` (5-shift):  
Plaintext : `HELLO WORLD`  
Encoded   : `FC/GGJ RJMG.`

## 🧱 Reference Table and Shift Variants

| Index | Original | Shift #1 (B) | Shift #2 (F) |
|-------|----------|--------------|--------------|
| 0     | A        | B            | F            |
| 1     | B        | A            | E            |
| 2     | C        | B            | D            |
| 3     | D        | C            | C            |
| 4     | E        | D            | B            |
| 5     | F        | E            | A            |
| 6     | G        | F            | B            |
| 7     | H        | G            | C            |
| 8     | I        | H            | D            |
| 9     | J        | I            | E            |
| 10    | K        | J            | F            |
| 11    | L        | K            | G            |
| 12    | M        | L            | H            |
| 13    | N        | M            | I            |
| 14    | O        | N            | J            |
| 15    | P        | O            | K            |
| 16    | Q        | P            | L            |
| 17    | R        | Q            | M            |
| 18    | S        | R            | N            |
| 19    | T        | S            | O            |
| 20    | U        | T            | P            |
| 21    | V        | U            | Q            |
| 22    | W        | V            | R            |
| 23    | X        | W            | S            |
| 24    | Y        | X            | T            |
| 25    | Z        | Y            | U            |
| 26    | 0        | Z            | V            |
| 27    | 1        | 0            | W            |
| 28    | 2        | 1            | X            |
| 29    | 3        | 2            | Y            |
| 30    | 4        | 3            | Z            |
| 31    | 5        | 4            | 0            |
| 32    | 6        | 5            | 1            |
| 33    | 7        | 6            | 2            |
| 34    | 8        | 7            | 3            |
| 35    | 9        | 8            | 4            |
| 36    | (        | 9            | 5            |
| 37    | )        | (            | 6            |
| 38    | *        | )            | 7            |
| 39    | +        | *            | 8            |
| 40    | ,        | +            | 9            |
| 41    | -        | ,            | (            |
| 42    | .        | -            | )            |
| 43    | /        | .            | *            |

## 🛠️ Installation & Running

### Prerequisites

- Java 8 or higher
- Git (optional, for cloning)

### Steps

```bash
# Clone the repository
git clone https://github.com/VishalJeyaram/encoder.git
cd encoder

# Compile and run
javac Encoder.java
java Encoder

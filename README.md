# Passgen

My first password generator made in Java with customizable character sets and Fisher-Yates shuffling algorithm :)

## Features

- **Customizable character counts**: Specify exact numbers of digits, lowercase, uppercase, and special characters
- **Fisher-Yates shuffling**: Ensures truly random character distribution using the Fisher-Yates algorithm. I used this video to understand: [Fisher-Yates algorithm](https://www.youtube.com/watch?v=TdOUjGfv1Gs)
- **Secure random generation**: Uses `SecureRandom` for cryptographically strong randomness
- **Automatic clipboard copy**: Automatically copies passwords to system clipboard (when supported)
- **File output for long passwords**: Automatically saves passwords >1000 characters to `password.txt`

## Usage

```bash
javac Passgen.java
java Passgen
```

The program will prompt you for:
- Number of digits (0-9)
- Number of lowercase letters (a-z)
- Number of uppercase letters (A-Z)
- Number of special characters (!@#$%^&*()-_=+[]{}|;:',.<>?/)


I tested this with a `40 million` character password (LOL), enjoy!

- **Customizable character counts**: Specify exact numbers of digits, lowercase, uppercase, and special characters
- **Fisher-Yates shuffling**: I used this video to understand: [Fisher-Yates algorithm](https://www.youtube.com/watch?v=TdOUjGfv1Gs)
- Automatically copies passwords to system clipboard (when supported)
- Automatically saves passwords >1000 characters to `password.txt`

### Usage

```bash
javac Passgen.java
java Passgen
```
Prompt order:
- Number of digits (0-9)
- Number of lowercase letters (a-z)
- Number of uppercase letters (A-Z)
- Number of special characters (!@#$%^&*()-_=+[]{}|;:',.<>?/)


I tested this with a `40 million` character password (LOL)


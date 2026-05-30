void main() {

    /*
                      Data Structures
                             │
             ┌───────────────┴───────────────┐
             ▼                               ▼
           Linear                         Non-Linear
             │                               │
       ┌─────┴─────┐           ┌─────────────┼─────────────┐
       ▼           ▼           ▼             ▼             ▼
     Static      Dynamic      Trees        Graphs      Hash Tables
       │           │           │             │             │
       └►Array     ├►List      ├►Binary      ├►Directed    ├►HashMap
                   ├►Stack     ├►BST         ├►Undirected  └►HashSet
                   └►Queue     ├►AVL/RB      └►Weighted
                               └►B/B+ Tree

     */
    // 1. Integer Types (Whole numbers)
    byte byteVar = 127;                   // 1 byte: 8 bits => 2^8-1 = 127
    short shortVar = 32767;               // 2 bytes
    int intVar = 11;                      // 4 bytes
    long longVar = 13333L;                // 8 bytes (Note: use Uppercase 'L' is for readability)

    // 2. Floating-Point Types (Decimals)
    float floatVar = 11.3f;               // 4 bytes
    double doubleVar = 11.3;              // 8 bytes //by default hence d unnecessary

    // 3. Character Type
    char charVar = 'c';                   // 2 bytes (Stores a single character/Unicode)

    // 4. Boolean Type
    boolean booleanVar = true;            // 1 bit (true or false)

    // Printing Integer and Floating-Point primitives
    IO.println("Numbers: " + byteVar + ", " + shortVar + ", " + intVar + ", " + longVar + ", " + floatVar + ", " + doubleVar);

    // Printing Character and Boolean primitives
    IO.println("Others: " + charVar + " " + booleanVar);


}
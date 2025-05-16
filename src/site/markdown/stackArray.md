
# 🧱 MyStackArray - A Generic Stack Implementation Using Arrays

Welcome to the documentation of `MyStackArray` 📚 — a fully generic stack implementation using arrays as the underlying data structure.

---

## 🛠️ Class Overview

The `MyStackArray<E>` class allows you to manage a stack of elements of any type `E`. It supports all essential stack operations (push, pop, peek, etc.) and adds additional functionality like resizing, clearing, and introspection.

```java
public class MyStackArray<E> {
    E[] array;
    int top;
    Class<E> clazz;
}
```

- `array`: internal array holding elements.
- `top`: index of the top element in the stack.
- `clazz`: stores the class type for creating generic arrays.

---

## 🚀 Constructor

### `MyStackArray(int initialSize, Class<E> clazz)`

Initializes the stack with a specific initial size.

- 🔢 `initialSize`: starting capacity of the stack.
- 🧬 `clazz`: class type of the generic type `E` used to instantiate the array via reflection.

---

## 📏 size()

Returns the number of elements currently in the stack.

```java
public int size()
```

🧠 Logic: Returns `top + 1`, since `top` starts at -1.

---

## 📦 isEmpty()

Checks if the stack is empty.

```java
public boolean isEmpty()
```

✅ Returns `true` if `top == -1`, meaning no elements are present.

---

## 📈 isFull()

Checks whether the stack has reached its current array capacity.

```java
public boolean isFull()
```

🔐 Useful for deciding when to call `resize()`.

---

## ➕ push(E newElement)

Adds an element to the top of the stack. If the stack is full, it automatically doubles the array size.

```java
public void push(E newElement)
```

- 💥 Auto-resizes when needed.
- 🔼 Increments `top` and stores the element at `array[top]`.

---

## ➖ pop()

Removes and returns the top element of the stack.

```java
public E pop()
```

- ❌ Throws `NoSuchElementException` if the stack is empty.
- 📤 Internally calls `peek()` and then decrements `top`.

---

## 👀 peek()

Returns the element at the top without removing it.

```java
public E peek()
```

- ⚠️ Also throws `NoSuchElementException` if stack is empty.
- ✅ Useful for inspecting the last added element.

---

## 🧬 resize()

Doubles the size of the internal array when full.

```java
public void resize()
```

- 🛠️ Uses `System.arraycopy` to copy elements.
- 🧪 Respects generic type safety via reflection.

---

## 🧹 clear()

Resets the logical content of the stack by setting `top = -1`.

```java
public void clear()
```

⚠️ Elements remain in memory but are not accessible.

---

## 🔥 clearComplete()

Completely resets the stack by nullifying all elements and resetting the top.

```java
public void clearComplete()
```

🧼 Ensures all references are removed, aiding garbage collection.

---

## 🪞 toString()

Returns a readable string representation of the stack.

```java
public String toString()
```

🧾 Example: `[1, 2, 3]`

- Uses `StringBuilder` for performance.
- Empty stack returns `"[]"`.

---

## ✅ Summary

`MyStackArray` is:

- ✅ Type-safe (thanks to generics)
- ✅ Auto-resizing
- ✅ Fully covered by unit tests (100% 🧪)
- ✅ Easy to use



# 🌲 MyStackList - A Generic Stack Implementation with a Linked List

Welcome to the documentation of `MyStackList` 📚 — a generic stack implementation that uses a singly linked list as its underlying data structure.

---

## 🛠️ Class Overview

The `MyStackList<E>` class allows you to manage a stack of arbitrary elements of type `E`. In addition to the classic stack operations (push, pop, peek), it offers additional list functionality such as adding and removing at the beginning and end, as well as a string representation of the list.

```java
public class MyStackList<E> {

Node<E> head;

Node<E> tail;

int size = 1;
}
```

- `head`: Points to the first element of the list (stack top).
- `tail`: Points to the last element of the list.
- `size`: Number of elements in the list.

---

## 🚀 Constructor

### `MyStackList(Node<E> head)`

Creates a new list with a given initial node.

- ⚙️ `head`: The initial node of the list (stack base and starting point of the linked list).
- 🛠️ Sets both `head` and `tail` to this node.

---

## 📏 size()

Returns the current number of elements in the list.

```java
public int size()
```

🧠 Returns the value of `size`.

---

## 📦 isEmpty()

Checks whether the list is empty.

java public boolean isEmpty()
```

✅ Returns `true` if `head == null` (i.e., there are no elements).

```
---

## ➕ push(E newElement)

Adds a new element to the top of the stack (at the beginning of the list).

java public void push(E newElement)
```

- 🔼 Creates a new node and sets it as the new `head`.
- 📈 Increases the `size` by 1.

```
---

## ➖ pop()

Removes and returns the top element of the stack (beginning of the list).

java public E pop()
```

- ❌ Throws `NoSuchElementException` if the list is empty.
- 🔽 Removes `head` and pushes it to the next element.
- 📉 Decrements `size` by 1.

```
---

## 👀 first()

Returns the first element (at the top of the stack) without removing it.

```java
public E first()
```

- ❌ Throws `NoSuchElementException` if empty.
- ✅ Useful for viewing the top of the stack.

---

## 👀 last()

Returns the last element of the list (at the bottom of the stack).

```java
public E last()
```

- ❌ Throws `NoSuchElementException` if empty.
- ✅ Useful for checking the end of the list.

---

## ➕ addFirst(E newElement)

Adds an element to the top of the list (like `push`).

java
public void addFirst(E newElement)
```

- 🔼 New node becomes `head`.
- 📈 `size` is incremented.

```

---

## ➕ addLast(E newElement)

Adds an element to the end of the list.

java
public void addLast(E newElement)
```

- 🔙️ If empty, the element becomes `head` and `tail`.
- 🔗 Otherwise, the new node is appended to `tail.next` and `tail` is adjusted.
- 📈 `size` is incremented.

```

---

## ➖ deleteFirst()

Removes the first element from the list.

java
public void deleteFirst()
```

- 🔽 `head` is set to `head.next`.
- 📉 `size` is decremented.
- ⚠️ If the list becomes empty, `tail` is also set to `null`.

```
---

## ➖ deleteLast()

Removes the last element of the list.

```java
public void deleteLast()
```

- ⚙️ Traverses the list to the second-to-last element.
- 🔗 Sets `tail` to the second-to-last node and `next` to `null`.
- 📉 `size` is decremented.
- ⚠️ If only one element exists, `head` and `tail` are set to `null`.

---

## 🧹 clear()

Clears the entire list.

```java
public void clear()
```

- Sets `head` and `tail` to `null`.
- Sets `size` to 0.

---

## 🪞 listAsString()

Returns a string representation of the list in the format:

`element1 -> element2 -> ... -> null`

```java
public String listAsString()
```

- 📜 Returns `"null"` if the list is empty.
- 🔄 Traverses all nodes and appends their data to a `StringBuilder`.

---

## ✅ Summary

`MyStackList` is:

- ✅ Generic and flexible for any element type.
- ✅ Implements basic stack functions via a linked list.
- ✅ Provides additional list operations (addFirst, addLast, deleteFirst, deleteLast).
- ✅ Dynamic in size — no fixed capacity.
- ✅ Easily expandable and intuitive to use.
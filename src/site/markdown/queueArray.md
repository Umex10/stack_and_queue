# 📬 MyQueueArray – A Generic Queue Implementation Using Arrays

Welcome to the documentation of `MyQueueArray` 📚 — a fully generic queue implementation using arrays as the underlying data structure. This queue follows the **FIFO (First In, First Out)** principle, ensuring elements are processed in the order they were added.

---

## 🚀 Overview

`MyQueueArray` is a generic queue implementation in Java, built with the goal of understanding core data structure behavior without relying on built-in libraries like ``java.util.Queue``. It internally uses a fixed-size array and provides standard queue operations like **put**, **get**, **size**, and **isEmpty**.

---

## 🧠 Key Concepts

[X] FIFO behavior: Elements are added to the back and removed from the front.

[X] Generic support: You can create queues of any data type using Java generics.

[X] Fixed size: The queue has a maximum capacity defined at creation.

---

## 🛠 Constructor and the Member Variables

```java

      private int size;
      private int maxSize;
      private E[] queue;
      Class<E> clazz;
      
public MyQueueArray(int maxSize, Class<E> clazz)
{
      this.maxSize = maxSize;
      this.clazz = clazz;
      this.queue = (E[]) Array.newInstance(clazz, maxSize);
      this.size = -1;
}
```

---

- maxSize: Maximum number of elements the queue can hold.

- clazz: Class type for the generic array.

> The constructor initializes the internal array and sets the queue to an empty state.

---

## 📚 Methods

- ``put(E element)``
  - Adds an element to the back of the queue.

  - Shifts all existing elements one index forward to preserve FIFO behavior.

  - Throws IllegalArgumentException if the queue is already full.

- ``get() : E``
  - Removes and returns the element at the front of the queue.

  - Throws IllegalArgumentException if the queue is empty.

- ``isEmpty() : boolean``
  - Returns true if the queue contains no elements.

- ``size() : int``
  - Returns the number of elements currently stored in the queue.

---

## 📁 Example Usage

```java

MyQueueArray<String> queue = new MyQueueArray<>(5, String.class);

queue.put("A");
queue.put("B");
queue.put("C");

System.out.println(queue.get()); // Output: A
System.out.println(queue.size()); // Output: 2```
```

---

## ⚙️ Internal Design

**Internally, the array is managed as follows:**

queue[0] always holds the most recently added element.

Elements are shifted forward on every put() call.

The oldest element is removed from the highest active index on get().

*This might seem reversed compared to a naive queue implementation, but it effectively maintains FIFO behavior using array shifting.*

---

## 🧩 Supporting Class: Node\<E>

Though not used directly in MyQueueArray, a Node\<E> class is included — likely for potential future linked list-based implementations.

```java

public class Node<E> {
    E data;
    Node<E> next;
    Node<E> prev;

    public Node(E data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

```

---

## 🧪 Testing & Validation

**Also Tests are included for this class testing and checking for special cases like:**

- Adding elements until full → expect exception.

- Removing elements until empty → expect exception.

- Verifying order: ensure the first inserted element is the first removed.

- Edge cases: zero-length queue, alternating put/get calls, etc.

---

## 📌 Limitations

- Fixed capacity: No dynamic resizing — you must define the max size upfront.

- Shift cost: Each insertion causes a full shift of existing elements, making ``put()`` **O(n)**.

---

## 🧱 Ideal For

- **Learning** and teaching purposes

- **Scenarios** requiring controlled memory allocation

- **Exploring** the mechanics of array-based queues

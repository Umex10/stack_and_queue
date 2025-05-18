# 🔁 MyQueueList – A Generic Queue Implementation Using a Doubly Linked List

Welcome to the documentation of `MyQueueList` 🧾 — a generic, doubly linked list-based queue implementation in Java. This structure follows the **FIFO (First In, First Out)** principle, meaning elements are removed in the order they were added.

---

## 🚀 Overview

*MyQueueList implements a queue using a custom doubly linked list structure (Node\<E>). This queue allows generic type parameters and supports the fundamental queue operations: adding (put) and removing (get) elements. Unlike the array-based version, this implementation dynamically adjusts in size and doesn't require shifting of elements.*

---

## 🧠 Key Concepts

**Doubly linked list:** Each node maintains references to both previous and next nodes.

**FIFO behavior:** Elements are added to the back and removed from the front.

**Dynamic sizing:** The queue can grow without predefined limits (memory allowing).

---

## 🛠 Constructor and the Member Variables

```java
private E Element;
      private int size = 1;
      private Node<E> head;
      @SuppressWarnings("unused")
      private Node<E> tail;
      private Node<E> pointer;
      
      public MyQueueList (Node<E> NodeElement)
      {
            this.head = NodeElement;
            this.tail = NodeElement;
      }

```

---

- Initializes the queue with a single starting node.

- Sets both head and tail to the provided node.
  - the head being at the beginning (The first added and the first that is going to be deleted)
  - the tail being at the end (The last added and the last that is going to be deleted)

- Starts with a size of 1.

---

## 📚 Methods

- **put(E Element)**
  - Adds a new element to the back of the queue.

  - Creates a new node containing the given element.

  - Updates the tail and internal links accordingly.

  - Behavior differs depending on whether the queue is empty, has one element, or multiple.

- **get() : E**
  - Removes and returns the front element of the queue (i.e., the element pointed to by head).

  - Updates the head reference to point to the previous node in the list.

  - Throws IllegalArgumentException if the queue is empty.

- **isEmpty() : boolean**
  - Returns true if the queue is empty (size is 0), otherwise false.

- **size() : int**
  - Returns the number of elements currently stored in the queue.

## ⚙️ Internal Design

- `head`: Points to the front of the queue (the oldest element). This is the node whose `data` is returned when calling `get()`.

- `tail`: Points to the newest node added to the queue. It is updated each time a new element is added with `put()`. *(Note: It is not actively used for traversal or removal in this implementation, but may be useful for future features like peeking or iteration.)*

- `pointer`: This field plays a key role in linking new nodes into the queue efficiently. It always points to the node **before the current tail** — effectively tracking the "insertion point" for new elements. This allows the queue to build a backward chain of `prev` references without needing to traverse from `head`.

### 🔄 Example of pointer usage

Let’s say you add the elements in this order: `"A"`, `"B"`, `"C"`

1. You initialize the queue with a node `"A"`:

2. Add `"B"`:

- `head.prev = "B"`

- `pointer = "B"`

"B" ← "A" (head)  
↑  
pointer

3. Add `"C"`:

- `pointer.prev = "C"` (link `"B"` ← `"C"`)

- `pointer = "C"`

"C" ← "B" ← "A" (head)  
↑  
pointer

```sql

In this way, `pointer` avoids the need to traverse the list on each `put()` operation, keeping node insertion efficient and logically correct.

The structure grows backward (through `prev` references), and elements are removed from the `head` using the `get()` method, which simply moves the `head` pointer back one node and returns the removed data.

```

> The doubly linked structure allows traversal and removal from either end, but only the FIFO direction is used.

---

## 📁 Example Usage

```java

Node<String> startNode = new Node<>("First");
MyQueueList<String> queue = new MyQueueList<>(startNode);

queue.put("Second");
queue.put("Third");

System.out.println(queue.get()); // Output: First
System.out.println(queue.size()); // Output: 2

```

---

## 🧩 Supporting Class: Node\<E>

The queue uses the following Node structure:

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

> Each node contains the data element and pointers to the previous and next nodes in the list.

---

## 🧪 Testing

✅ Unit tests for MyQueueList are already implemented.

**Test scenarios include:**

- Enqueueing multiple elements

- Dequeueing elements and checking correct order

- Attempting to dequeue from an empty queue

- Edge cases like initializing with a single element and adding/removing around that

---


## 📌 Limitations & Considerations

- The implementation requires a Node\<E> object to initialize the queue.

- You must manually create the first node before using the queue, which may feel unintuitive for some users.

- It does not yet support iteration or peek functionality.

---

## 🧱 Ideal For

- **Learning** data structures, especially linked lists

- **Scenarios** where dynamic queue size is needed without array resizing

- **Understanding** pointer manipulation in doubly linked structures

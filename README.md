# Dining Philosophers Concurrency Problem - Java Implementation
https://github.com/afdeanon/Dining-Philosophers-Concurrency-Problem/blob/main/diningphilosophers.gif.mov

**A multithreaded Java implementation of the classic Dining Philosophers synchronization problem using ReentrantLocks and Condition variables to manage resource contention and prevent deadlock among competing philosopher threads.**

## 🍽️ Overview

This project implements the classic **Dining Philosophers Problem**, a fundamental synchronization problem in computer science that illustrates the challenges of resource allocation and deadlock prevention in concurrent programming.

The problem involves five philosophers sitting around a circular table, each alternating between thinking and eating. Each philosopher needs two chopsticks (forks) to eat, but there are only five chopsticks total, creating potential conflicts and synchronization challenges.

## 🎯 Problem Statement

- **5 Philosophers** sit around a circular table
- **5 Chopsticks** are placed between adjacent philosophers
- Each philosopher alternates between **thinking** and **eating**
- A philosopher needs **both adjacent chopsticks** to eat
- Must avoid **deadlock** and **starvation**

## 🏗️ Architecture

### Core Components

| Class | Purpose |
|-------|---------|
| `DiningPhilosophers` | Main entry point - creates and starts philosopher threads |
| `DiningServer` | Interface defining fork acquisition and release operations |
| `DiningService` | Concrete implementation handling synchronization logic |
| `Philosopher` | Thread representing individual philosopher behavior |

### Design Patterns Used

- **Strategy Pattern**: `DiningServer` interface allows different synchronization strategies
- **Thread-Safe Singleton**: `DiningService` manages shared resources
- **Producer-Consumer**: Philosophers compete for limited chopstick resources

## 🔧 Technical Implementation

### Synchronization Mechanism
- **ReentrantLock**: Provides exclusive access to chopsticks
- **Condition Variables**: Enable efficient thread waiting and signaling
- **Thread-Safe Operations**: All chopstick operations are atomic

### Key Features
- **Deadlock Prevention**: Uses strategic resource ordering
- **Random Sleep Times**: Simulates realistic thinking/eating durations (1-5 seconds)
- **Clean Resource Management**: Proper lock acquisition and release

## 🚀 Getting Started

### Prerequisites
- Java 8 or higher
- Basic understanding of multithreading concepts

### Running the Application

```bash
# Compile all Java files
javac *.java

# Run the simulation
java DiningPhilosophers
```

### Sample Output
```
Philosopher 1 is thinking
Philosopher 3 is eating
Philosopher 5 is thinking
Philosopher 2 is eating
Philosopher 4 is thinking
...
```

## 💡 Learning Outcomes

This implementation demonstrates key computer science concepts:

- **Concurrency Control**: Managing shared resources between threads
- **Deadlock Prevention**: Strategies to avoid circular wait conditions
- **Thread Synchronization**: Using locks and conditions for coordination
- **Race Condition Mitigation**: Ensuring thread-safe operations

*This implementation provides a solid foundation for understanding classical synchronization problems and serves as a stepping stone to more complex concurrent programming challenges.*

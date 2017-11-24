# Codename-OBSIDIAN_ROBOT
__***Relay chat system created on the Java platform.***__

## **Project Phases:**

| Project Phase | Current Status |
|:----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|:--------------:|
| ***Protocol Design:***  The first milestone of the project is the design of the system. The design is a step by step description of how the system fulfills the various functional requirements. For this reason,it is often called a requirements analysis. The requirements are classified as 'use cases'. Each use case contains the steps involved in fulfilling that case scenario. From the analysis we should be able to design a communication protocol – the messages involved in the various interactions of the system, and the contents of those messages. | In Progress (Iterative) |
| ***Technical Proof Of Concept (TPC):***  The second milestone of the project is called a Technical Proof Of Concept. This is a risk mitigating phase that proves that the system architecture is sound. At least one core use-case has to be implemented to demonstrate the architecture. For example,  a client announcing its presence is a core use case. This would include server functionality such as logging the event. | **Completed** |
| ***Full implementation:***  The final phase of the project is fully implementing all requirements and maintaining the project with bug fixes and future updates. | Not Started |


## **Version 1.0 Requirements:**

| Feature | Completed?(Y/N) |
|:-------------------------------------------------------------------------------------------------------------------:|:---------------:|
| Java based project. | Y |
| GUI based program (Desktop). | N |
| Server has a log file system for monitoring and debugging. | N |
| When a client sends a message, all known clients receive it. | N |
| Clients announce their presence to the server once; before they can send or receive messages | N |
| Clients can request a list of clients who are online at any point in time after they have announced their presence. | N |
| Clients send messages to the server. The server multi-casts the message to all known clients. | N |
| Clients announce their departure to the server. | N |
| If the server shuts down, it announces it's unavailability. | N |

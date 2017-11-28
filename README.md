# Codename-OBSIDIAN_ROBOT
__***Relay chat system created on the Java platform.***__

## [Download the latest version](https://github.com/Softwareological/Codename-OBSIDIAN_ROBOT/releases/latest)

## **Project Phases:**

| Project Phase | Current Status |
|:----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|:--------------:|
| ***Protocol Design:***  The first milestone of the project is the design of the system. The design is a step by step description of how the system fulfills the various functional requirements. For this reason,it is often called a requirements analysis. The requirements are classified as 'use cases'. Each use case contains the steps involved in fulfilling that case scenario. From the analysis we should be able to design a communication protocol – the messages involved in the various interactions of the system, and the contents of those messages. | In Progress (Iterative) |
| ***Technical Proof Of Concept (TPC):***  The second milestone of the project is called a Technical Proof Of Concept. This is a risk mitigating phase that proves that the system architecture is sound. At least one core use-case has to be implemented to demonstrate the architecture. For example,  a client announcing its presence is a core use case. This would include server functionality such as logging the event. | **Completed** |
| ***Full implementation:***  The final phase of the project is fully implementing all requirements and maintaining the project with bug fixes and future updates. | **Completed (Maintaining will continue)** |


## **Version 1.0 Requirements: COMPLETED**

| Feature | Completed?(Y/N) |
|:-------------------------------------------------------------------------------------------------------------------:|:---------------:|
| Java based project. | Y |
| GUI based program (Desktop). | Y |
| Server has a log file system for monitoring and debugging. | Y |
| When a client sends a message, all known clients receive it. | Y |
| Clients announce their presence to the server once; before they can send or receive messages | Y |
| Clients send messages to the server. The server multi-casts the message to all known clients. | Y |
| Clients announce their departure to the server. | Y |
| If the server shuts down, it announces it's unavailability. | Y |


## **Version 1.1 Requirements:**

| Requirements | Completed?(Y/N) |
|:------------------------------------------------------------------:|:---------------:|
| Private chat with individual users. | N |
| Password authentication. | N |
| Registration process | N |
| Administration ( banning users, viewing log file, creating rooms ) | N |
| Multiple chat-rooms | N |
| Profanity filtering | N |
| Voting polls (e.g. democratic banning of unwanted users) | N |
| Significant GUI design | N |
| Server messages are displayed to the user. | N |
| List all clients in the chat-room | N |

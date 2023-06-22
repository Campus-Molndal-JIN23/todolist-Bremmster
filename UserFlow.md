``` mermaid
flowchart TD
    A[Start] -->|Select User| B(Todo Menu)
    B -->C{User input}
    C -->|C| D[Create Todo]
    C -->|R| E[Read todo]
    C -->|U| F{Update todo}
    F --> F1[update text]
    F --> F2[mark as done]
    F --> F3[assignTo]
    C --> |D|G[Delete todo]
    C --> |L|H[List todos]
```
``` mermaid
flowchart TD
    A[Start]
    A-->B[Create user]
    A-->C[Show al users]
    A-->D[search for user]
    A-->E[update username]
```

### API Gateway

API Gateway is the single entry point for all clients. The API gateway handles requests in one of the two ways. 
Some requests are simply proxied/routed to the appropriate service. It handles other requests by fanning out to multiple services.


                                 ┌─────────────────────────────────────┐
                                 │                                     │
                                 │  Microservices                      │
                                 │                                     │
                                 │   ┌────────┐                        │
┌───────────────┐                │   │        │    ┌──────────────┐    │
│               │                │   │        ├───>│Microservice 1│    │
│ ┌──────────┐  │                │   │        │    └──────────────┘    │
│ │ Client A │  │                │   │   A    │                        │
│ │   Web    ├──┼────────────────┼──>│   P    │                        │
│ └──────────┘  │                │   │   I    │                        │
│               │                │   │        │                        │
│ ┌──────────┐  │                │   │   G    │    ┌──────────────┐    │
│ │ Client B │  │                │   │   A    ├───>│Microservice 2│    │
│ │  Mobile  ├──┼────────────────┼──>│   T    │    └──────────────┘    │
│ └──────────┘  │                │   │   E    │                        │
│               │                │   │   W    │                        │
│               │                │   │   A    │                        │
│ ┌──────────┐  │                │   │   Y    │                        │
│ │ Client X │  │                │   │        │    ┌───────────────┐   │
│ │ -------  ├──┼────────────────┼──>│        ├───>│Microservice X │   │
│ └──────────┘  │                │   │        │    └───────────────┘   │
│               │                │   └────────┘                        │
│               │                │                                     │
└───────────────┘                │                                     │
                                 │                                     │
                                 │                                     │
                                 └─────────────────────────────────────┘

https://microservices.io/patterns/apigateway.html


### Why we need Limit Service

 P: How can the API provider prevent API clients from excessive API usage? As the number
    of instance that provides the API scale up ad down based on load, it needs to perform 
    and coordinate rate limiting per instance.

    - How can the provider maintain a high performance for all clients while properly 
      economizing its resources?
    - How can a provider prevent a client from abusing the API, or minimize the impact of
      excessive and unwanted usage (fairness)?

 S: Introduce and enforce a Rate Limit to safeguard against API clients that overuse the API. 
    Read more:
    https://microservice-api-patterns.org/patterns/quality/qualityManagementAndGovernance/RateLimit.html
    https://engineering.salesforce.com/coordinated-rate-limiting-in-microservices-bb8861126beb/
    https://dzone.com/articles/rate-limiting-for-microservices

### Dependency Used

• Spring Web:
  We need spring-web dependency to create RESTful service using SpringMVC which uses Apache 
  Tomccat as the default embedded container. 

• Spring Boot DevTools: 
  Provides fast application restarts, live-reloads and configurations for enhanced 
  development experience.

• Spring Boot Actuator:
  It provides builtin (or custom) endpoints that let you monitor and manage your appication,
   such as application health, metrics, session, etc

• Spring Cloud Config:
  Client that connects to Spring Cloud Config Server to fetch the appliction configuration.

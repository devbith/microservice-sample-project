#### Sample Microservice with Spring Cloud

| Application                       |   Ports                     |
|-----------------------------------|-----------------------------|
| Limit Service                     |   8080, 8081, ...           |
| Spring Cloud Config Server        |   8888                      |
| Currency Exchange Service         |   8000, 8001, 8002, ...     |          
| Curreny Conversion Service        |   8100, 8101, 8102, ...     |            
| Neflix Eureka Naming Service      |   8761                      |              
| Netflix Zuul API Gateway          |   8765                      |            
| Zipkin Distributed Tracing Server |   9411                      |


#### To Deploy Currency Exchange And Currency Conversion Service In Kubernetes Of <a href="https://console.cloud.google.com/">Google Cloud Platform</a>
Checkout branch name <a href="https://github.com/devbith/microservice-sample-project/pull/1"> `gcp-k8s-deploy` </a>


# Dead Letter Queue - Auto Acknowledgement

## Spring Cloud Stream - RabbitMQ

This app simulates use of dead letter queue and Consumer's auto ack.

mvn spring-boot:run | tee tempauto.log

http://localhost:9090/orders/publish

{
    "orderNumber": 1003,
    "quantity": 5,
    "productName": "Study Lamp",
    "productDesc": "Lights and Lamps",
    "orderStatus": "CREATED"
}

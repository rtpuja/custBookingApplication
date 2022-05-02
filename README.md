# custBookingApplication
This projects includes Zuul, eureka and restapi service which combined into one microservices. The main task is to save booking data if booking space is available in database. 

Technologies Used: SpringBoot, Java 8, MySQL, Zuul api gateway, Eureka service discovery

Steps to be followed:
1. Import zuul projects which has three services named : Zuul, Eureka, Customer-service
2. All three projects are developed using SpringBoot.
3. Run Eureka server followed by Zuul and lastly run Customer Service Project
4. Hit the API after running these projects: http://localhost:8761/. It will show all the services configured.
5. Exposing zuul service to restrict visibility of actual service and handling incoming traffic to single gateway which runs on 8080.
6. Customer Service is running on 8090.

APIs: 
1.  http://localhost:8080/customer-service/api/bookings/available : POST Service
    It checks the available space and return true if available. The url given in assignment return 404 so it has been handled in the code.
    respoonse: {
    "available": true
    }

2. http://localhost:8080/customer-service/api/bookings/ : POST Service
   input Json: {
	"origin":"punejkk",
	"containerType": "DRY",
	"destination": "usaaustrailia",
	"containerSize": 10,
	"quantity":20
  }
Response: 
{
    "bookingRef": "6ffdf260-097a-401b-a1f2-6e0a0cf2f4d5"
}

3. in case of error, it return 500 internal error with error messages

4. in case of improper validation:
{
    "quantity": "quantity should have minimum 2 and maximum 20 characters",
    "containerType": "must be any of enum class com.maersk.sample.customer.model.ContainerEnum",
    "origin": "Origin should have minimum 2 and maximum 20 characters",
    "destination": "Destination should have minimum 2 and maximum 20 characters"
}

5.http://localhost:8080/customer-service/api/bookings/ : GET Service
[
    {
        "id": "abb82bf9-993a-4fb8-b79d-589c206e3103",
        "containerSize": 10,
        "origin": "punejkk",
        "destination": "usaaustrailia",
        "quantity": 20,
        "containerType": "DRY",
        "timeStamp": "2022-05-02T04:34:37.000+0000"
    },
    {
        "id": "b6cee0c2-2dd4-4b6f-aa92-a69d4f6c51ec",
        "containerSize": 10,
        "origin": "punejkk",
        "destination": "usaaustrailia",
        "quantity": 20,
        "containerType": "DRY",
        "timeStamp": "2022-05-02T04:34:24.000+0000"
    }
]






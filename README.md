# Covid-helping-hand-platform-using-rest-apis

## Problem Statement:
Currently due to increasing Covid-19 cases, there is a shortage of plasma donors. This platform is to help connect people in need of plasma and the donors in their vicinity.

## Techonologies used:
Backend: Spring boot REST APIs.

Frontend: ReactJs.

## Software Prerequisites:
Java 11+

NodeJS and NPM

## Steps to run the project:
```
- Clone the project with the url "https://github.com/vinita1005/Covid-helping-hand-platform-using-rest-apis.git"
  OR
  Download the code in a zip file and extract.
- Open a terminal/command prompt(windows) and navigate to the directory {proj_directory}/RestService/.

- run the command : java -jar getmeplasma-0.1.1.jar

PS: you can also start the server by double clicking on the jar, but to kill it, you have to kill the specific task on the machine.
```
This will start the server. The server will run on localhost:8000.
Keep the server running and open a new terminal/command prompt.
```
- Navigate to the directory {proj_directory}/UI/my-app/
- Run the following commands:
  - npm install
  - npm start
```
This will open a browser and the app will run on localhost:3000.

## REST APIs

This project utilizes spring boot JPA capabilities. No physical Database is created for this project. Instead the built-in h2 database by spring boot is used here.
H2 is a open source relational database. It can be configured easily and can be used in a client-server project without any major changes.

The following rest APIs have been created:

```
GET

url: http://localhost:8080/donors/getAll

url: http://localhost:8080/donors/getByCity?city=Buffalo

url: http://localhost:8080/donors/getByBloodType?bloodType=A%2B
```

```
POST
url: http://localhost:8080/donors/addDonor
Headers: {Content-Type: 'application/json'}
Body:
{
        "fullName": "Gandalf the grey",
        "city": "Buffalo",
        "state": "New York",
        "country": "USA",
        "contactNo": "2526352718",
        "fullAddress": "",
        "bloodType": "A+",
        "active": true
}
```

```
PUT
url: http://localhost:8080/donors/updateDonor
Headers: {Content-Type: 'application/json'}
Body:
{
        "id":3,
        "fullName": "Gandalf the grey",
        "city": "Buffalo",
        "state": "New York",
        "country": "USA",
        "contactNo": "2526352718",
        "fullAddress": "",
        "bloodType": "A+",
        "active": true
}
```

```
DELETE
url: http://localhost:8080/donors/deleteDonor?id={id}
```

```
Note that: If you run these commands in POSTMAN, you might face the "Invalid CORS request" error.
This error normally occurs because we are trying to run server and client both on the localhost (same host) with different port.
Pls follow these steps to resolve this issue: https://stackoverflow.com/questions/38778083/postman-resolving-invalid-cors-request-for-a-post-request

This error should not occur on the UI front as at the backend, this error is taken care of by adding the @CrossOrigin(origins = "http://localhost:3000") annotation on controller. This will enable the client on localhost:3000 to make cross origin requests without errors.
```


## Screenshots:
![image](https://user-images.githubusercontent.com/31128057/116014551-cbd86000-a603-11eb-9403-da32b89a66b7.png)
![image](https://user-images.githubusercontent.com/31128057/116014575-f1656980-a603-11eb-8ee4-ab235d164ea4.png)
![image](https://user-images.githubusercontent.com/31128057/116014586-fde9c200-a603-11eb-8ac4-2fa1d3cabcab.png)

## Working:
Homepage
![image](https://user-images.githubusercontent.com/31128057/116014613-1ce85400-a604-11eb-9a74-8e5185b03f95.png)

Register
![image](https://user-images.githubusercontent.com/31128057/116014667-56b95a80-a604-11eb-97d0-4ba87c38e388.png)

View Donors
![image](https://user-images.githubusercontent.com/31128057/116014692-87998f80-a604-11eb-8f74-42cfe4d4deb7.png)

## Future Scope:
- Athentication (Login)
- Edit Donor profile

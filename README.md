# COURIER TRACKING APP

Courier tracking app is java 11 basesapplication.

## Project Github repository
https://github.com/CLNKDNZ/courier-tracking.git

## Usage

The app deployed to heroku which is online web server. You can send web request to heroku for testing.  
**Project Base Path :** https://courier-tracking.herokuapp.com/courier-tracking/api/v1  



## **REQUEST EXAMPLES** 

**ADD NEW COURIER**
- METHOD : POST  
- HEROKU URL : https://courier-tracking.herokuapp.com/courier-tracking/api/v1/courier
- LOCAL URL : http://localhost:8080/courier-tracking/api/v1/courier
```bash
{
    "name": "deniz",
    "surname": "Celenk"
}
```



**ADD NEW STORE**
- METHOD : POST  
- HEROKU URL : https://courier-tracking.herokuapp.com/courier-tracking/api/v1/store
- LOCAL URL : http://localhost:8080/courier-tracking/api/v1/store
```bash

{
"name":"Caddebostan MMM Migros",
"lat":40.9632463,
"lon":29.0630908

}
```


**TRACKING CONTROL**
- METHOD : POST  
- HEROKU URL : https://courier-tracking.herokuapp.com/courier-tracking/api/v1/track
- LOCAL URL : http://localhost:8080/courier-tracking/api/v1track
```bash
{
    "courier": {
        "id":1,
        "name": "deniz",
        "surname": "celenk"
    },

    "requestTime": "2022-03-25T15:28:17.331738400",
    "lat": 1111,
    "lon": 2222
}
```

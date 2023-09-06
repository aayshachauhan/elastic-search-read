# elastic-search-read
Data validation and use builder method


Fetch user data report from elastic 

Post API 

url - http://localhost:40003/v2/userdata/search

ClientId is mendatory

1. Fetch through oNly Client Name (Valid)

Request :

{
    "clientId": "lM1niZR9n"
}

Response :

{
    "status": "OK",
    "code": 2000,
    "message": "Request Successful",
    "data": {
        "totalHits": 10000,
        "userInfoList": [
            {
                "userId": 387,
                "loginId": ".",
                "firstName": "dheeraj",
                "lastName": "Kanojiya",
                "mobileNo": "918108212831",
                "altMobileNo": "8108255658",
                "emailId": "dheeraj.kanojiya@anmsoft.com",
                "createdDate": "2017-03-06T17:40:25+0530",
                "userClientDomainInfo": {
                    "domainID": 1,
                    "domainName": "EZMall",
                    "clientId": 1,
                    "clientName": "lM1niZR9n",
                    "clientDescription": "ezmall_web",
                    "isActive": null,
                    "deleted": null
                }
            },
            {
                "userId": 388,
                "loginId": "julie.ansari@anmsoft.com",
                "firstName": "julie",
                "lastName": "ansri",
                "mobileNo": "9857645678",
                "altMobileNo": "9564345642",
                "emailId": "julie.ansari@anmsoft.com",
                "createdDate": "2017-03-06T17:51:31+0530",
                "userClientDomainInfo": {
                    "domainID": 1,
                    "domainName": "EZMall",
                    "clientId": 1,
                    "clientName": "lM1niZR9n",
                    "clientDescription": "ezmall_web",
                    "isActive": null,
                    "deleted": null
                }
            },
            {
                "userId": 389,
                "loginId": "jay.rawale@anmsoft.com",
                "firstName": "jay",
                "lastName": "rawale",
                "mobileNo": "7710947499",
                "altMobileNo": "9664543620",
                "emailId": "jay.rawale@anmsoft.com",
                "createdDate": "2017-03-06T18:18:36+0530",
                "userClientDomainInfo": {
                    "domainID": 1,
                    "domainName": "EZMall",
                    "clientId": 1,
                    "clientName": "lM1niZR9n",
                    "clientDescription": "ezmall_web",
                    "isActive": null,
                    "deleted": null
                }
            },
            {
                "userId": 390,
                "loginId": "NA",
                "firstName": "archana",
                "mobileNo": "8693085367",
                "altMobileNo": "9876545678",
                "emailId": "archana.khatal@anmsoft.com",
                "createdDate": "2017-03-06T19:35:38+0530",
                "userClientDomainInfo": {
                    "domainID": 1,
                    "domainName": "EZMall",
                    "clientId": 1,
                    "clientName": "lM1niZR9n",
                    "clientDescription": "ezmall_web",
                    "isActive": null,
                    "deleted": null
                }
            },
            {
                "userId": 392,
                "loginId": "La",
                "firstName": "Kanchan",
                "lastName": "TELANGADE",
                "mobileNo": "8600281414",
                "emailId": "kanchan.telangade@anmsoft.com",
                "createdDate": "2017-03-07T21:18:25+0530",
                "userClientDomainInfo": {
                    "domainID": 1,
                    "domainName": "EZMall",
                    "clientId": 1,
                    "clientName": "lM1niZR9n",
                    "clientDescription": "ezmall_web",
                    "isActive": null,
                    "deleted": null
                }
            },
            {
                "userId": 399,
                "loginId": "4",
                "firstName": "fjhfhfjhf",
                "mobileNo": "7710947499",
                "altMobileNo": "9664543616",
                "emailId": "jayrawale4545@gmail.com",
                "createdDate": "2017-03-14T16:35:08+0530",
                "userClientDomainInfo": {
                    "domainID": 1,
                    "domainName": "EZMall",
                    "clientId": 1,
                    "clientName": "lM1niZR9n",
                    "clientDescription": "ezmall_web",
                    "isActive": null,
                    "deleted": null
                }
            },
            {
                "userId": 400,
                "loginId": "akshay.hate@anmsoft.com",
                "firstName": "akshay",
                "mobileNo": "9029034577",
                "altMobileNo": "9664123840",
                "emailId": "akshay.hate@anmsoft.com",
                "createdDate": "2017-03-14T17:10:36+0530",
                "userClientDomainInfo": {
                    "domainID": 1,
                    "domainName": "EZMall",
                    "clientId": 1,
                    "clientName": "lM1niZR9n",
                    "clientDescription": "ezmall_web",
                    "isActive": null,
                    "deleted": null
                }
            },
            {
                "userId": 402,
                "loginId": "5545454521",
                "firstName": "Trupti",
                "mobileNo": "9969565656",
                "altMobileNo": "8898948938",
                "emailId": "zdsds@sds.com",
                "createdDate": "2017-03-14T18:11:00+0530",
                "userClientDomainInfo": {
                    "domainID": 1,
                    "domainName": "EZMall",
                    "clientId": 1,
                    "clientName": "lM1niZR9n",
                    "clientDescription": "ezmall_web",
                    "isActive": null,
                    "deleted": null
                }
            },
            {
                "userId": 403,
                "loginId": "amol.dabholkar@anmsoft.com",
                "firstName": "Om",
                "lastName": "Dabholkar",
                "mobileNo": "9819492953",
                "altMobileNo": "1111111111",
                "emailId": "amol.dabholkar@anmsoft.com",
                "createdDate": "2017-03-14T18:20:46+0530",
                "userClientDomainInfo": {
                    "domainID": 1,
                    "domainName": "EZMall",
                    "clientId": 1,
                    "clientName": "lM1niZR9n",
                    "clientDescription": "ezmall_web",
                    "isActive": null,
                    "deleted": null
                }
            },
            {
                "userId": 406,
                "loginId": "bhushan.sawant@anmsoft.com",
                "firstName": "Bhushan",
                "lastName": "Sawant",
                "mobileNo": "7276774950",
                "altMobileNo": "9867495938",
                "emailId": "bhushan.sawant@anmsoft.com",
                "createdDate": "2017-03-15T17:53:41+0530",
                "userClientDomainInfo": {
                    "domainID": 1,
                    "domainName": "EZMall",
                    "clientId": 1,
                    "clientName": "lM1niZR9n",
                    "clientDescription": "ezmall_web",
                    "isActive": null,
                    "deleted": null
                }
            }
        ]
    }
}

2. Fetch data through from date and to date (Valid)

Request :

{
    "clientId": "lM1niZR9n",
    "fromDate": "2023-06-25",
    "toDate": "2023-06-30"
}

Response :

{
    "status": "OK",
    "code": 2000,
    "message": "Request Successful",
    "data": {
        "totalHits": 33,
        "userInfoList": [
            {
                "userId": 3094054,
                "loginId": "shanmukswami52@gmail.com",
                "firstName": "Shanmuk",
                "lastName": "Swami",
                "emailId": "shanmukswami52@gmail.com",
                "createdDate": "2023-06-25T08:50:34+0530",
                "userClientDomainInfo": {
                    "domainID": 1,
                    "domainName": "EZMall",
                    "clientId": 1,
                    "clientName": "lM1niZR9n",
                    "clientDescription": "ezmall_web",
                    "isActive": "Y",
                    "deleted": "N"
                }
            },
            {
                "userId": 3094056,
                "loginId": "9263539933",
                "firstName": "Ashok",
                "lastName": "Datta",
                "mobileNo": "9263539933",
                "emailId": "ashok_datta68@yahoo.com",
                "createdDate": "2023-06-25T09:20:44+0530",
                "userClientDomainInfo": {
                    "domainID": 1,
                    "domainName": "EZMall",
                    "clientId": 1,
                    "clientName": "lM1niZR9n",
                    "clientDescription": "ezmall_web",
                    "isActive": "Y",
                    "deleted": "N"
                }
            },
            {
                "userId": 3094082,
                "loginId": "ankitgeete88@gmail.com",
                "firstName": "ankit",
                "lastName": "geete",
                "emailId": "ankitgeete88@gmail.com",
                "createdDate": "2023-06-25T13:18:13+0530",
                "userClientDomainInfo": {
                    "domainID": 1,
                    "domainName": "EZMall",
                    "clientId": 1,
                    "clientName": "lM1niZR9n",
                    "clientDescription": "ezmall_web",
                    "isActive": "Y",
                    "deleted": "N"
                }
            },
            {
                "userId": 3094092,
                "loginId": "pramiladewangan17@gmail.com",
                "firstName": "Bhawana",
                "lastName": "Dewangan",
                "emailId": "pramiladewangan17@gmail.com",
                "createdDate": "2023-06-25T14:03:42+0530",
                "userClientDomainInfo": {
                    "domainID": 1,
                    "domainName": "EZMall",
                    "clientId": 1,
                    "clientName": "lM1niZR9n",
                    "clientDescription": "ezmall_web",
                    "isActive": "Y",
                    "deleted": "N"
                }
            },
            {
                "userId": 3094093,
                "loginId": "bhawanad61@gmail.com",
                "firstName": "Bhaumik",
                "lastName": "Dewangan",
                "emailId": "bhawanad61@gmail.com",
                "createdDate": "2023-06-25T14:07:50+0530",
                "userClientDomainInfo": {
                    "domainID": 1,
                    "domainName": "EZMall",
                    "clientId": 1,
                    "clientName": "lM1niZR9n",
                    "clientDescription": "ezmall_web",
                    "isActive": "Y",
                    "deleted": "N"
                }
            },
            {
                "userId": 3094095,
                "loginId": "9373612954",
                "firstName": "Sanjay",
                "lastName": "Sakhare",
                "mobileNo": "9373612954",
                "emailId": "sanjaysakhare@rediffmail.com",
                "createdDate": "2023-06-25T14:15:20+0530",
                "userClientDomainInfo": {
                    "domainID": 1,
                    "domainName": "EZMall",
                    "clientId": 1,
                    "clientName": "lM1niZR9n",
                    "clientDescription": "ezmall_web",
                    "isActive": "Y",
                    "deleted": "N"
                }
            },
            {
                "userId": 3094123,
                "loginId": "nitincbhatt@gmail.com",
                "firstName": "Nitin",
                "lastName": "Bhatt",
                "emailId": "nitincbhatt@gmail.com",
                "createdDate": "2023-06-25T18:02:23+0530",
                "userClientDomainInfo": {
                    "domainID": 1,
                    "domainName": "EZMall",
                    "clientId": 1,
                    "clientName": "lM1niZR9n",
                    "clientDescription": "ezmall_web",
                    "isActive": "Y",
                    "deleted": "N"
                }
            },
            {
                "userId": 3094139,
                "loginId": "9015040030",
                "firstName": "gaurav",
                "lastName": "kathpal",
                "mobileNo": "9015040030",
                "emailId": "kathpalgaurav17@gmail.com",
                "createdDate": "2023-06-25T20:51:20+0530",
                "userClientDomainInfo": {
                    "domainID": 1,
                    "domainName": "EZMall",
                    "clientId": 1,
                    "clientName": "lM1niZR9n",
                    "clientDescription": "ezmall_web",
                    "isActive": "Y",
                    "deleted": "N"
                }
            },
            {
                "userId": 3094143,
                "loginId": "pranjels@gmail.com",
                "firstName": "Shagun",
                "lastName": "Singh",
                "emailId": "pranjels@gmail.com",
                "createdDate": "2023-06-25T21:05:40+0530",
                "userClientDomainInfo": {
                    "domainID": 1,
                    "domainName": "EZMall",
                    "clientId": 1,
                    "clientName": "lM1niZR9n",
                    "clientDescription": "ezmall_web",
                    "isActive": "Y",
                    "deleted": "N"
                }
            },
            {
                "userId": 3094181,
                "loginId": "7975246152",
                "firstName": "aaminah",
                "lastName": "siddique",
                "mobileNo": "7975246152",
                "emailId": "aaminahsiddique225@gmail.com",
                "createdDate": "2023-06-26T10:50:55+0530",
                "userClientDomainInfo": {
                    "domainID": 1,
                    "domainName": "EZMall",
                    "clientId": 1,
                    "clientName": "lM1niZR9n",
                    "clientDescription": "ezmall_web",
                    "isActive": "Y",
                    "deleted": "N"
                }
            }
        ]
    }
}

3. Fetch through only date without Client ID(invalid)

Request:

{
    "fromDate": "2023-06-25",
    "toDate": "2023-06-30"
}

Response :

{
    "status": "BAD_REQUEST",
    "code": 4033,
    "message": "Please provide clientId",
    "data": null
}

4. fetch by date but From_date is greater than To_date (invalid)

Request :

{
    "clientId": "lM1niZR9n",
    "fromDate": "2023-06-30",
    "toDate": "2023-06-29"
}

Response:

{
    "status": "BAD_REQUEST",
    "code": 4033,
    "message": "Please provide correct date",
    "data": null
}

5 fetch through client ID and To date (valid)

{
    "clientId":"lM1niZR9n",
    "toDate" :"2023-06-20"
}

Response 

{
    "status": "OK",
    "code": 2000,
    "message": "Request Successful",
    "data": {
        "totalHits": 10000,
        "userInfoList": [
            {
                "userId": 387,
                "loginId": ".",
                "firstName": "dheeraj",
                "lastName": "Kanojiya",
                "mobileNo": "918108212831",
                "altMobileNo": "8108255658",
                "emailId": "dheeraj.kanojiya@anmsoft.com",
                "createdDate": "2017-03-06T17:40:25+0530",
                "userClientDomainInfo": {
                    "domainID": 1,
                    "domainName": "EZMall",
                    "clientId": 1,
                    "clientName": "lM1niZR9n",
                    "clientDescription": "ezmall_web",
                    "isActive": null,
                    "deleted": null
                }
            },
            {
                "userId": 388,
                "loginId": "julie.ansari@anmsoft.com",
                "firstName": "julie",
                "lastName": "ansri",
                "mobileNo": "9857645678",
                "altMobileNo": "9564345642",
                "emailId": "julie.ansari@anmsoft.com",
                "createdDate": "2017-03-06T17:51:31+0530",
                "userClientDomainInfo": {
                    "domainID": 1,
                    "domainName": "EZMall",
                    "clientId": 1,
                    "clientName": "lM1niZR9n",
                    "clientDescription": "ezmall_web",
                    "isActive": null,
                    "deleted": null
                }
            },
            {
                "userId": 389,
                "loginId": "jay.rawale@anmsoft.com",
                "firstName": "jay",
                "lastName": "rawale",
                "mobileNo": "7710947499",
                "altMobileNo": "9664543620",
                "emailId": "jay.rawale@anmsoft.com",
                "createdDate": "2017-03-06T18:18:36+0530",
                "userClientDomainInfo": {
                    "domainID": 1,
                    "domainName": "EZMall",
                    "clientId": 1,
                    "clientName": "lM1niZR9n",
                    "clientDescription": "ezmall_web",
                    "isActive": null,
                    "deleted": null
                }
            },
            {
                "userId": 390,
                "loginId": "NA",
                "firstName": "archana",
                "mobileNo": "8693085367",
                "altMobileNo": "9876545678",
                "emailId": "archana.khatal@anmsoft.com",
                "createdDate": "2017-03-06T19:35:38+0530",
                "userClientDomainInfo": {
                    "domainID": 1,
                    "domainName": "EZMall",
                    "clientId": 1,
                    "clientName": "lM1niZR9n",
                    "clientDescription": "ezmall_web",
                    "isActive": null,
                    "deleted": null
                }
            },
            {
                "userId": 392,
                "loginId": "La",
                "firstName": "Kanchan",
                "lastName": "TELANGADE",
                "mobileNo": "8600281414",
                "emailId": "kanchan.telangade@anmsoft.com",
                "createdDate": "2017-03-07T21:18:25+0530",
                "userClientDomainInfo": {
                    "domainID": 1,
                    "domainName": "EZMall",
                    "clientId": 1,
                    "clientName": "lM1niZR9n",
                    "clientDescription": "ezmall_web",
                    "isActive": null,
                    "deleted": null
                }
            },
            {
                "userId": 399,
                "loginId": "4",
                "firstName": "fjhfhfjhf",
                "mobileNo": "7710947499",
                "altMobileNo": "9664543616",
                "emailId": "jayrawale4545@gmail.com",
                "createdDate": "2017-03-14T16:35:08+0530",
                "userClientDomainInfo": {
                    "domainID": 1,
                    "domainName": "EZMall",
                    "clientId": 1,
                    "clientName": "lM1niZR9n",
                    "clientDescription": "ezmall_web",
                    "isActive": null,
                    "deleted": null
                }
            },
            {
                "userId": 400,
                "loginId": "akshay.hate@anmsoft.com",
                "firstName": "akshay",
                "mobileNo": "9029034577",
                "altMobileNo": "9664123840",
                "emailId": "akshay.hate@anmsoft.com",
                "createdDate": "2017-03-14T17:10:36+0530",
                "userClientDomainInfo": {
                    "domainID": 1,
                    "domainName": "EZMall",
                    "clientId": 1,
                    "clientName": "lM1niZR9n",
                    "clientDescription": "ezmall_web",
                    "isActive": null,
                    "deleted": null
                }
            },
            {
                "userId": 402,
                "loginId": "5545454521",
                "firstName": "Trupti",
                "mobileNo": "9969565656",
                "altMobileNo": "8898948938",
                "emailId": "zdsds@sds.com",
                "createdDate": "2017-03-14T18:11:00+0530",
                "userClientDomainInfo": {
                    "domainID": 1,
                    "domainName": "EZMall",
                    "clientId": 1,
                    "clientName": "lM1niZR9n",
                    "clientDescription": "ezmall_web",
                    "isActive": null,
                    "deleted": null
                }
            },
            {
                "userId": 403,
                "loginId": "amol.dabholkar@anmsoft.com",
                "firstName": "Om",
                "lastName": "Dabholkar",
                "mobileNo": "9819492953",
                "altMobileNo": "1111111111",
                "emailId": "amol.dabholkar@anmsoft.com",
                "createdDate": "2017-03-14T18:20:46+0530",
                "userClientDomainInfo": {
                    "domainID": 1,
                    "domainName": "EZMall",
                    "clientId": 1,
                    "clientName": "lM1niZR9n",
                    "clientDescription": "ezmall_web",
                    "isActive": null,
                    "deleted": null
                }
            },
            {
                "userId": 406,
                "loginId": "bhushan.sawant@anmsoft.com",
                "firstName": "Bhushan",
                "lastName": "Sawant",
                "mobileNo": "7276774950",
                "altMobileNo": "9867495938",
                "emailId": "bhushan.sawant@anmsoft.com",
                "createdDate": "2017-03-15T17:53:41+0530",
                "userClientDomainInfo": {
                    "domainID": 1,
                    "domainName": "EZMall",
                    "clientId": 1,
                    "clientName": "lM1niZR9n",
                    "clientDescription": "ezmall_web",
                    "isActive": null,
                    "deleted": null
                }
            }
        ]
    }
}

7. fetch through client ID and from date (valid)

Request :

{
    "clientId": "lM1niZR9n",
    "fromDate": "2023-06-21"
}

Response 

{
    "status": "OK",
    "code": 2000,
    "message": "Request Successful",
    "data": {
        "totalHits": 211,
        "userInfoList": [
            {
                "userId": 3093662,
                "loginId": "anuragdwivedi6264@gmail.com",
                "firstName": "Anurag",
                "lastName": "Dwivedi",
                "emailId": "anuragdwivedi6264@gmail.com",
                "createdDate": "2023-06-21T09:46:42+0530",
                "userClientDomainInfo": {
                    "domainID": 1,
                    "domainName": "EZMall",
                    "clientId": 1,
                    "clientName": "lM1niZR9n",
                    "clientDescription": "ezmall_web",
                    "isActive": "Y",
                    "deleted": "N"
                }
            },
            {
                "userId": 3093679,
                "loginId": "9027239383",
                "firstName": "Akshya",
                "lastName": "Chauhan",
                "mobileNo": "9027239383",
                "emailId": "ishuchauhan.2004@gmail.com",
                "createdDate": "2023-06-21T13:16:34+0530",
                "userClientDomainInfo": {
                    "domainID": 1,
                    "domainName": "EZMall",
                    "clientId": 1,
                    "clientName": "lM1niZR9n",
                    "clientDescription": "ezmall_web",
                    "isActive": "Y",
                    "deleted": "N"
                }
            },
            {
                "userId": 3093711,
                "loginId": "deep93verma@gmail.com",
                "firstName": "Satender",
                "emailId": "deep93verma@gmail.com",
                "createdDate": "2023-06-21T17:32:23+0530",
                "userClientDomainInfo": {
                    "domainID": 1,
                    "domainName": "EZMall",
                    "clientId": 1,
                    "clientName": "lM1niZR9n",
                    "clientDescription": "ezmall_web",
                    "isActive": "Y",
                    "deleted": "N"
                }
            },
            {
                "userId": 3093727,
                "loginId": "corporategiftprint@gmail.com",
                "firstName": "meena",
                "lastName": "patel",
                "emailId": "corporategiftprint@gmail.com",
                "createdDate": "2023-06-21T21:05:52+0530",
                "userClientDomainInfo": {
                    "domainID": 1,
                    "domainName": "EZMall",
                    "clientId": 1,
                    "clientName": "lM1niZR9n",
                    "clientDescription": "ezmall_web",
                    "isActive": "Y",
                    "deleted": "N"
                }
            },
            {
                "userId": 3093745,
                "loginId": "8595253763",
                "firstName": "DEV",
                "lastName": "THAKUR",
                "mobileNo": "8595253763",
                "emailId": "devk46556@gmail.com",
                "createdDate": "2023-06-22T00:08:16+0530",
                "userClientDomainInfo": {
                    "domainID": 1,
                    "domainName": "EZMall",
                    "clientId": 1,
                    "clientName": "lM1niZR9n",
                    "clientDescription": "ezmall_web",
                    "isActive": "Y",
                    "deleted": "N"
                }
            },
            {
                "userId": 3093770,
                "loginId": "ravindrathakut740@gmail.com",
                "firstName": "Azad",
                "lastName": "Thakur",
                "emailId": "ravindrathakut740@gmail.com",
                "createdDate": "2023-06-22T09:46:21+0530",
                "userClientDomainInfo": {
                    "domainID": 1,
                    "domainName": "EZMall",
                    "clientId": 1,
                    "clientName": "lM1niZR9n",
                    "clientDescription": "ezmall_web",
                    "isActive": "Y",
                    "deleted": "N"
                }
            },
            {
                "userId": 3093782,
                "loginId": "jsamta494@gmail.com",
                "firstName": "Samta",
                "lastName": "Jain",
                "emailId": "jsamta494@gmail.com",
                "createdDate": "2023-06-22T11:11:25+0530",
                "userClientDomainInfo": {
                    "domainID": 1,
                    "domainName": "EZMall",
                    "clientId": 1,
                    "clientName": "lM1niZR9n",
                    "clientDescription": "ezmall_web",
                    "isActive": "Y",
                    "deleted": "N"
                }
            },
            {
                "userId": 3093786,
                "loginId": "cap.capprmr@gmail.com",
                "firstName": "chandrakant",
                "lastName": "parmar",
                "emailId": "cap.capprmr@gmail.com",
                "createdDate": "2023-06-22T11:32:26+0530",
                "userClientDomainInfo": {
                    "domainID": 1,
                    "domainName": "EZMall",
                    "clientId": 1,
                    "clientName": "lM1niZR9n",
                    "clientDescription": "ezmall_web",
                    "isActive": "Y",
                    "deleted": "N"
                }
            },
            {
                "userId": 3093793,
                "loginId": "maheshnxt777@gmail.com",
                "firstName": "Mahesh",
                "lastName": "Narayan",
                "emailId": "maheshnxt777@gmail.com",
                "createdDate": "2023-06-22T12:11:26+0530",
                "userClientDomainInfo": {
                    "domainID": 1,
                    "domainName": "EZMall",
                    "clientId": 1,
                    "clientName": "lM1niZR9n",
                    "clientDescription": "ezmall_web",
                    "isActive": "Y",
                    "deleted": "N"
                }
            },
            {
                "userId": 3093794,
                "loginId": "maheshnarayan9977@gmail.com",
                "firstName": "Mahesh",
                "lastName": "Narayan",
                "emailId": "maheshnarayan9977@gmail.com",
                "createdDate": "2023-06-22T12:12:35+0530",
                "userClientDomainInfo": {
                    "domainID": 1,
                    "domainName": "EZMall",
                    "clientId": 1,
                    "clientName": "lM1niZR9n",
                    "clientDescription": "ezmall_web",
                    "isActive": "Y",
                    "deleted": "N"
                }
            }
        ]
    }
}

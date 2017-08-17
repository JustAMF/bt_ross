# bt_ross_h1
running info analysis

1. Functions

Take in a JSON file formatted like this:

 {
 "runningId": "7c08973d-bed4-4cbd-9c28-9282a02a6032",
 "latitude": "38.9093216",
 "longitude": "-77.0036435",
 "runningDistance": "39492",
 "totalRunningTime": "2139.25",
 "heartRate": 0,
 "timestamp": "2017-04-01T18:50:35Z",
 "userInfo": {
 "username": "ross0",
 "address": "504 CS Street, Mountain View, CA 88888"
 }
 },
 {
 "runningId": "07e8db69-99f2-4fe2-b65a-52fbbdf8c32c",
 "latitude": "39.927434",
 "longitude": "-76.635816",
 "runningDistance": "1235",
 "totalRunningTime": "3011.23",
 "heartRate": 0,
 "timestamp": "2017-04-01T18:50:35Z",
 "userInfo": {
 "username": "ross1",
 "address": "504 CS Street, Mountain View, CA 88888"
 }
 }
 ...
 
 And return 
 a) all sorted by HealthWarningLevel where HealthWarningLevel is determined by heartRate (randomly generated when saving into database)
 b) any running info with High, Normal or Low HealthWarningLevel.
 c) delete any running information by running ID
 via rest API.
 
 
 2. Storage
 Saved in H2 in-memory data base (will modify to MySQL later).
 
 3. Steps:
 
 Use Http://localhost:8080/running  to upload data to DB.
 Use Http://localhost:8080/running/all   to get sorted running info (by HealthWarningLevel) from DB.
 Use Http://localhost:8080/delete/{runningid} to delete a running info by running ID.
 Use Http://localhost:8080/running/all/{healthwarninglevel} to get all running info with specific healthwarninglevel.
 Use Http://localhost:8080/purge  to delete all data.
 
 
 
 

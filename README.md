# UnityObjectDatabase
Database to store Unity GameObject

## Abstract

UnityObjectDatabase is a database used to save Unity game objects (only unity game objects are 'offcialy' supported actually, but other engine should be working too). This database isn't intended to be used directly by your players but by one of your servers.

## Core concepts

UOB is built around the concept of pushing new or changed objects to the database using a PUSH request, and use a FIND request to fetch all objects in a rectangle.
If your player is at x,y,z (0, 10, 0) and you want to find all objects in a radius of 10 around him, UOB interprets it as "find all objects between (10, 10) and (-10, -10).

GameObjects are indexed using a 2D Point, using this method, finding objects are really efficients. It also contains a `z` field for object z coordinate and a `data` field for the serialized object (see your client documentation for further informations about what is stored inside the `data` field).

## Getting started

Firstly, you need to download one the latest release of UnityObjectDatabase [here](https://github.com/JulienLavocat/UnityObjectDatabase/releases)

Once download completed, run the executable. It'll create a configuration file if it don't exist and then exit.
Edit the configuration file (see [Configuration](https://github.com/JulienLavocat/UnityObjectDatabase#Configuration)) and start again UOB.

UOB will automaticaly create tables that are required in order to work in database.

Now download the client [here](https://github.com/JulienLavocat/UnityObjectDatabase-Client) or on Assets Store and read it's documentation.

## Pushing new objects to database

Pushing new objects could be an expensive process as it is done a single-threaded way in order to avoid any kind of data-corruption and object are replaced. You shouldn't make a push request every time a new object is created or destroyed, instead keep updated objects in a list and push them every x seconds to the database (30 to 60 seconds by example).

## Write your own client

UnityObject database communicate using WebSocket and protocol is quite simple.

### Connecting and authenticating to UnityObject Database
Connecting to UOB is made using the following endpoint : `ws://<host address>:<port>/?token=<access key>`.
Connection request that does not contains token field or ones that does not match it are rejected and client is disconnected.

### Push request

Push requests are used to save new objects to the database.

### Find between request

Find between is a type of request that takes two 2D points and find all objects between them.

### Find around request

Find around is a type of request that takes a center point and a radius. It'll beinterpreted as a find between by the database.
These requests are not mandatory for a client implementation, they are for convinience.

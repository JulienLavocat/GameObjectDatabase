
# GameObjectDatabase
Database to store Unity, UnrealEngine and others GameObject

## Abstract

GameObjectDatabase (GOB) is a database used to save GameObjects from any game engine (only Unity game objects are currently supported actually, but other engine should be working too). This database isn't intended to be used directly by your players but by your servers.

## Core concepts

GOB is built around the concept of pushing new or changed objects to the database using a PUSH request, and use a FIND request to fetch all objects in a certain area.
If your player is at x, y, z (0, 10, 0) and you want to find all objects in a radius of 10 around him, GOB interprets it as "find all objects between (10, 10) and (-10, -10).

GameObjects are indexed using a 2D Point, using this method, finding objects are really efficients. It also contains a `z` field for object z coordinate and a `data` field for the serialized object (see your client documentation for further informations about what is stored inside the `data` field).

## Getting started

Firstly, you need to download the latest release of GameObjectDatabase [here](https://github.com/JulienLavocat/GameObjectDatabase/releases)

Onc done download completed, run the executable. It'll create a configuration file if it don't exist and then exit.
Edit the configuration file (see [Configuration](https://github.com/JulienLavocat/GameObjectDatabase#Configuration)) and start again GOB.

GOB will automaticaly create tables that are required in order to work in database.

Now download one of the supported clients (see [here](https://github.com/JulienLavocat/GameObjectDatabase#Clients) or on Assets Store and read it's documentation.

## Configuration

| Option | Description |
|--|--|
| ws_host | Address to listen on (WebSocket) |
| ws_port | Port to listen on (WebSocket) |
| ws_accesskey | Access key to authenticate WebSocket connections |
| db_host | Database host address |
| db_port | Database port |
| db_user | Database user |
| db_password | Database user password |

## Pushing new objects to database

Pushing new objects could be an expensive process as it is done a single-threaded way in order to avoid any kind of data-corruption and object are replaced. You shouldn't make a push request every time a new object is created or destroyed, instead keep updated objects in a list and push them every x seconds to the database (30 to 60 seconds by example).

## Write your own client

https://github.com/JulienLavocat/GameObjectDatabase/wiki/Wrtting-your-own-client

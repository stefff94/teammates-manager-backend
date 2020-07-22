# Teammates Manager Backend
[![Build Status](https://travis-ci.com/stefff94/teammates-manager-backend.svg?branch=master)](https://travis-ci.com/stefff94/teammates-manager-backend)
[![Coverage Status](https://coveralls.io/repos/github/stefff94/teammates-manager-backend/badge.svg?branch=master)](https://coveralls.io/github/stefff94/teammates-manager-backend?branch=master)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=it.polste.attsw%3Ateammates-manager-backend&metric=alert_status)](https://sonarcloud.io/dashboard?id=it.polste.attsw%3Ateammates-manager-backend)

## Run all the tests
###### Note: you need a running Docker installation on your machine.
```
./mvnw clean verify -Pjacoco && ./mvnw verify -Pe2e-tests
``` 
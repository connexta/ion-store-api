## ion-store-api is now ARCHIVED

# Store API
[![Dependabot Status](https://api.dependabot.com/badges/status?host=github&repo=connexta/ion-store-api)](https://dependabot.com)
[![Known Vulnerabilities](https://snyk.io/test/github/connexta/ion-store-api/badge.svg)](https://snyk.io/test/github/connexta/ion-store-api)
[![CircleCI](https://circleci.com/gh/connexta/ion-store-api/tree/master.svg?style=svg)](https://circleci.com/gh/connexta/ion-store-api/tree/master)

## Prerequisites
* Java 11

## Building
```bash
mvn clean install
```

## License Validation
The license headers are checked when you perform `mvn clean install`,
but if you want to do a standalone check:
```bash
mvn license:check
```
and to apply the header in `license-header.txt`:
```bash
mvn license:format
```

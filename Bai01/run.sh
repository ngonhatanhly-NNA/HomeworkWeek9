#!bin/bash

set-e
echo"""Prepare running tests..."
mvn clean
mvn compile
mvn test
echo"""Running tests successfully!"""
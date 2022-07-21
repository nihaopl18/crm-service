#!/bin/bash
SERVICE_NAME=yusp-app-single
SERVICE_VERSION=V1.0.0.RELEASE
unzip -o $HOME/app/SERVICE_NAME-SERVICE_VERSION.zip -d $HOME/app/$SERVICE_NAME
cd $HOME/app/$SERVICE_NAME/scripts
./shutdown.sh
./startup.sh


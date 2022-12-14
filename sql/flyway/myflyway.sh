#!/bin/bash

[ $# -le 2 ] || exit

OPTIONS=( "migrate" "clean" "info" "validate" "undo" "baseline" "repair" )
ENVIRONMENTS=("dev" "prod")

OPTION_ENV=dev
OPTION_FLYWAY=info
RUN=0

options_env() {
  echo "Options: [ ${ENVIRONMENTS[*]} ]"
}

if [ -z "$2" ]; then
  echo "No argument supplied. Default environment: dev"
  options_env
else
  for i in "${ENVIRONMENTS[@]}"; do
    if [ "$i" == "$2" ] ; then
      OPTION_ENV=$2
    fi
  done
fi

options() {
  echo "Options: [ ${OPTIONS[*]} ]"
}

if [ -z "$1" ]; then
  echo "No argument supplied. Default: info"
  options
  RUN=1
else
  for i in "${OPTIONS[@]}"; do
    if [ "$i" == "$1" ] ; then

      OPTION_FLYWAY=$1
      RUN=1
    fi
  done
fi

echo "validando variables"
echo "user: ${USER_DB}"
echo "pass: ${PASSWORD_DB}"

export FLYWAY_URL="jdbc:postgresql://34.170.151.67:5432/escuela"
export FLYWAY_USER="${USER_DB}"
export FLYWAY_PASSWORD="${PASSWORD_DB}"
export FLYWAY_DRIVER=org.postgresql.Driver
export FLYWAY_CONNECT_RETRIES=3
export FLYWAY_SCHEMAS=${SCHEMA_DB}
#export FLYWAY_TABLE=${TABLE_DB}

#export FLYWAY_CONFIG_FILES=./conf/$OPTION_ENV.conf
export FLYWAY_LOCATIONS=filesystem:./sql/$OPTION_ENV

if [ $RUN == 1 ]; then
  echo "Exec: $OPTION_FLYWAY"
  #exec flyway -configFiles="$FLYWAY_CONFIG_FILES" -locations="$FLYWAY_LOCATIONS" $OPTION_FLYWAY
  exec flyway $OPTION_FLYWAY
else
  echo "Not found command: $1"
  options
  exit
fi




#

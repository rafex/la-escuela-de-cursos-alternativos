#! /bin/bash

NAME_IMAGE=$1
PROJECT_ID_GCP=$2
TAG_IMAGE=$(date +%s)
NAME_AND_TAG_IMAGE=$NAME_IMAGE:$TAG_IMAGE

echo "Docker Auth"
cat gcp_service.json | docker login -u _json_key --password-stdin https://gcr.io
echo "Docker Build"
cd ../alternative-courses > /dev/null
ls -la
docker build . -t $NAME_AND_TAG_IMAGE && docker images
echo "Docker Tag"
docker tag $NAME_AND_TAG_IMAGE gcr.io/${PROJECT_ID_GCP}/$NAME_IMAGE
echo "Docker Push"
docker push gcr.io/${PROJECT_ID_GCP}/$NAME_IMAGE
#! /bin/bash

NAME_IMAGE=$1
PROJECT_ID_GCP=$2
JSON_GCP=$3
TAG_IMAGE=$(date +%s)
NAME_AND_TAG_IMAGE=$NAME_IMAGE:$TAG_IMAGE

echo "Creando JSON GCP"
echo $JSON_GCP | base64 -d > gcp_service.json

ls -la

cat gcp_service.json

echo "Docker Auth"
cat gcp_service.json | docker login -u _json_key --password-stdin https://gcr.io
echo "Docker Build"
#cd alternative-courses
ls -la
docker build . -t $NAME_AND_TAG_IMAGE -f docker/Dockerfile
docker images
echo "Docker Tag"
docker tag $NAME_AND_TAG_IMAGE gcr.io/${PROJECT_ID_GCP}/$NAME_AND_TAG_IMAGE
echo "Docker Push"
docker push gcr.io/${PROJECT_ID_GCP}/$NAME_AND_TAG_IMAGE

echo "Deploy GKE"
kubectl set image deployment nginx-1 tutum-demo-1-1=gcr.io/${PROJECT_ID_GCP}/$NAME_AND_TAG_IMAGE
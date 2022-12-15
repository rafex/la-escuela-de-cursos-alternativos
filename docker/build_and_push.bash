#! /bin/bash

NAME_IMAGE=$1
NAME_IMAGE_2=$2
NAME_IMAGE_3=$3
PROJECT_ID_GCP=$4
JSON_GCP=$5
TAG_IMAGE=$(date +%s)
VERSION=$(git rev-parse --short HEAD)

NAME_AND_TAG_IMAGE=$NAME_IMAGE:$TAG_IMAGE
NAME_AND_TAG_IMAGE_2=$NAME_IMAGE_2:$TAG_IMAGE
NAME_AND_TAG_IMAGE_3=$NAME_IMAGE_3:$TAG_IMAGE

echo $VERSION

echo "Creando JSON GCP"
echo $JSON_GCP | base64 -d > gcp_service.json

ls -la

cat gcp_service.json

echo "Docker Auth"
cat gcp_service.json | docker login -u _json_key --password-stdin https://gcr.io
echo "Docker Build Webapp"
#cd alternative-courses
ls -la
docker build . -t $NAME_AND_TAG_IMAGE -f docker/Dockerfile.webapp
docker images
echo "Docker Tag"
docker tag $NAME_AND_TAG_IMAGE gcr.io/${PROJECT_ID_GCP}/$NAME_AND_TAG_IMAGE
echo "Docker Push"
docker push gcr.io/${PROJECT_ID_GCP}/$NAME_AND_TAG_IMAGE

echo "Deploy Webapp"
kubectl set image deployment tutum-demo-1 tutum-demo-1-sha256-1=gcr.io/${PROJECT_ID_GCP}/$NAME_AND_TAG_IMAGE

echo "Docker Swagger"
#cd alternative-courses
ls -la
docker build . -t $NAME_AND_TAG_IMAGE_3 -f docker/Dockerfile.webservices
docker images
echo "Docker Tag"
docker tag $NAME_AND_TAG_IMAGE_3 gcr.io/${PROJECT_ID_GCP}/$NAME_AND_TAG_IMAGE_3
echo "Docker Push"
docker push gcr.io/${PROJECT_ID_GCP}/$NAME_AND_TAG_IMAGE_3

echo "Deploy Swagger"
kubectl set image deployment swagger-1 tutum-demo-1-sha256-1=gcr.io/${PROJECT_ID_GCP}/$NAME_AND_TAG_IMAGE_3

echo "Docker Build Webservices"
#cd alternative-courses
ls -la
docker build . -t $NAME_AND_TAG_IMAGE_2 -f docker/Dockerfile.webservices
docker images
echo "Docker Tag"
docker tag $NAME_AND_TAG_IMAGE_2 gcr.io/${PROJECT_ID_GCP}/$NAME_AND_TAG_IMAGE_2
echo "Docker Push"
docker push gcr.io/${PROJECT_ID_GCP}/$NAME_AND_TAG_IMAGE_2

echo "Deploy Webservices"
kubectl set image deployment tutum-demo-rest-1 tutum-demo-1-sha256-1=gcr.io/${PROJECT_ID_GCP}/$NAME_AND_TAG_IMAGE_2




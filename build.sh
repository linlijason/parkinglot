#!/usr/bin/env sh

./gradlew build

DOCKER_REGISTRY=076880417388.dkr.ecr.cn-northwest-1.amazonaws.com.cn
SERVICE_NAME=avengers-parking-service
VERSION=1.0.$BUILD_NUMBER
DOCKER_IMAGE=$DOCKER_REGISTRY/$SERVICE_NAME:$VERSION

sudo $(aws ecr get-login --no-include-email --region cn-northwest-1)

sudo docker build -t avengers-parking-service .
sudo docker tag avengers-parking-service:latest $DOCKER_REGISTRY/$SERVICE_NAME:latest
sudo docker tag avengers-parking-service:latest $DOCKER_IMAGE
sudo docker push $DOCKER_REGISTRY/$SERVICE_NAME:latest
sudo docker push $DOCKER_IMAGE

sed "s#DOCKER_IMAGE#$DOCKER_IMAGE#g" k8s-deployment.yml | kubectl --kubeconfig $KUBE_CONFIG apply -f -

#!/bin/bash
docker build -t huomai-app:1.0.0 .
#0=""
#1=""
#word="1"
echo "$word"
word=`docker ps -a -q --no-trunc --filter name=^/"$1"$`
echo "$word"
if [ -z "$word" ];
then
    echo "当前不存在该容器，直接进行启动该操作-------------------------------------"
        echo "$1"
        echo "$2"
        docker run --hostname huomai-app --add-host huomai-app:127.0.0.1 --restart=always -itd --name "$1" -e PARAMS="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=18081 -Dspring.profiles.active=$3 -Dserver.port=8081" -v /home/"$1"-"$3"-logs:$HOME/logs/"$1" --net=host "$2" /bin/bash
elif [ -n "$word" ];
then
    echo "当前已存在容器，停止并移除该容器-------------------------------------"
        docker stop "$1"
        docker rm "$1"
        docker run --hostname huomai-app --add-host huomai-app:127.0.0.1 --restart=always -itd --name "$1" -e PARAMS="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=18081 -Dspring.profiles.active=$3 -Dserver.port=8081" -v /home/"$1"-"$3"-logs:$HOME/logs/"$1" --net=host "$2" /bin/bash
elif [ "$word" == "1" ];
then
    echo "查询的信息有误，执行默认操作-------------------------------------"
fi

echo "finish--------------------------------------------------"

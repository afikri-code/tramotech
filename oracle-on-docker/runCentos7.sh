####
## created by: Ahmed Fikri
####
docker run -itd --name centos7 --privileged  --rm \
-p 1521:1521 -p 5500:5500 -p 2484:2484 \
--ulimit nofile=1024:65536 --ulimit nproc=2047:16384 --ulimit stack=10485760:33554432 --ulimit memlock=3221225472 \
-v /home/kirux/docker/data/oracle/12c:/home/oracle \
centos7

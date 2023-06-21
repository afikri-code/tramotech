FROM centos:centos7
MAINTAINER Ahmed Fikri <gherrami@gmail.com>

RUN yum install -y bc    
RUN yum install -y binutils
RUN yum install -y make
RUN yum install -y unzip.x86_64
RUN yum install -y glibc-devel
RUN yum install -y compat-libcap1
RUN yum install -y compat-libstdc++-33
RUN yum install -y elfutils-libelf
RUN yum install -y elfutils-libelf-devel
RUN yum install -y fontconfig-devel
RUN yum install -y glibc
RUN yum install -y ksh
RUN yum install -y libaio
RUN yum install -y libaio-devel
RUN yum install -y libXrender
RUN yum install -y libXrender-devel
RUN yum install -y libX11
RUN yum install -y libXau
RUN yum install -y libXi
RUN yum install -y libXtst
RUN yum install -y libgcc
RUN yum install -y libstdc++
RUN yum install -y libstdc++-devel
RUN yum install -y librdmacm-devel
RUN yum install -y libxcb
RUN yum install -y net-tools 
RUN yum install -y nfs-utils 
RUN yum install -y python 
RUN yum install -y python-configshell 
RUN yum install -y python-rtslib 
RUN yum install -y python-six 
RUN yum install -y targetcli 
RUN yum install -y smartmontools
RUN yum install -y sysstat
RUN yum install -y unixODBC
RUN yum install -y vim
RUN yum install -y which openssh-clients openssh-server
RUN yum install -y gcc-c++

RUN groupadd -g 1000 oinstall
RUN groupadd -g 1010 dba
RUN groupadd -g 1011 oper
RUN useradd -u 1000 -g oinstall -G dba,oper oracle

ENTRYPOINT ["/bin/bash"]

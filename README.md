# AREP-T04-APP-DOCKER
### Presentado por:

Jeisson G. Sanchez R.

### Docker repository

[ver](https://hub.docker.com/r/jsanchez0/app-server-note)

### Build

~~~
    docker build --tag jaysanchez0/app-server-note .
~~~

### Docker pull

~~~
    docker pull jsanchez0/app-server-note
~~~

### Run in docker
~~~
    docker run -dp 90:90 -e PORT=90 jsanchez0/app-server-note
~~~

Cambia el puerto como variable de entorno al 90 y transfiere el trafico del puerto 90 del contenedor al 90 de la maquina virtual.
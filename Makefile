COMPOSE=docker-compose -f ./docker/docker-compose.yml
COMPOSE_DEV=docker-compose -f ./docker/docker-compose-debug.yml

up:
	${COMPOSE} up --build -d
stop:
	${COMPOSE} stop

up_dev:
	${COMPOSE_DEV} up --build -d

stop_dev:
	${COMPOSE_DEV} stop

rebuild:
	${COMPOSE} build $(ARGS)

server:
	${COMPOSE} exec app-server bash

front:
	${COMPOSE} exec app-client su

mysql:
	${COMPOSE} exec db su

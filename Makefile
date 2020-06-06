COMPOSE=docker-compose -p birzha_app -f ./docker/docker-compose.yml

up:
	${COMPOSE} up --build -d
stop:
	${COMPOSE} stop

rebuild:
	${COMPOSE} build $(ARGS)

server:
	${COMPOSE} exec app-server bash

front:
	${COMPOSE} exec app-client su

mysql:
	${COMPOSE} exec db su

# Install :


## PostGre config :

- username: postgre
- password: root
- port: 5432
- dbName: springboot

## Backend config:

application.properties:

```
spring.jpa.hibernate.ddl-auto=create
```

Permet de relancer la création de la database a chaque lancement du front

## Front config:

Lancer le front:

```
npm install
npm run dev
```